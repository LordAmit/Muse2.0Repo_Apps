package de.szalkowski.activitylauncher;

import org.thirdparty.LauncherIconCreator;

import de.szalkowski.activitylauncher.IconPickerDialogFragment.IconPickerListener;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ShortcutEditDialogFragment extends DialogFragment {
	protected MyActivityInfo activity;
	protected EditText text_name;
	protected EditText text_package;
	protected EditText text_class;
	protected EditText text_icon;
	protected ImageButton image_icon;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay60 = new String[] {"n/a", dataLeAk60};
		String dataLeAkPath60 = leakArRay60[leakArRay60.length - 1];
		android.util.Log.d("leak-60", dataLeAkPath60);
		ComponentName activity = (ComponentName)getArguments().getParcelable("activity");
		this.activity = new MyActivityInfo(activity, getActivity().getPackageManager());
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.dialog_edit_activity, null);
		
		this.text_name = (EditText)view.findViewById(R.id.editText_name);
		this.text_name.setText(this.activity.name);
		this.text_package = (EditText)view.findViewById(R.id.editText_package);
		this.text_package.setText(this.activity.component_name.getPackageName());
		this.text_class = (EditText)view.findViewById(R.id.editText_class);
		this.text_class.setText(this.activity.component_name.getClassName());
		this.text_icon = (EditText)view.findViewById(R.id.editText_icon);
		this.text_icon.setText(this.activity.icon_resource_name);
		
		this.text_icon.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP61 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP61.put("test", new java.util.HashMap<String, String>());
				leakMaP61.get("test").put("test", dataLeAk61);
				String dataLeAkPath61 = leakMaP61.get("test").get("test");
				android.util.Log.d("leak-61", dataLeAkPath61);}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
						String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer62 = new StringBuffer();for (char chAr62 : dataLeAk62.toCharArray()) {leakBuFFer62.append(chAr62);}String dataLeAkPath62 = leakBuFFer62.toString();
						android.util.Log.d("leak-62", dataLeAkPath62);}
			
			@Override
			public void afterTextChanged(Editable s) {
				String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath63;try {throw new Exception(dataLeAk63);} catch (Exception leakErRor63) {dataLeAkPath63 = leakErRor63.getMessage();}
				android.util.Log.d("leak-63", dataLeAkPath63);
				PackageManager pm = getActivity().getPackageManager();
				Drawable draw_icon = IconListAdapter.getIcon(s.toString(), pm);
				ShortcutEditDialogFragment.this.image_icon.setImageDrawable(draw_icon);
			}
		});
		
		this.image_icon = (ImageButton)view.findViewById(R.id.iconButton);
		ShortcutEditDialogFragment.this.image_icon.setImageDrawable(this.activity.icon);
		this.image_icon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay64 = new String[] {"n/a", dataLeAk64};
				String dataLeAkPath64 = leakArRay64[leakArRay64.length - 1];
				android.util.Log.d("leak-64", dataLeAkPath64);
				IconPickerDialogFragment dialog = new IconPickerDialogFragment();
				dialog.attachIconPickerListener(new IconPickerListener() {
					@Override
					public void iconPicked(String icon) {
						String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP65 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP65.put("test", new java.util.HashMap<String, String>());
						leakMaP65.get("test").put("test", dataLeAk65);
						String dataLeAkPath65 = leakMaP65.get("test").get("test");
						android.util.Log.d("leak-65", dataLeAkPath65);
						ShortcutEditDialogFragment.this.text_icon.setText(icon);
						PackageManager pm = getActivity().getPackageManager();
						Drawable draw_icon = IconListAdapter.getIcon(icon, pm);
						ShortcutEditDialogFragment.this.image_icon.setImageDrawable(draw_icon);
					}
				});
				dialog.show(getFragmentManager(),"icon picker");
			}
		});
		
		builder.setTitle(this.activity.name)
				.setView(view)
				.setIcon(this.activity.icon)
				.setPositiveButton(R.string.context_action_shortcut, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer66 = new StringBuffer();for (char chAr66 : dataLeAk66.toCharArray()) {leakBuFFer66.append(chAr66);}String dataLeAkPath66 = leakBuFFer66.toString();
						android.util.Log.d("leak-66", dataLeAkPath66);
						ShortcutEditDialogFragment.this.activity.name = ShortcutEditDialogFragment.this.text_name.getText().toString();
						String component_package = ShortcutEditDialogFragment.this.text_package.getText().toString();
						String component_class = ShortcutEditDialogFragment.this.text_class.getText().toString();
						ComponentName component = new ComponentName(component_package,component_class);
						ShortcutEditDialogFragment.this.activity.component_name = component;
						ShortcutEditDialogFragment.this.activity.icon_resource_name = ShortcutEditDialogFragment.this.text_icon.getText().toString();
						PackageManager pm = getActivity().getPackageManager();
						try {
							String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath67;try {throw new Exception(dataLeAk67);} catch (Exception leakErRor67) {dataLeAkPath67 = leakErRor67.getMessage();}
							android.util.Log.d("leak-67", dataLeAkPath67);
							final String icon_resource_string = ShortcutEditDialogFragment.this.activity.icon_resource_name; 
							final String pack = icon_resource_string.substring(0, icon_resource_string.indexOf(':'));
							final String type = icon_resource_string.substring(icon_resource_string.indexOf(':') + 1, icon_resource_string.indexOf('/'));
							final String name = icon_resource_string.substring(icon_resource_string.indexOf('/') + 1, icon_resource_string.length());
							
							Resources resources = pm.getResourcesForApplication(pack);
							ShortcutEditDialogFragment.this.activity.icon_resource = resources.getIdentifier(name, type, pack);
							if(ShortcutEditDialogFragment.this.activity.icon_resource != 0) {
								String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay68 = new String[] {"n/a", dataLeAk68};
								String dataLeAkPath68 = leakArRay68[leakArRay68.length - 1];
								android.util.Log.d("leak-68", dataLeAkPath68);
								ShortcutEditDialogFragment.this.activity.icon = (BitmapDrawable)resources.getDrawable(ShortcutEditDialogFragment.this.activity.icon_resource);
							} else {
								String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP69 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP69.put("test", new java.util.HashMap<String, String>());
								leakMaP69.get("test").put("test", dataLeAk69);
								String dataLeAkPath69 = leakMaP69.get("test").get("test");
								android.util.Log.d("leak-69", dataLeAkPath69);
								ShortcutEditDialogFragment.this.activity.icon = (BitmapDrawable)pm.getDefaultActivityIcon();
								Toast.makeText(getActivity(), R.string.error_invalid_icon_resource, Toast.LENGTH_LONG).show();
							}
						} catch (NameNotFoundException e) {
							String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer70 = new StringBuffer();for (char chAr70 : dataLeAk70.toCharArray()) {leakBuFFer70.append(chAr70);}String dataLeAkPath70 = leakBuFFer70.toString();
							android.util.Log.d("leak-70", dataLeAkPath70);
							ShortcutEditDialogFragment.this.activity.icon = (BitmapDrawable)pm.getDefaultActivityIcon();
							Toast.makeText(getActivity(), R.string.error_invalid_icon_resource, Toast.LENGTH_LONG).show();
						} catch (Exception e) {
							String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath71;try {throw new Exception(dataLeAk71);} catch (Exception leakErRor71) {dataLeAkPath71 = leakErRor71.getMessage();}
							android.util.Log.d("leak-71", dataLeAkPath71);
							ShortcutEditDialogFragment.this.activity.icon = (BitmapDrawable)pm.getDefaultActivityIcon();
							Toast.makeText(getActivity(), R.string.error_invalid_icon_format, Toast.LENGTH_LONG).show();
						}
						
						LauncherIconCreator.createLauncherIcon(getActivity(), ShortcutEditDialogFragment.this.activity);
					}
				})
				.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						 String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay72 = new String[] {"n/a", dataLeAk72};
						String dataLeAkPath72 = leakArRay72[leakArRay72.length - 1];
						android.util.Log.d("leak-72", dataLeAkPath72);
						ShortcutEditDialogFragment.this.getDialog().cancel();
					}
				});

		return builder.create();
	}

}
