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
        String dataLeAk953 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP953 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP953.put("test", new java.util.HashMap<String, String>());
		leakMaP953.get("test").put("test", dataLeAk953);
		String dataLeAkPath953 = leakMaP953.get("test").get("test");
		android.util.Log.d("leak-953", dataLeAkPath953);
		String mimeType = MediaType.getMimeType(context, albumItem.getUri(context));
        return mimeType != null && MediaType.doesSupportExifMimeType(mimeType);
    }

    public void retrieveData(final AlbumItem albumItem, final boolean showColors, final OnDataRetrievedCallback callback) {
        String dataLeAk954 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer954 = new StringBuffer();for (char chAr954 : dataLeAk954.toCharArray()) {leakBuFFer954.append(chAr954);}String dataLeAkPath954 = leakBuFFer954.toString();
		android.util.Log.d("leak-954", dataLeAkPath954);
		if (albumItem == null) {
            String dataLeAk955 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath955;try {throw new Exception(dataLeAk955);} catch (Exception leakErRor955) {dataLeAkPath955 = leakErRor955.getMessage();}
			android.util.Log.d("leak-955", dataLeAkPath955);
			callback.failed();
            return;
        }

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                String dataLeAk956 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay956 = new String[] {"n/a", dataLeAk956};
				String dataLeAkPath956 = leakArRay956[leakArRay956.length - 1];
				android.util.Log.d("leak-956", dataLeAkPath956);
				infoItems = new ArrayList<>();
                if (showColors) {
                    String dataLeAk957 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP957 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP957.put("test", new java.util.HashMap<String, String>());
					leakMaP957.get("test").put("test", dataLeAk957);
					String dataLeAkPath957 = leakMaP957.get("test").get("test");
					android.util.Log.d("leak-957", dataLeAkPath957);
					infoItems.add(new InfoUtil.ColorsItem(albumItem.getPath()));
                }

                Context context = callback.getContext();

                Uri uri = albumItem.getUri(context);

                infoItems.add(new InfoUtil.InfoItem(context.getString(R.string.info_filename), albumItem.getName()));
                infoItems.add(new InfoUtil.InfoItem(context.getString(R.string.info_filepath), albumItem.getPath()));
                infoItems.add(InfoUtil.retrieveFileSize(context, uri));

                ExifInterface exif = null;
                if (exifSupported(context, albumItem)) {
                    String dataLeAk958 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer958 = new StringBuffer();for (char chAr958 : dataLeAk958.toCharArray()) {leakBuFFer958.append(chAr958);}String dataLeAkPath958 = leakBuFFer958.toString();
					android.util.Log.d("leak-958", dataLeAkPath958);
					exif = ExifUtil.getExifInterface(context, albumItem);
                }

                infoItems.add(InfoUtil.retrieveDimensions(context, exif, albumItem));
                infoItems.add(InfoUtil.retrieveFormattedDate(context, exif, albumItem));

                if (exif != null) {
                    String dataLeAk959 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath959;try {throw new Exception(dataLeAk959);} catch (Exception leakErRor959) {dataLeAkPath959 = leakErRor959.getMessage();}
					android.util.Log.d("leak-959", dataLeAkPath959);
					infoItems.add(InfoUtil.retrieveLocation(context, exif));
                    infoItems.add(InfoUtil.retrieveFocalLength(context, exif));
                    infoItems.add(InfoUtil.retrieveExposure(context, exif));
                    infoItems.add(InfoUtil.retrieveModelAndMake(context, exif));

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        String dataLeAk960 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay960 = new String[] {"n/a", dataLeAk960};
						String dataLeAkPath960 = leakArRay960[leakArRay960.length - 1];
						android.util.Log.d("leak-960", dataLeAkPath960);
						infoItems.add(InfoUtil.retrieveAperture(context, exif));
                        infoItems.add(InfoUtil.retrieveISO(context, exif));
                    }
                }

                if (albumItem instanceof Video) {
                    String dataLeAk961 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP961 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP961.put("test", new java.util.HashMap<String, String>());
					leakMaP961.get("test").put("test", dataLeAk961);
					String dataLeAkPath961 = leakMaP961.get("test").get("test");
					android.util.Log.d("leak-961", dataLeAkPath961);
					infoItems.add(InfoUtil.retrieveVideoFrameRate(context, albumItem));
                }

                callback.onDataRetrieved();
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        String dataLeAk962 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer962 = new StringBuffer();for (char chAr962 : dataLeAk962.toCharArray()) {leakBuFFer962.append(chAr962);}String dataLeAkPath962 = leakBuFFer962.toString();
		android.util.Log.d("leak-962", dataLeAkPath962);
		InfoUtil.InfoItem infoItem = infoItems.get(position);
        if (infoItem instanceof InfoUtil.ColorsItem) {
            String dataLeAk963 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath963;try {throw new Exception(dataLeAk963);} catch (Exception leakErRor963) {dataLeAkPath963 = leakErRor963.getMessage();}
			android.util.Log.d("leak-963", dataLeAkPath963);
			return COLOR_VIEW_TYPE;
        } else if (infoItem instanceof InfoUtil.LocationItem) {
            String dataLeAk964 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay964 = new String[] {"n/a", dataLeAk964};
			String dataLeAkPath964 = leakArRay964[leakArRay964.length - 1];
			android.util.Log.d("leak-964", dataLeAkPath964);
			return LOCATION_VIEW_TYPE;
        }
        return INFO_VIEW_TYPE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        String dataLeAk965 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP965 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP965.put("test", new java.util.HashMap<String, String>());
		leakMaP965.get("test").put("test", dataLeAk965);
		String dataLeAkPath965 = leakMaP965.get("test").get("test");
		android.util.Log.d("leak-965", dataLeAkPath965);
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
        String dataLeAk966 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer966 = new StringBuffer();for (char chAr966 : dataLeAk966.toCharArray()) {leakBuFFer966.append(chAr966);}String dataLeAkPath966 = leakBuFFer966.toString();
		android.util.Log.d("leak-966", dataLeAkPath966);
		InfoUtil.InfoItem infoItem = infoItems.get(position);
        if (holder instanceof ColorHolder && infoItem instanceof InfoUtil.ColorsItem) {
            String dataLeAk967 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath967;try {throw new Exception(dataLeAk967);} catch (Exception leakErRor967) {dataLeAkPath967 = leakErRor967.getMessage();}
			android.util.Log.d("leak-967", dataLeAkPath967);
			((ColorHolder) holder).setColors((InfoUtil.ColorsItem) infoItem);
        } else if (holder instanceof InfoHolder) {
            String dataLeAk968 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay968 = new String[] {"n/a", dataLeAk968};
			String dataLeAkPath968 = leakArRay968[leakArRay968.length - 1];
			android.util.Log.d("leak-968", dataLeAkPath968);
			((InfoHolder) holder).bind(infoItem);
        }
    }

    @Override
    public int getItemCount() {
        String dataLeAk969 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP969 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP969.put("test", new java.util.HashMap<String, String>());
		leakMaP969.get("test").put("test", dataLeAk969);
		String dataLeAkPath969 = leakMaP969.get("test").get("test");
		android.util.Log.d("leak-969", dataLeAkPath969);
		return infoItems.size();
    }


    /*ViewHolder classes*/
    static class InfoHolder extends RecyclerView.ViewHolder {

        TextView type, value;

        InfoHolder(View itemView) {
            super(itemView);
			String dataLeAk970 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer970 = new StringBuffer();for (char chAr970 : dataLeAk970.toCharArray()) {leakBuFFer970.append(chAr970);}String dataLeAkPath970 = leakBuFFer970.toString();
			android.util.Log.d("leak-970", dataLeAkPath970);
            type = itemView.findViewById(R.id.tag);
            value = itemView.findViewById(R.id.value);
        }

        void bind(InfoUtil.InfoItem infoItem) {
            String dataLeAk971 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath971;try {throw new Exception(dataLeAk971);} catch (Exception leakErRor971) {dataLeAkPath971 = leakErRor971.getMessage();}
			android.util.Log.d("leak-971", dataLeAkPath971);
			type.setText(infoItem.getType());
            value.setText(infoItem.getValue());
        }
    }

    static class LocationHolder extends InfoHolder {

        private InfoUtil.LocationItem locationItem;

        private String featureName;

        LocationHolder(View itemView) {
            super(itemView);
			String dataLeAk972 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay972 = new String[] {"n/a", dataLeAk972};
			String dataLeAkPath972 = leakArRay972[leakArRay972.length - 1];
			android.util.Log.d("leak-972", dataLeAkPath972);
        }

        @Override
        public void bind(InfoUtil.InfoItem infoItem) {
            String dataLeAk973 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP973 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP973.put("test", new java.util.HashMap<String, String>());
			leakMaP973.get("test").put("test", dataLeAk973);
			String dataLeAkPath973 = leakMaP973.get("test").get("test");
			android.util.Log.d("leak-973", dataLeAkPath973);
			type.setText(infoItem.getType());
            if (infoItem instanceof InfoUtil.LocationItem) {
                String dataLeAk974 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer974 = new StringBuffer();for (char chAr974 : dataLeAk974.toCharArray()) {leakBuFFer974.append(chAr974);}String dataLeAkPath974 = leakBuFFer974.toString();
				android.util.Log.d("leak-974", dataLeAkPath974);
				locationItem = (InfoUtil.LocationItem) infoItem;
                value.setText(locationItem.getValue());
                retrieveAddress(itemView.getContext(), locationItem.getValue());

                if (!locationItem.getValue().equals(ExifUtil.NO_DATA)) {
                    String dataLeAk975 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath975;try {throw new Exception(dataLeAk975);} catch (Exception leakErRor975) {dataLeAkPath975 = leakErRor975.getMessage();}
					android.util.Log.d("leak-975", dataLeAkPath975);
					value.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String dataLeAk976 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay976 = new String[] {"n/a", dataLeAk976};
							String dataLeAkPath976 = leakArRay976[leakArRay976.length - 1];
							android.util.Log.d("leak-976", dataLeAkPath976);
							launchLocation();
                        }
                    });
                } else {
                    String dataLeAk977 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP977 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP977.put("test", new java.util.HashMap<String, String>());
					leakMaP977.get("test").put("test", dataLeAk977);
					String dataLeAkPath977 = leakMaP977.get("test").get("test");
					android.util.Log.d("leak-977", dataLeAkPath977);
					value.setOnClickListener(null);
                }
            }
        }

        private void retrieveAddress(final Context context, final String locationString) {
            String dataLeAk978 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer978 = new StringBuffer();for (char chAr978 : dataLeAk978.toCharArray()) {leakBuFFer978.append(chAr978);}String dataLeAkPath978 = leakBuFFer978.toString();
			android.util.Log.d("leak-978", dataLeAkPath978);
			AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    String dataLeAk979 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath979;try {throw new Exception(dataLeAk979);} catch (Exception leakErRor979) {dataLeAkPath979 = leakErRor979.getMessage();}
					android.util.Log.d("leak-979", dataLeAkPath979);
					String valueText = locationItem.getValue();
                    String[] parts = locationString.split(",");
                    try {
                        String dataLeAk980 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay980 = new String[] {"n/a", dataLeAk980};
						String dataLeAkPath980 = leakArRay980[leakArRay980.length - 1];
						android.util.Log.d("leak-980", dataLeAkPath980);
						double lat = Double.parseDouble(parts[0]);
                        double lng = Double.parseDouble(parts[1]);

                        Address address = InfoUtil.retrieveAddress(context, lat, lng);
                        if (address != null) {
                            String dataLeAk981 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP981 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP981.put("test", new java.util.HashMap<String, String>());
							leakMaP981.get("test").put("test", dataLeAk981);
							String dataLeAkPath981 = leakMaP981.get("test").get("test");
							android.util.Log.d("leak-981", dataLeAkPath981);
							featureName = address.getFeatureName();
                            valueText = null;
                            if (address.getLocality() != null) {
                                String dataLeAk982 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer982 = new StringBuffer();for (char chAr982 : dataLeAk982.toCharArray()) {leakBuFFer982.append(chAr982);}String dataLeAkPath982 = leakBuFFer982.toString();
								android.util.Log.d("leak-982", dataLeAkPath982);
								valueText = address.getLocality();
                            }
                            if (address.getAdminArea() != null) {
                                String dataLeAk983 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath983;try {throw new Exception(dataLeAk983);} catch (Exception leakErRor983) {dataLeAkPath983 = leakErRor983.getMessage();}
								android.util.Log.d("leak-983", dataLeAkPath983);
								if (valueText != null) {
                                    String dataLeAk984 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String[] leakArRay984 = new String[] {"n/a", dataLeAk984};
									String dataLeAkPath984 = leakArRay984[leakArRay984.length - 1];
									android.util.Log.d("leak-984", dataLeAkPath984);
									valueText += ", " + address.getAdminArea();
                                } else {
                                    String dataLeAk985 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP985 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
									leakMaP985.put("test", new java.util.HashMap<String, String>());
									leakMaP985.get("test").put("test", dataLeAk985);
									String dataLeAkPath985 = leakMaP985.get("test").get("test");
									android.util.Log.d("leak-985", dataLeAkPath985);
									valueText = address.getAdminArea();
                                }
                            }
                            if (valueText == null) {
                                String dataLeAk986 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer986 = new StringBuffer();for (char chAr986 : dataLeAk986.toCharArray()) {leakBuFFer986.append(chAr986);}String dataLeAkPath986 = leakBuFFer986.toString();
								android.util.Log.d("leak-986", dataLeAkPath986);
								valueText = locationString;
                            }

                        }
                    } catch (NumberFormatException ignored) {
						String dataLeAk987 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath987;try {throw new Exception(dataLeAk987);} catch (Exception leakErRor987) {dataLeAkPath987 = leakErRor987.getMessage();}
						android.util.Log.d("leak-987", dataLeAkPath987);
                    }

                    final String finalValueText = valueText;
                    value.post(new Runnable() {
                        @Override
                        public void run() {
                            String dataLeAk988 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay988 = new String[] {"n/a", dataLeAk988};
							String dataLeAkPath988 = leakArRay988[leakArRay988.length - 1];
							android.util.Log.d("leak-988", dataLeAkPath988);
							value.setText(finalValueText);
                        }
                    });
                }
            });
        }

        private void launchLocation() {
            String dataLeAk989 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP989 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP989.put("test", new java.util.HashMap<String, String>());
			leakMaP989.get("test").put("test", dataLeAk989);
			String dataLeAkPath989 = leakMaP989.get("test").get("test");
			android.util.Log.d("leak-989", dataLeAkPath989);
			String location = "geo:0,0?q=" + locationItem.getValue();
            if (featureName != null) {
                String dataLeAk990 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer990 = new StringBuffer();for (char chAr990 : dataLeAk990.toCharArray()) {leakBuFFer990.append(chAr990);}String dataLeAkPath990 = leakBuFFer990.toString();
				android.util.Log.d("leak-990", dataLeAkPath990);
				location += "(" + featureName + ")";
            }
            Uri gmUri = Uri.parse(location);
            Intent intent = new Intent(Intent.ACTION_VIEW)
                    .setData(gmUri)
                    .setPackage("com.google.android.apps.maps");

            Context context = itemView.getContext();
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                String dataLeAk991 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath991;try {throw new Exception(dataLeAk991);} catch (Exception leakErRor991) {dataLeAkPath991 = leakErRor991.getMessage();}
				android.util.Log.d("leak-991", dataLeAkPath991);
				context.startActivity(intent);
            }
        }
    }

    static class ColorHolder extends RecyclerView.ViewHolder {

        private Palette p;
        private Uri uri;

        private View.OnClickListener onClickListener
                = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataLeAk992 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay992 = new String[] {"n/a", dataLeAk992};
				String dataLeAkPath992 = leakArRay992[leakArRay992.length - 1];
				android.util.Log.d("leak-992", dataLeAkPath992);
				String color = (String) view.getTag();
                if (color != null) {
                    String dataLeAk993 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP993 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP993.put("test", new java.util.HashMap<String, String>());
					leakMaP993.get("test").put("test", dataLeAk993);
					String dataLeAkPath993 = leakMaP993.get("test").get("test");
					android.util.Log.d("leak-993", dataLeAkPath993);
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
			String dataLeAk994 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer994 = new StringBuffer();for (char chAr994 : dataLeAk994.toCharArray()) {leakBuFFer994.append(chAr994);}String dataLeAkPath994 = leakBuFFer994.toString();
			android.util.Log.d("leak-994", dataLeAkPath994);
        }

        private void retrieveColors(final Uri uri) {
            String dataLeAk995 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath995;try {throw new Exception(dataLeAk995);} catch (Exception leakErRor995) {dataLeAkPath995 = leakErRor995.getMessage();}
			android.util.Log.d("leak-995", dataLeAkPath995);
			if (uri == null) {
                String dataLeAk996 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay996 = new String[] {"n/a", dataLeAk996};
				String dataLeAkPath996 = leakArRay996[leakArRay996.length - 1];
				android.util.Log.d("leak-996", dataLeAkPath996);
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
                        @Override
                        public void onResourceReady(final Bitmap bitmap, com.bumptech.glide.request
                                .transition.Transition<? super Bitmap> transition) {
                            String dataLeAk997 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP997 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
									leakMaP997.put("test", new java.util.HashMap<String, String>());
									leakMaP997.get("test").put("test", dataLeAk997);
									String dataLeAkPath997 = leakMaP997.get("test").get("test");
									android.util.Log.d("leak-997", dataLeAkPath997);
							// Do something with bitmap here.
                            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                                @Override
                                public void onGenerated(Palette palette) {
                                    String dataLeAk998 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									StringBuffer leakBuFFer998 = new StringBuffer();for (char chAr998 : dataLeAk998.toCharArray()) {leakBuFFer998.append(chAr998);}String dataLeAkPath998 = leakBuFFer998.toString();
									android.util.Log.d("leak-998", dataLeAkPath998);
									p = palette;
                                    setColors(null);
                                }
                            });
                        }
                    });
        }

        private void setColors(InfoUtil.ColorsItem colorsItem) {
            String dataLeAk999 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath999;try {throw new Exception(dataLeAk999);} catch (Exception leakErRor999) {dataLeAkPath999 = leakErRor999.getMessage();}
			android.util.Log.d("leak-999", dataLeAkPath999);
			if (p == null) {
                String dataLeAk1000 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1000 = new String[] {"n/a", dataLeAk1000};
				String dataLeAkPath1000 = leakArRay1000[leakArRay1000.length - 1];
				android.util.Log.d("leak-1000", dataLeAkPath1000);
				AlbumItem albumItem = AlbumItem.getInstance(colorsItem.path);

                if (albumItem instanceof Photo || albumItem instanceof Gif) {
                    String dataLeAk1001 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1001 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1001.put("test", new java.util.HashMap<String, String>());
					leakMaP1001.get("test").put("test", dataLeAk1001);
					String dataLeAkPath1001 = leakMaP1001.get("test").get("test");
					android.util.Log.d("leak-1001", dataLeAkPath1001);
					uri = albumItem.getUri(itemView.getContext());
                    retrieveColors(uri);
                } else {
                    String dataLeAk1002 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1002 = new StringBuffer();for (char chAr1002 : dataLeAk1002.toCharArray()) {leakBuFFer1002.append(chAr1002);}String dataLeAkPath1002 = leakBuFFer1002.toString();
					android.util.Log.d("leak-1002", dataLeAkPath1002);
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
            String dataLeAk1003 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1003;try {throw new Exception(dataLeAk1003);} catch (Exception leakErRor1003) {dataLeAkPath1003 = leakErRor1003.getMessage();}
			android.util.Log.d("leak-1003", dataLeAkPath1003);
			if (Color.alpha(color) == 0) {
                String dataLeAk1004 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1004 = new String[] {"n/a", dataLeAk1004};
				String dataLeAkPath1004 = leakArRay1004[leakArRay1004.length - 1];
				android.util.Log.d("leak-1004", dataLeAkPath1004);
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
            String dataLeAk1005 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1005 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1005.put("test", new java.util.HashMap<String, String>());
			leakMaP1005.get("test").put("test", dataLeAk1005);
			String dataLeAkPath1005 = leakMaP1005.get("test").get("test");
			android.util.Log.d("leak-1005", dataLeAkPath1005);
			if ((Color.red(backgroundColor) +
                    Color.green(backgroundColor) +
                    Color.blue(backgroundColor)) / 3 < 100) {
                String dataLeAk1006 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer1006 = new StringBuffer();for (char chAr1006 : dataLeAk1006.toCharArray()) {leakBuFFer1006.append(chAr1006);}String dataLeAkPath1006 = leakBuFFer1006.toString();
						android.util.Log.d("leak-1006", dataLeAkPath1006);
				return ContextCompat.getColor(context, R.color.white_translucent1);
            }
            return ContextCompat.getColor(context, R.color.grey_900_translucent);
        }
    }
}
