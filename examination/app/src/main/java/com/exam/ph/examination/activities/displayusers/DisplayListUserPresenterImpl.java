package com.exam.ph.examination.activities.displayusers;

import android.util.Log;

import com.exam.ph.examination.repository.DataRepository;
import com.exam.ph.examination.restclient.LoadAction;
import com.exam.ph.examination.restclient.restinterface.TestInterface;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by IanBlanco on 12/26/2017.
 */

public class DisplayListUserPresenterImpl implements DisplayListUserPresenter {

    DisplayListUserView mDisplayListUserView;
    DataRepository mDataRepository;

    @Override
    public void attachView(DisplayListUserView displayListUserView) {
        mDisplayListUserView = displayListUserView;
    }

    @Override
    public void loadData(TestInterface testInterface, LoadAction loadAction) {
        if (mDisplayListUserView != null) {
            mDataRepository = new DataRepository();
            mDisplayListUserView.showProgress();
            mDataRepository.getUsers(testInterface).
                    subscribeOn(Schedulers.newThread()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe(result -> mDisplayListUserView.showSuccess(result),
                            throwable -> mDisplayListUserView.showError(throwable.toString()),
                            () -> Log.i("api", "api request completed --> "));
        }
    }


    @Override
    public void detachView() {
        mDisplayListUserView = null;
    }
}
