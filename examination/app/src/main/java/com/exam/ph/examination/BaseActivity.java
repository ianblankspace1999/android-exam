package com.exam.ph.examination;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.exam.ph.examination.Utils.NetworkHelper;
import com.exam.ph.examination.Utils.UiUtil;
import com.exam.ph.examination.restclient.restinterface.TestInterface;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by ian.blanco on 10/4/2017.
 */

public abstract class BaseActivity extends AppCompatActivity{

    protected Context mContext;

    protected NetworkHelper networkHelper;

    @Inject
    protected TestInterface mTestInterface;

    protected abstract int getLayoutResource();

    protected abstract DialogInterface.OnClickListener getListner();

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        networkHelper = new NetworkHelper(mContext);
        ((ExamApplication) getApplication()).getAppComponent().inject(this);
        setContentView(getLayoutResource());
        ButterKnife.bind(this);

    }



    @Override
    protected void onResume() {
        super.onResume();
        if (!networkHelper.isNetworkAvailable()) {
            UiUtil.dialogWithOnClick(mContext, "No Internet connection!", getListner());
        }
    }


}
