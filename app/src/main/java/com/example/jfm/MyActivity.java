package com.example.jfm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;

/**
 * Created by 吴彦祖 on 2018/9/25.
 */

class MyActivity extends Activity {
    String sdPath = Environment.getExternalStorageDirectory().toString() + "/Police";
    String deBugLog = "jfm--->";
    Handler task = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            Intent i = new Intent();
            switch (message.what) {
                /**
                 * Welcome message
                 */
                case 1:
                    i.setClass(getApplicationContext(), LoginActivity.class);
                    startActivity(i);
                    finish();
                    break;
                /**
                 * Login message
                 */
                case 2:
                    i.setClass(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ToastUtils.init(this);
    }

}
