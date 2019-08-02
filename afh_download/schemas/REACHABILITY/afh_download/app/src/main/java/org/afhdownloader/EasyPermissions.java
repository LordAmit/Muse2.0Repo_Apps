package org.afhdownloader;

/*
 * Copyright Google Inc. All Rights Reserved.
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

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utility to request and check System permissions for apps targeting Android M (API >= 23).
 */
public class EasyPermissions {

    String dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk201 = android.util.Log.d("leak-201", dataLeAk201);

	private static final String TAG = "EasyPermissions";

    public interface PermissionCallbacks extends
            ActivityCompat.OnRequestPermissionsResultCallback {

        void onPermissionsGranted(int requestCode, List<String> perms);

        void onPermissionsDenied(int requestCode, List<String> perms);

    }

    /**
     * Check if the calling context has a set of permissions.
     *
     * @param context the calling context.
     * @param perms   one ore more permissions, such as {@code android.Manifest.permission.CAMERA}.
     * @return true if all permissions are already granted, false if at least one permission
     * is not yet granted.
     */
    public static boolean hasPermissions(Context context, String... perms) {
        String dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk202 = android.util.Log.d("leak-202", dataLeAk202);
		for (String perm : perms) {
            String dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk203 = android.util.Log.d("leak-203", dataLeAk203);
			boolean hasPerm = (ContextCompat.checkSelfPermission(context, perm) == PackageManager.PERMISSION_GRANTED);
            if (!hasPerm) {
                String dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk204 = android.util.Log.d("leak-204", dataLeAk204);
				return false;
            }
        }

        return true;
    }

    /**
     * Request a set of permissions, showing rationale if the system requests it.
     *
     * @param object      Activity or Fragment requesting permissions. Should implement
     *                    {@link android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback}
     *                    or
     *                    {@link android.support.v13.app.FragmentCompat.OnRequestPermissionsResultCallback}
     * @param rationale   a message explaining why the application needs this set of permissions, will
     *                    be displayed if the user rejects the request the first time.
     * @param requestCode request code to track this request, must be < 256.
     * @param perms       a set of permissions to be requested.
     */
    public static void requestPermissions(final Object object, String rationale,
                                          final int requestCode, final String... perms) {
        String dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk205 = android.util.Log.d("leak-205", dataLeAk205);
		requestPermissions(object, rationale,
                android.R.string.ok,
                android.R.string.cancel,
                requestCode, perms);
    }

    /**
     * Request a set of permissions, showing rationale if the system requests it.
     *
     * @param object         Activity or Fragment requesting permissions. Should implement
     *                       {@link android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback}
     *                       or
     *                       {@link android.support.v13.app.FragmentCompat.OnRequestPermissionsResultCallback}
     * @param rationale      a message explaining why the application needs this set of permissions, will
     *                       be displayed if the user rejects the request the first time.
     * @param positiveButton custom text for positive button
     * @param negativeButton custom text for negative button
     * @param requestCode    request code to track this request, must be < 256.
     * @param perms          a set of permissions to be requested.
     */
    public static void requestPermissions(final Object object, String rationale,
                                          @StringRes int positiveButton,
                                          @StringRes int negativeButton,
                                          final int requestCode, final String... perms) {

        String dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk206 = android.util.Log.d("leak-206", dataLeAk206);
		checkCallingObjectSuitability(object);
        final PermissionCallbacks callbacks = (PermissionCallbacks) object;

        boolean shouldShowRationale = false;
        for (String perm : perms) {
            String dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk207 = android.util.Log.d("leak-207", dataLeAk207);
			shouldShowRationale = shouldShowRationale || shouldShowRequestPermissionRationale(object, perm);
        }

        if (shouldShowRationale) {
            String dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk208 = android.util.Log.d("leak-208", dataLeAk208);
			AlertDialog dialog = new AlertDialog.Builder(getActivity(object))
                    .setMessage(rationale)
                    .setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
                        String dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk209 = android.util.Log.d("leak-209", dataLeAk209);

						@Override
                        public void onClick(DialogInterface dialog, int which) {
                            String dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk210 = android.util.Log.d("leak-210", dataLeAk210);
							executePermissionsRequest(object, perms, requestCode);
                        }
                    })
                    .setNegativeButton(negativeButton, new DialogInterface.OnClickListener() {
                        String dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk211 = android.util.Log.d("leak-211", dataLeAk211);

						@Override
                        public void onClick(DialogInterface dialog, int which) {
                            String dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk212 = android.util.Log.d("leak-212", dataLeAk212);
							// act as if the permissions were denied
                            callbacks.onPermissionsDenied(requestCode, Arrays.asList(perms));
                        }
                    }).create();
            dialog.show();
        } else {
            String dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk213 = android.util.Log.d("leak-213", dataLeAk213);
			executePermissionsRequest(object, perms, requestCode);
        }
    }

    /**
     * Handle the result of a permission request, should be called from the calling Activity's
     * {@link android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback#onRequestPermissionsResult(int, String[], int[])}
     * method.
     * <p/>
     * If any permissions were granted or denied, the Activity will receive the appropriate
     * callbacks through {@link PermissionCallbacks} and methods annotated with
     * {@link AfterPermissionGranted} will be run if appropriate.
     *
     * @param requestCode  requestCode argument to permission result callback.
     * @param permissions  permissions argument to permission result callback.
     * @param grantResults grantResults argument to permission result callback.
     * @param object       the calling Activity or Fragment.
     * @throws IllegalArgumentException if the calling Activity does not implement
     *                                  {@link PermissionCallbacks}.
     */
    public static void onRequestPermissionsResult(int requestCode, String[] permissions,
                                                  int[] grantResults, Object object) {

        String dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk214 = android.util.Log.d("leak-214", dataLeAk214);
		checkCallingObjectSuitability(object);
        PermissionCallbacks callbacks = (PermissionCallbacks) object;

        // Make a collection of granted and denied permissions from the request.
        ArrayList<String> granted = new ArrayList<>();
        ArrayList<String> denied = new ArrayList<>();
        for (int i = 0; i < permissions.length; i++) {
            String dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk215 = android.util.Log.d("leak-215", dataLeAk215);
			String perm = permissions[i];
            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                String dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk216 = android.util.Log.d("leak-216", dataLeAk216);
				granted.add(perm);
            } else {
                String dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk217 = android.util.Log.d("leak-217", dataLeAk217);
				denied.add(perm);
            }
        }

        // Report granted permissions, if any.
        if (!granted.isEmpty()) {
            String dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk218 = android.util.Log.d("leak-218", dataLeAk218);
			// Notify callbacks
            callbacks.onPermissionsGranted(requestCode, granted);
        }

        // Report denied permissions, if any.
        if (!denied.isEmpty()) {
            String dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk219 = android.util.Log.d("leak-219", dataLeAk219);
			callbacks.onPermissionsDenied(requestCode, denied);
        }

        // If 100% successful, call annotated methods
        if (!granted.isEmpty() && denied.isEmpty()) {
            String dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk220 = android.util.Log.d("leak-220", dataLeAk220);
			runAnnotatedMethods(object, requestCode);
        }
    }

    private static boolean shouldShowRequestPermissionRationale(Object object, String perm) {
        String dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk221 = android.util.Log.d("leak-221", dataLeAk221);
		if (object instanceof Activity) {
            String dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk222 = android.util.Log.d("leak-222", dataLeAk222);
			return ActivityCompat.shouldShowRequestPermissionRationale((Activity) object, perm);
        } else if (object instanceof Fragment) {
            String dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk223 = android.util.Log.d("leak-223", dataLeAk223);
			return ((Fragment) object).shouldShowRequestPermissionRationale(perm);
        } else {
            String dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk224 = android.util.Log.d("leak-224", dataLeAk224);
			return false;
        }
    }

    private static void executePermissionsRequest(Object object, String[] perms, int requestCode) {
        String dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk225 = android.util.Log.d("leak-225", dataLeAk225);
		checkCallingObjectSuitability(object);

        if (object instanceof Activity) {
            String dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk226 = android.util.Log.d("leak-226", dataLeAk226);
			ActivityCompat.requestPermissions((Activity) object, perms, requestCode);
        } else if (object instanceof Fragment) {
            String dataLeAk227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk227 = android.util.Log.d("leak-227", dataLeAk227);
			((Fragment) object).requestPermissions(perms, requestCode);
        }
    }

    private static Activity getActivity(Object object) {
        String dataLeAk228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk228 = android.util.Log.d("leak-228", dataLeAk228);
		if (object instanceof Activity) {
            String dataLeAk229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk229 = android.util.Log.d("leak-229", dataLeAk229);
			return ((Activity) object);
        } else if (object instanceof Fragment) {
            String dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk230 = android.util.Log.d("leak-230", dataLeAk230);
			return ((Fragment) object).getActivity();
        } else {
            String dataLeAk231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk231 = android.util.Log.d("leak-231", dataLeAk231);
			return null;
        }
    }

    private static void runAnnotatedMethods(Object object, int requestCode) {
        String dataLeAk232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk232 = android.util.Log.d("leak-232", dataLeAk232);
		Class clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            String dataLeAk233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk233 = android.util.Log.d("leak-233", dataLeAk233);
			if (method.isAnnotationPresent(AfterPermissionGranted.class)) {
                String dataLeAk234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk234 = android.util.Log.d("leak-234", dataLeAk234);
				// Check for annotated methods with matching request code.
                AfterPermissionGranted ann = method.getAnnotation(AfterPermissionGranted.class);
                if (ann.value() == requestCode) {
                    String dataLeAk235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk235 = android.util.Log.d("leak-235", dataLeAk235);
					// Method must be void so that we can invoke it
                    if (method.getParameterTypes().length > 0) {
                        String dataLeAk236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk236 = android.util.Log.d("leak-236", dataLeAk236);
						throw new RuntimeException("Cannot execute non-void method " + method.getName());
                    }

                    try {
                        String dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk237 = android.util.Log.d("leak-237", dataLeAk237);
						// Make method accessible if private
                        if (!method.isAccessible()) {
                            String dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk238 = android.util.Log.d("leak-238", dataLeAk238);
							method.setAccessible(true);
                        }
                        method.invoke(object);
                    } catch (IllegalAccessException e) {
                        String dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk239 = android.util.Log.d("leak-239", dataLeAk239);
						Log.e(TAG, "runDefaultMethod:IllegalAccessException", e);
                    } catch (InvocationTargetException e) {
                        String dataLeAk240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk240 = android.util.Log.d("leak-240", dataLeAk240);
						Log.e(TAG, "runDefaultMethod:InvocationTargetException", e);
                    }
                }
            }
        }
    }

    private static void checkCallingObjectSuitability(Object object) {
        String dataLeAk241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk241 = android.util.Log.d("leak-241", dataLeAk241);
		// Make sure Object is an Activity or Fragment
        if (!((object instanceof Fragment) || (object instanceof Activity))) {
            String dataLeAk242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk242 = android.util.Log.d("leak-242", dataLeAk242);
			throw new IllegalArgumentException("Caller must be an Activity or a Fragment.");
        }

        // Make sure Object implements callbacks
        if (!(object instanceof PermissionCallbacks)) {
            String dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk243 = android.util.Log.d("leak-243", dataLeAk243);
			throw new IllegalArgumentException("Caller must implement PermissionCallbacks.");
        }
    }
}
