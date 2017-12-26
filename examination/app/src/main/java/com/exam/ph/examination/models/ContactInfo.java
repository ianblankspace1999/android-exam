package com.exam.ph.examination.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by IanBlanco on 12/26/2017.
 */
@Data
public class ContactInfo implements Serializable {

    @SerializedName("contact_name")
    @Expose
    private String contactName;
    @SerializedName("contact_no")
    @Expose
    private String contactNo;
}
