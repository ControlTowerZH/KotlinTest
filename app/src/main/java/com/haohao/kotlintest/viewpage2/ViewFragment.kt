package com.haohao.kotlintest.viewpage2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch

import com.haohao.kotlintest.R
import kotlinx.android.synthetic.main.fragment_view.*

/**
 * 填充viewPage2 的内容
 */
class ViewFragment : Fragment() {
    //var 可变  val 不可变
    companion object {
        fun newInstance(type: Int): ViewFragment {
            val fragment = ViewFragment()
            val bundle = Bundle()
            bundle.putInt("type", type)
            fragment.arguments = bundle
            return fragment
        }
    }

    var mType: Int? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mType = arguments!!.getInt("type")
        val animUrl :String = when(mType){
            0 -> "https://assets10.lottiefiles.com/packages/lf20_E3zV8N.json"
            1 -> "https://assets4.lottiefiles.com/packages/lf20_Skcpso.json"
            2 -> "https://assets4.lottiefiles.com/packages/lf20_TLs6bJ.json"
            3 -> "https://assets4.lottiefiles.com/packages/lf20_7nsIIO.json"
            4 -> "https://assets4.lottiefiles.com/packages/lf20_kgmaoC.json"
            else -> {
                "https://assets4.lottiefiles.com/packages/lf20_DEcXxG.json";
            }
        }
        lottie.setAnimationFromUrl(animUrl)
    }

}
