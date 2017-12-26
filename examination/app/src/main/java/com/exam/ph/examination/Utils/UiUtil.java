package com.exam.ph.examination.Utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;


/**
 * UiUtil is a collection of static methods that
 * are commonly used in user interface.
 *
 * @author IanBlanco
 */
public class UiUtil {

    /**
     * Show a toast with duration LENGHT_SHORT.
     *
     * @param context
     * @param message
     */
    public static void showToastShort(Context context, String message) {
        showToast(context, message, Toast.LENGTH_SHORT);
    }

    /**
     * Show a toast with duration LENGTH_LONG.
     *
     * @param context
     * @param message
     */
    public static void showToastLong(Context context, String message) {
        showToast(context, message, Toast.LENGTH_LONG);
    }

    private static void showToast(Context context, String message, int duration) {
        Toast.makeText(context, message, duration).show();
    }

    /**
     * Create an instance of ProgressDialog that is
     * not cancelable with the specified message.
     *
     * @param context
     * @param message
     * @return an instance of a ProgressDialog
     */
    public static ProgressDialog getProgressDialog(Context context, String message) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(message);
        return progressDialog;
    }


    public static void dialogWithOnClick(Context context, String title, DialogInterface.OnClickListener onClickListener) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(title);
            builder.setCancelable(false);
            builder.setPositiveButton("OK", onClickListener);
            builder.create().show();
        } catch (Exception e) {
//            No Context available
        }
    }

}
