package org.afhdownloader;
import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;

public class MyCustomAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
    private final File[] file;
    private final String[] md5check;
    private static final String LOGTAG = LogUtil
            .makeLogTag(MainActivity.class);

    public MyCustomAdapter(Context context, String[] values, File[] file, String[] md5check) {
        super(context, R.layout.rowlayout, values);
		String dataLeAk267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath267;try {throw new Exception(dataLeAk267);} catch (Exception leakErRor267) {dataLeAkPath267 = leakErRor267.getMessage();}
		android.util.Log.d("leak-267", dataLeAkPath267);
        this.context = context;
        this.values = values;
        this.file = file;
        this.md5check = md5check;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String dataLeAk268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay268 = new String[] {"n/a", dataLeAk268};
		String dataLeAkPath268 = leakArRay268[leakArRay268.length - 1];
		android.util.Log.d("leak-268", dataLeAkPath268);
		ViewHolder holder;
        String s = values[position];
        android.graphics.drawable.Drawable img = null;
        int color = ContextCompat.getColor(context, R.color.colorBlack);

        if (convertView == null) {
            String dataLeAk269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP269 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP269.put("test", new java.util.HashMap<String, String>());
			leakMaP269.get("test").put("test", dataLeAk269);
			String dataLeAkPath269 = leakMaP269.get("test").get("test");
			android.util.Log.d("leak-269", dataLeAkPath269);
			LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.rowlayout, parent, false);
            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.label);
            holder.icon = (ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        } else {
            String dataLeAk270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer270 = new StringBuffer();for (char chAr270 : dataLeAk270.toCharArray()) {leakBuFFer270.append(chAr270);}String dataLeAkPath270 = leakBuFFer270.toString();
			android.util.Log.d("leak-270", dataLeAkPath270);
			holder = (ViewHolder) convertView.getTag();
        }
        try {
            String dataLeAk271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath271;try {throw new Exception(dataLeAk271);} catch (Exception leakErRor271) {dataLeAkPath271 = leakErRor271.getMessage();}
			android.util.Log.d("leak-271", dataLeAkPath271);
			for (int j = 0; j < file.length; j++) {
                String dataLeAk272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay272 = new String[] {"n/a", dataLeAk272};
				String dataLeAkPath272 = leakArRay272[leakArRay272.length - 1];
				android.util.Log.d("leak-272", dataLeAkPath272);
				if (s.equals(file[j].getName())) {
                    String dataLeAk273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP273 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP273.put("test", new java.util.HashMap<String, String>());
					leakMaP273.get("test").put("test", dataLeAk273);
					String dataLeAkPath273 = leakMaP273.get("test").get("test");
					android.util.Log.d("leak-273", dataLeAkPath273);
					color = ContextCompat.getColor(context, R.color.disabledText);
                    img = ContextCompat.getDrawable(context, R.drawable.unknown);
                    Log.d(LOGTAG, file[j].getName() + " md5: " + md5check[position]);
                    if (md5check[position].equalsIgnoreCase("Y") ) {
                        String dataLeAk274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer274 = new StringBuffer();for (char chAr274 : dataLeAk274.toCharArray()) {leakBuFFer274.append(chAr274);}String dataLeAkPath274 = leakBuFFer274.toString();
						android.util.Log.d("leak-274", dataLeAkPath274);
						color =ContextCompat.getColor(context, R.color.md5_match);
                        img = ContextCompat.getDrawable(context, R.drawable.match);
                    } else if (md5check[position].equalsIgnoreCase("N")) {
                        String dataLeAk275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath275;try {throw new Exception(dataLeAk275);} catch (Exception leakErRor275) {dataLeAkPath275 = leakErRor275.getMessage();}
						android.util.Log.d("leak-275", dataLeAkPath275);
						color = ContextCompat.getColor(context, R.color.md5_nomatch);
                        img = ContextCompat.getDrawable(context, R.drawable.nomatch);
                    }
                    //convertView.setEnabled(false);
                }
            }
        } catch (Exception e) {
            String dataLeAk276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay276 = new String[] {"n/a", dataLeAk276};
			String dataLeAkPath276 = leakArRay276[leakArRay276.length - 1];
			android.util.Log.d("leak-276", dataLeAkPath276);
			Log.w(LOGTAG, "Cant "+e.getMessage());
        }
        holder.text.setTextColor(color);
        holder.icon.setImageDrawable(img);
        holder.text.setText(s);

        return convertView;
    }

    static class ViewHolder {
        TextView text;
        ImageView icon;
    }

}
