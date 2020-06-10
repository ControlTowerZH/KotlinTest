package com.haohao.kotlintest.viewpage2;

import android.os.Parcelable;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

//FragmentStatePagerAdapter 适用于大量页面，不保存状态
//FragmentStateAdapter替换了原来的 FragmentStatePagerAdapter
//RecyclerView.Adapter替换了原来的 FragmentPagerAdapter
//registerOnPageChangeCallback替换了原来的 addPageChangeListener
//
//作者：走在冷风中吧
//链接：https://www.jianshu.com/p/6d46c89069f8
//来源：简书
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public class CommonPagerAdapter extends FragmentPagerAdapter {//少量fragment

    private List<Fragment> mFragments;
    private String[] mTitles;

    public CommonPagerAdapter(FragmentManager fm, @NonNull List<Fragment> list, String[] titles) {
        super(fm);
        mFragments = list;
        if (titles!=null)
        mTitles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}
