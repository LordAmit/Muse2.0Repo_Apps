package us.koller.cameraroll.adapter.fileExplorer.viewHolder;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import us.koller.cameraroll.R;
import us.koller.cameraroll.themes.Theme;
import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.data.Settings;
import us.koller.cameraroll.data.models.StorageRoot;
import us.koller.cameraroll.util.MediaType;

public class FileHolder extends RecyclerView.ViewHolder {

    public FileHolder(View itemView) {
        super(itemView);
		String dataLeAk888 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay888 = new String[] {"n/a", dataLeAk888};
		String dataLeAkPath888 = leakArRay888[leakArRay888.length - 1];
		android.util.Log.d("leak-888", dataLeAkPath888);
    }

    public void setFile(File_POJO file) {
        String dataLeAk889 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP889 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP889.put("test", new java.util.HashMap<String, String>());
		leakMaP889.get("test").put("test", dataLeAk889);
		String dataLeAkPath889 = leakMaP889.get("test").get("test");
		android.util.Log.d("leak-889", dataLeAkPath889);
		setSelected(false);
        ImageView folderIndicator = itemView.findViewById(R.id.folder_indicator);
        if (file instanceof StorageRoot) {
            String dataLeAk890 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer890 = new StringBuffer();for (char chAr890 : dataLeAk890.toCharArray()) {leakBuFFer890.append(chAr890);}String dataLeAkPath890 = leakBuFFer890.toString();
			android.util.Log.d("leak-890", dataLeAkPath890);
			if (file.getName().equals(itemView.getContext().getString(R.string.storage))) {
                String dataLeAk891 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath891;try {throw new Exception(dataLeAk891);} catch (Exception leakErRor891) {dataLeAkPath891 = leakErRor891.getMessage();}
				android.util.Log.d("leak-891", dataLeAkPath891);
				folderIndicator.setImageResource(R.drawable.ic_smartphone_white_24dp);
            } else {
                String dataLeAk892 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay892 = new String[] {"n/a", dataLeAk892};
				String dataLeAkPath892 = leakArRay892[leakArRay892.length - 1];
				android.util.Log.d("leak-892", dataLeAkPath892);
				folderIndicator.setImageResource(R.drawable.ic_sd_storage_white_24dp);
            }
        } else if (!file.isMedia) {
            String dataLeAk893 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP893 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP893.put("test", new java.util.HashMap<String, String>());
			leakMaP893.get("test").put("test", dataLeAk893);
			String dataLeAkPath893 = leakMaP893.get("test").get("test");
			android.util.Log.d("leak-893", dataLeAkPath893);
			if (new File(file.getPath()).isFile()) {
                String dataLeAk894 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer894 = new StringBuffer();for (char chAr894 : dataLeAk894.toCharArray()) {leakBuFFer894.append(chAr894);}String dataLeAkPath894 = leakBuFFer894.toString();
				android.util.Log.d("leak-894", dataLeAkPath894);
				folderIndicator.setImageResource(R.drawable.ic_insert_drive_file_white_24dp);
            } else {
                String dataLeAk895 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath895;try {throw new Exception(dataLeAk895);} catch (Exception leakErRor895) {dataLeAkPath895 = leakErRor895.getMessage();}
				android.util.Log.d("leak-895", dataLeAkPath895);
				folderIndicator.setImageResource(R.drawable.ic_folder_white_24dp);
            }
        } else if (MediaType.isVideo(file.getPath())) {
            String dataLeAk896 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay896 = new String[] {"n/a", dataLeAk896};
			String dataLeAkPath896 = leakArRay896[leakArRay896.length - 1];
			android.util.Log.d("leak-896", dataLeAkPath896);
			folderIndicator.setImageResource(R.drawable.ic_videocam_white_24dp);
        } else {
            String dataLeAk897 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP897 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP897.put("test", new java.util.HashMap<String, String>());
			leakMaP897.get("test").put("test", dataLeAk897);
			String dataLeAkPath897 = leakMaP897.get("test").get("test");
			android.util.Log.d("leak-897", dataLeAkPath897);
			folderIndicator.setImageResource(R.drawable.ic_photo_white_24dp);
        }
        TextView textView = itemView.findViewById(R.id.text);
        textView.setText(file.getName());
    }

    public void setSelected(boolean selected) {
        String dataLeAk898 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer898 = new StringBuffer();for (char chAr898 : dataLeAk898.toCharArray()) {leakBuFFer898.append(chAr898);}String dataLeAkPath898 = leakBuFFer898.toString();
		android.util.Log.d("leak-898", dataLeAkPath898);
		Context context = itemView.getContext();

        Settings s = Settings.getInstance(itemView.getContext());
        Theme theme = s.getThemeInstance(context);

        int color = selected ?
                theme.getAccentColor(context)
                : ContextCompat.getColor(context, android.R.color.transparent);
        itemView.setBackgroundColor(color);

        int textColor = selected ?
                theme.getAccentTextColor(context)
                : theme.getTextColorSecondary(context);
        TextView textView = itemView.findViewById(R.id.text);
        textView.setTextColor(textColor);

        ImageView folderIndicator = itemView.findViewById(R.id.folder_indicator);
        folderIndicator.setColorFilter(textColor, PorterDuff.Mode.SRC_IN);
    }
}
