package com.example.jfm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import cn.bmob.v3.Bmob;

public class Welcom extends Activity {
Handler task = new Handler(new Handler.Callback() {
    @Override
    public boolean handleMessage(Message message) {
        Intent i = new Intent();
        i.setClass(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
        return false;
    }
});
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        Bmob.initialize(this, "614369e4118b4e9941e296f5c12a6325");
        task.sendMessageDelayed(Message.obtain(),1500);
    }

}
