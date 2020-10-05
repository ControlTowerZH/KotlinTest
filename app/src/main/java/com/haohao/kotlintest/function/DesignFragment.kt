package com.haohao.kotlintest.function

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.haohao.kotlintest.R
import com.haohao.kotlintest.util.ToastUtils
import com.haohao.kotlintest.util.ToastUtils.showShort
import kotlinx.android.synthetic.main.fragment_design.*

/**
 *  GoogleDesign 风格控件
 */
class DesignFragment : Fragment() {

    companion object{
        fun newInstance():DesignFragment{
            return DesignFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        arguments?.getString("name")?.let {
            //ToastUtils.showShort(this, "hello$it")
        }
        return inflater.inflate(R.layout.fragment_design, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fl_btn.setOnClickListener {
            Snackbar.make(view,"一个snackBar",Snackbar.LENGTH_SHORT)
                    .setAction("action") {
                        Snackbar.make(view,"Action 点击",Snackbar.LENGTH_SHORT).show()
                    }.show()
        }

        var textContext = "举杯邀明月，对饮成三人。"
        while (textContext.length<500){
            textContext += textContext;
        }
        tv_context.text = textContext
    }

}
