package com.marius.mytemplate.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchAnimListener;
import com.mahfa.dnswitch.DayNightSwitchListener;
import com.marius.mytemplate.R;
import com.marius.mytemplate.Settings;
import com.marius.mytemplate.fragments.MainFragment;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.daynight_menu, menu);

        DayNightSwitch dayNightSwitch = menu.findItem(R.id.day_night_switch).getActionView().findViewById(R.id.switch_item);
        dayNightSwitch.setIsNight(Settings.getInstance(this).darkMode);
        dayNightSwitch.setAnimListener(new DayNightSwitchAnimListener() {
            @Override
            public void onAnimStart() {

            }

            @Override
            public void onAnimEnd() {
                Fragment frag = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
                assert frag != null;
                frag.onStop();
                Intent intent = new Intent(frag.getActivity(), MainActivity.class);

                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimValueChanged(float v) {

            }
        });
        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean isNight) {
                Settings.getInstance(MainActivity.this).darkMode = isNight;
            }
        });

        return true;
    }
}
