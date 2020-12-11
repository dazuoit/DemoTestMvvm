package com.zuo.xmvvm.utils;

import com.zuo.xmvvm.photowall.PhotoItemBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Zuo
 * @filename: DemoUtils
 * @date: 2020/12/10
 * @description: DemoUtils
 * @version: 1.0.0
 */
public class DemoUtils {

	public final static String[] arr = {"http://www.baidu.com/img/bdlogo.png",
			"http://rongcloud-web.qiniudn.com/docs_demo_rongcloud_logo.png",
			"http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg",
			"http://h.hiphotos.baidu.com/image/pic/item/7c1ed21b0ef41bd5f2c2a9e953da81cb39db3d1d.jpg",
			"http://g.hiphotos.baidu.com/image/pic/item/55e736d12f2eb938d5277fd5d0628535e5dd6f4a.jpg",
			"http://e.hiphotos.baidu.com/image/pic/item/4e4a20a4462309f7e41f5cfe760e0cf3d6cad6ee.jpg",
			"http://g.hiphotos.baidu.com/image/pic/item/6d81800a19d8bc3e770bd00d868ba61ea9d345f2.jpg",
			"http://b.hiphotos.baidu.com/image/pic/item/e824b899a9014c08878b2c4c0e7b02087af4f4a3.jpg",
			"http://www.baidu.com/img/bdlogo.png",
			"http://rongcloud-web.qiniudn.com/docs_demo_rongcloud_logo.png",
			"http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg",
			"http://h.hiphotos.baidu.com/image/pic/item/7c1ed21b0ef41bd5f2c2a9e953da81cb39db3d1d.jpg",
			"http://g.hiphotos.baidu.com/image/pic/item/55e736d12f2eb938d5277fd5d0628535e5dd6f4a.jpg",
			"http://e.hiphotos.baidu.com/image/pic/item/4e4a20a4462309f7e41f5cfe760e0cf3d6cad6ee.jpg",
			"http://g.hiphotos.baidu.com/image/pic/item/6d81800a19d8bc3e770bd00d868ba61ea9d345f2.jpg",
			"http://b.hiphotos.baidu.com/image/pic/item/e824b899a9014c08878b2c4c0e7b02087af4f4a3.jpg",
	};


	/**
	 * 随机字符串
	 * @return
	 */
	public static String getRandomString() {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < random.nextInt(20) + 1; i++) {
			int number = random.nextInt(str.length());
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}


	/**
	 * 图片列表
	 * @return
	 */
	public static List<PhotoItemBean> getPhotoItemBeanData() {
		List<PhotoItemBean> data = new ArrayList<PhotoItemBean>();
		for (int i = 0; i < arr.length; i++) {
			PhotoItemBean photoItemBean = new PhotoItemBean();
			photoItemBean.path = arr[i];
			data.add(photoItemBean);
		}
		return data;
	}
}
