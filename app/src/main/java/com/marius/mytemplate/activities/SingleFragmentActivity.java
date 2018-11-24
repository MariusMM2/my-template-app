package com.marius.mytemplate.activities;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import com.marius.mytemplate.R;
import com.marius.mytemplate.Settings;

//A template Activity consisting of one fragment
public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();

    //To be overridden if the activity contains multiple fragments
    @LayoutRes
    protected int getLayoutResId() {
        return R.layout.activity_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(Settings.getInstance(this).darkMode ? R.style.AppNightTheme : R.style.AppDayTheme);
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Settings.getInstance(this).save(this);
    }
}