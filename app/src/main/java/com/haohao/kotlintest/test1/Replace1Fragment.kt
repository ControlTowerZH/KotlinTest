package com.haohao.kotlintest.test1


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.haohao.kotlintest.R

/**
 * A simple [Fragment] subclass.
 */
class Replace1Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_replase1, container, false)
    }


}
