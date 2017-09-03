package com.example.shinelon.autodesk.AutoViewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shinelon on 2017/9/3.
 */

public class ViewPagerWithTransformer extends ViewPager {
    View mLeft;
    View mRight;
    float mTrans;
    float mScale;

    public static final float MIN_SCALE = 0.5f;
    private Map<Integer, View> mapChildren = new HashMap<Integer, View>();

    public ViewPagerWithTransformer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void AddViewByPosition(View view, int position) {
        mapChildren.put(position, view);
    }

    public void RemoveViewByPosition(int position){
        mapChildren.remove(position);
    }

    @Override
    protected void onPageScrolled(int position, float offset, int offsetPixels) {
        // positon: 0 ~ 1 ,  offset : 0 - 1, offserpixels : 0 到屏幕宽度
        Log.e("--TAG--", "positon=" + position + "offset=" + offset + "offsetPixels=" + offsetPixels);
        mLeft = mapChildren.get(position);
        mRight = mapChildren.get(position + 1);
        animTrans(mLeft, mRight, offset, offsetPixels);
        super.onPageScrolled(position, offset, offsetPixels);
    }

    public void animTrans(View left, View right, float offset, int offsetPixels) {
        if(right != null) {
            //模拟从0~1的页面大小的变化
            mScale = (1 - MIN_SCALE)*offset + MIN_SCALE;
            mTrans = - getWidth() - getPageMargin() + offsetPixels;
            //getAlpha()
            //nineoldandroid 不能用
            //ViewHelper.setScaleX(right, mScale);
           // ViewHelper.setScaleY(right, mScale);
           // ViewHelper.setTranslation(right, mTrans);

            right.setScaleX(mScale);
            right.setScaleY(mScale);
            right.setTranslationZ(mTrans);
            right.setTranslationX(mTrans);
            right.setTranslationX(mTrans);
        }
        if(left != null){
            left.bringToFront();
        }
    }
}
