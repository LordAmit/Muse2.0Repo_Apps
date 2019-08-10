package org.androidpn.client.helper;

/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.ListActivity;
import android.app.ListFragment;
import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * A {@link View.OnTouchListener} that makes any {@link View} dismissable when the
 * user swipes (drags her finger) horizontally across the view.
 *
 * <p><em>For {@link ListView} list items that don't manage their own touch events
 * (i.e. you're using
 * {@link ListView#setOnItemClickListener(AdapterView.OnItemClickListener)}
 * or an equivalent listener on {@link ListActivity} or
 * {@link ListFragment}, use {@link SwipeDismissListViewTouchListener} instead.</em></p>
 *
 * <p>Example usage:</p>
 *
 * <pre>
 * view.setOnTouchListener(new SwipeDismissTouchListener(
 *         view,
 *         null, // Optional token/cookie object
 *         new SwipeDismissTouchListener.OnDismissCallback() {
 *             public void onDismiss(View view, Object token) {
 *                 parent.removeView(view);
 *             }
 *         }));
 * </pre>
 *
 * <p>This class Requires API level 12 or later due to use of {@link
 * android.view.ViewPropertyAnimator}.</p>
 *
 * @see SwipeDismissListViewTouchListener
 */
public class SwipeDismissTouchListener implements View.OnTouchListener {
    String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk100 = android.util.Log.d("leak-100", dataLeAk100);

	// Cached ViewConfiguration and system-wide constant values
    private int mSlop;
    private int mMinFlingVelocity;
    private int mMaxFlingVelocity;
    private long mAnimationTime;

    // Fixed properties
    private View mView;
    private DismissCallbacks mCallbacks;
    private int mViewWidth = 1; // 1 and not 0 to prevent dividing by zero

    // Transient properties
    private float mDownX;
    private float mDownY;
    private boolean mSwiping;
    private int mSwipingSlop;
    private Object mToken;
    private VelocityTracker mVelocityTracker;
    private float mTranslationX;

    /**
     * The callback interface used by {@link SwipeDismissTouchListener} to inform its client
     * about a successful dismissal of the view for which it was created.
     */
    public interface DismissCallbacks {
        /**
         * Called to determine whether the view can be dismissed.
         */
        boolean canDismiss(Object token);

        /**
         * Called when the user has indicated they she would like to dismiss the view.
         *
         * @param view  The originating {@link View} to be dismissed.
         * @param token The optional token passed to this object's constructor.
         */
        void onDismiss(View view, Object token);
    }

    /**
     * Constructs a new swipe-to-dismiss touch listener for the given view.
     *
     * @param view     The view to make dismissable.
     * @param token    An optional token/cookie object to be passed through to the callback.
     * @param callbacks The callback to trigger when the user has indicated that she would like to
     *                 dismiss this view.
     */
    public SwipeDismissTouchListener(View view, Object token, DismissCallbacks callbacks) {
        String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk101 = android.util.Log.d("leak-101", dataLeAk101);
		ViewConfiguration vc = ViewConfiguration.get(view.getContext());
        mSlop = vc.getScaledTouchSlop();
        mMinFlingVelocity = vc.getScaledMinimumFlingVelocity() * 16;
        mMaxFlingVelocity = vc.getScaledMaximumFlingVelocity();
        mAnimationTime = view.getContext().getResources().getInteger(
                android.R.integer.config_shortAnimTime);
        mView = view;
        mToken = token;
        mCallbacks = callbacks;
    }

    @TargetApi(12)
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk102 = android.util.Log.d("leak-102", dataLeAk102);
		// offset because the view is translated during swipe
        motionEvent.offsetLocation(mTranslationX, 0);

        if (mViewWidth < 2) {
            String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk103 = android.util.Log.d("leak-103", dataLeAk103);
			mViewWidth = mView.getWidth();
        }

        switch (motionEvent.getActionMasked()) {
            case MotionEvent.ACTION_DOWN: {
                String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk104 = android.util.Log.d("leak-104", dataLeAk104);
				// TODO: ensure this is a finger, and set a flag
                mDownX = motionEvent.getRawX();
                mDownY = motionEvent.getRawY();
                if (mCallbacks.canDismiss(mToken)) {
                    String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk105 = android.util.Log.d("leak-105", dataLeAk105);
					mVelocityTracker = VelocityTracker.obtain();
                    mVelocityTracker.addMovement(motionEvent);
                }
                return false;
            }

            case MotionEvent.ACTION_UP: {
                String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk106 = android.util.Log.d("leak-106", dataLeAk106);
				if (mVelocityTracker == null) {
                    String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk107 = android.util.Log.d("leak-107", dataLeAk107);
					break;
                }

                float deltaX = motionEvent.getRawX() - mDownX;
                mVelocityTracker.addMovement(motionEvent);
                mVelocityTracker.computeCurrentVelocity(1000);
                float velocityX = mVelocityTracker.getXVelocity();
                float absVelocityX = Math.abs(velocityX);
                float absVelocityY = Math.abs(mVelocityTracker.getYVelocity());
                boolean dismiss = false;
                boolean dismissRight = false;
                if (Math.abs(deltaX) > mViewWidth / 2 && mSwiping) {
                    String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk108 = android.util.Log.d("leak-108", dataLeAk108);
					dismiss = true;
                    dismissRight = deltaX > 0;
                } else if (mMinFlingVelocity <= absVelocityX && absVelocityX <= mMaxFlingVelocity
                        && absVelocityY < absVelocityX
                        && absVelocityY < absVelocityX && mSwiping) {
                    String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk109 = android.util.Log.d("leak-109", dataLeAk109);
					// dismiss only if flinging in the same direction as dragging
                    dismiss = (velocityX < 0) == (deltaX < 0);
                    dismissRight = mVelocityTracker.getXVelocity() > 0;
                }
                if (dismiss) {
                    String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk110 = android.util.Log.d("leak-110", dataLeAk110);
					// dismiss
                    if (Build.VERSION.SDK_INT >= 12) {
                        String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk111 = android.util.Log.d("leak-111", dataLeAk111);
						mView.animate()
                                .translationX(dismissRight ? mViewWidth : -mViewWidth)
                                .alpha(0)
                                .setDuration(mAnimationTime)
                                .setListener(new AnimatorListenerAdapter() {
                                    String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk112 = android.util.Log.d("leak-112", dataLeAk112);

									@Override
                                    public void onAnimationEnd(Animator animation) {
                                        String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk113 = android.util.Log.d("leak-113", dataLeAk113);
										performDismiss();
                                    }
                                });
                    } else {
                        String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk114 = android.util.Log.d("leak-114", dataLeAk114);
						performDismiss();
                    }
                } else if (mSwiping) {
                    String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk115 = android.util.Log.d("leak-115", dataLeAk115);
					// cancel
                    if (Build.VERSION.SDK_INT >= 12) {
                        String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk116 = android.util.Log.d("leak-116", dataLeAk116);
						mView.animate()
                                .translationX(0)
                                .alpha(1)
                                .setDuration(mAnimationTime)
                                .setListener(null);
                    }
                }
                mVelocityTracker.recycle();
                mVelocityTracker = null;
                mTranslationX = 0;
                mDownX = 0;
                mDownY = 0;
                mSwiping = false;
                break;
            }

            case MotionEvent.ACTION_CANCEL: {
                String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk117 = android.util.Log.d("leak-117", dataLeAk117);
				if (mVelocityTracker == null) {
                    String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk118 = android.util.Log.d("leak-118", dataLeAk118);
					break;
                }
                if (Build.VERSION.SDK_INT >= 12) {
                    String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk119 = android.util.Log.d("leak-119", dataLeAk119);
					mView.animate()
                            .translationX(0)
                            .alpha(1)
                            .setDuration(mAnimationTime)
                            .setListener(null);
                }
                mVelocityTracker.recycle();
                mVelocityTracker = null;
                mTranslationX = 0;
                mDownX = 0;
                mDownY = 0;
                mSwiping = false;
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk120 = android.util.Log.d("leak-120", dataLeAk120);
				if (mVelocityTracker == null) {
                    String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk121 = android.util.Log.d("leak-121", dataLeAk121);
					break;
                }

                mVelocityTracker.addMovement(motionEvent);
                float deltaX = motionEvent.getRawX() - mDownX;
                float deltaY = motionEvent.getRawY() - mDownY;
                if (Math.abs(deltaX) > mSlop && Math.abs(deltaY) < Math.abs(deltaX) / 2) {
                    String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk122 = android.util.Log.d("leak-122", dataLeAk122);
					mSwiping = true;
                    mSwipingSlop = (deltaX > 0 ? mSlop : -mSlop);
                    mView.getParent().requestDisallowInterceptTouchEvent(true);

                    // Cancel listview's touch
                    MotionEvent cancelEvent = MotionEvent.obtain(motionEvent);
                    cancelEvent.setAction(MotionEvent.ACTION_CANCEL |
                            (motionEvent.getActionIndex() <<
                                    MotionEvent.ACTION_POINTER_INDEX_SHIFT));
                    mView.onTouchEvent(cancelEvent);
                    cancelEvent.recycle();
                }

                if (mSwiping) {
                    String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk123 = android.util.Log.d("leak-123", dataLeAk123);
					mTranslationX = deltaX;
                    mView.setTranslationX(deltaX - mSwipingSlop);
                    // TODO: use an ease-out interpolator or such
                    mView.setAlpha(Math.max(0f, Math.min(1f,
                            1f - 2f * Math.abs(deltaX) / mViewWidth)));
                    view.performClick();
                    return true;
                }
                break;
            }
        }
        return false;
    }

    private void performDismiss() {
        // Animate the dismissed view to zero-height and then fire the dismiss callback.
        // This triggers layout on each animation frame; in the future we may want to do something
        // smarter and more performant.

        String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk124 = android.util.Log.d("leak-124", dataLeAk124);
		final ViewGroup.LayoutParams lp = mView.getLayoutParams();
        final int originalHeight = mView.getHeight();

        ValueAnimator animator = ValueAnimator.ofInt(originalHeight, 1).setDuration(mAnimationTime);

        animator.addListener(new AnimatorListenerAdapter() {
            String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk125 = android.util.Log.d("leak-125", dataLeAk125);

			@Override
            public void onAnimationEnd(Animator animation) {
                String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk126 = android.util.Log.d("leak-126", dataLeAk126);
				mCallbacks.onDismiss(mView, mToken);
                // Reset view presentation
                mView.setAlpha(1f);
                mView.setTranslationX(0);
                lp.height = originalHeight;
                mView.setLayoutParams(lp);
            }
        });

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk127 = android.util.Log.d("leak-127", dataLeAk127);

			@Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk128 = android.util.Log.d("leak-128", dataLeAk128);
				lp.height = (Integer) valueAnimator.getAnimatedValue();
                mView.setLayoutParams(lp);
            }
        });

        animator.start();
    }
}
