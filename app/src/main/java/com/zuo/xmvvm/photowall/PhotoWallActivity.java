package com.zuo.xmvvm.photowall;

import com.bumptech.glide.Glide;
import com.zuo.demo.lib_common.base.model.TitleViewModel;
import com.zuo.demo.lib_common.base.ui.BaseRecycleViewActivity;
import com.zuo.xmvvm.utils.DemoUtils;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/**
 * @author zuo
 * @filename: PhotoWallActivity
 * @date: 2020/12/11
 * @description: 瀑布流
 * @version: V1.0
 */
public class PhotoWallActivity extends BaseRecycleViewActivity<ListDemoViewModel, DemoAdapter> {
	@Override
	protected DemoAdapter createAdapter() {
		return new DemoAdapter();
	}

	@Override
	protected void setTitle(TitleViewModel titleViewModel) {
		super.setTitle(titleViewModel);
		titleViewModel.setTitle("PhotoWallActivity");
	}

	@Override
	protected RecyclerView.LayoutManager getLayoutManager() {
		/**
		 * 瀑布流
		 */
		StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
		staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
		return staggeredGridLayoutManager;
	}

	@Override
	protected void initData() {
		super.initData();
		reLoadData();
	}

	@Override
	protected void loadData(boolean isLoadMore) {
		showLoadView(null);
		finishLoadData(isLoadMore);
		if (isLoadMore) {
			mViewModel.setPage(mViewModel.getPage() + 1);
			mAdapter.addData(DemoUtils.getPhotoItemBeanData());
			if (mViewModel.getPage() > 10) {
				noMoreData();
			}
		} else {
			mAdapter.setNewInstance(DemoUtils.getPhotoItemBeanData());
		}
		hideLoadView();
	}

	public class MineOnScrollListener extends RecyclerView.OnScrollListener {
		@Override
		public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
			if (newState == RecyclerView.SCROLL_STATE_IDLE) {
				//恢复Glide加载图片
				Glide.with(PhotoWallActivity.this).resumeRequests();
			} else {
				//禁止Glide加载图片
				Glide.with(PhotoWallActivity.this).pauseRequests();
			}
		}
	}

}
