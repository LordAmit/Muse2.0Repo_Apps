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
    String dataLeAk105 = "105";

	String dataLeAk103 = "103";

	String dataLeAk101 = "101";

	String dataLeAk99 = "99";

	String dataLeAk97 = "97";

	String dataLeAk95 = "95";

	String dataLeAk94 = "94";

	String dataLeAk92 = "92";

	String dataLeAk90 = "90";

	String dataLeAk89 = "89";

	String dataLeAk88 = "88";

	String dataLeAk87 = "87";

	String dataLeAk85 = "85";

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
        String dataLeAk86 = "86";

		String dataLeAk84 = "84";

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
		android.util.Log.d("leak-85-60", dataLeAk85);
		android.util.Log.d("leak-87-60", dataLeAk87);
		android.util.Log.d("leak-88-60", dataLeAk88);
		android.util.Log.d("leak-89-60", dataLeAk89);
		android.util.Log.d("leak-90-60", dataLeAk90);
		android.util.Log.d("leak-92-60", dataLeAk92);
		android.util.Log.d("leak-94-60", dataLeAk94);
		android.util.Log.d("leak-95-60", dataLeAk95);
		android.util.Log.d("leak-97-60", dataLeAk97);
		android.util.Log.d("leak-99-60", dataLeAk99);
		android.util.Log.d("leak-101-60", dataLeAk101);
		android.util.Log.d("leak-103-60", dataLeAk103);
		android.util.Log.d("leak-105-60", dataLeAk105);
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
		android.util.Log.d("leak-85-61", dataLeAk85);
		android.util.Log.d("leak-87-61", dataLeAk87);
		android.util.Log.d("leak-88-61", dataLeAk88);
		android.util.Log.d("leak-89-61", dataLeAk89);
		android.util.Log.d("leak-90-61", dataLeAk90);
		android.util.Log.d("leak-92-61", dataLeAk92);
		android.util.Log.d("leak-94-61", dataLeAk94);
		android.util.Log.d("leak-95-61", dataLeAk95);
		android.util.Log.d("leak-97-61", dataLeAk97);
		android.util.Log.d("leak-99-61", dataLeAk99);
		android.util.Log.d("leak-101-61", dataLeAk101);
		android.util.Log.d("leak-103-61", dataLeAk103);
		android.util.Log.d("leak-105-61", dataLeAk105);
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
		android.util.Log.d("leak-85-62", dataLeAk85);
		android.util.Log.d("leak-87-62", dataLeAk87);
		android.util.Log.d("leak-88-62", dataLeAk88);
		android.util.Log.d("leak-89-62", dataLeAk89);
		android.util.Log.d("leak-90-62", dataLeAk90);
		android.util.Log.d("leak-92-62", dataLeAk92);
		android.util.Log.d("leak-94-62", dataLeAk94);
		android.util.Log.d("leak-95-62", dataLeAk95);
		android.util.Log.d("leak-97-62", dataLeAk97);
		android.util.Log.d("leak-99-62", dataLeAk99);
		android.util.Log.d("leak-101-62", dataLeAk101);
		android.util.Log.d("leak-103-62", dataLeAk103);
		android.util.Log.d("leak-105-62", dataLeAk105);
		return new AbsListView.OnScrollListener() {
            String dataLeAk93 = "93";

			String dataLeAk91 = "91";

			@Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				setEnabled(scrollState != AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
				dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
            }
        };
    }

    @TargetApi(12)
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-85-63", dataLeAk85);
		android.util.Log.d("leak-87-63", dataLeAk87);
		android.util.Log.d("leak-88-63", dataLeAk88);
		android.util.Log.d("leak-89-63", dataLeAk89);
		android.util.Log.d("leak-90-63", dataLeAk90);
		android.util.Log.d("leak-92-63", dataLeAk92);
		android.util.Log.d("leak-94-63", dataLeAk94);
		android.util.Log.d("leak-95-63", dataLeAk95);
		android.util.Log.d("leak-97-63", dataLeAk97);
		android.util.Log.d("leak-99-63", dataLeAk99);
		android.util.Log.d("leak-101-63", dataLeAk101);
		android.util.Log.d("leak-103-63", dataLeAk103);
		android.util.Log.d("leak-105-63", dataLeAk105);
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
                                    String dataLeAk96 = "96";

									@Override
                                    public void onAnimationEnd(Animator animation) {
                                        dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
        String dataLeAk100 = "100";

		String dataLeAk98 = "98";

		public int position;
        public View view;

        public PendingDismissData(int position, View view) {
            dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-98-64", dataLeAk98);
			android.util.Log.d("leak-100-64", dataLeAk100);
			android.util.Log.d("leak-85-64", dataLeAk85);
			android.util.Log.d("leak-87-64", dataLeAk87);
			android.util.Log.d("leak-88-64", dataLeAk88);
			android.util.Log.d("leak-89-64", dataLeAk89);
			android.util.Log.d("leak-90-64", dataLeAk90);
			android.util.Log.d("leak-92-64", dataLeAk92);
			android.util.Log.d("leak-94-64", dataLeAk94);
			android.util.Log.d("leak-95-64", dataLeAk95);
			android.util.Log.d("leak-97-64", dataLeAk97);
			android.util.Log.d("leak-99-64", dataLeAk99);
			android.util.Log.d("leak-101-64", dataLeAk101);
			android.util.Log.d("leak-103-64", dataLeAk103);
			android.util.Log.d("leak-105-64", dataLeAk105);
//			android.util.Log.d("leak-96-64", dataLeAk96);
//			android.util.Log.d("leak-91-64", dataLeAk91);
//			android.util.Log.d("leak-93-64", dataLeAk93);
//			android.util.Log.d("leak-84-64", dataLeAk84);
//			android.util.Log.d("leak-86-64", dataLeAk86);
			android.util.Log.d("leak-85-64", dataLeAk85);
			android.util.Log.d("leak-87-64", dataLeAk87);
			android.util.Log.d("leak-88-64", dataLeAk88);
			android.util.Log.d("leak-89-64", dataLeAk89);
			android.util.Log.d("leak-90-64", dataLeAk90);
			android.util.Log.d("leak-92-64", dataLeAk92);
			android.util.Log.d("leak-94-64", dataLeAk94);
			android.util.Log.d("leak-95-64", dataLeAk95);
			android.util.Log.d("leak-97-64", dataLeAk97);
			android.util.Log.d("leak-99-64", dataLeAk99);
			android.util.Log.d("leak-101-64", dataLeAk101);
			android.util.Log.d("leak-103-64", dataLeAk103);
			android.util.Log.d("leak-105-64", dataLeAk105);
//			android.util.Log.d("leak-96-64", dataLeAk96);
//			android.util.Log.d("leak-91-64", dataLeAk91);
//			android.util.Log.d("leak-93-64", dataLeAk93);
//			android.util.Log.d("leak-84-64", dataLeAk84);
//			android.util.Log.d("leak-86-64", dataLeAk86);
			android.util.Log.d("leak-85-64", dataLeAk85);
			android.util.Log.d("leak-87-64", dataLeAk87);
			android.util.Log.d("leak-88-64", dataLeAk88);
			android.util.Log.d("leak-89-64", dataLeAk89);
			android.util.Log.d("leak-90-64", dataLeAk90);
			android.util.Log.d("leak-92-64", dataLeAk92);
			android.util.Log.d("leak-94-64", dataLeAk94);
			android.util.Log.d("leak-95-64", dataLeAk95);
			android.util.Log.d("leak-97-64", dataLeAk97);
			android.util.Log.d("leak-99-64", dataLeAk99);
			android.util.Log.d("leak-101-64", dataLeAk101);
			android.util.Log.d("leak-103-64", dataLeAk103);
			android.util.Log.d("leak-105-64", dataLeAk105);
			dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			this.position = position;
            this.view = view;
        }

        @Override
        public int compareTo(PendingDismissData other) {
            dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-98-65", dataLeAk98);
			android.util.Log.d("leak-100-65", dataLeAk100);
//			android.util.Log.d("leak-96-65", dataLeAk96);
//			android.util.Log.d("leak-91-65", dataLeAk91);
//			android.util.Log.d("leak-93-65", dataLeAk93);
//			android.util.Log.d("leak-84-65", dataLeAk84);
//			android.util.Log.d("leak-86-65", dataLeAk86);
			android.util.Log.d("leak-85-65", dataLeAk85);
			android.util.Log.d("leak-87-65", dataLeAk87);
			android.util.Log.d("leak-88-65", dataLeAk88);
			android.util.Log.d("leak-89-65", dataLeAk89);
			android.util.Log.d("leak-90-65", dataLeAk90);
			android.util.Log.d("leak-92-65", dataLeAk92);
			android.util.Log.d("leak-94-65", dataLeAk94);
			android.util.Log.d("leak-95-65", dataLeAk95);
			android.util.Log.d("leak-97-65", dataLeAk97);
			android.util.Log.d("leak-99-65", dataLeAk99);
			android.util.Log.d("leak-101-65", dataLeAk101);
			android.util.Log.d("leak-103-65", dataLeAk103);
			android.util.Log.d("leak-105-65", dataLeAk105);
//			android.util.Log.d("leak-96-65", dataLeAk96);
//			android.util.Log.d("leak-91-65", dataLeAk91);
//			android.util.Log.d("leak-93-65", dataLeAk93);
//			android.util.Log.d("leak-84-65", dataLeAk84);
//			android.util.Log.d("leak-86-65", dataLeAk86);
			android.util.Log.d("leak-85-65", dataLeAk85);
			android.util.Log.d("leak-87-65", dataLeAk87);
			android.util.Log.d("leak-88-65", dataLeAk88);
			android.util.Log.d("leak-89-65", dataLeAk89);
			android.util.Log.d("leak-90-65", dataLeAk90);
			android.util.Log.d("leak-92-65", dataLeAk92);
			android.util.Log.d("leak-94-65", dataLeAk94);
			android.util.Log.d("leak-95-65", dataLeAk95);
			android.util.Log.d("leak-97-65", dataLeAk97);
			android.util.Log.d("leak-99-65", dataLeAk99);
			android.util.Log.d("leak-101-65", dataLeAk101);
			android.util.Log.d("leak-103-65", dataLeAk103);
			android.util.Log.d("leak-105-65", dataLeAk105);
//			android.util.Log.d("leak-96-65", dataLeAk96);
//			android.util.Log.d("leak-91-65", dataLeAk91);
//			android.util.Log.d("leak-93-65", dataLeAk93);
//			android.util.Log.d("leak-84-65", dataLeAk84);
//			android.util.Log.d("leak-86-65", dataLeAk86);
			android.util.Log.d("leak-85-65", dataLeAk85);
			android.util.Log.d("leak-87-65", dataLeAk87);
			android.util.Log.d("leak-88-65", dataLeAk88);
			android.util.Log.d("leak-89-65", dataLeAk89);
			android.util.Log.d("leak-90-65", dataLeAk90);
			android.util.Log.d("leak-92-65", dataLeAk92);
			android.util.Log.d("leak-94-65", dataLeAk94);
			android.util.Log.d("leak-95-65", dataLeAk95);
			android.util.Log.d("leak-97-65", dataLeAk97);
			android.util.Log.d("leak-99-65", dataLeAk99);
			android.util.Log.d("leak-101-65", dataLeAk101);
			android.util.Log.d("leak-103-65", dataLeAk103);
			android.util.Log.d("leak-105-65", dataLeAk105);
			dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			// Sort by descending position
            return other.position - position;
        }
    }

    private void performDismiss(final View dismissView, final int dismissPosition) {
        // Animate the dismissed list item to zero-height and fire the dismiss callback when
        // all dismissed list item animations have completed. This triggers layout on each animation
        // frame; in the future we may want to do something smarter and more performant.

        final ViewGroup.LayoutParams lp = dismissView.getLayoutParams();
		android.util.Log.d("leak-85-66", dataLeAk85);
		android.util.Log.d("leak-87-66", dataLeAk87);
		android.util.Log.d("leak-88-66", dataLeAk88);
		android.util.Log.d("leak-89-66", dataLeAk89);
		android.util.Log.d("leak-90-66", dataLeAk90);
		android.util.Log.d("leak-92-66", dataLeAk92);
		android.util.Log.d("leak-94-66", dataLeAk94);
		android.util.Log.d("leak-95-66", dataLeAk95);
		android.util.Log.d("leak-97-66", dataLeAk97);
		android.util.Log.d("leak-99-66", dataLeAk99);
		android.util.Log.d("leak-101-66", dataLeAk101);
		android.util.Log.d("leak-103-66", dataLeAk103);
		android.util.Log.d("leak-105-66", dataLeAk105);
        final int originalHeight = dismissView.getHeight();

        ValueAnimator animator = ValueAnimator.ofInt(originalHeight, 1).setDuration(mAnimationTime);

        animator.addListener(new AnimatorListenerAdapter() {
            String dataLeAk102 = "102";

			@Override
            public void onAnimationEnd(Animator animation) {
                dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk104 = "104";

			@Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				lp.height = (Integer) valueAnimator.getAnimatedValue();
                dismissView.setLayoutParams(lp);
            }
        });

        mPendingDismisses.add(new PendingDismissData(dismissPosition, dismissView));
        animator.start();
    }
}
