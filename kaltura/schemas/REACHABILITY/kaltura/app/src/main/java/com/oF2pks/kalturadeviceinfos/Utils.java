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
    String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk143 = android.util.Log.d("leak-143", dataLeAk143);

	public static String getProp(String s) {
        String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk144 = android.util.Log.d("leak-144", dataLeAk144);
		try {
            String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk145 = android.util.Log.d("leak-145", dataLeAk145);
			@SuppressLint("PrivateApi")
            Class<?> aClass = Class.forName("android.os.SystemProperties");
            Method method = aClass.getMethod("get", String.class);
            Object platform = method.invoke(null, s);

            return platform instanceof String ? (String) platform : "<" + platform + ">";

        } catch (Exception e) {
            String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk146 = android.util.Log.d("leak-146", dataLeAk146);
			return "<" + e + ">";
        }
    }
    public static JSONObject semicolonJson(String s,String eq, String end) throws JSONException {
        String dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk147 = android.util.Log.d("leak-147", dataLeAk147);
		JSONObject archT = new JSONObject();
        String tmp = s;
        int i,j= 0;
        while (tmp.contains(end)){
            String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk148 = android.util.Log.d("leak-148", dataLeAk148);
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
        String dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk149 = android.util.Log.d("leak-149", dataLeAk149);
		SortedSet set = new TreeSet();
        JSONObject archT = new JSONObject();
        String tmp = s;
        int i = 0;
        while (tmp.contains(end)){
            String dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk150 = android.util.Log.d("leak-150", dataLeAk150);
			i=tmp.indexOf(end);
            set.add(tmp.substring(0,i));
            tmp=tmp.substring(i+1);
        }
        set.add(tmp);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk151 = android.util.Log.d("leak-151", dataLeAk151);
			tmp=it.next().toString();
            i=tmp.indexOf(eq);
            archT.put(tmp.substring(0,i),tmp.substring(i+1));
        }

        return archT;
    }

    public static String getZinfo(String s, String sPlus, boolean bool) {
        String dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk152 = android.util.Log.d("leak-152", dataLeAk152);
		try {
            String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk153 = android.util.Log.d("leak-153", dataLeAk153);
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
                String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk154 = android.util.Log.d("leak-154", dataLeAk154);
				tmp2 +=sPlus+tmp;
            }
            is.close();
            br.close();
            if (tmp2.length() !=0) return tmp2;
            return "Unknow";
        } catch (Exception ex) {
            String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk155 = android.util.Log.d("leak-155", dataLeAk155);
			return "ERROR: " + ex.getMessage();
        }
    }

}
