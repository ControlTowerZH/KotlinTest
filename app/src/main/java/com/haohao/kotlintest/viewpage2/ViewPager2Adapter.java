package com.haohao.kotlintest.viewpage2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haohao.kotlintest.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPager2Adapter extends FragmentStateAdapter {

    private List<Fragment> mFragments;
    private String[] mTitles;

    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity,List<Fragment> list, String[] titles) {
        super(fragmentActivity);
        mFragments = list;
        if (titles!=null)
            mTitles=titles;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getItemCount() {
        return  mTitles.length;
    }


}
