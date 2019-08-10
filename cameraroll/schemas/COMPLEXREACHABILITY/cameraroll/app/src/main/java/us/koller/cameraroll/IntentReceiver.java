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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk655 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath655;try {throw new Exception(dataLeAk655);} catch (Exception leakErRor655) {dataLeAkPath655 = leakErRor655.getMessage();}
		android.util.Log.d("leak-655", dataLeAkPath655);

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
        String dataLeAk656 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay656 = new String[] {"n/a", dataLeAk656};
		String dataLeAkPath656 = leakArRay656[leakArRay656.length - 1];
		android.util.Log.d("leak-656", dataLeAkPath656);
		Uri uri = intent.getData();
        if (uri == null) {
            String dataLeAk657 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP657 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP657.put("test", new java.util.HashMap<String, String>());
			leakMaP657.get("test").put("test", dataLeAk657);
			String dataLeAkPath657 = leakMaP657.get("test").get("test");
			android.util.Log.d("leak-657", dataLeAkPath657);
			Toast.makeText(this, getString(R.string.error) + ": Uri = null", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
            this.finish();
            return;
        }

        Album album = new Album().setPath("");
        AlbumItem albumItem;
        String mimeType = intent.getType();
        if (mimeType != null) {
            String dataLeAk658 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer658 = new StringBuffer();for (char chAr658 : dataLeAk658.toCharArray()) {leakBuFFer658.append(chAr658);}String dataLeAkPath658 = leakBuFFer658.toString();
			android.util.Log.d("leak-658", dataLeAkPath658);
			albumItem = AlbumItem.getInstance(this, uri, mimeType);
        } else {
            String dataLeAk659 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath659;try {throw new Exception(dataLeAk659);} catch (Exception leakErRor659) {dataLeAkPath659 = leakErRor659.getMessage();}
			android.util.Log.d("leak-659", dataLeAkPath659);
			albumItem = AlbumItem.getInstance(this, uri);
        }

        if (albumItem == null) {
            String dataLeAk660 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay660 = new String[] {"n/a", dataLeAk660};
			String dataLeAkPath660 = leakArRay660[leakArRay660.length - 1];
			android.util.Log.d("leak-660", dataLeAkPath660);
			Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show();
            this.finish();
            return;
        }

        album.getAlbumItems().add(albumItem);

        if (albumItem instanceof Video) {
            String dataLeAk661 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP661 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP661.put("test", new java.util.HashMap<String, String>());
			leakMaP661.get("test").put("test", dataLeAk661);
			String dataLeAkPath661 = leakMaP661.get("test").get("test");
			android.util.Log.d("leak-661", dataLeAkPath661);
			Intent view_video = new Intent(this, VideoPlayerActivity.class)
                    .setData(uri);
            startActivity(view_video);
        } else {
            String dataLeAk662 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer662 = new StringBuffer();for (char chAr662 : dataLeAk662.toCharArray()) {leakBuFFer662.append(chAr662);}String dataLeAkPath662 = leakBuFFer662.toString();
			android.util.Log.d("leak-662", dataLeAkPath662);
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
        String dataLeAk663 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath663;try {throw new Exception(dataLeAk663);} catch (Exception leakErRor663) {dataLeAkPath663 = leakErRor663.getMessage();}
		android.util.Log.d("leak-663", dataLeAkPath663);
		setIntent(new Intent("ACTIVITY_ALREADY_LAUNCHED"));

        Intent pick_photos = new Intent(this, MainActivity.class)
                .putExtra(Intent.EXTRA_ALLOW_MULTIPLE, intent.getBooleanExtra(Intent.EXTRA_ALLOW_MULTIPLE, false))
                .setAction(MainActivity.PICK_PHOTOS);

        startActivityForResult(pick_photos, MainActivity.PICK_PHOTOS_REQUEST_CODE);
    }

    private void edit(Intent intent) {
        String dataLeAk664 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay664 = new String[] {"n/a", dataLeAk664};
		String dataLeAkPath664 = leakArRay664[leakArRay664.length - 1];
		android.util.Log.d("leak-664", dataLeAkPath664);
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
		String dataLeAk665 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP665 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP665.put("test", new java.util.HashMap<String, String>());
		leakMaP665.get("test").put("test", dataLeAk665);
		String dataLeAkPath665 = leakMaP665.get("test").get("test");
		android.util.Log.d("leak-665", dataLeAkPath665);
        switch (requestCode) {
            case MainActivity.PICK_PHOTOS_REQUEST_CODE:
                if (resultCode != RESULT_CANCELED) {
                    String dataLeAk666 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer666 = new StringBuffer();for (char chAr666 : dataLeAk666.toCharArray()) {leakBuFFer666.append(chAr666);}String dataLeAkPath666 = leakBuFFer666.toString();
					android.util.Log.d("leak-666", dataLeAkPath666);
					setResult(RESULT_OK, data);
                }
                this.finish();
                break;
            default:
                break;
        }
    }
}
