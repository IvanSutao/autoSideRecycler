package demo.ivan.com.ClassifyLine;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import demo.ivan.com.LibDensityUtils;

/**
 * Copyright (C), 2018-2018, 912租房网
 * Author: 张一帆
 * Date: 2018/5/18 0018 下午 1:44
 * Description: 自定义对其方式
 */

public class DivLinearSnapHelper extends LinearSnapHelper {

    private OrientationHelper mHorizontalHelper;

    @Override
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View targetView) {
        int[] out = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            out[0] = distanceToStart(targetView, getHorizontalHelper(layoutManager));
        } else {
            out[0] = 0;
        }

        return out;
    }

    private int distanceToStart(View targetView, OrientationHelper helper) {
        //计算滑动的距离
        return helper.getDecoratedStart(targetView) - helper.getStartAfterPadding() - LibDensityUtils.dp2px(15);
    }

    @Override
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        return findStartView(layoutManager, getHorizontalHelper(layoutManager));
    }

    private View findStartView(RecyclerView.LayoutManager layoutManager,
                               OrientationHelper helper) {

        if (layoutManager instanceof LinearLayoutManager) {
            int firstChild = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            int lastChild = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            if (firstChild == RecyclerView.NO_POSITION) {
                return null;
            }
//            if (lastChild == layoutManager.getItemCount() - 1) {
//                return layoutManager.findViewByPosition(lastChild);
//            }

            View child = layoutManager.findViewByPosition(firstChild);

            // 第一个可见的view的长度 >= item 宽度（view宽度+padding+margin) / 2 并且 尾部坐标>0,则选中这个view
            if (helper.getDecoratedEnd(child) >= helper.getDecoratedMeasurement(child) / 2
                    && helper.getDecoratedEnd(child) > 0) {
                return child;
            } else {
                return layoutManager.findViewByPosition(firstChild + 1);
            }
        }

        return super.findSnapView(layoutManager);
    }

    private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        if (mHorizontalHelper == null) {
            mHorizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return mHorizontalHelper;
    }
}
