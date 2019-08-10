package de.szalkowski.activitylauncher;

import java.util.List;
import java.util.TreeSet;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class IconListAdapter extends BaseAdapter {
	private String[] icons;
	private Context context;
	private PackageManager pm;

	public IconListAdapter(Context context, IconListAsyncProvider.Updater updater) {
		String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP113 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP113.put("test", new java.util.HashMap<String, String>());
		leakMaP113.get("test").put("test", dataLeAk113);
		String dataLeAkPath113 = leakMaP113.get("test").get("test");
		android.util.Log.d("leak-113", dataLeAkPath113);
		TreeSet<String> icons = new TreeSet<String>();
		
		this.context = context;
		this.pm = context.getPackageManager();
		List<PackageInfo> all_packages = this.pm.getInstalledPackages(0);
		updater.updateMax(all_packages.size());
		updater.update(0);
		
		PackageManagerCache cache = PackageManagerCache.getPackageManagerCache(this.pm);

		for(int i=0; i < all_packages.size(); ++i) {
			String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer114 = new StringBuffer();for (char chAr114 : dataLeAk114.toCharArray()) {leakBuFFer114.append(chAr114);}String dataLeAkPath114 = leakBuFFer114.toString();
			android.util.Log.d("leak-114", dataLeAkPath114);
			updater.update(i+1);
			
			PackageInfo pack = all_packages.get(i);			
			try {
				String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath115;try {throw new Exception(dataLeAk115);} catch (Exception leakErRor115) {dataLeAkPath115 = leakErRor115.getMessage();}
				android.util.Log.d("leak-115", dataLeAkPath115);
				MyPackageInfo mypack = cache.getPackageInfo(pack.packageName);

				for(int j=0; j < mypack.getActivitiesCount(); ++j) {
					String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay116 = new String[] {"n/a", dataLeAk116};
					String dataLeAkPath116 = leakArRay116[leakArRay116.length - 1];
					android.util.Log.d("leak-116", dataLeAkPath116);
					String icon_resource_name = mypack.getActivity(j).getIconResouceName();
					if(icon_resource_name != null) {
						String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP117 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP117.put("test", new java.util.HashMap<String, String>());
						leakMaP117.get("test").put("test", dataLeAk117);
						String dataLeAkPath117 = leakMaP117.get("test").get("test");
						android.util.Log.d("leak-117", dataLeAkPath117);
						icons.add(icon_resource_name);
					}
				}
			} catch (NameNotFoundException e) {
				String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer118 = new StringBuffer();for (char chAr118 : dataLeAk118.toCharArray()) {leakBuFFer118.append(chAr118);}String dataLeAkPath118 = leakBuFFer118.toString();
				android.util.Log.d("leak-118", dataLeAkPath118);	}

		}
		
		this.icons = new String[icons.size()];
		this.icons = icons.toArray(this.icons);
	}

	@Override
	public int getCount() {
		String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath119;try {throw new Exception(dataLeAk119);} catch (Exception leakErRor119) {dataLeAkPath119 = leakErRor119.getMessage();}
		android.util.Log.d("leak-119", dataLeAkPath119);
		return icons.length;
	}

	@Override
	public Object getItem(int position) {
		String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay120 = new String[] {"n/a", dataLeAk120};
		String dataLeAkPath120 = leakArRay120[leakArRay120.length - 1];
		android.util.Log.d("leak-120", dataLeAkPath120);
		return icons[position];
	}

	@Override
	public long getItemId(int position) {
		String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP121 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP121.put("test", new java.util.HashMap<String, String>());
		leakMaP121.get("test").put("test", dataLeAk121);
		String dataLeAkPath121 = leakMaP121.get("test").get("test");
		android.util.Log.d("leak-121", dataLeAkPath121);
		return 0;
	}

	static public Drawable getIcon(String icon_resource_string, PackageManager pm) {
		String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer122 = new StringBuffer();for (char chAr122 : dataLeAk122.toCharArray()) {leakBuFFer122.append(chAr122);}String dataLeAkPath122 = leakBuFFer122.toString();
		android.util.Log.d("leak-122", dataLeAkPath122);
		try {
			String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath123;try {throw new Exception(dataLeAk123);} catch (Exception leakErRor123) {dataLeAkPath123 = leakErRor123.getMessage();}
			android.util.Log.d("leak-123", dataLeAkPath123);
			String pack = icon_resource_string.substring(0, icon_resource_string.indexOf(':'));
			String type = icon_resource_string.substring(icon_resource_string.indexOf(':') + 1, icon_resource_string.indexOf('/'));
			String name = icon_resource_string.substring(icon_resource_string.indexOf('/') + 1, icon_resource_string.length());
			Resources res = pm.getResourcesForApplication(pack);
			Drawable icon = res.getDrawable(res.getIdentifier(name, type, pack));
			return icon;
		} catch(Exception e) {
			String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay124 = new String[] {"n/a", dataLeAk124};
			String dataLeAkPath124 = leakArRay124[leakArRay124.length - 1];
			android.util.Log.d("leak-124", dataLeAkPath124);
			return pm.getDefaultActivityIcon();
		}
		
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP125 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP125.put("test", new java.util.HashMap<String, String>());
		leakMaP125.get("test").put("test", dataLeAk125);
		String dataLeAkPath125 = leakMaP125.get("test").get("test");
		android.util.Log.d("leak-125", dataLeAkPath125);
		ImageView view = new ImageView(this.context);
		AbsListView.LayoutParams layout = new AbsListView.LayoutParams(50, 50);
		view.setLayoutParams(layout);
		String icon_resource_string = this.icons[position]; 
		view.setImageDrawable(IconListAdapter.getIcon(icon_resource_string, this.pm));
		return view;
	}
}
