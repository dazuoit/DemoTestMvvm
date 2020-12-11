package com.zuo.demo.lib_common.base;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yinglan.alphatabs.AlphaTabsIndicator;
import com.yinglan.alphatabs.OnTabChangedListner;
import com.zuo.demo.lib_common.base.adapter.BaseFragmentAdapter;
import com.zuo.demo.lib_common.base.adapter.BaseRecycleAdaper;
import com.zuo.demo.lib_common.glide.MyGlide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/**
 * @author zuo
 * @filename: MyBindingAdapter
 * @date: 2020/10/26
 * @description: BindingAdapter
 * @version: V1.0
 */
public class MyBindingAdapter {

	@BindingAdapter({"imageRes"})
	public static void setImageRes(ImageView imageView, int imageRes) {
		imageView.setImageResource(imageRes);
	}

	@BindingAdapter("canVisable")
	public static void setCanVisable(View view, boolean enable) {
		view.setVisibility(enable ? View.VISIBLE : View.GONE);
	}


	@BindingAdapter(value = {"isEnableRefresh", "isEnableLoadmore"}, requireAll = false)
	public static void setEnableRefreshAndLoadMore(SmartRefreshLayout view, boolean reFresh, boolean loadmore) {
		view.setEnableRefresh(reFresh);
		view.setEnableLoadMore(loadmore);
	}

	@BindingAdapter(value = {"onRefreshListener", "onLoadMoreListener"}, requireAll = false)
	public static void setSmartRefreshLayoutListener(SmartRefreshLayout view, OnRefreshListener onRefreshListener, OnLoadMoreListener onLoadMoreListener) {
		if (view != null) {
			view.setOnRefreshListener(onRefreshListener);
			view.setOnLoadMoreListener(onLoadMoreListener);
		}
	}

	@BindingAdapter("pagerAdapter")
	public static void setPagerAdapter(ViewPager2 view, BaseFragmentAdapter adapter) {
		view.setAdapter(adapter);
	}

	@BindingAdapter("viewpager2Callback")
	public static void setcallback(ViewPager2 view, ViewPager2.OnPageChangeCallback callback) {
		view.registerOnPageChangeCallback(callback);
	}

	@BindingAdapter("tabChangedListner")
	public static void setTabChangedListner(AlphaTabsIndicator alphaTabsIndicator, OnTabChangedListner onTabChangedListner) {
		LogUtils.w("setTabChangedListner", "setTabChangedListner");
		alphaTabsIndicator.setOnTabChangedListner(onTabChangedListner);
	}

	@BindingAdapter("bindViewPager")
	public static void setBindViewPager(AlphaTabsIndicator alphaTabsIndicator, int postion) {
		LogUtils.w("setBindViewPager", postion);
		if (postion < alphaTabsIndicator.getChildCount() && postion > -1) {
			alphaTabsIndicator.setTabCurrenItem(postion);
		}
	}

	@BindingAdapter("bindIndicator")
	public static void setBindIndicator(ViewPager2 view, int postion) {
		if (postion == -1) {
			return;
		}
		view.setCurrentItem(postion);
	}


	@BindingAdapter(value = {"rcAdapter", "rcLayoutManager"}, requireAll = true)
	public static void setBindRecycle(RecyclerView view, BaseRecycleAdaper adapter, RecyclerView.LayoutManager layoutManager) {
		if (view != null) {
			if (layoutManager != null) {
				view.setLayoutManager(layoutManager);
			}
			if (adapter != null) {
				view.setAdapter(adapter);
			}
		}
	}

	@BindingAdapter(value = "OnScrollListener")
	public static void setOnScrollListener(RecyclerView view, RecyclerView.OnScrollListener onScrollListener) {
		if (view != null) {
			view.addOnScrollListener(onScrollListener);
		}
	}

	@BindingAdapter(value = {"noDataMore"}, requireAll = false)
	public static void setSmarRefreshLayoutNoDataMore(SmartRefreshLayout view, boolean noDataMore) {

		if (view != null) {
			if (noDataMore) {
				view.finishLoadMoreWithNoMoreData();
			}
		}
	}

	@BindingAdapter(value = {"refreshFinish"}, requireAll = false)
	public static void setSmarRefreshLayoutRefreshFinish(SmartRefreshLayout view, boolean isRefreshFinish) {
		LogUtils.w("setSmarRefreshLayoutRefreshFinish", isRefreshFinish);
		if (view != null) {
			if (isRefreshFinish) {
				view.finishRefresh();
			}
		}
	}

	@BindingAdapter(value = {"loadmoreFinish"}, requireAll = false)
	public static void setSmarRefreshLayoutLoadmoreFinish(SmartRefreshLayout view, boolean isLoadmoreFinish) {
		if (view != null) {
			if (isLoadmoreFinish) {
				view.finishLoadMore();
			}
		}
	}



}


