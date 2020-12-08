package com.example.img;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

public class ImgUtils {
    //TODO 设置String url
    //默认设置图片
    public static void ImgDefault(Context context, String url, ImageView imagegview) {
        Glide
                .with(context)
                .load(url)
                .transform(new CenterCrop())
                .into(imagegview);
    }

    //园形图片
    public static void ImgCircle(Context context, String url, ImageView imagegview) {
        Glide
                .with(context)
                .load(url)
                .transform(new CenterCrop(), new CircleCrop())
                .into(imagegview);
    }

    //默认圆角20图片
    public static void imgDefaultRound(Context context, String url, ImageView imagegview) {
        Glide
                .with(context)
                .load(url)
                .transform(new CenterCrop(), new RoundedCorners(20))
                .into(imagegview);
    }

    //自定圆角度数图片
    public static void imgRound(Context context, String url, ImageView imagegview, int limit) {
        Glide
                .with(context)
                .load(url)
                .transform(new CenterCrop(), new RoundedCorners(limit))
                .into(imagegview);
    }

    //TODO 设置String uri

    public static void ImgUriDefault(Context context, Uri uri, ImageView imagegview) {
        Glide
                .with(context)
                .load(uri)
                .transform(new CenterCrop())
                .into(imagegview);
    }

    //园形图片
    public static void ImgUriCircle(Context context, Uri uri, ImageView imagegview) {
        Glide
                .with(context)
                .load(uri)
                .transform(new CenterCrop(), new CircleCrop())
                .into(imagegview);
    }

    //默认圆角20图片
    public static void imgUriDefaultRound(Context context, Uri uri, ImageView imagegview) {
        Glide
                .with(context)
                .load(uri)
                .transform(new CenterCrop(), new RoundedCorners(20))
                .into(imagegview);
    }

    //自定圆角度数图片
    public static void imgUriRound(Context context, Uri uri, ImageView imagegview, int limit) {
        Glide
                .with(context)
                .load(uri)
                .transform(new CenterCrop(), new RoundedCorners(limit))
                .into(imagegview);
    }
}
