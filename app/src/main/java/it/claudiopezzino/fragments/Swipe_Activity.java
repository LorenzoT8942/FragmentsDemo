package it.claudiopezzino.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class Swipe_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        ViewPager vp=findViewById(R.id.viewPager);
        PageAdapter pA = new PageAdapter(getSupportFragmentManager());
        vp.setAdapter(pA);
        vp.setPageTransformer(true, new DepthPageTransformer());


        TabLayout tL=findViewById(R.id.sliding_tabs);
        tL.setupWithViewPager(vp);

    }
}
