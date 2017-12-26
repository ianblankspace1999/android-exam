package com.exam.ph.examination.dagger;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ian.blanco on 12/26/2017.
 */
@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }



    @Provides
    @Singleton
    public Context getContext() {
        return application;
    }
}
