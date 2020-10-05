package com.haohao.kotlintest.data.model

import androidx.databinding.ObservableInt

/**
 * Description : kotlin 的数据bean竟然可以这样？
 *
 * @author Wanderer
 * @date 2020/9/18
 */
data class DataBindingUser (
    val name: String,
    val age: ObservableInt,
    val num: ObservableInt
)