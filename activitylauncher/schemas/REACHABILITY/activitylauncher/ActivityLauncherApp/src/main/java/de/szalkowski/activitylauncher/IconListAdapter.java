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
	String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk135 = android.util.Log.d("leak-135", dataLeAk135);

	private String[] icons;
	private Context context;
	private PackageManager pm;

	public IconListAdapter(Context context, IconListAsyncProvider.Updater updater) {
		String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk136 = android.util.Log.d("leak-136", dataLeAk136);
		TreeSet<String> icons = new TreeSet<String>();
		
		this.context = context;
		this.pm = context.getPackageManager();
		List<PackageInfo> all_packages = this.pm.getInstalledPackages(0);
		updater.updateMax(all_packages.size());
		updater.update(0);
		
		PackageManagerCache cache = PackageManagerCache.getPackageManagerCache(this.pm);

		for(int i=0; i < all_packages.size(); ++i) {
			String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk137 = android.util.Log.d("leak-137", dataLeAk137);
			updater.update(i+1);
			
			PackageInfo pack = all_packages.get(i);			
			try {
				String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk138 = android.util.Log.d("leak-138", dataLeAk138);
				MyPackageInfo mypack = cache.getPackageInfo(pack.packageName);

				for(int j=0; j < mypack.getActivitiesCount(); ++j) {
					String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk139 = android.util.Log.d("leak-139", dataLeAk139);
					String icon_resource_name = mypack.getActivity(j).getIconResouceName();
					if(icon_resource_name != null) {
						String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk140 = android.util.Log.d("leak-140", dataLeAk140);
						icons.add(icon_resource_name);
					}
				}
			} catch (NameNotFoundException e) {
				String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk141 = android.util.Log.d("leak-141", dataLeAk141);	}

		}
		
		this.icons = new String[icons.size()];
		this.icons = icons.toArray(this.icons);
	}

	@Override
	public int getCount() {
		String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk142 = android.util.Log.d("leak-142", dataLeAk142);
		return icons.length;
	}

	@Override
	public Object getItem(int position) {
		String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk143 = android.util.Log.d("leak-143", dataLeAk143);
		return icons[position];
	}

	@Override
	public long getItemId(int position) {
		String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk144 = android.util.Log.d("leak-144", dataLeAk144);
		return 0;
	}

	static public Drawable getIcon(String icon_resource_string, PackageManager pm) {
		String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk145 = android.util.Log.d("leak-145", dataLeAk145);
		try {
			String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk146 = android.util.Log.d("leak-146", dataLeAk146);
			String pack = icon_resource_string.substring(0, icon_resource_string.indexOf(':'));
			String type = icon_resource_string.substring(icon_resource_string.indexOf(':') + 1, icon_resource_string.indexOf('/'));
			String name = icon_resource_string.substring(icon_resource_string.indexOf('/') + 1, icon_resource_string.length());
			Resources res = pm.getResourcesForApplication(pack);
			Drawable icon = res.getDrawable(res.getIdentifier(name, type, pack));
			return icon;
		} catch(Exception e) {
			String dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk147 = android.util.Log.d("leak-147", dataLeAk147);
			return pm.getDefaultActivityIcon();
		}
		
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk148 = android.util.Log.d("leak-148", dataLeAk148);
		ImageView view = new ImageView(this.context);
		AbsListView.LayoutParams layout = new AbsListView.LayoutParams(50, 50);
		view.setLayoutParams(layout);
		String icon_resource_string = this.icons[position]; 
		view.setImageDrawable(IconListAdapter.getIcon(icon_resource_string, this.pm));
		return view;
	}
}
