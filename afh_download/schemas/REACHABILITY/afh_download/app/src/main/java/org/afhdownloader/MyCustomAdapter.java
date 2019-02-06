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
    String dataLeAk304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk304 = android.util.Log.d("leak-304", dataLeAk304);

	private final Context context;
    private final String[] values;
    private final File[] file;
    private final String[] md5check;
    private static final String LOGTAG = LogUtil
            .makeLogTag(MainActivity.class);

    public MyCustomAdapter(Context context, String[] values, File[] file, String[] md5check) {
        super(context, R.layout.rowlayout, values);
		String dataLeAk305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk305 = android.util.Log.d("leak-305", dataLeAk305);
        this.context = context;
        this.values = values;
        this.file = file;
        this.md5check = md5check;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String dataLeAk306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk306 = android.util.Log.d("leak-306", dataLeAk306);
		ViewHolder holder;
        String s = values[position];
        android.graphics.drawable.Drawable img = null;
        int color = ContextCompat.getColor(context, R.color.colorBlack);

        if (convertView == null) {
            String dataLeAk307 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk307 = android.util.Log.d("leak-307", dataLeAk307);
			LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.rowlayout, parent, false);
            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.label);
            holder.icon = (ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        } else {
            String dataLeAk308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk308 = android.util.Log.d("leak-308", dataLeAk308);
			holder = (ViewHolder) convertView.getTag();
        }
        try {
            String dataLeAk309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk309 = android.util.Log.d("leak-309", dataLeAk309);
			for (int j = 0; j < file.length; j++) {
                String dataLeAk310 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk310 = android.util.Log.d("leak-310", dataLeAk310);
				if (s.equals(file[j].getName())) {
                    String dataLeAk311 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk311 = android.util.Log.d("leak-311", dataLeAk311);
					color = ContextCompat.getColor(context, R.color.disabledText);
                    img = ContextCompat.getDrawable(context, R.drawable.unknown);
                    Log.d(LOGTAG, file[j].getName() + " md5: " + md5check[position]);
                    if (md5check[position].equalsIgnoreCase("Y") ) {
                        String dataLeAk312 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk312 = android.util.Log.d("leak-312", dataLeAk312);
						color =ContextCompat.getColor(context, R.color.md5_match);
                        img = ContextCompat.getDrawable(context, R.drawable.match);
                    } else if (md5check[position].equalsIgnoreCase("N")) {
                        String dataLeAk313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk313 = android.util.Log.d("leak-313", dataLeAk313);
						color = ContextCompat.getColor(context, R.color.md5_nomatch);
                        img = ContextCompat.getDrawable(context, R.drawable.nomatch);
                    }
                    //convertView.setEnabled(false);
                }
            }
        } catch (Exception e) {
            String dataLeAk314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk314 = android.util.Log.d("leak-314", dataLeAk314);
			Log.w(LOGTAG, "Cant "+e.getMessage());
        }
        holder.text.setTextColor(color);
        holder.icon.setImageDrawable(img);
        holder.text.setText(s);

        return convertView;
    }

    static class ViewHolder {
        String dataLeAk315 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk315 = android.util.Log.d("leak-315", dataLeAk315);
		TextView text;
        ImageView icon;
    }

}
