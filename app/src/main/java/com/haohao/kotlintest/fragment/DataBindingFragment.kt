package com.haohao.kotlintest.fragment

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableInt
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.haohao.kotlintest.R
import com.haohao.kotlintest.data.model.DataBindingUser
import com.haohao.kotlintest.databinding.FragmentDataBindingBinding
import kotlinx.android.synthetic.main.fragment_data_binding.*

/**
 * A simple [Fragment] subclass.
 */
class DataBindingFragment : Fragment() {
    //定义我们的数据
    private val fieldProfile = DataBindingUser("dog",  ObservableInt(100),
            ObservableInt(230))

    var mBinding:  FragmentDataBindingBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return inflater.inflate(R.layout.fragment_data_binding, container, false)
        mBinding = FragmentDataBindingBinding.inflate(inflater);
        return mBinding!!.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //注释1处，将Activity和布局文件绑定
//        val binding:  FragmentDataBindingBinding = DataBindingUtil
//                .setContentView(context as Activity, R.layout.fragment_data_binding)
        //注释2处，为布局变量user赋值
        mBinding!!.user = fieldProfile

        val navController = Navigation.findNavController(view)
        mBinding!!.tvSkip.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", "silas")
            navController.navigate(R.id.action_dataBindingFragment_to_designFragment, bundle)
        }
    }

}
