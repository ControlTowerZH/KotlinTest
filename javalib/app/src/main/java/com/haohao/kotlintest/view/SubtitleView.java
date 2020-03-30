package com.haohao.kotlintest.view;

import android.content.Context;
import android.util.AttributeSet;

import com.haohao.kotlintest.widget.HeadlineTextPage;
import com.iyuba.subtitle.SSGView;


public class SubtitleView extends SSGView<HeadlineTextPage, ChForeignSubtitle> {

    private boolean showCHN = true;
    private OnSelectListener listener;

    public SubtitleView(Context context) {
        super(context);
    }

    public SubtitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SubtitleView(Context context, AttributeSet attrs, int defStyles) {
        super(context, attrs, defStyles);
    }

    public void setOnSelectListener(OnSelectListener listener) {
        this.listener = listener;
    }

    public void setShowCHN(boolean show) {
        if (showCHN != show) {
            showCHN = show;
            int mode = showCHN ? ChForeignSubtitle.ShowMode.DOUBLE_FOREIGN_ABOVE : ChForeignSubtitle.ShowMode.FOREIGN_ONLY;
            for (ChForeignSubtitle sub : mSubtitles) {
                sub.setMode(mode);
            }
            updateContentViews();
        }
    }

    public boolean getShowCHN() {
        return showCHN;
    }

    @Override
    protected HeadlineTextPage buildUnitView(Context context) {
        return new HeadlineTextPage(context);
    }

    @Override
    protected void settingUnitView(final HeadlineTextPage unitview, final int index) {

        unitview.setOnLongClickListener(view -> true);
        unitview.setOnSelectListener(text -> {
            if (listener != null) {
                listener.onSelectText(text);
            }
        });
    }

    public interface OnSelectListener {
        void onSelectText(String text);
    }



}
