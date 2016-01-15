package com.dycloud.bannerimageslider;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

public class MainActivity extends Activity {

    private SliderLayout sliderLayout;
    private SliderLayout sliderLayout0;
    private PagerIndicator pagerIndicator;
    private PagerIndicator pagerIndicator0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //使标题栏不可见
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏显示
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderLayout = (SliderLayout) findViewById(R.id.slider);
        sliderLayout0 = (SliderLayout) findViewById(R.id.slider0);
        pagerIndicator = (PagerIndicator) findViewById(R.id.custom_indicator);
        pagerIndicator0 = (PagerIndicator) findViewById(R.id.custom_indicator0);

        intSliderView();
        sliderLayout.setCustomIndicator(pagerIndicator);
        sliderLayout.setDuration(3000);

        intSliderView0();
        sliderLayout0.setCustomIndicator(pagerIndicator0);
        sliderLayout0.setDuration(3000);

    }

    private void intSliderView0() {
        DefaultSliderView defaultSliderView0 = new DefaultSliderView(this);
        DefaultSliderView defaultSliderView1 = new DefaultSliderView(this);
        DefaultSliderView defaultSliderView2 = new DefaultSliderView(this);

        defaultSliderView0.image(R.drawable.img01);
        defaultSliderView1.image(R.drawable.img02);
        defaultSliderView2.image(R.drawable.img03);

        sliderLayout0.addSlider(defaultSliderView0);
        sliderLayout0.addSlider(defaultSliderView1);
        sliderLayout0.addSlider(defaultSliderView2);

    }

    private void intSliderView() {
        TextSliderView mTextSliderView0 = new TextSliderView(this);
        TextSliderView mTextSliderView1 = new TextSliderView(this);
        TextSliderView mTextSliderView2 = new TextSliderView(this);

        mTextSliderView0.description("one").image(R.drawable.img01);
        mTextSliderView0.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(MainActivity.this, "one", Toast.LENGTH_SHORT).show();
            }
        });
        mTextSliderView1.description("two").image(R.drawable.img02);
        mTextSliderView1.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(MainActivity.this, "two", Toast.LENGTH_SHORT).show();
            }
        });
        mTextSliderView2.description("three").image(R.drawable.img03);
        mTextSliderView2.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(MainActivity.this, "three", Toast.LENGTH_SHORT).show();
            }
        });
        sliderLayout.addSlider(mTextSliderView0);
        sliderLayout.addSlider(mTextSliderView1);
        sliderLayout.addSlider(mTextSliderView2);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //锁屏后由于activity不可见所以会调用onStop方法中的停止循环方法
        //为了解锁后继续循环，应该调用自动开始的循环
        sliderLayout.startAutoCycle();
        sliderLayout0.startAutoCycle();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //防止图片切换消耗内存，在销毁activity之前停止循环
        sliderLayout.stopAutoCycle();
        sliderLayout0.stopAutoCycle();
    }
}
