package com.zuo.xmvvm.flow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.SizeUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zuo
 * @filename: FlowViewLayout
 * @date: 2020/12/11
 * @description: FlowViewLayout For ViewGroup
 * @version: V1.0
 */
public class FlowViewLayout extends ViewGroup {
	/**
	 * 每个item横向间距
	 */
	private int mHorizontalSpacing = SizeUtils.dp2px(2);

	/**
	 * 每个item竖向间距
	 */
	private int mVerticalSpacing = SizeUtils.dp2px(8);


	/**
	 * 记录所有的行
	 */
	private List<List<View>> allLines;

	/**
	 * 记录每一行的行高，用于layout
	 */
	List<Integer> lineHeights = new ArrayList<>();


	public FlowViewLayout(Context context) {
		super(context, null, 0);

	}

	public FlowViewLayout(Context context, AttributeSet attrs) {
		super(context, attrs, 0);

	}


	public FlowViewLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initMeasureParams();
	}

	/**
	 * 初始化
	 */
	private void initMeasureParams() {
		allLines = new ArrayList<>();
		lineHeights = new ArrayList<>();
	}

	/**
	 * 测量
	 *
	 * @param widthMeasureSpec  width
	 * @param heightMeasureSpec heigth
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		initMeasureParams();
		//子View count
		int childCount = getChildCount();

		//测量子View
		int paddingLeft = getPaddingLeft();
		int paddingRight = getPaddingRight();
		int paddingTop = getPaddingTop();
		int paddingBottom = getPaddingBottom();

		List<View> lineViews = new ArrayList<>(); //一行中的所有的view
		int lineWidthUsed = 0; //单行size
		int lineHeight = 0; // 单行高

		int parentNeededWidth = 0;  // measure过程中，子View要求的父ViewGroup的宽
		int parentNeededHeight = 0; // measure过程中，子View要求的父ViewGroup的高

		int selfWidth = MeasureSpec.getSize(widthMeasureSpec);  //ViewGroup解析的宽度
		int selfHeight = MeasureSpec.getSize(heightMeasureSpec); // ViewGroup解析的高度


		for (int i = 0; i < childCount; i++) {
			View childView = getChildAt(i);
			LayoutParams childLP = childView.getLayoutParams();
			int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight,
					childLP.width);
			int childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom,
					childLP.height);
			childView.measure(childWidthMeasureSpec, childHeightMeasureSpec);

			//获取子view的宽高
			int childMesauredWidth = childView.getMeasuredWidth();
			int childMeasuredHeight = childView.getMeasuredHeight();

			//通过宽度来判断是否需要换行，通过换行后的每行的行高来获取整个viewGroup的行高
			//如果需要换行
			if (childMesauredWidth + lineWidthUsed + mHorizontalSpacing > selfWidth) {
				allLines.add(lineViews);
				lineHeights.add(lineHeight);

				//一旦换行，我们就可以判断当前行需要的宽和高了，所以此时要记录下来
				parentNeededHeight = parentNeededHeight + lineHeight + mVerticalSpacing;
				parentNeededWidth = Math.max(parentNeededWidth, lineWidthUsed + mHorizontalSpacing);

				lineViews = new ArrayList<>();
				lineWidthUsed = 0;
				lineHeight = 0;
			}
			// view 是分行layout的，所以要记录每一行有哪些view，这样可以方便layout布局
			lineViews.add(childView);
			//每行都会有自己的宽和高
			lineWidthUsed = lineWidthUsed + childMesauredWidth + mHorizontalSpacing;
			lineHeight = Math.max(lineHeight, childMeasuredHeight);

			////处理最后一行数据
			if (i == childCount - 1) {
				allLines.add(lineViews);
				lineHeights.add(lineHeight);
				parentNeededHeight = parentNeededHeight + lineHeight + mVerticalSpacing;
				parentNeededWidth = Math.max(parentNeededWidth, lineWidthUsed + mHorizontalSpacing);
			}


		}
		//根据子View的度量结果，来重新测量自己ViewGroup
		// 作为一个ViewGroup，它自己也是一个View,它的大小也需要根据它的父亲给它提供的宽高来度量
		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);

		int realWidth = (widthMode == MeasureSpec.EXACTLY) ? selfWidth : parentNeededWidth;
		int realHeight = (heightMode == MeasureSpec.EXACTLY) ? selfHeight : parentNeededHeight;

		//再自己度量
		//根据子View的度量结果，来重新度量自己ViewGroup
		setMeasuredDimension(realWidth, realHeight);

	}

	//布局
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {

		int lineCount = allLines.size();

		int curL = getPaddingLeft();
		int curT = getPaddingTop();

		for (int i = 0; i < lineCount; i++) {
			List<View> lineViews = allLines.get(i);
			// measure度量的行高
			int lineHeight = lineHeights.get(i);
			for (int j = 0; j < lineViews.size(); j++) {
				View view = lineViews.get(j);
				int left = curL;
				int top = curT;
				int right = left + view.getMeasuredWidth();
				int bottom = top + view.getMeasuredHeight();
				view.layout(left, top, right, bottom);

				curL = right + mHorizontalSpacing;
			}
			curL = getPaddingLeft();
			curT = curT + lineHeight + mVerticalSpacing;
		}

	}

}
