package com.haohao.kotlintest.function;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.haohao.kotlintest.R;
import com.haohao.kotlintest.functionmotion.GranuleDemoFragment;

/**
 * 容器Activity 包裹Fragment ,最好再实现一下 模仿Activity任务栈
 */
public class ContainsActivity extends AppCompatActivity {
    public static final String FRAGMENT_OK_HTTP = "okHttpFragment";
    public static final String FRAGMENT_DESIGN = "designFragment";
    public static final String FRAGMENT_CLOUD = "cloudFragment";
    public static final String FRAGMENT_ANIMATE = "animateFragment";
    public static final String FRAGMENT_TYPE = "Fragment";

    public static void start(Context context, String type) {
        Intent intent = new Intent(context, ContainsActivity.class);
        intent.putExtra(FRAGMENT_TYPE, type);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String fragmentType = getIntent().getStringExtra(FRAGMENT_TYPE);
        if (fragmentType != null && fragmentType.equals(FRAGMENT_DESIGN)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                View decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                getWindow().setStatusBarColor(Color.TRANSPARENT);
            }
        }
        setContentView(R.layout.activity_contains);
        if (!TextUtils.isEmpty(fragmentType)) {
            switch (fragmentType) {
                case FRAGMENT_OK_HTTP:
                    replaceFragment(OkHttpFragment.newInstance());
                    break;
                case FRAGMENT_DESIGN:
                    replaceFragment(DesignFragment.Companion.newInstance());
                    break;
                case FRAGMENT_CLOUD:
                    replaceFragment(GranuleDemoFragment.Companion.newInstance());
                    break;
                case FRAGMENT_ANIMATE:
                    replaceFragment(AnimateFragment.Companion.newInstance("",""));
                    break;
                default:
            }
        }

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_fragment, fragment);
        transaction.commit();
    }
}
