package com.exam.ph.examination.restclient;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by IanBlanco on 3/15/2017.
 */

public class Rest {

    private static Retrofit mRetrofit = null;

    public static <T> T create(final Context context, Class<T> interFace){


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        String baseUrl = "";
        // Get Base URL from meta-data
        ApplicationInfo app = null;
        try {
            app = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = app.metaData;
            baseUrl = bundle.getString("base-url", "");

//            if (baseUrl.length() == 0) {
//                UiUtil.showAlertDialog(context, "URL not found", "Base URL not found in manifest. Please declare a meta-data value with name \"base-url\".");
//                return null;
//            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        // Check for authorization
        OkHttpClient client;

        client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
//                                .addHeader("X-Authorization", authKey)
//                                .addHeader("X-OS", "android")
//                                .addHeader("X-App-Version", finalAppVersionName)
//                                .addHeader("X-OS-Version", osVersion)
//                                .addHeader("X-Device-Name", getDeviceName())
                                .build();
                        return chain.proceed(request);
                    }
                }).build();

        mRetrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return mRetrofit.create(interFace);
    }

}
