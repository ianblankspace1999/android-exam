package com.exam.ph.examination.activities.displayspecificuser;

import com.exam.ph.examination.Utils.BaseUtil;
import com.exam.ph.examination.activities.displayusers.DisplayListUserView;
import com.exam.ph.examination.restclient.LoadAction;
import com.exam.ph.examination.restclient.restinterface.TestInterface;

import java.util.ArrayList;

/**
 * Created by IanBlanco on 12/26/2017.
 */

public class DisplaySpecificUserPresenterImpl implements DisplaySpecificUserPresenter{

    private DisplaySpecificUserView mDisplaySpecificUserView;

    @Override
    public void loadData(TestInterface testInterface, LoadAction loadAction) {

    }



    @Override
    public void detachView() {
        mDisplaySpecificUserView = null;
    }


    @Override
    public void attachView(DisplaySpecificUserView displaySpecificUserView) {
        mDisplaySpecificUserView = displaySpecificUserView;
    }

    @Override
    public void getAge(String date) {
        if (mDisplaySpecificUserView != null) {
            ArrayList<Integer> ints = new ArrayList<>(BaseUtil.convertBirthDate(date));

            mDisplaySpecificUserView.showAge(BaseUtil.getAge(ints.get(0), ints.get(1), ints.get(2)));
        }
    }
}
