package com.haohao.kotlintest.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.haohao.kotlintest.R

class NewsListAdapter : RecyclerView.Adapter<NewsListAdapter.TitleHolder> {

    private var mContext: Context
    private var itemList: List<String>

    constructor(mContext: Context, list: List<String>) {
        this.mContext = mContext
        this.itemList = list
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.headline_item_title_small, parent, false)
        return TitleHolder(view)
    }

    override fun onBindViewHolder(holder: TitleHolder, position: Int) {
        holder.simpleItemView.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


     class TitleHolder (var simpleItemView: View): RecyclerView.ViewHolder(simpleItemView){

    }
}