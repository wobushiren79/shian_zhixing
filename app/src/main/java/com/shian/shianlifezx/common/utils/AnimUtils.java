package com.shian.shianlifezx.common.utils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

/**
 * Created by zm.
 */

public class AnimUtils {
    public static void startScaleToSelf(View view, int duration, float fromX, float toX, float fromY, float toY, Animation.AnimationListener animationListener) {
        ScaleAnimation scaleAnimation = new ScaleAnimation
                (fromX, toX, fromY, toY,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(duration);
        scaleAnimation.setAnimationListener(animationListener);
        view.startAnimation(scaleAnimation);
    }

}
