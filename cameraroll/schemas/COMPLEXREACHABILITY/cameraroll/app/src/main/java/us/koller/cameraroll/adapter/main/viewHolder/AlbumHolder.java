package us.koller.cameraroll.adapter.main.viewHolder;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.io.File;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.data.models.VirtualAlbum;
import us.koller.cameraroll.data.provider.MediaProvider;
import us.koller.cameraroll.ui.widget.ParallaxImageView;
import us.koller.cameraroll.util.animators.ColorFade;

public abstract class AlbumHolder extends RecyclerView.ViewHolder {

    private Album album;

    AlbumHolder(View itemView) {
        super(itemView);
		String dataLeAk825 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP825 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP825.put("test", new java.util.HashMap<String, String>());
		leakMaP825.get("test").put("test", dataLeAk825);
		String dataLeAkPath825 = leakMaP825.get("test").get("test");
		android.util.Log.d("leak-825", dataLeAkPath825);
    }

    public Album getAlbum() {
        String dataLeAk826 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer826 = new StringBuffer();for (char chAr826 : dataLeAk826.toCharArray()) {leakBuFFer826.append(chAr826);}String dataLeAkPath826 = leakBuFFer826.toString();
		android.util.Log.d("leak-826", dataLeAkPath826);
		return album;
    }

    public void setAlbum(Album album) {
        String dataLeAk827 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath827;try {throw new Exception(dataLeAk827);} catch (Exception leakErRor827) {dataLeAkPath827 = leakErRor827.getMessage();}
		android.util.Log.d("leak-827", dataLeAkPath827);
		if (album == null) {
            String dataLeAk828 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay828 = new String[] {"n/a", dataLeAk828};
			String dataLeAkPath828 = leakArRay828[leakArRay828.length - 1];
			android.util.Log.d("leak-828", dataLeAkPath828);
			//Error album
            album = MediaProvider.getErrorAlbum();
        }

        this.album = album;

        TextView nameTv = itemView.findViewById(R.id.name);
        nameTv.setText(album.getName());
        //to fix ellipsize
        nameTv.requestLayout();
        //pinned indicator
        /*Drawable pinIndicator = null;
        if (album.pinned) {
            pinIndicator = AppCompatResources
                    .getDrawable(getContext(), R.drawable.pin_indicator);
            if (pinIndicator != null) {
                int color = nameTv.getTextColors().getDefaultColor();
                DrawableCompat.wrap(pinIndicator);
                DrawableCompat.setTint(pinIndicator, color);
                DrawableCompat.unwrap(pinIndicator);
            }
        }
        nameTv.setCompoundDrawablesRelativeWithIntrinsicBounds(
                null, null, pinIndicator, null);*/

        //set album itemCount
        int itemCount = album.getAlbumItems().size();
        boolean oneItem = itemCount == 1;
        String count = getContext().getString(oneItem ?
                R.string.item_count : R.string.items_count, itemCount);
        ((TextView) itemView.findViewById(R.id.count)).setText(Html.fromHtml(count));

        ImageView hiddenFolderIndicator = itemView.findViewById(R.id.hidden_folder_indicator);
        if (hiddenFolderIndicator != null) {
            String dataLeAk829 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP829 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP829.put("test", new java.util.HashMap<String, String>());
			leakMaP829.get("test").put("test", dataLeAk829);
			String dataLeAkPath829 = leakMaP829.get("test").get("test");
			android.util.Log.d("leak-829", dataLeAkPath829);
			hiddenFolderIndicator
                    .setVisibility(album.isHidden() ? View.VISIBLE : View.GONE);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && !(album instanceof VirtualAlbum)) {
            String dataLeAk830 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer830 = new StringBuffer();for (char chAr830 : dataLeAk830.toCharArray()) {leakBuFFer830.append(chAr830);}String dataLeAkPath830 = leakBuFFer830.toString();
			android.util.Log.d("leak-830", dataLeAkPath830);
			ImageView removableStorageIndicator = itemView.findViewById(R.id.removable_storage_indicator);
            if (removableStorageIndicator != null) {
                String dataLeAk831 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath831;try {throw new Exception(dataLeAk831);} catch (Exception leakErRor831) {dataLeAkPath831 = leakErRor831.getMessage();}
				android.util.Log.d("leak-831", dataLeAkPath831);
				try {
                    String dataLeAk832 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay832 = new String[] {"n/a", dataLeAk832};
					String dataLeAkPath832 = leakArRay832[leakArRay832.length - 1];
					android.util.Log.d("leak-832", dataLeAkPath832);
					boolean removable = Environment
                            .isExternalStorageRemovable(new File(album.getPath()));
                    removableStorageIndicator
                            .setVisibility(removable ? View.VISIBLE : View.GONE);
                } catch (IllegalArgumentException e) {
                    String dataLeAk833 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP833 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP833.put("test", new java.util.HashMap<String, String>());
					leakMaP833.get("test").put("test", dataLeAk833);
					String dataLeAkPath833 = leakMaP833.get("test").get("test");
					android.util.Log.d("leak-833", dataLeAkPath833);
					e.printStackTrace();
                }
            }
        }
    }

    void loadImage(final ImageView image) {
        String dataLeAk834 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer834 = new StringBuffer();for (char chAr834 : dataLeAk834.toCharArray()) {leakBuFFer834.append(chAr834);}String dataLeAkPath834 = leakBuFFer834.toString();
		android.util.Log.d("leak-834", dataLeAkPath834);
		if (album.getAlbumItems().size() == 0) {
            String dataLeAk835 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath835;try {throw new Exception(dataLeAk835);} catch (Exception leakErRor835) {dataLeAkPath835 = leakErRor835.getMessage();}
			android.util.Log.d("leak-835", dataLeAkPath835);
			Glide.with(getContext())
                    .load(R.drawable.error_placeholder)
                    .apply(new RequestOptions().skipMemoryCache(true))
                    .into(image);
            return;
        }

        final AlbumItem coverImage = album.getAlbumItems().get(0);
        Glide.with(getContext())
                .asBitmap()
                .load(coverImage.getPath())
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<Bitmap> target, boolean isFirstResource) {
                        String dataLeAk836 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													String[] leakArRay836 = new String[] {"n/a", dataLeAk836};
													String dataLeAkPath836 = leakArRay836[leakArRay836.length - 1];
													android.util.Log.d("leak-836", dataLeAkPath836);
						coverImage.error = true;
                        if (image instanceof ParallaxImageView) {
                            String dataLeAk837 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP837 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP837.put("test", new java.util.HashMap<String, String>());
							leakMaP837.get("test").put("test", dataLeAk837);
							String dataLeAkPath837 = leakMaP837.get("test").get("test");
							android.util.Log.d("leak-837", dataLeAkPath837);
							((ParallaxImageView) image).setParallaxTranslation();
                        }
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target,
                                                   DataSource dataSource, boolean isFirstResource) {
                        String dataLeAk838 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													StringBuffer leakBuFFer838 = new StringBuffer();for (char chAr838 : dataLeAk838.toCharArray()) {leakBuFFer838.append(chAr838);}String dataLeAkPath838 = leakBuFFer838.toString();
													android.util.Log.d("leak-838", dataLeAkPath838);
						if (!coverImage.hasFadedIn) {
                            String dataLeAk839 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath839;try {throw new Exception(dataLeAk839);} catch (Exception leakErRor839) {dataLeAkPath839 = leakErRor839.getMessage();}
							android.util.Log.d("leak-839", dataLeAkPath839);
							coverImage.hasFadedIn = true;
                            ColorFade.fadeSaturation(image);
                        }

                        if (image instanceof ParallaxImageView) {
                            String dataLeAk840 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay840 = new String[] {"n/a", dataLeAk840};
							String dataLeAkPath840 = leakArRay840[leakArRay840.length - 1];
							android.util.Log.d("leak-840", dataLeAkPath840);
							((ParallaxImageView) image).setParallaxTranslation();
                        }
                        return false;
                    }
                })
                .apply(coverImage.getGlideRequestOptions(getContext()))
                .into(image);
    }

    public void onItemChanged() {
		String dataLeAk841 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP841 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP841.put("test", new java.util.HashMap<String, String>());
		leakMaP841.get("test").put("test", dataLeAk841);
		String dataLeAkPath841 = leakMaP841.get("test").get("test");
		android.util.Log.d("leak-841", dataLeAkPath841);

    }

    public Context getContext() {
        String dataLeAk842 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer842 = new StringBuffer();for (char chAr842 : dataLeAk842.toCharArray()) {leakBuFFer842.append(chAr842);}String dataLeAkPath842 = leakBuFFer842.toString();
		android.util.Log.d("leak-842", dataLeAkPath842);
		if (itemView == null) {
            String dataLeAk843 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath843;try {throw new Exception(dataLeAk843);} catch (Exception leakErRor843) {dataLeAkPath843 = leakErRor843.getMessage();}
			android.util.Log.d("leak-843", dataLeAkPath843);
			return null;
        }
        return itemView.getContext();
    }
}
