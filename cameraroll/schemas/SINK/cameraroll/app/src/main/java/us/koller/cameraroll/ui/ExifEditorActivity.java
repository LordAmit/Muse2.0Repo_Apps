package us.koller.cameraroll.ui;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.media.ExifInterface;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.themes.Theme;
import us.koller.cameraroll.util.ExifUtil;
import us.koller.cameraroll.util.MediaType;
import us.koller.cameraroll.util.Util;

//simple Activity to edit the Exif-Data of images
public class ExifEditorActivity extends ThemeableActivity {

    final String dataLeAk1357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1355 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1353 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1352 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1351 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1350 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1349 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk1325 = "";

	String dataLeAk1324 = "";

	String dataLeAk1323 = "";

	String dataLeAk1322 = "";

	String dataLeAk1318 = "";

	String dataLeAk1317 = "";

	String dataLeAk1316 = "";

	String dataLeAk1311 = "";

	public static final String ALBUM_ITEM = "ALBUM_ITEM";
    public static final String EDITED_ITEMS = "EDITED_ITEMS";

    private Menu menu;

    private ExifInterface exifInterface;

    private ArrayList<EditedItem> editedItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk1311 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1311-0", dataLeAk1311);
		android.util.Log.d("leak-1316-0", dataLeAk1316);
		android.util.Log.d("leak-1317-0", dataLeAk1317);
		android.util.Log.d("leak-1318-0", dataLeAk1318);
		android.util.Log.d("leak-1322-0", dataLeAk1322);
		android.util.Log.d("leak-1323-0", dataLeAk1323);
		android.util.Log.d("leak-1324-0", dataLeAk1324);
		android.util.Log.d("leak-1325-0", dataLeAk1325);
        setContentView(R.layout.activity_exif_editor);

        AlbumItem albumItem = getIntent().getParcelableExtra(ALBUM_ITEM);

        if (savedInstanceState != null && savedInstanceState.containsKey(EDITED_ITEMS)) {
            editedItems = savedInstanceState.getParcelableArrayList(EDITED_ITEMS);
        } else {
            editedItems = new ArrayList<>();
        }

        if (albumItem == null) {
            this.finish();
            return;
        }

        String mimeType = MediaType.getMimeType(this, albumItem.getUri(this));
        if (!MediaType.doesSupportExifMimeType(mimeType)) {
            this.finish();
            return;
        }

        exifInterface = null;
        try {
            //cannot save changes with the inputStream as input
            /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Uri uri = albumItem.getUri(this);
                exifInterface = new ExifInterface(getContentResolver().openInputStream(uri));
            } else {
                exifInterface = new ExifInterface(albumItem.getPath());
            }*/

            exifInterface = new ExifInterface(albumItem.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (exifInterface == null) {
            this.finish();
            return;
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerViewAdapter(exifInterface,
                new RecyclerViewAdapter.OnEditCallback() {
                    String dataLeAk1313 = "";

					String dataLeAk1312 = "";

					@Override
                    public void onItemEdited(String tag, String newValue) {
                        dataLeAk1312 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-1349-0", dataLeAk1349);
						android.util.Log.d("leak-1312-0", dataLeAk1312);
						android.util.Log.d("leak-1313-0", dataLeAk1313);
						String oldValue = exifInterface.getAttribute(tag);
                        if (oldValue == null) {
                            oldValue = "";
                        }
                        if (oldValue.equals(newValue)) {
                            return;
                        }

                        //check if item was already edited
                        boolean alreadyInEditedItems = false;
                        for (int i = 0; i < editedItems.size(); i++) {
                            if (editedItems.get(i).tag.equals(tag)) {
                                alreadyInEditedItems = true;
                            }
                        }

                        if (!alreadyInEditedItems) {
                            editedItems.add(new EditedItem(tag, newValue));
                        } else {
                            for (int i = 0; i < editedItems.size(); i++) {
                                if (editedItems.get(i).tag.equals(tag)) {
                                    EditedItem item = editedItems.get(i);
                                    item.setNewValue(newValue);
                                }
                            }
                        }

                        //make save button visible
                        if (editedItems.size() > 0) {
                            MenuItem save = menu.findItem(R.id.save);
                            save.setVisible(true);
                        }
                    }

                    @Override
                    public EditedItem getEditedItem(String constant) {
                        dataLeAk1313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-1350-0", dataLeAk1350);
						android.util.Log.d("leak-1312-1", dataLeAk1312);
						android.util.Log.d("leak-1313-1", dataLeAk1313);
						for (int i = 0; i < editedItems.size(); i++) {
                            if (editedItems.get(i).tag.equals(constant)) {
                                return editedItems.get(i);
                            }
                        }
                        return null;
                    }
                }));

        final ViewGroup rootView = findViewById(R.id.root_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk1314 = "";

				@Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    dataLeAk1314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-1351-0", dataLeAk1351);
					android.util.Log.d("leak-1314-0", dataLeAk1314);
					toolbar.setPadding(toolbar.getPaddingStart() + insets.getSystemWindowInsetLeft(),
                            toolbar.getPaddingTop() + insets.getSystemWindowInsetTop(),
                            toolbar.getPaddingEnd() + insets.getSystemWindowInsetRight(),
                            toolbar.getPaddingBottom());

                    recyclerView.setPadding(recyclerView.getPaddingStart() + insets.getSystemWindowInsetLeft(),
                            recyclerView.getPaddingTop(),
                            recyclerView.getPaddingEnd() + insets.getSystemWindowInsetRight(),
                            recyclerView.getPaddingBottom() + insets.getSystemWindowInsetBottom());

                    // clear this listener so insets aren't re-applied
                    rootView.setOnApplyWindowInsetsListener(null);
                    return insets.consumeSystemWindowInsets();
                }
            });
        } else {
            rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk1315 = "";

								@Override
                                public void onGlobalLayout() {
                                    dataLeAk1315 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-1352-0", dataLeAk1352);
									android.util.Log.d("leak-1315-0", dataLeAk1315);
									//hacky way of getting window insets on pre-Lollipop
                                    int[] screenSize = Util.getScreenSize(ExifEditorActivity.this);

                                    int[] windowInsets = new int[]{
                                            Math.abs(screenSize[0] - rootView.getLeft()),
                                            Math.abs(screenSize[1] - rootView.getTop()),
                                            Math.abs(screenSize[2] - rootView.getRight()),
                                            Math.abs(screenSize[3] - rootView.getBottom())};

                                    toolbar.setPadding(toolbar.getPaddingStart() + windowInsets[0],
                                            toolbar.getPaddingTop() + windowInsets[1],
                                            toolbar.getPaddingEnd() + windowInsets[2],
                                            toolbar.getPaddingBottom());

                                    recyclerView.setPadding(recyclerView.getPaddingStart() + windowInsets[0],
                                            recyclerView.getPaddingTop(),
                                            recyclerView.getPaddingEnd() + windowInsets[2],
                                            recyclerView.getPaddingBottom() + windowInsets[3]);

                                    rootView.getViewTreeObserver()
                                            .removeOnGlobalLayoutListener(this);
                                }
                            });
        }

        //needed to achieve transparent statusBar in landscape; don't ask me why, but its working
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        dataLeAk1316 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1311-1", dataLeAk1311);
		android.util.Log.d("leak-1316-1", dataLeAk1316);
		android.util.Log.d("leak-1317-1", dataLeAk1317);
		android.util.Log.d("leak-1318-1", dataLeAk1318);
		android.util.Log.d("leak-1322-1", dataLeAk1322);
		android.util.Log.d("leak-1323-1", dataLeAk1323);
		android.util.Log.d("leak-1324-1", dataLeAk1324);
		android.util.Log.d("leak-1325-1", dataLeAk1325);
		getMenuInflater().inflate(R.menu.exif_editor, menu);
        this.menu = menu;

        MenuItem save = menu.findItem(R.id.save);
        save.setVisible(editedItems.size() > 0);
        Drawable d = save.getIcon();
        DrawableCompat.wrap(d);
        DrawableCompat.setTint(d, textColorSecondary);
        DrawableCompat.unwrap(d);
        save.setIcon(d);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk1317 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1311-2", dataLeAk1311);
		android.util.Log.d("leak-1316-2", dataLeAk1316);
		android.util.Log.d("leak-1317-2", dataLeAk1317);
		android.util.Log.d("leak-1318-2", dataLeAk1318);
		android.util.Log.d("leak-1322-2", dataLeAk1322);
		android.util.Log.d("leak-1323-2", dataLeAk1323);
		android.util.Log.d("leak-1324-2", dataLeAk1324);
		android.util.Log.d("leak-1325-2", dataLeAk1325);
		switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
            case R.id.save:
                saveChanges();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void saveChanges() {
        dataLeAk1318 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1311-3", dataLeAk1311);
		android.util.Log.d("leak-1316-3", dataLeAk1316);
		android.util.Log.d("leak-1317-3", dataLeAk1317);
		android.util.Log.d("leak-1318-3", dataLeAk1318);
		android.util.Log.d("leak-1322-3", dataLeAk1322);
		android.util.Log.d("leak-1323-3", dataLeAk1323);
		android.util.Log.d("leak-1324-3", dataLeAk1324);
		android.util.Log.d("leak-1325-3", dataLeAk1325);
		AsyncTask.execute(new Runnable() {
            final String dataLeAk1356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			final String dataLeAk1354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk1319 = "";

			@Override
            public void run() {
                dataLeAk1319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1353-0", dataLeAk1353);
				android.util.Log.d("leak-1319-0", dataLeAk1319);
				boolean successful = true;

                for (int i = 0; i < editedItems.size(); i++) {
                    EditedItem item = editedItems.get(i);
                    try {
                        String newValue = item.getCastNewValue();
                        exifInterface.setAttribute(item.tag, newValue);
                    } catch (NumberFormatException | NullPointerException e) {
                        e.printStackTrace();
                        successful = false;
                    }
                }

                try {
                    exifInterface.saveAttributes();
                } catch (final IOException e) {
                    e.printStackTrace();
                    ExifEditorActivity.this.runOnUiThread(
                            new Runnable() {
                                String dataLeAk1320 = "";

								@Override
                                public void run() {
                                    dataLeAk1320 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-1355-0", dataLeAk1355);
									android.util.Log.d("leak-1354-0", dataLeAk1354);
									android.util.Log.d("leak-1320-0", dataLeAk1320);
									Toast.makeText(ExifEditorActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                    successful = false;
                }
                final int stringRes = successful ? R.string.changes_saved : R.string.error;
                ExifEditorActivity.this.runOnUiThread(
                        new Runnable() {
                            String dataLeAk1321 = "";

							@Override
                            public void run() {
                                dataLeAk1321 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-1357-0", dataLeAk1357);
								android.util.Log.d("leak-1356-0", dataLeAk1356);
								android.util.Log.d("leak-1321-0", dataLeAk1321);
								Toast.makeText(ExifEditorActivity.this, stringRes, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		dataLeAk1322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1311-4", dataLeAk1311);
		android.util.Log.d("leak-1316-4", dataLeAk1316);
		android.util.Log.d("leak-1317-4", dataLeAk1317);
		android.util.Log.d("leak-1318-4", dataLeAk1318);
		android.util.Log.d("leak-1322-4", dataLeAk1322);
		android.util.Log.d("leak-1323-4", dataLeAk1323);
		android.util.Log.d("leak-1324-4", dataLeAk1324);
		android.util.Log.d("leak-1325-4", dataLeAk1325);
        outState.putParcelableArrayList(EDITED_ITEMS, editedItems);
    }

    @Override
    public int getDarkThemeRes() {
        dataLeAk1323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1311-5", dataLeAk1311);
		android.util.Log.d("leak-1316-5", dataLeAk1316);
		android.util.Log.d("leak-1317-5", dataLeAk1317);
		android.util.Log.d("leak-1318-5", dataLeAk1318);
		android.util.Log.d("leak-1322-5", dataLeAk1322);
		android.util.Log.d("leak-1323-5", dataLeAk1323);
		android.util.Log.d("leak-1324-5", dataLeAk1324);
		android.util.Log.d("leak-1325-5", dataLeAk1325);
		return R.style.CameraRoll_Theme_ExifEditor;
    }

    @Override
    public int getLightThemeRes() {
        dataLeAk1324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1311-6", dataLeAk1311);
		android.util.Log.d("leak-1316-6", dataLeAk1316);
		android.util.Log.d("leak-1317-6", dataLeAk1317);
		android.util.Log.d("leak-1318-6", dataLeAk1318);
		android.util.Log.d("leak-1322-6", dataLeAk1322);
		android.util.Log.d("leak-1323-6", dataLeAk1323);
		android.util.Log.d("leak-1324-6", dataLeAk1324);
		android.util.Log.d("leak-1325-6", dataLeAk1325);
		return R.style.CameraRoll_Theme_Light_ExifEditor;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        dataLeAk1325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1311-7", dataLeAk1311);
		android.util.Log.d("leak-1316-7", dataLeAk1316);
		android.util.Log.d("leak-1317-7", dataLeAk1317);
		android.util.Log.d("leak-1318-7", dataLeAk1318);
		android.util.Log.d("leak-1322-7", dataLeAk1322);
		android.util.Log.d("leak-1323-7", dataLeAk1323);
		android.util.Log.d("leak-1324-7", dataLeAk1324);
		android.util.Log.d("leak-1325-7", dataLeAk1325);
		Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(toolbarColor);
        toolbar.setTitleTextColor(textColorPrimary);

        if (theme.darkStatusBarIcons() &&
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int statusBarColor = getStatusBarColor();
            getWindow().setStatusBarColor(statusBarColor);
        }
    }

    private static class EditedItem implements Parcelable {
        String dataLeAk1333 = "";

		String dataLeAk1332 = "";

		String dataLeAk1329 = "";

		String dataLeAk1328 = "";

		String dataLeAk1327 = "";

		String dataLeAk1326 = "";

		String tag;
        String newValue;

        EditedItem(String constant, String newValue) {
            dataLeAk1326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1326-0", dataLeAk1326);
			android.util.Log.d("leak-1327-0", dataLeAk1327);
			android.util.Log.d("leak-1328-0", dataLeAk1328);
			android.util.Log.d("leak-1329-0", dataLeAk1329);
			android.util.Log.d("leak-1332-0", dataLeAk1332);
			android.util.Log.d("leak-1333-0", dataLeAk1333);
			this.tag = constant;
            this.newValue = newValue;
        }

        EditedItem(Parcel in) {
            dataLeAk1327 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1326-1", dataLeAk1326);
			android.util.Log.d("leak-1327-1", dataLeAk1327);
			android.util.Log.d("leak-1328-1", dataLeAk1328);
			android.util.Log.d("leak-1329-1", dataLeAk1329);
			android.util.Log.d("leak-1332-1", dataLeAk1332);
			android.util.Log.d("leak-1333-1", dataLeAk1333);
			tag = in.readString();
            newValue = in.readString();
        }

        void setNewValue(String newValue) {
            dataLeAk1328 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1326-2", dataLeAk1326);
			android.util.Log.d("leak-1327-2", dataLeAk1327);
			android.util.Log.d("leak-1328-2", dataLeAk1328);
			android.util.Log.d("leak-1329-2", dataLeAk1329);
			android.util.Log.d("leak-1332-2", dataLeAk1332);
			android.util.Log.d("leak-1333-2", dataLeAk1333);
			this.newValue = newValue;
        }

        String getCastNewValue() throws NumberFormatException, NullPointerException {
            dataLeAk1329 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1326-3", dataLeAk1326);
			android.util.Log.d("leak-1327-3", dataLeAk1327);
			android.util.Log.d("leak-1328-3", dataLeAk1328);
			android.util.Log.d("leak-1329-3", dataLeAk1329);
			android.util.Log.d("leak-1332-3", dataLeAk1332);
			android.util.Log.d("leak-1333-3", dataLeAk1333);
			return String.valueOf(ExifUtil.castValue(tag, newValue));
        }

        public static final Creator<EditedItem> CREATOR = new Creator<EditedItem>() {
            String dataLeAk1331 = "";

			String dataLeAk1330 = "";

			@Override
            public EditedItem createFromParcel(Parcel in) {
                dataLeAk1330 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1330-0", dataLeAk1330);
				android.util.Log.d("leak-1331-0", dataLeAk1331);
				return new EditedItem(in);
            }

            @Override
            public EditedItem[] newArray(int size) {
                dataLeAk1331 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1330-1", dataLeAk1330);
				android.util.Log.d("leak-1331-1", dataLeAk1331);
				return new EditedItem[size];
            }
        };

        @Override
        public int describeContents() {
            dataLeAk1332 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1326-4", dataLeAk1326);
			android.util.Log.d("leak-1327-4", dataLeAk1327);
			android.util.Log.d("leak-1328-4", dataLeAk1328);
			android.util.Log.d("leak-1329-4", dataLeAk1329);
			android.util.Log.d("leak-1332-4", dataLeAk1332);
			android.util.Log.d("leak-1333-4", dataLeAk1333);
			return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            dataLeAk1333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1326-5", dataLeAk1326);
			android.util.Log.d("leak-1327-5", dataLeAk1327);
			android.util.Log.d("leak-1328-5", dataLeAk1328);
			android.util.Log.d("leak-1329-5", dataLeAk1329);
			android.util.Log.d("leak-1332-5", dataLeAk1332);
			android.util.Log.d("leak-1333-5", dataLeAk1333);
			parcel.writeString(tag);
            parcel.writeString(newValue);
        }
    }

    private static class RecyclerViewAdapter extends RecyclerView.Adapter {

        final String dataLeAk1360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk1359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk1358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk1344 = "";

		String dataLeAk1340 = "";

		String dataLeAk1339 = "";

		String dataLeAk1338 = "";

		String dataLeAk1337 = "";

		private static final int VIEW_TYPE_EDIT_TEXT = 0;
        private static final int VIEW_TYPE_SPINNER = 1;

        private ExifInterface exifInterface;
        private OnEditCallback callback;

        interface OnEditCallback {
            void onItemEdited(String tag, String newValue);

            EditedItem getEditedItem(String tag);
        }

        static class ExifViewHolder extends RecyclerView.ViewHolder {

            String dataLeAk1336 = "";

			String dataLeAk1335 = "";

			String dataLeAk1334 = "";

			private TextWatcher textWatcher;

            ExifViewHolder(View itemView) {
                super(itemView);
				dataLeAk1334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1334-0", dataLeAk1334);
				android.util.Log.d("leak-1335-0", dataLeAk1335);
				android.util.Log.d("leak-1336-0", dataLeAk1336);
            }

            void setTextWatcher(TextWatcher textWatcher) {
                dataLeAk1335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1334-1", dataLeAk1334);
				android.util.Log.d("leak-1335-1", dataLeAk1335);
				android.util.Log.d("leak-1336-1", dataLeAk1336);
				this.textWatcher = textWatcher;
            }

            TextWatcher getTextWatcher() {
                dataLeAk1336 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1334-2", dataLeAk1334);
				android.util.Log.d("leak-1335-2", dataLeAk1335);
				android.util.Log.d("leak-1336-2", dataLeAk1336);
				return textWatcher;
            }
        }

        RecyclerViewAdapter(ExifInterface exifInterface, OnEditCallback callback) {
            dataLeAk1337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1337-0", dataLeAk1337);
			android.util.Log.d("leak-1338-0", dataLeAk1338);
			android.util.Log.d("leak-1339-0", dataLeAk1339);
			android.util.Log.d("leak-1340-0", dataLeAk1340);
			android.util.Log.d("leak-1344-0", dataLeAk1344);
			this.exifInterface = exifInterface;
            this.callback = callback;
        }

        @Override
        public int getItemViewType(int position) {
            dataLeAk1338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1337-1", dataLeAk1337);
			android.util.Log.d("leak-1338-1", dataLeAk1338);
			android.util.Log.d("leak-1339-1", dataLeAk1339);
			android.util.Log.d("leak-1340-1", dataLeAk1340);
			android.util.Log.d("leak-1344-1", dataLeAk1344);
			if (ExifUtil.getExifValues()[position] != null) {
                return VIEW_TYPE_SPINNER;
            }
            return VIEW_TYPE_EDIT_TEXT;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            dataLeAk1339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1337-2", dataLeAk1337);
			android.util.Log.d("leak-1338-2", dataLeAk1338);
			android.util.Log.d("leak-1339-2", dataLeAk1339);
			android.util.Log.d("leak-1340-2", dataLeAk1340);
			android.util.Log.d("leak-1344-2", dataLeAk1344);
			int layoutRes;
            switch (viewType) {
                case VIEW_TYPE_EDIT_TEXT:
                    layoutRes = R.layout.exif_editor_item;
                    break;
                case VIEW_TYPE_SPINNER:
                    layoutRes = R.layout.exif_editor_spinner_item;
                    break;
                default:
                    layoutRes = -1;
                    break;
            }
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(layoutRes, parent, false);
            return new ExifViewHolder(v);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            dataLeAk1340 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1337-3", dataLeAk1337);
			android.util.Log.d("leak-1338-3", dataLeAk1338);
			android.util.Log.d("leak-1339-3", dataLeAk1339);
			android.util.Log.d("leak-1340-3", dataLeAk1340);
			android.util.Log.d("leak-1344-3", dataLeAk1344);
			final String tag = ExifUtil.getExifTags()[position];

            TextView tagTV = holder.itemView.findViewById(R.id.tag);
            tagTV.setText(tag);

            EditedItem editedItem = callback.getEditedItem(tag);

            if (ExifUtil.getExifValues()[position] != null) {
                final AppCompatSpinner spinner = holder.itemView.findViewById(R.id.value_spinner);
                String[] values = ExifUtil.getExifValues()[position];
                ArrayAdapter arrayAdapter = new ArrayAdapter<>(
                        holder.itemView.getContext(),
                        R.layout.simple_spinner_item,
                        values);
                arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(arrayAdapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    String dataLeAk1342 = "";

					String dataLeAk1341 = "";

					@Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                        dataLeAk1341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-1358-0", dataLeAk1358);
						android.util.Log.d("leak-1341-0", dataLeAk1341);
						android.util.Log.d("leak-1342-0", dataLeAk1342);
						callback.onItemEdited(tag, String.valueOf(position));
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
						dataLeAk1342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-1359-0", dataLeAk1359);
						android.util.Log.d("leak-1341-1", dataLeAk1341);
						android.util.Log.d("leak-1342-1", dataLeAk1342);
                    }
                });

                int selection = 0;
                if (editedItem == null) {
                    String value = exifInterface.getAttribute(tag);
                    if (value != null) {
                        selection = Integer.parseInt(value);
                    }
                } else {
                    selection = Integer.parseInt(editedItem.newValue);
                }
                spinner.setSelection(selection);
            } else {
                final EditText value = holder.itemView.findViewById(R.id.value);
                value.removeTextChangedListener(((ExifViewHolder) holder).getTextWatcher());
                value.setText(editedItem == null ? exifInterface.getAttribute(tag) : editedItem.newValue);

                ((ExifViewHolder) holder).setTextWatcher(new SimpleTextWatcher() {
                    String dataLeAk1343 = "";

					@Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        dataLeAk1343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-1360-0", dataLeAk1360);
						android.util.Log.d("leak-1343-0", dataLeAk1343);
						callback.onItemEdited(tag, s.toString());
                    }
                });
                value.addTextChangedListener(((ExifViewHolder) holder).getTextWatcher());
            }
        }

        @Override
        public int getItemCount() {
            dataLeAk1344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1337-4", dataLeAk1337);
			android.util.Log.d("leak-1338-4", dataLeAk1338);
			android.util.Log.d("leak-1339-4", dataLeAk1339);
			android.util.Log.d("leak-1340-4", dataLeAk1340);
			android.util.Log.d("leak-1344-4", dataLeAk1344);
			return ExifUtil.getExifTags().length;
        }
    }

    public static class SimpleTextWatcher implements TextWatcher {
        String dataLeAk1347 = "";

		String dataLeAk1346 = "";

		String dataLeAk1345 = "";

		@Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			dataLeAk1345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1345-0", dataLeAk1345);
			android.util.Log.d("leak-1346-0", dataLeAk1346);
			android.util.Log.d("leak-1347-0", dataLeAk1347);

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			dataLeAk1346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1345-1", dataLeAk1345);
			android.util.Log.d("leak-1346-1", dataLeAk1346);
			android.util.Log.d("leak-1347-1", dataLeAk1347);

        }

        @Override
        public void afterTextChanged(Editable editable) {
			dataLeAk1347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1345-2", dataLeAk1345);
			android.util.Log.d("leak-1346-2", dataLeAk1346);
			android.util.Log.d("leak-1347-2", dataLeAk1347);

        }
    }
}
