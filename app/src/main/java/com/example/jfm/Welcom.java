package com.example.jfm;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;

import java.io.File;

import cn.bmob.v3.Bmob;

public class Welcom extends MyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        Bmob.initialize(this, "614369e4118b4e9941e296f5c12a6325");
        makeDirectory(sdPath);
        Message welcomeMessage = Message.obtain();
        welcomeMessage.what = 1;
        task.sendMessageDelayed(welcomeMessage,1500);
    }
    // 生成文件夹
    public static void makeDirectory(String filePath) {
        File file = null;
        try {
            file = new File(filePath);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            Log.i("error:", e+"");
        }
    }
}
