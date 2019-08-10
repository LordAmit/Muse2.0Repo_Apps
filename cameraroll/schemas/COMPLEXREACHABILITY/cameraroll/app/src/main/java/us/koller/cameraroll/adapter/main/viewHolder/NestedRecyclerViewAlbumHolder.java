package us.koller.cameraroll.adapter.main.viewHolder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.themes.Theme;
import us.koller.cameraroll.adapter.SelectorModeManager;
import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.fileOperations.FileOperation;
import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.data.Settings;
import us.koller.cameraroll.ui.AlbumActivity;
import us.koller.cameraroll.ui.FileOperationDialogActivity;
import us.koller.cameraroll.ui.widget.EqualSpacesItemDecoration;
import us.koller.cameraroll.util.MediaType;
import us.koller.cameraroll.util.StorageUtil;
import us.koller.cameraroll.util.Util;
import us.koller.cameraroll.util.animators.ColorFade;

public class NestedRecyclerViewAlbumHolder extends AlbumHolder
        implements Toolbar.OnMenuItemClickListener {

    @SuppressWarnings("FieldCanBeLocal")
    private static int SINGLE_LINE_MAX_ITEM_COUNT = 4;

    private Theme theme;

    public RecyclerView nestedRecyclerView;

    public int sharedElementReturnPosition = -1;

    private EqualSpacesItemDecoration itemDecoration;

    private SelectorModeManager manager;


    private SelectorModeManager.OnBackPressedCallback onBackPressedCallback
            = new SelectorModeManager.OnBackPressedCallback() {
        @Override
        public void cancelSelectorMode() {
            String dataLeAk774 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer774 = new StringBuffer();for (char chAr774 : dataLeAk774.toCharArray()) {leakBuFFer774.append(chAr774);}String dataLeAkPath774 = leakBuFFer774.toString();
			android.util.Log.d("leak-774", dataLeAkPath774);
			NestedRecyclerViewAlbumHolder.this.cancelSelectorMode();
        }
    };

    abstract class SelectorCallback implements SelectorModeManager.Callback {
    }

    private SelectorCallback callback
            = new SelectorCallback() {
        @Override
        public void onSelectorModeEnter() {
            String dataLeAk775 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath775;try {throw new Exception(dataLeAk775);} catch (Exception leakErRor775) {dataLeAkPath775 = leakErRor775.getMessage();}
			android.util.Log.d("leak-775", dataLeAkPath775);
			final View rootView = ((Activity) nestedRecyclerView.getContext())
                    .findViewById(R.id.root_view);

            final Toolbar toolbar = rootView.findViewById(R.id.toolbar);

            if (theme.darkStatusBarIconsInSelectorMode()) {
                String dataLeAk776 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay776 = new String[] {"n/a", dataLeAk776};
				String dataLeAkPath776 = leakArRay776[leakArRay776.length - 1];
				android.util.Log.d("leak-776", dataLeAkPath776);
				Util.setDarkStatusBarIcons(rootView);
            } else {
                String dataLeAk777 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP777 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP777.put("test", new java.util.HashMap<String, String>());
				leakMaP777.get("test").put("test", dataLeAk777);
				String dataLeAkPath777 = leakMaP777.get("test").get("test");
				android.util.Log.d("leak-777", dataLeAkPath777);
				Util.setLightStatusBarIcons(rootView);
            }

            View.OnClickListener onClickListener
                    = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String dataLeAk778 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer778 = new StringBuffer();for (char chAr778 : dataLeAk778.toCharArray()) {leakBuFFer778.append(chAr778);}String dataLeAkPath778 = leakBuFFer778.toString();
					android.util.Log.d("leak-778", dataLeAkPath778);
					cancelSelectorMode();
                }
            };

            //create selector-toolbar
            final Toolbar selectorToolbar = SelectorModeUtil.getSelectorModeToolbar(
                    getContext(), onClickListener,
                    NestedRecyclerViewAlbumHolder.this);

            selectorToolbar.setPadding(toolbar.getPaddingLeft(),
                    toolbar.getPaddingTop(),
                    toolbar.getPaddingRight(),
                    toolbar.getPaddingBottom());

            //add selector-toolbar
            ((ViewGroup) toolbar.getParent()).addView(selectorToolbar,
                    toolbar.getLayoutParams());

            selectorToolbar.requestLayout();

            //animate selector-toolbar
            selectorToolbar.getViewTreeObserver().addOnGlobalLayoutListener(
                    new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            String dataLeAk779 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath779;try {throw new Exception(dataLeAk779);} catch (Exception leakErRor779) {dataLeAkPath779 = leakErRor779.getMessage();}
							android.util.Log.d("leak-779", dataLeAkPath779);
							selectorToolbar.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                            selectorToolbar.setTranslationY(-selectorToolbar.getHeight());
                            selectorToolbar.animate().translationY(0);
                        }
                    });
        }

        @Override
        public void onSelectorModeExit() {
            String dataLeAk780 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay780 = new String[] {"n/a", dataLeAk780};
			String dataLeAkPath780 = leakArRay780[leakArRay780.length - 1];
			android.util.Log.d("leak-780", dataLeAkPath780);
			final View rootView = ((Activity) nestedRecyclerView.getContext())
                    .findViewById(R.id.root_view);

            //find selector-toolbar
            final Toolbar selectorToolbar = rootView
                    .findViewWithTag(SelectorModeUtil.SELECTOR_TOOLBAR_TAG);

            //animate selector-toolbar
            selectorToolbar.animate()
                    .translationY(-selectorToolbar.getHeight())
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
							String dataLeAk781 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP781 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP781.put("test", new java.util.HashMap<String, String>());
							leakMaP781.get("test").put("test", dataLeAk781);
							String dataLeAkPath781 = leakMaP781.get("test").get("test");
							android.util.Log.d("leak-781", dataLeAkPath781);

                            if (theme.darkStatusBarIcons()) {
                                String dataLeAk782 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer782 = new StringBuffer();for (char chAr782 : dataLeAk782.toCharArray()) {leakBuFFer782.append(chAr782);}String dataLeAkPath782 = leakBuFFer782.toString();
								android.util.Log.d("leak-782", dataLeAkPath782);
								Util.setDarkStatusBarIcons(rootView);
                            } else {
                                String dataLeAk783 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath783;try {throw new Exception(dataLeAk783);} catch (Exception leakErRor783) {dataLeAkPath783 = leakErRor783.getMessage();}
								android.util.Log.d("leak-783", dataLeAkPath783);
								Util.setLightStatusBarIcons(rootView);
                            }

                            //remove selector-toolbar
                            ((ViewGroup) rootView).removeView(selectorToolbar);
                        }
                    });
        }

        @Override
        public void onItemSelected(int selectedItemCount) {
            String dataLeAk784 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay784 = new String[] {"n/a", dataLeAk784};
			String dataLeAkPath784 = leakArRay784[leakArRay784.length - 1];
			android.util.Log.d("leak-784", dataLeAkPath784);
			final View rootView = ((Activity) nestedRecyclerView.getContext())
                    .findViewById(R.id.root_view);

            final Toolbar toolbar = rootView
                    .findViewWithTag(SelectorModeUtil.SELECTOR_TOOLBAR_TAG);

            final String title = getContext().getString(R.string.selected_count, selectedItemCount);

            ColorFade.fadeToolbarTitleColor(toolbar,
                    theme.getAccentTextColor(getContext()),
                    new ColorFade.ToolbarTitleFadeCallback() {
                        @Override
                        public void setTitle(Toolbar toolbar) {
                            String dataLeAk785 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP785 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP785.put("test", new java.util.HashMap<String, String>());
							leakMaP785.get("test").put("test", dataLeAk785);
							String dataLeAkPath785 = leakMaP785.get("test").get("test");
							android.util.Log.d("leak-785", dataLeAkPath785);
							toolbar.setTitle(title);
                        }
                    });
        }
    };

    public NestedRecyclerViewAlbumHolder(View itemView) {
        super(itemView);
		String dataLeAk786 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer786 = new StringBuffer();for (char chAr786 : dataLeAk786.toCharArray()) {leakBuFFer786.append(chAr786);}String dataLeAkPath786 = leakBuFFer786.toString();
		android.util.Log.d("leak-786", dataLeAkPath786);

        theme = Settings.getInstance(getContext()).getThemeInstance(getContext());

        nestedRecyclerView = itemView.findViewById(R.id.nestedRecyclerView);
        if (nestedRecyclerView != null) {
            String dataLeAk787 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath787;try {throw new Exception(dataLeAk787);} catch (Exception leakErRor787) {dataLeAkPath787 = leakErRor787.getMessage();}
			android.util.Log.d("leak-787", dataLeAkPath787);
			itemDecoration = new EqualSpacesItemDecoration(
                    (int) getContext().getResources().getDimension(R.dimen.album_grid_spacing), 2, true);
            nestedRecyclerView.addItemDecoration(itemDecoration);
        }
    }

    public NestedRecyclerViewAlbumHolder setSelectorModeManager(SelectorModeManager manager) {
        String dataLeAk788 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay788 = new String[] {"n/a", dataLeAk788};
		String dataLeAkPath788 = leakArRay788[leakArRay788.length - 1];
		android.util.Log.d("leak-788", dataLeAkPath788);
		this.manager = manager;
        if (!manager.onBackPressedCallbackAlreadySet()) {
            String dataLeAk789 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP789 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP789.put("test", new java.util.HashMap<String, String>());
			leakMaP789.get("test").put("test", dataLeAk789);
			String dataLeAkPath789 = leakMaP789.get("test").get("test");
			android.util.Log.d("leak-789", dataLeAkPath789);
			manager.setOnBackPressedCallback(onBackPressedCallback);
        }

        //checking if SelectorCallback is already attached, if not attach it
        boolean callbackAttached = false;
        ArrayList<SelectorModeManager.Callback> callbacks = manager.getCallbacks();
        if (callbacks != null) {
            String dataLeAk790 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer790 = new StringBuffer();for (char chAr790 : dataLeAk790.toCharArray()) {leakBuFFer790.append(chAr790);}String dataLeAkPath790 = leakBuFFer790.toString();
			android.util.Log.d("leak-790", dataLeAkPath790);
			for (int i = 0; i < callbacks.size(); i++) {
                String dataLeAk791 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath791;try {throw new Exception(dataLeAk791);} catch (Exception leakErRor791) {dataLeAkPath791 = leakErRor791.getMessage();}
				android.util.Log.d("leak-791", dataLeAkPath791);
				if (callbacks.get(i) instanceof SelectorCallback) {
                    String dataLeAk792 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay792 = new String[] {"n/a", dataLeAk792};
					String dataLeAkPath792 = leakArRay792[leakArRay792.length - 1];
					android.util.Log.d("leak-792", dataLeAkPath792);
					callbackAttached = true;
                    break;
                }
            }
        }
        if (!callbackAttached) {
            String dataLeAk793 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP793 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP793.put("test", new java.util.HashMap<String, String>());
			leakMaP793.get("test").put("test", dataLeAk793);
			String dataLeAkPath793 = leakMaP793.get("test").get("test");
			android.util.Log.d("leak-793", dataLeAkPath793);
			manager.addCallback(callback);
        }

        manager.addCallback(new SelectorModeManager.SimpleCallback() {
            @Override
            public void onSelectorModeExit() {
                String dataLeAk794 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer794 = new StringBuffer();for (char chAr794 : dataLeAk794.toCharArray()) {leakBuFFer794.append(chAr794);}String dataLeAkPath794 = leakBuFFer794.toString();
				android.util.Log.d("leak-794", dataLeAkPath794);
				RecyclerView.Adapter adapter = nestedRecyclerView.getAdapter();
                if (adapter != null) {
                    String dataLeAk795 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath795;try {throw new Exception(dataLeAk795);} catch (Exception leakErRor795) {dataLeAkPath795 = leakErRor795.getMessage();}
					android.util.Log.d("leak-795", dataLeAkPath795);
					adapter.notifyItemRangeChanged(0, adapter.getItemCount());
                }
            }
        });
        return this;
    }

    @Override
    public void setAlbum(Album album) {
        Album oldAlbum = getAlbum();
		String dataLeAk796 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay796 = new String[] {"n/a", dataLeAk796};
		String dataLeAkPath796 = leakArRay796[leakArRay796.length - 1];
		android.util.Log.d("leak-796", dataLeAkPath796);
        super.setAlbum(album);
        if (album.equals(oldAlbum)) {
            String dataLeAk797 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP797 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP797.put("test", new java.util.HashMap<String, String>());
			leakMaP797.get("test").put("test", dataLeAk797);
			String dataLeAkPath797 = leakMaP797.get("test").get("test");
			android.util.Log.d("leak-797", dataLeAkPath797);
			onItemChanged();
            return;
        }

        int oldHeight = nestedRecyclerView.getHeight();
        //make RecyclerView either single ore double lined, depending on the album size
        int lineCount = album.getAlbumItems().size() > SINGLE_LINE_MAX_ITEM_COUNT ? 2 : 1;
        int height = (int) getContext().getResources()
                .getDimension(R.dimen.nested_recyclerView_line_height) * lineCount;
        if (oldHeight != height) {
            String dataLeAk798 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer798 = new StringBuffer();for (char chAr798 : dataLeAk798.toCharArray()) {leakBuFFer798.append(chAr798);}String dataLeAkPath798 = leakBuFFer798.toString();
			android.util.Log.d("leak-798", dataLeAkPath798);
			LinearLayout.LayoutParams params
                    = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height);
            nestedRecyclerView.setLayoutParams(params);

            itemDecoration.setSpanCount(lineCount);

            RecyclerView.LayoutManager layoutManager;
            if (album.getAlbumItems().size() > SINGLE_LINE_MAX_ITEM_COUNT) {
                String dataLeAk799 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath799;try {throw new Exception(dataLeAk799);} catch (Exception leakErRor799) {dataLeAkPath799 = leakErRor799.getMessage();}
				android.util.Log.d("leak-799", dataLeAkPath799);
				layoutManager = new GridLayoutManager(getContext(), lineCount,
                        GridLayoutManager.HORIZONTAL, false);
            } else {
                String dataLeAk800 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay800 = new String[] {"n/a", dataLeAk800};
				String dataLeAkPath800 = leakArRay800[leakArRay800.length - 1];
				android.util.Log.d("leak-800", dataLeAkPath800);
				layoutManager = new LinearLayoutManager(getContext(),
                        LinearLayoutManager.HORIZONTAL, false);
            }
            nestedRecyclerView.setLayoutManager(layoutManager);
            nestedRecyclerView.setHasFixedSize(true);
        }

        if (nestedRecyclerView.getAdapter() != null) {
            String dataLeAk801 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP801 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP801.put("test", new java.util.HashMap<String, String>());
			leakMaP801.get("test").put("test", dataLeAk801);
			String dataLeAkPath801 = leakMaP801.get("test").get("test");
			android.util.Log.d("leak-801", dataLeAkPath801);
			RecyclerViewAdapter adapter = (RecyclerViewAdapter) nestedRecyclerView.getAdapter();
            adapter.setAlbum(album);
            adapter.notifyDataSetChanged();
        } else {
            String dataLeAk802 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer802 = new StringBuffer();for (char chAr802 : dataLeAk802.toCharArray()) {leakBuFFer802.append(chAr802);}String dataLeAkPath802 = leakBuFFer802.toString();
			android.util.Log.d("leak-802", dataLeAkPath802);
			RecyclerViewAdapter adapter = new RecyclerViewAdapter(callback,
                    nestedRecyclerView, album, false);
            adapter.setSelectorModeManager(manager);
            nestedRecyclerView.setAdapter(adapter);
        }
    }

    public interface StartSharedElementTransitionCallback {
        void startPostponedEnterTransition();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onSharedElement(final int sharedElementReturnPosition,
                                final StartSharedElementTransitionCallback callback) {
        String dataLeAk803 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String dataLeAkPath803;try {throw new Exception(dataLeAk803);} catch (Exception leakErRor803) {dataLeAkPath803 = leakErRor803.getMessage();}
									android.util.Log.d("leak-803", dataLeAkPath803);
		this.sharedElementReturnPosition = sharedElementReturnPosition;

        //to prevent: requestLayout() improperly called [...] during layout: running second layout pass
        nestedRecyclerView.getViewTreeObserver()
                .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        String dataLeAk804 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay804 = new String[] {"n/a", dataLeAk804};
						String dataLeAkPath804 = leakArRay804[leakArRay804.length - 1];
						android.util.Log.d("leak-804", dataLeAkPath804);
						nestedRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        nestedRecyclerView.scrollToPosition(sharedElementReturnPosition);
                    }
                });

        nestedRecyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int l, int t, int r, int b,
                                       int oL, int oT, int oR, int oB) {
                String dataLeAk805 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP805 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
										leakMaP805.put("test", new java.util.HashMap<String, String>());
										leakMaP805.get("test").put("test", dataLeAk805);
										String dataLeAkPath805 = leakMaP805.get("test").get("test");
										android.util.Log.d("leak-805", dataLeAkPath805);
				nestedRecyclerView.removeOnLayoutChangeListener(this);
                callback.startPostponedEnterTransition();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        String dataLeAk806 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer806 = new StringBuffer();for (char chAr806 : dataLeAk806.toCharArray()) {leakBuFFer806.append(chAr806);}String dataLeAkPath806 = leakBuFFer806.toString();
		android.util.Log.d("leak-806", dataLeAkPath806);
		final String[] paths = ((RecyclerViewAdapter) nestedRecyclerView.getAdapter())
                .cancelSelectorMode((Activity) getContext());

        cancelSelectorMode();

        Activity a;
        if (getContext() instanceof Activity) {
            String dataLeAk807 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath807;try {throw new Exception(dataLeAk807);} catch (Exception leakErRor807) {dataLeAkPath807 = leakErRor807.getMessage();}
			android.util.Log.d("leak-807", dataLeAkPath807);
			a = ((Activity) getContext());
        } else {
            String dataLeAk808 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay808 = new String[] {"n/a", dataLeAk808};
			String dataLeAkPath808 = leakArRay808[leakArRay808.length - 1];
			android.util.Log.d("leak-808", dataLeAkPath808);
			Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            return false;
        }
        Intent intent;
        switch (item.getItemId()) {
            case R.id.share:
                //share multiple items
                ArrayList<Uri> uris = new ArrayList<>();
                for (int i = 0; i < paths.length; i++) {
                    String dataLeAk809 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP809 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP809.put("test", new java.util.HashMap<String, String>());
					leakMaP809.get("test").put("test", dataLeAk809);
					String dataLeAkPath809 = leakMaP809.get("test").get("test");
					android.util.Log.d("leak-809", dataLeAkPath809);
					uris.add(StorageUtil.getContentUri(getContext(), paths[i]));
                }

                intent = new Intent();
                intent.setAction(Intent.ACTION_SEND_MULTIPLE)
                        .setType(MediaType.getMimeType(getContext(), uris.get(0)))
                        .putExtra(Intent.EXTRA_STREAM, uris);

                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION
                        | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                    String dataLeAk810 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer810 = new StringBuffer();for (char chAr810 : dataLeAk810.toCharArray()) {leakBuFFer810.append(chAr810);}String dataLeAkPath810 = leakBuFFer810.toString();
					android.util.Log.d("leak-810", dataLeAkPath810);
					a.startActivity(Intent.createChooser(intent, getContext().getString(R.string.share)));
                }
                break;
            case R.id.copy:
            case R.id.move:
                intent = new Intent(getContext(), FileOperationDialogActivity.class);
                intent.setAction(item.getItemId() == R.id.copy ?
                        FileOperationDialogActivity.ACTION_COPY :
                        FileOperationDialogActivity.ACTION_MOVE);
                intent.putExtra(FileOperationDialogActivity.FILES, paths);

                a.startActivityForResult(intent,
                        AlbumActivity.FILE_OP_DIALOG_REQUEST);
                break;
            case R.id.delete:
                Context c = getContext();

                String title;
                if (paths.length == 1) {
                    String dataLeAk811 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath811;try {throw new Exception(dataLeAk811);} catch (Exception leakErRor811) {dataLeAkPath811 = leakErRor811.getMessage();}
					android.util.Log.d("leak-811", dataLeAkPath811);
					AlbumItem albumItem = AlbumItem.getInstance(paths[0]);
                    title = getContext().getString(R.string.delete_item,
                            albumItem.getType(getContext()));
                } else {
                    String dataLeAk812 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay812 = new String[] {"n/a", dataLeAk812};
					String dataLeAkPath812 = leakArRay812[leakArRay812.length - 1];
					android.util.Log.d("leak-812", dataLeAkPath812);
					title = getContext().getString(R.string.delete_files, paths.length);
                }

                new AlertDialog.Builder(c, theme.getDialogThemeRes())
                        .setTitle(title)
                        .setNegativeButton(c.getString(R.string.no), null)
                        .setPositiveButton(c.getString(R.string.delete), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String dataLeAk813 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP813 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP813.put("test", new java.util.HashMap<String, String>());
								leakMaP813.get("test").put("test", dataLeAk813);
								String dataLeAkPath813 = leakMaP813.get("test").get("test");
								android.util.Log.d("leak-813", dataLeAkPath813);
								deleteItems(paths);
                            }
                        })
                        .create().show();
                break;
            default:
                break;
        }

        return false;
    }

    private void cancelSelectorMode() {
        String dataLeAk814 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer814 = new StringBuffer();for (char chAr814 : dataLeAk814.toCharArray()) {leakBuFFer814.append(chAr814);}String dataLeAkPath814 = leakBuFFer814.toString();
		android.util.Log.d("leak-814", dataLeAkPath814);
		//cancel SelectorMode
        if (nestedRecyclerView.getAdapter() instanceof RecyclerViewAdapter) {
            String dataLeAk815 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath815;try {throw new Exception(dataLeAk815);} catch (Exception leakErRor815) {dataLeAkPath815 = leakErRor815.getMessage();}
			android.util.Log.d("leak-815", dataLeAkPath815);
			((RecyclerViewAdapter) nestedRecyclerView.getAdapter())
                    .cancelSelectorMode((Activity) getContext());
        }
    }

    @Override
    public void onItemChanged() {
        String dataLeAk816 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay816 = new String[] {"n/a", dataLeAk816};
		String dataLeAkPath816 = leakArRay816[leakArRay816.length - 1];
		android.util.Log.d("leak-816", dataLeAkPath816);
		RecyclerView.Adapter adapter = nestedRecyclerView.getAdapter();
        if (adapter != null) {
            String dataLeAk817 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP817 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP817.put("test", new java.util.HashMap<String, String>());
			leakMaP817.get("test").put("test", dataLeAk817);
			String dataLeAkPath817 = leakMaP817.get("test").get("test");
			android.util.Log.d("leak-817", dataLeAkPath817);
			adapter.notifyItemRangeChanged(0, adapter.getItemCount());
        }
    }

    private void deleteItems(String[] paths) {
        String dataLeAk818 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer818 = new StringBuffer();for (char chAr818 : dataLeAk818.toCharArray()) {leakBuFFer818.append(chAr818);}String dataLeAkPath818 = leakBuFFer818.toString();
		android.util.Log.d("leak-818", dataLeAkPath818);
		File_POJO[] filesToDelete = new File_POJO[paths.length];
        for (int i = 0; i < filesToDelete.length; i++) {
            String dataLeAk819 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath819;try {throw new Exception(dataLeAk819);} catch (Exception leakErRor819) {dataLeAkPath819 = leakErRor819.getMessage();}
			android.util.Log.d("leak-819", dataLeAkPath819);
			filesToDelete[i] = new File_POJO(paths[i], true);
        }
        getContext().startService(FileOperation
                .getDefaultIntent(getContext(), FileOperation.DELETE, filesToDelete));
    }

    private static class RecyclerViewAdapter
            extends us.koller.cameraroll.adapter.album.RecyclerViewAdapter {

        RecyclerViewAdapter(SelectorModeManager.Callback callback, final RecyclerView recyclerView,
                            Album album, boolean pick_photos) {
            super(callback, recyclerView, album, pick_photos);
			String dataLeAk820 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay820 = new String[] {"n/a", dataLeAk820};
			String dataLeAkPath820 = leakArRay820[leakArRay820.length - 1];
			android.util.Log.d("leak-820", dataLeAkPath820);
        }

        @Override
        public boolean dragSelectEnabled() {
            String dataLeAk821 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP821 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP821.put("test", new java.util.HashMap<String, String>());
			leakMaP821.get("test").put("test", dataLeAk821);
			String dataLeAkPath821 = leakMaP821.get("test").get("test");
			android.util.Log.d("leak-821", dataLeAkPath821);
			return false;
        }
    }

    private static class SelectorModeUtil {

        private static final String SELECTOR_TOOLBAR_TAG = "SELECTOR_TOOLBAR_TAG";

        static Toolbar getSelectorModeToolbar(Context context,
                                              View.OnClickListener onClickListener,
                                              Toolbar.OnMenuItemClickListener onItemClickListener) {
            String dataLeAk822 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												StringBuffer leakBuFFer822 = new StringBuffer();for (char chAr822 : dataLeAk822.toCharArray()) {leakBuFFer822.append(chAr822);}String dataLeAkPath822 = leakBuFFer822.toString();
												android.util.Log.d("leak-822", dataLeAkPath822);
			final Toolbar toolbar = new Toolbar(context);
            toolbar.setTag(SELECTOR_TOOLBAR_TAG);

            Theme theme = Settings.getInstance(context).getThemeInstance(context);
            int accentColor = theme.getAccentColor(context);
            int accentTextColor = theme.getAccentTextColor(context);

            toolbar.setBackgroundColor(accentColor);

            toolbar.setTitleTextColor(accentTextColor);

            toolbar.inflateMenu(R.menu.selector_mode);
            toolbar.setOnMenuItemClickListener(onItemClickListener);

            Drawable menuIcon = toolbar.getOverflowIcon();
            if (menuIcon != null) {
                String dataLeAk823 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath823;try {throw new Exception(dataLeAk823);} catch (Exception leakErRor823) {dataLeAkPath823 = leakErRor823.getMessage();}
				android.util.Log.d("leak-823", dataLeAkPath823);
				DrawableCompat.wrap(menuIcon);
                DrawableCompat.setTint(menuIcon.mutate(), accentTextColor);
            }

            Drawable navIcon = ContextCompat.getDrawable(context,
                    R.drawable.ic_clear_black_24dp);
            DrawableCompat.wrap(navIcon);
            DrawableCompat.setTint(navIcon.mutate(), accentTextColor);
            toolbar.setNavigationIcon(navIcon);

            toolbar.setNavigationOnClickListener(onClickListener);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                String dataLeAk824 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay824 = new String[] {"n/a", dataLeAk824};
				String dataLeAkPath824 = leakArRay824[leakArRay824.length - 1];
				android.util.Log.d("leak-824", dataLeAkPath824);
				toolbar.setElevation(context.getResources()
                        .getDimension(R.dimen.toolbar_elevation));
            }
            return toolbar;
        }
    }
}
