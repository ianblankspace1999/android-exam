package com.exam.ph.examination.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by IanBlanco on 12/26/2017.
 */
@Data
public class User implements Serializable{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("birthdate")
    @Expose
    private String birthdate;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("contact_info")
    @Expose
    private ContactInfo contactInfo;
    @SerializedName("phone")
    @Expose
    private String phone;
}
