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

    private MainFragment mainFragment = new MainFragment();
    private FindFragment findFragment = new FindFragment();
    private MeFragment meFragment = new MeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
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
                FragmentTransaction main = getSupportFragmentManager().beginTransaction();
                main.show(mainFragment);
                main.hide(findFragment);
                main.hide(meFragment);
                main.commit();
                btnBackground(true, false, false);
                break;
            case R.id.btn_nav_find:
                FragmentTransaction find = getSupportFragmentManager().beginTransaction();
                find.hide(mainFragment);
                find.show(findFragment);
                find.hide(meFragment);
                find.commit();
                btnBackground(false, true, false);
                break;
            case R.id.btn_nav_me:
                FragmentTransaction me = getSupportFragmentManager().beginTransaction();
                me.hide(mainFragment);
                me.hide(findFragment);
                me.show(meFragment);
                me.commit();
                btnBackground(false, false, true);
                break;
            default:
                break;
        }
    }

    private void initFragment(){
        FragmentManager addMamager = getSupportFragmentManager();
        FragmentTransaction addTransaction = addMamager.beginTransaction();
        addTransaction.add(R.id.content_fragment_layout, mainFragment);
        addTransaction.add(R.id.content_fragment_layout, findFragment);
        addTransaction.add(R.id.content_fragment_layout, meFragment);
        addTransaction.hide(findFragment);
        addTransaction.hide(meFragment);
        addTransaction.commit();
        btnNavMain.setBackgroundResource(R.mipmap.nav_main_click);
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
