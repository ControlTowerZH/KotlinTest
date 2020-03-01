package com.haohao.kotlintest.help;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import android.util.SparseArray;

import com.haohao.kotlintest.R;
import com.haohao.kotlintest.util.ResourcesUtil;


public final class CategoryDataHelper {
    private static CategoryDataHelper sInstance;
    private static final int DEFAULT_CODE_POSITION = 0;

    public static void init(Context context) {
        if (sInstance == null) {
            sInstance = new CategoryDataHelper(context);
        }
    }

    public static CategoryDataHelper getInstance() {
        if (sInstance == null) {
            throw new NullPointerException("CategoryDataHelper is not initialized yet");
        }
        return sInstance;
    }

    public int[] imageIds;
    public int[] codes;
    //private final String[] names;
    public String[] names;
    private final SparseArray<String> mMap;
    private final SparseArray<String> mCnMap;

    private CategoryDataHelper(Context context) {
        Resources resources = context.getResources();

        codes = resources.getIntArray(R.array.category_code);
        names = resources.getStringArray(R.array.category_name);
        imageIds = ResourcesUtil.INSTANCE.fromTypedArray(context, R.array.category_images);
        mMap = new SparseArray<>();
        mCnMap = new SparseArray<>();
        String[] cnnames = resources.getStringArray(R.array.category_images);//category_cn_name

        for (int i = 0; i < codes.length; i += 1) {
            mMap.put(codes[i], names[i]);
            mCnMap.put(codes[i], cnnames[i]);

        }
    }

    public Pair<String[], int[]> getCategoryData() {
        return new Pair<>(names, imageIds);
    }

    public int getDefaultCategoryCode() {
        return codes[DEFAULT_CODE_POSITION];
    }

    public String getDefaultCategoryName() {
        return names[DEFAULT_CODE_POSITION];
    }

    public int getCategoryCode(int position) {
        return codes[position];
    }

    public String getCategoryName(int position) {
        return names[position];
    }

    public String getNameFromCode(int code) {
        return mMap.get(code);
    }

    public String getCnNameFromCode(int code) {
        return mCnMap.get(code);
    }
}
