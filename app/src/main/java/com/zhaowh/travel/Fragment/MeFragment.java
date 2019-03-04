package com.zhaowh.travel.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.zhaowh.travel.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ImageButton ibLogin;
    private TextView tvCoupon, tvCard, tvCar;
    private ListView lvSetting;
    private Map<String, Object> map;
    private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    private SimpleAdapter simpleAdapter = null;
    private int[] i;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        initView(view);
        initAdapter();
        return view;
    }

    private void initView(View view){
        ibLogin = (ImageButton) view.findViewById(R.id.ib_login);
        tvCoupon = (TextView) view.findViewById(R.id.tv_coupon);
        tvCard = (TextView) view.findViewById(R.id.tv_card);
        tvCar = (TextView) view.findViewById(R.id.tv_car);
        lvSetting = (ListView) view.findViewById(R.id.lv_setting);
        ibLogin.setOnClickListener(this);
        tvCoupon.setOnClickListener(this);
        tvCard.setOnClickListener(this);
        tvCar.setOnClickListener(this);
        lvSetting.setOnItemClickListener(this);
    }

    private void initAdapter(){
        String[] itemIconName = getResources().getStringArray(R.array.fragment_me_setting_icon_name);
        String[] itemTitle = getResources().getStringArray(R.array.fragment_me_setting_string);
        for(int i = 0; i < itemIconName.length; i++){
            map = new HashMap<>();
            map.put("icon",getResources().getIdentifier(itemIconName[i], "mipmap", getContext().getPackageName()));
            map.put("title",itemTitle[i]);
            list.add(map);
        }
        simpleAdapter = new SimpleAdapter(getContext(), list, R.layout.fragment_me_setting_item,
                new String[]{"icon", "title"},
                new int[]{R.id.iv_left_icon, R.id.tv_right_text});
        lvSetting.setAdapter(simpleAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_login:
                //登录
                allToast("登录");
                break;
            case R.id.tv_coupon:
                //优惠券
                allToast("优惠券");
                break;
            case R.id.tv_card:
                //折扣卡
                allToast("折扣卡");
                break;
            case R.id.tv_car:
                //购物车
                allToast("购物车");
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                allToast("我的订单");
                break;
            case 1:
                allToast("我的收藏");
                break;
            case 2:
                allToast("我的口令");
                break;
            case 3:
                allToast("我的锦囊");
                break;
            case 4:
                allToast("安全中心");
                break;
            default:
                break;
        }
    }

    private void allToast(String content){

        Toast.makeText(getContext(), content, Toast.LENGTH_SHORT).show();
    }
}
