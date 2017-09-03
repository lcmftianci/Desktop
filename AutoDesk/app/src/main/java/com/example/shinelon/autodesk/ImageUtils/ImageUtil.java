package com.example.shinelon.autodesk.ImageUtils;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Shinelon on 2017/9/3.
 */

public  class ImageUtil extends View{
    public ImageUtil(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public static void setScale(View view, float args){
        view.setScaleY(args);
        view.setScaleX(args);
    }

    public static void setTranslation(View view, float args){
        view.setTranslationX(args);
        view.setTranslationY(args);
        view.setTranslationZ(args);
    }
}
