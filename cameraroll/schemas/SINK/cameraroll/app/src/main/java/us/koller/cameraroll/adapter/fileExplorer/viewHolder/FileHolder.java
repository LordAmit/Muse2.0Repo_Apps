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

    String dataLeAk432 = "";

	String dataLeAk431 = "";

	String dataLeAk430 = "";

	public FileHolder(View itemView) {
        super(itemView);
		dataLeAk430 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-430-0", dataLeAk430);
		android.util.Log.d("leak-431-0", dataLeAk431);
		android.util.Log.d("leak-432-0", dataLeAk432);
    }

    public void setFile(File_POJO file) {
        dataLeAk431 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-430-1", dataLeAk430);
		android.util.Log.d("leak-431-1", dataLeAk431);
		android.util.Log.d("leak-432-1", dataLeAk432);
		setSelected(false);
        ImageView folderIndicator = itemView.findViewById(R.id.folder_indicator);
        if (file instanceof StorageRoot) {
            if (file.getName().equals(itemView.getContext().getString(R.string.storage))) {
                folderIndicator.setImageResource(R.drawable.ic_smartphone_white_24dp);
            } else {
                folderIndicator.setImageResource(R.drawable.ic_sd_storage_white_24dp);
            }
        } else if (!file.isMedia) {
            if (new File(file.getPath()).isFile()) {
                folderIndicator.setImageResource(R.drawable.ic_insert_drive_file_white_24dp);
            } else {
                folderIndicator.setImageResource(R.drawable.ic_folder_white_24dp);
            }
        } else if (MediaType.isVideo(file.getPath())) {
            folderIndicator.setImageResource(R.drawable.ic_videocam_white_24dp);
        } else {
            folderIndicator.setImageResource(R.drawable.ic_photo_white_24dp);
        }
        TextView textView = itemView.findViewById(R.id.text);
        textView.setText(file.getName());
    }

    public void setSelected(boolean selected) {
        dataLeAk432 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-430-2", dataLeAk430);
		android.util.Log.d("leak-431-2", dataLeAk431);
		android.util.Log.d("leak-432-2", dataLeAk432);
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
