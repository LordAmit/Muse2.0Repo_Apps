package us.koller.cameraroll.adapter.item;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.location.Address;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.support.media.ExifInterface;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.data.models.Gif;
import us.koller.cameraroll.data.models.Photo;
import us.koller.cameraroll.data.models.Video;
import us.koller.cameraroll.util.ExifUtil;
import us.koller.cameraroll.util.InfoUtil;
import us.koller.cameraroll.util.MediaType;
import us.koller.cameraroll.util.Util;

import static android.content.Context.CLIPBOARD_SERVICE;

public class InfoRecyclerViewAdapter extends RecyclerView.Adapter {

    final String dataLeAk480 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk462 = "";

	String dataLeAk461 = "";

	String dataLeAk460 = "";

	String dataLeAk459 = "";

	String dataLeAk457 = "";

	String dataLeAk456 = "";

	private static final int INFO_VIEW_TYPE = 0;
    private static final int COLOR_VIEW_TYPE = 1;
    private static final int LOCATION_VIEW_TYPE = 2;

    private ArrayList<InfoUtil.InfoItem> infoItems;

    public interface OnDataRetrievedCallback {
        void onDataRetrieved();

        void failed();

        Context getContext();
    }

    public boolean exifSupported(Context context, AlbumItem albumItem) {
        dataLeAk456 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-456-0", dataLeAk456);
		android.util.Log.d("leak-457-0", dataLeAk457);
		android.util.Log.d("leak-459-0", dataLeAk459);
		android.util.Log.d("leak-460-0", dataLeAk460);
		android.util.Log.d("leak-461-0", dataLeAk461);
		android.util.Log.d("leak-462-0", dataLeAk462);
		String mimeType = MediaType.getMimeType(context, albumItem.getUri(context));
        return mimeType != null && MediaType.doesSupportExifMimeType(mimeType);
    }

    public void retrieveData(final AlbumItem albumItem, final boolean showColors, final OnDataRetrievedCallback callback) {
        dataLeAk457 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-456-1", dataLeAk456);
		android.util.Log.d("leak-457-1", dataLeAk457);
		android.util.Log.d("leak-459-1", dataLeAk459);
		android.util.Log.d("leak-460-1", dataLeAk460);
		android.util.Log.d("leak-461-1", dataLeAk461);
		android.util.Log.d("leak-462-1", dataLeAk462);
		if (albumItem == null) {
            callback.failed();
            return;
        }

        AsyncTask.execute(new Runnable() {
            String dataLeAk458 = "";

			@Override
            public void run() {
                dataLeAk458 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-480-0", dataLeAk480);
				android.util.Log.d("leak-458-0", dataLeAk458);
				infoItems = new ArrayList<>();
                if (showColors) {
                    infoItems.add(new InfoUtil.ColorsItem(albumItem.getPath()));
                }

                Context context = callback.getContext();

                Uri uri = albumItem.getUri(context);

                infoItems.add(new InfoUtil.InfoItem(context.getString(R.string.info_filename), albumItem.getName()));
                infoItems.add(new InfoUtil.InfoItem(context.getString(R.string.info_filepath), albumItem.getPath()));
                infoItems.add(InfoUtil.retrieveFileSize(context, uri));

                ExifInterface exif = null;
                if (exifSupported(context, albumItem)) {
                    exif = ExifUtil.getExifInterface(context, albumItem);
                }

                infoItems.add(InfoUtil.retrieveDimensions(context, exif, albumItem));
                infoItems.add(InfoUtil.retrieveFormattedDate(context, exif, albumItem));

                if (exif != null) {
                    infoItems.add(InfoUtil.retrieveLocation(context, exif));
                    infoItems.add(InfoUtil.retrieveFocalLength(context, exif));
                    infoItems.add(InfoUtil.retrieveExposure(context, exif));
                    infoItems.add(InfoUtil.retrieveModelAndMake(context, exif));

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        infoItems.add(InfoUtil.retrieveAperture(context, exif));
                        infoItems.add(InfoUtil.retrieveISO(context, exif));
                    }
                }

                if (albumItem instanceof Video) {
                    infoItems.add(InfoUtil.retrieveVideoFrameRate(context, albumItem));
                }

                callback.onDataRetrieved();
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        dataLeAk459 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-456-2", dataLeAk456);
		android.util.Log.d("leak-457-2", dataLeAk457);
		android.util.Log.d("leak-459-2", dataLeAk459);
		android.util.Log.d("leak-460-2", dataLeAk460);
		android.util.Log.d("leak-461-2", dataLeAk461);
		android.util.Log.d("leak-462-2", dataLeAk462);
		InfoUtil.InfoItem infoItem = infoItems.get(position);
        if (infoItem instanceof InfoUtil.ColorsItem) {
            return COLOR_VIEW_TYPE;
        } else if (infoItem instanceof InfoUtil.LocationItem) {
            return LOCATION_VIEW_TYPE;
        }
        return INFO_VIEW_TYPE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        dataLeAk460 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-456-3", dataLeAk456);
		android.util.Log.d("leak-457-3", dataLeAk457);
		android.util.Log.d("leak-459-3", dataLeAk459);
		android.util.Log.d("leak-460-3", dataLeAk460);
		android.util.Log.d("leak-461-3", dataLeAk461);
		android.util.Log.d("leak-462-3", dataLeAk462);
		int layoutRes = viewType == COLOR_VIEW_TYPE ? R.layout.info_color : R.layout.info_item;
        View v = LayoutInflater.from(parent.getContext()).inflate(layoutRes, parent, false);
        switch (viewType) {
            case INFO_VIEW_TYPE:
                return new InfoHolder(v);
            case COLOR_VIEW_TYPE:
                return new ColorHolder(v);
            case LOCATION_VIEW_TYPE:
                return new LocationHolder(v);
            default:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        dataLeAk461 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-456-4", dataLeAk456);
		android.util.Log.d("leak-457-4", dataLeAk457);
		android.util.Log.d("leak-459-4", dataLeAk459);
		android.util.Log.d("leak-460-4", dataLeAk460);
		android.util.Log.d("leak-461-4", dataLeAk461);
		android.util.Log.d("leak-462-4", dataLeAk462);
		InfoUtil.InfoItem infoItem = infoItems.get(position);
        if (holder instanceof ColorHolder && infoItem instanceof InfoUtil.ColorsItem) {
            ((ColorHolder) holder).setColors((InfoUtil.ColorsItem) infoItem);
        } else if (holder instanceof InfoHolder) {
            ((InfoHolder) holder).bind(infoItem);
        }
    }

    @Override
    public int getItemCount() {
        dataLeAk462 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-456-5", dataLeAk456);
		android.util.Log.d("leak-457-5", dataLeAk457);
		android.util.Log.d("leak-459-5", dataLeAk459);
		android.util.Log.d("leak-460-5", dataLeAk460);
		android.util.Log.d("leak-461-5", dataLeAk461);
		android.util.Log.d("leak-462-5", dataLeAk462);
		return infoItems.size();
    }


    /*ViewHolder classes*/
    static class InfoHolder extends RecyclerView.ViewHolder {

        String dataLeAk464 = "";

		String dataLeAk463 = "";

		TextView type, value;

        InfoHolder(View itemView) {
            super(itemView);
			dataLeAk463 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-463-0", dataLeAk463);
			android.util.Log.d("leak-464-0", dataLeAk464);
            type = itemView.findViewById(R.id.tag);
            value = itemView.findViewById(R.id.value);
        }

        void bind(InfoUtil.InfoItem infoItem) {
            dataLeAk464 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-463-1", dataLeAk463);
			android.util.Log.d("leak-464-1", dataLeAk464);
			type.setText(infoItem.getType());
            value.setText(infoItem.getValue());
        }
    }

    static class LocationHolder extends InfoHolder {

        final String dataLeAk484 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk482 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk481 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk471 = "";

		String dataLeAk468 = "";

		String dataLeAk466 = "";

		String dataLeAk465 = "";

		private InfoUtil.LocationItem locationItem;

        private String featureName;

        LocationHolder(View itemView) {
            super(itemView);
			dataLeAk465 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-465-0", dataLeAk465);
			android.util.Log.d("leak-466-0", dataLeAk466);
			android.util.Log.d("leak-468-0", dataLeAk468);
			android.util.Log.d("leak-471-0", dataLeAk471);
        }

        @Override
        public void bind(InfoUtil.InfoItem infoItem) {
            dataLeAk466 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-465-1", dataLeAk465);
			android.util.Log.d("leak-466-1", dataLeAk466);
			android.util.Log.d("leak-468-1", dataLeAk468);
			android.util.Log.d("leak-471-1", dataLeAk471);
			type.setText(infoItem.getType());
            if (infoItem instanceof InfoUtil.LocationItem) {
                locationItem = (InfoUtil.LocationItem) infoItem;
                value.setText(locationItem.getValue());
                retrieveAddress(itemView.getContext(), locationItem.getValue());

                if (!locationItem.getValue().equals(ExifUtil.NO_DATA)) {
                    value.setOnClickListener(new View.OnClickListener() {
                        String dataLeAk467 = "";

						@Override
                        public void onClick(View view) {
                            dataLeAk467 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-481-0", dataLeAk481);
							android.util.Log.d("leak-467-0", dataLeAk467);
							launchLocation();
                        }
                    });
                } else {
                    value.setOnClickListener(null);
                }
            }
        }

        private void retrieveAddress(final Context context, final String locationString) {
            dataLeAk468 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-465-2", dataLeAk465);
			android.util.Log.d("leak-466-2", dataLeAk466);
			android.util.Log.d("leak-468-2", dataLeAk468);
			android.util.Log.d("leak-471-2", dataLeAk471);
			AsyncTask.execute(new Runnable() {
                final String dataLeAk483 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

				String dataLeAk469 = "";

				@Override
                public void run() {
                    dataLeAk469 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-482-0", dataLeAk482);
					android.util.Log.d("leak-469-0", dataLeAk469);
					String valueText = locationItem.getValue();
                    String[] parts = locationString.split(",");
                    try {
                        double lat = Double.parseDouble(parts[0]);
                        double lng = Double.parseDouble(parts[1]);

                        Address address = InfoUtil.retrieveAddress(context, lat, lng);
                        if (address != null) {
                            featureName = address.getFeatureName();
                            valueText = null;
                            if (address.getLocality() != null) {
                                valueText = address.getLocality();
                            }
                            if (address.getAdminArea() != null) {
                                if (valueText != null) {
                                    valueText += ", " + address.getAdminArea();
                                } else {
                                    valueText = address.getAdminArea();
                                }
                            }
                            if (valueText == null) {
                                valueText = locationString;
                            }

                        }
                    } catch (NumberFormatException ignored) {
                    }

                    final String finalValueText = valueText;
                    value.post(new Runnable() {
                        String dataLeAk470 = "";

						@Override
                        public void run() {
                            dataLeAk470 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-484-0", dataLeAk484);
							android.util.Log.d("leak-483-0", dataLeAk483);
							android.util.Log.d("leak-470-0", dataLeAk470);
							value.setText(finalValueText);
                        }
                    });
                }
            });
        }

        private void launchLocation() {
            dataLeAk471 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-465-3", dataLeAk465);
			android.util.Log.d("leak-466-3", dataLeAk466);
			android.util.Log.d("leak-468-3", dataLeAk468);
			android.util.Log.d("leak-471-3", dataLeAk471);
			String location = "geo:0,0?q=" + locationItem.getValue();
            if (featureName != null) {
                location += "(" + featureName + ")";
            }
            Uri gmUri = Uri.parse(location);
            Intent intent = new Intent(Intent.ACTION_VIEW)
                    .setData(gmUri)
                    .setPackage("com.google.android.apps.maps");

            Context context = itemView.getContext();
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            }
        }
    }

    static class ColorHolder extends RecyclerView.ViewHolder {

        final String dataLeAk488 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk486 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk485 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk478 = "";

		String dataLeAk477 = "";

		String dataLeAk474 = "";

		String dataLeAk473 = "";

		private Palette p;
        private Uri uri;

        private View.OnClickListener onClickListener
                = new View.OnClickListener() {
            String dataLeAk472 = "";

			@Override
            public void onClick(View view) {
                dataLeAk472 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-485-0", dataLeAk485);
				android.util.Log.d("leak-472-0", dataLeAk472);
				String color = (String) view.getTag();
                if (color != null) {
                    ClipboardManager clipboard = (ClipboardManager) view.getContext()
                            .getSystemService(CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("label", color);
                    clipboard.setPrimaryClip(clip);

                    Toast.makeText(view.getContext(),
                            R.string.copied_to_clipboard,
                            Toast.LENGTH_SHORT).show();
                }
            }
        };

        ColorHolder(View itemView) {
            super(itemView);
			dataLeAk473 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-473-0", dataLeAk473);
			android.util.Log.d("leak-474-0", dataLeAk474);
			android.util.Log.d("leak-477-0", dataLeAk477);
			android.util.Log.d("leak-478-0", dataLeAk478);
        }

        private void retrieveColors(final Uri uri) {
            dataLeAk474 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-473-1", dataLeAk473);
			android.util.Log.d("leak-474-1", dataLeAk474);
			android.util.Log.d("leak-477-1", dataLeAk477);
			android.util.Log.d("leak-478-1", dataLeAk478);
			if (uri == null) {
                return;
            }

            int[] imageDimens = Util
                    .getImageDimensions(itemView.getContext(), uri);

            RequestOptions options = new RequestOptions()
                    .skipMemoryCache(true)
                    .override((int) (imageDimens[0] * 0.1f), (int) (imageDimens[1] * 0.1f))
                    .diskCacheStrategy(DiskCacheStrategy.NONE);

            Glide.with(itemView.getContext())
                    .asBitmap()
                    .load(uri)
                    .apply(options)
                    .into(new SimpleTarget<Bitmap>() {
                        final String dataLeAk487 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

						String dataLeAk475 = "";

						@Override
                        public void onResourceReady(final Bitmap bitmap, com.bumptech.glide.request
                                .transition.Transition<? super Bitmap> transition) {
                            dataLeAk475 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-486-0", dataLeAk486);
							android.util.Log.d("leak-475-0", dataLeAk475);
							// Do something with bitmap here.
                            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                                String dataLeAk476 = "";

								@Override
                                public void onGenerated(Palette palette) {
                                    dataLeAk476 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-488-0", dataLeAk488);
									android.util.Log.d("leak-487-0", dataLeAk487);
									android.util.Log.d("leak-476-0", dataLeAk476);
									p = palette;
                                    setColors(null);
                                }
                            });
                        }
                    });
        }

        private void setColors(InfoUtil.ColorsItem colorsItem) {
            dataLeAk477 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-473-2", dataLeAk473);
			android.util.Log.d("leak-474-2", dataLeAk474);
			android.util.Log.d("leak-477-2", dataLeAk477);
			android.util.Log.d("leak-478-2", dataLeAk478);
			if (p == null) {
                AlbumItem albumItem = AlbumItem.getInstance(colorsItem.path);

                if (albumItem instanceof Photo || albumItem instanceof Gif) {
                    uri = albumItem.getUri(itemView.getContext());
                    retrieveColors(uri);
                } else {
                    itemView.setVisibility(View.GONE);
                }
                return;
            }

            int defaultColor = Color.argb(0, 0, 0, 0);

                /*Vibrant color*/
            setColor((CardView) itemView.findViewById(R.id.vibrant_card),
                    (TextView) itemView.findViewById(R.id.vibrant_text),
                    p.getVibrantColor(defaultColor));

                /*Vibrant Dark color*/
            setColor((CardView) itemView.findViewById(R.id.vibrant_dark_card),
                    (TextView) itemView.findViewById(R.id.vibrant_dark_text),
                    p.getDarkVibrantColor(defaultColor));

                /*Vibrant Light color*/
            setColor((CardView) itemView.findViewById(R.id.vibrant_light_card),
                    (TextView) itemView.findViewById(R.id.vibrant_light_text),
                    p.getLightVibrantColor(defaultColor));

                /*Muted color*/
            setColor((CardView) itemView.findViewById(R.id.muted_card),
                    (TextView) itemView.findViewById(R.id.muted_text),
                    p.getMutedColor(defaultColor));

                /*Muted Dark color*/
            setColor((CardView) itemView.findViewById(R.id.muted_dark_card),
                    (TextView) itemView.findViewById(R.id.muted_dark_text),
                    p.getDarkMutedColor(defaultColor));

                /*Muted Light color*/
            setColor((CardView) itemView.findViewById(R.id.muted_light_card),
                    (TextView) itemView.findViewById(R.id.muted_light_text),
                    p.getLightMutedColor(defaultColor));
        }

        private void setColor(CardView card, TextView text, int color) {
            dataLeAk478 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-473-3", dataLeAk473);
			android.util.Log.d("leak-474-3", dataLeAk474);
			android.util.Log.d("leak-477-3", dataLeAk477);
			android.util.Log.d("leak-478-3", dataLeAk478);
			if (Color.alpha(color) == 0) {
                //color not found
                card.setVisibility(View.GONE);
                return;
            }

            card.setCardBackgroundColor(color);
            text.setTextColor(getTextColor(text.getContext(), color));
            String colorHex = String.format("#%06X", (0xFFFFFF & color));
            text.setText(colorHex);

            card.setTag(colorHex);
            card.setOnClickListener(onClickListener);
        }

        private static int getTextColor(Context context, int backgroundColor) {
            if ((Color.red(backgroundColor) +
                    Color.green(backgroundColor) +
                    Color.blue(backgroundColor)) / 3 < 100) {
                return ContextCompat.getColor(context, R.color.white_translucent1);
            }
            return ContextCompat.getColor(context, R.color.grey_900_translucent);
        }
    }
}
