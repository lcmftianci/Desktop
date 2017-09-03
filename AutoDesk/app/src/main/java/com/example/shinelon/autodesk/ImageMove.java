package com.example.shinelon.autodesk;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.shinelon.autodesk.ImageUtils.ImageUtil;

/**
 * Created by Shinelon on 2017/9/3.
 */

public class ImageMove extends Activity implements View.OnClickListener{

    private Button btnLeft;
    private Button btnRight;
    private Button btnTop;
    private Button btnBottom;
    private ImageView mImageView;

    private View header_logo;
    private float moveDistanceY = 25;// logo初始移动距离为10
    private float moveDistanceX = 25;// logo初始移动距离为10
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_move);

        mImageView = (ImageView)findViewById(R.id.id_image);

        btnLeft = (Button)findViewById(R.id.id_left);
        btnRight = (Button)findViewById(R.id.id_right);
        btnTop = (Button)findViewById(R.id.id_top);
        btnBottom = (Button)findViewById(R.id.id_bottom);

        btnBottom.setOnClickListener(this);
        btnTop.setOnClickListener(this);
        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_bottom :
                moveDistanceY += 20;
                mImageView.setTranslationY(moveDistanceY);
                break;

            case R.id.id_top :
                moveDistanceY -= 20;
                mImageView.setTranslationY(moveDistanceY);
                break;

            case R.id.id_left :
                moveDistanceX -= 20;
                mImageView.setTranslationX(moveDistanceX);
                break;

            case R.id.id_right :
                moveDistanceX += 20;
                mImageView.setTranslationX(moveDistanceX);
                break;
            default :
                break;
        }
    }
}
