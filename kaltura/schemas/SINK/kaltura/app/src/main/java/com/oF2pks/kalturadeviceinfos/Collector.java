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
    final String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk25 = "";

	String dataLeAk24 = "";

	String dataLeAk23 = "";

	String dataLeAk22 = "";

	String dataLeAk21 = "";

	String dataLeAk19 = "";

	String dataLeAk18 = "";

	String dataLeAk16 = "";

	String dataLeAk15 = "";

	String dataLeAk14 = "";

	String dataLeAk13 = "";

	String dataLeAk12 = "";

	String dataLeAk11 = "";

	String dataLeAk10 = "";

	String dataLeAk9 = "";

	String dataLeAk8 = "";

	String dataLeAk7 = "";

	String dataLeAk6 = "";

	String dataLeAk5 = "";

	String dataLeAk4 = "";

	String dataLeAk3 = "";

	String dataLeAk2 = "";

	String dataLeAk1 = "";

	String dataLeAk0 = "";

	private static final String TAG = "Collector";
    static final UUID WIDEVINE_UUID = new UUID(0xEDEF8BA979D64ACEL, 0xA3C827DCD51D21EDL);
    private final Context mContext;
    private final boolean includeSafetyNet;
    private final JSONObject mRoot = new JSONObject();
    private final int numCameras = Camera.getNumberOfCameras();


    private static String sReport;

    static String getReport(Context ctx, boolean includeSafetyNet) {
        sReport = null;
        if (sReport == null) {
            Collector collector = new Collector(ctx, includeSafetyNet);
            JSONObject jsonReport = collector.collect();

            try {
                sReport = jsonReport.toString(4);
                sReport = sReport.replace("\\/", "/");
                
            } catch (JSONException e) {
                sReport = "{}";
            }
        }

        return sReport;
    }
    
    Collector(Context context, boolean includeSafetyNet) {
        dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-0", dataLeAk0);
		android.util.Log.d("leak-1-0", dataLeAk1);
		android.util.Log.d("leak-2-0", dataLeAk2);
		android.util.Log.d("leak-3-0", dataLeAk3);
		android.util.Log.d("leak-4-0", dataLeAk4);
		android.util.Log.d("leak-5-0", dataLeAk5);
		android.util.Log.d("leak-6-0", dataLeAk6);
		android.util.Log.d("leak-7-0", dataLeAk7);
		android.util.Log.d("leak-8-0", dataLeAk8);
		android.util.Log.d("leak-9-0", dataLeAk9);
		android.util.Log.d("leak-10-0", dataLeAk10);
		android.util.Log.d("leak-11-0", dataLeAk11);
		android.util.Log.d("leak-12-0", dataLeAk12);
		android.util.Log.d("leak-13-0", dataLeAk13);
		android.util.Log.d("leak-14-0", dataLeAk14);
		android.util.Log.d("leak-15-0", dataLeAk15);
		android.util.Log.d("leak-16-0", dataLeAk16);
		android.util.Log.d("leak-18-0", dataLeAk18);
		android.util.Log.d("leak-19-0", dataLeAk19);
		android.util.Log.d("leak-21-0", dataLeAk21);
		android.util.Log.d("leak-22-0", dataLeAk22);
		android.util.Log.d("leak-23-0", dataLeAk23);
		android.util.Log.d("leak-24-0", dataLeAk24);
		android.util.Log.d("leak-25-0", dataLeAk25);
		mContext = context;
        this.includeSafetyNet = includeSafetyNet;
    }
    
    JSONObject collect() {
        dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-1", dataLeAk0);
		android.util.Log.d("leak-1-1", dataLeAk1);
		android.util.Log.d("leak-2-1", dataLeAk2);
		android.util.Log.d("leak-3-1", dataLeAk3);
		android.util.Log.d("leak-4-1", dataLeAk4);
		android.util.Log.d("leak-5-1", dataLeAk5);
		android.util.Log.d("leak-6-1", dataLeAk6);
		android.util.Log.d("leak-7-1", dataLeAk7);
		android.util.Log.d("leak-8-1", dataLeAk8);
		android.util.Log.d("leak-9-1", dataLeAk9);
		android.util.Log.d("leak-10-1", dataLeAk10);
		android.util.Log.d("leak-11-1", dataLeAk11);
		android.util.Log.d("leak-12-1", dataLeAk12);
		android.util.Log.d("leak-13-1", dataLeAk13);
		android.util.Log.d("leak-14-1", dataLeAk14);
		android.util.Log.d("leak-15-1", dataLeAk15);
		android.util.Log.d("leak-16-1", dataLeAk16);
		android.util.Log.d("leak-18-1", dataLeAk18);
		android.util.Log.d("leak-19-1", dataLeAk19);
		android.util.Log.d("leak-21-1", dataLeAk21);
		android.util.Log.d("leak-22-1", dataLeAk22);
		android.util.Log.d("leak-23-1", dataLeAk23);
		android.util.Log.d("leak-24-1", dataLeAk24);
		android.util.Log.d("leak-25-1", dataLeAk25);
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
            Log.e(TAG, "Error");
//        } catch (InterruptedException e) {
//            Log.d(TAG, "Interrupted");
        }
        return mRoot;
    }

    private JSONObject trebleInfo() throws JSONException {
        dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-2", dataLeAk0);
		android.util.Log.d("leak-1-2", dataLeAk1);
		android.util.Log.d("leak-2-2", dataLeAk2);
		android.util.Log.d("leak-3-2", dataLeAk3);
		android.util.Log.d("leak-4-2", dataLeAk4);
		android.util.Log.d("leak-5-2", dataLeAk5);
		android.util.Log.d("leak-6-2", dataLeAk6);
		android.util.Log.d("leak-7-2", dataLeAk7);
		android.util.Log.d("leak-8-2", dataLeAk8);
		android.util.Log.d("leak-9-2", dataLeAk9);
		android.util.Log.d("leak-10-2", dataLeAk10);
		android.util.Log.d("leak-11-2", dataLeAk11);
		android.util.Log.d("leak-12-2", dataLeAk12);
		android.util.Log.d("leak-13-2", dataLeAk13);
		android.util.Log.d("leak-14-2", dataLeAk14);
		android.util.Log.d("leak-15-2", dataLeAk15);
		android.util.Log.d("leak-16-2", dataLeAk16);
		android.util.Log.d("leak-18-2", dataLeAk18);
		android.util.Log.d("leak-19-2", dataLeAk19);
		android.util.Log.d("leak-21-2", dataLeAk21);
		android.util.Log.d("leak-22-2", dataLeAk22);
		android.util.Log.d("leak-23-2", dataLeAk23);
		android.util.Log.d("leak-24-2", dataLeAk24);
		android.util.Log.d("leak-25-2", dataLeAk25);
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
        dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-3", dataLeAk0);
		android.util.Log.d("leak-1-3", dataLeAk1);
		android.util.Log.d("leak-2-3", dataLeAk2);
		android.util.Log.d("leak-3-3", dataLeAk3);
		android.util.Log.d("leak-4-3", dataLeAk4);
		android.util.Log.d("leak-5-3", dataLeAk5);
		android.util.Log.d("leak-6-3", dataLeAk6);
		android.util.Log.d("leak-7-3", dataLeAk7);
		android.util.Log.d("leak-8-3", dataLeAk8);
		android.util.Log.d("leak-9-3", dataLeAk9);
		android.util.Log.d("leak-10-3", dataLeAk10);
		android.util.Log.d("leak-11-3", dataLeAk11);
		android.util.Log.d("leak-12-3", dataLeAk12);
		android.util.Log.d("leak-13-3", dataLeAk13);
		android.util.Log.d("leak-14-3", dataLeAk14);
		android.util.Log.d("leak-15-3", dataLeAk15);
		android.util.Log.d("leak-16-3", dataLeAk16);
		android.util.Log.d("leak-18-3", dataLeAk18);
		android.util.Log.d("leak-19-3", dataLeAk19);
		android.util.Log.d("leak-21-3", dataLeAk21);
		android.util.Log.d("leak-22-3", dataLeAk22);
		android.util.Log.d("leak-23-3", dataLeAk23);
		android.util.Log.d("leak-24-3", dataLeAk24);
		android.util.Log.d("leak-25-3", dataLeAk25);
		JSONObject archT = new JSONObject();
        String sCams = "";
        Camera camera = null;
        Camera.CameraInfo info = new Camera.CameraInfo();
        for (int i = 0; i < numCameras; i++) {
            Camera.getCameraInfo(i, info);
            try {
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
                archT.put("MISSING permission_CAMERA","!Marshmallow and up!");
            }
        }
        return archT;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private JSONObject camera2API() throws JSONException {
    dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-0-4", dataLeAk0);
	android.util.Log.d("leak-1-4", dataLeAk1);
	android.util.Log.d("leak-2-4", dataLeAk2);
	android.util.Log.d("leak-3-4", dataLeAk3);
	android.util.Log.d("leak-4-4", dataLeAk4);
	android.util.Log.d("leak-5-4", dataLeAk5);
	android.util.Log.d("leak-6-4", dataLeAk6);
	android.util.Log.d("leak-7-4", dataLeAk7);
	android.util.Log.d("leak-8-4", dataLeAk8);
	android.util.Log.d("leak-9-4", dataLeAk9);
	android.util.Log.d("leak-10-4", dataLeAk10);
	android.util.Log.d("leak-11-4", dataLeAk11);
	android.util.Log.d("leak-12-4", dataLeAk12);
	android.util.Log.d("leak-13-4", dataLeAk13);
	android.util.Log.d("leak-14-4", dataLeAk14);
	android.util.Log.d("leak-15-4", dataLeAk15);
	android.util.Log.d("leak-16-4", dataLeAk16);
	android.util.Log.d("leak-18-4", dataLeAk18);
	android.util.Log.d("leak-19-4", dataLeAk19);
	android.util.Log.d("leak-21-4", dataLeAk21);
	android.util.Log.d("leak-22-4", dataLeAk22);
	android.util.Log.d("leak-23-4", dataLeAk23);
	android.util.Log.d("leak-24-4", dataLeAk24);
	android.util.Log.d("leak-25-4", dataLeAk25);
	JSONObject archT = new JSONObject();
    String sCams = "";

        CameraManager manager = (CameraManager) mContext.getSystemService(Context.CAMERA_SERVICE);
        if (manager==null) return archT.put("WARNING","CameraAPi2 removed");
        try {
            for (String cameraId : manager.getCameraIdList()) {
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
                e.printStackTrace();
            } catch(NullPointerException e){
                // Currently an NPE is thrown when the Camera2API is used but not supported on the
                // device this code runs.
            }
    return archT;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private JSONObject tech2API(CameraCharacteristics chars) throws JSONException {
        dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-5", dataLeAk0);
		android.util.Log.d("leak-1-5", dataLeAk1);
		android.util.Log.d("leak-2-5", dataLeAk2);
		android.util.Log.d("leak-3-5", dataLeAk3);
		android.util.Log.d("leak-4-5", dataLeAk4);
		android.util.Log.d("leak-5-5", dataLeAk5);
		android.util.Log.d("leak-6-5", dataLeAk6);
		android.util.Log.d("leak-7-5", dataLeAk7);
		android.util.Log.d("leak-8-5", dataLeAk8);
		android.util.Log.d("leak-9-5", dataLeAk9);
		android.util.Log.d("leak-10-5", dataLeAk10);
		android.util.Log.d("leak-11-5", dataLeAk11);
		android.util.Log.d("leak-12-5", dataLeAk12);
		android.util.Log.d("leak-13-5", dataLeAk13);
		android.util.Log.d("leak-14-5", dataLeAk14);
		android.util.Log.d("leak-15-5", dataLeAk15);
		android.util.Log.d("leak-16-5", dataLeAk16);
		android.util.Log.d("leak-18-5", dataLeAk18);
		android.util.Log.d("leak-19-5", dataLeAk19);
		android.util.Log.d("leak-21-5", dataLeAk21);
		android.util.Log.d("leak-22-5", dataLeAk22);
		android.util.Log.d("leak-23-5", dataLeAk23);
		android.util.Log.d("leak-24-5", dataLeAk24);
		android.util.Log.d("leak-25-5", dataLeAk25);
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
            for (int i:iiiiii) if (i<z.length) tmp+="+ "+z[i];
            arch.put("OIS_modes",tmp);tmp="";
        }
        List<CameraCharacteristics.Key<?>> tt = chars.getKeys();
        ListIterator<CameraCharacteristics.Key<?>> it = tt.listIterator();
        while(it.hasNext()){
                c=it.next();
                tmp = chars.get(c).toString();
                if (!tmp.startsWith("[") || tmp.endsWith("]")) arch.put(c.getName(),(tmp));
                else {
                    oo+="/"+c.getName();
                    //arch.put(c.getName(),c.getClass().getSimpleName());
                }
        }
        oo=oo.replaceAll("\\."," ");
        if (oo.length()>0)arch.put("UNSOLVEDs",oo);
        return arch;

    }

    private JSONObject selfMounts() throws JSONException {
        dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-6", dataLeAk0);
		android.util.Log.d("leak-1-6", dataLeAk1);
		android.util.Log.d("leak-2-6", dataLeAk2);
		android.util.Log.d("leak-3-6", dataLeAk3);
		android.util.Log.d("leak-4-6", dataLeAk4);
		android.util.Log.d("leak-5-6", dataLeAk5);
		android.util.Log.d("leak-6-6", dataLeAk6);
		android.util.Log.d("leak-7-6", dataLeAk7);
		android.util.Log.d("leak-8-6", dataLeAk8);
		android.util.Log.d("leak-9-6", dataLeAk9);
		android.util.Log.d("leak-10-6", dataLeAk10);
		android.util.Log.d("leak-11-6", dataLeAk11);
		android.util.Log.d("leak-12-6", dataLeAk12);
		android.util.Log.d("leak-13-6", dataLeAk13);
		android.util.Log.d("leak-14-6", dataLeAk14);
		android.util.Log.d("leak-15-6", dataLeAk15);
		android.util.Log.d("leak-16-6", dataLeAk16);
		android.util.Log.d("leak-18-6", dataLeAk18);
		android.util.Log.d("leak-19-6", dataLeAk19);
		android.util.Log.d("leak-21-6", dataLeAk21);
		android.util.Log.d("leak-22-6", dataLeAk22);
		android.util.Log.d("leak-23-6", dataLeAk23);
		android.util.Log.d("leak-24-6", dataLeAk24);
		android.util.Log.d("leak-25-6", dataLeAk25);
		JSONObject archT = new JSONObject();
        JSONObject arch = new JSONObject();
        String[] s3 =new String[3];
        try {
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
                set.add(tmp);
            }
            is.close();
            br.close();

            Iterator it = set.iterator();
            s3=it.next().toString().split(" ",3);
            arch.put(s3[1],s3[2]);
            tmp=s3[0];
            while (it.hasNext()) {
                while (it.hasNext()) {
                    s3=it.next().toString().split(" ",3);
                    if (!tmp.equals(s3[0])){
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
            arch.put("error", ex.getMessage() + '\n' + Log.getStackTraceString(ex));
        }
        return archT;
    }

    private JSONObject dumpsysL() throws JSONException {
        dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-7", dataLeAk0);
		android.util.Log.d("leak-1-7", dataLeAk1);
		android.util.Log.d("leak-2-7", dataLeAk2);
		android.util.Log.d("leak-3-7", dataLeAk3);
		android.util.Log.d("leak-4-7", dataLeAk4);
		android.util.Log.d("leak-5-7", dataLeAk5);
		android.util.Log.d("leak-6-7", dataLeAk6);
		android.util.Log.d("leak-7-7", dataLeAk7);
		android.util.Log.d("leak-8-7", dataLeAk8);
		android.util.Log.d("leak-9-7", dataLeAk9);
		android.util.Log.d("leak-10-7", dataLeAk10);
		android.util.Log.d("leak-11-7", dataLeAk11);
		android.util.Log.d("leak-12-7", dataLeAk12);
		android.util.Log.d("leak-13-7", dataLeAk13);
		android.util.Log.d("leak-14-7", dataLeAk14);
		android.util.Log.d("leak-15-7", dataLeAk15);
		android.util.Log.d("leak-16-7", dataLeAk16);
		android.util.Log.d("leak-18-7", dataLeAk18);
		android.util.Log.d("leak-19-7", dataLeAk19);
		android.util.Log.d("leak-21-7", dataLeAk21);
		android.util.Log.d("leak-22-7", dataLeAk22);
		android.util.Log.d("leak-23-7", dataLeAk23);
		android.util.Log.d("leak-24-7", dataLeAk24);
		android.util.Log.d("leak-25-7", dataLeAk25);
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
            dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-0-8", dataLeAk0);
			android.util.Log.d("leak-1-8", dataLeAk1);
			android.util.Log.d("leak-2-8", dataLeAk2);
			android.util.Log.d("leak-3-8", dataLeAk3);
			android.util.Log.d("leak-4-8", dataLeAk4);
			android.util.Log.d("leak-5-8", dataLeAk5);
			android.util.Log.d("leak-6-8", dataLeAk6);
			android.util.Log.d("leak-7-8", dataLeAk7);
			android.util.Log.d("leak-8-8", dataLeAk8);
			android.util.Log.d("leak-9-8", dataLeAk9);
			android.util.Log.d("leak-10-8", dataLeAk10);
			android.util.Log.d("leak-11-8", dataLeAk11);
			android.util.Log.d("leak-12-8", dataLeAk12);
			android.util.Log.d("leak-13-8", dataLeAk13);
			android.util.Log.d("leak-14-8", dataLeAk14);
			android.util.Log.d("leak-15-8", dataLeAk15);
			android.util.Log.d("leak-16-8", dataLeAk16);
			android.util.Log.d("leak-18-8", dataLeAk18);
			android.util.Log.d("leak-19-8", dataLeAk19);
			android.util.Log.d("leak-21-8", dataLeAk21);
			android.util.Log.d("leak-22-8", dataLeAk22);
			android.util.Log.d("leak-23-8", dataLeAk23);
			android.util.Log.d("leak-24-8", dataLeAk24);
			android.util.Log.d("leak-25-8", dataLeAk25);
			JSONObject archT = new JSONObject();
            SortedSet set = new TreeSet();
            String s = "" ;
            PackageManager packageManager = mContext.getPackageManager();
            FeatureInfo[] featureInfos = packageManager.getSystemAvailableFeatures();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                String[] Libs = packageManager.getSystemSharedLibraryNames();
                Arrays.sort(Libs);
                for (String ss : Libs) s+= " / "+ ss.replaceAll("\\."," ");
                archT.put("SystemSharedLibraryNames", s);
                s="";
            }
            for (FeatureInfo featureInfo : featureInfos) {
                if (featureInfo != null && featureInfo.name != null ) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        if (featureInfo.version !=0){
                            set.add(featureInfo.name+"\u25A0"+(String.valueOf(featureInfo.version)));
                        } else set.add(featureInfo.name+" °");
                    }
                    else set.add(featureInfo.name);
                }
            }
            Iterator it = set.iterator();
            while (it.hasNext()) {
                s+="/ "+it.next().toString();
            }
            return archT.put("Features",s.replaceAll("\\."," "));
        }


        private JSONObject systemArch() throws JSONException {
            dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-0-9", dataLeAk0);
			android.util.Log.d("leak-1-9", dataLeAk1);
			android.util.Log.d("leak-2-9", dataLeAk2);
			android.util.Log.d("leak-3-9", dataLeAk3);
			android.util.Log.d("leak-4-9", dataLeAk4);
			android.util.Log.d("leak-5-9", dataLeAk5);
			android.util.Log.d("leak-6-9", dataLeAk6);
			android.util.Log.d("leak-7-9", dataLeAk7);
			android.util.Log.d("leak-8-9", dataLeAk8);
			android.util.Log.d("leak-9-9", dataLeAk9);
			android.util.Log.d("leak-10-9", dataLeAk10);
			android.util.Log.d("leak-11-9", dataLeAk11);
			android.util.Log.d("leak-12-9", dataLeAk12);
			android.util.Log.d("leak-13-9", dataLeAk13);
			android.util.Log.d("leak-14-9", dataLeAk14);
			android.util.Log.d("leak-15-9", dataLeAk15);
			android.util.Log.d("leak-16-9", dataLeAk16);
			android.util.Log.d("leak-18-9", dataLeAk18);
			android.util.Log.d("leak-19-9", dataLeAk19);
			android.util.Log.d("leak-21-9", dataLeAk21);
			android.util.Log.d("leak-22-9", dataLeAk22);
			android.util.Log.d("leak-23-9", dataLeAk23);
			android.util.Log.d("leak-24-9", dataLeAk24);
			android.util.Log.d("leak-25-9", dataLeAk25);
			JSONObject archT = new JSONObject();
            JSONObject arch = new JSONObject();
            archT.put("uname-m",getZinfo("uname -m","",false));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                arch.put("SUPPORTED_ABIS", new JSONArray(Build.SUPPORTED_ABIS));
                arch.put("SUPPORTED_32_BIT_ABIS", new JSONArray(Build.SUPPORTED_32_BIT_ABIS));
                arch.put("SUPPORTED_64_BIT_ABIS", new JSONArray(Build.SUPPORTED_64_BIT_ABIS));
            } else {
                arch.put("CPU_ABI", Build.CPU_ABI);
                arch.put("CPU_ABI2", Build.CPU_ABI2);
            }
            return archT.put(System.getProperty("os.arch"),arch);
        }

    private JSONObject meta() throws JSONException {
        dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-10", dataLeAk0);
		android.util.Log.d("leak-1-10", dataLeAk1);
		android.util.Log.d("leak-2-10", dataLeAk2);
		android.util.Log.d("leak-3-10", dataLeAk3);
		android.util.Log.d("leak-4-10", dataLeAk4);
		android.util.Log.d("leak-5-10", dataLeAk5);
		android.util.Log.d("leak-6-10", dataLeAk6);
		android.util.Log.d("leak-7-10", dataLeAk7);
		android.util.Log.d("leak-8-10", dataLeAk8);
		android.util.Log.d("leak-9-10", dataLeAk9);
		android.util.Log.d("leak-10-10", dataLeAk10);
		android.util.Log.d("leak-11-10", dataLeAk11);
		android.util.Log.d("leak-12-10", dataLeAk12);
		android.util.Log.d("leak-13-10", dataLeAk13);
		android.util.Log.d("leak-14-10", dataLeAk14);
		android.util.Log.d("leak-15-10", dataLeAk15);
		android.util.Log.d("leak-16-10", dataLeAk16);
		android.util.Log.d("leak-18-10", dataLeAk18);
		android.util.Log.d("leak-19-10", dataLeAk19);
		android.util.Log.d("leak-21-10", dataLeAk21);
		android.util.Log.d("leak-22-10", dataLeAk22);
		android.util.Log.d("leak-23-10", dataLeAk23);
		android.util.Log.d("leak-24-10", dataLeAk24);
		android.util.Log.d("leak-25-10", dataLeAk25);
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
        dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-11", dataLeAk0);
		android.util.Log.d("leak-1-11", dataLeAk1);
		android.util.Log.d("leak-2-11", dataLeAk2);
		android.util.Log.d("leak-3-11", dataLeAk3);
		android.util.Log.d("leak-4-11", dataLeAk4);
		android.util.Log.d("leak-5-11", dataLeAk5);
		android.util.Log.d("leak-6-11", dataLeAk6);
		android.util.Log.d("leak-7-11", dataLeAk7);
		android.util.Log.d("leak-8-11", dataLeAk8);
		android.util.Log.d("leak-9-11", dataLeAk9);
		android.util.Log.d("leak-10-11", dataLeAk10);
		android.util.Log.d("leak-11-11", dataLeAk11);
		android.util.Log.d("leak-12-11", dataLeAk12);
		android.util.Log.d("leak-13-11", dataLeAk13);
		android.util.Log.d("leak-14-11", dataLeAk14);
		android.util.Log.d("leak-15-11", dataLeAk15);
		android.util.Log.d("leak-16-11", dataLeAk16);
		android.util.Log.d("leak-18-11", dataLeAk18);
		android.util.Log.d("leak-19-11", dataLeAk19);
		android.util.Log.d("leak-21-11", dataLeAk21);
		android.util.Log.d("leak-22-11", dataLeAk22);
		android.util.Log.d("leak-23-11", dataLeAk23);
		android.util.Log.d("leak-24-11", dataLeAk24);
		android.util.Log.d("leak-25-11", dataLeAk25);
		JSONObject marshmalow = new JSONObject();
        String s = ((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().toString();
        int i,ii=0 ;
        marshmalow.put("ro.sf.lcd_density", getProp("ro.sf.lcd_density"));
        marshmalow.put("RefreshRate",(((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRefreshRate()));
        i= s.indexOf(", real ");
        if (i>=0) {
            ii= s.indexOf(", DisplayMetrics{");
            if (ii>=0) s=s.substring(0,ii);
            s=s.substring(i+7);
            marshmalow.put("ScreenSpecs",s.substring(0,s.indexOf(",")));
            //marshmalow.put("AllMetrics",s);
            marshmalow.put("ViewingMetrics", mContext.getResources().getDisplayMetrics().toString());
        } else {
            //marshmalow.put("AllMetrics",s);//android.view.Display@...
            return marshmalow.put("Metrics", mContext.getResources().getDisplayMetrics().toString());
        }
        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)marshmalow.put("isHDR",((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().isHdr());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
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
            s="";
            float[] dRefsreshRates = ((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getSupportedRefreshRates();
            for (float f:dRefsreshRates)s+=f;
            marshmalow.put("RefreshRates21",s);
        }

            return marshmalow;
    }

    private JSONObject drmInfo() throws JSONException {
        dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-12", dataLeAk0);
		android.util.Log.d("leak-1-12", dataLeAk1);
		android.util.Log.d("leak-2-12", dataLeAk2);
		android.util.Log.d("leak-3-12", dataLeAk3);
		android.util.Log.d("leak-4-12", dataLeAk4);
		android.util.Log.d("leak-5-12", dataLeAk5);
		android.util.Log.d("leak-6-12", dataLeAk6);
		android.util.Log.d("leak-7-12", dataLeAk7);
		android.util.Log.d("leak-8-12", dataLeAk8);
		android.util.Log.d("leak-9-12", dataLeAk9);
		android.util.Log.d("leak-10-12", dataLeAk10);
		android.util.Log.d("leak-11-12", dataLeAk11);
		android.util.Log.d("leak-12-12", dataLeAk12);
		android.util.Log.d("leak-13-12", dataLeAk13);
		android.util.Log.d("leak-14-12", dataLeAk14);
		android.util.Log.d("leak-15-12", dataLeAk15);
		android.util.Log.d("leak-16-12", dataLeAk16);
		android.util.Log.d("leak-18-12", dataLeAk18);
		android.util.Log.d("leak-19-12", dataLeAk19);
		android.util.Log.d("leak-21-12", dataLeAk21);
		android.util.Log.d("leak-22-12", dataLeAk22);
		android.util.Log.d("leak-23-12", dataLeAk23);
		android.util.Log.d("leak-24-12", dataLeAk24);
		android.util.Log.d("leak-25-12", dataLeAk25);
		return new JSONObject()
                .put("modular", modularDrmInfo())
                .put("classic", classicDrmInfo());
                
    }

    private JSONObject classicDrmInfo() throws JSONException {
        dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-13", dataLeAk0);
		android.util.Log.d("leak-1-13", dataLeAk1);
		android.util.Log.d("leak-2-13", dataLeAk2);
		android.util.Log.d("leak-3-13", dataLeAk3);
		android.util.Log.d("leak-4-13", dataLeAk4);
		android.util.Log.d("leak-5-13", dataLeAk5);
		android.util.Log.d("leak-6-13", dataLeAk6);
		android.util.Log.d("leak-7-13", dataLeAk7);
		android.util.Log.d("leak-8-13", dataLeAk8);
		android.util.Log.d("leak-9-13", dataLeAk9);
		android.util.Log.d("leak-10-13", dataLeAk10);
		android.util.Log.d("leak-11-13", dataLeAk11);
		android.util.Log.d("leak-12-13", dataLeAk12);
		android.util.Log.d("leak-13-13", dataLeAk13);
		android.util.Log.d("leak-14-13", dataLeAk14);
		android.util.Log.d("leak-15-13", dataLeAk15);
		android.util.Log.d("leak-16-13", dataLeAk16);
		android.util.Log.d("leak-18-13", dataLeAk18);
		android.util.Log.d("leak-19-13", dataLeAk19);
		android.util.Log.d("leak-21-13", dataLeAk21);
		android.util.Log.d("leak-22-13", dataLeAk22);
		android.util.Log.d("leak-23-13", dataLeAk23);
		android.util.Log.d("leak-24-13", dataLeAk24);
		android.util.Log.d("leak-25-13", dataLeAk25);
		JSONObject json = new JSONObject();
        
        DrmManagerClient drmManagerClient = new DrmManagerClient(mContext);
        String[] availableDrmEngines = drmManagerClient.getAvailableDrmEngines();

        JSONArray engines = jsonArray(availableDrmEngines);
        json.put("engines", engines);
        
        try {
            if (drmManagerClient.canHandle("", "video/wvm")) {
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
            json.put("error", e.getMessage() + '\n' + Log.getStackTraceString(e));
        }

        drmManagerClient.release();
        
        return json;
    }

    @NonNull
    private JSONArray jsonArray(String[] stringArray) {
        dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-14", dataLeAk0);
		android.util.Log.d("leak-1-14", dataLeAk1);
		android.util.Log.d("leak-2-14", dataLeAk2);
		android.util.Log.d("leak-3-14", dataLeAk3);
		android.util.Log.d("leak-4-14", dataLeAk4);
		android.util.Log.d("leak-5-14", dataLeAk5);
		android.util.Log.d("leak-6-14", dataLeAk6);
		android.util.Log.d("leak-7-14", dataLeAk7);
		android.util.Log.d("leak-8-14", dataLeAk8);
		android.util.Log.d("leak-9-14", dataLeAk9);
		android.util.Log.d("leak-10-14", dataLeAk10);
		android.util.Log.d("leak-11-14", dataLeAk11);
		android.util.Log.d("leak-12-14", dataLeAk12);
		android.util.Log.d("leak-13-14", dataLeAk13);
		android.util.Log.d("leak-14-14", dataLeAk14);
		android.util.Log.d("leak-15-14", dataLeAk15);
		android.util.Log.d("leak-16-14", dataLeAk16);
		android.util.Log.d("leak-18-14", dataLeAk18);
		android.util.Log.d("leak-19-14", dataLeAk19);
		android.util.Log.d("leak-21-14", dataLeAk21);
		android.util.Log.d("leak-22-14", dataLeAk22);
		android.util.Log.d("leak-23-14", dataLeAk23);
		android.util.Log.d("leak-24-14", dataLeAk24);
		android.util.Log.d("leak-25-14", dataLeAk25);
		JSONArray jsonArray = new JSONArray();
        for (String string : stringArray) {
            if (!TextUtils.isEmpty(string)) {
                jsonArray.put(string);
            }
        }
        return jsonArray;
    }

    private String mediaCodecInfo(MediaCodecInfo mediaCodec) {
        dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-15", dataLeAk0);
		android.util.Log.d("leak-1-15", dataLeAk1);
		android.util.Log.d("leak-2-15", dataLeAk2);
		android.util.Log.d("leak-3-15", dataLeAk3);
		android.util.Log.d("leak-4-15", dataLeAk4);
		android.util.Log.d("leak-5-15", dataLeAk5);
		android.util.Log.d("leak-6-15", dataLeAk6);
		android.util.Log.d("leak-7-15", dataLeAk7);
		android.util.Log.d("leak-8-15", dataLeAk8);
		android.util.Log.d("leak-9-15", dataLeAk9);
		android.util.Log.d("leak-10-15", dataLeAk10);
		android.util.Log.d("leak-11-15", dataLeAk11);
		android.util.Log.d("leak-12-15", dataLeAk12);
		android.util.Log.d("leak-13-15", dataLeAk13);
		android.util.Log.d("leak-14-15", dataLeAk14);
		android.util.Log.d("leak-15-15", dataLeAk15);
		android.util.Log.d("leak-16-15", dataLeAk16);
		android.util.Log.d("leak-18-15", dataLeAk18);
		android.util.Log.d("leak-19-15", dataLeAk19);
		android.util.Log.d("leak-21-15", dataLeAk21);
		android.util.Log.d("leak-22-15", dataLeAk22);
		android.util.Log.d("leak-23-15", dataLeAk23);
		android.util.Log.d("leak-24-15", dataLeAk24);
		android.util.Log.d("leak-25-15", dataLeAk25);
		String s = "";
        String[] types = mediaCodec.getSupportedTypes();
        for (int j = 0; j < types.length; j++) {
            s +="~"+types[j];
        }
        return s;
    }
    
    private JSONObject mediaCodecInfo() throws JSONException {

        dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-16", dataLeAk0);
		android.util.Log.d("leak-1-16", dataLeAk1);
		android.util.Log.d("leak-2-16", dataLeAk2);
		android.util.Log.d("leak-3-16", dataLeAk3);
		android.util.Log.d("leak-4-16", dataLeAk4);
		android.util.Log.d("leak-5-16", dataLeAk5);
		android.util.Log.d("leak-6-16", dataLeAk6);
		android.util.Log.d("leak-7-16", dataLeAk7);
		android.util.Log.d("leak-8-16", dataLeAk8);
		android.util.Log.d("leak-9-16", dataLeAk9);
		android.util.Log.d("leak-10-16", dataLeAk10);
		android.util.Log.d("leak-11-16", dataLeAk11);
		android.util.Log.d("leak-12-16", dataLeAk12);
		android.util.Log.d("leak-13-16", dataLeAk13);
		android.util.Log.d("leak-14-16", dataLeAk14);
		android.util.Log.d("leak-15-16", dataLeAk15);
		android.util.Log.d("leak-16-16", dataLeAk16);
		android.util.Log.d("leak-18-16", dataLeAk18);
		android.util.Log.d("leak-19-16", dataLeAk19);
		android.util.Log.d("leak-21-16", dataLeAk21);
		android.util.Log.d("leak-22-16", dataLeAk22);
		android.util.Log.d("leak-23-16", dataLeAk23);
		android.util.Log.d("leak-24-16", dataLeAk24);
		android.util.Log.d("leak-25-16", dataLeAk25);
		ArrayList<MediaCodecInfo> mediaCodecs = new ArrayList<>();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            MediaCodecList mediaCodecList = new MediaCodecList(MediaCodecList.ALL_CODECS);
            MediaCodecInfo[] codecInfos = mediaCodecList.getCodecInfos();
            
            Collections.addAll(mediaCodecs, codecInfos);
        } else {
            for (int i=0, n=MediaCodecList.getCodecCount(); i<n; i++) {
                mediaCodecs.add(MediaCodecList.getCodecInfoAt(i));
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) Collections.sort(mediaCodecs,McComparator);
        JSONObject info = new JSONObject();
        JSONObject jsonDecoders = new JSONObject();
        JSONObject jsonEncoders = new JSONObject();
        for (MediaCodecInfo mediaCodec : mediaCodecs) {
            if (mediaCodec.isEncoder()) {
                jsonEncoders.put(mediaCodec.getName(), mediaCodecInfo(mediaCodec));
            } else {
                jsonDecoders.put(mediaCodec.getName(), mediaCodecInfo(mediaCodec));
            }
        }
        info.put("decoders", jsonDecoders);
        info.put("encoders", jsonEncoders);

        return info;
        
    }

    private static Comparator<MediaCodecInfo> McComparator = new Comparator<MediaCodecInfo>(){
        String dataLeAk17 = "";

		public int compare(MediaCodecInfo m1,MediaCodecInfo m2){
            dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-17-0", dataLeAk17);
			String mName1 = m1.getName().toUpperCase();
            String mName2 = m2.getName().toUpperCase();

            //ascending order
            return mName1.compareTo(mName2);
        }
    };

    private JSONObject modularDrmInfo() throws JSONException {

        dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-17", dataLeAk0);
		android.util.Log.d("leak-1-17", dataLeAk1);
		android.util.Log.d("leak-2-17", dataLeAk2);
		android.util.Log.d("leak-3-17", dataLeAk3);
		android.util.Log.d("leak-4-17", dataLeAk4);
		android.util.Log.d("leak-5-17", dataLeAk5);
		android.util.Log.d("leak-6-17", dataLeAk6);
		android.util.Log.d("leak-7-17", dataLeAk7);
		android.util.Log.d("leak-8-17", dataLeAk8);
		android.util.Log.d("leak-9-17", dataLeAk9);
		android.util.Log.d("leak-10-17", dataLeAk10);
		android.util.Log.d("leak-11-17", dataLeAk11);
		android.util.Log.d("leak-12-17", dataLeAk12);
		android.util.Log.d("leak-13-17", dataLeAk13);
		android.util.Log.d("leak-14-17", dataLeAk14);
		android.util.Log.d("leak-15-17", dataLeAk15);
		android.util.Log.d("leak-16-17", dataLeAk16);
		android.util.Log.d("leak-18-17", dataLeAk18);
		android.util.Log.d("leak-19-17", dataLeAk19);
		android.util.Log.d("leak-21-17", dataLeAk21);
		android.util.Log.d("leak-22-17", dataLeAk22);
		android.util.Log.d("leak-23-17", dataLeAk23);
		android.util.Log.d("leak-24-17", dataLeAk24);
		android.util.Log.d("leak-25-17", dataLeAk25);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            return new JSONObject()
                    .put("widevine", widevineModularDrmInfo());
        } else {
            return null;
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    private JSONObject widevineModularDrmInfo() throws JSONException {
        dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-18", dataLeAk0);
		android.util.Log.d("leak-1-18", dataLeAk1);
		android.util.Log.d("leak-2-18", dataLeAk2);
		android.util.Log.d("leak-3-18", dataLeAk3);
		android.util.Log.d("leak-4-18", dataLeAk4);
		android.util.Log.d("leak-5-18", dataLeAk5);
		android.util.Log.d("leak-6-18", dataLeAk6);
		android.util.Log.d("leak-7-18", dataLeAk7);
		android.util.Log.d("leak-8-18", dataLeAk8);
		android.util.Log.d("leak-9-18", dataLeAk9);
		android.util.Log.d("leak-10-18", dataLeAk10);
		android.util.Log.d("leak-11-18", dataLeAk11);
		android.util.Log.d("leak-12-18", dataLeAk12);
		android.util.Log.d("leak-13-18", dataLeAk13);
		android.util.Log.d("leak-14-18", dataLeAk14);
		android.util.Log.d("leak-15-18", dataLeAk15);
		android.util.Log.d("leak-16-18", dataLeAk16);
		android.util.Log.d("leak-18-18", dataLeAk18);
		android.util.Log.d("leak-19-18", dataLeAk19);
		android.util.Log.d("leak-21-18", dataLeAk21);
		android.util.Log.d("leak-22-18", dataLeAk22);
		android.util.Log.d("leak-23-18", dataLeAk23);
		android.util.Log.d("leak-24-18", dataLeAk24);
		android.util.Log.d("leak-25-18", dataLeAk25);
		if (!MediaDrm.isCryptoSchemeSupported(WIDEVINE_UUID)) {
            return null;
        }

        MediaDrm mediaDrm;
        try {
            mediaDrm = new MediaDrm(WIDEVINE_UUID);
        } catch (UnsupportedSchemeException e) {
            return null;
        }
        
        final JSONArray mediaDrmEvents = new JSONArray();
        
        mediaDrm.setOnEventListener(new MediaDrm.OnEventListener() {
            String dataLeAk20 = "";

			@Override
            public void onEvent(@NonNull MediaDrm md, byte[] sessionId, int event, int extra, byte[] data) {
                dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-27-0", dataLeAk27);
				android.util.Log.d("leak-20-0", dataLeAk20);
				try {
                    String encodedData = data == null ? null : Base64.encodeToString(data, Base64.NO_WRAP);
                    
                    mediaDrmEvents.put(new JSONObject().put("event", event).put("extra", extra).put("data", encodedData));
                } catch (JSONException e) {
                    Log.e(TAG, "JSONError", e);
                }
            }
        });

        try {
            byte[] session;
            session = mediaDrm.openSession();
            mediaDrm.closeSession(session);
        } catch (Exception e) {
            mediaDrmEvents.put(new JSONObject().put("Exception(openSession)", e.toString()));
        }


        String[] stringProps = {MediaDrm.PROPERTY_VENDOR, MediaDrm.PROPERTY_VERSION, MediaDrm.PROPERTY_DESCRIPTION, MediaDrm.PROPERTY_ALGORITHMS, "securityLevel", "systemId", "privacyMode", "sessionSharing", "usageReportingSupport", "appId", "origin", "hdcpLevel", "maxHdcpLevel", "maxNumberOfSessions", "numberOfOpenSessions"};
        String[] byteArrayProps = {MediaDrm.PROPERTY_DEVICE_UNIQUE_ID, "provisioningUniqueId", "serviceCertificate"};
        
        JSONObject props = new JSONObject();
        
        for (String prop : stringProps) {
            String value;
            try {
                value = mediaDrm.getPropertyString(prop);
            } catch (IllegalStateException e) {
                value = "<unknown>";
            }
            props.put(prop, value);
        }
        for (String prop : byteArrayProps) {
            String value;
            try {
                value = Base64.encodeToString(mediaDrm.getPropertyByteArray(prop), Base64.NO_WRAP);
            } catch (IllegalStateException|NullPointerException e) {
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
        dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-19", dataLeAk0);
		android.util.Log.d("leak-1-19", dataLeAk1);
		android.util.Log.d("leak-2-19", dataLeAk2);
		android.util.Log.d("leak-3-19", dataLeAk3);
		android.util.Log.d("leak-4-19", dataLeAk4);
		android.util.Log.d("leak-5-19", dataLeAk5);
		android.util.Log.d("leak-6-19", dataLeAk6);
		android.util.Log.d("leak-7-19", dataLeAk7);
		android.util.Log.d("leak-8-19", dataLeAk8);
		android.util.Log.d("leak-9-19", dataLeAk9);
		android.util.Log.d("leak-10-19", dataLeAk10);
		android.util.Log.d("leak-11-19", dataLeAk11);
		android.util.Log.d("leak-12-19", dataLeAk12);
		android.util.Log.d("leak-13-19", dataLeAk13);
		android.util.Log.d("leak-14-19", dataLeAk14);
		android.util.Log.d("leak-15-19", dataLeAk15);
		android.util.Log.d("leak-16-19", dataLeAk16);
		android.util.Log.d("leak-18-19", dataLeAk18);
		android.util.Log.d("leak-19-19", dataLeAk19);
		android.util.Log.d("leak-21-19", dataLeAk21);
		android.util.Log.d("leak-22-19", dataLeAk22);
		android.util.Log.d("leak-23-19", dataLeAk23);
		android.util.Log.d("leak-24-19", dataLeAk24);
		android.util.Log.d("leak-25-19", dataLeAk25);
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
            marshmalow.put("LOCATION_PROVIDERS_ALLOWED", Settings.Secure.getString(mContext.getContentResolver(),
                    Settings.Secure.LOCATION_PROVIDERS_ALLOWED));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
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
        dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-20", dataLeAk0);
		android.util.Log.d("leak-1-20", dataLeAk1);
		android.util.Log.d("leak-2-20", dataLeAk2);
		android.util.Log.d("leak-3-20", dataLeAk3);
		android.util.Log.d("leak-4-20", dataLeAk4);
		android.util.Log.d("leak-5-20", dataLeAk5);
		android.util.Log.d("leak-6-20", dataLeAk6);
		android.util.Log.d("leak-7-20", dataLeAk7);
		android.util.Log.d("leak-8-20", dataLeAk8);
		android.util.Log.d("leak-9-20", dataLeAk9);
		android.util.Log.d("leak-10-20", dataLeAk10);
		android.util.Log.d("leak-11-20", dataLeAk11);
		android.util.Log.d("leak-12-20", dataLeAk12);
		android.util.Log.d("leak-13-20", dataLeAk13);
		android.util.Log.d("leak-14-20", dataLeAk14);
		android.util.Log.d("leak-15-20", dataLeAk15);
		android.util.Log.d("leak-16-20", dataLeAk16);
		android.util.Log.d("leak-18-20", dataLeAk18);
		android.util.Log.d("leak-19-20", dataLeAk19);
		android.util.Log.d("leak-21-20", dataLeAk21);
		android.util.Log.d("leak-22-20", dataLeAk22);
		android.util.Log.d("leak-23-20", dataLeAk23);
		android.util.Log.d("leak-24-20", dataLeAk24);
		android.util.Log.d("leak-25-20", dataLeAk25);
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
        dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-21", dataLeAk0);
		android.util.Log.d("leak-1-21", dataLeAk1);
		android.util.Log.d("leak-2-21", dataLeAk2);
		android.util.Log.d("leak-3-21", dataLeAk3);
		android.util.Log.d("leak-4-21", dataLeAk4);
		android.util.Log.d("leak-5-21", dataLeAk5);
		android.util.Log.d("leak-6-21", dataLeAk6);
		android.util.Log.d("leak-7-21", dataLeAk7);
		android.util.Log.d("leak-8-21", dataLeAk8);
		android.util.Log.d("leak-9-21", dataLeAk9);
		android.util.Log.d("leak-10-21", dataLeAk10);
		android.util.Log.d("leak-11-21", dataLeAk11);
		android.util.Log.d("leak-12-21", dataLeAk12);
		android.util.Log.d("leak-13-21", dataLeAk13);
		android.util.Log.d("leak-14-21", dataLeAk14);
		android.util.Log.d("leak-15-21", dataLeAk15);
		android.util.Log.d("leak-16-21", dataLeAk16);
		android.util.Log.d("leak-18-21", dataLeAk18);
		android.util.Log.d("leak-19-21", dataLeAk19);
		android.util.Log.d("leak-21-21", dataLeAk21);
		android.util.Log.d("leak-22-21", dataLeAk22);
		android.util.Log.d("leak-23-21", dataLeAk23);
		android.util.Log.d("leak-24-21", dataLeAk24);
		android.util.Log.d("leak-25-21", dataLeAk25);
		Provider[] providers = Security.getProviders();
        JSONObject providergroup = new JSONObject();
        for (int i = 0; i < providers.length; i++) {
            JSONObject provider = new JSONObject().put("Info",providers[i].getInfo());

            provider.put("Version",String.valueOf(providers[i].getVersion()));
            provider.put("Class",providers[i].getClass().getName());
            providergroup.put(providers[i].getName(), provider);

        }
        return providergroup;
    }


    private JSONObject rootInfo() throws JSONException {

        dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-22", dataLeAk0);
		android.util.Log.d("leak-1-22", dataLeAk1);
		android.util.Log.d("leak-2-22", dataLeAk2);
		android.util.Log.d("leak-3-22", dataLeAk3);
		android.util.Log.d("leak-4-22", dataLeAk4);
		android.util.Log.d("leak-5-22", dataLeAk5);
		android.util.Log.d("leak-6-22", dataLeAk6);
		android.util.Log.d("leak-7-22", dataLeAk7);
		android.util.Log.d("leak-8-22", dataLeAk8);
		android.util.Log.d("leak-9-22", dataLeAk9);
		android.util.Log.d("leak-10-22", dataLeAk10);
		android.util.Log.d("leak-11-22", dataLeAk11);
		android.util.Log.d("leak-12-22", dataLeAk12);
		android.util.Log.d("leak-13-22", dataLeAk13);
		android.util.Log.d("leak-14-22", dataLeAk14);
		android.util.Log.d("leak-15-22", dataLeAk15);
		android.util.Log.d("leak-16-22", dataLeAk16);
		android.util.Log.d("leak-18-22", dataLeAk18);
		android.util.Log.d("leak-19-22", dataLeAk19);
		android.util.Log.d("leak-21-22", dataLeAk21);
		android.util.Log.d("leak-22-22", dataLeAk22);
		android.util.Log.d("leak-23-22", dataLeAk23);
		android.util.Log.d("leak-24-22", dataLeAk24);
		android.util.Log.d("leak-25-22", dataLeAk25);
		JSONObject info = new JSONObject();

        String[] paths = { "/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su",
                "/system/bin/failsafe/su", "/data/local/su" , "/data/adb/magisk.img" ,"/data/magisk.img" };
        JSONArray files = new JSONArray();
        for (String path : paths) {
            if (new File(path).exists()) {
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
        dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-23", dataLeAk0);
		android.util.Log.d("leak-1-23", dataLeAk1);
		android.util.Log.d("leak-2-23", dataLeAk2);
		android.util.Log.d("leak-3-23", dataLeAk3);
		android.util.Log.d("leak-4-23", dataLeAk4);
		android.util.Log.d("leak-5-23", dataLeAk5);
		android.util.Log.d("leak-6-23", dataLeAk6);
		android.util.Log.d("leak-7-23", dataLeAk7);
		android.util.Log.d("leak-8-23", dataLeAk8);
		android.util.Log.d("leak-9-23", dataLeAk9);
		android.util.Log.d("leak-10-23", dataLeAk10);
		android.util.Log.d("leak-11-23", dataLeAk11);
		android.util.Log.d("leak-12-23", dataLeAk12);
		android.util.Log.d("leak-13-23", dataLeAk13);
		android.util.Log.d("leak-14-23", dataLeAk14);
		android.util.Log.d("leak-15-23", dataLeAk15);
		android.util.Log.d("leak-16-23", dataLeAk16);
		android.util.Log.d("leak-18-23", dataLeAk18);
		android.util.Log.d("leak-19-23", dataLeAk19);
		android.util.Log.d("leak-21-23", dataLeAk21);
		android.util.Log.d("leak-22-23", dataLeAk22);
		android.util.Log.d("leak-23-23", dataLeAk23);
		android.util.Log.d("leak-24-23", dataLeAk24);
		android.util.Log.d("leak-25-23", dataLeAk25);
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
        try {
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
            return "ERROR: " + ex.getMessage();
        }
    }

    private static String getCpu() {
        try {
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
                if (tmp.contains("Hardware")) return tmp.substring(11);
                if (tmp.contains("model name")) tmp2= tmp.substring(13);
            }
            is.close();
            br.close();
            if (tmp2 != null) return tmp2;
            return "Unknow";
        } catch (Exception ex) {
            return "ERROR: " + ex.getMessage();
        }
    }

}

