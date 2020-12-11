package com.zuo.xmvvm;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.zuo.xmvvm.photowall.PhotoItemBean;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

/**
 * @author zuo
 * @filename: AppBindingAdapter
 * @date: 2020/12/11
 * @description: BindingAdapter
 * @version: V1.0
 */
public class AppBindingAdapter {

	@BindingAdapter("addView")
	public static void setAddView(ViewGroup viewGroup, String item) {
		if (viewGroup != null && item != null) {
			TextView tv = new TextView(viewGroup.getContext());
			tv.setText(item);
			tv.setTextColor(Color.WHITE);
			tv.setGravity(Gravity.CENTER);
			tv.setTextSize(14);
			tv.setBackgroundResource(R.drawable.shape_bg_flowview);
			viewGroup.addView(tv);
		}
	}

	@BindingAdapter({"urlPath"})
	public static void showImage(ImageView imageView, PhotoItemBean photoItemBean) {


		Glide.with(imageView.getContext()).asBitmap().load((photoItemBean).path).into(new CustomTarget<Bitmap>() {
			@Override
			public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
				// 模拟服务器获取到图片大小
				photoItemBean.weight = resource.getWidth();
				photoItemBean.height = resource.getHeight();

				int height = (int) (ScreenUtils.getScreenWidth() / 3 * photoItemBean.height / photoItemBean.weight);
				ViewGroup.LayoutParams para = imageView.getLayoutParams();
				para.height = height;
				para.width = ScreenUtils.getScreenWidth() / 3;
				imageView.setImageBitmap(resource);
			}

			@Override
			public void onLoadCleared(@Nullable Drawable placeholder) {

			}
		});

	}
}


