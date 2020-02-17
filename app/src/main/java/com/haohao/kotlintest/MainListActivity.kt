package com.haohao.kotlintest

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.haohao.kotlintest.CommonConstant.*
import com.haohao.kotlintest.help.ExtraDataHelper
import com.haohao.kotlintest.help.InfoHelper
import com.haohao.kotlintest.util.HeadlineType
import kotlinx.android.synthetic.main.activity_main_list.*
import kotlinx.android.synthetic.main.headline_partial_drop_down_expanded.view.*
import kotlinx.android.synthetic.main.partial_drop_down_header.*
import kotlinx.android.synthetic.main.partial_drop_down_header.view.*
import java.util.*

class MainListActivity : AppCompatActivity() {

    //var 可变  val 不可变
    private var mDropDownAdapter:DropDownAdapter? = null
    private var typeStr: String? = null
    private var typeRequest: String? = null
    private var pageCount: Int = 0
    private var pageCountForAll: Int = 0
    private var pageCountForSingle: Int = 0
    private var mExtraFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list)
    }


    private fun setFragment(isFirst: Boolean) {
        //个人中心写入类型
        //PersonalManager.getInstance().categoryType = AccountManager.getInstance().getHeadlineType()
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        val fragment = fm.findFragmentByTag("ExtraDataHelper")
        if (isFirst) {
            if (fragment != null) transaction.remove(fragment)//hide
            mExtraFragment = ExtraDataHelper.buildExtraFragment(mCategoryDataHelper.names, mCategoryDataHelper.codes)
            transaction.add(R.id.frame_container, mExtraFragment, "ExtraDataHelper")
            transaction.show(mExtraFragment)
            transaction.commit()
        }
    }

    private fun setUpDropDown(isShow: Boolean) {
        val collapsedView = LayoutInflater.from(baseContext).inflate(
                R.layout.partial_drop_down_header, null, false)
        val expandedView = LayoutInflater.from(baseContext).inflate(
               R.layout.headline_partial_drop_down_expanded, null, false)


        ll_center.isSoundEffectsEnabled = false

        //image_search.setOnClickListener(searchListener)//搜索点击
        var mDropDownRecyclerView = expandedView.recycler
        mDropDownRecyclerView.setLayoutManager(LinearLayoutManager(baseContext))

        mDropDownAdapter = DropDownAdapter()
        mDropDownAdapter?.setDelegate(mViewActions)

        //collapsedView.tv_category_name.setText(InfoHelper.getInstance().getCategoryName(baseContext))
        collapsedView.tv_category_name.setText("VOA VOA")
        val category:String = InfoHelper.getInstance().getCategory().toString()
        if (category != CATEGORY_VOA_SPECIAL) {
            setFirstPosition(category)
        }
        if (isShow) {
            mDropDownRecyclerView.setAdapter(mDropDownAdapter)
            val types = ArrayList<String>()
            types.add(HeadlineType.VOA)
            types.add(HeadlineType.CSVOA)
            types.add(HeadlineType.VOAVIDEO)
            types.add(HeadlineType.MEIYU)
            types.add(HeadlineType.BBC)
            types.add(HeadlineType.NEWS)
            types.add(HeadlineType.TED)
            types.add(HeadlineType.TOPVIDEOS)
            types.add(HeadlineType.BBCWORDVIDEO)
            mDropDownAdapter?.setData(types)

            drop_down_view.setExpandedView(expandedView)//expandedView
            // mDropDownView.setDropDownListener(mDropDownListener);
        }
        drop_down_view.setHeaderView(collapsedView)
    }

    private val mViewActions = object : DropDownAdapter.OnItemClickListener {
        override fun collapseDropDown() {
            drop_down_view.collapseDropDown()
        }

        override fun onTypeSelected(type: String) {
            val infoHelper = InfoHelper.getInstance()
            //如果切换了就一顿操作
            //String category = TypeUtils.headlineTypeToSpInfoType(type);
            val category = "voa_special"//TypeUtil.INSTANCE.headlineTypeToSpInfoType(type)
            infoHelper.putCategory(category)

            val categoryName = getString(R.string.headline_type_voa)//infoHelper.getCategoryName(getContext())
            tv_category_name.text=categoryName

            //mCategory = category
            //EventBus.getDefault().post(ChangeCategoryEvent(categoryName))

            //val menuObjects = buildCategoryMenuObjects()
            //mCategoryDataHelper.names = resources.getStringArray(R.array.category_name_voa)
            //mCategoryDataHelper.codes = resources.getIntArray(R.array.category_code_voa)

            setFragment(false)
        }
    }

    private fun setFirstPosition(type: String) {
        var choosePosition = 0
        when (type) {
            CATEGORY_VOA_STANDARD -> choosePosition = 1
            CATEGORY_VOA_VIDEO -> choosePosition = 2
            CATEGORY_HOW_TO_SAY -> choosePosition = 3
            CATEGORY_BRITISH_ENGLISH -> choosePosition = 4
            CATEGORY_ENGLISH_HEADLINE -> choosePosition = 5
            CATEGORY_TED_SPEECH -> choosePosition = 6
            CATEGORY_TOPIC_VIDEO -> choosePosition = 7
            CATEGORY_BBC_VIDEO -> choosePosition = 8
        }
        mDropDownAdapter?.mCurrentSelectedPosition = choosePosition
    }

}
