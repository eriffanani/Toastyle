package com.erif.toastyle;

import android.content.Context;

import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.GravityInt;
import androidx.annotation.IntDef;
import androidx.annotation.StringRes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ToastyleState {

    private final Toastyle toast;

    @IntDef({SUCCESS, FAILED, WARNING, INFO, DISABLE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface States {}
    public static final int SUCCESS = 0;
    public static final int FAILED = 1;
    public static final int WARNING = 2;
    public static final int INFO = 3;
    public static final int DISABLE = 4;

    private final int currentState;

    public ToastyleState(Context context, @States int state) {
        this.currentState = state;
        toast = new Toastyle(context);
        init();
    }
    public ToastyleState(Context context, @Toastyle.Length int length, @States int state) {
        toast = new Toastyle(context, length);
        this.currentState = state;
        init();
    }

    private void init() {
        toast.useElevation(true);
        if (currentState == SUCCESS) {
            toast.backgroundColor(R.color.qtoast_state_success_background);
            toast.textColor(R.color.qtoast_color_black);
            toast.iconColor(R.color.qtoast_state_success_icon);
            toast.cornerRadius(R.dimen.qtoast_corner_radius);
        } else if (currentState == FAILED) {
            toast.backgroundColor(R.color.qtoast_state_failed_background);
            toast.textColor(R.color.qtoast_color_black);
            toast.iconColor(R.color.qtoast_state_failed_icon);
            toast.cornerRadius(R.dimen.qtoast_corner_radius);
        } else if (currentState == WARNING) {
            toast.backgroundColor(R.color.qtoast_state_warning_background);
            toast.textColor(R.color.qtoast_color_black);
            toast.iconColor(R.color.qtoast_state_warning_icon);
            toast.cornerRadius(R.dimen.qtoast_corner_radius);
        } else if (currentState == INFO) {
            toast.backgroundColor(R.color.qtoast_state_info_background);
            toast.textColor(R.color.qtoast_color_black);
            toast.iconColor(R.color.qtoast_state_info_icon);
            toast.cornerRadius(R.dimen.qtoast_corner_radius);
        } else if (currentState == DISABLE) {
            toast.backgroundColor(R.color.qtoast_state_disable_background);
            toast.textColor(R.color.qtoast_color_black);
            toast.iconColor(R.color.qtoast_state_disable_icon);
            toast.cornerRadius(R.dimen.qtoast_corner_radius);
        }
    }

    public ToastyleState message(String message) {
        toast.message(message);
        return this;
    }

    public ToastyleState message(@StringRes int message) {
        toast.message(message);
        return this;
    }

    public ToastyleState iconLeft(@DrawableRes int iconRes) {
        toast.iconLeft(iconRes);
        return this;
    }

    public ToastyleState iconRight(@DrawableRes int iconRes) {
        toast.iconRight(iconRes);
        return this;
    }

    public ToastyleState cornerRadius(@DimenRes int cornerRes) {
        toast.cornerRadius(cornerRes);
        return this;
    }

    public ToastyleState cornerRadius(
            @DimenRes int topLeftRes,
            @DimenRes int topRightRes,
            @DimenRes int bottomLeftRes,
            @DimenRes int bottomRightRes
    ) {
        toast.cornerRadius(
            topLeftRes, topRightRes,
            bottomLeftRes, bottomRightRes
        );
        return this;
    }

    public ToastyleState position(@GravityInt int gravity) {
        toast.position(gravity);
        return this;
    }

    public ToastyleState verticalSpace(@Toastyle.VerticalSpace int verticalSpace) {
        toast.verticalSpace(verticalSpace);
        return this;
    }

    public ToastyleState useElevation(boolean useElevation) {
        toast.useElevation(useElevation);
        return this;
    }

    public ToastyleState border(@DimenRes int size) {
        int color = R.color.qtoast_state_success_border;
        if (currentState == FAILED) {
            color = R.color.qtoast_state_failed_border;
        } else if (currentState == WARNING) {
            color = R.color.qtoast_state_warning_border;
        } else if (currentState == INFO) {
            color = R.color.qtoast_state_info_border;
        } else if (currentState == DISABLE) {
            color = R.color.qtoast_state_disable_border;
        }
        toast.border(size, color);
        return this;
    }

    public void show() {
        toast.show();
    }

    public void hide() {
        toast.hide();
    }

}
