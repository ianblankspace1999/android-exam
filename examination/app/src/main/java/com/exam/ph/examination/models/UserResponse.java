package com.exam.ph.examination.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

/**
 * Created by IanBlanco on 12/26/2017.
 */
@Data
public class UserResponse implements Serializable {
    @SerializedName("data")
    @Expose
    private ArrayList<User> userList;
}
