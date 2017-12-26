package com.exam.ph.examination.repository;

import android.util.Log;

import com.exam.ph.examination.models.ErrorResponse;
import com.exam.ph.examination.models.User;
import com.exam.ph.examination.models.UserResponse;
import com.exam.ph.examination.restclient.restinterface.TestInterface;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by IanBlanco on 12/26/2017.
 */

public class DataRepository {

    private Retrofit mRetrofit;


    public Observable<UserResponse> getUsers(final TestInterface testInterface) {
        return testInterface.getUsers().flatMap(new Func1<Response<UserResponse>, Observable<UserResponse>>() {
            @Override
            public Observable<UserResponse> call(Response<UserResponse> listResponse) {
                if (listResponse.isSuccessful()) {
                    return Observable.just(listResponse.body());
                }
                try {
                    Converter<ResponseBody, ErrorResponse> converter = mRetrofit.responseBodyConverter(ErrorResponse.class, new Annotation[0]);
                    ErrorResponse error = converter.convert(listResponse.errorBody());

                    return Observable.error(error);
                } catch (IOException e) {
                    Log.i("Error,", "Error:error");
                    return null;
                }

            }
        });
    }



}
