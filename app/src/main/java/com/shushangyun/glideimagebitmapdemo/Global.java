package com.shushangyun.glideimagebitmapdemo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.File;




public class Global {

    public static Context sContext;
    public static float sDensity;
    public static int sScreenWidth;
    public static int sScreenHeight;


    public static void init(Context context) {
        sContext = context;
        initScreenSize();
    }

    /**
     * 获取屏幕属性，密度，宽度，高度
     */
    private static void initScreenSize() {
        DisplayMetrics dm = sContext.getResources().getDisplayMetrics();
        sDensity = dm.density;
        sScreenWidth = dm.widthPixels;
        sScreenHeight = dm.heightPixels;
    }
    /**
     * glide 加载图片(获取原图宽高适应屏幕宽高比例)
     */
    public static void displayBitmap(String imgUrl, final ImageView target) {

        Glide.with(sContext).asBitmap().load(imgUrl).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();

                ViewGroup.LayoutParams para= target.getLayoutParams();
                para.height = Global.sScreenWidth*height/width;
                para.width = Global.sScreenWidth;

                if (height > width) {
                    target.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    target.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                target.setImageBitmap(bitmap);
            }
        });
    }


}
