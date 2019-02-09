package com.oF2pks.kalturadeviceinfos;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.drm.DrmInfo;
import android.drm.DrmInfoRequest;
import android.drm.DrmManagerClient;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaDrm;
import android.media.UnsupportedSchemeException;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Range;
import android.view.Display;
import android.view.WindowManager;

//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.api.GoogleApiClient;
//import com.google.android.gms.common.api.Status;
//import com.google.android.gms.safetynet.SafetyNet;
//import com.google.android.gms.safetynet.SafetyNetApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Provider;
import java.security.Security;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.SortedSet;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.UUID;

import static com.oF2pks.kalturadeviceinfos.Utils.getProp;
import static com.oF2pks.kalturadeviceinfos.Utils.getZinfo;


/**
 * Created by noamt on 17/05/2016.
 */
class Collector {
    private static final String TAG = "Collector";
    static final UUID WIDEVINE_UUID = new UUID(0xEDEF8BA979D64ACEL, 0xA3C827DCD51D21EDL);
    private final Context mContext;
    private final boolean includeSafetyNet;
    private final JSONObject mRoot = new JSONObject();
    private final int numCameras = Camera.getNumberOfCameras();


    private static String sReport;

    static String getReport(Context ctx, boolean includeSafetyNet) {
        String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay0 = new String[] {"n/a", dataLeAk0};
		String dataLeAkPath0 = leakArRay0[leakArRay0.length - 1];
		android.util.Log.d("leak-0", dataLeAkPath0);
		sReport = null;
        if (sReport == null) {
            String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1.put("test", new java.util.HashMap<String, String>());
			leakMaP1.get("test").put("test", dataLeAk1);
			String dataLeAkPath1 = leakMaP1.get("test").get("test");
			android.util.Log.d("leak-1", dataLeAkPath1);
			Collector collector = new Collector(ctx, includeSafetyNet);
            JSONObject jsonReport = collector.collect();

            try {
                String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2 = new StringBuffer();for (char chAr2 : dataLeAk2.toCharArray()) {leakBuFFer2.append(chAr2);}String dataLeAkPath2 = leakBuFFer2.toString();
				android.util.Log.d("leak-2", dataLeAkPath2);
				sReport = jsonReport.toString(4);
                sReport = sReport.replace("\\/", "/");
                
            } catch (JSONException e) {
                String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath3;try {throw new Exception(dataLeAk3);} catch (Exception leakErRor3) {dataLeAkPath3 = leakErRor3.getMessage();}
				android.util.Log.d("leak-3", dataLeAkPath3);
				sReport = "{}";
            }
        }

        return sReport;
    }
    
    Collector(Context context, boolean includeSafetyNet) {
        String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay4 = new String[] {"n/a", dataLeAk4};
		String dataLeAkPath4 = leakArRay4[leakArRay4.length - 1];
		android.util.Log.d("leak-4", dataLeAkPath4);
		mContext = context;
        this.includeSafetyNet = includeSafetyNet;
    }
    
    JSONObject collect() {
        String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP5 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP5.put("test", new java.util.HashMap<String, String>());
		leakMaP5.get("test").put("test", dataLeAk5);
		String dataLeAkPath5 = leakMaP5.get("test").get("test");
		android.util.Log.d("leak-5", dataLeAkPath5);
		final JSONObject[] safetyNetResult = new JSONObject[1];
//        Thread safetyNetThread = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    safetyNetResult[0]=collectSafetyNet();
//                } catch (JSONException e) {
//                    Log.e(TAG, "Failed converting safetyNet response to JSON");
//                }
//            }
//        };
//
//        if (includeSafetyNet) {
//            safetyNetThread.start();
//        }
        try {
            String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer6 = new StringBuffer();for (char chAr6 : dataLeAk6.toCharArray()) {leakBuFFer6.append(chAr6);}String dataLeAkPath6 = leakBuFFer6.toString();
			android.util.Log.d("leak-6", dataLeAkPath6);
			JSONObject root = mRoot;
            root.put("#META=", meta());
            root.put("#ARCH=", systemArch());
            root.put("#DRM=", drmInfo());
            root.put("#ANDROID",androidInfo());
            root.put("#SYSTEM=", systemInfo());
            root.put("#DISPLAY=", displayInfo());
            root.put("#MEDIA=", mediaCodecInfo());
            root.put("#SECURITY=", securityProviders());
            root.put("#CAMERA=",cameraOldAPI());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) root.put("#CAMERA2API=",camera2API());
            root.put("#LIBS&FEATURES=", systemFL());
            root.put("#SERVICES&SVC=", dumpsysL());
            root.put("#ROOT?=", rootInfo());
            if (getProp("ro.treble.enabled").equals("true")) root.put("#TREBLE=", trebleInfo());
            root.put("#MOUNTS", selfMounts());

//            if (includeSafetyNet) {
//                safetyNetThread.join(20 * 1000);
//                root.put("safetyNet", safetyNetResult[0]);
//            }
            
        } catch (JSONException e) {
            String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath7;try {throw new Exception(dataLeAk7);} catch (Exception leakErRor7) {dataLeAkPath7 = leakErRor7.getMessage();}
			android.util.Log.d("leak-7", dataLeAkPath7);
			Log.e(TAG, "Error");
//        } catch (InterruptedException e) {
//            Log.d(TAG, "Interrupted");
        }
        return mRoot;
    }

    private JSONObject trebleInfo() throws JSONException {
        String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay8 = new String[] {"n/a", dataLeAk8};
		String dataLeAkPath8 = leakArRay8[leakArRay8.length - 1];
		android.util.Log.d("leak-8", dataLeAkPath8);
		String s = getProp("ro.vndk.version");
        JSONObject marshmalow = new JSONObject();
        marshmalow.put("TrebleGetprop", getProp("ro.treble.enabled"));
        marshmalow.put("ro.vendor.vndk.version", getProp("ro.vendor.vndk.version"));
        marshmalow.put("ro.product.first_api_level", getProp("ro.product.first_api_level"));
        marshmalow.put("ro.vndk.lite", getProp("ro.vndk.lite"));
        marshmalow.put("ro.vndk.version", s);
        if (!(s.equals(""))) s="-"+s;
        marshmalow.put("system/lib/vndk" + s, getZinfo("ls /system/lib/vndk" + s, "/",false));
        marshmalow.put("system/lib/vndk-sp" + s, getZinfo("ls /system/lib/vndk-sp" + s, "/",false));
        marshmalow.put("vendor/lib/vndk" + s, getZinfo("ls /vendor/lib/vndk" + s, "/",false));
        marshmalow.put("vendor/lib/vndk-sp" + s, getZinfo("ls /vendor/lib/vndk-sp" + s, "/",false));
        marshmalow.put("system/lib64/vndk" + s, getZinfo("ls /system/lib64/vndk" + s, "/",false));
        marshmalow.put("system/lib64/vndk-sp" + s, getZinfo("ls /system/lib64/vndk-sp" + s, "/",false));
        marshmalow.put("vendor/lib64/vndk" + s, getZinfo("ls /vendor/lib64/vndk" + s, "/",false));
        marshmalow.put("vendor/lib64/vndk-sp" + s, getZinfo("ls /vendor/lib64/vndk-sp" + s, "/",false));

        return marshmalow;
    }

    private JSONObject cameraOldAPI() throws JSONException {
        String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP9 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP9.put("test", new java.util.HashMap<String, String>());
		leakMaP9.get("test").put("test", dataLeAk9);
		String dataLeAkPath9 = leakMaP9.get("test").get("test");
		android.util.Log.d("leak-9", dataLeAkPath9);
		JSONObject archT = new JSONObject();
        String sCams = "";
        Camera camera = null;
        Camera.CameraInfo info = new Camera.CameraInfo();
        for (int i = 0; i < numCameras; i++) {
            String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer10 = new StringBuffer();for (char chAr10 : dataLeAk10.toCharArray()) {leakBuFFer10.append(chAr10);}String dataLeAkPath10 = leakBuFFer10.toString();
			android.util.Log.d("leak-10", dataLeAkPath10);
			Camera.getCameraInfo(i, info);
            try {
                String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath11;try {throw new Exception(dataLeAk11);} catch (Exception leakErRor11) {dataLeAkPath11 = leakErRor11.getMessage();}
				android.util.Log.d("leak-11", dataLeAkPath11);
				camera = Camera.open(i);
                Camera.Parameters parms = camera.getParameters();
                sCams = parms.flatten();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    archT.put(Integer.toString(i) + "/" + numCameras + (info.facing == 0 ? "Back" : "Front"),
                            Utils.semicolonSortedJson(sCams, "=", ";"));
                else archT.put(Integer.toString(i) + "/" + numCameras + (info.facing == 0 ? "Back" : "Front"),
                        Utils.semicolonJson(sCams, "=", ";"));
                camera.release();
            } catch (Exception e) {
                String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay12 = new String[] {"n/a", dataLeAk12};
				String dataLeAkPath12 = leakArRay12[leakArRay12.length - 1];
				android.util.Log.d("leak-12", dataLeAkPath12);
				archT.put("MISSING permission_CAMERA","!Marshmallow and up!");
            }
        }
        return archT;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private JSONObject camera2API() throws JSONException {
    String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP13 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP13.put("test", new java.util.HashMap<String, String>());
		leakMaP13.get("test").put("test", dataLeAk13);
		String dataLeAkPath13 = leakMaP13.get("test").get("test");
		android.util.Log.d("leak-13", dataLeAkPath13);
	JSONObject archT = new JSONObject();
    String sCams = "";

        CameraManager manager = (CameraManager) mContext.getSystemService(Context.CAMERA_SERVICE);
        if (manager==null) return archT.put("WARNING","CameraAPi2 removed");
        try {
            String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer14 = new StringBuffer();for (char chAr14 : dataLeAk14.toCharArray()) {leakBuFFer14.append(chAr14);}String dataLeAkPath14 = leakBuFFer14.toString();
			android.util.Log.d("leak-14", dataLeAkPath14);
			for (String cameraId : manager.getCameraIdList()) {
                String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath15;try {throw new Exception(dataLeAk15);} catch (Exception leakErRor15) {dataLeAkPath15 = leakErRor15.getMessage();}
				android.util.Log.d("leak-15", dataLeAkPath15);
				sCams += "%"+cameraId;
                CameraCharacteristics chars = manager.getCameraCharacteristics(cameraId);
                String s=cameraId+"=";
                switch (chars.get(CameraCharacteristics.LENS_FACING)){
                    case 0:
                        s+="front"; break;
                    case 1:
                        s+="back"; break;
                    case 2:
                        s+="external";
                }
                s+="<";
                switch (chars.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)){
                    case 0:
                        s+="LIMITED"; break;
                    case 1:
                        s+="FULL"; break;
                    case 2:
                        s+="LEGACY"; break;
                    case 3:
                        s+="LEVEL3"; break;
                    case 4:
                        s+="EXTERNAL";
                }
                s+=">"+chars.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE)+"("+chars.get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE)+")";
                archT.put(s,tech2API(chars));
                // Do something with the characteristics
            }
            } catch(CameraAccessException e){
                String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay16 = new String[] {"n/a", dataLeAk16};
				String dataLeAkPath16 = leakArRay16[leakArRay16.length - 1];
				android.util.Log.d("leak-16", dataLeAkPath16);
				e.printStackTrace();
            } catch(NullPointerException e){
				String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP17 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP17.put("test", new java.util.HashMap<String, String>());
				leakMaP17.get("test").put("test", dataLeAk17);
				String dataLeAkPath17 = leakMaP17.get("test").get("test");
				android.util.Log.d("leak-17", dataLeAkPath17);
                // Currently an NPE is thrown when the Camera2API is used but not supported on the
                // device this code runs.
            }
    return archT;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private JSONObject tech2API(CameraCharacteristics chars) throws JSONException {
        String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer18 = new StringBuffer();for (char chAr18 : dataLeAk18.toCharArray()) {leakBuFFer18.append(chAr18);}String dataLeAkPath18 = leakBuFFer18.toString();
		android.util.Log.d("leak-18", dataLeAkPath18);
		JSONObject arch = new JSONObject();
        CameraCharacteristics.Key c;
        String tmp ="";
        String oo="";
        int[] ii=chars.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        String[] z={"OFF","ON"};
        String[] zz={"BACKWARD_COMPATIBLE"//21"
                ,"MANUAL_SENSOR"//21"
                ,"MANUAL_POST_PROCESSING"//21"
                ,"RAW"//21"
                ,"PRIVATE_REPROCESSING"//23"
                ,"READ_SENSOR_SETTINGS"//22"
                ,"BURST_CAPTURE"//22"
                ,"YUV_REPROCESSING"//23"
                ,"DEPTH_OUTPUT"//23"
                ,"CONSTRAINED_HIGH_SPEED_VIDEO"//23"
                ,"MOTION_TRACKING"//28"
                ,"LOGICAL_MULTI_CAMERA"//28"
                ,"MONOCHROME"};//28"};
        for (int i:ii) if (i<zz.length) tmp+="+ "+zz[i];
        arch.put("MAIN_specs",tmp);tmp="";

        Range[] jj = chars.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        for (Range r:jj) tmp+=r.toString();
        arch.put("FPS_ranges",tmp);tmp="";

        float[] jjj = chars.get(CameraCharacteristics.LENS_INFO_AVAILABLE_APERTURES);
        if (jjj!=null) {
            String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath19;try {throw new Exception(dataLeAk19);} catch (Exception leakErRor19) {dataLeAkPath19 = leakErRor19.getMessage();}
			android.util.Log.d("leak-19", dataLeAkPath19);
			for (float f:jjj) tmp+=f;
            arch.put("Apertures",tmp);tmp="";
        }

        float[] jjjj = chars.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
        for (float f:jjjj) tmp+=f;
        arch.put("Focal_lenghts",tmp);tmp="";

        int[] iii= chars.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        String[] zzz={"OFF","ON","ON_AUTO_FLASH","ON_ALWAYS_FLASH","ON_AUTO_FLASH_REDEYE","ON_EXTERNAL_FLASH"};
        for (int i:iii) if (i<zzz.length) tmp+="+ "+zzz[i];
        arch.put("AE_modes",tmp);tmp="";

        int[] iiii= chars.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        String[] zzzz={"OFF","AUTO","MACRO","CONTINUOUS_VIDEO","CONTINUOUS_PICTURE","EDOF"};
        for (int i:iiii) if (i<zzzz.length) tmp+="+ "+zzzz[i];
        arch.put("AF_modes",tmp);tmp="";

        int[] iiiii= chars.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
        String[] zzzzz={"OFF","AUTO","INCANDESCENT","FLUORESCENT","WARM_FLUORESCENT","DAYLIGHT","CLOUDY_DAYLIGHT","TWILIGHT","SHADE"};
        for (int i:iiiii) if (i<zzzzz.length) tmp+="+ "+zzzzz[i];
        arch.put("AWB_modes",tmp);tmp="";

        int[] iiiiii = chars.get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
        if (iiiiii!=null) {
            String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay20 = new String[] {"n/a", dataLeAk20};
			String dataLeAkPath20 = leakArRay20[leakArRay20.length - 1];
			android.util.Log.d("leak-20", dataLeAkPath20);
			for (int i:iiiiii) if (i<z.length) tmp+="+ "+z[i];
            arch.put("OIS_modes",tmp);tmp="";
        }
        List<CameraCharacteristics.Key<?>> tt = chars.getKeys();
        ListIterator<CameraCharacteristics.Key<?>> it = tt.listIterator();
        while(it.hasNext()){
                String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP21 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP21.put("test", new java.util.HashMap<String, String>());
			leakMaP21.get("test").put("test", dataLeAk21);
			String dataLeAkPath21 = leakMaP21.get("test").get("test");
			android.util.Log.d("leak-21", dataLeAkPath21);
				c=it.next();
                tmp = chars.get(c).toString();
                if (!tmp.startsWith("[") || tmp.endsWith("]")) arch.put(c.getName(),(tmp));
                else {
                    String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer22 = new StringBuffer();for (char chAr22 : dataLeAk22.toCharArray()) {leakBuFFer22.append(chAr22);}String dataLeAkPath22 = leakBuFFer22.toString();
					android.util.Log.d("leak-22", dataLeAkPath22);
					oo+="/"+c.getName();
                    //arch.put(c.getName(),c.getClass().getSimpleName());
                }
        }
        oo=oo.replaceAll("\\."," ");
        if (oo.length()>0)arch.put("UNSOLVEDs",oo);
        return arch;

    }

    private JSONObject selfMounts() throws JSONException {
        String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath23;try {throw new Exception(dataLeAk23);} catch (Exception leakErRor23) {dataLeAkPath23 = leakErRor23.getMessage();}
		android.util.Log.d("leak-23", dataLeAkPath23);
		JSONObject archT = new JSONObject();
        JSONObject arch = new JSONObject();
        String[] s3 =new String[3];
        try {
            String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay24 = new String[] {"n/a", dataLeAk24};
			String dataLeAkPath24 = leakArRay24[leakArRay24.length - 1];
			android.util.Log.d("leak-24", dataLeAkPath24);
			Process p = Runtime.getRuntime().exec("cat /proc/self/mounts");
            InputStream is = null;
            //if (p.waitFor() == 0) {
                is = p.getInputStream();
            /*} else {
                is = p.getErrorStream();
            }*/
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String tmp;
            SortedSet set = new TreeSet();

            while ((tmp = br.readLine()) != null)
            {
                String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP25 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP25.put("test", new java.util.HashMap<String, String>());
				leakMaP25.get("test").put("test", dataLeAk25);
				String dataLeAkPath25 = leakMaP25.get("test").get("test");
				android.util.Log.d("leak-25", dataLeAkPath25);
				set.add(tmp);
            }
            is.close();
            br.close();

            Iterator it = set.iterator();
            s3=it.next().toString().split(" ",3);
            arch.put(s3[1],s3[2]);
            tmp=s3[0];
            while (it.hasNext()) {
                String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer26 = new StringBuffer();for (char chAr26 : dataLeAk26.toCharArray()) {leakBuFFer26.append(chAr26);}String dataLeAkPath26 = leakBuFFer26.toString();
				android.util.Log.d("leak-26", dataLeAkPath26);
				while (it.hasNext()) {
                    String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath27;try {throw new Exception(dataLeAk27);} catch (Exception leakErRor27) {dataLeAkPath27 = leakErRor27.getMessage();}
					android.util.Log.d("leak-27", dataLeAkPath27);
					s3=it.next().toString().split(" ",3);
                    if (!tmp.equals(s3[0])){
                        String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay28 = new String[] {"n/a", dataLeAk28};
						String dataLeAkPath28 = leakArRay28[leakArRay28.length - 1];
						android.util.Log.d("leak-28", dataLeAkPath28);
						archT.put("\u25A0"+tmp,arch);
                        arch = new JSONObject();
                        arch.put(s3[1],s3[2]);
                        tmp=s3[0];
                        break;
                    }
                    arch.put(s3[1],s3[2]);
                }
            }

        } catch (Exception ex) {
            String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP29 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP29.put("test", new java.util.HashMap<String, String>());
			leakMaP29.get("test").put("test", dataLeAk29);
			String dataLeAkPath29 = leakMaP29.get("test").get("test");
			android.util.Log.d("leak-29", dataLeAkPath29);
			arch.put("error", ex.getMessage() + '\n' + Log.getStackTraceString(ex));
        }
        return archT;
    }

    private JSONObject dumpsysL() throws JSONException {
        String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer30 = new StringBuffer();for (char chAr30 : dataLeAk30.toCharArray()) {leakBuFFer30.append(chAr30);}String dataLeAkPath30 = leakBuFFer30.toString();
		android.util.Log.d("leak-30", dataLeAkPath30);
		JSONObject archT = new JSONObject();
        String s = getZinfo("dumpsys -l","/",true);
        archT.put("dumpsys-l",s.replaceAll("\\."," "));
        s= getZpack("getprop",".svc.",false);
        s=s.replaceAll("init\\u002Esvc\\u002E","");
        s=s.replaceAll("\\]: \\[running\\]","");
        s=s.replaceAll("\\]: \\[stopped\\]","\u25A0");
        s=s.replaceAll("\\[","");
        return archT.put("InitSVC",s.replaceAll("\\."," "));
    }

    private JSONObject systemFL() throws JSONException {
            String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath31;try {throw new Exception(dataLeAk31);} catch (Exception leakErRor31) {dataLeAkPath31 = leakErRor31.getMessage();}
		android.util.Log.d("leak-31", dataLeAkPath31);
			JSONObject archT = new JSONObject();
            SortedSet set = new TreeSet();
            String s = "" ;
            PackageManager packageManager = mContext.getPackageManager();
            FeatureInfo[] featureInfos = packageManager.getSystemAvailableFeatures();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay32 = new String[] {"n/a", dataLeAk32};
				String dataLeAkPath32 = leakArRay32[leakArRay32.length - 1];
				android.util.Log.d("leak-32", dataLeAkPath32);
				String[] Libs = packageManager.getSystemSharedLibraryNames();
                Arrays.sort(Libs);
                for (String ss : Libs) s+= " / "+ ss.replaceAll("\\."," ");
                archT.put("SystemSharedLibraryNames", s);
                s="";
            }
            for (FeatureInfo featureInfo : featureInfos) {
                String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP33 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP33.put("test", new java.util.HashMap<String, String>());
				leakMaP33.get("test").put("test", dataLeAk33);
				String dataLeAkPath33 = leakMaP33.get("test").get("test");
				android.util.Log.d("leak-33", dataLeAkPath33);
				if (featureInfo != null && featureInfo.name != null ) {
                    String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer34 = new StringBuffer();for (char chAr34 : dataLeAk34.toCharArray()) {leakBuFFer34.append(chAr34);}String dataLeAkPath34 = leakBuFFer34.toString();
					android.util.Log.d("leak-34", dataLeAkPath34);
					if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath35;try {throw new Exception(dataLeAk35);} catch (Exception leakErRor35) {dataLeAkPath35 = leakErRor35.getMessage();}
						android.util.Log.d("leak-35", dataLeAkPath35);
						if (featureInfo.version !=0){
                            String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay36 = new String[] {"n/a", dataLeAk36};
							String dataLeAkPath36 = leakArRay36[leakArRay36.length - 1];
							android.util.Log.d("leak-36", dataLeAkPath36);
							set.add(featureInfo.name+"\u25A0"+(String.valueOf(featureInfo.version)));
                        } else set.add(featureInfo.name+" °");
                    }
                    else set.add(featureInfo.name);
                }
            }
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP37 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP37.put("test", new java.util.HashMap<String, String>());
				leakMaP37.get("test").put("test", dataLeAk37);
				String dataLeAkPath37 = leakMaP37.get("test").get("test");
				android.util.Log.d("leak-37", dataLeAkPath37);
				s+="/ "+it.next().toString();
            }
            return archT.put("Features",s.replaceAll("\\."," "));
        }


        private JSONObject systemArch() throws JSONException {
            String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer38 = new StringBuffer();for (char chAr38 : dataLeAk38.toCharArray()) {leakBuFFer38.append(chAr38);}String dataLeAkPath38 = leakBuFFer38.toString();
			android.util.Log.d("leak-38", dataLeAkPath38);
			JSONObject archT = new JSONObject();
            JSONObject arch = new JSONObject();
            archT.put("uname-m",getZinfo("uname -m","",false));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath39;try {throw new Exception(dataLeAk39);} catch (Exception leakErRor39) {dataLeAkPath39 = leakErRor39.getMessage();}
				android.util.Log.d("leak-39", dataLeAkPath39);
				arch.put("SUPPORTED_ABIS", new JSONArray(Build.SUPPORTED_ABIS));
                arch.put("SUPPORTED_32_BIT_ABIS", new JSONArray(Build.SUPPORTED_32_BIT_ABIS));
                arch.put("SUPPORTED_64_BIT_ABIS", new JSONArray(Build.SUPPORTED_64_BIT_ABIS));
            } else {
                String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay40 = new String[] {"n/a", dataLeAk40};
				String dataLeAkPath40 = leakArRay40[leakArRay40.length - 1];
				android.util.Log.d("leak-40", dataLeAkPath40);
				arch.put("CPU_ABI", Build.CPU_ABI);
                arch.put("CPU_ABI2", Build.CPU_ABI2);
            }
            return archT.put(System.getProperty("os.arch"),arch);
        }

    private JSONObject meta() throws JSONException {
        String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP41 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP41.put("test", new java.util.HashMap<String, String>());
		leakMaP41.get("test").put("test", dataLeAk41);
		String dataLeAkPath41 = leakMaP41.get("test").get("test");
		android.util.Log.d("leak-41", dataLeAkPath41);
		TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());
        return new JSONObject()
                .put("versionName", BuildConfig.VERSION_NAME)
                .put("versionCode", BuildConfig.VERSION_CODE)
                .put("timestamp", nowAsISO);
    }

    private JSONObject displayInfo() throws JSONException {
        String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer42 = new StringBuffer();for (char chAr42 : dataLeAk42.toCharArray()) {leakBuFFer42.append(chAr42);}String dataLeAkPath42 = leakBuFFer42.toString();
		android.util.Log.d("leak-42", dataLeAkPath42);
		JSONObject marshmalow = new JSONObject();
        String s = ((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().toString();
        int i,ii=0 ;
        marshmalow.put("ro.sf.lcd_density", getProp("ro.sf.lcd_density"));
        marshmalow.put("RefreshRate",(((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRefreshRate()));
        i= s.indexOf(", real ");
        if (i>=0) {
            String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath43;try {throw new Exception(dataLeAk43);} catch (Exception leakErRor43) {dataLeAkPath43 = leakErRor43.getMessage();}
			android.util.Log.d("leak-43", dataLeAkPath43);
			ii= s.indexOf(", DisplayMetrics{");
            if (ii>=0) s=s.substring(0,ii);
            s=s.substring(i+7);
            marshmalow.put("ScreenSpecs",s.substring(0,s.indexOf(",")));
            //marshmalow.put("AllMetrics",s);
            marshmalow.put("ViewingMetrics", mContext.getResources().getDisplayMetrics().toString());
        } else {
            String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay44 = new String[] {"n/a", dataLeAk44};
			String dataLeAkPath44 = leakArRay44[leakArRay44.length - 1];
			android.util.Log.d("leak-44", dataLeAkPath44);
			//marshmalow.put("AllMetrics",s);//android.view.Display@...
            return marshmalow.put("Metrics", mContext.getResources().getDisplayMetrics().toString());
        }
        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)marshmalow.put("isHDR",((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().isHdr());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP45 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP45.put("test", new java.util.HashMap<String, String>());
			leakMaP45.get("test").put("test", dataLeAk45);
			String dataLeAkPath45 = leakMaP45.get("test").get("test");
			android.util.Log.d("leak-45", dataLeAkPath45);
			i= s.indexOf(", hdrCapa");
            ii= s.indexOf("ilities@");
            if (i>=0 && ii>=0) s=s.substring(0,i)+s.substring(ii+16);
            marshmalow.put("AllMetrics",s);

            s="";
            String[] zz = {"DOLBY_VISION","HDR10","HLG"};
            Display.HdrCapabilities dHDR =((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getHdrCapabilities();
            for(int j:dHDR.getSupportedHdrTypes()) if(j<zz.length) s+="+ "+zz[j-1];
            marshmalow.put("SupportedHdrTypes",s);
            s="";
            Display.Mode[] dModes = ((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getSupportedModes();
            for (Display.Mode mode:dModes)s+=mode.toString();//+","+mode.getRefreshRate()+">"+mode.getPhysicalHeight()+"x"+mode.getPhysicalWidth();
            marshmalow.put("getSupportedModes",s);

        } else marshmalow.put("AllMetrics",s);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer46 = new StringBuffer();for (char chAr46 : dataLeAk46.toCharArray()) {leakBuFFer46.append(chAr46);}String dataLeAkPath46 = leakBuFFer46.toString();
			android.util.Log.d("leak-46", dataLeAkPath46);
			s="";
            float[] dRefsreshRates = ((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getSupportedRefreshRates();
            for (float f:dRefsreshRates)s+=f;
            marshmalow.put("RefreshRates21",s);
        }

            return marshmalow;
    }

    private JSONObject drmInfo() throws JSONException {
        String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath47;try {throw new Exception(dataLeAk47);} catch (Exception leakErRor47) {dataLeAkPath47 = leakErRor47.getMessage();}
		android.util.Log.d("leak-47", dataLeAkPath47);
		return new JSONObject()
                .put("modular", modularDrmInfo())
                .put("classic", classicDrmInfo());
                
    }

    private JSONObject classicDrmInfo() throws JSONException {
        String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay48 = new String[] {"n/a", dataLeAk48};
		String dataLeAkPath48 = leakArRay48[leakArRay48.length - 1];
		android.util.Log.d("leak-48", dataLeAkPath48);
		JSONObject json = new JSONObject();
        
        DrmManagerClient drmManagerClient = new DrmManagerClient(mContext);
        String[] availableDrmEngines = drmManagerClient.getAvailableDrmEngines();

        JSONArray engines = jsonArray(availableDrmEngines);
        json.put("engines", engines);
        
        try {
            String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP49 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP49.put("test", new java.util.HashMap<String, String>());
			leakMaP49.get("test").put("test", dataLeAk49);
			String dataLeAkPath49 = leakMaP49.get("test").get("test");
			android.util.Log.d("leak-49", dataLeAkPath49);
			if (drmManagerClient.canHandle("", "video/wvm")) {
                String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer50 = new StringBuffer();for (char chAr50 : dataLeAk50.toCharArray()) {leakBuFFer50.append(chAr50);}String dataLeAkPath50 = leakBuFFer50.toString();
				android.util.Log.d("leak-50", dataLeAkPath50);
				DrmInfoRequest request = new DrmInfoRequest(DrmInfoRequest.TYPE_REGISTRATION_INFO, "video/wvm");
                request.put("WVPortalKey", "OEM");
                DrmInfo response = drmManagerClient.acquireDrmInfo(request);
                String status = (String) response.get("WVDrmInfoRequestStatusKey");
                
                status = new String[]{"HD_SD", null, "SD"}[Integer.parseInt(status)];
                json.put("widevine", 
                        new JSONObject()
                                .put("version", response.get("WVDrmInfoRequestVersionKey"))
                                .put("status", status)
                );
            }
        } catch (Exception e) {
            String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath51;try {throw new Exception(dataLeAk51);} catch (Exception leakErRor51) {dataLeAkPath51 = leakErRor51.getMessage();}
			android.util.Log.d("leak-51", dataLeAkPath51);
			json.put("error", e.getMessage() + '\n' + Log.getStackTraceString(e));
        }

        drmManagerClient.release();
        
        return json;
    }

    @NonNull
    private JSONArray jsonArray(String[] stringArray) {
        String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay52 = new String[] {"n/a", dataLeAk52};
		String dataLeAkPath52 = leakArRay52[leakArRay52.length - 1];
		android.util.Log.d("leak-52", dataLeAkPath52);
		JSONArray jsonArray = new JSONArray();
        for (String string : stringArray) {
            String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP53 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP53.put("test", new java.util.HashMap<String, String>());
			leakMaP53.get("test").put("test", dataLeAk53);
			String dataLeAkPath53 = leakMaP53.get("test").get("test");
			android.util.Log.d("leak-53", dataLeAkPath53);
			if (!TextUtils.isEmpty(string)) {
                String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer54 = new StringBuffer();for (char chAr54 : dataLeAk54.toCharArray()) {leakBuFFer54.append(chAr54);}String dataLeAkPath54 = leakBuFFer54.toString();
				android.util.Log.d("leak-54", dataLeAkPath54);
				jsonArray.put(string);
            }
        }
        return jsonArray;
    }

    private String mediaCodecInfo(MediaCodecInfo mediaCodec) {
        String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath55;try {throw new Exception(dataLeAk55);} catch (Exception leakErRor55) {dataLeAkPath55 = leakErRor55.getMessage();}
		android.util.Log.d("leak-55", dataLeAkPath55);
		String s = "";
        String[] types = mediaCodec.getSupportedTypes();
        for (int j = 0; j < types.length; j++) {
            String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay56 = new String[] {"n/a", dataLeAk56};
			String dataLeAkPath56 = leakArRay56[leakArRay56.length - 1];
			android.util.Log.d("leak-56", dataLeAkPath56);
			s +="~"+types[j];
        }
        return s;
    }
    
    private JSONObject mediaCodecInfo() throws JSONException {

        String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP57 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP57.put("test", new java.util.HashMap<String, String>());
		leakMaP57.get("test").put("test", dataLeAk57);
		String dataLeAkPath57 = leakMaP57.get("test").get("test");
		android.util.Log.d("leak-57", dataLeAkPath57);
		ArrayList<MediaCodecInfo> mediaCodecs = new ArrayList<>();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer58 = new StringBuffer();for (char chAr58 : dataLeAk58.toCharArray()) {leakBuFFer58.append(chAr58);}String dataLeAkPath58 = leakBuFFer58.toString();
			android.util.Log.d("leak-58", dataLeAkPath58);
			MediaCodecList mediaCodecList = new MediaCodecList(MediaCodecList.ALL_CODECS);
            MediaCodecInfo[] codecInfos = mediaCodecList.getCodecInfos();
            
            Collections.addAll(mediaCodecs, codecInfos);
        } else {
            String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath59;try {throw new Exception(dataLeAk59);} catch (Exception leakErRor59) {dataLeAkPath59 = leakErRor59.getMessage();}
			android.util.Log.d("leak-59", dataLeAkPath59);
			for (int i=0, n=MediaCodecList.getCodecCount(); i<n; i++) {
                String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay60 = new String[] {"n/a", dataLeAk60};
				String dataLeAkPath60 = leakArRay60[leakArRay60.length - 1];
				android.util.Log.d("leak-60", dataLeAkPath60);
				mediaCodecs.add(MediaCodecList.getCodecInfoAt(i));
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) Collections.sort(mediaCodecs,McComparator);
        JSONObject info = new JSONObject();
        JSONObject jsonDecoders = new JSONObject();
        JSONObject jsonEncoders = new JSONObject();
        for (MediaCodecInfo mediaCodec : mediaCodecs) {
            String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP61 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP61.put("test", new java.util.HashMap<String, String>());
			leakMaP61.get("test").put("test", dataLeAk61);
			String dataLeAkPath61 = leakMaP61.get("test").get("test");
			android.util.Log.d("leak-61", dataLeAkPath61);
			if (mediaCodec.isEncoder()) {
                String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer62 = new StringBuffer();for (char chAr62 : dataLeAk62.toCharArray()) {leakBuFFer62.append(chAr62);}String dataLeAkPath62 = leakBuFFer62.toString();
				android.util.Log.d("leak-62", dataLeAkPath62);
				jsonEncoders.put(mediaCodec.getName(), mediaCodecInfo(mediaCodec));
            } else {
                String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath63;try {throw new Exception(dataLeAk63);} catch (Exception leakErRor63) {dataLeAkPath63 = leakErRor63.getMessage();}
				android.util.Log.d("leak-63", dataLeAkPath63);
				jsonDecoders.put(mediaCodec.getName(), mediaCodecInfo(mediaCodec));
            }
        }
        info.put("decoders", jsonDecoders);
        info.put("encoders", jsonEncoders);

        return info;
        
    }

    private static Comparator<MediaCodecInfo> McComparator = new Comparator<MediaCodecInfo>(){
        public int compare(MediaCodecInfo m1,MediaCodecInfo m2){
            String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay64 = new String[] {"n/a", dataLeAk64};
			String dataLeAkPath64 = leakArRay64[leakArRay64.length - 1];
			android.util.Log.d("leak-64", dataLeAkPath64);
			String mName1 = m1.getName().toUpperCase();
            String mName2 = m2.getName().toUpperCase();

            //ascending order
            return mName1.compareTo(mName2);
        }
    };

    private JSONObject modularDrmInfo() throws JSONException {

        String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP65 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP65.put("test", new java.util.HashMap<String, String>());
		leakMaP65.get("test").put("test", dataLeAk65);
		String dataLeAkPath65 = leakMaP65.get("test").get("test");
		android.util.Log.d("leak-65", dataLeAkPath65);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer66 = new StringBuffer();for (char chAr66 : dataLeAk66.toCharArray()) {leakBuFFer66.append(chAr66);}String dataLeAkPath66 = leakBuFFer66.toString();
			android.util.Log.d("leak-66", dataLeAkPath66);
			return new JSONObject()
                    .put("widevine", widevineModularDrmInfo());
        } else {
            String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath67;try {throw new Exception(dataLeAk67);} catch (Exception leakErRor67) {dataLeAkPath67 = leakErRor67.getMessage();}
			android.util.Log.d("leak-67", dataLeAkPath67);
			return null;
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    private JSONObject widevineModularDrmInfo() throws JSONException {
        String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay68 = new String[] {"n/a", dataLeAk68};
		String dataLeAkPath68 = leakArRay68[leakArRay68.length - 1];
		android.util.Log.d("leak-68", dataLeAkPath68);
		if (!MediaDrm.isCryptoSchemeSupported(WIDEVINE_UUID)) {
            String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP69 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP69.put("test", new java.util.HashMap<String, String>());
			leakMaP69.get("test").put("test", dataLeAk69);
			String dataLeAkPath69 = leakMaP69.get("test").get("test");
			android.util.Log.d("leak-69", dataLeAkPath69);
			return null;
        }

        MediaDrm mediaDrm;
        try {
            String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer70 = new StringBuffer();for (char chAr70 : dataLeAk70.toCharArray()) {leakBuFFer70.append(chAr70);}String dataLeAkPath70 = leakBuFFer70.toString();
			android.util.Log.d("leak-70", dataLeAkPath70);
			mediaDrm = new MediaDrm(WIDEVINE_UUID);
        } catch (UnsupportedSchemeException e) {
            String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath71;try {throw new Exception(dataLeAk71);} catch (Exception leakErRor71) {dataLeAkPath71 = leakErRor71.getMessage();}
			android.util.Log.d("leak-71", dataLeAkPath71);
			return null;
        }
        
        final JSONArray mediaDrmEvents = new JSONArray();
        
        mediaDrm.setOnEventListener(new MediaDrm.OnEventListener() {
            @Override
            public void onEvent(@NonNull MediaDrm md, byte[] sessionId, int event, int extra, byte[] data) {
                String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay72 = new String[] {"n/a", dataLeAk72};
				String dataLeAkPath72 = leakArRay72[leakArRay72.length - 1];
				android.util.Log.d("leak-72", dataLeAkPath72);
				try {
                    String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP73 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP73.put("test", new java.util.HashMap<String, String>());
					leakMaP73.get("test").put("test", dataLeAk73);
					String dataLeAkPath73 = leakMaP73.get("test").get("test");
					android.util.Log.d("leak-73", dataLeAkPath73);
					String encodedData = data == null ? null : Base64.encodeToString(data, Base64.NO_WRAP);
                    
                    mediaDrmEvents.put(new JSONObject().put("event", event).put("extra", extra).put("data", encodedData));
                } catch (JSONException e) {
                    String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer74 = new StringBuffer();for (char chAr74 : dataLeAk74.toCharArray()) {leakBuFFer74.append(chAr74);}String dataLeAkPath74 = leakBuFFer74.toString();
					android.util.Log.d("leak-74", dataLeAkPath74);
					Log.e(TAG, "JSONError", e);
                }
            }
        });

        try {
            String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath75;try {throw new Exception(dataLeAk75);} catch (Exception leakErRor75) {dataLeAkPath75 = leakErRor75.getMessage();}
			android.util.Log.d("leak-75", dataLeAkPath75);
			byte[] session;
            session = mediaDrm.openSession();
            mediaDrm.closeSession(session);
        } catch (Exception e) {
            String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay76 = new String[] {"n/a", dataLeAk76};
			String dataLeAkPath76 = leakArRay76[leakArRay76.length - 1];
			android.util.Log.d("leak-76", dataLeAkPath76);
			mediaDrmEvents.put(new JSONObject().put("Exception(openSession)", e.toString()));
        }


        String[] stringProps = {MediaDrm.PROPERTY_VENDOR, MediaDrm.PROPERTY_VERSION, MediaDrm.PROPERTY_DESCRIPTION, MediaDrm.PROPERTY_ALGORITHMS, "securityLevel", "systemId", "privacyMode", "sessionSharing", "usageReportingSupport", "appId", "origin", "hdcpLevel", "maxHdcpLevel", "maxNumberOfSessions", "numberOfOpenSessions"};
        String[] byteArrayProps = {MediaDrm.PROPERTY_DEVICE_UNIQUE_ID, "provisioningUniqueId", "serviceCertificate"};
        
        JSONObject props = new JSONObject();
        
        for (String prop : stringProps) {
            String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP77 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP77.put("test", new java.util.HashMap<String, String>());
			leakMaP77.get("test").put("test", dataLeAk77);
			String dataLeAkPath77 = leakMaP77.get("test").get("test");
			android.util.Log.d("leak-77", dataLeAkPath77);
			String value;
            try {
                String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer78 = new StringBuffer();for (char chAr78 : dataLeAk78.toCharArray()) {leakBuFFer78.append(chAr78);}String dataLeAkPath78 = leakBuFFer78.toString();
				android.util.Log.d("leak-78", dataLeAkPath78);
				value = mediaDrm.getPropertyString(prop);
            } catch (IllegalStateException e) {
                String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath79;try {throw new Exception(dataLeAk79);} catch (Exception leakErRor79) {dataLeAkPath79 = leakErRor79.getMessage();}
				android.util.Log.d("leak-79", dataLeAkPath79);
				value = "<unknown>";
            }
            props.put(prop, value);
        }
        for (String prop : byteArrayProps) {
            String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay80 = new String[] {"n/a", dataLeAk80};
			String dataLeAkPath80 = leakArRay80[leakArRay80.length - 1];
			android.util.Log.d("leak-80", dataLeAkPath80);
			String value;
            try {
                String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP81 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP81.put("test", new java.util.HashMap<String, String>());
				leakMaP81.get("test").put("test", dataLeAk81);
				String dataLeAkPath81 = leakMaP81.get("test").get("test");
				android.util.Log.d("leak-81", dataLeAkPath81);
				value = Base64.encodeToString(mediaDrm.getPropertyByteArray(prop), Base64.NO_WRAP);
            } catch (IllegalStateException|NullPointerException e) {
                String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer82 = new StringBuffer();for (char chAr82 : dataLeAk82.toCharArray()) {leakBuFFer82.append(chAr82);}String dataLeAkPath82 = leakBuFFer82.toString();
				android.util.Log.d("leak-82", dataLeAkPath82);
				value = "<unknown>";
            }
            props.put(prop, value);
        }

        JSONObject response = new JSONObject();
        response.put("properties", props);
        response.put("events", mediaDrmEvents);

        return response;
    }

    private JSONObject androidInfo() throws JSONException {
        String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath83;try {throw new Exception(dataLeAk83);} catch (Exception leakErRor83) {dataLeAkPath83 = leakErRor83.getMessage();}
		android.util.Log.d("leak-83", dataLeAkPath83);
		JSONObject marshmalow = new JSONObject();
        marshmalow.put("RELEASE", Build.VERSION.RELEASE);
        marshmalow.put("KERNEL", System.getProperty("os.version"));
        marshmalow.put("SDK_INT", Build.VERSION.SDK_INT);
        marshmalow.put("TAGS", Build.TAGS);
        marshmalow.put("systemName", System.getProperty("user.name"));
        marshmalow.put("osName", System.getProperty("os.name"));
        marshmalow.put("JAVA", System.getProperty("java.vendor"));
        marshmalow.put("JAVA_url", System.getProperty("java.vendor.url"));
        marshmalow.put("JAVA_vm_version", System.getProperty("java.vm.version"));
        marshmalow.put("JAVA_home", System.getProperty("java.home"));
        marshmalow.put("JAVA_path", System.getProperty("java.class.path"));
        marshmalow.put("JAVA_version", System.getProperty("java.version"));
        marshmalow.put("JAVA_runtime", System.getProperty("java.runtime.version"));
        marshmalow.put("ro.build.flavor", getProp("ro.build.flavor"));
        marshmalow.put("ro.crypto.type", getProp("ro.crypto.type"));
        marshmalow.put("ALLOWED_GEOLOCATION_ORIGINS", Settings.Secure.getString(mContext.getContentResolver(),
                Settings.Secure.ALLOWED_GEOLOCATION_ORIGINS));
        marshmalow.put("LOCATION_MODE", Settings.Secure.getString(mContext.getContentResolver(),
                Settings.Secure.LOCATION_MODE));
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay84 = new String[] {"n/a", dataLeAk84};
			String dataLeAkPath84 = leakArRay84[leakArRay84.length - 1];
			android.util.Log.d("leak-84", dataLeAkPath84);
			marshmalow.put("LOCATION_PROVIDERS_ALLOWED", Settings.Secure.getString(mContext.getContentResolver(),
                    Settings.Secure.LOCATION_PROVIDERS_ALLOWED));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP85 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP85.put("test", new java.util.HashMap<String, String>());
			leakMaP85.get("test").put("test", dataLeAk85);
			String dataLeAkPath85 = leakMaP85.get("test").get("test");
			android.util.Log.d("leak-85", dataLeAkPath85);
			marshmalow.put("BASE_OS", Build.VERSION.BASE_OS);
            marshmalow.put("PREVIEW_SDK_INT", Build.VERSION.PREVIEW_SDK_INT);
            marshmalow.put("SECURITY_PATCH", Build.VERSION.SECURITY_PATCH);
            marshmalow.put("ro.secure", getProp("ro.secure"));
            marshmalow.put("TrebleGetprop", getProp("ro.treble.enabled"));
            marshmalow.put("ABupdateGetprop", getProp("ro.build.ab_update"));
        }
        marshmalow.put("/Vendor", getZpack("df vendor","vendor",true));
        marshmalow.put("/System", getZpack("df system","system",true));
        return marshmalow;
    }

    private JSONObject systemInfo() throws JSONException {
        String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer86 = new StringBuffer();for (char chAr86 : dataLeAk86.toCharArray()) {leakBuFFer86.append(chAr86);}String dataLeAkPath86 = leakBuFFer86.toString();
		android.util.Log.d("leak-86", dataLeAkPath86);
		JSONObject marshmalow = new JSONObject();
        marshmalow.put("Cpu", getCpu());
        marshmalow.put("BOARD", getProp("ro.board.platform"));
        marshmalow.put("HARDWARE", Build.HARDWARE);
        marshmalow.put("nbrCams", numCameras);
        marshmalow.put("KernelFull", getZinfo("uname -a","",false));
        marshmalow.put("CODENAME", Build.VERSION.CODENAME);
        marshmalow.put("BOOTLOADER", Build.BOOTLOADER);
        marshmalow.put("ro.boot.bootdevice", getProp("ro.boot.bootdevice"));
        marshmalow.put("BRAND", Build.BRAND);
        marshmalow.put("MODEL", Build.MODEL);
        marshmalow.put("MANUFACTURER", Build.MANUFACTURER);
        marshmalow.put("DEVICE", Build.DEVICE);
        marshmalow.put("ID", Build.ID);
        marshmalow.put("HOST", Build.HOST);
        marshmalow.put("PRODUCT", Build.PRODUCT);
        marshmalow.put("TYPE", Build.TYPE);
        marshmalow.put("USER", Build.USER);
        marshmalow.put("DISPLAY", Build.DISPLAY);
        marshmalow.put("INCREMENTAL", Build.VERSION.INCREMENTAL);
        marshmalow.put("RadioVersion", Build.getRadioVersion());
        marshmalow.put("FINGERPRINT", Build.FINGERPRINT);
        marshmalow.put("FINGERPRINTvendor", getProp("ro.vendor.build.fingerprint"));

        final ActivityManager activityManager =
                (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo =
                activityManager.getDeviceConfigurationInfo();
                marshmalow.put("glEsVersion", configurationInfo.getGlEsVersion());
                marshmalow.put("reqGlEsVersion", String.valueOf(configurationInfo.reqGlEsVersion));

        //marshmalow.put("zz", mContext.getPackageManager().hasSystemFeature (PackageManager.FEATURE_OPENGLES_EXTENSION_PACK));

            return marshmalow;
    }

    private JSONObject securityProviders() throws JSONException {
        String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath87;try {throw new Exception(dataLeAk87);} catch (Exception leakErRor87) {dataLeAkPath87 = leakErRor87.getMessage();}
		android.util.Log.d("leak-87", dataLeAkPath87);
		Provider[] providers = Security.getProviders();
        JSONObject providergroup = new JSONObject();
        for (int i = 0; i < providers.length; i++) {
            String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay88 = new String[] {"n/a", dataLeAk88};
			String dataLeAkPath88 = leakArRay88[leakArRay88.length - 1];
			android.util.Log.d("leak-88", dataLeAkPath88);
			JSONObject provider = new JSONObject().put("Info",providers[i].getInfo());

            provider.put("Version",String.valueOf(providers[i].getVersion()));
            provider.put("Class",providers[i].getClass().getName());
            providergroup.put(providers[i].getName(), provider);

        }
        return providergroup;
    }


    private JSONObject rootInfo() throws JSONException {

        String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP89 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP89.put("test", new java.util.HashMap<String, String>());
		leakMaP89.get("test").put("test", dataLeAk89);
		String dataLeAkPath89 = leakMaP89.get("test").get("test");
		android.util.Log.d("leak-89", dataLeAkPath89);
		JSONObject info = new JSONObject();

        String[] paths = { "/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su",
                "/system/bin/failsafe/su", "/data/local/su" , "/data/adb/magisk.img" ,"/data/magisk.img" };
        JSONArray files = new JSONArray();
        for (String path : paths) {
            String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer90 = new StringBuffer();for (char chAr90 : dataLeAk90.toCharArray()) {leakBuFFer90.append(chAr90);}String dataLeAkPath90 = leakBuFFer90.toString();
			android.util.Log.d("leak-90", dataLeAkPath90);
			if (new File(path).exists()) {
                String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath91;try {throw new Exception(dataLeAk91);} catch (Exception leakErRor91) {dataLeAkPath91 = leakErRor91.getMessage();}
				android.util.Log.d("leak-91", dataLeAkPath91);
				files.put(path);
            }
        }
        info.put("existingFiles", files);

        return info;
    }

    // NOTE: this application is meant for user-initiated diagnostics. 
    // It doesn't attempt to use the best security practices or to validate the result. 
//    private JSONObject collectSafetyNet() throws JSONException {
//        GoogleApiClient client = new GoogleApiClient.Builder(mContext)
//                .addApi(SafetyNet.API)
//                .build();
//        ConnectionResult connectionResult = client.blockingConnect(20, TimeUnit.SECONDS);
//        if (!connectionResult.isSuccess()) {
//            return new JSONObject().put("connectionError", connectionResult.toString());
//        }
//        byte[] nonce = getRequestNonce();
//        SafetyNetApi.AttestationResult result = SafetyNet.SafetyNetApi.attest(client, nonce).await(20, TimeUnit.SECONDS);
//                        Status status = result.getStatus();
//        if (!status.isSuccess()) {
//            return new JSONObject().put("testingError", status.toString());
//        }
//        String jwsResult = result.getJwsResult();
//
//        // Extract the payload, ignore the rest.
//        String[] parts = jwsResult.split("\\.");
//        if (parts.length != 3) {
//            return new JSONObject().put("invalidResponse", jwsResult);
//        }
//
//        String decoded = new String(Base64.decode(parts[1], Base64.URL_SAFE));
//
//        JSONObject jsonObject = new JSONObject(decoded);
//
//        // Remove the boring keys
//        for (String key : new String[]{"nonce", "timestampMs", "apkPackageName", "apkCertificateDigestSha256", "apkDigestSha256"}) {
//            jsonObject.remove(key);
//        }
//
//        return jsonObject;
//    }

    private byte[] getRequestNonce() {
        String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay92 = new String[] {"n/a", dataLeAk92};
		String dataLeAkPath92 = leakArRay92[leakArRay92.length - 1];
		android.util.Log.d("leak-92", dataLeAkPath92);
		byte[] bytes = new byte[32];
        new Random().nextBytes(bytes);
        return bytes;
    }
    /*private String ipAddress() {
        try {
            for (final Enumeration<NetworkInterface> enumerationNetworkInterface = NetworkInterface.getNetworkInterfaces(); enumerationNetworkInterface.hasMoreElements();) {
                final NetworkInterface networkInterface = enumerationNetworkInterface.nextElement();
                for (Enumeration<InetAddress> enumerationInetAddress = networkInterface.getInetAddresses(); enumerationInetAddress.hasMoreElements();) {
                    final InetAddress inetAddress = enumerationInetAddress.nextElement();
                    if (! inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
            return "";
        }
        catch (final Exception e) {
            return "";
        }
    }*/
    //
    private static String getZpack(String s, String grp, boolean bool) {
        String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP93 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP93.put("test", new java.util.HashMap<String, String>());
		leakMaP93.get("test").put("test", dataLeAk93);
		String dataLeAkPath93 = leakMaP93.get("test").get("test");
		android.util.Log.d("leak-93", dataLeAkPath93);
		try {
            String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer94 = new StringBuffer();for (char chAr94 : dataLeAk94.toCharArray()) {leakBuFFer94.append(chAr94);}String dataLeAkPath94 = leakBuFFer94.toString();
			android.util.Log.d("leak-94", dataLeAkPath94);
			Process p = Runtime.getRuntime().exec(s);
            InputStream is = null;
            //if (p.waitFor() == 0) {
            is = p.getInputStream();
            /*} else {
                is = p.getErrorStream();
            }*/
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String tmp;
            String tmp2 = "";
            if (bool) tmp = br.readLine();
            while ((tmp = br.readLine()) != null)
            {
                String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath95;try {throw new Exception(dataLeAk95);} catch (Exception leakErRor95) {dataLeAkPath95 = leakErRor95.getMessage();}
				android.util.Log.d("leak-95", dataLeAkPath95);
				if (tmp.contains(grp)) tmp2 +="\n"+tmp;//.replaceAll(" ","");
            }
            is.close();
            br.close();
/*            if (grp.equals(".svc.")) {
                tmp2=tmp2.replaceAll("init\\u002Esvc\\u002E","");
                tmp2=tmp2.replaceAll("\\]: \\[running\\]","");
                tmp2=tmp2.replaceAll("\\]: \\[stopped\\]","\u25A0");
                tmp2=tmp2.replaceAll("\\[","");
            }*/
            if (tmp2.length() != 0) return tmp2.replaceAll("\\n"," /");
            return "Unknow";
        } catch (Exception ex) {
            String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay96 = new String[] {"n/a", dataLeAk96};
			String dataLeAkPath96 = leakArRay96[leakArRay96.length - 1];
			android.util.Log.d("leak-96", dataLeAkPath96);
			return "ERROR: " + ex.getMessage();
        }
    }

    private static String getCpu() {
        String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP97 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP97.put("test", new java.util.HashMap<String, String>());
		leakMaP97.get("test").put("test", dataLeAk97);
		String dataLeAkPath97 = leakMaP97.get("test").get("test");
		android.util.Log.d("leak-97", dataLeAkPath97);
		try {
            String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer98 = new StringBuffer();for (char chAr98 : dataLeAk98.toCharArray()) {leakBuFFer98.append(chAr98);}String dataLeAkPath98 = leakBuFFer98.toString();
			android.util.Log.d("leak-98", dataLeAkPath98);
			Process p = Runtime.getRuntime().exec("cat /proc/cpuinfo");
            InputStream is = null;
            //if (p.waitFor() == 0) {
            is = p.getInputStream();
            /*} else {
                is = p.getErrorStream();
            }*/
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String tmp;
            String tmp2 = null;

            while ((tmp = br.readLine()) != null)
            {
                String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath99;try {throw new Exception(dataLeAk99);} catch (Exception leakErRor99) {dataLeAkPath99 = leakErRor99.getMessage();}
				android.util.Log.d("leak-99", dataLeAkPath99);
				if (tmp.contains("Hardware")) return tmp.substring(11);
                if (tmp.contains("model name")) tmp2= tmp.substring(13);
            }
            is.close();
            br.close();
            if (tmp2 != null) return tmp2;
            return "Unknow";
        } catch (Exception ex) {
            String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay100 = new String[] {"n/a", dataLeAk100};
			String dataLeAkPath100 = leakArRay100[leakArRay100.length - 1];
			android.util.Log.d("leak-100", dataLeAkPath100);
			return "ERROR: " + ex.getMessage();
        }
    }

}

