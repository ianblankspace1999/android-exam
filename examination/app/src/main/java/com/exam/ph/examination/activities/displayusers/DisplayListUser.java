package com.exam.ph.examination.activities.displayusers;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.exam.ph.examination.BaseActivity;
import com.exam.ph.examination.ExamApplication;
import com.exam.ph.examination.R;
import com.exam.ph.examination.Utils.BaseUtil;
import com.exam.ph.examination.Utils.UiUtil;
import com.exam.ph.examination.activities.displayspecificuser.DisplaySpecificUser;
import com.exam.ph.examination.adapter.DisplayListUserAdapter;
import com.exam.ph.examination.models.User;
import com.exam.ph.examination.models.UserResponse;
import com.exam.ph.examination.restclient.LoadAction;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by IanBlanco on 12/26/2017.
 */

public class DisplayListUser extends BaseActivity implements DisplayListUserView, DisplayListUserAdapter.Callback {

    @Inject
    DisplayListUserPresenter mDisplayListUserPresenter;

    @BindView(R.id.rvUserList)
    RecyclerView mRvUserList;

    @BindView(R.id.progBar)
    ProgressBar mProgBar;

    private ArrayList<User> mUserList = new ArrayList<>();

    private DisplayListUserAdapter mDisplayListUserAdapter;

    private DialogInterface.OnClickListener onClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            mDisplayListUserPresenter.loadData(mTestInterface, LoadAction.LOAD_USER_LIST);
        }
    };

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_displaylistuser;
    }


    @Override
    protected DialogInterface.OnClickListener getListner() {
        return onClick;
    }

    @Override
    public void showProgress() {
        mProgBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgBar.setVisibility(View.GONE);
    }

    @Override
    public void showSuccess(Object result) {
        Log.i("pumasok dito", "pumasok dito");
        if (result instanceof UserResponse) {
            Log.i("pumasok dito", "pumasok dito o");
            UserResponse userResponse = (UserResponse) result;
            mUserList = userResponse.getUserList();
            mDisplayListUserAdapter = new DisplayListUserAdapter(this, mUserList, this);
            BaseUtil.setDefaultRecyclerView(this, mRvUserList, mDisplayListUserAdapter);
            hideProgress();
        }

    }

    @Override
    public void showError(String error) {
        hideProgress();
        Log.i("pumasok dito", "pumasok dito error: " + error);
        if (!networkHelper.isNetworkAvailable()) {
            UiUtil.dialogWithOnClick(mContext, "No Internet connection!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mDisplayListUserPresenter.loadData(mTestInterface, LoadAction.LOAD_MOVIE);
                }
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((ExamApplication) getApplication()).getAppComponent().inject(this);
        mDisplayListUserPresenter.attachView(this);
        initialize();
    }

    private void initialize() {
        if (!networkHelper.isNetworkAvailable()) {
            UiUtil.dialogWithOnClick(mContext, "No Internet connection!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mDisplayListUserPresenter.loadData(mTestInterface, LoadAction.LOAD_USER_LIST);
                }
            });
            return;
        }
        mDisplayListUserPresenter.loadData(mTestInterface, LoadAction.LOAD_USER_LIST);
    }

    @Override
    public void changeIntent(Context context, String response) {
        Intent intent = DisplaySpecificUser.getIntent(context, response);
        startActivity(intent);
    }
}
