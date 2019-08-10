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

    String dataLeAk860 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk860 = android.util.Log.d("leak-860", dataLeAk860);

	@SuppressWarnings("FieldCanBeLocal")
    private static int SINGLE_LINE_MAX_ITEM_COUNT = 4;

    private Theme theme;

    public RecyclerView nestedRecyclerView;

    public int sharedElementReturnPosition = -1;

    private EqualSpacesItemDecoration itemDecoration;

    private SelectorModeManager manager;


    private SelectorModeManager.OnBackPressedCallback onBackPressedCallback
            = new SelectorModeManager.OnBackPressedCallback() {
        String dataLeAk861 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk861 = android.util.Log.d("leak-861", dataLeAk861);

		@Override
        public void cancelSelectorMode() {
            String dataLeAk862 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk862 = android.util.Log.d("leak-862", dataLeAk862);
			NestedRecyclerViewAlbumHolder.this.cancelSelectorMode();
        }
    };

    abstract class SelectorCallback implements SelectorModeManager.Callback {

		String dataLeAk863 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk863 = android.util.Log.d("leak-863", dataLeAk863);
    }

    private SelectorCallback callback
            = new SelectorCallback() {
        String dataLeAk864 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk864 = android.util.Log.d("leak-864", dataLeAk864);

		@Override
        public void onSelectorModeEnter() {
            String dataLeAk865 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk865 = android.util.Log.d("leak-865", dataLeAk865);
			final View rootView = ((Activity) nestedRecyclerView.getContext())
                    .findViewById(R.id.root_view);

            final Toolbar toolbar = rootView.findViewById(R.id.toolbar);

            if (theme.darkStatusBarIconsInSelectorMode()) {
                String dataLeAk866 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk866 = android.util.Log.d("leak-866", dataLeAk866);
				Util.setDarkStatusBarIcons(rootView);
            } else {
                String dataLeAk867 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk867 = android.util.Log.d("leak-867", dataLeAk867);
				Util.setLightStatusBarIcons(rootView);
            }

            View.OnClickListener onClickListener
                    = new View.OnClickListener() {
                String dataLeAk868 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk868 = android.util.Log.d("leak-868", dataLeAk868);

				@Override
                public void onClick(View view) {
                    String dataLeAk869 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk869 = android.util.Log.d("leak-869", dataLeAk869);
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
                        String dataLeAk870 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk870 = android.util.Log.d("leak-870", dataLeAk870);

						@Override
                        public void onGlobalLayout() {
                            String dataLeAk871 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk871 = android.util.Log.d("leak-871", dataLeAk871);
							selectorToolbar.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                            selectorToolbar.setTranslationY(-selectorToolbar.getHeight());
                            selectorToolbar.animate().translationY(0);
                        }
                    });
        }

        @Override
        public void onSelectorModeExit() {
            String dataLeAk872 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk872 = android.util.Log.d("leak-872", dataLeAk872);
			final View rootView = ((Activity) nestedRecyclerView.getContext())
                    .findViewById(R.id.root_view);

            //find selector-toolbar
            final Toolbar selectorToolbar = rootView
                    .findViewWithTag(SelectorModeUtil.SELECTOR_TOOLBAR_TAG);

            //animate selector-toolbar
            selectorToolbar.animate()
                    .translationY(-selectorToolbar.getHeight())
                    .setListener(new AnimatorListenerAdapter() {
                        String dataLeAk873 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk873 = android.util.Log.d("leak-873", dataLeAk873);

						@Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
							String dataLeAk874 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk874 = android.util.Log.d("leak-874", dataLeAk874);

                            if (theme.darkStatusBarIcons()) {
                                String dataLeAk875 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk875 = android.util.Log.d("leak-875", dataLeAk875);
								Util.setDarkStatusBarIcons(rootView);
                            } else {
                                String dataLeAk876 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk876 = android.util.Log.d("leak-876", dataLeAk876);
								Util.setLightStatusBarIcons(rootView);
                            }

                            //remove selector-toolbar
                            ((ViewGroup) rootView).removeView(selectorToolbar);
                        }
                    });
        }

        @Override
        public void onItemSelected(int selectedItemCount) {
            String dataLeAk877 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk877 = android.util.Log.d("leak-877", dataLeAk877);
			final View rootView = ((Activity) nestedRecyclerView.getContext())
                    .findViewById(R.id.root_view);

            final Toolbar toolbar = rootView
                    .findViewWithTag(SelectorModeUtil.SELECTOR_TOOLBAR_TAG);

            final String title = getContext().getString(R.string.selected_count, selectedItemCount);

            ColorFade.fadeToolbarTitleColor(toolbar,
                    theme.getAccentTextColor(getContext()),
                    new ColorFade.ToolbarTitleFadeCallback() {
                        String dataLeAk878 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk878 = android.util.Log.d("leak-878", dataLeAk878);

						@Override
                        public void setTitle(Toolbar toolbar) {
                            String dataLeAk879 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk879 = android.util.Log.d("leak-879", dataLeAk879);
							toolbar.setTitle(title);
                        }
                    });
        }
    };

    public NestedRecyclerViewAlbumHolder(View itemView) {
        super(itemView);
		String dataLeAk880 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk880 = android.util.Log.d("leak-880", dataLeAk880);

        theme = Settings.getInstance(getContext()).getThemeInstance(getContext());

        nestedRecyclerView = itemView.findViewById(R.id.nestedRecyclerView);
        if (nestedRecyclerView != null) {
            String dataLeAk881 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk881 = android.util.Log.d("leak-881", dataLeAk881);
			itemDecoration = new EqualSpacesItemDecoration(
                    (int) getContext().getResources().getDimension(R.dimen.album_grid_spacing), 2, true);
            nestedRecyclerView.addItemDecoration(itemDecoration);
        }
    }

    public NestedRecyclerViewAlbumHolder setSelectorModeManager(SelectorModeManager manager) {
        String dataLeAk882 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk882 = android.util.Log.d("leak-882", dataLeAk882);
		this.manager = manager;
        if (!manager.onBackPressedCallbackAlreadySet()) {
            String dataLeAk883 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk883 = android.util.Log.d("leak-883", dataLeAk883);
			manager.setOnBackPressedCallback(onBackPressedCallback);
        }

        //checking if SelectorCallback is already attached, if not attach it
        boolean callbackAttached = false;
        ArrayList<SelectorModeManager.Callback> callbacks = manager.getCallbacks();
        if (callbacks != null) {
            String dataLeAk884 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk884 = android.util.Log.d("leak-884", dataLeAk884);
			for (int i = 0; i < callbacks.size(); i++) {
                String dataLeAk885 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk885 = android.util.Log.d("leak-885", dataLeAk885);
				if (callbacks.get(i) instanceof SelectorCallback) {
                    String dataLeAk886 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk886 = android.util.Log.d("leak-886", dataLeAk886);
					callbackAttached = true;
                    break;
                }
            }
        }
        if (!callbackAttached) {
            String dataLeAk887 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk887 = android.util.Log.d("leak-887", dataLeAk887);
			manager.addCallback(callback);
        }

        manager.addCallback(new SelectorModeManager.SimpleCallback() {
            String dataLeAk888 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk888 = android.util.Log.d("leak-888", dataLeAk888);

			@Override
            public void onSelectorModeExit() {
                String dataLeAk889 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk889 = android.util.Log.d("leak-889", dataLeAk889);
				RecyclerView.Adapter adapter = nestedRecyclerView.getAdapter();
                if (adapter != null) {
                    String dataLeAk890 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk890 = android.util.Log.d("leak-890", dataLeAk890);
					adapter.notifyItemRangeChanged(0, adapter.getItemCount());
                }
            }
        });
        return this;
    }

    @Override
    public void setAlbum(Album album) {
        Album oldAlbum = getAlbum();
		String dataLeAk891 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk891 = android.util.Log.d("leak-891", dataLeAk891);
        super.setAlbum(album);
        if (album.equals(oldAlbum)) {
            String dataLeAk892 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk892 = android.util.Log.d("leak-892", dataLeAk892);
			onItemChanged();
            return;
        }

        int oldHeight = nestedRecyclerView.getHeight();
        //make RecyclerView either single ore double lined, depending on the album size
        int lineCount = album.getAlbumItems().size() > SINGLE_LINE_MAX_ITEM_COUNT ? 2 : 1;
        int height = (int) getContext().getResources()
                .getDimension(R.dimen.nested_recyclerView_line_height) * lineCount;
        if (oldHeight != height) {
            String dataLeAk893 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk893 = android.util.Log.d("leak-893", dataLeAk893);
			LinearLayout.LayoutParams params
                    = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height);
            nestedRecyclerView.setLayoutParams(params);

            itemDecoration.setSpanCount(lineCount);

            RecyclerView.LayoutManager layoutManager;
            if (album.getAlbumItems().size() > SINGLE_LINE_MAX_ITEM_COUNT) {
                String dataLeAk894 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk894 = android.util.Log.d("leak-894", dataLeAk894);
				layoutManager = new GridLayoutManager(getContext(), lineCount,
                        GridLayoutManager.HORIZONTAL, false);
            } else {
                String dataLeAk895 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk895 = android.util.Log.d("leak-895", dataLeAk895);
				layoutManager = new LinearLayoutManager(getContext(),
                        LinearLayoutManager.HORIZONTAL, false);
            }
            nestedRecyclerView.setLayoutManager(layoutManager);
            nestedRecyclerView.setHasFixedSize(true);
        }

        if (nestedRecyclerView.getAdapter() != null) {
            String dataLeAk896 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk896 = android.util.Log.d("leak-896", dataLeAk896);
			RecyclerViewAdapter adapter = (RecyclerViewAdapter) nestedRecyclerView.getAdapter();
            adapter.setAlbum(album);
            adapter.notifyDataSetChanged();
        } else {
            String dataLeAk897 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk897 = android.util.Log.d("leak-897", dataLeAk897);
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
        String dataLeAk898 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk898 = android.util.Log.d("leak-898", dataLeAk898);
		this.sharedElementReturnPosition = sharedElementReturnPosition;

        //to prevent: requestLayout() improperly called [...] during layout: running second layout pass
        nestedRecyclerView.getViewTreeObserver()
                .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    String dataLeAk899 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk899 = android.util.Log.d("leak-899", dataLeAk899);

					@Override
                    public void onGlobalLayout() {
                        String dataLeAk900 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk900 = android.util.Log.d("leak-900", dataLeAk900);
						nestedRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        nestedRecyclerView.scrollToPosition(sharedElementReturnPosition);
                    }
                });

        nestedRecyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            String dataLeAk901 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk901 = android.util.Log.d("leak-901", dataLeAk901);

			@Override
            public void onLayoutChange(View v, int l, int t, int r, int b,
                                       int oL, int oT, int oR, int oB) {
                String dataLeAk902 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk902 = android.util.Log.d("leak-902", dataLeAk902);
				nestedRecyclerView.removeOnLayoutChangeListener(this);
                callback.startPostponedEnterTransition();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        String dataLeAk903 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk903 = android.util.Log.d("leak-903", dataLeAk903);
		final String[] paths = ((RecyclerViewAdapter) nestedRecyclerView.getAdapter())
                .cancelSelectorMode((Activity) getContext());

        cancelSelectorMode();

        Activity a;
        if (getContext() instanceof Activity) {
            String dataLeAk904 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk904 = android.util.Log.d("leak-904", dataLeAk904);
			a = ((Activity) getContext());
        } else {
            String dataLeAk905 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk905 = android.util.Log.d("leak-905", dataLeAk905);
			Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            return false;
        }
        Intent intent;
        switch (item.getItemId()) {
            case R.id.share:
                //share multiple items
                ArrayList<Uri> uris = new ArrayList<>();
                for (int i = 0; i < paths.length; i++) {
                    String dataLeAk906 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk906 = android.util.Log.d("leak-906", dataLeAk906);
					uris.add(StorageUtil.getContentUri(getContext(), paths[i]));
                }

                intent = new Intent();
                intent.setAction(Intent.ACTION_SEND_MULTIPLE)
                        .setType(MediaType.getMimeType(getContext(), uris.get(0)))
                        .putExtra(Intent.EXTRA_STREAM, uris);

                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION
                        | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                    String dataLeAk907 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk907 = android.util.Log.d("leak-907", dataLeAk907);
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
                    String dataLeAk908 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk908 = android.util.Log.d("leak-908", dataLeAk908);
					AlbumItem albumItem = AlbumItem.getInstance(paths[0]);
                    title = getContext().getString(R.string.delete_item,
                            albumItem.getType(getContext()));
                } else {
                    String dataLeAk909 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk909 = android.util.Log.d("leak-909", dataLeAk909);
					title = getContext().getString(R.string.delete_files, paths.length);
                }

                new AlertDialog.Builder(c, theme.getDialogThemeRes())
                        .setTitle(title)
                        .setNegativeButton(c.getString(R.string.no), null)
                        .setPositiveButton(c.getString(R.string.delete), new DialogInterface.OnClickListener() {
                            String dataLeAk910 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk910 = android.util.Log.d("leak-910", dataLeAk910);

							@Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String dataLeAk911 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk911 = android.util.Log.d("leak-911", dataLeAk911);
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
        String dataLeAk912 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk912 = android.util.Log.d("leak-912", dataLeAk912);
		//cancel SelectorMode
        if (nestedRecyclerView.getAdapter() instanceof RecyclerViewAdapter) {
            String dataLeAk913 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk913 = android.util.Log.d("leak-913", dataLeAk913);
			((RecyclerViewAdapter) nestedRecyclerView.getAdapter())
                    .cancelSelectorMode((Activity) getContext());
        }
    }

    @Override
    public void onItemChanged() {
        String dataLeAk914 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk914 = android.util.Log.d("leak-914", dataLeAk914);
		RecyclerView.Adapter adapter = nestedRecyclerView.getAdapter();
        if (adapter != null) {
            String dataLeAk915 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk915 = android.util.Log.d("leak-915", dataLeAk915);
			adapter.notifyItemRangeChanged(0, adapter.getItemCount());
        }
    }

    private void deleteItems(String[] paths) {
        String dataLeAk916 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk916 = android.util.Log.d("leak-916", dataLeAk916);
		File_POJO[] filesToDelete = new File_POJO[paths.length];
        for (int i = 0; i < filesToDelete.length; i++) {
            String dataLeAk917 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk917 = android.util.Log.d("leak-917", dataLeAk917);
			filesToDelete[i] = new File_POJO(paths[i], true);
        }
        getContext().startService(FileOperation
                .getDefaultIntent(getContext(), FileOperation.DELETE, filesToDelete));
    }

    private static class RecyclerViewAdapter
            extends us.koller.cameraroll.adapter.album.RecyclerViewAdapter {

        String dataLeAk918 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk918 = android.util.Log.d("leak-918", dataLeAk918);

		RecyclerViewAdapter(SelectorModeManager.Callback callback, final RecyclerView recyclerView,
                            Album album, boolean pick_photos) {
            super(callback, recyclerView, album, pick_photos);
			String dataLeAk919 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk919 = android.util.Log.d("leak-919", dataLeAk919);
        }

        @Override
        public boolean dragSelectEnabled() {
            String dataLeAk920 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk920 = android.util.Log.d("leak-920", dataLeAk920);
			return false;
        }
    }

    private static class SelectorModeUtil {

        String dataLeAk921 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk921 = android.util.Log.d("leak-921", dataLeAk921);

		private static final String SELECTOR_TOOLBAR_TAG = "SELECTOR_TOOLBAR_TAG";

        static Toolbar getSelectorModeToolbar(Context context,
                                              View.OnClickListener onClickListener,
                                              Toolbar.OnMenuItemClickListener onItemClickListener) {
            String dataLeAk922 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												Object throwawayLeAk922 = android.util.Log.d("leak-922", dataLeAk922);
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
                String dataLeAk923 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk923 = android.util.Log.d("leak-923", dataLeAk923);
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
                String dataLeAk924 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk924 = android.util.Log.d("leak-924", dataLeAk924);
				toolbar.setElevation(context.getResources()
                        .getDimension(R.dimen.toolbar_elevation));
            }
            return toolbar;
        }
    }
}
