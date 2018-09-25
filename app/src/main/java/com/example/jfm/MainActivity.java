package com.example.jfm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends MyActivity {
    Button a = null;
    private long firstTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToastUtils.init(this);
        a = findViewById(R.id.button);
        a.setOnClickListener(new View.OnClickListener() {
            int i = 0;
            @Override
            public void onClick(View view) {
                ToastUtils.show("--------------" + i);
                i++;
            }
        });
    }

    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 2000) {
            ToastUtils.show("再按一次退出程序");
            firstTime = secondTime;
        } else {
            System.exit(0);
        }
    }
}
