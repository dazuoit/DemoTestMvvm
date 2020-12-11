package com.zuo.xmvvm.photowall;


import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.zuo.demo.lib_common.base.adapter.BaseRecycleAdaper;
import com.zuo.xmvvm.R;
import com.zuo.xmvvm.databinding.ListItemBinding;

import org.jetbrains.annotations.NotNull;

/**
 * @author zuo
 * @filename: DemoAdapter
 * @date: 2020/12/11
 * @description: 适配器
 * @version: V1.0
 */
public class DemoAdapter extends BaseRecycleAdaper<PhotoItemBean, ListItemBinding> {

	public DemoAdapter() {
		super(R.layout.list_item);
	}

	@Override
	protected void bindingData(@NotNull BaseDataBindingHolder<ListItemBinding> holder, PhotoItemBean itemBean, ListItemBinding listItemBinding) {
		listItemBinding.setItemPhoto(itemBean);
	}

}
