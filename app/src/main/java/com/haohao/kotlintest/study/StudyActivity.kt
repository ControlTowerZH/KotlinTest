package com.haohao.kotlintest.study

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.haohao.kotlintest.R
import com.haohao.kotlintest.data.model.Headline
import com.haohao.kotlintest.data.model.HeadlineDetail
import com.haohao.kotlintest.util.HeadlineType
import com.haohao.kotlintest.util.ToastUtils
import com.haohao.kotlintest.util.Util
import com.haohao.kotlintest.view.ChForeignSubtitle
import com.haohao.kotlintest.view.SubtitleView
import com.haohao.kotlintest.widget.dialog.HeadlineCustomDialog
import com.iyuba.play.IJKPlayer
import com.iyuba.play.OnStateChangeListener
import com.iyuba.play.State
import kotlinx.android.synthetic.main.activity_study.*
import timber.log.Timber
import tv.danmaku.ijk.media.player.IMediaPlayer

class StudyActivity : AppCompatActivity(),AudioStudyMvpView {

    companion object {
        fun getIntent2Me(context: Context, headline: Headline): Intent {
            val intent = Intent(context, StudyActivity::class.java)
            intent.putExtra("categoryName", headline.categoryName)
            intent.putExtra("title", headline.title)
            intent.putExtra("title_cn", headline.titleCn)
            intent.putExtra("imageUrl", headline.pic1)
            intent.putExtra("type", headline.type)
            intent.putExtra("id", headline.id)
            intent.putExtra("sound", headline.getSoundPath())
            return intent
        }
    }

     var categoryName: String? = null
     var title: String? = null
     var titleCn: String? = null
     var imageUrl: String? = null
     var type: String? = null
     var id: String? = null
     var sound: String? = null

    private var mPresenter: AudioStudyPresenter? = null
    private lateinit var mPlayer: IJKPlayer
    private var waiting: HeadlineCustomDialog? = null
    private lateinit var mContext:Context
    private lateinit var mProgressMover: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study)

        mPlayer = IJKPlayer()
        mPresenter= AudioStudyPresenter()
        mPresenter!!.attachView(this)
        setSupportActionBar(toolbar)
        waiting= HeadlineCustomDialog(this)
        mContext=this
        subtitle.setOnSelectListener(mSubtitleSelectListener)

        initData()
        initListener()

        mPlayer.initialize(sound)
        mPlayer.setOnStateChangeListener(mStateChangeListener)
        mPlayer.setOnBufferingUpdateListener(mBufferUpdateListener)
        mPlayer.prepareAndPlay()

        seekbar_headlines_player.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        mProgressMover = Handler(Handler.Callback {
            val progress = mPlayer.currentPosition
            seekbar_headlines_player.progress=(progress)
            tv_current_time.text=(formatTime(progress / 1000))
            subtitle.syncProgress(progress.toLong())
            mProgressMover.sendEmptyMessageDelayed(0, 500)
            true
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        mPlayer.stopAndRelease()
    }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         //return super.onOptionsItemSelected(item)
         when(item.itemId){
             android.R.id.home-> finish()//这是toolbar 的返回键！！！
             else -> showMessage("else")
         }
         return true
     }
     private fun initListener() {
         nav_right_button.setOnClickListener {
             showMessage("老刁别点！")
         }
         media_play.setOnClickListener {
             mPlayer.toggle()
         }
         next_button.setOnClickListener {
             val newPara: Int = subtitle.currParagraph + 1
             if (newPara >= 0 && newPara < subtitle.subtitleCount) {
                 val progress = subtitle.getSubtitle(newPara)!!.startTime.toInt()
                 mPlayer.seekTo(progress)
             }
         }
         former_button.setOnClickListener {
             val newPara: Int = subtitle.currParagraph - 1
             if (newPara >= 0 && newPara < subtitle.subtitleCount) {
                 val progress = subtitle.getSubtitle(newPara)!!.startTime.toInt()
                 mPlayer.seekTo(progress)
             }
         }
         iv_more_function.setOnClickListener {
             showError("toast")
         }
     }

    private fun initData() {
        categoryName = intent.getStringExtra("categoryName")
        title = intent.getStringExtra("title")
        titleCn = intent.getStringExtra("title_cn")
        imageUrl = intent.getStringExtra("imageUrl")
        type = intent.getStringExtra("type")
        id = intent.getStringExtra("id")
        sound = intent.getStringExtra("sound")

        center_title.text = title
        val userId = 6565369
        mPresenter!!.getHeadlineDetail(userId,"200", type!!, id!!)
    }


    private val mBufferUpdateListener = IMediaPlayer.OnBufferingUpdateListener { mp, percent ->
        seekbar_headlines_player.secondaryProgress=(percent * seekbar_headlines_player.max / 100)
    }

    private val mStateChangeListener = OnStateChangeListener { newState ->
        when (newState) {
            State.IDLE -> {
                seekbar_headlines_player.max = 0
                seekbar_headlines_player.progress = 0
                seekbar_headlines_player.secondaryProgress = 0
                tv_total_time.text = "00:00"
                tv_current_time.text = "00:00"
            }
            State.PREPARING -> {
            }
            State.PREPARED -> {
                val duration = mPlayer.duration
                seekbar_headlines_player.max = duration
                tv_total_time.setText(formatTime(duration / 1000))
            }
            State.PLAYING -> {
                mProgressMover.sendEmptyMessage(0)
                media_play.setImageResource(R.drawable.headline_audio_pause)
            }
            State.PAUSED -> {
                mProgressMover.removeMessages(0)
                media_play.setImageResource(R.drawable.headline_audio_play)
            }
            State.COMPLETED -> {
                mProgressMover.removeMessages(0)
                media_play.setImageResource(R.drawable.headline_audio_play)
                //playNextAudio()
            }
            State.ERROR -> {
                mProgressMover.removeMessages(0)
                showError("播放时出现错误!")
            }
        }
    }

//    private val mProgressMover = Handler(Handler.Callback {
//        val progress = mPlayer.currentPosition
//        seekbar_headlines_player.setProgress(progress)
//        tv_current_time.setText(formatTime(progress / 1000))
//        subtitle.syncProgress(progress.toLong())
//        mProgressMover.sendEmptyMessageDelayed(0, 500)
//        true
//    })

    private val mSubtitleSelectListener = SubtitleView.OnSelectListener { selectText ->
        var selectText = selectText
        Timber.d("Selected text: %s", selectText)
        //mWordCard.setVisibility(View.GONE)
        if (selectText.matches("^[a-zA-Z'-]*.".toRegex())) {
            //mWordCard.setVisibility(View.VISIBLE)
            val mShowAction = TranslateAnimation(Animation.RELATIVE_TO_SELF, -1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f)
            mShowAction.duration = 500
            //mWordCard.startAnimation(mShowAction)
            //若为句子的最后一个单词，去掉最后的"."号
            if (selectText.endsWith(".")) {
                selectText = selectText.substring(0, selectText.length - 1)
            }
            //mWordCard.searchWord(selectText)
        } else {
            showMessage("请取英文单词")
        }
    }

    override fun showMessage(message: String) {
        ToastUtils.showShort(mContext,message)
    }

    override fun setWaitingDialog(visible: Boolean) {
        if (visible) {
            waiting!!.show()
        } else {
            waiting!!.dismiss()
        }
    }

    override fun onDetailsLoaded(details: MutableList<HeadlineDetail>) {
        val mode = if (subtitle.showCHN) ChForeignSubtitle.ShowMode.DOUBLE_FOREIGN_ABOVE else ChForeignSubtitle.ShowMode.FOREIGN_ONLY
        val subtitles = Util.transform(details, mode)
        subtitle.subtitles=(subtitles)
        subtitle.refreshContentViews()
        if (HeadlineType.SONG == type) {
            subtitle.showCHN=(false)
        }
    }

    override fun onAddCreditFinish(creditChange: Int, totalCredit: Int) {
    }

    override fun setLikeCount(count: String) {
    }

    override fun showMessage(resId: Int) {
        ToastUtils.showShort(mContext,resId)
    }

    private fun formatTime(time: Int): String {
        val second = time % 60
        val minute = time / 60
        return String.format("%02d:%02d", minute, second)
    }

    private fun showError(message: String) {
        AlertDialog.Builder(mContext)
                .setTitle("Error")
                .setMessage(message)
                .setNegativeButton("取消",null)
                .setPositiveButton("确定") { dialog, _ -> dialog.dismiss() }
                //.setOnDismissListener { finish() }
                .create()
                .show()
    }

}
