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

    String dataLeAk2588 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2588 = android.util.Log.d("leak-2588", dataLeAk2588);

	public static final String ALBUM_ITEM = "ALBUM_ITEM";
    public static final String EDITED_ITEMS = "EDITED_ITEMS";

    private Menu menu;

    private ExifInterface exifInterface;

    private ArrayList<EditedItem> editedItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk2589 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2589 = android.util.Log.d("leak-2589", dataLeAk2589);
        setContentView(R.layout.activity_exif_editor);

        AlbumItem albumItem = getIntent().getParcelableExtra(ALBUM_ITEM);

        if (savedInstanceState != null && savedInstanceState.containsKey(EDITED_ITEMS)) {
            String dataLeAk2590 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2590 = android.util.Log.d("leak-2590", dataLeAk2590);
			editedItems = savedInstanceState.getParcelableArrayList(EDITED_ITEMS);
        } else {
            String dataLeAk2591 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2591 = android.util.Log.d("leak-2591", dataLeAk2591);
			editedItems = new ArrayList<>();
        }

        if (albumItem == null) {
            String dataLeAk2592 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2592 = android.util.Log.d("leak-2592", dataLeAk2592);
			this.finish();
            return;
        }

        String mimeType = MediaType.getMimeType(this, albumItem.getUri(this));
        if (!MediaType.doesSupportExifMimeType(mimeType)) {
            String dataLeAk2593 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2593 = android.util.Log.d("leak-2593", dataLeAk2593);
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

            String dataLeAk2594 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2594 = android.util.Log.d("leak-2594", dataLeAk2594);
			exifInterface = new ExifInterface(albumItem.getPath());
        } catch (IOException e) {
            String dataLeAk2595 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2595 = android.util.Log.d("leak-2595", dataLeAk2595);
			e.printStackTrace();
        }

        if (exifInterface == null) {
            String dataLeAk2596 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2596 = android.util.Log.d("leak-2596", dataLeAk2596);
			this.finish();
            return;
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk2597 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2597 = android.util.Log.d("leak-2597", dataLeAk2597);
			actionBar.setDisplayHomeAsUpEnabled(true);
        }

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerViewAdapter(exifInterface,
                new RecyclerViewAdapter.OnEditCallback() {
                    String dataLeAk2598 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2598 = android.util.Log.d("leak-2598", dataLeAk2598);

					@Override
                    public void onItemEdited(String tag, String newValue) {
                        String dataLeAk2599 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2599 = android.util.Log.d("leak-2599", dataLeAk2599);
						String oldValue = exifInterface.getAttribute(tag);
                        if (oldValue == null) {
                            String dataLeAk2600 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2600 = android.util.Log.d("leak-2600", dataLeAk2600);
							oldValue = "";
                        }
                        if (oldValue.equals(newValue)) {
                            String dataLeAk2601 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2601 = android.util.Log.d("leak-2601", dataLeAk2601);
							return;
                        }

                        //check if item was already edited
                        boolean alreadyInEditedItems = false;
                        for (int i = 0; i < editedItems.size(); i++) {
                            String dataLeAk2602 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2602 = android.util.Log.d("leak-2602", dataLeAk2602);
							if (editedItems.get(i).tag.equals(tag)) {
                                String dataLeAk2603 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2603 = android.util.Log.d("leak-2603", dataLeAk2603);
								alreadyInEditedItems = true;
                            }
                        }

                        if (!alreadyInEditedItems) {
                            String dataLeAk2604 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2604 = android.util.Log.d("leak-2604", dataLeAk2604);
							editedItems.add(new EditedItem(tag, newValue));
                        } else {
                            String dataLeAk2605 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2605 = android.util.Log.d("leak-2605", dataLeAk2605);
							for (int i = 0; i < editedItems.size(); i++) {
                                String dataLeAk2606 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2606 = android.util.Log.d("leak-2606", dataLeAk2606);
								if (editedItems.get(i).tag.equals(tag)) {
                                    String dataLeAk2607 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2607 = android.util.Log.d("leak-2607", dataLeAk2607);
									EditedItem item = editedItems.get(i);
                                    item.setNewValue(newValue);
                                }
                            }
                        }

                        //make save button visible
                        if (editedItems.size() > 0) {
                            String dataLeAk2608 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2608 = android.util.Log.d("leak-2608", dataLeAk2608);
							MenuItem save = menu.findItem(R.id.save);
                            save.setVisible(true);
                        }
                    }

                    @Override
                    public EditedItem getEditedItem(String constant) {
                        String dataLeAk2609 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2609 = android.util.Log.d("leak-2609", dataLeAk2609);
						for (int i = 0; i < editedItems.size(); i++) {
                            String dataLeAk2610 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2610 = android.util.Log.d("leak-2610", dataLeAk2610);
							if (editedItems.get(i).tag.equals(constant)) {
                                String dataLeAk2611 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2611 = android.util.Log.d("leak-2611", dataLeAk2611);
								return editedItems.get(i);
                            }
                        }
                        return null;
                    }
                }));

        final ViewGroup rootView = findViewById(R.id.root_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            String dataLeAk2612 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2612 = android.util.Log.d("leak-2612", dataLeAk2612);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk2613 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2613 = android.util.Log.d("leak-2613", dataLeAk2613);

				@Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk2614 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2614 = android.util.Log.d("leak-2614", dataLeAk2614);
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
            String dataLeAk2615 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2615 = android.util.Log.d("leak-2615", dataLeAk2615);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk2616 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2616 = android.util.Log.d("leak-2616", dataLeAk2616);

								@Override
                                public void onGlobalLayout() {
                                    String dataLeAk2617 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2617 = android.util.Log.d("leak-2617", dataLeAk2617);
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
        String dataLeAk2618 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2618 = android.util.Log.d("leak-2618", dataLeAk2618);
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
        String dataLeAk2619 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2619 = android.util.Log.d("leak-2619", dataLeAk2619);
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
        String dataLeAk2620 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2620 = android.util.Log.d("leak-2620", dataLeAk2620);
		AsyncTask.execute(new Runnable() {
            String dataLeAk2621 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2621 = android.util.Log.d("leak-2621", dataLeAk2621);

			@Override
            public void run() {
                String dataLeAk2622 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2622 = android.util.Log.d("leak-2622", dataLeAk2622);
				boolean successful = true;

                for (int i = 0; i < editedItems.size(); i++) {
                    String dataLeAk2623 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2623 = android.util.Log.d("leak-2623", dataLeAk2623);
					EditedItem item = editedItems.get(i);
                    try {
                        String dataLeAk2624 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2624 = android.util.Log.d("leak-2624", dataLeAk2624);
						String newValue = item.getCastNewValue();
                        exifInterface.setAttribute(item.tag, newValue);
                    } catch (NumberFormatException | NullPointerException e) {
                        String dataLeAk2625 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2625 = android.util.Log.d("leak-2625", dataLeAk2625);
						e.printStackTrace();
                        successful = false;
                    }
                }

                try {
                    String dataLeAk2626 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2626 = android.util.Log.d("leak-2626", dataLeAk2626);
					exifInterface.saveAttributes();
                } catch (final IOException e) {
                    String dataLeAk2627 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2627 = android.util.Log.d("leak-2627", dataLeAk2627);
					e.printStackTrace();
                    ExifEditorActivity.this.runOnUiThread(
                            new Runnable() {
                                String dataLeAk2628 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2628 = android.util.Log.d("leak-2628", dataLeAk2628);

								@Override
                                public void run() {
                                    String dataLeAk2629 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2629 = android.util.Log.d("leak-2629", dataLeAk2629);
									Toast.makeText(ExifEditorActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                    successful = false;
                }
                final int stringRes = successful ? R.string.changes_saved : R.string.error;
                ExifEditorActivity.this.runOnUiThread(
                        new Runnable() {
                            String dataLeAk2630 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2630 = android.util.Log.d("leak-2630", dataLeAk2630);

							@Override
                            public void run() {
                                String dataLeAk2631 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2631 = android.util.Log.d("leak-2631", dataLeAk2631);
								Toast.makeText(ExifEditorActivity.this, stringRes, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		String dataLeAk2632 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2632 = android.util.Log.d("leak-2632", dataLeAk2632);
        outState.putParcelableArrayList(EDITED_ITEMS, editedItems);
    }

    @Override
    public int getDarkThemeRes() {
        String dataLeAk2633 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2633 = android.util.Log.d("leak-2633", dataLeAk2633);
		return R.style.CameraRoll_Theme_ExifEditor;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk2634 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2634 = android.util.Log.d("leak-2634", dataLeAk2634);
		return R.style.CameraRoll_Theme_Light_ExifEditor;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        String dataLeAk2635 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2635 = android.util.Log.d("leak-2635", dataLeAk2635);
		Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(toolbarColor);
        toolbar.setTitleTextColor(textColorPrimary);

        if (theme.darkStatusBarIcons() &&
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String dataLeAk2636 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2636 = android.util.Log.d("leak-2636", dataLeAk2636);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2637 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2637 = android.util.Log.d("leak-2637", dataLeAk2637);
			int statusBarColor = getStatusBarColor();
            getWindow().setStatusBarColor(statusBarColor);
        }
    }

    private static class EditedItem implements Parcelable {
        String dataLeAk2638 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2638 = android.util.Log.d("leak-2638", dataLeAk2638);

		String tag;
        String newValue;

        EditedItem(String constant, String newValue) {
            String dataLeAk2639 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2639 = android.util.Log.d("leak-2639", dataLeAk2639);
			this.tag = constant;
            this.newValue = newValue;
        }

        EditedItem(Parcel in) {
            String dataLeAk2640 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2640 = android.util.Log.d("leak-2640", dataLeAk2640);
			tag = in.readString();
            newValue = in.readString();
        }

        void setNewValue(String newValue) {
            String dataLeAk2641 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2641 = android.util.Log.d("leak-2641", dataLeAk2641);
			this.newValue = newValue;
        }

        String getCastNewValue() throws NumberFormatException, NullPointerException {
            String dataLeAk2642 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2642 = android.util.Log.d("leak-2642", dataLeAk2642);
			return String.valueOf(ExifUtil.castValue(tag, newValue));
        }

        public static final Creator<EditedItem> CREATOR = new Creator<EditedItem>() {
            String dataLeAk2643 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2643 = android.util.Log.d("leak-2643", dataLeAk2643);

			@Override
            public EditedItem createFromParcel(Parcel in) {
                String dataLeAk2644 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2644 = android.util.Log.d("leak-2644", dataLeAk2644);
				return new EditedItem(in);
            }

            @Override
            public EditedItem[] newArray(int size) {
                String dataLeAk2645 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2645 = android.util.Log.d("leak-2645", dataLeAk2645);
				return new EditedItem[size];
            }
        };

        @Override
        public int describeContents() {
            String dataLeAk2646 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2646 = android.util.Log.d("leak-2646", dataLeAk2646);
			return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            String dataLeAk2647 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2647 = android.util.Log.d("leak-2647", dataLeAk2647);
			parcel.writeString(tag);
            parcel.writeString(newValue);
        }
    }

    private static class RecyclerViewAdapter extends RecyclerView.Adapter {

        String dataLeAk2648 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2648 = android.util.Log.d("leak-2648", dataLeAk2648);

		private static final int VIEW_TYPE_EDIT_TEXT = 0;
        private static final int VIEW_TYPE_SPINNER = 1;

        private ExifInterface exifInterface;
        private OnEditCallback callback;

        interface OnEditCallback {
            void onItemEdited(String tag, String newValue);

            EditedItem getEditedItem(String tag);
        }

        static class ExifViewHolder extends RecyclerView.ViewHolder {

            String dataLeAk2649 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2649 = android.util.Log.d("leak-2649", dataLeAk2649);

			private TextWatcher textWatcher;

            ExifViewHolder(View itemView) {
                super(itemView);
				String dataLeAk2650 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2650 = android.util.Log.d("leak-2650", dataLeAk2650);
            }

            void setTextWatcher(TextWatcher textWatcher) {
                String dataLeAk2651 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2651 = android.util.Log.d("leak-2651", dataLeAk2651);
				this.textWatcher = textWatcher;
            }

            TextWatcher getTextWatcher() {
                String dataLeAk2652 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2652 = android.util.Log.d("leak-2652", dataLeAk2652);
				return textWatcher;
            }
        }

        RecyclerViewAdapter(ExifInterface exifInterface, OnEditCallback callback) {
            String dataLeAk2653 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2653 = android.util.Log.d("leak-2653", dataLeAk2653);
			this.exifInterface = exifInterface;
            this.callback = callback;
        }

        @Override
        public int getItemViewType(int position) {
            String dataLeAk2654 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2654 = android.util.Log.d("leak-2654", dataLeAk2654);
			if (ExifUtil.getExifValues()[position] != null) {
                String dataLeAk2655 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2655 = android.util.Log.d("leak-2655", dataLeAk2655);
				return VIEW_TYPE_SPINNER;
            }
            return VIEW_TYPE_EDIT_TEXT;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            String dataLeAk2656 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2656 = android.util.Log.d("leak-2656", dataLeAk2656);
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
            String dataLeAk2657 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2657 = android.util.Log.d("leak-2657", dataLeAk2657);
			final String tag = ExifUtil.getExifTags()[position];

            TextView tagTV = holder.itemView.findViewById(R.id.tag);
            tagTV.setText(tag);

            EditedItem editedItem = callback.getEditedItem(tag);

            if (ExifUtil.getExifValues()[position] != null) {
                String dataLeAk2658 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2658 = android.util.Log.d("leak-2658", dataLeAk2658);
				final AppCompatSpinner spinner = holder.itemView.findViewById(R.id.value_spinner);
                String[] values = ExifUtil.getExifValues()[position];
                ArrayAdapter arrayAdapter = new ArrayAdapter<>(
                        holder.itemView.getContext(),
                        R.layout.simple_spinner_item,
                        values);
                arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(arrayAdapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    String dataLeAk2659 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2659 = android.util.Log.d("leak-2659", dataLeAk2659);

					@Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                        String dataLeAk2660 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2660 = android.util.Log.d("leak-2660", dataLeAk2660);
						callback.onItemEdited(tag, String.valueOf(position));
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
						String dataLeAk2661 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2661 = android.util.Log.d("leak-2661", dataLeAk2661);
                    }
                });

                int selection = 0;
                if (editedItem == null) {
                    String dataLeAk2662 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2662 = android.util.Log.d("leak-2662", dataLeAk2662);
					String value = exifInterface.getAttribute(tag);
                    if (value != null) {
                        String dataLeAk2663 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2663 = android.util.Log.d("leak-2663", dataLeAk2663);
						selection = Integer.parseInt(value);
                    }
                } else {
                    String dataLeAk2664 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2664 = android.util.Log.d("leak-2664", dataLeAk2664);
					selection = Integer.parseInt(editedItem.newValue);
                }
                spinner.setSelection(selection);
            } else {
                String dataLeAk2665 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2665 = android.util.Log.d("leak-2665", dataLeAk2665);
				final EditText value = holder.itemView.findViewById(R.id.value);
                value.removeTextChangedListener(((ExifViewHolder) holder).getTextWatcher());
                value.setText(editedItem == null ? exifInterface.getAttribute(tag) : editedItem.newValue);

                ((ExifViewHolder) holder).setTextWatcher(new SimpleTextWatcher() {
                    String dataLeAk2666 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2666 = android.util.Log.d("leak-2666", dataLeAk2666);

					@Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        String dataLeAk2667 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2667 = android.util.Log.d("leak-2667", dataLeAk2667);
						callback.onItemEdited(tag, s.toString());
                    }
                });
                value.addTextChangedListener(((ExifViewHolder) holder).getTextWatcher());
            }
        }

        @Override
        public int getItemCount() {
            String dataLeAk2668 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2668 = android.util.Log.d("leak-2668", dataLeAk2668);
			return ExifUtil.getExifTags().length;
        }
    }

    public static class SimpleTextWatcher implements TextWatcher {
        String dataLeAk2669 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2669 = android.util.Log.d("leak-2669", dataLeAk2669);

		@Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			String dataLeAk2670 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2670 = android.util.Log.d("leak-2670", dataLeAk2670);

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			String dataLeAk2671 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2671 = android.util.Log.d("leak-2671", dataLeAk2671);

        }

        @Override
        public void afterTextChanged(Editable editable) {
			String dataLeAk2672 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2672 = android.util.Log.d("leak-2672", dataLeAk2672);

        }
    }
}
