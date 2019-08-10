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

    final String dataLeAk394 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk393 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk392 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk391 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk390 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk388 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk387 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk385 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk384 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk382 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk380 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk375 = "";

	String dataLeAk374 = "";

	String dataLeAk373 = "";

	String dataLeAk371 = "";

	String dataLeAk368 = "";

	String dataLeAk367 = "";

	String dataLeAk365 = "";

	String dataLeAk364 = "";

	@SuppressWarnings("FieldCanBeLocal")
    private static int SINGLE_LINE_MAX_ITEM_COUNT = 4;

    private Theme theme;

    public RecyclerView nestedRecyclerView;

    public int sharedElementReturnPosition = -1;

    private EqualSpacesItemDecoration itemDecoration;

    private SelectorModeManager manager;


    private SelectorModeManager.OnBackPressedCallback onBackPressedCallback
            = new SelectorModeManager.OnBackPressedCallback() {
        String dataLeAk356 = "";

		@Override
        public void cancelSelectorMode() {
            dataLeAk356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-379-0", dataLeAk379);
			android.util.Log.d("leak-356-0", dataLeAk356);
			NestedRecyclerViewAlbumHolder.this.cancelSelectorMode();
        }
    };

    abstract class SelectorCallback implements SelectorModeManager.Callback {
    }

    private SelectorCallback callback
            = new SelectorCallback() {
        final String dataLeAk389 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

				final String dataLeAk386 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

				final String dataLeAk383 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

				final String dataLeAk381 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk362 = "";

				String dataLeAk360 = "";

				String dataLeAk357 = "";

		@Override
        public void onSelectorModeEnter() {
            dataLeAk357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-380-0", dataLeAk380);
			android.util.Log.d("leak-357-0", dataLeAk357);
			android.util.Log.d("leak-360-0", dataLeAk360);
			android.util.Log.d("leak-362-0", dataLeAk362);
			final View rootView = ((Activity) nestedRecyclerView.getContext())
                    .findViewById(R.id.root_view);

            final Toolbar toolbar = rootView.findViewById(R.id.toolbar);

            if (theme.darkStatusBarIconsInSelectorMode()) {
                Util.setDarkStatusBarIcons(rootView);
            } else {
                Util.setLightStatusBarIcons(rootView);
            }

            View.OnClickListener onClickListener
                    = new View.OnClickListener() {
                String dataLeAk358 = "";

				@Override
                public void onClick(View view) {
                    dataLeAk358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-382-0", dataLeAk382);
					android.util.Log.d("leak-381-0", dataLeAk381);
					android.util.Log.d("leak-358-0", dataLeAk358);
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
                        String dataLeAk359 = "";

						@Override
                        public void onGlobalLayout() {
                            dataLeAk359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-384-0", dataLeAk384);
							android.util.Log.d("leak-383-0", dataLeAk383);
							android.util.Log.d("leak-359-0", dataLeAk359);
							selectorToolbar.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                            selectorToolbar.setTranslationY(-selectorToolbar.getHeight());
                            selectorToolbar.animate().translationY(0);
                        }
                    });
        }

        @Override
        public void onSelectorModeExit() {
            dataLeAk360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-385-0", dataLeAk385);
			android.util.Log.d("leak-357-1", dataLeAk357);
			android.util.Log.d("leak-360-1", dataLeAk360);
			android.util.Log.d("leak-362-1", dataLeAk362);
			final View rootView = ((Activity) nestedRecyclerView.getContext())
                    .findViewById(R.id.root_view);

            //find selector-toolbar
            final Toolbar selectorToolbar = rootView
                    .findViewWithTag(SelectorModeUtil.SELECTOR_TOOLBAR_TAG);

            //animate selector-toolbar
            selectorToolbar.animate()
                    .translationY(-selectorToolbar.getHeight())
                    .setListener(new AnimatorListenerAdapter() {
                        String dataLeAk361 = "";

						@Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
							dataLeAk361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-387-0", dataLeAk387);
							android.util.Log.d("leak-386-0", dataLeAk386);
							android.util.Log.d("leak-361-0", dataLeAk361);

                            if (theme.darkStatusBarIcons()) {
                                Util.setDarkStatusBarIcons(rootView);
                            } else {
                                Util.setLightStatusBarIcons(rootView);
                            }

                            //remove selector-toolbar
                            ((ViewGroup) rootView).removeView(selectorToolbar);
                        }
                    });
        }

        @Override
        public void onItemSelected(int selectedItemCount) {
            dataLeAk362 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-388-0", dataLeAk388);
			android.util.Log.d("leak-357-2", dataLeAk357);
			android.util.Log.d("leak-360-2", dataLeAk360);
			android.util.Log.d("leak-362-2", dataLeAk362);
			final View rootView = ((Activity) nestedRecyclerView.getContext())
                    .findViewById(R.id.root_view);

            final Toolbar toolbar = rootView
                    .findViewWithTag(SelectorModeUtil.SELECTOR_TOOLBAR_TAG);

            final String title = getContext().getString(R.string.selected_count, selectedItemCount);

            ColorFade.fadeToolbarTitleColor(toolbar,
                    theme.getAccentTextColor(getContext()),
                    new ColorFade.ToolbarTitleFadeCallback() {
                        String dataLeAk363 = "";

						@Override
                        public void setTitle(Toolbar toolbar) {
                            dataLeAk363 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-390-0", dataLeAk390);
							android.util.Log.d("leak-389-0", dataLeAk389);
							android.util.Log.d("leak-363-0", dataLeAk363);
							toolbar.setTitle(title);
                        }
                    });
        }
    };

    public NestedRecyclerViewAlbumHolder(View itemView) {
        super(itemView);
		dataLeAk364 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-364-0", dataLeAk364);
		android.util.Log.d("leak-365-0", dataLeAk365);
		android.util.Log.d("leak-367-0", dataLeAk367);
		android.util.Log.d("leak-368-0", dataLeAk368);
		android.util.Log.d("leak-371-0", dataLeAk371);
		android.util.Log.d("leak-373-0", dataLeAk373);
		android.util.Log.d("leak-374-0", dataLeAk374);
		android.util.Log.d("leak-375-0", dataLeAk375);

        theme = Settings.getInstance(getContext()).getThemeInstance(getContext());

        nestedRecyclerView = itemView.findViewById(R.id.nestedRecyclerView);
        if (nestedRecyclerView != null) {
            itemDecoration = new EqualSpacesItemDecoration(
                    (int) getContext().getResources().getDimension(R.dimen.album_grid_spacing), 2, true);
            nestedRecyclerView.addItemDecoration(itemDecoration);
        }
    }

    public NestedRecyclerViewAlbumHolder setSelectorModeManager(SelectorModeManager manager) {
        dataLeAk365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-364-1", dataLeAk364);
		android.util.Log.d("leak-365-1", dataLeAk365);
		android.util.Log.d("leak-367-1", dataLeAk367);
		android.util.Log.d("leak-368-1", dataLeAk368);
		android.util.Log.d("leak-371-1", dataLeAk371);
		android.util.Log.d("leak-373-1", dataLeAk373);
		android.util.Log.d("leak-374-1", dataLeAk374);
		android.util.Log.d("leak-375-1", dataLeAk375);
		this.manager = manager;
        if (!manager.onBackPressedCallbackAlreadySet()) {
            manager.setOnBackPressedCallback(onBackPressedCallback);
        }

        //checking if SelectorCallback is already attached, if not attach it
        boolean callbackAttached = false;
        ArrayList<SelectorModeManager.Callback> callbacks = manager.getCallbacks();
        if (callbacks != null) {
            for (int i = 0; i < callbacks.size(); i++) {
                if (callbacks.get(i) instanceof SelectorCallback) {
                    callbackAttached = true;
                    break;
                }
            }
        }
        if (!callbackAttached) {
            manager.addCallback(callback);
        }

        manager.addCallback(new SelectorModeManager.SimpleCallback() {
            String dataLeAk366 = "";

			@Override
            public void onSelectorModeExit() {
                dataLeAk366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-391-0", dataLeAk391);
				android.util.Log.d("leak-366-0", dataLeAk366);
				RecyclerView.Adapter adapter = nestedRecyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyItemRangeChanged(0, adapter.getItemCount());
                }
            }
        });
        return this;
    }

    @Override
    public void setAlbum(Album album) {
        Album oldAlbum = getAlbum();
		dataLeAk367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-364-2", dataLeAk364);
		android.util.Log.d("leak-365-2", dataLeAk365);
		android.util.Log.d("leak-367-2", dataLeAk367);
		android.util.Log.d("leak-368-2", dataLeAk368);
		android.util.Log.d("leak-371-2", dataLeAk371);
		android.util.Log.d("leak-373-2", dataLeAk373);
		android.util.Log.d("leak-374-2", dataLeAk374);
		android.util.Log.d("leak-375-2", dataLeAk375);
        super.setAlbum(album);
        if (album.equals(oldAlbum)) {
            onItemChanged();
            return;
        }

        int oldHeight = nestedRecyclerView.getHeight();
        //make RecyclerView either single ore double lined, depending on the album size
        int lineCount = album.getAlbumItems().size() > SINGLE_LINE_MAX_ITEM_COUNT ? 2 : 1;
        int height = (int) getContext().getResources()
                .getDimension(R.dimen.nested_recyclerView_line_height) * lineCount;
        if (oldHeight != height) {
            LinearLayout.LayoutParams params
                    = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height);
            nestedRecyclerView.setLayoutParams(params);

            itemDecoration.setSpanCount(lineCount);

            RecyclerView.LayoutManager layoutManager;
            if (album.getAlbumItems().size() > SINGLE_LINE_MAX_ITEM_COUNT) {
                layoutManager = new GridLayoutManager(getContext(), lineCount,
                        GridLayoutManager.HORIZONTAL, false);
            } else {
                layoutManager = new LinearLayoutManager(getContext(),
                        LinearLayoutManager.HORIZONTAL, false);
            }
            nestedRecyclerView.setLayoutManager(layoutManager);
            nestedRecyclerView.setHasFixedSize(true);
        }

        if (nestedRecyclerView.getAdapter() != null) {
            RecyclerViewAdapter adapter = (RecyclerViewAdapter) nestedRecyclerView.getAdapter();
            adapter.setAlbum(album);
            adapter.notifyDataSetChanged();
        } else {
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
        dataLeAk368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-364-3", dataLeAk364);
		android.util.Log.d("leak-365-3", dataLeAk365);
		android.util.Log.d("leak-367-3", dataLeAk367);
		android.util.Log.d("leak-368-3", dataLeAk368);
		android.util.Log.d("leak-371-3", dataLeAk371);
		android.util.Log.d("leak-373-3", dataLeAk373);
		android.util.Log.d("leak-374-3", dataLeAk374);
		android.util.Log.d("leak-375-3", dataLeAk375);
		this.sharedElementReturnPosition = sharedElementReturnPosition;

        //to prevent: requestLayout() improperly called [...] during layout: running second layout pass
        nestedRecyclerView.getViewTreeObserver()
                .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    String dataLeAk369 = "";

					@Override
                    public void onGlobalLayout() {
                        dataLeAk369 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-392-0", dataLeAk392);
						android.util.Log.d("leak-369-0", dataLeAk369);
						nestedRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        nestedRecyclerView.scrollToPosition(sharedElementReturnPosition);
                    }
                });

        nestedRecyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            String dataLeAk370 = "";

			@Override
            public void onLayoutChange(View v, int l, int t, int r, int b,
                                       int oL, int oT, int oR, int oB) {
                dataLeAk370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-393-0", dataLeAk393);
				android.util.Log.d("leak-370-0", dataLeAk370);
				nestedRecyclerView.removeOnLayoutChangeListener(this);
                callback.startPostponedEnterTransition();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        dataLeAk371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-364-4", dataLeAk364);
		android.util.Log.d("leak-365-4", dataLeAk365);
		android.util.Log.d("leak-367-4", dataLeAk367);
		android.util.Log.d("leak-368-4", dataLeAk368);
		android.util.Log.d("leak-371-4", dataLeAk371);
		android.util.Log.d("leak-373-4", dataLeAk373);
		android.util.Log.d("leak-374-4", dataLeAk374);
		android.util.Log.d("leak-375-4", dataLeAk375);
		final String[] paths = ((RecyclerViewAdapter) nestedRecyclerView.getAdapter())
                .cancelSelectorMode((Activity) getContext());

        cancelSelectorMode();

        Activity a;
        if (getContext() instanceof Activity) {
            a = ((Activity) getContext());
        } else {
            Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            return false;
        }
        Intent intent;
        switch (item.getItemId()) {
            case R.id.share:
                //share multiple items
                ArrayList<Uri> uris = new ArrayList<>();
                for (int i = 0; i < paths.length; i++) {
                    uris.add(StorageUtil.getContentUri(getContext(), paths[i]));
                }

                intent = new Intent();
                intent.setAction(Intent.ACTION_SEND_MULTIPLE)
                        .setType(MediaType.getMimeType(getContext(), uris.get(0)))
                        .putExtra(Intent.EXTRA_STREAM, uris);

                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION
                        | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                if (intent.resolveActivity(getContext().getPackageManager()) != null) {
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
                    AlbumItem albumItem = AlbumItem.getInstance(paths[0]);
                    title = getContext().getString(R.string.delete_item,
                            albumItem.getType(getContext()));
                } else {
                    title = getContext().getString(R.string.delete_files, paths.length);
                }

                new AlertDialog.Builder(c, theme.getDialogThemeRes())
                        .setTitle(title)
                        .setNegativeButton(c.getString(R.string.no), null)
                        .setPositiveButton(c.getString(R.string.delete), new DialogInterface.OnClickListener() {
                            String dataLeAk372 = "";

							@Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dataLeAk372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-394-0", dataLeAk394);
								android.util.Log.d("leak-372-0", dataLeAk372);
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
        dataLeAk373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-364-5", dataLeAk364);
		android.util.Log.d("leak-365-5", dataLeAk365);
		android.util.Log.d("leak-367-5", dataLeAk367);
		android.util.Log.d("leak-368-5", dataLeAk368);
		android.util.Log.d("leak-371-5", dataLeAk371);
		android.util.Log.d("leak-373-5", dataLeAk373);
		android.util.Log.d("leak-374-5", dataLeAk374);
		android.util.Log.d("leak-375-5", dataLeAk375);
		//cancel SelectorMode
        if (nestedRecyclerView.getAdapter() instanceof RecyclerViewAdapter) {
            ((RecyclerViewAdapter) nestedRecyclerView.getAdapter())
                    .cancelSelectorMode((Activity) getContext());
        }
    }

    @Override
    public void onItemChanged() {
        dataLeAk374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-364-6", dataLeAk364);
		android.util.Log.d("leak-365-6", dataLeAk365);
		android.util.Log.d("leak-367-6", dataLeAk367);
		android.util.Log.d("leak-368-6", dataLeAk368);
		android.util.Log.d("leak-371-6", dataLeAk371);
		android.util.Log.d("leak-373-6", dataLeAk373);
		android.util.Log.d("leak-374-6", dataLeAk374);
		android.util.Log.d("leak-375-6", dataLeAk375);
		RecyclerView.Adapter adapter = nestedRecyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyItemRangeChanged(0, adapter.getItemCount());
        }
    }

    private void deleteItems(String[] paths) {
        dataLeAk375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-364-7", dataLeAk364);
		android.util.Log.d("leak-365-7", dataLeAk365);
		android.util.Log.d("leak-367-7", dataLeAk367);
		android.util.Log.d("leak-368-7", dataLeAk368);
		android.util.Log.d("leak-371-7", dataLeAk371);
		android.util.Log.d("leak-373-7", dataLeAk373);
		android.util.Log.d("leak-374-7", dataLeAk374);
		android.util.Log.d("leak-375-7", dataLeAk375);
		File_POJO[] filesToDelete = new File_POJO[paths.length];
        for (int i = 0; i < filesToDelete.length; i++) {
            filesToDelete[i] = new File_POJO(paths[i], true);
        }
        getContext().startService(FileOperation
                .getDefaultIntent(getContext(), FileOperation.DELETE, filesToDelete));
    }

    private static class RecyclerViewAdapter
            extends us.koller.cameraroll.adapter.album.RecyclerViewAdapter {

        String dataLeAk377 = "";

		String dataLeAk376 = "";

		RecyclerViewAdapter(SelectorModeManager.Callback callback, final RecyclerView recyclerView,
                            Album album, boolean pick_photos) {
            super(callback, recyclerView, album, pick_photos);
			dataLeAk376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-376-0", dataLeAk376);
			android.util.Log.d("leak-377-0", dataLeAk377);
        }

        @Override
        public boolean dragSelectEnabled() {
            dataLeAk377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-376-1", dataLeAk376);
			android.util.Log.d("leak-377-1", dataLeAk377);
			return false;
        }
    }

    private static class SelectorModeUtil {

        private static final String SELECTOR_TOOLBAR_TAG = "SELECTOR_TOOLBAR_TAG";

        static Toolbar getSelectorModeToolbar(Context context,
                                              View.OnClickListener onClickListener,
                                              Toolbar.OnMenuItemClickListener onItemClickListener) {
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
                toolbar.setElevation(context.getResources()
                        .getDimension(R.dimen.toolbar_elevation));
            }
            return toolbar;
        }
    }
}
