package com.zuo.xmvvm.main;

import com.blankj.utilcode.util.ActivityUtils;
import com.zuo.demo.lib_common.base.db.DataBindingConfig;
import com.zuo.demo.lib_common.base.model.TitleViewModel;
import com.zuo.demo.lib_common.base.ui.BaseActivity;
import com.zuo.xmvvm.BR;
import com.zuo.xmvvm.R;
import com.zuo.xmvvm.flow.FlowViewActivity;
import com.zuo.xmvvm.photowall.PhotoWallActivity;


/**
 * @author zuo
 * @filename: MainActivity
 * @date: 2020/10/21
 * @description: 描述
 * @version: V1.0
 */
public class MainActivity extends BaseActivity<MainActivityViewModel> {
	@Override
	protected DataBindingConfig getDataBindingConfig() {
		return new DataBindingConfig(R.layout.activity_main, BR.viewModel)
				.addBindingParam(BR.click, new ClickProxy());
	}

	@Override
	protected void setTitle(TitleViewModel titleViewModel) {
		super.setTitle(titleViewModel);
		titleViewModel.setLeftVisable(false)
				.setTitle("Main");
	}


	public class ClickProxy {
		/**
		 * 标签页
		 */
		public void goFlowViewActivity() {
			ActivityUtils.startActivity(FlowViewActivity.class);
		}

		/**
		 * 瀑布流
		 */
		public void goPhotoWallActivity() {
			ActivityUtils.startActivity(PhotoWallActivity.class);
		}
	}
}