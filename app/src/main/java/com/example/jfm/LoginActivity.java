package com.example.jfm;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;

import java.util.List;

public class LoginActivity extends MyActivity implements Rationale {
    EditText userName;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        requestPermission();
        init();
    }

    /**
     * 动态获取运行权限
     */
    private void requestPermission() {
        AndPermission.with(this)
                .permission(Permission.Group.CAMERA, Permission.Group.STORAGE)
                .rationale(this)//添加拒绝权限回调
                /**
                 * 获取权限成功
                 */
                .onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {

                    }
                })
                /**
                 * 获取权限失败
                 */
                .onDenied(new Action() {
                    @Override
                    public void onAction(List<String> data) {
                        ToastUtils.show("公安信息核查：" + "缺少必要权限，请授予全部权限");
                        LoginActivity.this.finish();
                    }
                }).start();

    }

    /**
     * 初始化控件
     */
    private void init() {
        userName = (EditText) findViewById(R.id.et_userName);
        password = (EditText) findViewById(R.id.et_password);
        ImageView unameClear = (ImageView) findViewById(R.id.iv_unameClear);
        ImageView pwdClear = (ImageView) findViewById(R.id.iv_pwdClear);
        EditTextClearTools.addClearListener(userName, unameClear);
        EditTextClearTools.addClearListener(password, pwdClear);
        Button btn_login = findViewById(R.id.btn_login);
//        btn_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String Strname = userName.getText().toString();
//                String Strpassword = password.getText().toString();
//                BmobUser bu2 = new BmobUser();
//                bu2.setUsername("123456");
//                bu2.setPassword("123456");
//                bu2.login(new SaveListener<BmobUser>() {
//                    @Override
//                    public void done(BmobUser bmobUser, BmobException e) {
//                        if (e == null) {
//                            Message loginMessage = Message.obtain();
//                            loginMessage.what = 2;
//                            task.sendMessage(loginMessage);
//                            show("登录成功");
//                        } else {
//                            show( "登录失败"+e.toString());
//                        }
//                    }
//                });
//            }
//        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPermission();
            }
        });
    }

    /**
     * 权限拒绝后调用
     */
    @Override
    public void showRationale(Context context, List<String> data, final RequestExecutor executor) {
        String message = "请授权软件运行必要权限";
        new android.app.AlertDialog.Builder(context)
                .setCancelable(false)
                .setTitle("系统提示")
                .setMessage(message)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        executor.execute();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        executor.cancel();
                    }
                })
                .show();
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    /**
     * EditText控件内容感知
     */
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
