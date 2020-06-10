package com.yazao.lib.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. init first
        XToast.init(this);
        // 1. init perform
//        IConfig iConfig = new IConfig();
//        iConfig.backgroundResId = R.drawable.ic_launcher_background;
//        XToast.init(this, iConfig);


        findViewById(R.id.textClick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 2. use XToast component
                String message = "I'm a Toast";
                //        XToast.show(message);
                XToast.show(message, Gravity.CENTER);

                int msgResId = R.string.app_name;
                //        XToast.show(msgResId);


            }
        });


    }
}
