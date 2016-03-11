package com.kminfosystems.android.secondtask;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoViewAttacher;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private PhotoViewAttacher mAttacher;
    private Dialog dialog;
    private LayoutInflater inflater;
    private ViewPager paper;
    private List<Fragment> listData;
    private Button button1,button2,button3;
    TextView tv1,tv2,tv3,tv4,tv5,setText;
    LinearLayout LayoutColor;
    public MainActivity() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1= (Button) findViewById(R.id.button1);
        button2= (Button) findViewById(R.id.button2);
        button3= (Button) findViewById(R.id.button3);
        LayoutColor= (LinearLayout) findViewById(R.id.linerColor);
        tv1= (TextView) findViewById(R.id.tv1);
        tv2= (TextView) findViewById(R.id.tv2);
        tv3= (TextView) findViewById(R.id.tv3);
        tv4= (TextView) findViewById(R.id.tv4);
        tv5= (TextView) findViewById(R.id.tv5);

        setText= (TextView) findViewById(R.id.setText);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        listData = new ArrayList<>();
        listData.add(new TutorialPageOne().newInstance("FragmentOne"));
        listData.add(new TutorialPageTwo().newInstance("FragmentTwo"));
        listData.add(new TutorialPageThree().newInstance("FragmentThree!"));
        listData.add(new TutorialPageFour().newInstance("FragmentFour"));
        listData.add(new TutorialPageFive().newInstance("Fragment Five"));
        ViewPagerAdapder adapder = new ViewPagerAdapder(getSupportFragmentManager(), listData);
        paper = (ViewPager) findViewById(R.id.viewpager);
        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radiogroup);

        paper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        radioGroup.check(R.id.radioButton);
                        break;
                    case 1:
                        radioGroup.check(R.id.radioButton2);
                        break;
                    case 2:
                        radioGroup.check(R.id.radioButton3);
                        break;
                    case 3:
                        radioGroup.check(R.id.radioButton4);
                        break;
                    case 4:
                        radioGroup.check(R.id.radioButton5);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        paper.setAdapter(adapder);
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void onClick(View v) {

       if(v==button1){
           LayoutColor.setBackgroundColor(Color.parseColor("#960407"));
       }else if (v==button2){
           LayoutColor.setBackgroundColor(Color.parseColor("#22e486"));
       }else if(v==button3){
           LayoutColor.setBackgroundColor(Color.parseColor("#206ad1"));
       }

       else if(v==tv1){
           setText.setText(tv1.getText().toString());
       }
       else if(v==tv2){
           setText.setText(tv2.getText().toString());
       }
       else if(v==tv3){
           setText.setText(tv3.getText().toString());
       }
       else if(v==tv4){
           setText.setText(tv4.getText().toString());
       }
       else if(v==tv5){
           setText.setText(tv5.getText().toString());
       }



    }
}
