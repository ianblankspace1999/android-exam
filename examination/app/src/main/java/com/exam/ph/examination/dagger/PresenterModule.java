package com.exam.ph.examination.dagger;



import com.exam.ph.examination.activities.displayspecificuser.DisplaySpecificUserPresenter;
import com.exam.ph.examination.activities.displayspecificuser.DisplaySpecificUserPresenterImpl;
import com.exam.ph.examination.activities.displayusers.DisplayListUserPresenter;
import com.exam.ph.examination.activities.displayusers.DisplayListUserPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ian.blanco on 12/26/2017.
 */
@Module
public class PresenterModule {


    @Provides
    @Singleton
    DisplayListUserPresenter provideDisplayUserListPresenter() {
        return new DisplayListUserPresenterImpl();
    }

    @Provides
    @Singleton
    DisplaySpecificUserPresenter provideDisplayUserSpecificPresenter() {
        return  new DisplaySpecificUserPresenterImpl();
    }
}
