package com.example.jfm;

import android.os.Bundle;
import android.os.Message;

import cn.bmob.v3.Bmob;

public class Welcom extends MyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        Bmob.initialize(this, "614369e4118b4e9941e296f5c12a6325");
        Message welcomeMessage = Message.obtain();
        welcomeMessage.what = 1;
        task.sendMessageDelayed(welcomeMessage,1500);
    }

}
