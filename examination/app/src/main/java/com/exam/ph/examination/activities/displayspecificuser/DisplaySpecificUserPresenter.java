package com.exam.ph.examination.activities.displayspecificuser;

import com.exam.ph.examination.BaseViewPresenter;
import com.exam.ph.examination.activities.displayusers.DisplayListUserView;

/**
 * Created by IanBlanco on 12/26/2017.
 */

public interface DisplaySpecificUserPresenter extends BaseViewPresenter{
    void attachView(DisplaySpecificUserView displaySpecificUserView);
    void getAge(String date);
}
