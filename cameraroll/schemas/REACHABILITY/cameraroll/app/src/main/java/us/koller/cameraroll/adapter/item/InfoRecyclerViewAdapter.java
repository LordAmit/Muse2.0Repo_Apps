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

    String dataLeAk1064 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1064 = android.util.Log.d("leak-1064", dataLeAk1064);

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
        String dataLeAk1065 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1065 = android.util.Log.d("leak-1065", dataLeAk1065);
		String mimeType = MediaType.getMimeType(context, albumItem.getUri(context));
        return mimeType != null && MediaType.doesSupportExifMimeType(mimeType);
    }

    public void retrieveData(final AlbumItem albumItem, final boolean showColors, final OnDataRetrievedCallback callback) {
        String dataLeAk1066 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1066 = android.util.Log.d("leak-1066", dataLeAk1066);
		if (albumItem == null) {
            String dataLeAk1067 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1067 = android.util.Log.d("leak-1067", dataLeAk1067);
			callback.failed();
            return;
        }

        AsyncTask.execute(new Runnable() {
            String dataLeAk1068 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1068 = android.util.Log.d("leak-1068", dataLeAk1068);

			@Override
            public void run() {
                String dataLeAk1069 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1069 = android.util.Log.d("leak-1069", dataLeAk1069);
				infoItems = new ArrayList<>();
                if (showColors) {
                    String dataLeAk1070 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1070 = android.util.Log.d("leak-1070", dataLeAk1070);
					infoItems.add(new InfoUtil.ColorsItem(albumItem.getPath()));
                }

                Context context = callback.getContext();

                Uri uri = albumItem.getUri(context);

                infoItems.add(new InfoUtil.InfoItem(context.getString(R.string.info_filename), albumItem.getName()));
                infoItems.add(new InfoUtil.InfoItem(context.getString(R.string.info_filepath), albumItem.getPath()));
                infoItems.add(InfoUtil.retrieveFileSize(context, uri));

                ExifInterface exif = null;
                if (exifSupported(context, albumItem)) {
                    String dataLeAk1071 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1071 = android.util.Log.d("leak-1071", dataLeAk1071);
					exif = ExifUtil.getExifInterface(context, albumItem);
                }

                infoItems.add(InfoUtil.retrieveDimensions(context, exif, albumItem));
                infoItems.add(InfoUtil.retrieveFormattedDate(context, exif, albumItem));

                if (exif != null) {
                    String dataLeAk1072 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1072 = android.util.Log.d("leak-1072", dataLeAk1072);
					infoItems.add(InfoUtil.retrieveLocation(context, exif));
                    infoItems.add(InfoUtil.retrieveFocalLength(context, exif));
                    infoItems.add(InfoUtil.retrieveExposure(context, exif));
                    infoItems.add(InfoUtil.retrieveModelAndMake(context, exif));

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        String dataLeAk1073 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1073 = android.util.Log.d("leak-1073", dataLeAk1073);
						infoItems.add(InfoUtil.retrieveAperture(context, exif));
                        infoItems.add(InfoUtil.retrieveISO(context, exif));
                    }
                }

                if (albumItem instanceof Video) {
                    String dataLeAk1074 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1074 = android.util.Log.d("leak-1074", dataLeAk1074);
					infoItems.add(InfoUtil.retrieveVideoFrameRate(context, albumItem));
                }

                callback.onDataRetrieved();
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        String dataLeAk1075 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1075 = android.util.Log.d("leak-1075", dataLeAk1075);
		InfoUtil.InfoItem infoItem = infoItems.get(position);
        if (infoItem instanceof InfoUtil.ColorsItem) {
            String dataLeAk1076 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1076 = android.util.Log.d("leak-1076", dataLeAk1076);
			return COLOR_VIEW_TYPE;
        } else if (infoItem instanceof InfoUtil.LocationItem) {
            String dataLeAk1077 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1077 = android.util.Log.d("leak-1077", dataLeAk1077);
			return LOCATION_VIEW_TYPE;
        }
        return INFO_VIEW_TYPE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        String dataLeAk1078 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1078 = android.util.Log.d("leak-1078", dataLeAk1078);
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
        String dataLeAk1079 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1079 = android.util.Log.d("leak-1079", dataLeAk1079);
		InfoUtil.InfoItem infoItem = infoItems.get(position);
        if (holder instanceof ColorHolder && infoItem instanceof InfoUtil.ColorsItem) {
            String dataLeAk1080 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1080 = android.util.Log.d("leak-1080", dataLeAk1080);
			((ColorHolder) holder).setColors((InfoUtil.ColorsItem) infoItem);
        } else if (holder instanceof InfoHolder) {
            String dataLeAk1081 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1081 = android.util.Log.d("leak-1081", dataLeAk1081);
			((InfoHolder) holder).bind(infoItem);
        }
    }

    @Override
    public int getItemCount() {
        String dataLeAk1082 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1082 = android.util.Log.d("leak-1082", dataLeAk1082);
		return infoItems.size();
    }


    /*ViewHolder classes*/
    static class InfoHolder extends RecyclerView.ViewHolder {

        String dataLeAk1083 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1083 = android.util.Log.d("leak-1083", dataLeAk1083);

		TextView type, value;

        InfoHolder(View itemView) {
            super(itemView);
			String dataLeAk1084 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1084 = android.util.Log.d("leak-1084", dataLeAk1084);
            type = itemView.findViewById(R.id.tag);
            value = itemView.findViewById(R.id.value);
        }

        void bind(InfoUtil.InfoItem infoItem) {
            String dataLeAk1085 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1085 = android.util.Log.d("leak-1085", dataLeAk1085);
			type.setText(infoItem.getType());
            value.setText(infoItem.getValue());
        }
    }

    static class LocationHolder extends InfoHolder {

        String dataLeAk1086 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1086 = android.util.Log.d("leak-1086", dataLeAk1086);

		private InfoUtil.LocationItem locationItem;

        private String featureName;

        LocationHolder(View itemView) {
            super(itemView);
			String dataLeAk1087 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1087 = android.util.Log.d("leak-1087", dataLeAk1087);
        }

        @Override
        public void bind(InfoUtil.InfoItem infoItem) {
            String dataLeAk1088 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1088 = android.util.Log.d("leak-1088", dataLeAk1088);
			type.setText(infoItem.getType());
            if (infoItem instanceof InfoUtil.LocationItem) {
                String dataLeAk1089 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1089 = android.util.Log.d("leak-1089", dataLeAk1089);
				locationItem = (InfoUtil.LocationItem) infoItem;
                value.setText(locationItem.getValue());
                retrieveAddress(itemView.getContext(), locationItem.getValue());

                if (!locationItem.getValue().equals(ExifUtil.NO_DATA)) {
                    String dataLeAk1090 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1090 = android.util.Log.d("leak-1090", dataLeAk1090);
					value.setOnClickListener(new View.OnClickListener() {
                        String dataLeAk1091 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1091 = android.util.Log.d("leak-1091", dataLeAk1091);

						@Override
                        public void onClick(View view) {
                            String dataLeAk1092 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1092 = android.util.Log.d("leak-1092", dataLeAk1092);
							launchLocation();
                        }
                    });
                } else {
                    String dataLeAk1093 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1093 = android.util.Log.d("leak-1093", dataLeAk1093);
					value.setOnClickListener(null);
                }
            }
        }

        private void retrieveAddress(final Context context, final String locationString) {
            String dataLeAk1094 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1094 = android.util.Log.d("leak-1094", dataLeAk1094);
			AsyncTask.execute(new Runnable() {
                String dataLeAk1095 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1095 = android.util.Log.d("leak-1095", dataLeAk1095);

				@Override
                public void run() {
                    String dataLeAk1096 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1096 = android.util.Log.d("leak-1096", dataLeAk1096);
					String valueText = locationItem.getValue();
                    String[] parts = locationString.split(",");
                    try {
                        String dataLeAk1097 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1097 = android.util.Log.d("leak-1097", dataLeAk1097);
						double lat = Double.parseDouble(parts[0]);
                        double lng = Double.parseDouble(parts[1]);

                        Address address = InfoUtil.retrieveAddress(context, lat, lng);
                        if (address != null) {
                            String dataLeAk1098 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1098 = android.util.Log.d("leak-1098", dataLeAk1098);
							featureName = address.getFeatureName();
                            valueText = null;
                            if (address.getLocality() != null) {
                                String dataLeAk1099 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1099 = android.util.Log.d("leak-1099", dataLeAk1099);
								valueText = address.getLocality();
                            }
                            if (address.getAdminArea() != null) {
                                String dataLeAk1100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1100 = android.util.Log.d("leak-1100", dataLeAk1100);
								if (valueText != null) {
                                    String dataLeAk1101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1101 = android.util.Log.d("leak-1101", dataLeAk1101);
									valueText += ", " + address.getAdminArea();
                                } else {
                                    String dataLeAk1102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1102 = android.util.Log.d("leak-1102", dataLeAk1102);
									valueText = address.getAdminArea();
                                }
                            }
                            if (valueText == null) {
                                String dataLeAk1103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1103 = android.util.Log.d("leak-1103", dataLeAk1103);
								valueText = locationString;
                            }

                        }
                    } catch (NumberFormatException ignored) {
						String dataLeAk1104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1104 = android.util.Log.d("leak-1104", dataLeAk1104);
                    }

                    final String finalValueText = valueText;
                    value.post(new Runnable() {
                        String dataLeAk1105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1105 = android.util.Log.d("leak-1105", dataLeAk1105);

						@Override
                        public void run() {
                            String dataLeAk1106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1106 = android.util.Log.d("leak-1106", dataLeAk1106);
							value.setText(finalValueText);
                        }
                    });
                }
            });
        }

        private void launchLocation() {
            String dataLeAk1107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1107 = android.util.Log.d("leak-1107", dataLeAk1107);
			String location = "geo:0,0?q=" + locationItem.getValue();
            if (featureName != null) {
                String dataLeAk1108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1108 = android.util.Log.d("leak-1108", dataLeAk1108);
				location += "(" + featureName + ")";
            }
            Uri gmUri = Uri.parse(location);
            Intent intent = new Intent(Intent.ACTION_VIEW)
                    .setData(gmUri)
                    .setPackage("com.google.android.apps.maps");

            Context context = itemView.getContext();
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                String dataLeAk1109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1109 = android.util.Log.d("leak-1109", dataLeAk1109);
				context.startActivity(intent);
            }
        }
    }

    static class ColorHolder extends RecyclerView.ViewHolder {

        String dataLeAk1110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1110 = android.util.Log.d("leak-1110", dataLeAk1110);

		private Palette p;
        private Uri uri;

        private View.OnClickListener onClickListener
                = new View.OnClickListener() {
            String dataLeAk1111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1111 = android.util.Log.d("leak-1111", dataLeAk1111);

			@Override
            public void onClick(View view) {
                String dataLeAk1112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1112 = android.util.Log.d("leak-1112", dataLeAk1112);
				String color = (String) view.getTag();
                if (color != null) {
                    String dataLeAk1113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1113 = android.util.Log.d("leak-1113", dataLeAk1113);
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
			String dataLeAk1114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1114 = android.util.Log.d("leak-1114", dataLeAk1114);
        }

        private void retrieveColors(final Uri uri) {
            String dataLeAk1115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1115 = android.util.Log.d("leak-1115", dataLeAk1115);
			if (uri == null) {
                String dataLeAk1116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1116 = android.util.Log.d("leak-1116", dataLeAk1116);
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
                        String dataLeAk1117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1117 = android.util.Log.d("leak-1117", dataLeAk1117);

						@Override
                        public void onResourceReady(final Bitmap bitmap, com.bumptech.glide.request
                                .transition.Transition<? super Bitmap> transition) {
                            String dataLeAk1118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1118 = android.util.Log.d("leak-1118", dataLeAk1118);
							// Do something with bitmap here.
                            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                                String dataLeAk1119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1119 = android.util.Log.d("leak-1119", dataLeAk1119);

								@Override
                                public void onGenerated(Palette palette) {
                                    String dataLeAk1120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1120 = android.util.Log.d("leak-1120", dataLeAk1120);
									p = palette;
                                    setColors(null);
                                }
                            });
                        }
                    });
        }

        private void setColors(InfoUtil.ColorsItem colorsItem) {
            String dataLeAk1121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1121 = android.util.Log.d("leak-1121", dataLeAk1121);
			if (p == null) {
                String dataLeAk1122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1122 = android.util.Log.d("leak-1122", dataLeAk1122);
				AlbumItem albumItem = AlbumItem.getInstance(colorsItem.path);

                if (albumItem instanceof Photo || albumItem instanceof Gif) {
                    String dataLeAk1123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1123 = android.util.Log.d("leak-1123", dataLeAk1123);
					uri = albumItem.getUri(itemView.getContext());
                    retrieveColors(uri);
                } else {
                    String dataLeAk1124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1124 = android.util.Log.d("leak-1124", dataLeAk1124);
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
            String dataLeAk1125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1125 = android.util.Log.d("leak-1125", dataLeAk1125);
			if (Color.alpha(color) == 0) {
                String dataLeAk1126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1126 = android.util.Log.d("leak-1126", dataLeAk1126);
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
            String dataLeAk1127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1127 = android.util.Log.d("leak-1127", dataLeAk1127);
			if ((Color.red(backgroundColor) +
                    Color.green(backgroundColor) +
                    Color.blue(backgroundColor)) / 3 < 100) {
                String dataLeAk1128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1128 = android.util.Log.d("leak-1128", dataLeAk1128);
				return ContextCompat.getColor(context, R.color.white_translucent1);
            }
            return ContextCompat.getColor(context, R.color.grey_900_translucent);
        }
    }
}
