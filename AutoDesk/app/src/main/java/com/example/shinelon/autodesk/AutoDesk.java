package com.example.shinelon.autodesk;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.example.shinelon.autodesk.AutoViewpager.ViewPagerWithTransformer;
import com.example.shinelon.autodesk.Transformer.RotateDownPageTransformer;
import com.example.shinelon.autodesk.Transformer.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class AutoDesk extends AppCompatActivity {
    private ViewPager mViewPager;
    //private ViewPagerWithTransformer ownPager;
    int[] mImgIds = new int[]{R.drawable.mainicon_call, R.drawable.mainicon_contact, R.drawable.mainicon_sms};
    List<ImageView> mImageView= new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);          //去掉标题栏
        setContentView(R.layout.activity_auto_desk);
        //setContentView(R.layout.activity_auto_desk_own);

        mViewPager = (ViewPager)findViewById(R.id.id_viewPager);
        //ownPager = (ViewPagerWithTransformer)findViewById(R.id.id_viewPager_own);
        mViewPager.setPageTransformer(true, new RotateDownPageTransformer());                                          ;//设置动画
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(AutoDesk.this);
                imageView.setImageResource(mImgIds[position]);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                container.addView(imageView);
                //ownPager.AddViewByPosition(imageView, position);
                mImageView.add(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mImageView.get(position));
                //ownPager.RemoveViewByPosition(position);
            }

            @Override
            public int getCount() {
                return mImgIds.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });
        startActivity(new Intent(AutoDesk.this, ImageMove.class));
    }
}
