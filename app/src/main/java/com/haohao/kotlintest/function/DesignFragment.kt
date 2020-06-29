package com.haohao.kotlintest.function

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar

import com.haohao.kotlintest.R
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_design, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_snack.setOnClickListener {
            Snackbar.make(view,"一个snackBar",Snackbar.LENGTH_SHORT)
                    .setAction("action") {
                        Snackbar.make(view,"Action 点击",Snackbar.LENGTH_SHORT).show()
                    }.show()
        }
    }

}
