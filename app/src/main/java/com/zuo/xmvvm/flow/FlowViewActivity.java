package com.zuo.xmvvm.flow;

import com.zuo.demo.lib_common.base.db.DataBindingConfig;
import com.zuo.demo.lib_common.base.model.TitleViewModel;
import com.zuo.demo.lib_common.base.ui.BaseActivity;
import com.zuo.xmvvm.BR;
import com.zuo.xmvvm.R;
import com.zuo.xmvvm.utils.DemoUtils;


/**
 * @author zuo
 * @filename: FlowViewActivity
 * @date: 2020/12/11
 * @description: FlowViewDemo
 * @version: V1.0
 */
public class FlowViewActivity extends BaseActivity<FlowViewViewModel> {
	@Override
	protected DataBindingConfig getDataBindingConfig() {
		return new DataBindingConfig(R.layout.activity_flowview, BR.viewModel);
	}

	@Override
	protected void setTitle(TitleViewModel titleViewModel) {
		super.setTitle(titleViewModel);
		titleViewModel.setLeftVisable(true)
				.setRightVisable(true)
				.setRightTvDes("AddView")
				.setTitle("FlowView");
	}

	@Override
	protected void onRightPressEvent(TitleViewModel titleViewModel) {
		getItemString();
	}

	/**
	 * 手动添加条目
	 */
	private void getItemString() {
		mViewModel.addView.setValue(DemoUtils.getRandomString());
	}

}