package com.marius.mytemplate;

import android.app.Application;

public class TemplateApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Settings.getInstance(this).refreshTheme();
    }
}
