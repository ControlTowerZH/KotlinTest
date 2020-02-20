package com.haohao.kotlintest.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.haohao.kotlintest.R
import com.haohao.kotlintest.data.model.Headline
import com.haohao.kotlintest.util.ToastUtils
import kotlinx.android.synthetic.main.headline_item_title_small.view.*
import java.text.SimpleDateFormat
import java.util.*

class NewsListAdapter : RecyclerView.Adapter<NewsListAdapter.TitleHolder> {

    private var mContext: Context
    private  var headlines: MutableList<Headline> ?= null

    constructor(mContext: Context) {
        this.mContext = mContext
    }

    fun setItems(headlines: MutableList<Headline>) {
        this.headlines = headlines
        notifyDataSetChanged()
    }

    fun addItems(headlines: List<Headline>) {
        this.headlines!!.addAll(headlines)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.headline_item_title_small, parent, false)
        return TitleHolder(view)
    }

    override fun onBindViewHolder(holder: TitleHolder, position: Int) {
        holder.setItem(headlines!!.get(position),position)
    }

    override fun getItemCount(): Int {
        if (headlines==null){
            return 0
        }
        return headlines!!.size
    }


     class TitleHolder (var simpleItemView: View): RecyclerView.ViewHolder(simpleItemView){


         public fun setItem( headline:Headline, position:Int ) {
             var time = ""
             if (headline.createTime != null && headline.createTime!!.length >= 10) {
                 time = headline.createTime!!.substring(0, 10)
             }
             @SuppressLint("SimpleDateFormat") val sdf = SimpleDateFormat("yyyy-MM-dd")
             val nowTime = sdf.format(Date().time)

             if (time == nowTime) {
                 if (headline.createTime != null && headline.createTime!!.length >= 16) {
                     time = "今天" + " " + headline.createTime!!.substring(10, 16)
                 }
             }

             simpleItemView.tv_time_top.text=time

             Glide.with(itemView.context)
                     .load(headline.getPic())
                     .placeholder(R.drawable.headline_loading)
                     .dontAnimate().error(R.drawable.headline_failed)
                     .into(simpleItemView.iv_headlines)

             simpleItemView.iv_headlines_collect.setImageResource(R.drawable.ic_collect_on)
             simpleItemView.tv_view_count.text=(itemView.context.getString(R.string.headline_view_count_info, headline.readCount))

             simpleItemView.tv_headlines_title_cn.text=(headline.titleCn)

             simpleItemView.setOnClickListener {
                 ToastUtils.showShort(simpleItemView.context,headline.title!!)
             }
         }
    }
}