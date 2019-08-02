package org.afhdownloader;

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
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A {@link View.OnTouchListener} that makes the list items in a {@link ListView}
 * dismissable. {@link ListView} is given special treatment because by default it handles touches
 * for its list items... i.e. it's in charge of drawing the pressed state (the list selector),
 * handling list item clicks, etc.
 *
 * <p>After creating the listener, the caller should also call
 * {@link ListView#setOnScrollListener(AbsListView.OnScrollListener)}, passing
 * in the scroll listener returned by {@link #makeScrollListener()}. If a scroll listener is
 * already assigned, the caller should still pass scroll changes through to this listener. This will
 * ensure that this {@link SwipeDismissListViewTouchListener} is paused during list view
 * scrolling.</p>
 *
 * <p>Example usage:</p>
 *
 * <pre>
 * SwipeDismissListViewTouchListener touchListener =
 *         new SwipeDismissListViewTouchListener(
 *                 listView,
 *                 new SwipeDismissListViewTouchListener.OnDismissCallback() {
 *                     public void onDismiss(ListView listView, int[] reverseSortedPositions) {
 *                         for (int position : reverseSortedPositions) {
 *                             adapter.remove(adapter.getItem(position));
 *                         }
 *                         adapter.notifyDataSetChanged();
 *                     }
 *                 });
 * listView.setOnTouchListener(touchListener);
 * listView.setOnScrollListener(touchListener.makeScrollListener());
 * </pre>
 *
 * <p>This class Requires API level 12 or later due to use of {@link
 * ViewPropertyAnimator}.</p>
 *
 * <p>For a generalized {@link View.OnTouchListener} that makes any view dismissable,
 * see {@link SwipeDismissTouchListener}.</p>
 *
 * @see SwipeDismissTouchListener
 */
public class SwipeDismissListViewTouchListener implements View.OnTouchListener {
    final String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk99 = "";

	String dataLeAk98 = "";

	String dataLeAk96 = "";

	String dataLeAk93 = "";

	String dataLeAk90 = "";

	String dataLeAk89 = "";

	String dataLeAk88 = "";

	// Cached ViewConfiguration and system-wide constant values
    private int mSlop;
    private int mMinFlingVelocity;
    private int mMaxFlingVelocity;
    private long mAnimationTime;

    // Fixed properties
    private ListView mListView;
    private DismissCallbacks mCallbacks;
    private int mViewWidth = 1; // 1 and not 0 to prevent dividing by zero

    // Transient properties
    private List<PendingDismissData> mPendingDismisses = new ArrayList<PendingDismissData>();
    private int mDismissAnimationRefCount = 0;
    private float mDownX;
    private float mDownY;
    private boolean mSwiping;
    private int mSwipingSlop;
    private VelocityTracker mVelocityTracker;
    private int mDownPosition;
    private View mDownView;
    private boolean mPaused;

    /**
     * The callback interface used by {@link SwipeDismissListViewTouchListener} to inform its client
     * about a successful dismissal of one or more list item positions.
     */
    public interface DismissCallbacks {
        /**
         * Called to determine whether the given position can be dismissed.
         */
        boolean canDismiss(int position);

        /**
         * Called when the user has indicated they she would like to dismiss one or more list item
         * positions.
         *
         * @param listView               The originating {@link ListView}.
         * @param reverseSortedPositions An array of positions to dismiss, sorted in descending
         *                               order for convenience.
         */
        void onDismiss(ListView listView, int[] reverseSortedPositions);
    }

    /**
     * Constructs a new swipe-to-dismiss touch listener for the given list view.
     *
     * @param listView  The list view whose items should be dismissable.
     * @param callbacks The callback to trigger when the user has indicated that she would like to
     *                  dismiss one or more list items.
     */
    public SwipeDismissListViewTouchListener(ListView listView, DismissCallbacks callbacks) {
        dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-88-0", dataLeAk88);
		android.util.Log.d("leak-89-0", dataLeAk89);
		android.util.Log.d("leak-90-0", dataLeAk90);
		android.util.Log.d("leak-93-0", dataLeAk93);
		android.util.Log.d("leak-96-0", dataLeAk96);
		android.util.Log.d("leak-98-0", dataLeAk98);
		android.util.Log.d("leak-99-0", dataLeAk99);
		ViewConfiguration vc = ViewConfiguration.get(listView.getContext());
        mSlop = vc.getScaledTouchSlop();
        mMinFlingVelocity = vc.getScaledMinimumFlingVelocity() * 16;
        mMaxFlingVelocity = vc.getScaledMaximumFlingVelocity();
        mAnimationTime = listView.getContext().getResources().getInteger(
                android.R.integer.config_shortAnimTime);
        mListView = listView;
        mCallbacks = callbacks;
    }

    /**
     * Enables or disables (pauses or resumes) watching for swipe-to-dismiss gestures.
     *
     * @param enabled Whether or not to watch for gestures.
     */
    public void setEnabled(boolean enabled) {
        dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-88-1", dataLeAk88);
		android.util.Log.d("leak-89-1", dataLeAk89);
		android.util.Log.d("leak-90-1", dataLeAk90);
		android.util.Log.d("leak-93-1", dataLeAk93);
		android.util.Log.d("leak-96-1", dataLeAk96);
		android.util.Log.d("leak-98-1", dataLeAk98);
		android.util.Log.d("leak-99-1", dataLeAk99);
		mPaused = !enabled;
    }

    /**
     * Returns an {@link AbsListView.OnScrollListener} to be added to the {@link
     * ListView} using {@link ListView#setOnScrollListener(AbsListView.OnScrollListener)}.
     * If a scroll listener is already assigned, the caller should still pass scroll changes through
     * to this listener. This will ensure that this {@link SwipeDismissListViewTouchListener} is
     * paused during list view scrolling.</p>
     *
     * @see SwipeDismissListViewTouchListener
     */
    public AbsListView.OnScrollListener makeScrollListener() {
        dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-88-2", dataLeAk88);
		android.util.Log.d("leak-89-2", dataLeAk89);
		android.util.Log.d("leak-90-2", dataLeAk90);
		android.util.Log.d("leak-93-2", dataLeAk93);
		android.util.Log.d("leak-96-2", dataLeAk96);
		android.util.Log.d("leak-98-2", dataLeAk98);
		android.util.Log.d("leak-99-2", dataLeAk99);
		return new AbsListView.OnScrollListener() {
            String dataLeAk92 = "";

			String dataLeAk91 = "";

			@Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-103-0", dataLeAk103);
				android.util.Log.d("leak-91-0", dataLeAk91);
				android.util.Log.d("leak-92-0", dataLeAk92);
				setEnabled(scrollState != AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
				dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-104-0", dataLeAk104);
				android.util.Log.d("leak-91-1", dataLeAk91);
				android.util.Log.d("leak-92-1", dataLeAk92);
            }
        };
    }

    @TargetApi(12)
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-88-3", dataLeAk88);
		android.util.Log.d("leak-89-3", dataLeAk89);
		android.util.Log.d("leak-90-3", dataLeAk90);
		android.util.Log.d("leak-93-3", dataLeAk93);
		android.util.Log.d("leak-96-3", dataLeAk96);
		android.util.Log.d("leak-98-3", dataLeAk98);
		android.util.Log.d("leak-99-3", dataLeAk99);
		if (mViewWidth < 2) {
            mViewWidth = mListView.getWidth();
        }

        switch (motionEvent.getActionMasked()) {
            case MotionEvent.ACTION_DOWN: {
                if (mPaused) {
                    return false;
                }


                // Find the child view that was touched (perform a hit test)
                Rect rect = new Rect();
                int childCount = mListView.getChildCount();
                int[] listViewCoords = new int[2];
                mListView.getLocationOnScreen(listViewCoords);
                int x = (int) motionEvent.getRawX() - listViewCoords[0];
                int y = (int) motionEvent.getRawY() - listViewCoords[1];
                View child;
                for (int i = 0; i < childCount; i++) {
                    child = mListView.getChildAt(i);
                    child.getHitRect(rect);
                    if (rect.contains(x, y)) {
                        mDownView = child;
                        break;
                    }
                }

                if (mDownView != null) {
                    mDownX = motionEvent.getRawX();
                    mDownY = motionEvent.getRawY();
                    mDownPosition = mListView.getPositionForView(mDownView);
                    if (mCallbacks.canDismiss(mDownPosition)) {
                        mVelocityTracker = VelocityTracker.obtain();
                        mVelocityTracker.addMovement(motionEvent);
                    } else {
                        mDownView = null;
                    }
                }
                return false;
            }

            case MotionEvent.ACTION_CANCEL: {
                if (mVelocityTracker == null) {
                    break;
                }

                if (mDownView != null && mSwiping) {
                    // cancel
                    mDownView.animate()
                            .translationX(0)
                            .alpha(1)
                            .setDuration(mAnimationTime)
                            .setListener(null);
                }
                mVelocityTracker.recycle();
                mVelocityTracker = null;
                mDownX = 0;
                mDownY = 0;
                mDownView = null;
                mDownPosition = ListView.INVALID_POSITION;
                mSwiping = false;
                break;
            }

            case MotionEvent.ACTION_UP: {
                if (mVelocityTracker == null) {
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
                    dismiss = true;
                    dismissRight = deltaX > 0;
                } else if (mMinFlingVelocity <= absVelocityX && absVelocityX <= mMaxFlingVelocity
                        && absVelocityY < absVelocityX && mSwiping) {
                    // dismiss only if flinging in the same direction as dragging
                    dismiss = (velocityX < 0) == (deltaX < 0);
                    dismissRight = mVelocityTracker.getXVelocity() > 0;
                }
                if (dismiss && mDownPosition != ListView.INVALID_POSITION) {
                    // dismiss
                    final View downView = mDownView; // mDownView gets null'd before animation ends
                    final int downPosition = mDownPosition;
                    ++mDismissAnimationRefCount;
                    if (Build.VERSION.SDK_INT >= 12) {
                        mDownView.animate()
                                .translationX(dismissRight ? mViewWidth : -mViewWidth)
                                .alpha(0)
                                .setDuration(mAnimationTime)
                                .setListener(new AnimatorListenerAdapter() {
                                    String dataLeAk94 = "";

									@Override
                                    public void onAnimationEnd(Animator animation) {
                                        dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										android.util.Log.d("leak-105-0", dataLeAk105);
										android.util.Log.d("leak-94-0", dataLeAk94);
										performDismiss(downView, downPosition);
                                    }
                                });
                    } else {
                        performDismiss(downView, downPosition);
                    }
                } else {
                    // cancel
                    if (Build.VERSION.SDK_INT >= 12) {
                        mDownView.animate()
                                .translationX(0)
                                .alpha(1)
                                .setDuration(mAnimationTime)
                                .setListener(null);
                    }
                }
                mVelocityTracker.recycle();
                mVelocityTracker = null;
                mDownX = 0;
                mDownY = 0;
                mDownView = null;
                mDownPosition = ListView.INVALID_POSITION;
                mSwiping = false;
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                if (mVelocityTracker == null || mPaused) {
                    break;
                }

                mVelocityTracker.addMovement(motionEvent);
                float deltaX = motionEvent.getRawX() - mDownX;
                float deltaY = motionEvent.getRawY() - mDownY;
                if (Math.abs(deltaX) > mSlop && Math.abs(deltaY) < Math.abs(deltaX) / 2) {
                    mSwiping = true;
                    mSwipingSlop = (deltaX > 0 ? mSlop : -mSlop);
                    mListView.requestDisallowInterceptTouchEvent(true);

                    // Cancel ListView's touch (un-highlighting the item)
                    MotionEvent cancelEvent = MotionEvent.obtain(motionEvent);
                    cancelEvent.setAction(MotionEvent.ACTION_CANCEL |
                            (motionEvent.getActionIndex()
                                    << MotionEvent.ACTION_POINTER_INDEX_SHIFT));
                    mListView.onTouchEvent(cancelEvent);
                    cancelEvent.recycle();
                }

                if (mSwiping) {
                    mDownView.setTranslationX(deltaX - mSwipingSlop);
                    mDownView.setAlpha(Math.max(0f, Math.min(1f,
                            1f - 2f * Math.abs(deltaX) / mViewWidth)));
                    view.performClick();
                    return true;
                }
                break;
            }
        }
        return false;
    }

    class PendingDismissData implements Comparable<PendingDismissData> {
        String dataLeAk97 = "";

		String dataLeAk95 = "";

		public int position;
        public View view;

        public PendingDismissData(int position, View view) {
            dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-88-4", dataLeAk88);
			android.util.Log.d("leak-89-4", dataLeAk89);
			android.util.Log.d("leak-90-4", dataLeAk90);
			android.util.Log.d("leak-93-4", dataLeAk93);
			android.util.Log.d("leak-96-4", dataLeAk96);
			android.util.Log.d("leak-98-4", dataLeAk98);
			android.util.Log.d("leak-99-4", dataLeAk99);
			android.util.Log.d("leak-95-0", dataLeAk95);
			android.util.Log.d("leak-97-0", dataLeAk97);
			this.position = position;
            this.view = view;
        }

        @Override
        public int compareTo(PendingDismissData other) {
            dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-88-5", dataLeAk88);
			android.util.Log.d("leak-89-5", dataLeAk89);
			android.util.Log.d("leak-90-5", dataLeAk90);
			android.util.Log.d("leak-93-5", dataLeAk93);
			android.util.Log.d("leak-96-5", dataLeAk96);
			android.util.Log.d("leak-98-5", dataLeAk98);
			android.util.Log.d("leak-99-5", dataLeAk99);
			android.util.Log.d("leak-95-1", dataLeAk95);
			android.util.Log.d("leak-97-1", dataLeAk97);
			// Sort by descending position
            return other.position - position;
        }
    }

    private void performDismiss(final View dismissView, final int dismissPosition) {
        // Animate the dismissed list item to zero-height and fire the dismiss callback when
        // all dismissed list item animations have completed. This triggers layout on each animation
        // frame; in the future we may want to do something smarter and more performant.

        dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-88-6", dataLeAk88);
		android.util.Log.d("leak-89-6", dataLeAk89);
		android.util.Log.d("leak-90-6", dataLeAk90);
		android.util.Log.d("leak-93-6", dataLeAk93);
		android.util.Log.d("leak-96-6", dataLeAk96);
		android.util.Log.d("leak-98-6", dataLeAk98);
		android.util.Log.d("leak-99-6", dataLeAk99);
		final ViewGroup.LayoutParams lp = dismissView.getLayoutParams();
        final int originalHeight = dismissView.getHeight();

        ValueAnimator animator = ValueAnimator.ofInt(originalHeight, 1).setDuration(mAnimationTime);

        animator.addListener(new AnimatorListenerAdapter() {
            String dataLeAk100 = "";

			@Override
            public void onAnimationEnd(Animator animation) {
                dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-106-0", dataLeAk106);
				android.util.Log.d("leak-100-0", dataLeAk100);
				--mDismissAnimationRefCount;
                if (mDismissAnimationRefCount == 0) {
                    // No active animations, process all pending dismisses.
                    // Sort by descending position
                    Collections.sort(mPendingDismisses);

                    int[] dismissPositions = new int[mPendingDismisses.size()];
                    for (int i = mPendingDismisses.size() - 1; i >= 0; i--) {
                        dismissPositions[i] = mPendingDismisses.get(i).position;
                    }
                    mCallbacks.onDismiss(mListView, dismissPositions);

                    // Reset mDownPosition to avoid MotionEvent.ACTION_UP trying to start a dismiss
                    // animation with a stale position
                    mDownPosition = ListView.INVALID_POSITION;

                    ViewGroup.LayoutParams lp;
                    for (PendingDismissData pendingDismiss : mPendingDismisses) {
                        // Reset view presentation
                        pendingDismiss.view.setAlpha(1f);
                        pendingDismiss.view.setTranslationX(0);
                        lp = pendingDismiss.view.getLayoutParams();
                        lp.height = originalHeight;
                        pendingDismiss.view.setLayoutParams(lp);
                    }

                    // Send a cancel event
                    long time = SystemClock.uptimeMillis();
                    MotionEvent cancelEvent = MotionEvent.obtain(time, time,
                            MotionEvent.ACTION_CANCEL, 0, 0, 0);
                    mListView.dispatchTouchEvent(cancelEvent);

                    mPendingDismisses.clear();
                }
            }
        });

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            String dataLeAk101 = "";

			@Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-107-0", dataLeAk107);
				android.util.Log.d("leak-101-0", dataLeAk101);
				lp.height = (Integer) valueAnimator.getAnimatedValue();
                dismissView.setLayoutParams(lp);
            }
        });

        mPendingDismisses.add(new PendingDismissData(dismissPosition, dismissView));
        animator.start();
    }
}
