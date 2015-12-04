package com.xc.xcloadingview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

/**
 * Created by caizhiming on 2015/12/4.
 */
public class XCLoadingView extends RelativeLayout{
    private View mInnerView;
    private View mDotBlueView;
    private View mDotGrayView;
    public XCLoadingView(Context context) {
        super(context);
        init(context);
    }
    public XCLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    public XCLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context) {
        mInnerView = LayoutInflater.from(context).inflate(R.layout.layout_loading, this);
        mDotBlueView = mInnerView.findViewById(R.id.iv_blue);
        mDotGrayView = mInnerView.findViewById(R.id.iv_gray);
        playAnimation();
    }

    private void playAnimation() {
        ScaleAnimation animation = new ScaleAnimation(1.0f,0.75f,1.0f,0.75f
        , Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setDuration(600);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(Animation.INFINITE);
        mDotBlueView.startAnimation(animation);

        ScaleAnimation animation2 = new ScaleAnimation(0.75f,1.0f,0.75f,1.0f
                , Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation2.setDuration(600);
        animation2.setRepeatMode(Animation.REVERSE);
        animation2.setRepeatCount(Animation.INFINITE);
        mDotGrayView.startAnimation(animation2);
    }
}
