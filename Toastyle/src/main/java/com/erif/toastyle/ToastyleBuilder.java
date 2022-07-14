package com.erif.toastyle;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.GravityInt;
import androidx.annotation.StringRes;

public class ToastyleBuilder {

    private final Toastyle toast;

    public ToastyleBuilder(Context context) {
        toast = new Toastyle(context, null);
    }

    public ToastyleBuilder(Context context, String message) {
        toast = new Toastyle(context, message);
    }
    public ToastyleBuilder(Context context, @StringRes int message) {
        toast = new Toastyle(context, message);
    }

    public ToastyleBuilder(Context context, String message, @Toastyle.Length int length) {
        toast = new Toastyle(context, message, length);
    }
    public ToastyleBuilder(Context context, @StringRes int message, @Toastyle.Length int length) {
        toast = new Toastyle(context, message, length);
    }

    public ToastyleBuilder length(@Toastyle.Length int length) {
        toast.length(length);
        return this;
    }

    public ToastyleBuilder iconLeft(@DrawableRes int iconRes) {
        toast.iconLeft(iconRes);
        return this;
    }

    public ToastyleBuilder iconRight(@DrawableRes int iconRes) {
        toast.iconRight(iconRes);
        return this;
    }

    public ToastyleBuilder message(String message) {
        toast.message(message);
        return this;
    }

    public ToastyleBuilder message(@StringRes int messageRes) {
        toast.message(messageRes);
        return this;
    }

    public ToastyleBuilder textColor(@ColorRes int colorRes) {
        toast.textColor(colorRes);
        return this;
    }

    public ToastyleBuilder textSize(@DimenRes int resId) {
        toast.textSize(resId);
        return this;
    }

    public ToastyleBuilder fontFamily(@FontRes int fontRes) {
        toast.fontFamily(fontRes);
        return this;
    }

    public ToastyleBuilder iconColor(@ColorRes int colorRes) {
        toast.iconColor(colorRes);
        return this;
    }

    public ToastyleBuilder backgroundColor(@ColorRes int colorRes) {
        toast.backgroundColor(colorRes);
        return this;
    }

    public ToastyleBuilder cornerRadius(@DimenRes int cornerRes) {
        toast.cornerRadius(cornerRes);
        return this;
    }

    public ToastyleBuilder cornerRadius(
            @DimenRes int topLeftRes,
            @DimenRes int topRightRes,
            @DimenRes int bottomLeftRes,
            @DimenRes int bottomRightRes
    ) {
        toast.cornerRadius(topLeftRes, topRightRes, bottomLeftRes, bottomRightRes);
        return this;
    }

    public ToastyleBuilder border(@DimenRes int borderRes, @ColorRes int colorRes) {
        toast.border(borderRes, colorRes);
        return this;
    }

    public ToastyleBuilder position(@GravityInt int gravity) {
        toast.position(gravity);
        return this;
    }

    public ToastyleBuilder verticalSpace(@Toastyle.VerticalSpace int verticalSpace) {
        toast.verticalSpace(verticalSpace);
        return this;
    }

    public ToastyleBuilder useElevation(boolean useElevation) {
        toast.useElevation(useElevation);
        return this;
    }

    public void show() {
        toast.show();
    }

    public void hide() {
        toast.hide();
    }

    private static String getString(Context context, int id) {
        String result = null;
        try {
            result = context.getResources().getString(id);
        } catch (Resources.NotFoundException e) {
            Log.d("QToast", "String res not found");
        }
        return result;
    }

}
