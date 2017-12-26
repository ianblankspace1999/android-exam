package com.exam.ph.examination.Utils;

import android.widget.ProgressBar;

import com.exam.ph.examination.restclient.LoadAction;

import java.util.List;

/**
 * Created by ian.blanco on 10/4/2017.
 */

public interface BaseView {


    void showProgress();

    void hideProgress();

    void showSuccess(Object result);

    void showError(String error);
}
