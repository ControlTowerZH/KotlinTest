package com.haohao.kotlintest.functionmotion

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.haohao.kotlintest.R
import kotlinx.android.synthetic.main.fragment_granule_demo.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.  Particle 应该是粒子 而不是 Granule 颗粒
 */
class GranuleDemoFragment : Fragment() {

    companion object{
        fun newInstance():GranuleDemoFragment{
            return GranuleDemoFragment()
        }
    }

    lateinit var rotateAnimator: ObjectAnimator
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

       val view:View =  inflater.inflate(R.layout.fragment_granule_demo, container, false)
        //initView()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rotateAnimator = ObjectAnimator.ofFloat(iv_rotate, View.ROTATION, 0f, 360f)
        rotateAnimator.duration = 6000
        rotateAnimator.repeatCount = -1
        rotateAnimator.interpolator = LinearInterpolator()
        lifecycleScope.launch(Dispatchers.Main) {
            initView()
            rotateAnimator.start()
            //添加点击事件，并且启动动画
//            iv_rotate.setOnClickListener {
//
//            }
        }
    }

    private fun initView() {
        Glide.with(this)
                .load(R.drawable.bg_cloud)
                .circleCrop()
                .into(iv_rotate)
    }

}
