package com.zhaowh.travel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zhaowh.travel.Fragment.FindFragment;
import com.zhaowh.travel.Fragment.MainFragment;
import com.zhaowh.travel.Fragment.MeFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnNavMain;  //首页按钮
    private Button btnNavFind;  //发现页按钮
    private Button btnNavMe;    //个人信息查看按钮
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        replaceFragment(new MainFragment());
    }

    private void initView(){
        btnNavMain = (Button) findViewById(R.id.btn_nav_main);
        btnNavFind = (Button) findViewById(R.id.btn_nav_find);
        btnNavMe = (Button) findViewById(R.id.btn_nav_me);
        btnNavMain.setOnClickListener(this);
        btnNavFind.setOnClickListener(this);
        btnNavMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_nav_main:
                replaceFragment(new MainFragment());
                btnBackground(true, false, false);
                break;
            case R.id.btn_nav_find:
                replaceFragment(new FindFragment());
                btnBackground(false, true, false);
                break;
            case R.id.btn_nav_me:
                replaceFragment(new MeFragment());
                btnBackground(false, false, true);
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_fragment_layout, fragment);
        transaction.commit();

        btnBackground(true, false, false);
    }

    private void btnBackground(boolean btnMain, boolean btnFind, boolean btnMe){
        if(btnMain){
            btnNavMain.setBackgroundResource(R.mipmap.nav_main_click);
            btnNavFind.setBackgroundResource(R.mipmap.nav_find_normal);
            btnNavMe.setBackgroundResource(R.mipmap.nav_me_normal);
        }
        if(btnFind){
            btnNavMain.setBackgroundResource(R.mipmap.nav_main_normal);
            btnNavFind.setBackgroundResource(R.mipmap.nav_find_click);
            btnNavMe.setBackgroundResource(R.mipmap.nav_me_normal);
        }
        if(btnMe){
            btnNavMain.setBackgroundResource(R.mipmap.nav_main_normal);
            btnNavFind.setBackgroundResource(R.mipmap.nav_find_normal);
            btnNavMe.setBackgroundResource(R.mipmap.nav_me_click);
        }
    }
}
