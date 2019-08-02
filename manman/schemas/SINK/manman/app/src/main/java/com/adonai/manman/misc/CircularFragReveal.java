package com.adonai.manman.misc;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.DecelerateInterpolator;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Tin Megali on 21/02/16.
 * https://github.com/tinmegali
 *
 * based on https://gist.github.com/ferdy182/d9b3525aa65b5b4c468a
 *
 * Add a Reveal/UnReveal circular transition animation effect to a fragment.
 * It's possible to personalize:
 *  - BG color {@linkplain Builder#setRevealColor(int)}
 *  - Animation time {@linkplain Builder#setRevealTime(int)} {@linkplain Builder#setUnrevealTime(int)}
 *  - Interpolator {@linkplain Builder#setRevelInt(TimeInterpolator)} {@linkplain Builder#setUnrevealInt(TimeInterpolator)}
 *  - Choose to use or not a onTouch un reveal {@linkplain Builder#setOnToouchUnreveal(boolean)}
 *
 * Using:
 *  1 - Build and personalize an instance using
 *      {@link Builder}
 *  2 - To begin revealing
 *      {@linkplain #startReveal(int, int, OnCircularReveal)}
 *  3 - To terminate
 *      {@linkplain #startUnreveal(int, int, OnCircularReveal)}
 *  4 - Events will be sent using
 *      {@link OnCircularReveal}
 *
 *  IMPORTANT: CircularFragReveal won't exclude the fragment.
 *      You'll need to call this action after the animation ends
 *      using it's events
 *      {@link OnCircularReveal#onFragCircRevealStart()}
 *      {@link OnCircularReveal#onFragCircRevealEnded()}
 *      {@link OnCircularReveal#onFragCircUnRevealStart()}
 *      {@link OnCircularReveal#onFragCircUnRevealEnded()}
 *
 */
public class CircularFragReveal {

    final String dataLeAk350 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk349 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk348 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk331 = "";

	String dataLeAk330 = "";

	String dataLeAk328 = "";

	String dataLeAk327 = "";

	String dataLeAk326 = "";

	String dataLeAk324 = "";

	String dataLeAk308 = "";

	String dataLeAk307 = "";

	String dataLeAk306 = "";

	String dataLeAk305 = "";

	String dataLeAk304 = "";

	String dataLeAk303 = "";

	String dataLeAk302 = "";

	private static final String TAG = CircularFragReveal.class.getSimpleName();

    private int mRevealDuration;
    private int mUnrevealDuration;
    private TimeInterpolator mRevealInterpolator, mUnrevealInterpolator;
    private Animator mRevealAnimator;
    private Animator mUnrevealAnimator;

    private WeakReference<View> mRootView;
    private int mRevealColor;
    private boolean mUseOnTouchUnreveal;
    private boolean mIsRevealing, mIsUnrevealing;


    private WeakReference<OnCircularReveal> mCallback;

    public interface OnCircularReveal {
        void onFragCircRevealStart();
        void onFragCircRevealEnded();
        void onFragCircUnRevealStart();
        void onFragCircUnRevealEnded();

    }

    /**
     * Constructor
     * Uses a Builder
     */
    private CircularFragReveal(Builder builder) {
        dataLeAk302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-302-0", dataLeAk302);
		android.util.Log.d("leak-303-0", dataLeAk303);
		android.util.Log.d("leak-304-0", dataLeAk304);
		android.util.Log.d("leak-305-0", dataLeAk305);
		android.util.Log.d("leak-306-0", dataLeAk306);
		android.util.Log.d("leak-307-0", dataLeAk307);
		android.util.Log.d("leak-308-0", dataLeAk308);
		android.util.Log.d("leak-324-0", dataLeAk324);
		android.util.Log.d("leak-326-0", dataLeAk326);
		android.util.Log.d("leak-327-0", dataLeAk327);
		android.util.Log.d("leak-328-0", dataLeAk328);
		android.util.Log.d("leak-330-0", dataLeAk330);
		android.util.Log.d("leak-331-0", dataLeAk331);
		mRootView = new WeakReference<>(builder.getRootView());
        mRevealDuration = builder.getREVEAL_DURATION();
        mUnrevealDuration = builder.getUNREVEAL_DURATION();
        mRevealInterpolator = builder.getRevealInterpolator();
        mUnrevealInterpolator = builder.getUnrevealInterpolator();
        mRevealColor = builder.getRevealBgColor();
        mUseOnTouchUnreveal = builder.isTouchUnreveal();
    }

    /**
     * Start Circular unReveal animation
     *
     * @param centerX       Animation Center X
     * @param centerY       Animation Center Y
     * @param listener Unreveal listener
     */
    public void startReveal(int centerX, int centerY, @NonNull OnCircularReveal listener) {
        dataLeAk303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-302-1", dataLeAk302);
		android.util.Log.d("leak-303-1", dataLeAk303);
		android.util.Log.d("leak-304-1", dataLeAk304);
		android.util.Log.d("leak-305-1", dataLeAk305);
		android.util.Log.d("leak-306-1", dataLeAk306);
		android.util.Log.d("leak-307-1", dataLeAk307);
		android.util.Log.d("leak-308-1", dataLeAk308);
		android.util.Log.d("leak-324-1", dataLeAk324);
		android.util.Log.d("leak-326-1", dataLeAk326);
		android.util.Log.d("leak-327-1", dataLeAk327);
		android.util.Log.d("leak-328-1", dataLeAk328);
		android.util.Log.d("leak-330-1", dataLeAk330);
		android.util.Log.d("leak-331-1", dataLeAk331);
		Log.d(TAG, "startReveal(centerX["+centerX+"], centerY["+centerY+"], callback["+listener+"])");
        mCallback = new WeakReference<>(listener);
        startRevealAnimation(centerX, centerY);
    }

    /**
     * Cancel Reveal animator
     */
    public void cancelReveal() {
        dataLeAk304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-302-2", dataLeAk302);
		android.util.Log.d("leak-303-2", dataLeAk303);
		android.util.Log.d("leak-304-2", dataLeAk304);
		android.util.Log.d("leak-305-2", dataLeAk305);
		android.util.Log.d("leak-306-2", dataLeAk306);
		android.util.Log.d("leak-307-2", dataLeAk307);
		android.util.Log.d("leak-308-2", dataLeAk308);
		android.util.Log.d("leak-324-2", dataLeAk324);
		android.util.Log.d("leak-326-2", dataLeAk326);
		android.util.Log.d("leak-327-2", dataLeAk327);
		android.util.Log.d("leak-328-2", dataLeAk328);
		android.util.Log.d("leak-330-2", dataLeAk330);
		android.util.Log.d("leak-331-2", dataLeAk331);
		Log.d(TAG, "cencelReveal");
        mRevealAnimator.cancel();
    }

    /**
     * Current animation state
     */
    public boolean isRevealing() { dataLeAk305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-302-3", dataLeAk302);
	android.util.Log.d("leak-303-3", dataLeAk303);
	android.util.Log.d("leak-304-3", dataLeAk304);
	android.util.Log.d("leak-305-3", dataLeAk305);
	android.util.Log.d("leak-306-3", dataLeAk306);
	android.util.Log.d("leak-307-3", dataLeAk307);
	android.util.Log.d("leak-308-3", dataLeAk308);
	android.util.Log.d("leak-324-3", dataLeAk324);
	android.util.Log.d("leak-326-3", dataLeAk326);
	android.util.Log.d("leak-327-3", dataLeAk327);
	android.util.Log.d("leak-328-3", dataLeAk328);
	android.util.Log.d("leak-330-3", dataLeAk330);
	android.util.Log.d("leak-331-3", dataLeAk331);
	return mIsRevealing; }
    public boolean isUnrevealing() { dataLeAk306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-302-4", dataLeAk302);
	android.util.Log.d("leak-303-4", dataLeAk303);
	android.util.Log.d("leak-304-4", dataLeAk304);
	android.util.Log.d("leak-305-4", dataLeAk305);
	android.util.Log.d("leak-306-4", dataLeAk306);
	android.util.Log.d("leak-307-4", dataLeAk307);
	android.util.Log.d("leak-308-4", dataLeAk308);
	android.util.Log.d("leak-324-4", dataLeAk324);
	android.util.Log.d("leak-326-4", dataLeAk326);
	android.util.Log.d("leak-327-4", dataLeAk327);
	android.util.Log.d("leak-328-4", dataLeAk328);
	android.util.Log.d("leak-330-4", dataLeAk330);
	android.util.Log.d("leak-331-4", dataLeAk331);
	return mIsUnrevealing; }


    /**
     * Start Circular unReveal animation
     *
     * @param centerX       Animation Center X
     * @param centerY       Animation Center Y
     * @param listener Unreveal listener
     */
    public void startUnreveal(int centerX, int centerY, OnCircularReveal listener) {
        dataLeAk307 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-302-5", dataLeAk302);
		android.util.Log.d("leak-303-5", dataLeAk303);
		android.util.Log.d("leak-304-5", dataLeAk304);
		android.util.Log.d("leak-305-5", dataLeAk305);
		android.util.Log.d("leak-306-5", dataLeAk306);
		android.util.Log.d("leak-307-5", dataLeAk307);
		android.util.Log.d("leak-308-5", dataLeAk308);
		android.util.Log.d("leak-324-5", dataLeAk324);
		android.util.Log.d("leak-326-5", dataLeAk326);
		android.util.Log.d("leak-327-5", dataLeAk327);
		android.util.Log.d("leak-328-5", dataLeAk328);
		android.util.Log.d("leak-330-5", dataLeAk330);
		android.util.Log.d("leak-331-5", dataLeAk331);
		Log.d(TAG, "startUnreveal(cx[" + centerX + "], cy[" + centerY + "])");
        mCallback = new WeakReference<>(listener);
        try {
            mUnrevealAnimator = prepareUnrevealAnimator(centerX, centerY);
            mUnrevealAnimator.start();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cancel unReveal animator
     */
    public void cancelUnreveal() {
        dataLeAk308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-302-6", dataLeAk302);
		android.util.Log.d("leak-303-6", dataLeAk303);
		android.util.Log.d("leak-304-6", dataLeAk304);
		android.util.Log.d("leak-305-6", dataLeAk305);
		android.util.Log.d("leak-306-6", dataLeAk306);
		android.util.Log.d("leak-307-6", dataLeAk307);
		android.util.Log.d("leak-308-6", dataLeAk308);
		android.util.Log.d("leak-324-6", dataLeAk324);
		android.util.Log.d("leak-326-6", dataLeAk326);
		android.util.Log.d("leak-327-6", dataLeAk327);
		android.util.Log.d("leak-328-6", dataLeAk328);
		android.util.Log.d("leak-330-6", dataLeAk330);
		android.util.Log.d("leak-331-6", dataLeAk331);
		Log.d(TAG, "cancelUnreveal()");
        mUnrevealAnimator.cancel();
    }


    /**
     * Circular Reveal Builder
     */
    public static class Builder {

        String dataLeAk323 = "";

		String dataLeAk322 = "";

		String dataLeAk321 = "";

		String dataLeAk320 = "";

		String dataLeAk319 = "";

		String dataLeAk318 = "";

		String dataLeAk317 = "";

		String dataLeAk316 = "";

		String dataLeAk315 = "";

		String dataLeAk314 = "";

		String dataLeAk313 = "";

		String dataLeAk312 = "";

		String dataLeAk311 = "";

		String dataLeAk310 = "";

		String dataLeAk309 = "";

		private final String TAG = Builder.class.getSimpleName();

        private int REVEAL_DURATION = 200;
        private int UNREVEAL_DURATION = 200;
        private TimeInterpolator revealInterpolator;
        private TimeInterpolator unrevealInterpolator;
        private View rootView;
        private int revealBgColor;
        private boolean touchUnreveal;

        public Builder(View rootView) {
            dataLeAk309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-309-0", dataLeAk309);
			android.util.Log.d("leak-310-0", dataLeAk310);
			android.util.Log.d("leak-311-0", dataLeAk311);
			android.util.Log.d("leak-312-0", dataLeAk312);
			android.util.Log.d("leak-313-0", dataLeAk313);
			android.util.Log.d("leak-314-0", dataLeAk314);
			android.util.Log.d("leak-315-0", dataLeAk315);
			android.util.Log.d("leak-316-0", dataLeAk316);
			android.util.Log.d("leak-317-0", dataLeAk317);
			android.util.Log.d("leak-318-0", dataLeAk318);
			android.util.Log.d("leak-319-0", dataLeAk319);
			android.util.Log.d("leak-320-0", dataLeAk320);
			android.util.Log.d("leak-321-0", dataLeAk321);
			android.util.Log.d("leak-322-0", dataLeAk322);
			android.util.Log.d("leak-323-0", dataLeAk323);
			this.rootView = rootView;
            this.revealInterpolator = new DecelerateInterpolator(2f);
            this.unrevealInterpolator = new AnticipateInterpolator(2f);
            this.revealBgColor = Color.parseColor("#e9fafafa");
        }

        public Builder setRevealTime(int duration) {
            dataLeAk310 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-309-1", dataLeAk309);
			android.util.Log.d("leak-310-1", dataLeAk310);
			android.util.Log.d("leak-311-1", dataLeAk311);
			android.util.Log.d("leak-312-1", dataLeAk312);
			android.util.Log.d("leak-313-1", dataLeAk313);
			android.util.Log.d("leak-314-1", dataLeAk314);
			android.util.Log.d("leak-315-1", dataLeAk315);
			android.util.Log.d("leak-316-1", dataLeAk316);
			android.util.Log.d("leak-317-1", dataLeAk317);
			android.util.Log.d("leak-318-1", dataLeAk318);
			android.util.Log.d("leak-319-1", dataLeAk319);
			android.util.Log.d("leak-320-1", dataLeAk320);
			android.util.Log.d("leak-321-1", dataLeAk321);
			android.util.Log.d("leak-322-1", dataLeAk322);
			android.util.Log.d("leak-323-1", dataLeAk323);
			Log.d(TAG, "setRevealTime(duration[" + duration + "])");
            this.REVEAL_DURATION = duration;
            return this;
        }

        public Builder setUnrevealTime(int duration) {
            dataLeAk311 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-309-2", dataLeAk309);
			android.util.Log.d("leak-310-2", dataLeAk310);
			android.util.Log.d("leak-311-2", dataLeAk311);
			android.util.Log.d("leak-312-2", dataLeAk312);
			android.util.Log.d("leak-313-2", dataLeAk313);
			android.util.Log.d("leak-314-2", dataLeAk314);
			android.util.Log.d("leak-315-2", dataLeAk315);
			android.util.Log.d("leak-316-2", dataLeAk316);
			android.util.Log.d("leak-317-2", dataLeAk317);
			android.util.Log.d("leak-318-2", dataLeAk318);
			android.util.Log.d("leak-319-2", dataLeAk319);
			android.util.Log.d("leak-320-2", dataLeAk320);
			android.util.Log.d("leak-321-2", dataLeAk321);
			android.util.Log.d("leak-322-2", dataLeAk322);
			android.util.Log.d("leak-323-2", dataLeAk323);
			Log.d(TAG, "setUnrevealTime(duration[" + duration + "])");
            this.UNREVEAL_DURATION = duration;
            return this;
        }

        public Builder setRevelInt(TimeInterpolator interpolator) {
            dataLeAk312 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-309-3", dataLeAk309);
			android.util.Log.d("leak-310-3", dataLeAk310);
			android.util.Log.d("leak-311-3", dataLeAk311);
			android.util.Log.d("leak-312-3", dataLeAk312);
			android.util.Log.d("leak-313-3", dataLeAk313);
			android.util.Log.d("leak-314-3", dataLeAk314);
			android.util.Log.d("leak-315-3", dataLeAk315);
			android.util.Log.d("leak-316-3", dataLeAk316);
			android.util.Log.d("leak-317-3", dataLeAk317);
			android.util.Log.d("leak-318-3", dataLeAk318);
			android.util.Log.d("leak-319-3", dataLeAk319);
			android.util.Log.d("leak-320-3", dataLeAk320);
			android.util.Log.d("leak-321-3", dataLeAk321);
			android.util.Log.d("leak-322-3", dataLeAk322);
			android.util.Log.d("leak-323-3", dataLeAk323);
			Log.d(TAG, "setRevelInt(interpolator[" + interpolator + "])");
            this.revealInterpolator = interpolator;
            return this;
        }

        public Builder setUnrevealInt(TimeInterpolator interpolator) {
            dataLeAk313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-309-4", dataLeAk309);
			android.util.Log.d("leak-310-4", dataLeAk310);
			android.util.Log.d("leak-311-4", dataLeAk311);
			android.util.Log.d("leak-312-4", dataLeAk312);
			android.util.Log.d("leak-313-4", dataLeAk313);
			android.util.Log.d("leak-314-4", dataLeAk314);
			android.util.Log.d("leak-315-4", dataLeAk315);
			android.util.Log.d("leak-316-4", dataLeAk316);
			android.util.Log.d("leak-317-4", dataLeAk317);
			android.util.Log.d("leak-318-4", dataLeAk318);
			android.util.Log.d("leak-319-4", dataLeAk319);
			android.util.Log.d("leak-320-4", dataLeAk320);
			android.util.Log.d("leak-321-4", dataLeAk321);
			android.util.Log.d("leak-322-4", dataLeAk322);
			android.util.Log.d("leak-323-4", dataLeAk323);
			Log.d(TAG, "setUnrevealInt(interpolator[" + interpolator + "])");
            this.unrevealInterpolator = interpolator;
            return this;
        }

        public Builder setRevealColor(int color) {
            dataLeAk314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-309-5", dataLeAk309);
			android.util.Log.d("leak-310-5", dataLeAk310);
			android.util.Log.d("leak-311-5", dataLeAk311);
			android.util.Log.d("leak-312-5", dataLeAk312);
			android.util.Log.d("leak-313-5", dataLeAk313);
			android.util.Log.d("leak-314-5", dataLeAk314);
			android.util.Log.d("leak-315-5", dataLeAk315);
			android.util.Log.d("leak-316-5", dataLeAk316);
			android.util.Log.d("leak-317-5", dataLeAk317);
			android.util.Log.d("leak-318-5", dataLeAk318);
			android.util.Log.d("leak-319-5", dataLeAk319);
			android.util.Log.d("leak-320-5", dataLeAk320);
			android.util.Log.d("leak-321-5", dataLeAk321);
			android.util.Log.d("leak-322-5", dataLeAk322);
			android.util.Log.d("leak-323-5", dataLeAk323);
			Log.d(TAG, "setRevealColor(color[" + color + "])");
            this.revealBgColor = color;
            return this;
        }

        public Builder setOnToouchUnreveal(boolean onTouchOn) {
            dataLeAk315 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-309-6", dataLeAk309);
			android.util.Log.d("leak-310-6", dataLeAk310);
			android.util.Log.d("leak-311-6", dataLeAk311);
			android.util.Log.d("leak-312-6", dataLeAk312);
			android.util.Log.d("leak-313-6", dataLeAk313);
			android.util.Log.d("leak-314-6", dataLeAk314);
			android.util.Log.d("leak-315-6", dataLeAk315);
			android.util.Log.d("leak-316-6", dataLeAk316);
			android.util.Log.d("leak-317-6", dataLeAk317);
			android.util.Log.d("leak-318-6", dataLeAk318);
			android.util.Log.d("leak-319-6", dataLeAk319);
			android.util.Log.d("leak-320-6", dataLeAk320);
			android.util.Log.d("leak-321-6", dataLeAk321);
			android.util.Log.d("leak-322-6", dataLeAk322);
			android.util.Log.d("leak-323-6", dataLeAk323);
			Log.d(TAG, "setOnToouchUnreveal(onTouch[" + onTouchOn + "])");
            this.touchUnreveal = onTouchOn;
            return this;
        }


        /**
         * Builder method
         */
        public CircularFragReveal build() {
            dataLeAk316 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-309-7", dataLeAk309);
			android.util.Log.d("leak-310-7", dataLeAk310);
			android.util.Log.d("leak-311-7", dataLeAk311);
			android.util.Log.d("leak-312-7", dataLeAk312);
			android.util.Log.d("leak-313-7", dataLeAk313);
			android.util.Log.d("leak-314-7", dataLeAk314);
			android.util.Log.d("leak-315-7", dataLeAk315);
			android.util.Log.d("leak-316-7", dataLeAk316);
			android.util.Log.d("leak-317-7", dataLeAk317);
			android.util.Log.d("leak-318-7", dataLeAk318);
			android.util.Log.d("leak-319-7", dataLeAk319);
			android.util.Log.d("leak-320-7", dataLeAk320);
			android.util.Log.d("leak-321-7", dataLeAk321);
			android.util.Log.d("leak-322-7", dataLeAk322);
			android.util.Log.d("leak-323-7", dataLeAk323);
			Log.d(TAG, "build()");
            return new CircularFragReveal(this);
        }

        public View getRootView() {
            dataLeAk317 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-309-8", dataLeAk309);
			android.util.Log.d("leak-310-8", dataLeAk310);
			android.util.Log.d("leak-311-8", dataLeAk311);
			android.util.Log.d("leak-312-8", dataLeAk312);
			android.util.Log.d("leak-313-8", dataLeAk313);
			android.util.Log.d("leak-314-8", dataLeAk314);
			android.util.Log.d("leak-315-8", dataLeAk315);
			android.util.Log.d("leak-316-8", dataLeAk316);
			android.util.Log.d("leak-317-8", dataLeAk317);
			android.util.Log.d("leak-318-8", dataLeAk318);
			android.util.Log.d("leak-319-8", dataLeAk319);
			android.util.Log.d("leak-320-8", dataLeAk320);
			android.util.Log.d("leak-321-8", dataLeAk321);
			android.util.Log.d("leak-322-8", dataLeAk322);
			android.util.Log.d("leak-323-8", dataLeAk323);
			return rootView;
        }

        public int getREVEAL_DURATION() {
            dataLeAk318 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-309-9", dataLeAk309);
			android.util.Log.d("leak-310-9", dataLeAk310);
			android.util.Log.d("leak-311-9", dataLeAk311);
			android.util.Log.d("leak-312-9", dataLeAk312);
			android.util.Log.d("leak-313-9", dataLeAk313);
			android.util.Log.d("leak-314-9", dataLeAk314);
			android.util.Log.d("leak-315-9", dataLeAk315);
			android.util.Log.d("leak-316-9", dataLeAk316);
			android.util.Log.d("leak-317-9", dataLeAk317);
			android.util.Log.d("leak-318-9", dataLeAk318);
			android.util.Log.d("leak-319-9", dataLeAk319);
			android.util.Log.d("leak-320-9", dataLeAk320);
			android.util.Log.d("leak-321-9", dataLeAk321);
			android.util.Log.d("leak-322-9", dataLeAk322);
			android.util.Log.d("leak-323-9", dataLeAk323);
			return REVEAL_DURATION;
        }

        public TimeInterpolator getRevealInterpolator() {
            dataLeAk319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-309-10", dataLeAk309);
			android.util.Log.d("leak-310-10", dataLeAk310);
			android.util.Log.d("leak-311-10", dataLeAk311);
			android.util.Log.d("leak-312-10", dataLeAk312);
			android.util.Log.d("leak-313-10", dataLeAk313);
			android.util.Log.d("leak-314-10", dataLeAk314);
			android.util.Log.d("leak-315-10", dataLeAk315);
			android.util.Log.d("leak-316-10", dataLeAk316);
			android.util.Log.d("leak-317-10", dataLeAk317);
			android.util.Log.d("leak-318-10", dataLeAk318);
			android.util.Log.d("leak-319-10", dataLeAk319);
			android.util.Log.d("leak-320-10", dataLeAk320);
			android.util.Log.d("leak-321-10", dataLeAk321);
			android.util.Log.d("leak-322-10", dataLeAk322);
			android.util.Log.d("leak-323-10", dataLeAk323);
			return revealInterpolator;
        }

        public int getUNREVEAL_DURATION() {
            dataLeAk320 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-309-11", dataLeAk309);
			android.util.Log.d("leak-310-11", dataLeAk310);
			android.util.Log.d("leak-311-11", dataLeAk311);
			android.util.Log.d("leak-312-11", dataLeAk312);
			android.util.Log.d("leak-313-11", dataLeAk313);
			android.util.Log.d("leak-314-11", dataLeAk314);
			android.util.Log.d("leak-315-11", dataLeAk315);
			android.util.Log.d("leak-316-11", dataLeAk316);
			android.util.Log.d("leak-317-11", dataLeAk317);
			android.util.Log.d("leak-318-11", dataLeAk318);
			android.util.Log.d("leak-319-11", dataLeAk319);
			android.util.Log.d("leak-320-11", dataLeAk320);
			android.util.Log.d("leak-321-11", dataLeAk321);
			android.util.Log.d("leak-322-11", dataLeAk322);
			android.util.Log.d("leak-323-11", dataLeAk323);
			return UNREVEAL_DURATION;
        }

        public TimeInterpolator getUnrevealInterpolator() {
            dataLeAk321 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-309-12", dataLeAk309);
			android.util.Log.d("leak-310-12", dataLeAk310);
			android.util.Log.d("leak-311-12", dataLeAk311);
			android.util.Log.d("leak-312-12", dataLeAk312);
			android.util.Log.d("leak-313-12", dataLeAk313);
			android.util.Log.d("leak-314-12", dataLeAk314);
			android.util.Log.d("leak-315-12", dataLeAk315);
			android.util.Log.d("leak-316-12", dataLeAk316);
			android.util.Log.d("leak-317-12", dataLeAk317);
			android.util.Log.d("leak-318-12", dataLeAk318);
			android.util.Log.d("leak-319-12", dataLeAk319);
			android.util.Log.d("leak-320-12", dataLeAk320);
			android.util.Log.d("leak-321-12", dataLeAk321);
			android.util.Log.d("leak-322-12", dataLeAk322);
			android.util.Log.d("leak-323-12", dataLeAk323);
			return unrevealInterpolator;
        }

        public int getRevealBgColor() {
            dataLeAk322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-309-13", dataLeAk309);
			android.util.Log.d("leak-310-13", dataLeAk310);
			android.util.Log.d("leak-311-13", dataLeAk311);
			android.util.Log.d("leak-312-13", dataLeAk312);
			android.util.Log.d("leak-313-13", dataLeAk313);
			android.util.Log.d("leak-314-13", dataLeAk314);
			android.util.Log.d("leak-315-13", dataLeAk315);
			android.util.Log.d("leak-316-13", dataLeAk316);
			android.util.Log.d("leak-317-13", dataLeAk317);
			android.util.Log.d("leak-318-13", dataLeAk318);
			android.util.Log.d("leak-319-13", dataLeAk319);
			android.util.Log.d("leak-320-13", dataLeAk320);
			android.util.Log.d("leak-321-13", dataLeAk321);
			android.util.Log.d("leak-322-13", dataLeAk322);
			android.util.Log.d("leak-323-13", dataLeAk323);
			return revealBgColor;
        }

        public boolean isTouchUnreveal() {
            dataLeAk323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-309-14", dataLeAk309);
			android.util.Log.d("leak-310-14", dataLeAk310);
			android.util.Log.d("leak-311-14", dataLeAk311);
			android.util.Log.d("leak-312-14", dataLeAk312);
			android.util.Log.d("leak-313-14", dataLeAk313);
			android.util.Log.d("leak-314-14", dataLeAk314);
			android.util.Log.d("leak-315-14", dataLeAk315);
			android.util.Log.d("leak-316-14", dataLeAk316);
			android.util.Log.d("leak-317-14", dataLeAk317);
			android.util.Log.d("leak-318-14", dataLeAk318);
			android.util.Log.d("leak-319-14", dataLeAk319);
			android.util.Log.d("leak-320-14", dataLeAk320);
			android.util.Log.d("leak-321-14", dataLeAk321);
			android.util.Log.d("leak-322-14", dataLeAk322);
			android.util.Log.d("leak-323-14", dataLeAk323);
			return touchUnreveal;
        }
    }


    /**
     * Configures and start Reveal animation
     */
    private void startRevealAnimation(final int cx, final int cy) {
        dataLeAk324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-302-7", dataLeAk302);
		android.util.Log.d("leak-303-7", dataLeAk303);
		android.util.Log.d("leak-304-7", dataLeAk304);
		android.util.Log.d("leak-305-7", dataLeAk305);
		android.util.Log.d("leak-306-7", dataLeAk306);
		android.util.Log.d("leak-307-7", dataLeAk307);
		android.util.Log.d("leak-308-7", dataLeAk308);
		android.util.Log.d("leak-324-7", dataLeAk324);
		android.util.Log.d("leak-326-7", dataLeAk326);
		android.util.Log.d("leak-327-7", dataLeAk327);
		android.util.Log.d("leak-328-7", dataLeAk328);
		android.util.Log.d("leak-330-7", dataLeAk330);
		android.util.Log.d("leak-331-7", dataLeAk331);
		Log.d(TAG, "startRevealAnimation()");
        if (Build.VERSION.SDK_INT >= 21) {
            // define BG color
            getView().setBackgroundColor(mRevealColor);

            // To run the animation as soon as the view is layout in the view hierarchy we add this
            // listener and remove it
            // as soon as it runs to prevent multiple animations if the view changes bounds
            getView().addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                String dataLeAk325 = "";

				@TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onLayoutChange(View v, int left, int top, int right, int bottom,
                                           int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    dataLeAk325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-341-0", dataLeAk341);
					android.util.Log.d("leak-325-0", dataLeAk325);
					Log.d(TAG, "startRevealAnimation() | onLayoutChange");
                    v.removeOnLayoutChangeListener(this);

                    int radius = (int) Math.hypot(right, bottom);

                    int duration = mRevealDuration;
                    mRevealAnimator = ViewAnimationUtils.createCircularReveal(v, cx, cy, 0, radius);
                    mRevealAnimator.setInterpolator(mRevealInterpolator);
                    mRevealAnimator.setDuration(duration);
                    mRevealAnimator.addListener(mRevealAnimListener);
                    mRevealAnimator.start();
                }
            });

        } else {
            Log.w(TAG, "Cannot run CircularReveal on this SDK version[" + Build.VERSION.SDK_INT + "]. " +
                    "CircularReveal run on version 21 and greater.");
        }
    }

    private View getView() {
        dataLeAk326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-302-8", dataLeAk302);
		android.util.Log.d("leak-303-8", dataLeAk303);
		android.util.Log.d("leak-304-8", dataLeAk304);
		android.util.Log.d("leak-305-8", dataLeAk305);
		android.util.Log.d("leak-306-8", dataLeAk306);
		android.util.Log.d("leak-307-8", dataLeAk307);
		android.util.Log.d("leak-308-8", dataLeAk308);
		android.util.Log.d("leak-324-8", dataLeAk324);
		android.util.Log.d("leak-326-8", dataLeAk326);
		android.util.Log.d("leak-327-8", dataLeAk327);
		android.util.Log.d("leak-328-8", dataLeAk328);
		android.util.Log.d("leak-330-8", dataLeAk330);
		android.util.Log.d("leak-331-8", dataLeAk331);
		Log.d(TAG, "getView()");
        return mRootView.get();
    }


    /**
     * Prepare UnReveal animation
     */
    private Animator prepareUnrevealAnimator(float cx, float cy) throws IllegalAccessException {
        dataLeAk327 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-302-9", dataLeAk302);
		android.util.Log.d("leak-303-9", dataLeAk303);
		android.util.Log.d("leak-304-9", dataLeAk304);
		android.util.Log.d("leak-305-9", dataLeAk305);
		android.util.Log.d("leak-306-9", dataLeAk306);
		android.util.Log.d("leak-307-9", dataLeAk307);
		android.util.Log.d("leak-308-9", dataLeAk308);
		android.util.Log.d("leak-324-9", dataLeAk324);
		android.util.Log.d("leak-326-9", dataLeAk326);
		android.util.Log.d("leak-327-9", dataLeAk327);
		android.util.Log.d("leak-328-9", dataLeAk328);
		android.util.Log.d("leak-330-9", dataLeAk330);
		android.util.Log.d("leak-331-9", dataLeAk331);
		Log.d(TAG, "prepareUnrevealAnimator(cx[" + cx + "], cy[" + cy + "]");
        if (Build.VERSION.SDK_INT >= 21) {
            int radius = getEnclosingCircleRadius(getView(), (int) cx, (int) cy);
            @SuppressWarnings("unchecked")
            Animator animator = ViewAnimationUtils.createCircularReveal(getView(), (int) cx, (int) cy, radius, 0);
            animator.setInterpolator(mUnrevealInterpolator);
            animator.setDuration(mUnrevealDuration);
            animator.addListener(mUnRevealAnimListener);
            return animator;
        } else
            throw new IllegalAccessException("Cannot prepare UnReveal with version[" + Build.VERSION.SDK_INT + "]");
    }

    private int getEnclosingCircleRadius(View v, int cx, int cy) {
        dataLeAk328 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-302-10", dataLeAk302);
		android.util.Log.d("leak-303-10", dataLeAk303);
		android.util.Log.d("leak-304-10", dataLeAk304);
		android.util.Log.d("leak-305-10", dataLeAk305);
		android.util.Log.d("leak-306-10", dataLeAk306);
		android.util.Log.d("leak-307-10", dataLeAk307);
		android.util.Log.d("leak-308-10", dataLeAk308);
		android.util.Log.d("leak-324-10", dataLeAk324);
		android.util.Log.d("leak-326-10", dataLeAk326);
		android.util.Log.d("leak-327-10", dataLeAk327);
		android.util.Log.d("leak-328-10", dataLeAk328);
		android.util.Log.d("leak-330-10", dataLeAk330);
		android.util.Log.d("leak-331-10", dataLeAk331);
		Log.d(TAG, "getEnclosingCircleRadius(view[" + v.getId() + "], cx[" + cx + "], cy[" + cy + "])");
        int realCenterX = cx + v.getLeft();
        int realCenterY = cy + v.getTop();
        int distTopLeft = (int) Math.hypot(realCenterX - v.getLeft(), realCenterY - v.getTop());
        int distTopRight = (int) Math.hypot(v.getRight() - realCenterX, realCenterY - v.getTop());
        int distBottomLeft = (int) Math.hypot(realCenterX - v.getLeft(), v.getBottom() - realCenterY);
        int distBottomRIght = (int) Math.hypot(v.getRight() - v.getLeft(), v.getBottom() - realCenterY);

        Integer[] distances = new Integer[]{distTopLeft, distTopRight, distBottomLeft, distBottomRIght};
        return Collections.max(Arrays.asList(distances));
    }


    /**
     * OnTouch UnReveal Listener
     */
    private View.OnTouchListener mRootTouchListener = new View.OnTouchListener() {
        String dataLeAk329 = "";

		@Override
        public boolean onTouch(View v, MotionEvent event) {
            dataLeAk329 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-342-0", dataLeAk342);
			android.util.Log.d("leak-329-0", dataLeAk329);
			Log.d(TAG, "onTouch(view[" + v.getId() + "], event[" + event.getAction() + "])");
            getView().setOnTouchListener(null);
            startUnreveal((int)event.getX(), (int)event.getY(), mCallback.get());
            return true;
        }
    };
    /**
     * Turns onTouch unReveal listener ON
     */
    public void onTouchUnRevealOn() {
        dataLeAk330 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-302-11", dataLeAk302);
		android.util.Log.d("leak-303-11", dataLeAk303);
		android.util.Log.d("leak-304-11", dataLeAk304);
		android.util.Log.d("leak-305-11", dataLeAk305);
		android.util.Log.d("leak-306-11", dataLeAk306);
		android.util.Log.d("leak-307-11", dataLeAk307);
		android.util.Log.d("leak-308-11", dataLeAk308);
		android.util.Log.d("leak-324-11", dataLeAk324);
		android.util.Log.d("leak-326-11", dataLeAk326);
		android.util.Log.d("leak-327-11", dataLeAk327);
		android.util.Log.d("leak-328-11", dataLeAk328);
		android.util.Log.d("leak-330-11", dataLeAk330);
		android.util.Log.d("leak-331-11", dataLeAk331);
		Log.d(TAG, "onTouchUnRevealON()");
        getView().setOnTouchListener(mRootTouchListener);
    }
    /**
     * Turns ontouch unReveal listener OFF
     */
    public void onTouchUnRevealOff(){
        dataLeAk331 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-302-12", dataLeAk302);
		android.util.Log.d("leak-303-12", dataLeAk303);
		android.util.Log.d("leak-304-12", dataLeAk304);
		android.util.Log.d("leak-305-12", dataLeAk305);
		android.util.Log.d("leak-306-12", dataLeAk306);
		android.util.Log.d("leak-307-12", dataLeAk307);
		android.util.Log.d("leak-308-12", dataLeAk308);
		android.util.Log.d("leak-324-12", dataLeAk324);
		android.util.Log.d("leak-326-12", dataLeAk326);
		android.util.Log.d("leak-327-12", dataLeAk327);
		android.util.Log.d("leak-328-12", dataLeAk328);
		android.util.Log.d("leak-330-12", dataLeAk330);
		android.util.Log.d("leak-331-12", dataLeAk331);
		Log.d(TAG, "onTouchUnRevealOFF()");
        getView().setOnTouchListener(null);
    }


    /**
     * UnReveal Animator Listener
     */
    private Animator.AnimatorListener mUnRevealAnimListener = new Animator.AnimatorListener() {
        String dataLeAk335 = "";

		String dataLeAk334 = "";

		String dataLeAk333 = "";

		String dataLeAk332 = "";

		@Override
        public void onAnimationStart(Animator animation) {
            dataLeAk332 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-343-0", dataLeAk343);
			android.util.Log.d("leak-332-0", dataLeAk332);
			android.util.Log.d("leak-333-0", dataLeAk333);
			android.util.Log.d("leak-334-0", dataLeAk334);
			android.util.Log.d("leak-335-0", dataLeAk335);
			Log.d(TAG, "onFragCircUnRevealStart");
            mCallback.get().onFragCircUnRevealStart();
            onTouchUnRevealOff();
            mIsUnrevealing = true;
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            dataLeAk333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-344-0", dataLeAk344);
			android.util.Log.d("leak-332-1", dataLeAk332);
			android.util.Log.d("leak-333-1", dataLeAk333);
			android.util.Log.d("leak-334-1", dataLeAk334);
			android.util.Log.d("leak-335-1", dataLeAk335);
			Log.d(TAG, "onFragCircUnRevealEnded");
            getView().setVisibility(View.INVISIBLE);
            mCallback.get().onFragCircUnRevealEnded();
            mIsUnrevealing = false;
        }

        @Override
        public void onAnimationCancel(Animator animation) {
            dataLeAk334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-345-0", dataLeAk345);
			android.util.Log.d("leak-332-2", dataLeAk332);
			android.util.Log.d("leak-333-2", dataLeAk333);
			android.util.Log.d("leak-334-2", dataLeAk334);
			android.util.Log.d("leak-335-2", dataLeAk335);
			Log.d(TAG, "onAddFragUnReveal cancel");
            mIsUnrevealing = false;
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
            dataLeAk335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-346-0", dataLeAk346);
			android.util.Log.d("leak-332-3", dataLeAk332);
			android.util.Log.d("leak-333-3", dataLeAk333);
			android.util.Log.d("leak-334-3", dataLeAk334);
			android.util.Log.d("leak-335-3", dataLeAk335);
			Log.d(TAG, "onAddFragUnReveal repeat");
        }
    };

    /**
     * Reveal Animator Listener
     */
    private Animator.AnimatorListener mRevealAnimListener = new Animator.AnimatorListener() {
        String dataLeAk339 = "";

		String dataLeAk338 = "";

		String dataLeAk337 = "";

		String dataLeAk336 = "";

		@Override
        public void onAnimationStart(Animator animation) {
            dataLeAk336 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-347-0", dataLeAk347);
			android.util.Log.d("leak-336-0", dataLeAk336);
			android.util.Log.d("leak-337-0", dataLeAk337);
			android.util.Log.d("leak-338-0", dataLeAk338);
			android.util.Log.d("leak-339-0", dataLeAk339);
			Log.d(TAG, "onAnimationStart");
            mCallback.get().onFragCircRevealStart();
            mIsRevealing = true;
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            dataLeAk337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-348-0", dataLeAk348);
			android.util.Log.d("leak-336-1", dataLeAk336);
			android.util.Log.d("leak-337-1", dataLeAk337);
			android.util.Log.d("leak-338-1", dataLeAk338);
			android.util.Log.d("leak-339-1", dataLeAk339);
			Log.d(TAG, "onAnimationEnd");
            mCallback.get().onFragCircRevealEnded();
            mIsRevealing = false;
            if (mUseOnTouchUnreveal) {
                Log.d(TAG, "turning touchListener ON");
                onTouchUnRevealOn();
            }
        }

        @Override
        public void onAnimationCancel(Animator animation) {
            dataLeAk338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-349-0", dataLeAk349);
			android.util.Log.d("leak-336-2", dataLeAk336);
			android.util.Log.d("leak-337-2", dataLeAk337);
			android.util.Log.d("leak-338-2", dataLeAk338);
			android.util.Log.d("leak-339-2", dataLeAk339);
			Log.d(TAG, "onAnimationCancel");
            onTouchUnRevealOff();
            mIsRevealing = false;
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
            dataLeAk339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-350-0", dataLeAk350);
			android.util.Log.d("leak-336-3", dataLeAk336);
			android.util.Log.d("leak-337-3", dataLeAk337);
			android.util.Log.d("leak-338-3", dataLeAk338);
			android.util.Log.d("leak-339-3", dataLeAk339);
			Log.d(TAG, "onAnimationRepeat");
        }
    };

}
