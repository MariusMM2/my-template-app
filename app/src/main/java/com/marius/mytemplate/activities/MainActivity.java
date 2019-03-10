package com.marius.mytemplate.activities;

import android.support.v4.app.Fragment;
import com.marius.mytemplate.fragments.MainFragment;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }
}
