package com.wf.circledialog.res.drawable;

import android.graphics.drawable.ShapeDrawable;

/**
 * 圆角
 * Created by wangpf on 2017/7/15.
 */
public class CircleDrawable extends ShapeDrawable {

    public CircleDrawable(int backgroundColor, int radius) {
        this(backgroundColor, radius, radius, radius, radius);
    }

    public CircleDrawable(int backgroundColor, int leftTopRadius, int rightTopRadius
            , int rightBottomRadius, int leftBottomRadius) {
        getPaint().setColor(backgroundColor);//内部填充颜色
        //圆角半径
        setShape(DrawableHelper.getRoundRectShape(leftTopRadius, rightTopRadius, rightBottomRadius, leftBottomRadius));
    }

}
