package com.exam.ph.examination.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by IanBlanco on 3/20/2017.
 */

public class ErrorResponse extends Throwable {

    @SerializedName("error")
    public Error error;

    public static class Error {

        @SerializedName("code")
        public String code;

        @SerializedName("http_code")
        public String httpCode;

        @SerializedName("message")
        public String message;

    }
}
