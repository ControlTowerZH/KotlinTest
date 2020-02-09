package com.haohao.kotlintest;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.haohao.kotlintest.util.HeadlineType;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class DropDownAdapter extends RecyclerView.Adapter<DropDownAdapter.DropTypeHolder> {

    private List<String> mTypes;
    private OnItemClickListener mItemClickListener;

    public int mCurrentSelectedPosition;

    public DropDownAdapter() {
        mTypes = new ArrayList<>();
        mCurrentSelectedPosition = 0;
    }

    public void setData(List<String> types) {
        mTypes = types;
        notifyDataSetChanged();
    }

    public void setDelegate(OnItemClickListener l) {
        mItemClickListener = l;
    }

    @NonNull
    @Override
    public DropTypeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.headline_item_drop_down, parent, false);
        return new DropTypeHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DropTypeHolder holder, int position) {
        holder.bind(mTypes.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mTypes.size();
    }

    private int getTypeIcon(String type) {
        switch (type) {
            case HeadlineType.ALL:
                return R.drawable.headline_type_all;
            case HeadlineType.NEWS:
                return R.drawable.headline_type_news;
            case HeadlineType.SONG:
                return R.drawable.headline_type_song;
            case HeadlineType.VOA:
                return R.drawable.headline_type_voa;
            case HeadlineType.CSVOA:
                return R.drawable.headline_type_csvoa;
            case HeadlineType.BBC:
                return R.drawable.headline_type_bbc;
            case HeadlineType.VOAVIDEO:
                return R.drawable.headline_type_voavideo;
            case HeadlineType.MEIYU:
                return R.drawable.headline_type_meiyu;
            case HeadlineType.TED:
                return R.drawable.headline_type_ted;
            case HeadlineType.BBCWORDVIDEO:
                return R.drawable.headline_type_bbc;
            case HeadlineType.TOPVIDEOS:
                return R.drawable.headline_type_cnn;//headline_type_news
            case HeadlineType.JAPANVIDEOS:
                return R.drawable.headline_type_japanese;
            default:
                return R.drawable.headline_type_voa;
        }
    }

    private int getTypeText(String type) {
        switch (type) {
            case HeadlineType.ALL:
                return R.string.headline_type_all;
            case HeadlineType.SONG:
                return R.string.headline_type_song;
            case HeadlineType.VOA:
                return R.string.headline_type_voa;
            case HeadlineType.CSVOA:
                return R.string.headline_type_csvoa;
            case HeadlineType.BBC:
                return R.string.headline_type_bbc;
            case HeadlineType.VOAVIDEO:
                return R.string.headline_type_voavideo;
            case HeadlineType.MEIYU:
                return R.string.headline_type_meiyu;
            case HeadlineType.TED:
                return R.string.headline_type_ted;
            case HeadlineType.BBCWORDVIDEO:
                return R.string.headline_type_bbcvideo;//headline_type_bbcwordvideo
            case HeadlineType.JAPANVIDEOS:
                return R.string.headline_type_japanvideos;
            case HeadlineType.TOPVIDEOS:
                return R.string.headline_type_topvideos;
            case HeadlineType.NEWS:
            default:
                return R.string.headline_type_news;
        }
    }

    class DropTypeHolder extends RecyclerView.ViewHolder {

        ImageView mIconIv;
        TextView mTextTv;

        private String type;

        public DropTypeHolder(View itemView) {
            super(itemView);
            mIconIv=itemView.findViewById(R.id.image_type);
            mTextTv=itemView.findViewById(R.id.text_type);
            //ButterKnife.bind(this, itemView);
            //itemView.setBackgroundDrawable(ContextCompat.getDrawable(itemView.getContext(), R.drawable.headline_drop_down_selector));
        }

        public void bind(final String type, int position) {
            this.type = type;
            mTextTv.setText(getTypeText(type));
            mIconIv.setImageResource(getTypeIcon(type));
            itemView.setSelected(mCurrentSelectedPosition == position);
            itemView.findViewById(R.id.linear_container).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mItemClickListener != null) {
                        int last = mCurrentSelectedPosition;
                        int current = getAdapterPosition();
                        boolean needChange = mCurrentSelectedPosition != current;
                        if (needChange) {
                            mCurrentSelectedPosition = current;
                            notifyItemChanged(last);
                            notifyItemChanged(mCurrentSelectedPosition);
                        }
                        mItemClickListener.collapseDropDown();
                        if (needChange) {
                            switch (type){
                                case HeadlineType.VOA:
                                    break;
                            }
                            mItemClickListener.onTypeSelected(type);
                        }
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void collapseDropDown();

        void onTypeSelected(String type);
    }
}

