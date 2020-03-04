package com.haohao.kotlintest.study

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
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
import kotlinx.android.synthetic.main.activity_study.*
import timber.log.Timber

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
            intent.putExtra("sound", headline.sound)
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
    private var mPlayer: IJKPlayer? = null
    private var waiting: HeadlineCustomDialog? = null
    private var mContext:Context?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study)

        mPlayer = IJKPlayer()
        mPresenter= AudioStudyPresenter()
        mPresenter!!.attachView(this)

        waiting= HeadlineCustomDialog(this)
        mContext=this
        subtitle.setOnSelectListener(mSubtitleSelectListener)

        initData()
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
        ToastUtils.showShort(mContext!!,message)
    }

    override fun setWaitingDialog(visible: Boolean) {
        if (visible) {
            waiting!!.show()
        } else {
            waiting!!.dismiss()
        }
    }

    override fun onDetailsLoaded(details: MutableList<HeadlineDetail>) {
        val mode = if (subtitle.getShowCHN()) ChForeignSubtitle.ShowMode.DOUBLE_FOREIGN_ABOVE else ChForeignSubtitle.ShowMode.FOREIGN_ONLY
        val subtitles = Util.transform(details, mode)
        subtitle.setSubtitles(subtitles)
        subtitle.refreshContentViews()
        if (HeadlineType.SONG.equals(type)) {
            subtitle.setShowCHN(false)
        }
    }

    override fun onAddCreditFinish(creditChange: Int, totalCredit: Int) {
    }

    override fun setLikeCount(count: String) {
    }

    override fun showMessage(resId: Int) {
    }

}
