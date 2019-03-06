package com.zhaowh.travel.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zhaowh.travel.Adapter.MyPageAdapter;
import com.zhaowh.travel.Custom.MyButton;
import com.zhaowh.travel.Interface.OnMyButtonClickListener;
import com.zhaowh.travel.R;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment{

    private ViewPager viewPager;
    private List<View> viewList;
    private MyPageAdapter myPageAdapter;
    private int[] myButton = {R.id.btn_plane, R.id.btn_hospital,
                                R.id.btn_travel, R.id.btn_near_travel,
                                R.id.btn_ticket, R.id.btn_train,
                                R.id.btn_car, R.id.btn_course};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initView(view);
        return view;
    }

    private void initView(View view){
        viewList = new ArrayList<View>();
        viewList.add(getLayoutInflater().inflate(R.layout.view_pager_1, null, false));
        viewList.add(getLayoutInflater().inflate(R.layout.view_pager_2, null, false));
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        myPageAdapter = new MyPageAdapter(viewList);
        viewPager.setAdapter(myPageAdapter);

        MyButton btnPlane = (MyButton) view.findViewById(R.id.btn_plane);
        MyButton btnHospital = (MyButton) view.findViewById(R.id.btn_hospital);
        MyButton btnTravel = (MyButton) view.findViewById(R.id.btn_travel);
        MyButton btnNear_travel = (MyButton) view.findViewById(R.id.btn_near_travel);
        MyButton btnTicket = (MyButton) view.findViewById(R.id.btn_ticket);
        MyButton btnTrain = (MyButton) view.findViewById(R.id.btn_train);
        MyButton btnCar = (MyButton) view.findViewById(R.id.btn_car);
        MyButton btnCourse = (MyButton) view.findViewById(R.id.btn_course);

        btnPlane.setOnMyButtonClickListener(new OnMyButtonClickListener() {
            @Override
            public void onMyButtonClick() {
                Toast.makeText(getContext(),"1",Toast.LENGTH_SHORT).show();
            }
        });
        btnHospital.setOnMyButtonClickListener(new OnMyButtonClickListener() {
            @Override
            public void onMyButtonClick() {
                Toast.makeText(getContext(),"2",Toast.LENGTH_SHORT).show();
            }
        });
        btnTravel.setOnMyButtonClickListener(new OnMyButtonClickListener() {
            @Override
            public void onMyButtonClick() {
                Toast.makeText(getContext(),"3",Toast.LENGTH_SHORT).show();
            }
        });
        btnNear_travel.setOnMyButtonClickListener(new OnMyButtonClickListener() {
            @Override
            public void onMyButtonClick() {
                Toast.makeText(getContext(),"4",Toast.LENGTH_SHORT).show();
            }
        });
        btnTicket.setOnMyButtonClickListener(new OnMyButtonClickListener() {
            @Override
            public void onMyButtonClick() {
                Toast.makeText(getContext(),"5",Toast.LENGTH_SHORT).show();
            }
        });
        btnTrain.setOnMyButtonClickListener(new OnMyButtonClickListener() {
            @Override
            public void onMyButtonClick() {
                Toast.makeText(getContext(),"6",Toast.LENGTH_SHORT).show();
            }
        });
        btnCar.setOnMyButtonClickListener(new OnMyButtonClickListener() {
            @Override
            public void onMyButtonClick() {
                Toast.makeText(getContext(),"7",Toast.LENGTH_SHORT).show();
            }
        });
        btnCourse.setOnMyButtonClickListener(new OnMyButtonClickListener() {
            @Override
            public void onMyButtonClick() {
                Toast.makeText(getContext(),"8",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
