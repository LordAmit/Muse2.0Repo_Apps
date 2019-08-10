package org.androidpn.client.helper;

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

import android.support.v4.app.ActivityCompat;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.annotation.StringRes;
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

    String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk6 = android.util.Log.d("leak-6", dataLeAk6);

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
        String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk7 = android.util.Log.d("leak-7", dataLeAk7);
		for (String perm : perms) {
            String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk8 = android.util.Log.d("leak-8", dataLeAk8);
			boolean hasPerm = (ContextCompat.checkSelfPermission(context, perm) == PackageManager.PERMISSION_GRANTED);
            if (!hasPerm) {
                String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk9 = android.util.Log.d("leak-9", dataLeAk9);
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
        String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk10 = android.util.Log.d("leak-10", dataLeAk10);
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

        String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk11 = android.util.Log.d("leak-11", dataLeAk11);
		checkCallingObjectSuitability(object);
        final PermissionCallbacks callbacks = (PermissionCallbacks) object;

        boolean shouldShowRationale = false;
        for (String perm : perms) {
            String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk12 = android.util.Log.d("leak-12", dataLeAk12);
			shouldShowRationale = shouldShowRationale || shouldShowRequestPermissionRationale(object, perm);
        }

        if (shouldShowRationale) {
            String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk13 = android.util.Log.d("leak-13", dataLeAk13);
			AlertDialog dialog = new AlertDialog.Builder(getActivity(object))
                    .setMessage(rationale)
                    .setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
                        String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk14 = android.util.Log.d("leak-14", dataLeAk14);

						@Override
                        public void onClick(DialogInterface dialog, int which) {
                            String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk15 = android.util.Log.d("leak-15", dataLeAk15);
							executePermissionsRequest(object, perms, requestCode);
                        }
                    })
                    .setNegativeButton(negativeButton, new DialogInterface.OnClickListener() {
                        String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk16 = android.util.Log.d("leak-16", dataLeAk16);

						@Override
                        public void onClick(DialogInterface dialog, int which) {
                            String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk17 = android.util.Log.d("leak-17", dataLeAk17);
							// act as if the permissions were denied
                            callbacks.onPermissionsDenied(requestCode, Arrays.asList(perms));
                        }
                    }).create();
            dialog.show();
        } else {
            String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk18 = android.util.Log.d("leak-18", dataLeAk18);
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

        String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk19 = android.util.Log.d("leak-19", dataLeAk19);
		checkCallingObjectSuitability(object);
        PermissionCallbacks callbacks = (PermissionCallbacks) object;

        // Make a collection of granted and denied permissions from the request.
        ArrayList<String> granted = new ArrayList<>();
        ArrayList<String> denied = new ArrayList<>();
        for (int i = 0; i < permissions.length; i++) {
            String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk20 = android.util.Log.d("leak-20", dataLeAk20);
			String perm = permissions[i];
            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk21 = android.util.Log.d("leak-21", dataLeAk21);
				granted.add(perm);
            } else {
                String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk22 = android.util.Log.d("leak-22", dataLeAk22);
				denied.add(perm);
            }
        }

        // Report granted permissions, if any.
        if (!granted.isEmpty()) {
            String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk23 = android.util.Log.d("leak-23", dataLeAk23);
			// Notify callbacks
            callbacks.onPermissionsGranted(requestCode, granted);
        }

        // Report denied permissions, if any.
        if (!denied.isEmpty()) {
            String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk24 = android.util.Log.d("leak-24", dataLeAk24);
			callbacks.onPermissionsDenied(requestCode, denied);
        }

        // If 100% successful, call annotated methods
        if (!granted.isEmpty() && denied.isEmpty()) {
            String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk25 = android.util.Log.d("leak-25", dataLeAk25);
			runAnnotatedMethods(object, requestCode);
        }
    }

    private static boolean shouldShowRequestPermissionRationale(Object object, String perm) {
        String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk26 = android.util.Log.d("leak-26", dataLeAk26);
		if (object instanceof Activity) {
            String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk27 = android.util.Log.d("leak-27", dataLeAk27);
			return ActivityCompat.shouldShowRequestPermissionRationale((Activity) object, perm);
        } else if (object instanceof Fragment) {
            String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk28 = android.util.Log.d("leak-28", dataLeAk28);
			return ((Fragment) object).shouldShowRequestPermissionRationale(perm);
        } else {
            String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk29 = android.util.Log.d("leak-29", dataLeAk29);
			return false;
        }
    }

    private static void executePermissionsRequest(Object object, String[] perms, int requestCode) {
        String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk30 = android.util.Log.d("leak-30", dataLeAk30);
		checkCallingObjectSuitability(object);

        if (object instanceof Activity) {
            String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk31 = android.util.Log.d("leak-31", dataLeAk31);
			ActivityCompat.requestPermissions((Activity) object, perms, requestCode);
        } else if (object instanceof Fragment) {
            String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk32 = android.util.Log.d("leak-32", dataLeAk32);
			((Fragment) object).requestPermissions(perms, requestCode);
        }
    }

    private static Activity getActivity(Object object) {
        String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk33 = android.util.Log.d("leak-33", dataLeAk33);
		if (object instanceof Activity) {
            String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk34 = android.util.Log.d("leak-34", dataLeAk34);
			return ((Activity) object);
        } else if (object instanceof Fragment) {
            String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk35 = android.util.Log.d("leak-35", dataLeAk35);
			return ((Fragment) object).getActivity();
        } else {
            String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk36 = android.util.Log.d("leak-36", dataLeAk36);
			return null;
        }
    }

    private static void runAnnotatedMethods(Object object, int requestCode) {
        String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk37 = android.util.Log.d("leak-37", dataLeAk37);
		Class clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk38 = android.util.Log.d("leak-38", dataLeAk38);
			if (method.isAnnotationPresent(AfterPermissionGranted.class)) {
                String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk39 = android.util.Log.d("leak-39", dataLeAk39);
				// Check for annotated methods with matching request code.
                AfterPermissionGranted ann = method.getAnnotation(AfterPermissionGranted.class);
                if (ann.value() == requestCode) {
                    String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk40 = android.util.Log.d("leak-40", dataLeAk40);
					// Method must be void so that we can invoke it
                    if (method.getParameterTypes().length > 0) {
                        String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk41 = android.util.Log.d("leak-41", dataLeAk41);
						throw new RuntimeException("Cannot execute non-void method " + method.getName());
                    }

                    try {
                        String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk42 = android.util.Log.d("leak-42", dataLeAk42);
						// Make method accessible if private
                        if (!method.isAccessible()) {
                            String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk43 = android.util.Log.d("leak-43", dataLeAk43);
							method.setAccessible(true);
                        }
                        method.invoke(object);
                    } catch (IllegalAccessException e) {
                        String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk44 = android.util.Log.d("leak-44", dataLeAk44);
						Log.e(TAG, "runDefaultMethod:IllegalAccessException", e);
                    } catch (InvocationTargetException e) {
                        String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk45 = android.util.Log.d("leak-45", dataLeAk45);
						Log.e(TAG, "runDefaultMethod:InvocationTargetException", e);
                    }
                }
            }
        }
    }

    private static void checkCallingObjectSuitability(Object object) {
        String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk46 = android.util.Log.d("leak-46", dataLeAk46);
		// Make sure Object is an Activity or Fragment
        if (!((object instanceof Fragment) || (object instanceof Activity))) {
            String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk47 = android.util.Log.d("leak-47", dataLeAk47);
			throw new IllegalArgumentException("Caller must be an Activity or a Fragment.");
        }

        // Make sure Object implements callbacks
        if (!(object instanceof PermissionCallbacks)) {
            String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk48 = android.util.Log.d("leak-48", dataLeAk48);
			throw new IllegalArgumentException("Caller must implement PermissionCallbacks.");
        }
    }
}
