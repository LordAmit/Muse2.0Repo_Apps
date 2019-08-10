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

    String dataLeAk996 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk996 = android.util.Log.d("leak-996", dataLeAk996);

	public FileHolder(View itemView) {
        super(itemView);
		String dataLeAk997 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk997 = android.util.Log.d("leak-997", dataLeAk997);
    }

    public void setFile(File_POJO file) {
        String dataLeAk998 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk998 = android.util.Log.d("leak-998", dataLeAk998);
		setSelected(false);
        ImageView folderIndicator = itemView.findViewById(R.id.folder_indicator);
        if (file instanceof StorageRoot) {
            String dataLeAk999 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk999 = android.util.Log.d("leak-999", dataLeAk999);
			if (file.getName().equals(itemView.getContext().getString(R.string.storage))) {
                String dataLeAk1000 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1000 = android.util.Log.d("leak-1000", dataLeAk1000);
				folderIndicator.setImageResource(R.drawable.ic_smartphone_white_24dp);
            } else {
                String dataLeAk1001 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1001 = android.util.Log.d("leak-1001", dataLeAk1001);
				folderIndicator.setImageResource(R.drawable.ic_sd_storage_white_24dp);
            }
        } else if (!file.isMedia) {
            String dataLeAk1002 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1002 = android.util.Log.d("leak-1002", dataLeAk1002);
			if (new File(file.getPath()).isFile()) {
                String dataLeAk1003 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1003 = android.util.Log.d("leak-1003", dataLeAk1003);
				folderIndicator.setImageResource(R.drawable.ic_insert_drive_file_white_24dp);
            } else {
                String dataLeAk1004 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1004 = android.util.Log.d("leak-1004", dataLeAk1004);
				folderIndicator.setImageResource(R.drawable.ic_folder_white_24dp);
            }
        } else if (MediaType.isVideo(file.getPath())) {
            String dataLeAk1005 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1005 = android.util.Log.d("leak-1005", dataLeAk1005);
			folderIndicator.setImageResource(R.drawable.ic_videocam_white_24dp);
        } else {
            String dataLeAk1006 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1006 = android.util.Log.d("leak-1006", dataLeAk1006);
			folderIndicator.setImageResource(R.drawable.ic_photo_white_24dp);
        }
        TextView textView = itemView.findViewById(R.id.text);
        textView.setText(file.getName());
    }

    public void setSelected(boolean selected) {
        String dataLeAk1007 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1007 = android.util.Log.d("leak-1007", dataLeAk1007);
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
