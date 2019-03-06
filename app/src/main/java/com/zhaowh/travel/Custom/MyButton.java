package com.zhaowh.travel.Custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhaowh.travel.Interface.OnMyButtonClickListener;
import com.zhaowh.travel.R;

public class MyButton extends RelativeLayout {
    private Drawable mIconBackground;
    private String mIconText;
    private int mIconTextColor;
    private float mIconTextSize;

    private ImageButton mImageButton;
    private TextView mTextView;

    private LayoutParams mImageLayoutParams;
    private LayoutParams mTextViewParams;

    private OnMyButtonClickListener myButtonClickListener;

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.main_fragment_button, this, true);
        mImageButton = (ImageButton) findViewById(R.id.ib_button);
        mTextView = (TextView) findViewById(R.id.tv_button);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MainFragmentButton);
        mIconBackground = ta.getDrawable(R.styleable.MainFragmentButton_iconBackground);
        mIconText = ta.getString(R.styleable.MainFragmentButton_iconText);
        mIconTextColor = ta.getColor(R.styleable.MainFragmentButton_iconTextColor,0);
        mIconTextSize = ta.getDimension(R.styleable.MainFragmentButton_iconTextSize, 10);

        mImageButton.setBackground(mIconBackground);
        mTextView.setText(mIconText);
        mTextView.setTextColor(mIconTextColor);
        mTextView.setTextSize(mIconTextSize);

        mImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                myButtonClickListener.onMyButtonClick();
            }
        });

        ta.recycle();
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setOnMyButtonClickListener(OnMyButtonClickListener myButtonClickListener){
        this.myButtonClickListener = myButtonClickListener;
    }

}
