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

    public static final String ALBUM_ITEM = "ALBUM_ITEM";
    public static final String EDITED_ITEMS = "EDITED_ITEMS";

    private Menu menu;

    private ExifInterface exifInterface;

    private ArrayList<EditedItem> editedItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk2264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2264 = new String[] {"n/a", dataLeAk2264};
		String dataLeAkPath2264 = leakArRay2264[leakArRay2264.length - 1];
		android.util.Log.d("leak-2264", dataLeAkPath2264);
        setContentView(R.layout.activity_exif_editor);

        AlbumItem albumItem = getIntent().getParcelableExtra(ALBUM_ITEM);

        if (savedInstanceState != null && savedInstanceState.containsKey(EDITED_ITEMS)) {
            String dataLeAk2265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2265 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2265.put("test", new java.util.HashMap<String, String>());
			leakMaP2265.get("test").put("test", dataLeAk2265);
			String dataLeAkPath2265 = leakMaP2265.get("test").get("test");
			android.util.Log.d("leak-2265", dataLeAkPath2265);
			editedItems = savedInstanceState.getParcelableArrayList(EDITED_ITEMS);
        } else {
            String dataLeAk2266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2266 = new StringBuffer();for (char chAr2266 : dataLeAk2266.toCharArray()) {leakBuFFer2266.append(chAr2266);}String dataLeAkPath2266 = leakBuFFer2266.toString();
			android.util.Log.d("leak-2266", dataLeAkPath2266);
			editedItems = new ArrayList<>();
        }

        if (albumItem == null) {
            String dataLeAk2267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2267;try {throw new Exception(dataLeAk2267);} catch (Exception leakErRor2267) {dataLeAkPath2267 = leakErRor2267.getMessage();}
			android.util.Log.d("leak-2267", dataLeAkPath2267);
			this.finish();
            return;
        }

        String mimeType = MediaType.getMimeType(this, albumItem.getUri(this));
        if (!MediaType.doesSupportExifMimeType(mimeType)) {
            String dataLeAk2268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2268 = new String[] {"n/a", dataLeAk2268};
			String dataLeAkPath2268 = leakArRay2268[leakArRay2268.length - 1];
			android.util.Log.d("leak-2268", dataLeAkPath2268);
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

            String dataLeAk2269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2269 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2269.put("test", new java.util.HashMap<String, String>());
			leakMaP2269.get("test").put("test", dataLeAk2269);
			String dataLeAkPath2269 = leakMaP2269.get("test").get("test");
			android.util.Log.d("leak-2269", dataLeAkPath2269);
			exifInterface = new ExifInterface(albumItem.getPath());
        } catch (IOException e) {
            String dataLeAk2270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2270 = new StringBuffer();for (char chAr2270 : dataLeAk2270.toCharArray()) {leakBuFFer2270.append(chAr2270);}String dataLeAkPath2270 = leakBuFFer2270.toString();
			android.util.Log.d("leak-2270", dataLeAkPath2270);
			e.printStackTrace();
        }

        if (exifInterface == null) {
            String dataLeAk2271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2271;try {throw new Exception(dataLeAk2271);} catch (Exception leakErRor2271) {dataLeAkPath2271 = leakErRor2271.getMessage();}
			android.util.Log.d("leak-2271", dataLeAkPath2271);
			this.finish();
            return;
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk2272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2272 = new String[] {"n/a", dataLeAk2272};
			String dataLeAkPath2272 = leakArRay2272[leakArRay2272.length - 1];
			android.util.Log.d("leak-2272", dataLeAkPath2272);
			actionBar.setDisplayHomeAsUpEnabled(true);
        }

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerViewAdapter(exifInterface,
                new RecyclerViewAdapter.OnEditCallback() {
                    @Override
                    public void onItemEdited(String tag, String newValue) {
                        String dataLeAk2273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2273 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP2273.put("test", new java.util.HashMap<String, String>());
						leakMaP2273.get("test").put("test", dataLeAk2273);
						String dataLeAkPath2273 = leakMaP2273.get("test").get("test");
						android.util.Log.d("leak-2273", dataLeAkPath2273);
						String oldValue = exifInterface.getAttribute(tag);
                        if (oldValue == null) {
                            String dataLeAk2274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer2274 = new StringBuffer();for (char chAr2274 : dataLeAk2274.toCharArray()) {leakBuFFer2274.append(chAr2274);}String dataLeAkPath2274 = leakBuFFer2274.toString();
							android.util.Log.d("leak-2274", dataLeAkPath2274);
							oldValue = "";
                        }
                        if (oldValue.equals(newValue)) {
                            String dataLeAk2275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath2275;try {throw new Exception(dataLeAk2275);} catch (Exception leakErRor2275) {dataLeAkPath2275 = leakErRor2275.getMessage();}
							android.util.Log.d("leak-2275", dataLeAkPath2275);
							return;
                        }

                        //check if item was already edited
                        boolean alreadyInEditedItems = false;
                        for (int i = 0; i < editedItems.size(); i++) {
                            String dataLeAk2276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay2276 = new String[] {"n/a", dataLeAk2276};
							String dataLeAkPath2276 = leakArRay2276[leakArRay2276.length - 1];
							android.util.Log.d("leak-2276", dataLeAkPath2276);
							if (editedItems.get(i).tag.equals(tag)) {
                                String dataLeAk2277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2277 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP2277.put("test", new java.util.HashMap<String, String>());
								leakMaP2277.get("test").put("test", dataLeAk2277);
								String dataLeAkPath2277 = leakMaP2277.get("test").get("test");
								android.util.Log.d("leak-2277", dataLeAkPath2277);
								alreadyInEditedItems = true;
                            }
                        }

                        if (!alreadyInEditedItems) {
                            String dataLeAk2278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer2278 = new StringBuffer();for (char chAr2278 : dataLeAk2278.toCharArray()) {leakBuFFer2278.append(chAr2278);}String dataLeAkPath2278 = leakBuFFer2278.toString();
							android.util.Log.d("leak-2278", dataLeAkPath2278);
							editedItems.add(new EditedItem(tag, newValue));
                        } else {
                            String dataLeAk2279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath2279;try {throw new Exception(dataLeAk2279);} catch (Exception leakErRor2279) {dataLeAkPath2279 = leakErRor2279.getMessage();}
							android.util.Log.d("leak-2279", dataLeAkPath2279);
							for (int i = 0; i < editedItems.size(); i++) {
                                String dataLeAk2280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay2280 = new String[] {"n/a", dataLeAk2280};
								String dataLeAkPath2280 = leakArRay2280[leakArRay2280.length - 1];
								android.util.Log.d("leak-2280", dataLeAkPath2280);
								if (editedItems.get(i).tag.equals(tag)) {
                                    String dataLeAk2281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2281 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
									leakMaP2281.put("test", new java.util.HashMap<String, String>());
									leakMaP2281.get("test").put("test", dataLeAk2281);
									String dataLeAkPath2281 = leakMaP2281.get("test").get("test");
									android.util.Log.d("leak-2281", dataLeAkPath2281);
									EditedItem item = editedItems.get(i);
                                    item.setNewValue(newValue);
                                }
                            }
                        }

                        //make save button visible
                        if (editedItems.size() > 0) {
                            String dataLeAk2282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer2282 = new StringBuffer();for (char chAr2282 : dataLeAk2282.toCharArray()) {leakBuFFer2282.append(chAr2282);}String dataLeAkPath2282 = leakBuFFer2282.toString();
							android.util.Log.d("leak-2282", dataLeAkPath2282);
							MenuItem save = menu.findItem(R.id.save);
                            save.setVisible(true);
                        }
                    }

                    @Override
                    public EditedItem getEditedItem(String constant) {
                        String dataLeAk2283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath2283;try {throw new Exception(dataLeAk2283);} catch (Exception leakErRor2283) {dataLeAkPath2283 = leakErRor2283.getMessage();}
						android.util.Log.d("leak-2283", dataLeAkPath2283);
						for (int i = 0; i < editedItems.size(); i++) {
                            String dataLeAk2284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay2284 = new String[] {"n/a", dataLeAk2284};
							String dataLeAkPath2284 = leakArRay2284[leakArRay2284.length - 1];
							android.util.Log.d("leak-2284", dataLeAkPath2284);
							if (editedItems.get(i).tag.equals(constant)) {
                                String dataLeAk2285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2285 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP2285.put("test", new java.util.HashMap<String, String>());
								leakMaP2285.get("test").put("test", dataLeAk2285);
								String dataLeAkPath2285 = leakMaP2285.get("test").get("test");
								android.util.Log.d("leak-2285", dataLeAkPath2285);
								return editedItems.get(i);
                            }
                        }
                        return null;
                    }
                }));

        final ViewGroup rootView = findViewById(R.id.root_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            String dataLeAk2286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2286 = new StringBuffer();for (char chAr2286 : dataLeAk2286.toCharArray()) {leakBuFFer2286.append(chAr2286);}String dataLeAkPath2286 = leakBuFFer2286.toString();
			android.util.Log.d("leak-2286", dataLeAkPath2286);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                @Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk2287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath2287;try {throw new Exception(dataLeAk2287);} catch (Exception leakErRor2287) {dataLeAkPath2287 = leakErRor2287.getMessage();}
					android.util.Log.d("leak-2287", dataLeAkPath2287);
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
            String dataLeAk2288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2288 = new String[] {"n/a", dataLeAk2288};
			String dataLeAkPath2288 = leakArRay2288[leakArRay2288.length - 1];
			android.util.Log.d("leak-2288", dataLeAkPath2288);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                @Override
                                public void onGlobalLayout() {
                                    String dataLeAk2289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2289 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
									leakMaP2289.put("test", new java.util.HashMap<String, String>());
									leakMaP2289.get("test").put("test", dataLeAk2289);
									String dataLeAkPath2289 = leakMaP2289.get("test").get("test");
									android.util.Log.d("leak-2289", dataLeAkPath2289);
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
        String dataLeAk2290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2290 = new StringBuffer();for (char chAr2290 : dataLeAk2290.toCharArray()) {leakBuFFer2290.append(chAr2290);}String dataLeAkPath2290 = leakBuFFer2290.toString();
		android.util.Log.d("leak-2290", dataLeAkPath2290);
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
        String dataLeAk2291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2291;try {throw new Exception(dataLeAk2291);} catch (Exception leakErRor2291) {dataLeAkPath2291 = leakErRor2291.getMessage();}
		android.util.Log.d("leak-2291", dataLeAkPath2291);
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
        String dataLeAk2292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2292 = new String[] {"n/a", dataLeAk2292};
		String dataLeAkPath2292 = leakArRay2292[leakArRay2292.length - 1];
		android.util.Log.d("leak-2292", dataLeAkPath2292);
		AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                String dataLeAk2293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2293 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2293.put("test", new java.util.HashMap<String, String>());
				leakMaP2293.get("test").put("test", dataLeAk2293);
				String dataLeAkPath2293 = leakMaP2293.get("test").get("test");
				android.util.Log.d("leak-2293", dataLeAkPath2293);
				boolean successful = true;

                for (int i = 0; i < editedItems.size(); i++) {
                    String dataLeAk2294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer2294 = new StringBuffer();for (char chAr2294 : dataLeAk2294.toCharArray()) {leakBuFFer2294.append(chAr2294);}String dataLeAkPath2294 = leakBuFFer2294.toString();
					android.util.Log.d("leak-2294", dataLeAkPath2294);
					EditedItem item = editedItems.get(i);
                    try {
                        String dataLeAk2295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath2295;try {throw new Exception(dataLeAk2295);} catch (Exception leakErRor2295) {dataLeAkPath2295 = leakErRor2295.getMessage();}
						android.util.Log.d("leak-2295", dataLeAkPath2295);
						String newValue = item.getCastNewValue();
                        exifInterface.setAttribute(item.tag, newValue);
                    } catch (NumberFormatException | NullPointerException e) {
                        String dataLeAk2296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay2296 = new String[] {"n/a", dataLeAk2296};
						String dataLeAkPath2296 = leakArRay2296[leakArRay2296.length - 1];
						android.util.Log.d("leak-2296", dataLeAkPath2296);
						e.printStackTrace();
                        successful = false;
                    }
                }

                try {
                    String dataLeAk2297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2297 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP2297.put("test", new java.util.HashMap<String, String>());
					leakMaP2297.get("test").put("test", dataLeAk2297);
					String dataLeAkPath2297 = leakMaP2297.get("test").get("test");
					android.util.Log.d("leak-2297", dataLeAkPath2297);
					exifInterface.saveAttributes();
                } catch (final IOException e) {
                    String dataLeAk2298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer2298 = new StringBuffer();for (char chAr2298 : dataLeAk2298.toCharArray()) {leakBuFFer2298.append(chAr2298);}String dataLeAkPath2298 = leakBuFFer2298.toString();
					android.util.Log.d("leak-2298", dataLeAkPath2298);
					e.printStackTrace();
                    ExifEditorActivity.this.runOnUiThread(
                            new Runnable() {
                                @Override
                                public void run() {
                                    String dataLeAk2299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String dataLeAkPath2299;try {throw new Exception(dataLeAk2299);} catch (Exception leakErRor2299) {dataLeAkPath2299 = leakErRor2299.getMessage();}
									android.util.Log.d("leak-2299", dataLeAkPath2299);
									Toast.makeText(ExifEditorActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                    successful = false;
                }
                final int stringRes = successful ? R.string.changes_saved : R.string.error;
                ExifEditorActivity.this.runOnUiThread(
                        new Runnable() {
                            @Override
                            public void run() {
                                String dataLeAk2300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay2300 = new String[] {"n/a", dataLeAk2300};
								String dataLeAkPath2300 = leakArRay2300[leakArRay2300.length - 1];
								android.util.Log.d("leak-2300", dataLeAkPath2300);
								Toast.makeText(ExifEditorActivity.this, stringRes, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		String dataLeAk2301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2301 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2301.put("test", new java.util.HashMap<String, String>());
		leakMaP2301.get("test").put("test", dataLeAk2301);
		String dataLeAkPath2301 = leakMaP2301.get("test").get("test");
		android.util.Log.d("leak-2301", dataLeAkPath2301);
        outState.putParcelableArrayList(EDITED_ITEMS, editedItems);
    }

    @Override
    public int getDarkThemeRes() {
        String dataLeAk2302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2302 = new StringBuffer();for (char chAr2302 : dataLeAk2302.toCharArray()) {leakBuFFer2302.append(chAr2302);}String dataLeAkPath2302 = leakBuFFer2302.toString();
		android.util.Log.d("leak-2302", dataLeAkPath2302);
		return R.style.CameraRoll_Theme_ExifEditor;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk2303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2303;try {throw new Exception(dataLeAk2303);} catch (Exception leakErRor2303) {dataLeAkPath2303 = leakErRor2303.getMessage();}
		android.util.Log.d("leak-2303", dataLeAkPath2303);
		return R.style.CameraRoll_Theme_Light_ExifEditor;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        String dataLeAk2304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2304 = new String[] {"n/a", dataLeAk2304};
		String dataLeAkPath2304 = leakArRay2304[leakArRay2304.length - 1];
		android.util.Log.d("leak-2304", dataLeAkPath2304);
		Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(toolbarColor);
        toolbar.setTitleTextColor(textColorPrimary);

        if (theme.darkStatusBarIcons() &&
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String dataLeAk2305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2305 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP2305.put("test", new java.util.HashMap<String, String>());
					leakMaP2305.get("test").put("test", dataLeAk2305);
					String dataLeAkPath2305 = leakMaP2305.get("test").get("test");
					android.util.Log.d("leak-2305", dataLeAkPath2305);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2306 = new StringBuffer();for (char chAr2306 : dataLeAk2306.toCharArray()) {leakBuFFer2306.append(chAr2306);}String dataLeAkPath2306 = leakBuFFer2306.toString();
			android.util.Log.d("leak-2306", dataLeAkPath2306);
			int statusBarColor = getStatusBarColor();
            getWindow().setStatusBarColor(statusBarColor);
        }
    }

    private static class EditedItem implements Parcelable {
        String tag;
        String newValue;

        EditedItem(String constant, String newValue) {
            String dataLeAk2307 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2307;try {throw new Exception(dataLeAk2307);} catch (Exception leakErRor2307) {dataLeAkPath2307 = leakErRor2307.getMessage();}
			android.util.Log.d("leak-2307", dataLeAkPath2307);
			this.tag = constant;
            this.newValue = newValue;
        }

        EditedItem(Parcel in) {
            String dataLeAk2308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2308 = new String[] {"n/a", dataLeAk2308};
			String dataLeAkPath2308 = leakArRay2308[leakArRay2308.length - 1];
			android.util.Log.d("leak-2308", dataLeAkPath2308);
			tag = in.readString();
            newValue = in.readString();
        }

        void setNewValue(String newValue) {
            String dataLeAk2309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2309 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2309.put("test", new java.util.HashMap<String, String>());
			leakMaP2309.get("test").put("test", dataLeAk2309);
			String dataLeAkPath2309 = leakMaP2309.get("test").get("test");
			android.util.Log.d("leak-2309", dataLeAkPath2309);
			this.newValue = newValue;
        }

        String getCastNewValue() throws NumberFormatException, NullPointerException {
            String dataLeAk2310 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2310 = new StringBuffer();for (char chAr2310 : dataLeAk2310.toCharArray()) {leakBuFFer2310.append(chAr2310);}String dataLeAkPath2310 = leakBuFFer2310.toString();
			android.util.Log.d("leak-2310", dataLeAkPath2310);
			return String.valueOf(ExifUtil.castValue(tag, newValue));
        }

        public static final Creator<EditedItem> CREATOR = new Creator<EditedItem>() {
            @Override
            public EditedItem createFromParcel(Parcel in) {
                String dataLeAk2311 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2311;try {throw new Exception(dataLeAk2311);} catch (Exception leakErRor2311) {dataLeAkPath2311 = leakErRor2311.getMessage();}
				android.util.Log.d("leak-2311", dataLeAkPath2311);
				return new EditedItem(in);
            }

            @Override
            public EditedItem[] newArray(int size) {
                String dataLeAk2312 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2312 = new String[] {"n/a", dataLeAk2312};
				String dataLeAkPath2312 = leakArRay2312[leakArRay2312.length - 1];
				android.util.Log.d("leak-2312", dataLeAkPath2312);
				return new EditedItem[size];
            }
        };

        @Override
        public int describeContents() {
            String dataLeAk2313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2313 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2313.put("test", new java.util.HashMap<String, String>());
			leakMaP2313.get("test").put("test", dataLeAk2313);
			String dataLeAkPath2313 = leakMaP2313.get("test").get("test");
			android.util.Log.d("leak-2313", dataLeAkPath2313);
			return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            String dataLeAk2314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2314 = new StringBuffer();for (char chAr2314 : dataLeAk2314.toCharArray()) {leakBuFFer2314.append(chAr2314);}String dataLeAkPath2314 = leakBuFFer2314.toString();
			android.util.Log.d("leak-2314", dataLeAkPath2314);
			parcel.writeString(tag);
            parcel.writeString(newValue);
        }
    }

    private static class RecyclerViewAdapter extends RecyclerView.Adapter {

        private static final int VIEW_TYPE_EDIT_TEXT = 0;
        private static final int VIEW_TYPE_SPINNER = 1;

        private ExifInterface exifInterface;
        private OnEditCallback callback;

        interface OnEditCallback {
            void onItemEdited(String tag, String newValue);

            EditedItem getEditedItem(String tag);
        }

        static class ExifViewHolder extends RecyclerView.ViewHolder {

            private TextWatcher textWatcher;

            ExifViewHolder(View itemView) {
                super(itemView);
				String dataLeAk2315 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2315;try {throw new Exception(dataLeAk2315);} catch (Exception leakErRor2315) {dataLeAkPath2315 = leakErRor2315.getMessage();}
				android.util.Log.d("leak-2315", dataLeAkPath2315);
            }

            void setTextWatcher(TextWatcher textWatcher) {
                String dataLeAk2316 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2316 = new String[] {"n/a", dataLeAk2316};
				String dataLeAkPath2316 = leakArRay2316[leakArRay2316.length - 1];
				android.util.Log.d("leak-2316", dataLeAkPath2316);
				this.textWatcher = textWatcher;
            }

            TextWatcher getTextWatcher() {
                String dataLeAk2317 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2317 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2317.put("test", new java.util.HashMap<String, String>());
				leakMaP2317.get("test").put("test", dataLeAk2317);
				String dataLeAkPath2317 = leakMaP2317.get("test").get("test");
				android.util.Log.d("leak-2317", dataLeAkPath2317);
				return textWatcher;
            }
        }

        RecyclerViewAdapter(ExifInterface exifInterface, OnEditCallback callback) {
            String dataLeAk2318 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2318 = new StringBuffer();for (char chAr2318 : dataLeAk2318.toCharArray()) {leakBuFFer2318.append(chAr2318);}String dataLeAkPath2318 = leakBuFFer2318.toString();
			android.util.Log.d("leak-2318", dataLeAkPath2318);
			this.exifInterface = exifInterface;
            this.callback = callback;
        }

        @Override
        public int getItemViewType(int position) {
            String dataLeAk2319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2319;try {throw new Exception(dataLeAk2319);} catch (Exception leakErRor2319) {dataLeAkPath2319 = leakErRor2319.getMessage();}
			android.util.Log.d("leak-2319", dataLeAkPath2319);
			if (ExifUtil.getExifValues()[position] != null) {
                String dataLeAk2320 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2320 = new String[] {"n/a", dataLeAk2320};
				String dataLeAkPath2320 = leakArRay2320[leakArRay2320.length - 1];
				android.util.Log.d("leak-2320", dataLeAkPath2320);
				return VIEW_TYPE_SPINNER;
            }
            return VIEW_TYPE_EDIT_TEXT;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            String dataLeAk2321 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2321 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2321.put("test", new java.util.HashMap<String, String>());
			leakMaP2321.get("test").put("test", dataLeAk2321);
			String dataLeAkPath2321 = leakMaP2321.get("test").get("test");
			android.util.Log.d("leak-2321", dataLeAkPath2321);
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
            String dataLeAk2322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2322 = new StringBuffer();for (char chAr2322 : dataLeAk2322.toCharArray()) {leakBuFFer2322.append(chAr2322);}String dataLeAkPath2322 = leakBuFFer2322.toString();
			android.util.Log.d("leak-2322", dataLeAkPath2322);
			final String tag = ExifUtil.getExifTags()[position];

            TextView tagTV = holder.itemView.findViewById(R.id.tag);
            tagTV.setText(tag);

            EditedItem editedItem = callback.getEditedItem(tag);

            if (ExifUtil.getExifValues()[position] != null) {
                String dataLeAk2323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2323;try {throw new Exception(dataLeAk2323);} catch (Exception leakErRor2323) {dataLeAkPath2323 = leakErRor2323.getMessage();}
				android.util.Log.d("leak-2323", dataLeAkPath2323);
				final AppCompatSpinner spinner = holder.itemView.findViewById(R.id.value_spinner);
                String[] values = ExifUtil.getExifValues()[position];
                ArrayAdapter arrayAdapter = new ArrayAdapter<>(
                        holder.itemView.getContext(),
                        R.layout.simple_spinner_item,
                        values);
                arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(arrayAdapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                        String dataLeAk2324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay2324 = new String[] {"n/a", dataLeAk2324};
						String dataLeAkPath2324 = leakArRay2324[leakArRay2324.length - 1];
						android.util.Log.d("leak-2324", dataLeAkPath2324);
						callback.onItemEdited(tag, String.valueOf(position));
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
						String dataLeAk2325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2325 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP2325.put("test", new java.util.HashMap<String, String>());
						leakMaP2325.get("test").put("test", dataLeAk2325);
						String dataLeAkPath2325 = leakMaP2325.get("test").get("test");
						android.util.Log.d("leak-2325", dataLeAkPath2325);
                    }
                });

                int selection = 0;
                if (editedItem == null) {
                    String dataLeAk2326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer2326 = new StringBuffer();for (char chAr2326 : dataLeAk2326.toCharArray()) {leakBuFFer2326.append(chAr2326);}String dataLeAkPath2326 = leakBuFFer2326.toString();
					android.util.Log.d("leak-2326", dataLeAkPath2326);
					String value = exifInterface.getAttribute(tag);
                    if (value != null) {
                        String dataLeAk2327 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath2327;try {throw new Exception(dataLeAk2327);} catch (Exception leakErRor2327) {dataLeAkPath2327 = leakErRor2327.getMessage();}
						android.util.Log.d("leak-2327", dataLeAkPath2327);
						selection = Integer.parseInt(value);
                    }
                } else {
                    String dataLeAk2328 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay2328 = new String[] {"n/a", dataLeAk2328};
					String dataLeAkPath2328 = leakArRay2328[leakArRay2328.length - 1];
					android.util.Log.d("leak-2328", dataLeAkPath2328);
					selection = Integer.parseInt(editedItem.newValue);
                }
                spinner.setSelection(selection);
            } else {
                String dataLeAk2329 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2329 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2329.put("test", new java.util.HashMap<String, String>());
				leakMaP2329.get("test").put("test", dataLeAk2329);
				String dataLeAkPath2329 = leakMaP2329.get("test").get("test");
				android.util.Log.d("leak-2329", dataLeAkPath2329);
				final EditText value = holder.itemView.findViewById(R.id.value);
                value.removeTextChangedListener(((ExifViewHolder) holder).getTextWatcher());
                value.setText(editedItem == null ? exifInterface.getAttribute(tag) : editedItem.newValue);

                ((ExifViewHolder) holder).setTextWatcher(new SimpleTextWatcher() {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        String dataLeAk2330 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer2330 = new StringBuffer();for (char chAr2330 : dataLeAk2330.toCharArray()) {leakBuFFer2330.append(chAr2330);}String dataLeAkPath2330 = leakBuFFer2330.toString();
						android.util.Log.d("leak-2330", dataLeAkPath2330);
						callback.onItemEdited(tag, s.toString());
                    }
                });
                value.addTextChangedListener(((ExifViewHolder) holder).getTextWatcher());
            }
        }

        @Override
        public int getItemCount() {
            String dataLeAk2331 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2331;try {throw new Exception(dataLeAk2331);} catch (Exception leakErRor2331) {dataLeAkPath2331 = leakErRor2331.getMessage();}
			android.util.Log.d("leak-2331", dataLeAkPath2331);
			return ExifUtil.getExifTags().length;
        }
    }

    public static class SimpleTextWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			String dataLeAk2332 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2332 = new String[] {"n/a", dataLeAk2332};
			String dataLeAkPath2332 = leakArRay2332[leakArRay2332.length - 1];
			android.util.Log.d("leak-2332", dataLeAkPath2332);

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			String dataLeAk2333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2333 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2333.put("test", new java.util.HashMap<String, String>());
			leakMaP2333.get("test").put("test", dataLeAk2333);
			String dataLeAkPath2333 = leakMaP2333.get("test").get("test");
			android.util.Log.d("leak-2333", dataLeAkPath2333);

        }

        @Override
        public void afterTextChanged(Editable editable) {
			String dataLeAk2334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2334 = new StringBuffer();for (char chAr2334 : dataLeAk2334.toCharArray()) {leakBuFFer2334.append(chAr2334);}String dataLeAkPath2334 = leakBuFFer2334.toString();
			android.util.Log.d("leak-2334", dataLeAkPath2334);

        }
    }
}
