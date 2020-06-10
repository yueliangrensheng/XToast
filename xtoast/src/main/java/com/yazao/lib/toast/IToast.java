package com.yazao.lib.toast;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;

public class IToast extends Toast {
    private View rootLayout = null;
    private TextView msgText;

    public IToast(Context context) {
        super(context);
        rootLayout = View.inflate(context, R.layout.xtoast_layout, null);
        setView(rootLayout);
    }

    public void setBackground(@DrawableRes int backgroundResId) {
        TextView msgText = getTextView();
        if (backgroundResId == 0) {
            backgroundResId = R.drawable.xtoast_bg;
        }
        msgText.setBackgroundResource(backgroundResId);
    }

    @Override
    public void setText(int resId) {
        TextView msgText = getTextView();
        msgText.setText(resId);
    }

    @Override
    public void setText(CharSequence s) {
        TextView msgText = getTextView();
        msgText.setText(s);
    }

    private TextView getTextView() {
        if (rootLayout == null) {
            return null;
        }
        if (msgText == null) {
            msgText = rootLayout.findViewById(R.id.xtoast_msg);
        }
        return msgText;
    }
}
