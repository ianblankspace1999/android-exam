package com.exam.ph.examination.restclient.restinterface;


import com.exam.ph.examination.models.UserResponse;

import java.util.ArrayList;

import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by IanBlanco on 10/04/2017.
 */

public interface TestInterface {

    @GET("5a41d13b3200000438ac34de")
    Observable<Response<UserResponse>> getUsers();

}
