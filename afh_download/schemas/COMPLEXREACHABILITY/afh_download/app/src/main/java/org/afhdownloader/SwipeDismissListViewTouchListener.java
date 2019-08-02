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
        String dataLeAk228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay228 = new String[] {"n/a", dataLeAk228};
		String dataLeAkPath228 = leakArRay228[leakArRay228.length - 1];
		android.util.Log.d("leak-228", dataLeAkPath228);
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
        String dataLeAk229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP229 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP229.put("test", new java.util.HashMap<String, String>());
		leakMaP229.get("test").put("test", dataLeAk229);
		String dataLeAkPath229 = leakMaP229.get("test").get("test");
		android.util.Log.d("leak-229", dataLeAkPath229);
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
        String dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer230 = new StringBuffer();for (char chAr230 : dataLeAk230.toCharArray()) {leakBuFFer230.append(chAr230);}String dataLeAkPath230 = leakBuFFer230.toString();
		android.util.Log.d("leak-230", dataLeAkPath230);
		return new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                String dataLeAk231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath231;try {throw new Exception(dataLeAk231);} catch (Exception leakErRor231) {dataLeAkPath231 = leakErRor231.getMessage();}
				android.util.Log.d("leak-231", dataLeAkPath231);
				setEnabled(scrollState != AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
				String dataLeAk232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay232 = new String[] {"n/a", dataLeAk232};
				String dataLeAkPath232 = leakArRay232[leakArRay232.length - 1];
				android.util.Log.d("leak-232", dataLeAkPath232);
            }
        };
    }

    @TargetApi(12)
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        String dataLeAk233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP233 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP233.put("test", new java.util.HashMap<String, String>());
		leakMaP233.get("test").put("test", dataLeAk233);
		String dataLeAkPath233 = leakMaP233.get("test").get("test");
		android.util.Log.d("leak-233", dataLeAkPath233);
		if (mViewWidth < 2) {
            String dataLeAk234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer234 = new StringBuffer();for (char chAr234 : dataLeAk234.toCharArray()) {leakBuFFer234.append(chAr234);}String dataLeAkPath234 = leakBuFFer234.toString();
			android.util.Log.d("leak-234", dataLeAkPath234);
			mViewWidth = mListView.getWidth();
        }

        switch (motionEvent.getActionMasked()) {
            case MotionEvent.ACTION_DOWN: {
                String dataLeAk235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath235;try {throw new Exception(dataLeAk235);} catch (Exception leakErRor235) {dataLeAkPath235 = leakErRor235.getMessage();}
				android.util.Log.d("leak-235", dataLeAkPath235);
				if (mPaused) {
                    String dataLeAk236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay236 = new String[] {"n/a", dataLeAk236};
					String dataLeAkPath236 = leakArRay236[leakArRay236.length - 1];
					android.util.Log.d("leak-236", dataLeAkPath236);
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
                    String dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP237 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP237.put("test", new java.util.HashMap<String, String>());
					leakMaP237.get("test").put("test", dataLeAk237);
					String dataLeAkPath237 = leakMaP237.get("test").get("test");
					android.util.Log.d("leak-237", dataLeAkPath237);
					child = mListView.getChildAt(i);
                    child.getHitRect(rect);
                    if (rect.contains(x, y)) {
                        String dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer238 = new StringBuffer();for (char chAr238 : dataLeAk238.toCharArray()) {leakBuFFer238.append(chAr238);}String dataLeAkPath238 = leakBuFFer238.toString();
						android.util.Log.d("leak-238", dataLeAkPath238);
						mDownView = child;
                        break;
                    }
                }

                if (mDownView != null) {
                    String dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath239;try {throw new Exception(dataLeAk239);} catch (Exception leakErRor239) {dataLeAkPath239 = leakErRor239.getMessage();}
					android.util.Log.d("leak-239", dataLeAkPath239);
					mDownX = motionEvent.getRawX();
                    mDownY = motionEvent.getRawY();
                    mDownPosition = mListView.getPositionForView(mDownView);
                    if (mCallbacks.canDismiss(mDownPosition)) {
                        String dataLeAk240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay240 = new String[] {"n/a", dataLeAk240};
						String dataLeAkPath240 = leakArRay240[leakArRay240.length - 1];
						android.util.Log.d("leak-240", dataLeAkPath240);
						mVelocityTracker = VelocityTracker.obtain();
                        mVelocityTracker.addMovement(motionEvent);
                    } else {
                        String dataLeAk241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP241 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP241.put("test", new java.util.HashMap<String, String>());
						leakMaP241.get("test").put("test", dataLeAk241);
						String dataLeAkPath241 = leakMaP241.get("test").get("test");
						android.util.Log.d("leak-241", dataLeAkPath241);
						mDownView = null;
                    }
                }
                return false;
            }

            case MotionEvent.ACTION_CANCEL: {
                String dataLeAk242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer242 = new StringBuffer();for (char chAr242 : dataLeAk242.toCharArray()) {leakBuFFer242.append(chAr242);}String dataLeAkPath242 = leakBuFFer242.toString();
				android.util.Log.d("leak-242", dataLeAkPath242);
				if (mVelocityTracker == null) {
                    String dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath243;try {throw new Exception(dataLeAk243);} catch (Exception leakErRor243) {dataLeAkPath243 = leakErRor243.getMessage();}
					android.util.Log.d("leak-243", dataLeAkPath243);
					break;
                }

                if (mDownView != null && mSwiping) {
                    String dataLeAk244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay244 = new String[] {"n/a", dataLeAk244};
					String dataLeAkPath244 = leakArRay244[leakArRay244.length - 1];
					android.util.Log.d("leak-244", dataLeAkPath244);
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
                String dataLeAk245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP245 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP245.put("test", new java.util.HashMap<String, String>());
				leakMaP245.get("test").put("test", dataLeAk245);
				String dataLeAkPath245 = leakMaP245.get("test").get("test");
				android.util.Log.d("leak-245", dataLeAkPath245);
				if (mVelocityTracker == null) {
                    String dataLeAk246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer246 = new StringBuffer();for (char chAr246 : dataLeAk246.toCharArray()) {leakBuFFer246.append(chAr246);}String dataLeAkPath246 = leakBuFFer246.toString();
					android.util.Log.d("leak-246", dataLeAkPath246);
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
                    String dataLeAk247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath247;try {throw new Exception(dataLeAk247);} catch (Exception leakErRor247) {dataLeAkPath247 = leakErRor247.getMessage();}
					android.util.Log.d("leak-247", dataLeAkPath247);
					dismiss = true;
                    dismissRight = deltaX > 0;
                } else if (mMinFlingVelocity <= absVelocityX && absVelocityX <= mMaxFlingVelocity
                        && absVelocityY < absVelocityX && mSwiping) {
                    String dataLeAk248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay248 = new String[] {"n/a", dataLeAk248};
							String dataLeAkPath248 = leakArRay248[leakArRay248.length - 1];
							android.util.Log.d("leak-248", dataLeAkPath248);
					// dismiss only if flinging in the same direction as dragging
                    dismiss = (velocityX < 0) == (deltaX < 0);
                    dismissRight = mVelocityTracker.getXVelocity() > 0;
                }
                if (dismiss && mDownPosition != ListView.INVALID_POSITION) {
                    String dataLeAk249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP249 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP249.put("test", new java.util.HashMap<String, String>());
					leakMaP249.get("test").put("test", dataLeAk249);
					String dataLeAkPath249 = leakMaP249.get("test").get("test");
					android.util.Log.d("leak-249", dataLeAkPath249);
					// dismiss
                    final View downView = mDownView; // mDownView gets null'd before animation ends
                    final int downPosition = mDownPosition;
                    ++mDismissAnimationRefCount;
                    if (Build.VERSION.SDK_INT >= 12) {
                        String dataLeAk250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer250 = new StringBuffer();for (char chAr250 : dataLeAk250.toCharArray()) {leakBuFFer250.append(chAr250);}String dataLeAkPath250 = leakBuFFer250.toString();
						android.util.Log.d("leak-250", dataLeAkPath250);
						mDownView.animate()
                                .translationX(dismissRight ? mViewWidth : -mViewWidth)
                                .alpha(0)
                                .setDuration(mAnimationTime)
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        String dataLeAk251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String dataLeAkPath251;try {throw new Exception(dataLeAk251);} catch (Exception leakErRor251) {dataLeAkPath251 = leakErRor251.getMessage();}
										android.util.Log.d("leak-251", dataLeAkPath251);
										performDismiss(downView, downPosition);
                                    }
                                });
                    } else {
                        String dataLeAk252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay252 = new String[] {"n/a", dataLeAk252};
						String dataLeAkPath252 = leakArRay252[leakArRay252.length - 1];
						android.util.Log.d("leak-252", dataLeAkPath252);
						performDismiss(downView, downPosition);
                    }
                } else {
                    String dataLeAk253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP253 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP253.put("test", new java.util.HashMap<String, String>());
					leakMaP253.get("test").put("test", dataLeAk253);
					String dataLeAkPath253 = leakMaP253.get("test").get("test");
					android.util.Log.d("leak-253", dataLeAkPath253);
					// cancel
                    if (Build.VERSION.SDK_INT >= 12) {
                        String dataLeAk254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer254 = new StringBuffer();for (char chAr254 : dataLeAk254.toCharArray()) {leakBuFFer254.append(chAr254);}String dataLeAkPath254 = leakBuFFer254.toString();
						android.util.Log.d("leak-254", dataLeAkPath254);
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
                String dataLeAk255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath255;try {throw new Exception(dataLeAk255);} catch (Exception leakErRor255) {dataLeAkPath255 = leakErRor255.getMessage();}
				android.util.Log.d("leak-255", dataLeAkPath255);
				if (mVelocityTracker == null || mPaused) {
                    String dataLeAk256 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay256 = new String[] {"n/a", dataLeAk256};
					String dataLeAkPath256 = leakArRay256[leakArRay256.length - 1];
					android.util.Log.d("leak-256", dataLeAkPath256);
					break;
                }

                mVelocityTracker.addMovement(motionEvent);
                float deltaX = motionEvent.getRawX() - mDownX;
                float deltaY = motionEvent.getRawY() - mDownY;
                if (Math.abs(deltaX) > mSlop && Math.abs(deltaY) < Math.abs(deltaX) / 2) {
                    String dataLeAk257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP257 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP257.put("test", new java.util.HashMap<String, String>());
					leakMaP257.get("test").put("test", dataLeAk257);
					String dataLeAkPath257 = leakMaP257.get("test").get("test");
					android.util.Log.d("leak-257", dataLeAkPath257);
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
                    String dataLeAk258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer258 = new StringBuffer();for (char chAr258 : dataLeAk258.toCharArray()) {leakBuFFer258.append(chAr258);}String dataLeAkPath258 = leakBuFFer258.toString();
					android.util.Log.d("leak-258", dataLeAkPath258);
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
        public int position;
        public View view;

        public PendingDismissData(int position, View view) {
            String dataLeAk259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath259;try {throw new Exception(dataLeAk259);} catch (Exception leakErRor259) {dataLeAkPath259 = leakErRor259.getMessage();}
			android.util.Log.d("leak-259", dataLeAkPath259);
			this.position = position;
            this.view = view;
        }

        @Override
        public int compareTo(PendingDismissData other) {
            String dataLeAk260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay260 = new String[] {"n/a", dataLeAk260};
			String dataLeAkPath260 = leakArRay260[leakArRay260.length - 1];
			android.util.Log.d("leak-260", dataLeAkPath260);
			// Sort by descending position
            return other.position - position;
        }
    }

    private void performDismiss(final View dismissView, final int dismissPosition) {
        // Animate the dismissed list item to zero-height and fire the dismiss callback when
        // all dismissed list item animations have completed. This triggers layout on each animation
        // frame; in the future we may want to do something smarter and more performant.

        String dataLeAk261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP261 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP261.put("test", new java.util.HashMap<String, String>());
		leakMaP261.get("test").put("test", dataLeAk261);
		String dataLeAkPath261 = leakMaP261.get("test").get("test");
		android.util.Log.d("leak-261", dataLeAkPath261);
		final ViewGroup.LayoutParams lp = dismissView.getLayoutParams();
        final int originalHeight = dismissView.getHeight();

        ValueAnimator animator = ValueAnimator.ofInt(originalHeight, 1).setDuration(mAnimationTime);

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                String dataLeAk262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer262 = new StringBuffer();for (char chAr262 : dataLeAk262.toCharArray()) {leakBuFFer262.append(chAr262);}String dataLeAkPath262 = leakBuFFer262.toString();
				android.util.Log.d("leak-262", dataLeAkPath262);
				--mDismissAnimationRefCount;
                if (mDismissAnimationRefCount == 0) {
                    String dataLeAk263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath263;try {throw new Exception(dataLeAk263);} catch (Exception leakErRor263) {dataLeAkPath263 = leakErRor263.getMessage();}
					android.util.Log.d("leak-263", dataLeAkPath263);
					// No active animations, process all pending dismisses.
                    // Sort by descending position
                    Collections.sort(mPendingDismisses);

                    int[] dismissPositions = new int[mPendingDismisses.size()];
                    for (int i = mPendingDismisses.size() - 1; i >= 0; i--) {
                        String dataLeAk264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay264 = new String[] {"n/a", dataLeAk264};
						String dataLeAkPath264 = leakArRay264[leakArRay264.length - 1];
						android.util.Log.d("leak-264", dataLeAkPath264);
						dismissPositions[i] = mPendingDismisses.get(i).position;
                    }
                    mCallbacks.onDismiss(mListView, dismissPositions);

                    // Reset mDownPosition to avoid MotionEvent.ACTION_UP trying to start a dismiss
                    // animation with a stale position
                    mDownPosition = ListView.INVALID_POSITION;

                    ViewGroup.LayoutParams lp;
                    for (PendingDismissData pendingDismiss : mPendingDismisses) {
                        String dataLeAk265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP265 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP265.put("test", new java.util.HashMap<String, String>());
						leakMaP265.get("test").put("test", dataLeAk265);
						String dataLeAkPath265 = leakMaP265.get("test").get("test");
						android.util.Log.d("leak-265", dataLeAkPath265);
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
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                String dataLeAk266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer266 = new StringBuffer();for (char chAr266 : dataLeAk266.toCharArray()) {leakBuFFer266.append(chAr266);}String dataLeAkPath266 = leakBuFFer266.toString();
				android.util.Log.d("leak-266", dataLeAkPath266);
				lp.height = (Integer) valueAnimator.getAnimatedValue();
                dismissView.setLayoutParams(lp);
            }
        });

        mPendingDismisses.add(new PendingDismissData(dismissPosition, dismissView));
        animator.start();
    }
}
