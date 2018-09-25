package com.example.jfm;

import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends MyActivity {
    EditText userName;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

    }

    private void init() {
        userName = (EditText) findViewById(R.id.et_userName);
        password = (EditText) findViewById(R.id.et_password);
        ImageView unameClear = (ImageView) findViewById(R.id.iv_unameClear);
        ImageView pwdClear = (ImageView) findViewById(R.id.iv_pwdClear);
        EditTextClearTools.addClearListener(userName, unameClear);
        EditTextClearTools.addClearListener(password, pwdClear);
        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Strname = userName.getText().toString();
                String Strpassword = password.getText().toString();
                BmobUser bu2 = new BmobUser();
                bu2.setUsername(Strname);
                bu2.setPassword(Strpassword);
                bu2.login(new SaveListener<BmobUser>() {
                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if (e == null) {
                            Message loginMessage = Message.obtain();
                            loginMessage.what = 2;
                            task.sendMessage(loginMessage);
                            ToastUtils.show("登录成功");
                        } else {
                            ToastUtils.show( "登录失败");
                        }
                    }
                });
            }
        });
    }

    public static class EditTextClearTools {
        public static void addClearListener(final EditText et, final ImageView iv) {
            et.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    //如果有输入内容长度大于0那么显示clear按钮
                    String str = s + "";
                    if (s.length() > 0) {
                        iv.setVisibility(View.VISIBLE);
                    } else {
                        iv.setVisibility(View.INVISIBLE);
                    }
                }
            });

            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    et.setText("");
                }
            });
        }

    }


}
