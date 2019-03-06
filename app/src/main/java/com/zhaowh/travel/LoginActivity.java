package com.zhaowh.travel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView tvFindPassword, tvSignIn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView(){
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        tvFindPassword = (TextView) findViewById(R.id.tv_find_password);
        tvSignIn = (TextView) findViewById(R.id.tv_sign_in);
        btnLogin.setOnClickListener(this);
        tvSignIn.setOnClickListener(this);
        tvFindPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                //登录
                break;
            case R.id.tv_find_password:
                //忘记密码
                break;
            case R.id.tv_sign_in:
                //免费注册
                Intent signIntent = new Intent(this, SignActivity.class);
                startActivity(signIntent);
                break;
            default:
                break;
        }
    }
}
