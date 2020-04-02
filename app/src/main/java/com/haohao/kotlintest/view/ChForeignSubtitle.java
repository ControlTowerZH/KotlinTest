package com.haohao.kotlintest.view;


import com.iyuba.subtitle.Subtitleable;

public class ChForeignSubtitle implements Subtitleable {

    public interface ShowMode {
        int FOREIGN_ONLY = 0;
        int DOUBLE_CH_ABOVE = 1;
        int DOUBLE_FOREIGN_ABOVE = 2;
        int CHINESE_ONLY = 3;
    }

    public String mChContent = "";
    public String mForeignContent = "";
    public long mStartTime;
    public int wordCount;

    private int mode = ShowMode.DOUBLE_FOREIGN_ABOVE;

    public void setMode(int mode) {
        this.mode = mode;
    }

    @Override
    public long getStartTime() {
        return mStartTime;
    }

    @Override
    public String getContent() {
        switch (mode) {
            case ShowMode.FOREIGN_ONLY:
                return mForeignContent;
            case ShowMode.DOUBLE_FOREIGN_ABOVE:
                return mForeignContent + "\n" + mChContent;
            case ShowMode.DOUBLE_CH_ABOVE:
                return mChContent + "\n" + mForeignContent;
            case ShowMode.CHINESE_ONLY:
                return mChContent;
            default:
                return mForeignContent;
        }
    }



}
