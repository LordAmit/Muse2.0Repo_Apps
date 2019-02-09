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

    String dataLeAk390 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk390 = android.util.Log.d("leak-390", dataLeAk390);

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
        String dataLeAk391 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk391 = android.util.Log.d("leak-391", dataLeAk391);
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
        String dataLeAk392 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk392 = android.util.Log.d("leak-392", dataLeAk392);
		Log.d(TAG, "startReveal(centerX["+centerX+"], centerY["+centerY+"], callback["+listener+"])");
        mCallback = new WeakReference<>(listener);
        startRevealAnimation(centerX, centerY);
    }

    /**
     * Cancel Reveal animator
     */
    public void cancelReveal() {
        String dataLeAk393 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk393 = android.util.Log.d("leak-393", dataLeAk393);
		Log.d(TAG, "cencelReveal");
        mRevealAnimator.cancel();
    }

    /**
     * Current animation state
     */
    public boolean isRevealing() { String dataLeAk394 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk394 = android.util.Log.d("leak-394", dataLeAk394);
	return mIsRevealing; }
    public boolean isUnrevealing() { String dataLeAk395 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk395 = android.util.Log.d("leak-395", dataLeAk395);
	return mIsUnrevealing; }


    /**
     * Start Circular unReveal animation
     *
     * @param centerX       Animation Center X
     * @param centerY       Animation Center Y
     * @param listener Unreveal listener
     */
    public void startUnreveal(int centerX, int centerY, OnCircularReveal listener) {
        String dataLeAk396 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk396 = android.util.Log.d("leak-396", dataLeAk396);
		Log.d(TAG, "startUnreveal(cx[" + centerX + "], cy[" + centerY + "])");
        mCallback = new WeakReference<>(listener);
        try {
            String dataLeAk397 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk397 = android.util.Log.d("leak-397", dataLeAk397);
			mUnrevealAnimator = prepareUnrevealAnimator(centerX, centerY);
            mUnrevealAnimator.start();
        } catch (IllegalAccessException e) {
            String dataLeAk398 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk398 = android.util.Log.d("leak-398", dataLeAk398);
			e.printStackTrace();
        }
    }

    /**
     * Cancel unReveal animator
     */
    public void cancelUnreveal() {
        String dataLeAk399 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk399 = android.util.Log.d("leak-399", dataLeAk399);
		Log.d(TAG, "cancelUnreveal()");
        mUnrevealAnimator.cancel();
    }


    /**
     * Circular Reveal Builder
     */
    public static class Builder {

        String dataLeAk400 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk400 = android.util.Log.d("leak-400", dataLeAk400);

		private final String TAG = Builder.class.getSimpleName();

        private int REVEAL_DURATION = 200;
        private int UNREVEAL_DURATION = 200;
        private TimeInterpolator revealInterpolator;
        private TimeInterpolator unrevealInterpolator;
        private View rootView;
        private int revealBgColor;
        private boolean touchUnreveal;

        public Builder(View rootView) {
            String dataLeAk401 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk401 = android.util.Log.d("leak-401", dataLeAk401);
			this.rootView = rootView;
            this.revealInterpolator = new DecelerateInterpolator(2f);
            this.unrevealInterpolator = new AnticipateInterpolator(2f);
            this.revealBgColor = Color.parseColor("#e9fafafa");
        }

        public Builder setRevealTime(int duration) {
            String dataLeAk402 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk402 = android.util.Log.d("leak-402", dataLeAk402);
			Log.d(TAG, "setRevealTime(duration[" + duration + "])");
            this.REVEAL_DURATION = duration;
            return this;
        }

        public Builder setUnrevealTime(int duration) {
            String dataLeAk403 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk403 = android.util.Log.d("leak-403", dataLeAk403);
			Log.d(TAG, "setUnrevealTime(duration[" + duration + "])");
            this.UNREVEAL_DURATION = duration;
            return this;
        }

        public Builder setRevelInt(TimeInterpolator interpolator) {
            String dataLeAk404 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk404 = android.util.Log.d("leak-404", dataLeAk404);
			Log.d(TAG, "setRevelInt(interpolator[" + interpolator + "])");
            this.revealInterpolator = interpolator;
            return this;
        }

        public Builder setUnrevealInt(TimeInterpolator interpolator) {
            String dataLeAk405 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk405 = android.util.Log.d("leak-405", dataLeAk405);
			Log.d(TAG, "setUnrevealInt(interpolator[" + interpolator + "])");
            this.unrevealInterpolator = interpolator;
            return this;
        }

        public Builder setRevealColor(int color) {
            String dataLeAk406 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk406 = android.util.Log.d("leak-406", dataLeAk406);
			Log.d(TAG, "setRevealColor(color[" + color + "])");
            this.revealBgColor = color;
            return this;
        }

        public Builder setOnToouchUnreveal(boolean onTouchOn) {
            String dataLeAk407 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk407 = android.util.Log.d("leak-407", dataLeAk407);
			Log.d(TAG, "setOnToouchUnreveal(onTouch[" + onTouchOn + "])");
            this.touchUnreveal = onTouchOn;
            return this;
        }


        /**
         * Builder method
         */
        public CircularFragReveal build() {
            String dataLeAk408 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk408 = android.util.Log.d("leak-408", dataLeAk408);
			Log.d(TAG, "build()");
            return new CircularFragReveal(this);
        }

        public View getRootView() {
            String dataLeAk409 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk409 = android.util.Log.d("leak-409", dataLeAk409);
			return rootView;
        }

        public int getREVEAL_DURATION() {
            String dataLeAk410 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk410 = android.util.Log.d("leak-410", dataLeAk410);
			return REVEAL_DURATION;
        }

        public TimeInterpolator getRevealInterpolator() {
            String dataLeAk411 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk411 = android.util.Log.d("leak-411", dataLeAk411);
			return revealInterpolator;
        }

        public int getUNREVEAL_DURATION() {
            String dataLeAk412 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk412 = android.util.Log.d("leak-412", dataLeAk412);
			return UNREVEAL_DURATION;
        }

        public TimeInterpolator getUnrevealInterpolator() {
            String dataLeAk413 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk413 = android.util.Log.d("leak-413", dataLeAk413);
			return unrevealInterpolator;
        }

        public int getRevealBgColor() {
            String dataLeAk414 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk414 = android.util.Log.d("leak-414", dataLeAk414);
			return revealBgColor;
        }

        public boolean isTouchUnreveal() {
            String dataLeAk415 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk415 = android.util.Log.d("leak-415", dataLeAk415);
			return touchUnreveal;
        }
    }


    /**
     * Configures and start Reveal animation
     */
    private void startRevealAnimation(final int cx, final int cy) {
        String dataLeAk416 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk416 = android.util.Log.d("leak-416", dataLeAk416);
		Log.d(TAG, "startRevealAnimation()");
        if (Build.VERSION.SDK_INT >= 21) {
            String dataLeAk417 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk417 = android.util.Log.d("leak-417", dataLeAk417);
			// define BG color
            getView().setBackgroundColor(mRevealColor);

            // To run the animation as soon as the view is layout in the view hierarchy we add this
            // listener and remove it
            // as soon as it runs to prevent multiple animations if the view changes bounds
            getView().addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                String dataLeAk418 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk418 = android.util.Log.d("leak-418", dataLeAk418);

				@TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onLayoutChange(View v, int left, int top, int right, int bottom,
                                           int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    String dataLeAk419 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk419 = android.util.Log.d("leak-419", dataLeAk419);
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
            String dataLeAk420 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk420 = android.util.Log.d("leak-420", dataLeAk420);
			Log.w(TAG, "Cannot run CircularReveal on this SDK version[" + Build.VERSION.SDK_INT + "]. " +
                    "CircularReveal run on version 21 and greater.");
        }
    }

    private View getView() {
        String dataLeAk421 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk421 = android.util.Log.d("leak-421", dataLeAk421);
		Log.d(TAG, "getView()");
        return mRootView.get();
    }


    /**
     * Prepare UnReveal animation
     */
    private Animator prepareUnrevealAnimator(float cx, float cy) throws IllegalAccessException {
        String dataLeAk422 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk422 = android.util.Log.d("leak-422", dataLeAk422);
		Log.d(TAG, "prepareUnrevealAnimator(cx[" + cx + "], cy[" + cy + "]");
        if (Build.VERSION.SDK_INT >= 21) {
            String dataLeAk423 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk423 = android.util.Log.d("leak-423", dataLeAk423);
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
        String dataLeAk424 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk424 = android.util.Log.d("leak-424", dataLeAk424);
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
        String dataLeAk425 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk425 = android.util.Log.d("leak-425", dataLeAk425);

		@Override
        public boolean onTouch(View v, MotionEvent event) {
            String dataLeAk426 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk426 = android.util.Log.d("leak-426", dataLeAk426);
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
        String dataLeAk427 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk427 = android.util.Log.d("leak-427", dataLeAk427);
		Log.d(TAG, "onTouchUnRevealON()");
        getView().setOnTouchListener(mRootTouchListener);
    }
    /**
     * Turns ontouch unReveal listener OFF
     */
    public void onTouchUnRevealOff(){
        String dataLeAk428 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk428 = android.util.Log.d("leak-428", dataLeAk428);
		Log.d(TAG, "onTouchUnRevealOFF()");
        getView().setOnTouchListener(null);
    }


    /**
     * UnReveal Animator Listener
     */
    private Animator.AnimatorListener mUnRevealAnimListener = new Animator.AnimatorListener() {
        String dataLeAk429 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk429 = android.util.Log.d("leak-429", dataLeAk429);

		@Override
        public void onAnimationStart(Animator animation) {
            String dataLeAk430 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk430 = android.util.Log.d("leak-430", dataLeAk430);
			Log.d(TAG, "onFragCircUnRevealStart");
            mCallback.get().onFragCircUnRevealStart();
            onTouchUnRevealOff();
            mIsUnrevealing = true;
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            String dataLeAk431 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk431 = android.util.Log.d("leak-431", dataLeAk431);
			Log.d(TAG, "onFragCircUnRevealEnded");
            getView().setVisibility(View.INVISIBLE);
            mCallback.get().onFragCircUnRevealEnded();
            mIsUnrevealing = false;
        }

        @Override
        public void onAnimationCancel(Animator animation) {
            String dataLeAk432 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk432 = android.util.Log.d("leak-432", dataLeAk432);
			Log.d(TAG, "onAddFragUnReveal cancel");
            mIsUnrevealing = false;
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
            String dataLeAk433 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk433 = android.util.Log.d("leak-433", dataLeAk433);
			Log.d(TAG, "onAddFragUnReveal repeat");
        }
    };

    /**
     * Reveal Animator Listener
     */
    private Animator.AnimatorListener mRevealAnimListener = new Animator.AnimatorListener() {
        String dataLeAk434 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk434 = android.util.Log.d("leak-434", dataLeAk434);

		@Override
        public void onAnimationStart(Animator animation) {
            String dataLeAk435 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk435 = android.util.Log.d("leak-435", dataLeAk435);
			Log.d(TAG, "onAnimationStart");
            mCallback.get().onFragCircRevealStart();
            mIsRevealing = true;
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            String dataLeAk436 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk436 = android.util.Log.d("leak-436", dataLeAk436);
			Log.d(TAG, "onAnimationEnd");
            mCallback.get().onFragCircRevealEnded();
            mIsRevealing = false;
            if (mUseOnTouchUnreveal) {
                String dataLeAk437 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk437 = android.util.Log.d("leak-437", dataLeAk437);
				Log.d(TAG, "turning touchListener ON");
                onTouchUnRevealOn();
            }
        }

        @Override
        public void onAnimationCancel(Animator animation) {
            String dataLeAk438 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk438 = android.util.Log.d("leak-438", dataLeAk438);
			Log.d(TAG, "onAnimationCancel");
            onTouchUnRevealOff();
            mIsRevealing = false;
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
            String dataLeAk439 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk439 = android.util.Log.d("leak-439", dataLeAk439);
			Log.d(TAG, "onAnimationRepeat");
        }
    };

}
