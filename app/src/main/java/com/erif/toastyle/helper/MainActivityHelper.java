package com.erif.toastyle.helper;

import android.content.Context;
import android.view.Gravity;

import com.erif.toastyle.R;
import com.erif.toastyle.Toastyle;

public class MainActivityHelper {

    private final Context context;

    public MainActivityHelper(Context context) {
        this.context = context;
    }

    public void toastBasic() {
        Toastyle.makeText(context, "Basic toast");
    }

    public void toastTextColor() {
        new Toastyle.Builder(context, "Toast text color")
                .textColor(R.color.purple_200)
                .show();
    }

    public void toastIconLeft() {
        new Toastyle.Builder(context, "Toast with left icon")
                .iconLeft(R.drawable.ic_error)
                .iconColor(R.color.purple_200)
                .show();
    }

    public void toastIconRight() {
        new Toastyle.Builder(context, "Toast with right icon")
                .iconRight(R.drawable.ic_error)
                .iconColor(R.color.purple_200)
                .show();
    }

    public void toastCorner() {
        new Toastyle.Builder(context, "Toast with corner radius")
                .cornerRadius(R.dimen.corner_toast_small)
                .show();
    }

    public void toastCornerCustom() {
        new Toastyle.Builder(context, "Toast with custom corner radius")
                .cornerRadius(R.dimen.corner_toast, 0, 0, R.dimen.corner_toast)
                .border(R.dimen.toast_border_size, R.color.teal_200)
                .show();
    }

    public void toastBackground() {
        new Toastyle.Builder(context, "Toast with background color")
                .backgroundColor(R.color.purple_200)
                .show();
    }

    public void toastFont() {
        new Toastyle.Builder(context, "Toast with custom font family")
                .fontFamily(R.font.montserrat)
                .show();
    }

    public void toastBorder() {
        new Toastyle.Builder(context, "Toast with custom font family")
                .fontFamily(R.font.montserrat)
                .border(R.dimen.toast_border_size, R.color.purple_200)
                .show();
    }

    public void toastState() {
        Toastyle.success(context, "Toast success message");
    }

    public void toastPosition() {
        new Toastyle.Builder(context, "Toast change position")
                .position(Gravity.CENTER|Gravity.END)
                .show();
    }

}
