package com.erif.toastyle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.GravityInt;
import androidx.annotation.IntDef;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Toastyle {

    private Toast toast;

    private LinearLayout parentView;
    private ImageView imgLeft;
    private TextView txtMessage;
    private ImageView imgRight;
    private View marginLeft;
    private View marginRight;

    private String message;
    private int length = Toast.LENGTH_SHORT;

    @IntDef({SHORT, LONG})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Length {}
    public static final int SHORT = 0;
    public static final int LONG = 1;

    @IntDef({SPACE_LARGE, SPACE_MEDIUM, SPACE_NORMAL, SPACE_SMALL})
    @Retention(RetentionPolicy.SOURCE)
    public @interface VerticalSpace {}
    public static final int SPACE_LARGE = 0;
    public static final int SPACE_MEDIUM = 1;
    public static final int SPACE_NORMAL = 2;
    public static final int SPACE_SMALL = 3;

    private static final float SPACE_LARGE_VALUE = 0.1f;
    private static final float SPACE_MEDIUM_VALUE = 0.07f;
    private static final float SPACE_NORMAL_VALUE = 0.04f;
    private static final float SPACE_SMALL_VALUE = 0.02f;

    private float currentSpaceValue = SPACE_NORMAL_VALUE;

    public Toastyle(Context context) {
        init(context);
    }

    public Toastyle(Context context, String message) {
        this.message = message;
        init(context);
    }
    public Toastyle(Context context, @StringRes int message) {
        this.message = getString(context, message);
        init(context);
    }

    public Toastyle(Context context, String message, @Length int length) {
        this.message = message;
        this.length = length;
        init(context);
    }
    public Toastyle(Context context, @StringRes int message, @Length int length) {
        this.message = getString(context, message);
        this.length = length;
        init(context);
    }

    @SuppressLint("InflateParams")
    private void init(Context context) {
        toast = new Toast(context);
        LayoutInflater inflater = LayoutInflater.from(context);

        View layout = inflater.inflate(R.layout.qtoast_custom_layout, null, false);
        parentView = layout.findViewById(R.id.qtoast_custom_layout_parent);
        imgLeft = layout.findViewById(R.id.qtoast_custom_layout_iconLeft);
        txtMessage = layout.findViewById(R.id.qtoast_custom_layout_txtMessage);
        imgRight = layout.findViewById(R.id.qtoast_custom_layout_iconRight);
        marginLeft = layout.findViewById(R.id.qtoast_custom_layout_marginLeft);
        marginRight = layout.findViewById(R.id.qtoast_custom_layout_marginRight);

        if (message != null)
            txtMessage.setText(message);

        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 0);
       // toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.setMargin(0f, SPACE_NORMAL_VALUE);
        int duration;
        if (length == LONG) {
            duration = Toast.LENGTH_LONG;
        } else {
            duration = Toast.LENGTH_SHORT;
        }
        toast.setDuration(duration);
        toast.setView(layout);

        Drawable background = parentView.getBackground();
        if (background instanceof GradientDrawable drawable) {
            drawable.setColor(getColor(R.color.qtoast_background_color));
            drawable.setCornerRadius(0f);
            drawable.setStroke(0, 0);
            parentView.setBackground(drawable);
        }

    }

    public void length(@Length int length) {
        this.length = length;
        int duration;
        if (length == LONG) {
            duration = Toast.LENGTH_LONG;
        } else {
            duration = Toast.LENGTH_SHORT;
        }
        toast.setDuration(duration);
    }

    public void iconLeft(@DrawableRes int iconRes) {
        if (iconRes != 0) {
            imgLeft.setImageResource(iconRes);
            imgLeft.setVisibility(View.VISIBLE);
            marginLeft.setVisibility(View.GONE);
        }
    }

    public void iconRight(@DrawableRes int iconRes) {
        if (iconRes != 0) {
            imgRight.setImageResource(iconRes);
            imgRight.setVisibility(View.VISIBLE);
            marginRight.setVisibility(View.GONE);
        }
    }

    public void message(String message) {
        this.message = message;
        txtMessage.setText(message);
    }

    public void message(@StringRes int messageRes) {
        String mMessage = getString(messageRes);
        if (mMessage != null) {
            this.message = mMessage;
            txtMessage.setText(mMessage);
        }
    }

    public void textColor(@ColorRes int colorRes) {
        int color = getColor(colorRes);
        if (color != 0)
            txtMessage.setTextColor(color);
    }

    public void textSize(@DimenRes int resId) {
        int size = getDimen(resId);
        if (size > 0)
            txtMessage.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    public void fontFamily(@FontRes int fontRes) {
        Typeface typeface = getFont(fontRes);
        if (typeface != null)
            txtMessage.setTypeface(typeface);
    }

    public void iconColor(@ColorRes int colorRes) {
        int color = getColor(colorRes);
        if (color != 0) {
            imgLeft.setColorFilter(color);
            imgRight.setColorFilter(color);
        }
    }

    public void backgroundColor(@ColorRes int colorRes) {
        int color = getColor(colorRes);
        if (color != 0) {
            Drawable background = parentView.getBackground();
            if (background instanceof GradientDrawable drawable) {
                drawable.setColor(color);
                parentView.setBackground(drawable);
            }
        }
    }

    public void cornerRadius(@DimenRes int cornerRes) {
        int size = getDimen(cornerRes);
        Drawable background = parentView.getBackground();
        if (background instanceof GradientDrawable drawable) {
            drawable.setCornerRadius(size);
            parentView.setBackground(drawable);
        }
    }

    public void cornerRadius(
            @DimenRes int topLeftRes,
            @DimenRes int topRightRes,
            @DimenRes int bottomLeftRes,
            @DimenRes int bottomRightRes
    ) {
        int topLeft = getDimen(topLeftRes);
        int topRight = getDimen(topRightRes);
        int bottomLeft = getDimen(bottomLeftRes);
        int bottomRight = getDimen(bottomRightRes);
        Drawable background = parentView.getBackground();
        if (background instanceof GradientDrawable drawable) {
            float[] corners = new float[]{
                    topLeft, topLeft,
                    topRight, topRight,
                    bottomRight, bottomRight,
                    bottomLeft, bottomLeft,
            };
            drawable.setCornerRadii(corners);
            parentView.setBackground(drawable);
        }
    }

    public void border(@DimenRes int borderRes, @ColorRes int colorRes) {
        int size = getDimen(borderRes);
        if (size > 0) {
            int color = getColor(colorRes);
            if (color != 0) {
                Drawable background = parentView.getBackground();
                if (background instanceof GradientDrawable drawable) {
                    drawable.setStroke(size, color);
                    parentView.setBackground(drawable);
                }
            }
        }
    }

    public void position(@GravityInt int gravity) {
        toast.setGravity(gravity, 0, 0);
        if (gravity == (Gravity.TOP|Gravity.START)
                || gravity == (Gravity.TOP|Gravity.LEFT)
                || gravity == (Gravity.TOP|Gravity.END)
                || gravity == (Gravity.TOP|Gravity.RIGHT)
                || gravity == (Gravity.CENTER|Gravity.START)
                || gravity == (Gravity.CENTER|Gravity.LEFT)
                || gravity == (Gravity.CENTER|Gravity.END)
                || gravity == (Gravity.CENTER|Gravity.RIGHT)
                || gravity == (Gravity.BOTTOM|Gravity.START)
                || gravity == (Gravity.BOTTOM|Gravity.LEFT)
                || gravity == (Gravity.BOTTOM|Gravity.END)
                || gravity == (Gravity.BOTTOM|Gravity.RIGHT)
        ) {
            toast.setMargin(0.02f, currentSpaceValue);
        }
    }

    public void verticalSpace(@VerticalSpace int verticalSpace) {
        if (verticalSpace == SPACE_LARGE) {
            currentSpaceValue = SPACE_LARGE_VALUE;
        } else if (verticalSpace == SPACE_MEDIUM) {
            currentSpaceValue = SPACE_MEDIUM_VALUE;
        } else if (verticalSpace == SPACE_SMALL) {
            currentSpaceValue = SPACE_SMALL_VALUE;
        } else {
            currentSpaceValue = SPACE_NORMAL_VALUE;
        }
        toast.setMargin(0f, currentSpaceValue);
    }

    public void useElevation(boolean useElevation) {
        if (useElevation) {
            parentView.setElevation(getDimen(R.dimen.qtoast_elevation_size));
        }
    }

    public void show() {
        toast.show();
    }

    public void hide() {
        toast.cancel();
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

    private String getString(int id) {
        String result = null;
        try {
            result = parentView.getContext().getResources().getString(id);
        } catch (Resources.NotFoundException e) {
            log("String res not found");
        }
        return result;
    }

    private int getColor(int id) {
        int result = 0;
        try {
            result = ContextCompat.getColor(parentView.getContext(), id);
        } catch (Resources.NotFoundException e) {
            log("Color res not found");
        }
        return result;
    }

    private int getDimen(int id) {
        int result = 0;
        try {
            result = parentView.getContext().getResources().getDimensionPixelSize(id);
        } catch (Resources.NotFoundException e) {
            log("Dimen res not found");
        }
        return result;
    }

    private Typeface getFont(@FontRes int fontRes) {
        Typeface typeface = null;
        try {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
                typeface = parentView.getContext().getResources().getFont(fontRes);
            else
                typeface = ResourcesCompat.getFont(parentView.getContext(), fontRes);
        } catch (Resources.NotFoundException e) {
            log("Font resource not found");
        }
        return typeface;
    }

    private void log(String message) {
        Log.d("QToast", message);
    }

    // ======================================== STATIC METHOD ========================================
    public static void makeText(Context context, String message) {
        new Toastyle(context, message, SHORT).show();
    }
    public static void makeText(Context context, String message, @Length int duration) {
        new Toastyle(context, message, duration).show();
    }
    public static void makeText(Context context, @StringRes int message) {
        new Toastyle(context, message).show();
    }
    public static void makeText(Context context, @StringRes int message, @Length int duration) {
        new Toastyle(context, message, duration).show();
    }
    // ==================================== STATIC STATE SUCCESS ====================================
    public static void success(Context context, String message) {
        new State(context, ToastyleState.SUCCESS)
                .message(message).show();
    }
    public static void success(Context context, @StringRes int message) {
        new State(context, ToastyleState.SUCCESS)
                .message(message).show();
    }
    // ==================================== STATIC STATE FAILED ====================================
    public static void failed(Context context, String message) {
        new State(context, ToastyleState.FAILED)
                .message(message).show();
    }
    public static void failed(Context context, @StringRes int message) {
        new State(context, ToastyleState.FAILED)
                .message(message).show();
    }
    // ==================================== STATIC STATE WARNING ====================================
    public static void warning(Context context, String message) {
        new State(context, ToastyleState.WARNING)
                .message(message).show();
    }
    public static void warning(Context context, @StringRes int message) {
        new State(context, ToastyleState.WARNING)
                .message(message).show();
    }
    // ===================================== STATIC STATE INFO =====================================
    public static void info(Context context, String message) {
        new State(context, ToastyleState.INFO)
                .message(message).show();
    }
    public static void info(Context context, @StringRes int message) {
        new State(context, ToastyleState.INFO)
                .message(message).show();
    }
    // ==================================== STATIC STATE DISABLE ====================================
    public static void disable(Context context, String message) {
        new State(context, ToastyleState.DISABLE)
                .message(message).show();
    }
    public static void disable(Context context, @StringRes int message) {
        new State(context, ToastyleState.DISABLE)
                .message(message).show();
    }

    // ======================================== CHILD CLASS ========================================
    public static class State extends ToastyleState {
        public State(Context context, int state) {super(context, state);}
        public State(Context context, int length, int state) {super(context, length, state);}
    }
    public static class Builder extends ToastyleBuilder {
        public Builder(Context context) {super(context);}
        public Builder(Context context, String message) {super(context, message);}
        public Builder(Context context, int message) {super(context, message);}
        public Builder(Context context, String message, int length) {super(context, message, length);}
        public Builder(Context context, int message, int length) {super(context, message, length);}
    }

}
