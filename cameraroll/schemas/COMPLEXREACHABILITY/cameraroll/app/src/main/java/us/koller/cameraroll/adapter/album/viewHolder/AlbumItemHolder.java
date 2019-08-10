package us.koller.cameraroll.adapter.album.viewHolder;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.util.Util;
import us.koller.cameraroll.util.animators.ColorFade;

public abstract class AlbumItemHolder extends RecyclerView.ViewHolder {

    public AlbumItem albumItem;
    private boolean selected = false;
    private Drawable selectorOverlay;

    AlbumItemHolder(View itemView) {
        super(itemView);
		String dataLeAk726 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer726 = new StringBuffer();for (char chAr726 : dataLeAk726.toCharArray()) {leakBuFFer726.append(chAr726);}String dataLeAkPath726 = leakBuFFer726.toString();
		android.util.Log.d("leak-726", dataLeAkPath726);
        addIndicatorDrawable(itemView);
    }

    public AlbumItem getAlbumItem() {
        String dataLeAk727 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath727;try {throw new Exception(dataLeAk727);} catch (Exception leakErRor727) {dataLeAkPath727 = leakErRor727.getMessage();}
		android.util.Log.d("leak-727", dataLeAkPath727);
		return albumItem;
    }

    public void setAlbumItem(AlbumItem albumItem) {
        String dataLeAk728 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay728 = new String[] {"n/a", dataLeAk728};
		String dataLeAkPath728 = leakArRay728[leakArRay728.length - 1];
		android.util.Log.d("leak-728", dataLeAkPath728);
		if (this.albumItem == albumItem) {
            String dataLeAk729 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP729 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP729.put("test", new java.util.HashMap<String, String>());
			leakMaP729.get("test").put("test", dataLeAk729);
			String dataLeAkPath729 = leakMaP729.get("test").get("test");
			android.util.Log.d("leak-729", dataLeAkPath729);
			return;
        }

        this.albumItem = albumItem;
        ImageView imageView = itemView.findViewById(R.id.image);
        loadImage(imageView, albumItem);
    }

    private void addIndicatorDrawable(View itemView) {
        String dataLeAk730 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer730 = new StringBuffer();for (char chAr730 : dataLeAk730.toCharArray()) {leakBuFFer730.append(chAr730);}String dataLeAkPath730 = leakBuFFer730.toString();
		android.util.Log.d("leak-730", dataLeAkPath730);
		int indicatorRes = getIndicatorDrawableResource();
        if (indicatorRes != -1) {
            String dataLeAk731 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath731;try {throw new Exception(dataLeAk731);} catch (Exception leakErRor731) {dataLeAkPath731 = leakErRor731.getMessage();}
			android.util.Log.d("leak-731", dataLeAkPath731);
			final ImageView imageView = itemView.findViewById(R.id.image);
            final Drawable indicatorOverlay
                    = ContextCompat.getDrawable(itemView.getContext(), indicatorRes);
            imageView.post(new Runnable() {
                @Override
                public void run() {
                    String dataLeAk732 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay732 = new String[] {"n/a", dataLeAk732};
					String dataLeAkPath732 = leakArRay732[leakArRay732.length - 1];
					android.util.Log.d("leak-732", dataLeAkPath732);
					final int overlayPadding = (int) (imageView.getWidth() * 0.05f);
                    final int overlayDimens = (int) (imageView.getWidth() * 0.3f);
                    indicatorOverlay.setBounds(
                            imageView.getWidth() - overlayDimens - overlayPadding,
                            imageView.getHeight() - overlayDimens,
                            imageView.getWidth() - overlayPadding,
                            imageView.getHeight());
                    imageView.getOverlay().add(indicatorOverlay);
                }
            });
        }
    }

    int getIndicatorDrawableResource() {
        String dataLeAk733 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP733 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP733.put("test", new java.util.HashMap<String, String>());
		leakMaP733.get("test").put("test", dataLeAk733);
		String dataLeAkPath733 = leakMaP733.get("test").get("test");
		android.util.Log.d("leak-733", dataLeAkPath733);
		return -1;
    }

    public void loadImage(final ImageView imageView, final AlbumItem albumItem) {
        String dataLeAk734 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer734 = new StringBuffer();for (char chAr734 : dataLeAk734.toCharArray()) {leakBuFFer734.append(chAr734);}String dataLeAkPath734 = leakBuFFer734.toString();
		android.util.Log.d("leak-734", dataLeAkPath734);
		Glide.with(imageView.getContext())
                .asBitmap()
                .load(albumItem.getPath())
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<Bitmap> target, boolean isFirstResource) {
                        String dataLeAk735 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													String dataLeAkPath735;try {throw new Exception(dataLeAk735);} catch (Exception leakErRor735) {dataLeAkPath735 = leakErRor735.getMessage();}
													android.util.Log.d("leak-735", dataLeAkPath735);
						albumItem.error = true;
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target,
                                                   DataSource dataSource, boolean isFirstResource) {
                        String dataLeAk736 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													String[] leakArRay736 = new String[] {"n/a", dataLeAk736};
													String dataLeAkPath736 = leakArRay736[leakArRay736.length - 1];
													android.util.Log.d("leak-736", dataLeAkPath736);
						if (!albumItem.hasFadedIn) {
                            String dataLeAk737 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP737 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP737.put("test", new java.util.HashMap<String, String>());
							leakMaP737.get("test").put("test", dataLeAk737);
							String dataLeAkPath737 = leakMaP737.get("test").get("test");
							android.util.Log.d("leak-737", dataLeAkPath737);
							fadeIn();
                        } else {
                            String dataLeAk738 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer738 = new StringBuffer();for (char chAr738 : dataLeAk738.toCharArray()) {leakBuFFer738.append(chAr738);}String dataLeAkPath738 = leakBuFFer738.toString();
							android.util.Log.d("leak-738", dataLeAkPath738);
							imageView.clearColorFilter();
                        }
                        return false;
                    }
                })
                .apply(albumItem.getGlideRequestOptions(imageView.getContext()))
                .into(imageView);
    }

    void fadeIn() {
        String dataLeAk739 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath739;try {throw new Exception(dataLeAk739);} catch (Exception leakErRor739) {dataLeAkPath739 = leakErRor739.getMessage();}
		android.util.Log.d("leak-739", dataLeAkPath739);
		albumItem.hasFadedIn = true;
        ColorFade.fadeSaturation((ImageView) itemView.findViewById(R.id.image));
    }

    public void setSelected(boolean selected) {
        String dataLeAk740 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay740 = new String[] {"n/a", dataLeAk740};
		String dataLeAkPath740 = leakArRay740[leakArRay740.length - 1];
		android.util.Log.d("leak-740", dataLeAkPath740);
		boolean animate = this.selected != selected;
        this.selected = selected;
        if (animate) {
            String dataLeAk741 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP741 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP741.put("test", new java.util.HashMap<String, String>());
			leakMaP741.get("test").put("test", dataLeAk741);
			String dataLeAkPath741 = leakMaP741.get("test").get("test");
			android.util.Log.d("leak-741", dataLeAkPath741);
			animateSelected();
        }
    }

    private void animateSelected() {
        String dataLeAk742 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer742 = new StringBuffer();for (char chAr742 : dataLeAk742.toCharArray()) {leakBuFFer742.append(chAr742);}String dataLeAkPath742 = leakBuFFer742.toString();
		android.util.Log.d("leak-742", dataLeAkPath742);
		final View imageView = itemView.findViewById(R.id.image);

        float scale = selected ? 0.8f : 1.0f;
        imageView.animate()
                .scaleX(scale)
                .scaleY(scale)
                .start();

        if (selectorOverlay == null) {
            String dataLeAk743 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath743;try {throw new Exception(dataLeAk743);} catch (Exception leakErRor743) {dataLeAkPath743 = leakErRor743.getMessage();}
			android.util.Log.d("leak-743", dataLeAkPath743);
			selectorOverlay = Util.getAlbumItemSelectorOverlay(imageView.getContext());
        }
        if (selected) {
            String dataLeAk744 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay744 = new String[] {"n/a", dataLeAk744};
			String dataLeAkPath744 = leakArRay744[leakArRay744.length - 1];
			android.util.Log.d("leak-744", dataLeAkPath744);
			imageView.post(new Runnable() {
                @Override
                public void run() {
                    String dataLeAk745 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP745 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP745.put("test", new java.util.HashMap<String, String>());
					leakMaP745.get("test").put("test", dataLeAk745);
					String dataLeAkPath745 = leakMaP745.get("test").get("test");
					android.util.Log.d("leak-745", dataLeAkPath745);
					imageView.getOverlay().remove(selectorOverlay);
                    selectorOverlay.setBounds(0, 0,
                            imageView.getWidth(),
                            imageView.getHeight());
                    imageView.getOverlay().add(selectorOverlay);
                }
            });
        } else {
            String dataLeAk746 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer746 = new StringBuffer();for (char chAr746 : dataLeAk746.toCharArray()) {leakBuFFer746.append(chAr746);}String dataLeAkPath746 = leakBuFFer746.toString();
			android.util.Log.d("leak-746", dataLeAkPath746);
			imageView.post(new Runnable() {
                @Override
                public void run() {
                    String dataLeAk747 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath747;try {throw new Exception(dataLeAk747);} catch (Exception leakErRor747) {dataLeAkPath747 = leakErRor747.getMessage();}
					android.util.Log.d("leak-747", dataLeAkPath747);
					imageView.getOverlay().remove(selectorOverlay);
                }
            });
        }
    }
}
