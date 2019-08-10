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
        String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP89 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP89.put("test", new java.util.HashMap<String, String>());
		leakMaP89.get("test").put("test", dataLeAk89);
		String dataLeAkPath89 = leakMaP89.get("test").get("test");
		android.util.Log.d("leak-89", dataLeAkPath89);
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
        String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer90 = new StringBuffer();for (char chAr90 : dataLeAk90.toCharArray()) {leakBuFFer90.append(chAr90);}String dataLeAkPath90 = leakBuFFer90.toString();
		android.util.Log.d("leak-90", dataLeAkPath90);
		// offset because the view is translated during swipe
        motionEvent.offsetLocation(mTranslationX, 0);

        if (mViewWidth < 2) {
            String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath91;try {throw new Exception(dataLeAk91);} catch (Exception leakErRor91) {dataLeAkPath91 = leakErRor91.getMessage();}
			android.util.Log.d("leak-91", dataLeAkPath91);
			mViewWidth = mView.getWidth();
        }

        switch (motionEvent.getActionMasked()) {
            case MotionEvent.ACTION_DOWN: {
                String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay92 = new String[] {"n/a", dataLeAk92};
				String dataLeAkPath92 = leakArRay92[leakArRay92.length - 1];
				android.util.Log.d("leak-92", dataLeAkPath92);
				// TODO: ensure this is a finger, and set a flag
                mDownX = motionEvent.getRawX();
                mDownY = motionEvent.getRawY();
                if (mCallbacks.canDismiss(mToken)) {
                    String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP93 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP93.put("test", new java.util.HashMap<String, String>());
					leakMaP93.get("test").put("test", dataLeAk93);
					String dataLeAkPath93 = leakMaP93.get("test").get("test");
					android.util.Log.d("leak-93", dataLeAkPath93);
					mVelocityTracker = VelocityTracker.obtain();
                    mVelocityTracker.addMovement(motionEvent);
                }
                return false;
            }

            case MotionEvent.ACTION_UP: {
                String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer94 = new StringBuffer();for (char chAr94 : dataLeAk94.toCharArray()) {leakBuFFer94.append(chAr94);}String dataLeAkPath94 = leakBuFFer94.toString();
				android.util.Log.d("leak-94", dataLeAkPath94);
				if (mVelocityTracker == null) {
                    String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath95;try {throw new Exception(dataLeAk95);} catch (Exception leakErRor95) {dataLeAkPath95 = leakErRor95.getMessage();}
					android.util.Log.d("leak-95", dataLeAkPath95);
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
                    String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay96 = new String[] {"n/a", dataLeAk96};
					String dataLeAkPath96 = leakArRay96[leakArRay96.length - 1];
					android.util.Log.d("leak-96", dataLeAkPath96);
					dismiss = true;
                    dismissRight = deltaX > 0;
                } else if (mMinFlingVelocity <= absVelocityX && absVelocityX <= mMaxFlingVelocity
                        && absVelocityY < absVelocityX
                        && absVelocityY < absVelocityX && mSwiping) {
                    String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP97 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP97.put("test", new java.util.HashMap<String, String>());
							leakMaP97.get("test").put("test", dataLeAk97);
							String dataLeAkPath97 = leakMaP97.get("test").get("test");
							android.util.Log.d("leak-97", dataLeAkPath97);
					// dismiss only if flinging in the same direction as dragging
                    dismiss = (velocityX < 0) == (deltaX < 0);
                    dismissRight = mVelocityTracker.getXVelocity() > 0;
                }
                if (dismiss) {
                    String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer98 = new StringBuffer();for (char chAr98 : dataLeAk98.toCharArray()) {leakBuFFer98.append(chAr98);}String dataLeAkPath98 = leakBuFFer98.toString();
					android.util.Log.d("leak-98", dataLeAkPath98);
					// dismiss
                    if (Build.VERSION.SDK_INT >= 12) {
                        String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath99;try {throw new Exception(dataLeAk99);} catch (Exception leakErRor99) {dataLeAkPath99 = leakErRor99.getMessage();}
						android.util.Log.d("leak-99", dataLeAkPath99);
						mView.animate()
                                .translationX(dismissRight ? mViewWidth : -mViewWidth)
                                .alpha(0)
                                .setDuration(mAnimationTime)
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String[] leakArRay100 = new String[] {"n/a", dataLeAk100};
										String dataLeAkPath100 = leakArRay100[leakArRay100.length - 1];
										android.util.Log.d("leak-100", dataLeAkPath100);
										performDismiss();
                                    }
                                });
                    } else {
                        String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP101 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP101.put("test", new java.util.HashMap<String, String>());
						leakMaP101.get("test").put("test", dataLeAk101);
						String dataLeAkPath101 = leakMaP101.get("test").get("test");
						android.util.Log.d("leak-101", dataLeAkPath101);
						performDismiss();
                    }
                } else if (mSwiping) {
                    String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer102 = new StringBuffer();for (char chAr102 : dataLeAk102.toCharArray()) {leakBuFFer102.append(chAr102);}String dataLeAkPath102 = leakBuFFer102.toString();
					android.util.Log.d("leak-102", dataLeAkPath102);
					// cancel
                    if (Build.VERSION.SDK_INT >= 12) {
                        String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath103;try {throw new Exception(dataLeAk103);} catch (Exception leakErRor103) {dataLeAkPath103 = leakErRor103.getMessage();}
						android.util.Log.d("leak-103", dataLeAkPath103);
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
                String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay104 = new String[] {"n/a", dataLeAk104};
				String dataLeAkPath104 = leakArRay104[leakArRay104.length - 1];
				android.util.Log.d("leak-104", dataLeAkPath104);
				if (mVelocityTracker == null) {
                    String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP105 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP105.put("test", new java.util.HashMap<String, String>());
					leakMaP105.get("test").put("test", dataLeAk105);
					String dataLeAkPath105 = leakMaP105.get("test").get("test");
					android.util.Log.d("leak-105", dataLeAkPath105);
					break;
                }
                if (Build.VERSION.SDK_INT >= 12) {
                    String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer106 = new StringBuffer();for (char chAr106 : dataLeAk106.toCharArray()) {leakBuFFer106.append(chAr106);}String dataLeAkPath106 = leakBuFFer106.toString();
					android.util.Log.d("leak-106", dataLeAkPath106);
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
                String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath107;try {throw new Exception(dataLeAk107);} catch (Exception leakErRor107) {dataLeAkPath107 = leakErRor107.getMessage();}
				android.util.Log.d("leak-107", dataLeAkPath107);
				if (mVelocityTracker == null) {
                    String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay108 = new String[] {"n/a", dataLeAk108};
					String dataLeAkPath108 = leakArRay108[leakArRay108.length - 1];
					android.util.Log.d("leak-108", dataLeAkPath108);
					break;
                }

                mVelocityTracker.addMovement(motionEvent);
                float deltaX = motionEvent.getRawX() - mDownX;
                float deltaY = motionEvent.getRawY() - mDownY;
                if (Math.abs(deltaX) > mSlop && Math.abs(deltaY) < Math.abs(deltaX) / 2) {
                    String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP109 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP109.put("test", new java.util.HashMap<String, String>());
					leakMaP109.get("test").put("test", dataLeAk109);
					String dataLeAkPath109 = leakMaP109.get("test").get("test");
					android.util.Log.d("leak-109", dataLeAkPath109);
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
                    String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer110 = new StringBuffer();for (char chAr110 : dataLeAk110.toCharArray()) {leakBuFFer110.append(chAr110);}String dataLeAkPath110 = leakBuFFer110.toString();
					android.util.Log.d("leak-110", dataLeAkPath110);
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

        String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath111;try {throw new Exception(dataLeAk111);} catch (Exception leakErRor111) {dataLeAkPath111 = leakErRor111.getMessage();}
		android.util.Log.d("leak-111", dataLeAkPath111);
		final ViewGroup.LayoutParams lp = mView.getLayoutParams();
        final int originalHeight = mView.getHeight();

        ValueAnimator animator = ValueAnimator.ofInt(originalHeight, 1).setDuration(mAnimationTime);

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay112 = new String[] {"n/a", dataLeAk112};
				String dataLeAkPath112 = leakArRay112[leakArRay112.length - 1];
				android.util.Log.d("leak-112", dataLeAkPath112);
				mCallbacks.onDismiss(mView, mToken);
                // Reset view presentation
                mView.setAlpha(1f);
                mView.setTranslationX(0);
                lp.height = originalHeight;
                mView.setLayoutParams(lp);
            }
        });

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP113 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP113.put("test", new java.util.HashMap<String, String>());
				leakMaP113.get("test").put("test", dataLeAk113);
				String dataLeAkPath113 = leakMaP113.get("test").get("test");
				android.util.Log.d("leak-113", dataLeAkPath113);
				lp.height = (Integer) valueAnimator.getAnimatedValue();
                mView.setLayoutParams(lp);
            }
        });

        animator.start();
    }
}
