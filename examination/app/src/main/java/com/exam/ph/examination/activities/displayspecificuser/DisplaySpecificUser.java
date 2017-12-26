package com.exam.ph.examination.activities.displayspecificuser;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.exam.ph.examination.BaseActivity;
import com.exam.ph.examination.ExamApplication;
import com.exam.ph.examination.R;
import com.exam.ph.examination.Utils.BaseUtil;
import com.exam.ph.examination.Utils.ModelUtil;
import com.exam.ph.examination.models.User;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by IanBlanco on 12/26/2017.
 */

public class DisplaySpecificUser extends BaseActivity implements DisplaySpecificUserView {

    @Inject
    DisplaySpecificUserPresenter mDisplaySpecificUserPresenter;

    @BindView(R.id.tvUserName)
    TextView tvUserName;

    @BindView(R.id.tvAddress)
    TextView tvAddress;

    @BindView(R.id.tvBirthDate)
    TextView tvBirthDate;

    @BindView(R.id.tvAge)
    TextView tvAge;

    @BindView(R.id.tvPhone)
    TextView tvPhone;

    @BindView(R.id.tvContactName)
    TextView tvContactName;

    @BindView(R.id.tvContactNumber)
    TextView tvContactNumber;

    @BindView(R.id.exhibitorImageView)
    ImageView exhibitorImageView;

    @BindView(R.id.tvPersonName)
    TextView tvPersonName;

    @BindView(R.id.tvEmail)
    TextView tvEmail;

    @BindView(R.id.rlProfileInfo)
    RelativeLayout rlProfileInfo;

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    public static String ARGS_USER = "ARGS_USER";

    private User mUser;

    public static Intent getIntent(Context context, String response) {
        Intent intent = new Intent(context, DisplaySpecificUser.class);
        intent.putExtra(ARGS_USER, response);
        return intent;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.layout_details;
    }

    @Override
    protected DialogInterface.OnClickListener getListner() {
        return null;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showSuccess(Object result) {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((ExamApplication) getApplication()).getAppComponent().inject(this);
        mDisplaySpecificUserPresenter.attachView(this);
        initialize();
    }

    private void initialize() {
        Bundle extras = getIntent().getExtras();
        String response = extras.getString(ARGS_USER);
        mUser = ModelUtil.fromJson(User.class, response);
        setDetails(mUser);
    }

    private void setDetails(User user) {

        mDisplaySpecificUserPresenter.getAge(user.getBirthdate());

        tvPersonName.setText(user.getFirstName() + " " + user.getLastName());
        tvEmail.setText(user.getEmail());
        tvPhone.setText(user.getPhone());
        tvUserName.setText(user.getUsername());
        tvAddress.setText(user.getAddress().getStreet() +" "+ user.getAddress().getSuite() + " " +
        user.getAddress().getCity());
        tvBirthDate.setText(BaseUtil.getBirthDate(user.getBirthdate()));
        tvContactName.setText(user.getContactInfo().getContactName());
        tvContactNumber.setText(user.getContactInfo().getContactNo());
    }

    @Override
    public void showAge(String age) {
        tvAge.setText(age);
    }
}
