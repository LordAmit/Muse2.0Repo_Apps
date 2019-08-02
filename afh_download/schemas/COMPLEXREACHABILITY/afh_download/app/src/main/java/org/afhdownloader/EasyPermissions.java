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
        String dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer174 = new StringBuffer();for (char chAr174 : dataLeAk174.toCharArray()) {leakBuFFer174.append(chAr174);}String dataLeAkPath174 = leakBuFFer174.toString();
		android.util.Log.d("leak-174", dataLeAkPath174);
		for (String perm : perms) {
            String dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath175;try {throw new Exception(dataLeAk175);} catch (Exception leakErRor175) {dataLeAkPath175 = leakErRor175.getMessage();}
			android.util.Log.d("leak-175", dataLeAkPath175);
			boolean hasPerm = (ContextCompat.checkSelfPermission(context, perm) == PackageManager.PERMISSION_GRANTED);
            if (!hasPerm) {
                String dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay176 = new String[] {"n/a", dataLeAk176};
				String dataLeAkPath176 = leakArRay176[leakArRay176.length - 1];
				android.util.Log.d("leak-176", dataLeAkPath176);
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
        String dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP177 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
											leakMaP177.put("test", new java.util.HashMap<String, String>());
											leakMaP177.get("test").put("test", dataLeAk177);
											String dataLeAkPath177 = leakMaP177.get("test").get("test");
											android.util.Log.d("leak-177", dataLeAkPath177);
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

        String dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											StringBuffer leakBuFFer178 = new StringBuffer();for (char chAr178 : dataLeAk178.toCharArray()) {leakBuFFer178.append(chAr178);}String dataLeAkPath178 = leakBuFFer178.toString();
											android.util.Log.d("leak-178", dataLeAkPath178);
		checkCallingObjectSuitability(object);
        final PermissionCallbacks callbacks = (PermissionCallbacks) object;

        boolean shouldShowRationale = false;
        for (String perm : perms) {
            String dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath179;try {throw new Exception(dataLeAk179);} catch (Exception leakErRor179) {dataLeAkPath179 = leakErRor179.getMessage();}
			android.util.Log.d("leak-179", dataLeAkPath179);
			shouldShowRationale = shouldShowRationale || shouldShowRequestPermissionRationale(object, perm);
        }

        if (shouldShowRationale) {
            String dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay180 = new String[] {"n/a", dataLeAk180};
			String dataLeAkPath180 = leakArRay180[leakArRay180.length - 1];
			android.util.Log.d("leak-180", dataLeAkPath180);
			AlertDialog dialog = new AlertDialog.Builder(getActivity(object))
                    .setMessage(rationale)
                    .setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP181 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP181.put("test", new java.util.HashMap<String, String>());
							leakMaP181.get("test").put("test", dataLeAk181);
							String dataLeAkPath181 = leakMaP181.get("test").get("test");
							android.util.Log.d("leak-181", dataLeAkPath181);
							executePermissionsRequest(object, perms, requestCode);
                        }
                    })
                    .setNegativeButton(negativeButton, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer182 = new StringBuffer();for (char chAr182 : dataLeAk182.toCharArray()) {leakBuFFer182.append(chAr182);}String dataLeAkPath182 = leakBuFFer182.toString();
							android.util.Log.d("leak-182", dataLeAkPath182);
							// act as if the permissions were denied
                            callbacks.onPermissionsDenied(requestCode, Arrays.asList(perms));
                        }
                    }).create();
            dialog.show();
        } else {
            String dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath183;try {throw new Exception(dataLeAk183);} catch (Exception leakErRor183) {dataLeAkPath183 = leakErRor183.getMessage();}
			android.util.Log.d("leak-183", dataLeAkPath183);
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

        String dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													String[] leakArRay184 = new String[] {"n/a", dataLeAk184};
													String dataLeAkPath184 = leakArRay184[leakArRay184.length - 1];
													android.util.Log.d("leak-184", dataLeAkPath184);
		checkCallingObjectSuitability(object);
        PermissionCallbacks callbacks = (PermissionCallbacks) object;

        // Make a collection of granted and denied permissions from the request.
        ArrayList<String> granted = new ArrayList<>();
        ArrayList<String> denied = new ArrayList<>();
        for (int i = 0; i < permissions.length; i++) {
            String dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP185 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP185.put("test", new java.util.HashMap<String, String>());
			leakMaP185.get("test").put("test", dataLeAk185);
			String dataLeAkPath185 = leakMaP185.get("test").get("test");
			android.util.Log.d("leak-185", dataLeAkPath185);
			String perm = permissions[i];
            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                String dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer186 = new StringBuffer();for (char chAr186 : dataLeAk186.toCharArray()) {leakBuFFer186.append(chAr186);}String dataLeAkPath186 = leakBuFFer186.toString();
				android.util.Log.d("leak-186", dataLeAkPath186);
				granted.add(perm);
            } else {
                String dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath187;try {throw new Exception(dataLeAk187);} catch (Exception leakErRor187) {dataLeAkPath187 = leakErRor187.getMessage();}
				android.util.Log.d("leak-187", dataLeAkPath187);
				denied.add(perm);
            }
        }

        // Report granted permissions, if any.
        if (!granted.isEmpty()) {
            String dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay188 = new String[] {"n/a", dataLeAk188};
			String dataLeAkPath188 = leakArRay188[leakArRay188.length - 1];
			android.util.Log.d("leak-188", dataLeAkPath188);
			// Notify callbacks
            callbacks.onPermissionsGranted(requestCode, granted);
        }

        // Report denied permissions, if any.
        if (!denied.isEmpty()) {
            String dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP189 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP189.put("test", new java.util.HashMap<String, String>());
			leakMaP189.get("test").put("test", dataLeAk189);
			String dataLeAkPath189 = leakMaP189.get("test").get("test");
			android.util.Log.d("leak-189", dataLeAkPath189);
			callbacks.onPermissionsDenied(requestCode, denied);
        }

        // If 100% successful, call annotated methods
        if (!granted.isEmpty() && denied.isEmpty()) {
            String dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer190 = new StringBuffer();for (char chAr190 : dataLeAk190.toCharArray()) {leakBuFFer190.append(chAr190);}String dataLeAkPath190 = leakBuFFer190.toString();
			android.util.Log.d("leak-190", dataLeAkPath190);
			runAnnotatedMethods(object, requestCode);
        }
    }

    private static boolean shouldShowRequestPermissionRationale(Object object, String perm) {
        String dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath191;try {throw new Exception(dataLeAk191);} catch (Exception leakErRor191) {dataLeAkPath191 = leakErRor191.getMessage();}
		android.util.Log.d("leak-191", dataLeAkPath191);
		if (object instanceof Activity) {
            String dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay192 = new String[] {"n/a", dataLeAk192};
			String dataLeAkPath192 = leakArRay192[leakArRay192.length - 1];
			android.util.Log.d("leak-192", dataLeAkPath192);
			return ActivityCompat.shouldShowRequestPermissionRationale((Activity) object, perm);
        } else if (object instanceof Fragment) {
            String dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP193 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP193.put("test", new java.util.HashMap<String, String>());
			leakMaP193.get("test").put("test", dataLeAk193);
			String dataLeAkPath193 = leakMaP193.get("test").get("test");
			android.util.Log.d("leak-193", dataLeAkPath193);
			return ((Fragment) object).shouldShowRequestPermissionRationale(perm);
        } else {
            String dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer194 = new StringBuffer();for (char chAr194 : dataLeAk194.toCharArray()) {leakBuFFer194.append(chAr194);}String dataLeAkPath194 = leakBuFFer194.toString();
			android.util.Log.d("leak-194", dataLeAkPath194);
			return false;
        }
    }

    private static void executePermissionsRequest(Object object, String[] perms, int requestCode) {
        String dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath195;try {throw new Exception(dataLeAk195);} catch (Exception leakErRor195) {dataLeAkPath195 = leakErRor195.getMessage();}
		android.util.Log.d("leak-195", dataLeAkPath195);
		checkCallingObjectSuitability(object);

        if (object instanceof Activity) {
            String dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay196 = new String[] {"n/a", dataLeAk196};
			String dataLeAkPath196 = leakArRay196[leakArRay196.length - 1];
			android.util.Log.d("leak-196", dataLeAkPath196);
			ActivityCompat.requestPermissions((Activity) object, perms, requestCode);
        } else if (object instanceof Fragment) {
            String dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP197 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP197.put("test", new java.util.HashMap<String, String>());
			leakMaP197.get("test").put("test", dataLeAk197);
			String dataLeAkPath197 = leakMaP197.get("test").get("test");
			android.util.Log.d("leak-197", dataLeAkPath197);
			((Fragment) object).requestPermissions(perms, requestCode);
        }
    }

    private static Activity getActivity(Object object) {
        String dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer198 = new StringBuffer();for (char chAr198 : dataLeAk198.toCharArray()) {leakBuFFer198.append(chAr198);}String dataLeAkPath198 = leakBuFFer198.toString();
		android.util.Log.d("leak-198", dataLeAkPath198);
		if (object instanceof Activity) {
            String dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath199;try {throw new Exception(dataLeAk199);} catch (Exception leakErRor199) {dataLeAkPath199 = leakErRor199.getMessage();}
			android.util.Log.d("leak-199", dataLeAkPath199);
			return ((Activity) object);
        } else if (object instanceof Fragment) {
            String dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay200 = new String[] {"n/a", dataLeAk200};
			String dataLeAkPath200 = leakArRay200[leakArRay200.length - 1];
			android.util.Log.d("leak-200", dataLeAkPath200);
			return ((Fragment) object).getActivity();
        } else {
            String dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP201 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP201.put("test", new java.util.HashMap<String, String>());
			leakMaP201.get("test").put("test", dataLeAk201);
			String dataLeAkPath201 = leakMaP201.get("test").get("test");
			android.util.Log.d("leak-201", dataLeAkPath201);
			return null;
        }
    }

    private static void runAnnotatedMethods(Object object, int requestCode) {
        String dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer202 = new StringBuffer();for (char chAr202 : dataLeAk202.toCharArray()) {leakBuFFer202.append(chAr202);}String dataLeAkPath202 = leakBuFFer202.toString();
		android.util.Log.d("leak-202", dataLeAkPath202);
		Class clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            String dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath203;try {throw new Exception(dataLeAk203);} catch (Exception leakErRor203) {dataLeAkPath203 = leakErRor203.getMessage();}
			android.util.Log.d("leak-203", dataLeAkPath203);
			if (method.isAnnotationPresent(AfterPermissionGranted.class)) {
                String dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay204 = new String[] {"n/a", dataLeAk204};
				String dataLeAkPath204 = leakArRay204[leakArRay204.length - 1];
				android.util.Log.d("leak-204", dataLeAkPath204);
				// Check for annotated methods with matching request code.
                AfterPermissionGranted ann = method.getAnnotation(AfterPermissionGranted.class);
                if (ann.value() == requestCode) {
                    String dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP205 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP205.put("test", new java.util.HashMap<String, String>());
					leakMaP205.get("test").put("test", dataLeAk205);
					String dataLeAkPath205 = leakMaP205.get("test").get("test");
					android.util.Log.d("leak-205", dataLeAkPath205);
					// Method must be void so that we can invoke it
                    if (method.getParameterTypes().length > 0) {
                        String dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer206 = new StringBuffer();for (char chAr206 : dataLeAk206.toCharArray()) {leakBuFFer206.append(chAr206);}String dataLeAkPath206 = leakBuFFer206.toString();
						android.util.Log.d("leak-206", dataLeAkPath206);
						throw new RuntimeException("Cannot execute non-void method " + method.getName());
                    }

                    try {
                        String dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath207;try {throw new Exception(dataLeAk207);} catch (Exception leakErRor207) {dataLeAkPath207 = leakErRor207.getMessage();}
						android.util.Log.d("leak-207", dataLeAkPath207);
						// Make method accessible if private
                        if (!method.isAccessible()) {
                            String dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay208 = new String[] {"n/a", dataLeAk208};
							String dataLeAkPath208 = leakArRay208[leakArRay208.length - 1];
							android.util.Log.d("leak-208", dataLeAkPath208);
							method.setAccessible(true);
                        }
                        method.invoke(object);
                    } catch (IllegalAccessException e) {
                        String dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP209 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP209.put("test", new java.util.HashMap<String, String>());
						leakMaP209.get("test").put("test", dataLeAk209);
						String dataLeAkPath209 = leakMaP209.get("test").get("test");
						android.util.Log.d("leak-209", dataLeAkPath209);
						Log.e(TAG, "runDefaultMethod:IllegalAccessException", e);
                    } catch (InvocationTargetException e) {
                        String dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer210 = new StringBuffer();for (char chAr210 : dataLeAk210.toCharArray()) {leakBuFFer210.append(chAr210);}String dataLeAkPath210 = leakBuFFer210.toString();
						android.util.Log.d("leak-210", dataLeAkPath210);
						Log.e(TAG, "runDefaultMethod:InvocationTargetException", e);
                    }
                }
            }
        }
    }

    private static void checkCallingObjectSuitability(Object object) {
        String dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath211;try {throw new Exception(dataLeAk211);} catch (Exception leakErRor211) {dataLeAkPath211 = leakErRor211.getMessage();}
		android.util.Log.d("leak-211", dataLeAkPath211);
		// Make sure Object is an Activity or Fragment
        if (!((object instanceof Fragment) || (object instanceof Activity))) {
            String dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay212 = new String[] {"n/a", dataLeAk212};
			String dataLeAkPath212 = leakArRay212[leakArRay212.length - 1];
			android.util.Log.d("leak-212", dataLeAkPath212);
			throw new IllegalArgumentException("Caller must be an Activity or a Fragment.");
        }

        // Make sure Object implements callbacks
        if (!(object instanceof PermissionCallbacks)) {
            String dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP213 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP213.put("test", new java.util.HashMap<String, String>());
			leakMaP213.get("test").put("test", dataLeAk213);
			String dataLeAkPath213 = leakMaP213.get("test").get("test");
			android.util.Log.d("leak-213", dataLeAkPath213);
			throw new IllegalArgumentException("Caller must implement PermissionCallbacks.");
        }
    }
}
