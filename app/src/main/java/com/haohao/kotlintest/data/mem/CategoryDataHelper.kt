package com.haohao.kotlintest.data.mem

import android.content.Context
import android.util.SparseArray

/**
 * Description :
 *
 * @author Hao Zhao
 * @date 2020/2/9
 */
class CategoryDataHelper constructor(context: Context){

    companion object{
        private var sInstance: CategoryDataHelper? = null
        private val DEFAULT_CODE_POSITION = 0

        fun init(context: Context) {
            if (sInstance == null) {
                sInstance = CategoryDataHelper(context)
            }
        }

        fun getInstance(): CategoryDataHelper {
            if (sInstance == null) {
                throw NullPointerException("CategoryDataHelper is not initialized yet")
            }
            return sInstance as CategoryDataHelper//???
        }
    }

    var codes: IntArray ?=null
    var names: Array<String>?=null
    private var mMap: SparseArray<String> ?= null
   // private var mCnMap: SparseArray<String>?=null

    init {
        val resources = context.resources

//        codes = resources.getIntArray(R.array.category_code)
//        names = resources.getStringArray(R.array.category_name)
        mMap = SparseArray()
       // mCnMap = SparseArray()
       // val cnnames = resources.getStringArray(R.array.category_images)//category_cn_name

        var i = 0
//        while (i < codes.size) {
//            mMap.put(codes[i], names[i])
//            //mCnMap.put(codes[i], cnnames[i])
//            i += 1
//
//        }
    }
}