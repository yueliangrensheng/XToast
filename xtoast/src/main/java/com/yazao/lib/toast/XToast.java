package com.yazao.lib.toast;

import android.content.Context;
import android.os.Looper;
import android.view.Gravity;
import android.widget.Toast;

import androidx.annotation.StringRes;


public final class XToast {

    private static final int DEFAULT_GRAVITY = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
    private static Context mApplicationContext;
    private static IToast mToast;
    private static IConfig iConfig;


    public static void init(Context context) {
        mApplicationContext = context.getApplicationContext();
    }

    public static void init(Context context, IConfig config) {
        mApplicationContext = context.getApplicationContext();
        if (config != null) {
            iConfig = config;
        }
    }

    private static void initToastView() {
        if (mToast == null) {
            mToast = new IToast(mApplicationContext);

            if (iConfig == null) {
                return;
            }

            int backgroundResId = iConfig.backgroundResId;
            mToast.setBackground(backgroundResId);
        }
    }

    public static void show(String msg) {
        show(msg, Toast.LENGTH_SHORT, DEFAULT_GRAVITY);
    }

    public static void show(String msg, int gravity) {
        show(msg, Toast.LENGTH_SHORT, gravity);
    }

    public static void show(@StringRes int resId) {
        show(resId, Toast.LENGTH_SHORT, DEFAULT_GRAVITY);
    }

    public static void show(@StringRes int resId, int gravity) {
        show(resId, Toast.LENGTH_SHORT, gravity);
    }

    public static void showLong(String msg) {
        show(msg, Toast.LENGTH_LONG, DEFAULT_GRAVITY);
    }

    public static void showLong(@StringRes int resId, int gravity) {
        show(resId, Toast.LENGTH_LONG, gravity);
    }

    public static void showLong(@StringRes int resId) {
        show(resId, Toast.LENGTH_LONG, DEFAULT_GRAVITY);
    }

    public static void showLong(String msg, int gravity) {
        show(msg, Toast.LENGTH_LONG, gravity);
    }

    private static synchronized void show(String msg, int duration, int gravity) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (mApplicationContext == null) {
            throw new RuntimeException("please init() first");
        }
        if (mToast == null) {
            initToastView();
        }
        // X轴偏移0个单位，Y轴偏移70个单位
        mToast.setGravity(gravity, 0, 70);
        mToast.setDuration(duration);
        mToast.setText(msg);
        mToast.show();
        Looper.loop();
    }

    private static synchronized void show(@StringRes int resId, int duration, int gravity) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (mApplicationContext == null) {
            throw new RuntimeException("please init() first");
        }
        if (mToast == null) {
            initToastView();
        }
        // X轴偏移0个单位，Y轴偏移70个单位
        mToast.setGravity(gravity, 0, 70);
        mToast.setDuration(duration);
        mToast.setText(resId);
        mToast.show();
        Looper.loop();
    }
}
