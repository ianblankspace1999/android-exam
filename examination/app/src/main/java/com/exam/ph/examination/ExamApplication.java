package com.exam.ph.examination;

import android.app.Application;

import com.exam.ph.examination.dagger.AppComponent;
import com.exam.ph.examination.dagger.AppModule;
import com.exam.ph.examination.dagger.DaggerAppComponent;

/**
 * Created by ian.blanco on 12/26/2017.
 */

public class ExamApplication extends Application {

    private AppComponent mAppComponent;

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    protected AppComponent initDagger(ExamApplication application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = initDagger(this);
    }
}
