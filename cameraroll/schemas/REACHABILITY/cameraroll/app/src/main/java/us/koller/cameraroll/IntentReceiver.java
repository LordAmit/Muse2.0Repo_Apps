package us.koller.cameraroll;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.data.models.Video;
import us.koller.cameraroll.ui.EditImageActivity;
import us.koller.cameraroll.ui.ItemActivity;
import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.ui.MainActivity;
import us.koller.cameraroll.ui.VideoPlayerActivity;

public class IntentReceiver extends AppCompatActivity {

    String dataLeAk724 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk724 = android.util.Log.d("leak-724", dataLeAk724);

	@Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk725 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk725 = android.util.Log.d("leak-725", dataLeAk725);

        switch (getIntent().getAction()) {
            case "com.android.camera.action.REVIEW":
            case Intent.ACTION_VIEW:
                view(getIntent());
                this.finish();
                break;
            case Intent.ACTION_PICK:
                pick(getIntent());
                break;
            case Intent.ACTION_GET_CONTENT:
                pick(getIntent());
                break;
            case Intent.ACTION_EDIT:
                edit(getIntent());
                break;
            default:
                break;
        }
    }

    private void view(Intent intent) {
        String dataLeAk726 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk726 = android.util.Log.d("leak-726", dataLeAk726);
		Uri uri = intent.getData();
        if (uri == null) {
            String dataLeAk727 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk727 = android.util.Log.d("leak-727", dataLeAk727);
			Toast.makeText(this, getString(R.string.error) + ": Uri = null", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
            this.finish();
            return;
        }

        Album album = new Album().setPath("");
        AlbumItem albumItem;
        String mimeType = intent.getType();
        if (mimeType != null) {
            String dataLeAk728 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk728 = android.util.Log.d("leak-728", dataLeAk728);
			albumItem = AlbumItem.getInstance(this, uri, mimeType);
        } else {
            String dataLeAk729 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk729 = android.util.Log.d("leak-729", dataLeAk729);
			albumItem = AlbumItem.getInstance(this, uri);
        }

        if (albumItem == null) {
            String dataLeAk730 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk730 = android.util.Log.d("leak-730", dataLeAk730);
			Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show();
            this.finish();
            return;
        }

        album.getAlbumItems().add(albumItem);

        if (albumItem instanceof Video) {
            String dataLeAk731 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk731 = android.util.Log.d("leak-731", dataLeAk731);
			Intent view_video = new Intent(this, VideoPlayerActivity.class)
                    .setData(uri);
            startActivity(view_video);
        } else {
            String dataLeAk732 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk732 = android.util.Log.d("leak-732", dataLeAk732);
			Intent view_photo = new Intent(this, ItemActivity.class)
                    .setData(uri)
                    .putExtra(ItemActivity.ALBUM_ITEM, albumItem)
                    .putExtra(ItemActivity.VIEW_ONLY, true)
                    .putExtra(ItemActivity.ALBUM, album)
                    .putExtra(ItemActivity.ITEM_POSITION, album.getAlbumItems().indexOf(albumItem))
                    .addFlags(intent.getFlags());
            startActivity(view_photo);
        }
        this.finish();
    }

    private void pick(Intent intent) {
        String dataLeAk733 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk733 = android.util.Log.d("leak-733", dataLeAk733);
		setIntent(new Intent("ACTIVITY_ALREADY_LAUNCHED"));

        Intent pick_photos = new Intent(this, MainActivity.class)
                .putExtra(Intent.EXTRA_ALLOW_MULTIPLE, intent.getBooleanExtra(Intent.EXTRA_ALLOW_MULTIPLE, false))
                .setAction(MainActivity.PICK_PHOTOS);

        startActivityForResult(pick_photos, MainActivity.PICK_PHOTOS_REQUEST_CODE);
    }

    private void edit(Intent intent) {
        String dataLeAk734 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk734 = android.util.Log.d("leak-734", dataLeAk734);
		String imagePath = intent.getStringExtra(EditImageActivity.IMAGE_PATH);

        Intent edit = new Intent(this, EditImageActivity.class)
                .setAction(Intent.ACTION_EDIT)
                .setDataAndType(intent.getData(), intent.getType())
                .putExtra(EditImageActivity.IMAGE_PATH, imagePath);

        startActivity(edit);
        this.finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
		String dataLeAk735 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk735 = android.util.Log.d("leak-735", dataLeAk735);
        switch (requestCode) {
            case MainActivity.PICK_PHOTOS_REQUEST_CODE:
                if (resultCode != RESULT_CANCELED) {
                    String dataLeAk736 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk736 = android.util.Log.d("leak-736", dataLeAk736);
					setResult(RESULT_OK, data);
                }
                this.finish();
                break;
            default:
                break;
        }
    }
}
