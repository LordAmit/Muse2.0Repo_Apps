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
    String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk0 = android.util.Log.d("leak-0", dataLeAk0);

	private static final String TAG = "Collector";
    static final UUID WIDEVINE_UUID = new UUID(0xEDEF8BA979D64ACEL, 0xA3C827DCD51D21EDL);
    private final Context mContext;
    private final boolean includeSafetyNet;
    private final JSONObject mRoot = new JSONObject();
    private final int numCameras = Camera.getNumberOfCameras();


    private static String sReport;

    static String getReport(Context ctx, boolean includeSafetyNet) {
        String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1 = android.util.Log.d("leak-1", dataLeAk1);
		sReport = null;
        if (sReport == null) {
            String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2 = android.util.Log.d("leak-2", dataLeAk2);
			Collector collector = new Collector(ctx, includeSafetyNet);
            JSONObject jsonReport = collector.collect();

            try {
                String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3 = android.util.Log.d("leak-3", dataLeAk3);
				sReport = jsonReport.toString(4);
                sReport = sReport.replace("\\/", "/");
                
            } catch (JSONException e) {
                String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk4 = android.util.Log.d("leak-4", dataLeAk4);
				sReport = "{}";
            }
        }

        return sReport;
    }
    
    Collector(Context context, boolean includeSafetyNet) {
        String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk5 = android.util.Log.d("leak-5", dataLeAk5);
		mContext = context;
        this.includeSafetyNet = includeSafetyNet;
    }
    
    JSONObject collect() {
        String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk6 = android.util.Log.d("leak-6", dataLeAk6);
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
            String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk7 = android.util.Log.d("leak-7", dataLeAk7);
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
            String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk8 = android.util.Log.d("leak-8", dataLeAk8);
			Log.e(TAG, "Error");
//        } catch (InterruptedException e) {
//            Log.d(TAG, "Interrupted");
        }
        return mRoot;
    }

    private JSONObject trebleInfo() throws JSONException {
        String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk9 = android.util.Log.d("leak-9", dataLeAk9);
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
        String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk10 = android.util.Log.d("leak-10", dataLeAk10);
		JSONObject archT = new JSONObject();
        String sCams = "";
        Camera camera = null;
        Camera.CameraInfo info = new Camera.CameraInfo();
        for (int i = 0; i < numCameras; i++) {
            String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk11 = android.util.Log.d("leak-11", dataLeAk11);
			Camera.getCameraInfo(i, info);
            try {
                String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk12 = android.util.Log.d("leak-12", dataLeAk12);
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
                String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk13 = android.util.Log.d("leak-13", dataLeAk13);
				archT.put("MISSING permission_CAMERA","!Marshmallow and up!");
            }
        }
        return archT;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private JSONObject camera2API() throws JSONException {
    String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk14 = android.util.Log.d("leak-14", dataLeAk14);
	JSONObject archT = new JSONObject();
    String sCams = "";

        CameraManager manager = (CameraManager) mContext.getSystemService(Context.CAMERA_SERVICE);
        if (manager==null) return archT.put("WARNING","CameraAPi2 removed");
        try {
            String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk15 = android.util.Log.d("leak-15", dataLeAk15);
			for (String cameraId : manager.getCameraIdList()) {
                String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk16 = android.util.Log.d("leak-16", dataLeAk16);
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
                String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk17 = android.util.Log.d("leak-17", dataLeAk17);
				e.printStackTrace();
            } catch(NullPointerException e){
				String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk18 = android.util.Log.d("leak-18", dataLeAk18);
                // Currently an NPE is thrown when the Camera2API is used but not supported on the
                // device this code runs.
            }
    return archT;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private JSONObject tech2API(CameraCharacteristics chars) throws JSONException {
        String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk19 = android.util.Log.d("leak-19", dataLeAk19);
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
            String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk20 = android.util.Log.d("leak-20", dataLeAk20);
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
            String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk21 = android.util.Log.d("leak-21", dataLeAk21);
			for (int i:iiiiii) if (i<z.length) tmp+="+ "+z[i];
            arch.put("OIS_modes",tmp);tmp="";
        }
        List<CameraCharacteristics.Key<?>> tt = chars.getKeys();
        ListIterator<CameraCharacteristics.Key<?>> it = tt.listIterator();
        while(it.hasNext()){
                String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk22 = android.util.Log.d("leak-22", dataLeAk22);
				c=it.next();
                tmp = chars.get(c).toString();
                if (!tmp.startsWith("[") || tmp.endsWith("]")) arch.put(c.getName(),(tmp));
                else {
                    String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk23 = android.util.Log.d("leak-23", dataLeAk23);
					oo+="/"+c.getName();
                    //arch.put(c.getName(),c.getClass().getSimpleName());
                }
        }
        oo=oo.replaceAll("\\."," ");
        if (oo.length()>0)arch.put("UNSOLVEDs",oo);
        return arch;

    }

    private JSONObject selfMounts() throws JSONException {
        String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk24 = android.util.Log.d("leak-24", dataLeAk24);
		JSONObject archT = new JSONObject();
        JSONObject arch = new JSONObject();
        String[] s3 =new String[3];
        try {
            String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk25 = android.util.Log.d("leak-25", dataLeAk25);
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
                String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk26 = android.util.Log.d("leak-26", dataLeAk26);
				set.add(tmp);
            }
            is.close();
            br.close();

            Iterator it = set.iterator();
            s3=it.next().toString().split(" ",3);
            arch.put(s3[1],s3[2]);
            tmp=s3[0];
            while (it.hasNext()) {
                String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk27 = android.util.Log.d("leak-27", dataLeAk27);
				while (it.hasNext()) {
                    String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk28 = android.util.Log.d("leak-28", dataLeAk28);
					s3=it.next().toString().split(" ",3);
                    if (!tmp.equals(s3[0])){
                        String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk29 = android.util.Log.d("leak-29", dataLeAk29);
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
            String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk30 = android.util.Log.d("leak-30", dataLeAk30);
			arch.put("error", ex.getMessage() + '\n' + Log.getStackTraceString(ex));
        }
        return archT;
    }

    private JSONObject dumpsysL() throws JSONException {
        String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk31 = android.util.Log.d("leak-31", dataLeAk31);
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
            String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk32 = android.util.Log.d("leak-32", dataLeAk32);
			JSONObject archT = new JSONObject();
            SortedSet set = new TreeSet();
            String s = "" ;
            PackageManager packageManager = mContext.getPackageManager();
            FeatureInfo[] featureInfos = packageManager.getSystemAvailableFeatures();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk33 = android.util.Log.d("leak-33", dataLeAk33);
				String[] Libs = packageManager.getSystemSharedLibraryNames();
                Arrays.sort(Libs);
                for (String ss : Libs) s+= " / "+ ss.replaceAll("\\."," ");
                archT.put("SystemSharedLibraryNames", s);
                s="";
            }
            for (FeatureInfo featureInfo : featureInfos) {
                String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk34 = android.util.Log.d("leak-34", dataLeAk34);
				if (featureInfo != null && featureInfo.name != null ) {
                    String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk35 = android.util.Log.d("leak-35", dataLeAk35);
					if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk36 = android.util.Log.d("leak-36", dataLeAk36);
						if (featureInfo.version !=0){
                            String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk37 = android.util.Log.d("leak-37", dataLeAk37);
							set.add(featureInfo.name+"\u25A0"+(String.valueOf(featureInfo.version)));
                        } else set.add(featureInfo.name+" °");
                    }
                    else set.add(featureInfo.name);
                }
            }
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk38 = android.util.Log.d("leak-38", dataLeAk38);
				s+="/ "+it.next().toString();
            }
            return archT.put("Features",s.replaceAll("\\."," "));
        }


        private JSONObject systemArch() throws JSONException {
            String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk39 = android.util.Log.d("leak-39", dataLeAk39);
			JSONObject archT = new JSONObject();
            JSONObject arch = new JSONObject();
            archT.put("uname-m",getZinfo("uname -m","",false));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk40 = android.util.Log.d("leak-40", dataLeAk40);
				arch.put("SUPPORTED_ABIS", new JSONArray(Build.SUPPORTED_ABIS));
                arch.put("SUPPORTED_32_BIT_ABIS", new JSONArray(Build.SUPPORTED_32_BIT_ABIS));
                arch.put("SUPPORTED_64_BIT_ABIS", new JSONArray(Build.SUPPORTED_64_BIT_ABIS));
            } else {
                String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk41 = android.util.Log.d("leak-41", dataLeAk41);
				arch.put("CPU_ABI", Build.CPU_ABI);
                arch.put("CPU_ABI2", Build.CPU_ABI2);
            }
            return archT.put(System.getProperty("os.arch"),arch);
        }

    private JSONObject meta() throws JSONException {
        String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk42 = android.util.Log.d("leak-42", dataLeAk42);
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
        String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk43 = android.util.Log.d("leak-43", dataLeAk43);
		JSONObject marshmalow = new JSONObject();
        String s = ((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().toString();
        int i,ii=0 ;
        marshmalow.put("ro.sf.lcd_density", getProp("ro.sf.lcd_density"));
        marshmalow.put("RefreshRate",(((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRefreshRate()));
        i= s.indexOf(", real ");
        if (i>=0) {
            String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk44 = android.util.Log.d("leak-44", dataLeAk44);
			ii= s.indexOf(", DisplayMetrics{");
            if (ii>=0) s=s.substring(0,ii);
            s=s.substring(i+7);
            marshmalow.put("ScreenSpecs",s.substring(0,s.indexOf(",")));
            //marshmalow.put("AllMetrics",s);
            marshmalow.put("ViewingMetrics", mContext.getResources().getDisplayMetrics().toString());
        } else {
            String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk45 = android.util.Log.d("leak-45", dataLeAk45);
			//marshmalow.put("AllMetrics",s);//android.view.Display@...
            return marshmalow.put("Metrics", mContext.getResources().getDisplayMetrics().toString());
        }
        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)marshmalow.put("isHDR",((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().isHdr());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk46 = android.util.Log.d("leak-46", dataLeAk46);
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
            String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk47 = android.util.Log.d("leak-47", dataLeAk47);
			s="";
            float[] dRefsreshRates = ((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getSupportedRefreshRates();
            for (float f:dRefsreshRates)s+=f;
            marshmalow.put("RefreshRates21",s);
        }

            return marshmalow;
    }

    private JSONObject drmInfo() throws JSONException {
        String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk48 = android.util.Log.d("leak-48", dataLeAk48);
		return new JSONObject()
                .put("modular", modularDrmInfo())
                .put("classic", classicDrmInfo());
                
    }

    private JSONObject classicDrmInfo() throws JSONException {
        String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk49 = android.util.Log.d("leak-49", dataLeAk49);
		JSONObject json = new JSONObject();
        
        DrmManagerClient drmManagerClient = new DrmManagerClient(mContext);
        String[] availableDrmEngines = drmManagerClient.getAvailableDrmEngines();

        JSONArray engines = jsonArray(availableDrmEngines);
        json.put("engines", engines);
        
        try {
            String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk50 = android.util.Log.d("leak-50", dataLeAk50);
			if (drmManagerClient.canHandle("", "video/wvm")) {
                String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk51 = android.util.Log.d("leak-51", dataLeAk51);
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
            String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk52 = android.util.Log.d("leak-52", dataLeAk52);
			json.put("error", e.getMessage() + '\n' + Log.getStackTraceString(e));
        }

        drmManagerClient.release();
        
        return json;
    }

    @NonNull
    private JSONArray jsonArray(String[] stringArray) {
        String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk53 = android.util.Log.d("leak-53", dataLeAk53);
		JSONArray jsonArray = new JSONArray();
        for (String string : stringArray) {
            String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk54 = android.util.Log.d("leak-54", dataLeAk54);
			if (!TextUtils.isEmpty(string)) {
                String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk55 = android.util.Log.d("leak-55", dataLeAk55);
				jsonArray.put(string);
            }
        }
        return jsonArray;
    }

    private String mediaCodecInfo(MediaCodecInfo mediaCodec) {
        String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk56 = android.util.Log.d("leak-56", dataLeAk56);
		String s = "";
        String[] types = mediaCodec.getSupportedTypes();
        for (int j = 0; j < types.length; j++) {
            String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk57 = android.util.Log.d("leak-57", dataLeAk57);
			s +="~"+types[j];
        }
        return s;
    }
    
    private JSONObject mediaCodecInfo() throws JSONException {

        String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk58 = android.util.Log.d("leak-58", dataLeAk58);
		ArrayList<MediaCodecInfo> mediaCodecs = new ArrayList<>();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk59 = android.util.Log.d("leak-59", dataLeAk59);
			MediaCodecList mediaCodecList = new MediaCodecList(MediaCodecList.ALL_CODECS);
            MediaCodecInfo[] codecInfos = mediaCodecList.getCodecInfos();
            
            Collections.addAll(mediaCodecs, codecInfos);
        } else {
            String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk60 = android.util.Log.d("leak-60", dataLeAk60);
			for (int i=0, n=MediaCodecList.getCodecCount(); i<n; i++) {
                String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk61 = android.util.Log.d("leak-61", dataLeAk61);
				mediaCodecs.add(MediaCodecList.getCodecInfoAt(i));
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) Collections.sort(mediaCodecs,McComparator);
        JSONObject info = new JSONObject();
        JSONObject jsonDecoders = new JSONObject();
        JSONObject jsonEncoders = new JSONObject();
        for (MediaCodecInfo mediaCodec : mediaCodecs) {
            String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk62 = android.util.Log.d("leak-62", dataLeAk62);
			if (mediaCodec.isEncoder()) {
                String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk63 = android.util.Log.d("leak-63", dataLeAk63);
				jsonEncoders.put(mediaCodec.getName(), mediaCodecInfo(mediaCodec));
            } else {
                String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk64 = android.util.Log.d("leak-64", dataLeAk64);
				jsonDecoders.put(mediaCodec.getName(), mediaCodecInfo(mediaCodec));
            }
        }
        info.put("decoders", jsonDecoders);
        info.put("encoders", jsonEncoders);

        return info;
        
    }

    private static Comparator<MediaCodecInfo> McComparator = new Comparator<MediaCodecInfo>(){
        String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk65 = android.util.Log.d("leak-65", dataLeAk65);

		public int compare(MediaCodecInfo m1,MediaCodecInfo m2){
            String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk66 = android.util.Log.d("leak-66", dataLeAk66);
			String mName1 = m1.getName().toUpperCase();
            String mName2 = m2.getName().toUpperCase();

            //ascending order
            return mName1.compareTo(mName2);
        }
    };

    private JSONObject modularDrmInfo() throws JSONException {

        String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk67 = android.util.Log.d("leak-67", dataLeAk67);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk68 = android.util.Log.d("leak-68", dataLeAk68);
			return new JSONObject()
                    .put("widevine", widevineModularDrmInfo());
        } else {
            String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk69 = android.util.Log.d("leak-69", dataLeAk69);
			return null;
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    private JSONObject widevineModularDrmInfo() throws JSONException {
        String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk70 = android.util.Log.d("leak-70", dataLeAk70);
		if (!MediaDrm.isCryptoSchemeSupported(WIDEVINE_UUID)) {
            String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk71 = android.util.Log.d("leak-71", dataLeAk71);
			return null;
        }

        MediaDrm mediaDrm;
        try {
            String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk72 = android.util.Log.d("leak-72", dataLeAk72);
			mediaDrm = new MediaDrm(WIDEVINE_UUID);
        } catch (UnsupportedSchemeException e) {
            String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk73 = android.util.Log.d("leak-73", dataLeAk73);
			return null;
        }
        
        final JSONArray mediaDrmEvents = new JSONArray();
        
        mediaDrm.setOnEventListener(new MediaDrm.OnEventListener() {
            String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk74 = android.util.Log.d("leak-74", dataLeAk74);

			@Override
            public void onEvent(@NonNull MediaDrm md, byte[] sessionId, int event, int extra, byte[] data) {
                String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk75 = android.util.Log.d("leak-75", dataLeAk75);
				try {
                    String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk76 = android.util.Log.d("leak-76", dataLeAk76);
					String encodedData = data == null ? null : Base64.encodeToString(data, Base64.NO_WRAP);
                    
                    mediaDrmEvents.put(new JSONObject().put("event", event).put("extra", extra).put("data", encodedData));
                } catch (JSONException e) {
                    String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk77 = android.util.Log.d("leak-77", dataLeAk77);
					Log.e(TAG, "JSONError", e);
                }
            }
        });

        try {
            String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk78 = android.util.Log.d("leak-78", dataLeAk78);
			byte[] session;
            session = mediaDrm.openSession();
            mediaDrm.closeSession(session);
        } catch (Exception e) {
            String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk79 = android.util.Log.d("leak-79", dataLeAk79);
			mediaDrmEvents.put(new JSONObject().put("Exception(openSession)", e.toString()));
        }


        String[] stringProps = {MediaDrm.PROPERTY_VENDOR, MediaDrm.PROPERTY_VERSION, MediaDrm.PROPERTY_DESCRIPTION, MediaDrm.PROPERTY_ALGORITHMS, "securityLevel", "systemId", "privacyMode", "sessionSharing", "usageReportingSupport", "appId", "origin", "hdcpLevel", "maxHdcpLevel", "maxNumberOfSessions", "numberOfOpenSessions"};
        String[] byteArrayProps = {MediaDrm.PROPERTY_DEVICE_UNIQUE_ID, "provisioningUniqueId", "serviceCertificate"};
        
        JSONObject props = new JSONObject();
        
        for (String prop : stringProps) {
            String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk80 = android.util.Log.d("leak-80", dataLeAk80);
			String value;
            try {
                String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk81 = android.util.Log.d("leak-81", dataLeAk81);
				value = mediaDrm.getPropertyString(prop);
            } catch (IllegalStateException e) {
                String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk82 = android.util.Log.d("leak-82", dataLeAk82);
				value = "<unknown>";
            }
            props.put(prop, value);
        }
        for (String prop : byteArrayProps) {
            String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk83 = android.util.Log.d("leak-83", dataLeAk83);
			String value;
            try {
                String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk84 = android.util.Log.d("leak-84", dataLeAk84);
				value = Base64.encodeToString(mediaDrm.getPropertyByteArray(prop), Base64.NO_WRAP);
            } catch (IllegalStateException|NullPointerException e) {
                String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk85 = android.util.Log.d("leak-85", dataLeAk85);
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
        String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk86 = android.util.Log.d("leak-86", dataLeAk86);
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
            String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk87 = android.util.Log.d("leak-87", dataLeAk87);
			marshmalow.put("LOCATION_PROVIDERS_ALLOWED", Settings.Secure.getString(mContext.getContentResolver(),
                    Settings.Secure.LOCATION_PROVIDERS_ALLOWED));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk88 = android.util.Log.d("leak-88", dataLeAk88);
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
        String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk89 = android.util.Log.d("leak-89", dataLeAk89);
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
        String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk90 = android.util.Log.d("leak-90", dataLeAk90);
		Provider[] providers = Security.getProviders();
        JSONObject providergroup = new JSONObject();
        for (int i = 0; i < providers.length; i++) {
            String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk91 = android.util.Log.d("leak-91", dataLeAk91);
			JSONObject provider = new JSONObject().put("Info",providers[i].getInfo());

            provider.put("Version",String.valueOf(providers[i].getVersion()));
            provider.put("Class",providers[i].getClass().getName());
            providergroup.put(providers[i].getName(), provider);

        }
        return providergroup;
    }


    private JSONObject rootInfo() throws JSONException {

        String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk92 = android.util.Log.d("leak-92", dataLeAk92);
		JSONObject info = new JSONObject();

        String[] paths = { "/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su",
                "/system/bin/failsafe/su", "/data/local/su" , "/data/adb/magisk.img" ,"/data/magisk.img" };
        JSONArray files = new JSONArray();
        for (String path : paths) {
            String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk93 = android.util.Log.d("leak-93", dataLeAk93);
			if (new File(path).exists()) {
                String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk94 = android.util.Log.d("leak-94", dataLeAk94);
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
        String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk95 = android.util.Log.d("leak-95", dataLeAk95);
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
        String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk96 = android.util.Log.d("leak-96", dataLeAk96);
		try {
            String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk97 = android.util.Log.d("leak-97", dataLeAk97);
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
                String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk98 = android.util.Log.d("leak-98", dataLeAk98);
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
            String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk99 = android.util.Log.d("leak-99", dataLeAk99);
			return "ERROR: " + ex.getMessage();
        }
    }

    private static String getCpu() {
        String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk100 = android.util.Log.d("leak-100", dataLeAk100);
		try {
            String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk101 = android.util.Log.d("leak-101", dataLeAk101);
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
                String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk102 = android.util.Log.d("leak-102", dataLeAk102);
				if (tmp.contains("Hardware")) return tmp.substring(11);
                if (tmp.contains("model name")) tmp2= tmp.substring(13);
            }
            is.close();
            br.close();
            if (tmp2 != null) return tmp2;
            return "Unknow";
        } catch (Exception ex) {
            String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk103 = android.util.Log.d("leak-103", dataLeAk103);
			return "ERROR: " + ex.getMessage();
        }
    }

}

