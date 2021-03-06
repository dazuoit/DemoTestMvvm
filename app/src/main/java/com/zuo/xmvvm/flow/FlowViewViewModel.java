/*
 * Copyright 2018-2020 KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zuo.xmvvm.flow;


import com.zuo.demo.lib_common.base.model.BaseViewModel;

import androidx.lifecycle.MutableLiveData;

/**
 * @author zuo
 * @filename: FlowViewViewModel
 * @date: 2020/12/11
 * @description: FlowViewViewModel
 * @version: V1.0
 */
public class FlowViewViewModel extends BaseViewModel {

	public final MutableLiveData<String> addView = new MutableLiveData();


}
