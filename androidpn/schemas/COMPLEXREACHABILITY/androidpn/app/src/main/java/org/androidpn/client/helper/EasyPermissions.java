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
        String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP5 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP5.put("test", new java.util.HashMap<String, String>());
		leakMaP5.get("test").put("test", dataLeAk5);
		String dataLeAkPath5 = leakMaP5.get("test").get("test");
		android.util.Log.d("leak-5", dataLeAkPath5);
		for (String perm : perms) {
            String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer6 = new StringBuffer();for (char chAr6 : dataLeAk6.toCharArray()) {leakBuFFer6.append(chAr6);}String dataLeAkPath6 = leakBuFFer6.toString();
			android.util.Log.d("leak-6", dataLeAkPath6);
			boolean hasPerm = (ContextCompat.checkSelfPermission(context, perm) == PackageManager.PERMISSION_GRANTED);
            if (!hasPerm) {
                String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath7;try {throw new Exception(dataLeAk7);} catch (Exception leakErRor7) {dataLeAkPath7 = leakErRor7.getMessage();}
				android.util.Log.d("leak-7", dataLeAkPath7);
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
        String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											String[] leakArRay8 = new String[] {"n/a", dataLeAk8};
											String dataLeAkPath8 = leakArRay8[leakArRay8.length - 1];
											android.util.Log.d("leak-8", dataLeAkPath8);
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

        String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP9 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
											leakMaP9.put("test", new java.util.HashMap<String, String>());
											leakMaP9.get("test").put("test", dataLeAk9);
											String dataLeAkPath9 = leakMaP9.get("test").get("test");
											android.util.Log.d("leak-9", dataLeAkPath9);
		checkCallingObjectSuitability(object);
        final PermissionCallbacks callbacks = (PermissionCallbacks) object;

        boolean shouldShowRationale = false;
        for (String perm : perms) {
            String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer10 = new StringBuffer();for (char chAr10 : dataLeAk10.toCharArray()) {leakBuFFer10.append(chAr10);}String dataLeAkPath10 = leakBuFFer10.toString();
			android.util.Log.d("leak-10", dataLeAkPath10);
			shouldShowRationale = shouldShowRationale || shouldShowRequestPermissionRationale(object, perm);
        }

        if (shouldShowRationale) {
            String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath11;try {throw new Exception(dataLeAk11);} catch (Exception leakErRor11) {dataLeAkPath11 = leakErRor11.getMessage();}
			android.util.Log.d("leak-11", dataLeAkPath11);
			AlertDialog dialog = new AlertDialog.Builder(getActivity(object))
                    .setMessage(rationale)
                    .setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay12 = new String[] {"n/a", dataLeAk12};
							String dataLeAkPath12 = leakArRay12[leakArRay12.length - 1];
							android.util.Log.d("leak-12", dataLeAkPath12);
							executePermissionsRequest(object, perms, requestCode);
                        }
                    })
                    .setNegativeButton(negativeButton, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP13 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP13.put("test", new java.util.HashMap<String, String>());
							leakMaP13.get("test").put("test", dataLeAk13);
							String dataLeAkPath13 = leakMaP13.get("test").get("test");
							android.util.Log.d("leak-13", dataLeAkPath13);
							// act as if the permissions were denied
                            callbacks.onPermissionsDenied(requestCode, Arrays.asList(perms));
                        }
                    }).create();
            dialog.show();
        } else {
            String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer14 = new StringBuffer();for (char chAr14 : dataLeAk14.toCharArray()) {leakBuFFer14.append(chAr14);}String dataLeAkPath14 = leakBuFFer14.toString();
			android.util.Log.d("leak-14", dataLeAkPath14);
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

        String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													String dataLeAkPath15;try {throw new Exception(dataLeAk15);} catch (Exception leakErRor15) {dataLeAkPath15 = leakErRor15.getMessage();}
													android.util.Log.d("leak-15", dataLeAkPath15);
		checkCallingObjectSuitability(object);
        PermissionCallbacks callbacks = (PermissionCallbacks) object;

        // Make a collection of granted and denied permissions from the request.
        ArrayList<String> granted = new ArrayList<>();
        ArrayList<String> denied = new ArrayList<>();
        for (int i = 0; i < permissions.length; i++) {
            String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay16 = new String[] {"n/a", dataLeAk16};
			String dataLeAkPath16 = leakArRay16[leakArRay16.length - 1];
			android.util.Log.d("leak-16", dataLeAkPath16);
			String perm = permissions[i];
            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP17 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP17.put("test", new java.util.HashMap<String, String>());
				leakMaP17.get("test").put("test", dataLeAk17);
				String dataLeAkPath17 = leakMaP17.get("test").get("test");
				android.util.Log.d("leak-17", dataLeAkPath17);
				granted.add(perm);
            } else {
                String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer18 = new StringBuffer();for (char chAr18 : dataLeAk18.toCharArray()) {leakBuFFer18.append(chAr18);}String dataLeAkPath18 = leakBuFFer18.toString();
				android.util.Log.d("leak-18", dataLeAkPath18);
				denied.add(perm);
            }
        }

        // Report granted permissions, if any.
        if (!granted.isEmpty()) {
            String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath19;try {throw new Exception(dataLeAk19);} catch (Exception leakErRor19) {dataLeAkPath19 = leakErRor19.getMessage();}
			android.util.Log.d("leak-19", dataLeAkPath19);
			// Notify callbacks
            callbacks.onPermissionsGranted(requestCode, granted);
        }

        // Report denied permissions, if any.
        if (!denied.isEmpty()) {
            String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay20 = new String[] {"n/a", dataLeAk20};
			String dataLeAkPath20 = leakArRay20[leakArRay20.length - 1];
			android.util.Log.d("leak-20", dataLeAkPath20);
			callbacks.onPermissionsDenied(requestCode, denied);
        }

        // If 100% successful, call annotated methods
        if (!granted.isEmpty() && denied.isEmpty()) {
            String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP21 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP21.put("test", new java.util.HashMap<String, String>());
			leakMaP21.get("test").put("test", dataLeAk21);
			String dataLeAkPath21 = leakMaP21.get("test").get("test");
			android.util.Log.d("leak-21", dataLeAkPath21);
			runAnnotatedMethods(object, requestCode);
        }
    }

    private static boolean shouldShowRequestPermissionRationale(Object object, String perm) {
        String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer22 = new StringBuffer();for (char chAr22 : dataLeAk22.toCharArray()) {leakBuFFer22.append(chAr22);}String dataLeAkPath22 = leakBuFFer22.toString();
		android.util.Log.d("leak-22", dataLeAkPath22);
		if (object instanceof Activity) {
            String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath23;try {throw new Exception(dataLeAk23);} catch (Exception leakErRor23) {dataLeAkPath23 = leakErRor23.getMessage();}
			android.util.Log.d("leak-23", dataLeAkPath23);
			return ActivityCompat.shouldShowRequestPermissionRationale((Activity) object, perm);
        } else if (object instanceof Fragment) {
            String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay24 = new String[] {"n/a", dataLeAk24};
			String dataLeAkPath24 = leakArRay24[leakArRay24.length - 1];
			android.util.Log.d("leak-24", dataLeAkPath24);
			return ((Fragment) object).shouldShowRequestPermissionRationale(perm);
        } else {
            String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP25 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP25.put("test", new java.util.HashMap<String, String>());
			leakMaP25.get("test").put("test", dataLeAk25);
			String dataLeAkPath25 = leakMaP25.get("test").get("test");
			android.util.Log.d("leak-25", dataLeAkPath25);
			return false;
        }
    }

    private static void executePermissionsRequest(Object object, String[] perms, int requestCode) {
        String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer26 = new StringBuffer();for (char chAr26 : dataLeAk26.toCharArray()) {leakBuFFer26.append(chAr26);}String dataLeAkPath26 = leakBuFFer26.toString();
		android.util.Log.d("leak-26", dataLeAkPath26);
		checkCallingObjectSuitability(object);

        if (object instanceof Activity) {
            String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath27;try {throw new Exception(dataLeAk27);} catch (Exception leakErRor27) {dataLeAkPath27 = leakErRor27.getMessage();}
			android.util.Log.d("leak-27", dataLeAkPath27);
			ActivityCompat.requestPermissions((Activity) object, perms, requestCode);
        } else if (object instanceof Fragment) {
            String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay28 = new String[] {"n/a", dataLeAk28};
			String dataLeAkPath28 = leakArRay28[leakArRay28.length - 1];
			android.util.Log.d("leak-28", dataLeAkPath28);
			((Fragment) object).requestPermissions(perms, requestCode);
        }
    }

    private static Activity getActivity(Object object) {
        String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP29 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP29.put("test", new java.util.HashMap<String, String>());
		leakMaP29.get("test").put("test", dataLeAk29);
		String dataLeAkPath29 = leakMaP29.get("test").get("test");
		android.util.Log.d("leak-29", dataLeAkPath29);
		if (object instanceof Activity) {
            String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer30 = new StringBuffer();for (char chAr30 : dataLeAk30.toCharArray()) {leakBuFFer30.append(chAr30);}String dataLeAkPath30 = leakBuFFer30.toString();
			android.util.Log.d("leak-30", dataLeAkPath30);
			return ((Activity) object);
        } else if (object instanceof Fragment) {
            String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath31;try {throw new Exception(dataLeAk31);} catch (Exception leakErRor31) {dataLeAkPath31 = leakErRor31.getMessage();}
			android.util.Log.d("leak-31", dataLeAkPath31);
			return ((Fragment) object).getActivity();
        } else {
            String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay32 = new String[] {"n/a", dataLeAk32};
			String dataLeAkPath32 = leakArRay32[leakArRay32.length - 1];
			android.util.Log.d("leak-32", dataLeAkPath32);
			return null;
        }
    }

    private static void runAnnotatedMethods(Object object, int requestCode) {
        String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP33 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP33.put("test", new java.util.HashMap<String, String>());
		leakMaP33.get("test").put("test", dataLeAk33);
		String dataLeAkPath33 = leakMaP33.get("test").get("test");
		android.util.Log.d("leak-33", dataLeAkPath33);
		Class clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer34 = new StringBuffer();for (char chAr34 : dataLeAk34.toCharArray()) {leakBuFFer34.append(chAr34);}String dataLeAkPath34 = leakBuFFer34.toString();
			android.util.Log.d("leak-34", dataLeAkPath34);
			if (method.isAnnotationPresent(AfterPermissionGranted.class)) {
                String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath35;try {throw new Exception(dataLeAk35);} catch (Exception leakErRor35) {dataLeAkPath35 = leakErRor35.getMessage();}
				android.util.Log.d("leak-35", dataLeAkPath35);
				// Check for annotated methods with matching request code.
                AfterPermissionGranted ann = method.getAnnotation(AfterPermissionGranted.class);
                if (ann.value() == requestCode) {
                    String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay36 = new String[] {"n/a", dataLeAk36};
					String dataLeAkPath36 = leakArRay36[leakArRay36.length - 1];
					android.util.Log.d("leak-36", dataLeAkPath36);
					// Method must be void so that we can invoke it
                    if (method.getParameterTypes().length > 0) {
                        String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP37 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP37.put("test", new java.util.HashMap<String, String>());
						leakMaP37.get("test").put("test", dataLeAk37);
						String dataLeAkPath37 = leakMaP37.get("test").get("test");
						android.util.Log.d("leak-37", dataLeAkPath37);
						throw new RuntimeException("Cannot execute non-void method " + method.getName());
                    }

                    try {
                        String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer38 = new StringBuffer();for (char chAr38 : dataLeAk38.toCharArray()) {leakBuFFer38.append(chAr38);}String dataLeAkPath38 = leakBuFFer38.toString();
						android.util.Log.d("leak-38", dataLeAkPath38);
						// Make method accessible if private
                        if (!method.isAccessible()) {
                            String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath39;try {throw new Exception(dataLeAk39);} catch (Exception leakErRor39) {dataLeAkPath39 = leakErRor39.getMessage();}
							android.util.Log.d("leak-39", dataLeAkPath39);
							method.setAccessible(true);
                        }
                        method.invoke(object);
                    } catch (IllegalAccessException e) {
                        String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay40 = new String[] {"n/a", dataLeAk40};
						String dataLeAkPath40 = leakArRay40[leakArRay40.length - 1];
						android.util.Log.d("leak-40", dataLeAkPath40);
						Log.e(TAG, "runDefaultMethod:IllegalAccessException", e);
                    } catch (InvocationTargetException e) {
                        String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP41 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP41.put("test", new java.util.HashMap<String, String>());
						leakMaP41.get("test").put("test", dataLeAk41);
						String dataLeAkPath41 = leakMaP41.get("test").get("test");
						android.util.Log.d("leak-41", dataLeAkPath41);
						Log.e(TAG, "runDefaultMethod:InvocationTargetException", e);
                    }
                }
            }
        }
    }

    private static void checkCallingObjectSuitability(Object object) {
        String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer42 = new StringBuffer();for (char chAr42 : dataLeAk42.toCharArray()) {leakBuFFer42.append(chAr42);}String dataLeAkPath42 = leakBuFFer42.toString();
		android.util.Log.d("leak-42", dataLeAkPath42);
		// Make sure Object is an Activity or Fragment
        if (!((object instanceof Fragment) || (object instanceof Activity))) {
            String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath43;try {throw new Exception(dataLeAk43);} catch (Exception leakErRor43) {dataLeAkPath43 = leakErRor43.getMessage();}
			android.util.Log.d("leak-43", dataLeAkPath43);
			throw new IllegalArgumentException("Caller must be an Activity or a Fragment.");
        }

        // Make sure Object implements callbacks
        if (!(object instanceof PermissionCallbacks)) {
            String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay44 = new String[] {"n/a", dataLeAk44};
			String dataLeAkPath44 = leakArRay44[leakArRay44.length - 1];
			android.util.Log.d("leak-44", dataLeAkPath44);
			throw new IllegalArgumentException("Caller must implement PermissionCallbacks.");
        }
    }
}
