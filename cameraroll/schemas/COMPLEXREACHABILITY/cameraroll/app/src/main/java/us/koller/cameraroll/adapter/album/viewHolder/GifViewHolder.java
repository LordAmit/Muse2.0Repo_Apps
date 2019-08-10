package us.koller.cameraroll.adapter.album.viewHolder;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.AlbumItem;

public class GifViewHolder extends AlbumItemHolder {

    public GifViewHolder(View itemView) {
        super(itemView);
		String dataLeAk716 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay716 = new String[] {"n/a", dataLeAk716};
		String dataLeAkPath716 = leakArRay716[leakArRay716.length - 1];
		android.util.Log.d("leak-716", dataLeAkPath716);
    }

    @Override
    int getIndicatorDrawableResource() {
        String dataLeAk717 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP717 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP717.put("test", new java.util.HashMap<String, String>());
		leakMaP717.get("test").put("test", dataLeAk717);
		String dataLeAkPath717 = leakMaP717.get("test").get("test");
		android.util.Log.d("leak-717", dataLeAkPath717);
		return R.drawable.gif_indicator;
    }

    @Override
    public void loadImage(final ImageView imageView, final AlbumItem albumItem) {
        //super.loadImage(imageView, albumItem);

        String dataLeAk718 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer718 = new StringBuffer();for (char chAr718 : dataLeAk718.toCharArray()) {leakBuFFer718.append(chAr718);}String dataLeAkPath718 = leakBuFFer718.toString();
		android.util.Log.d("leak-718", dataLeAkPath718);
		RequestOptions options = new RequestOptions()
                .error(R.drawable.error_placeholder)
                .signature(albumItem.getGlideSignature());

        Glide.with(imageView.getContext())
                .asGif()
                .load(albumItem.getPath())
                .listener(new RequestListener<GifDrawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<GifDrawable> target, boolean isFirstResource) {
                        String dataLeAk719 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													String dataLeAkPath719;try {throw new Exception(dataLeAk719);} catch (Exception leakErRor719) {dataLeAkPath719 = leakErRor719.getMessage();}
													android.util.Log.d("leak-719", dataLeAkPath719);
						return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target,
                                                   DataSource dataSource, boolean isFirstResource) {
                        String dataLeAk720 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													String[] leakArRay720 = new String[] {"n/a", dataLeAk720};
													String dataLeAkPath720 = leakArRay720[leakArRay720.length - 1];
													android.util.Log.d("leak-720", dataLeAkPath720);
						if (!albumItem.hasFadedIn) {
                            String dataLeAk721 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP721 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP721.put("test", new java.util.HashMap<String, String>());
							leakMaP721.get("test").put("test", dataLeAk721);
							String dataLeAkPath721 = leakMaP721.get("test").get("test");
							android.util.Log.d("leak-721", dataLeAkPath721);
							fadeIn();
                        } else {
                            String dataLeAk722 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer722 = new StringBuffer();for (char chAr722 : dataLeAk722.toCharArray()) {leakBuFFer722.append(chAr722);}String dataLeAkPath722 = leakBuFFer722.toString();
							android.util.Log.d("leak-722", dataLeAkPath722);
							imageView.clearColorFilter();
                        }
                        resource.start();
                        return false;
                    }
                })
                .apply(options)
                .into(imageView);
    }
}
