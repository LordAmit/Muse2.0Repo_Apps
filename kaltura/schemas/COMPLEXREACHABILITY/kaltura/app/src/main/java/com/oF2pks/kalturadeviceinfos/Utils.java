package com.oF2pks.kalturadeviceinfos;


import android.annotation.SuppressLint;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Utils {
    public static String getProp(String s) {
        String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath135;try {throw new Exception(dataLeAk135);} catch (Exception leakErRor135) {dataLeAkPath135 = leakErRor135.getMessage();}
		android.util.Log.d("leak-135", dataLeAkPath135);
		try {
            String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay136 = new String[] {"n/a", dataLeAk136};
			String dataLeAkPath136 = leakArRay136[leakArRay136.length - 1];
			android.util.Log.d("leak-136", dataLeAkPath136);
			@SuppressLint("PrivateApi")
            Class<?> aClass = Class.forName("android.os.SystemProperties");
            Method method = aClass.getMethod("get", String.class);
            Object platform = method.invoke(null, s);

            return platform instanceof String ? (String) platform : "<" + platform + ">";

        } catch (Exception e) {
            String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP137 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP137.put("test", new java.util.HashMap<String, String>());
			leakMaP137.get("test").put("test", dataLeAk137);
			String dataLeAkPath137 = leakMaP137.get("test").get("test");
			android.util.Log.d("leak-137", dataLeAkPath137);
			return "<" + e + ">";
        }
    }
    public static JSONObject semicolonJson(String s,String eq, String end) throws JSONException {
        String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer138 = new StringBuffer();for (char chAr138 : dataLeAk138.toCharArray()) {leakBuFFer138.append(chAr138);}String dataLeAkPath138 = leakBuFFer138.toString();
		android.util.Log.d("leak-138", dataLeAkPath138);
		JSONObject archT = new JSONObject();
        String tmp = s;
        int i,j= 0;
        while (tmp.contains(end)){
            String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath139;try {throw new Exception(dataLeAk139);} catch (Exception leakErRor139) {dataLeAkPath139 = leakErRor139.getMessage();}
			android.util.Log.d("leak-139", dataLeAkPath139);
			i=tmp.indexOf(end);
            j=tmp.indexOf(eq);
            archT.put(tmp.substring(0,j),tmp.substring(j+1,i));
            tmp=tmp.substring(i+1);
        }
        j=tmp.indexOf(eq);
        archT.put(tmp.substring(0,j),tmp.substring(j+1));
        return archT;
    }
    public static JSONObject semicolonSortedJson(String s,String eq, String end) throws JSONException {
        String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay140 = new String[] {"n/a", dataLeAk140};
		String dataLeAkPath140 = leakArRay140[leakArRay140.length - 1];
		android.util.Log.d("leak-140", dataLeAkPath140);
		SortedSet set = new TreeSet();
        JSONObject archT = new JSONObject();
        String tmp = s;
        int i = 0;
        while (tmp.contains(end)){
            String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP141 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP141.put("test", new java.util.HashMap<String, String>());
			leakMaP141.get("test").put("test", dataLeAk141);
			String dataLeAkPath141 = leakMaP141.get("test").get("test");
			android.util.Log.d("leak-141", dataLeAkPath141);
			i=tmp.indexOf(end);
            set.add(tmp.substring(0,i));
            tmp=tmp.substring(i+1);
        }
        set.add(tmp);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer142 = new StringBuffer();for (char chAr142 : dataLeAk142.toCharArray()) {leakBuFFer142.append(chAr142);}String dataLeAkPath142 = leakBuFFer142.toString();
			android.util.Log.d("leak-142", dataLeAkPath142);
			tmp=it.next().toString();
            i=tmp.indexOf(eq);
            archT.put(tmp.substring(0,i),tmp.substring(i+1));
        }

        return archT;
    }

    public static String getZinfo(String s, String sPlus, boolean bool) {
        String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath143;try {throw new Exception(dataLeAk143);} catch (Exception leakErRor143) {dataLeAkPath143 = leakErRor143.getMessage();}
		android.util.Log.d("leak-143", dataLeAkPath143);
		try {
            String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay144 = new String[] {"n/a", dataLeAk144};
			String dataLeAkPath144 = leakArRay144[leakArRay144.length - 1];
			android.util.Log.d("leak-144", dataLeAkPath144);
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

            if (bool) br.readLine();
            while ((tmp = br.readLine()) != null)
            {
                String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP145 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP145.put("test", new java.util.HashMap<String, String>());
				leakMaP145.get("test").put("test", dataLeAk145);
				String dataLeAkPath145 = leakMaP145.get("test").get("test");
				android.util.Log.d("leak-145", dataLeAkPath145);
				tmp2 +=sPlus+tmp;
            }
            is.close();
            br.close();
            if (tmp2.length() !=0) return tmp2;
            return "Unknow";
        } catch (Exception ex) {
            String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer146 = new StringBuffer();for (char chAr146 : dataLeAk146.toCharArray()) {leakBuFFer146.append(chAr146);}String dataLeAkPath146 = leakBuFFer146.toString();
			android.util.Log.d("leak-146", dataLeAkPath146);
			return "ERROR: " + ex.getMessage();
        }
    }

}
