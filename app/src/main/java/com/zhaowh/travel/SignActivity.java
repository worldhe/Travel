package com.zhaowh.travel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.zhaowh.travel.Custom.MyButton;
import com.zhaowh.travel.Interface.OnMyButtonClickListener;

public class SignActivity extends AppCompatActivity {

    private MyButton myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

    }
}
