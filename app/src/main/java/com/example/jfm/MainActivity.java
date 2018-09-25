package com.example.jfm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jfm.DATA.persion;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends Activity {
    Button a = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = findViewById(R.id.button);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            persion p2 = new persion();
            p2.setName("吴彦祖");
            p2.setID("610124199505162115");
            p2.setInfo("人很帅");
                p2.save(new SaveListener<String>() {
                    @Override
                    public void done(String objectId,BmobException e) {
                        if(e==null){
                            Toast.makeText(getBaseContext(),"添加数据成功，返回objectId为："+objectId,Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(getBaseContext(),"创建数据失败：" + e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }


        });

    }
}
