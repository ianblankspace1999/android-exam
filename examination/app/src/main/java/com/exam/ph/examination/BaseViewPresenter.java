package com.exam.ph.examination;

import com.exam.ph.examination.restclient.LoadAction;
import com.exam.ph.examination.restclient.restinterface.TestInterface;

/**
 * Created by ian.blanco on 10/4/2017.
 */

public interface BaseViewPresenter {
    void loadData(TestInterface testInterface, LoadAction loadAction);
    void detachView();
}
