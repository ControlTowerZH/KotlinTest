package com.haohao.kotlintest


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.haohao.kotlintest.util.HeadlineType

import java.util.ArrayList
import androidx.recyclerview.widget.RecyclerView


class DropDownAdapter : RecyclerView.Adapter<DropDownAdapter.DropTypeHolder>() {

    private var mTypes: List<String>? = null
    private var mItemClickListener: OnItemClickListener? = null

    var mCurrentSelectedPosition: Int = 0

    init {
        mTypes = ArrayList()
        mCurrentSelectedPosition = 0
    }

    fun setData(types: List<String>) {
        mTypes = types
        notifyDataSetChanged()
    }

    fun setDelegate(l: OnItemClickListener) {
        mItemClickListener = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DropTypeHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.headline_item_drop_down, parent, false)
        return DropTypeHolder(itemView)
    }

    override fun onBindViewHolder(holder: DropTypeHolder, position: Int) {
        holder.bind(mTypes!![position], position)
    }

    override fun getItemCount(): Int {
        return mTypes!!.size
    }

    private fun getTypeIcon(type: String): Int {
        return when (type) {
            HeadlineType.ALL -> R.drawable.headline_type_all
            HeadlineType.NEWS -> R.drawable.headline_type_news
            HeadlineType.SONG -> R.drawable.headline_type_song
            HeadlineType.VOA -> R.drawable.headline_type_voa
            HeadlineType.CSVOA -> R.drawable.headline_type_csvoa
            HeadlineType.BBC -> R.drawable.headline_type_bbc
            HeadlineType.VOAVIDEO -> R.drawable.headline_type_voavideo
            HeadlineType.MEIYU -> R.drawable.headline_type_meiyu
            HeadlineType.TED -> R.drawable.headline_type_ted
            HeadlineType.BBCWORDVIDEO -> R.drawable.headline_type_bbc
            HeadlineType.TOPVIDEOS -> R.drawable.headline_type_cnn//headline_type_news
            HeadlineType.JAPANVIDEOS -> R.drawable.headline_type_japanese
            else -> R.drawable.headline_type_voa
        }
    }

    private fun getTypeText(type: String): Int {
        return when (type) {
            HeadlineType.ALL -> R.string.headline_type_all
            HeadlineType.SONG -> R.string.headline_type_song
            HeadlineType.VOA -> R.string.headline_type_voa
            HeadlineType.CSVOA -> R.string.headline_type_csvoa
            HeadlineType.BBC -> R.string.headline_type_bbc
            HeadlineType.VOAVIDEO -> R.string.headline_type_voavideo
            HeadlineType.MEIYU -> R.string.headline_type_meiyu
            HeadlineType.TED -> R.string.headline_type_ted
            HeadlineType.BBCWORDVIDEO -> R.string.headline_type_bbcvideo//headline_type_bbcwordvideo
            HeadlineType.JAPANVIDEOS -> R.string.headline_type_japanvideos
            HeadlineType.TOPVIDEOS -> R.string.headline_type_topvideos
            HeadlineType.NEWS -> R.string.headline_type_news
            else -> R.string.headline_type_news
        }
    }

    inner class DropTypeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var mIconIv: ImageView = itemView.findViewById(R.id.image_type)
        var mTextTv: TextView = itemView.findViewById(R.id.text_type)

        private var type: String? = null

        fun bind(type: String, position: Int) {
            this.type = type
            mTextTv.setText(getTypeText(type))
            mIconIv.setImageResource(getTypeIcon(type))
            itemView.isSelected = mCurrentSelectedPosition == position
            itemView.findViewById<View>(R.id.linear_container).setOnClickListener {
                if (mItemClickListener != null) {
                    val last = mCurrentSelectedPosition
                    val current = adapterPosition
                    val needChange = mCurrentSelectedPosition != current
                    if (needChange) {
                        mCurrentSelectedPosition = current
                        notifyItemChanged(last)
                        notifyItemChanged(mCurrentSelectedPosition)
                    }
                    mItemClickListener!!.collapseDropDown()
                    if (needChange) {
                        when (type) {
                            HeadlineType.VOA -> {
                            }
                        }
                        mItemClickListener!!.onTypeSelected(type)
                    }
                }
            }
        }
    }

    interface OnItemClickListener {
        fun collapseDropDown()

        fun onTypeSelected(type: String)
    }
}

