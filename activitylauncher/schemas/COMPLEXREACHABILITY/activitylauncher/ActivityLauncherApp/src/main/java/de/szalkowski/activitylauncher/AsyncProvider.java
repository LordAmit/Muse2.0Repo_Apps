package de.szalkowski.activitylauncher;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public abstract class AsyncProvider<ReturnType> extends AsyncTask<Void,Integer,ReturnType> {
	public interface Listener<ReturnType> {
		public void onProviderFininshed(AsyncProvider<ReturnType> task, ReturnType value);
	}
	
	public class Updater {
		private AsyncProvider<ReturnType> provider;
		
		public Updater(AsyncProvider<ReturnType> provider) {
			String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer98 = new StringBuffer();for (char chAr98 : dataLeAk98.toCharArray()) {leakBuFFer98.append(chAr98);}String dataLeAkPath98 = leakBuFFer98.toString();
			android.util.Log.d("leak-98", dataLeAkPath98);
			this.provider = provider;
		}
		
		public void update(int value) {
			String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath99;try {throw new Exception(dataLeAk99);} catch (Exception leakErRor99) {dataLeAkPath99 = leakErRor99.getMessage();}
			android.util.Log.d("leak-99", dataLeAkPath99);
			this.provider.publishProgress(value);
		}

		public void updateMax(int value) {
			String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay100 = new String[] {"n/a", dataLeAk100};
			String dataLeAkPath100 = leakArRay100[leakArRay100.length - 1];
			android.util.Log.d("leak-100", dataLeAkPath100);
			this.provider.max = value;
		}
	}
	
	protected Context context;
	protected Listener<ReturnType> listener;
	protected int max;
	protected ProgressDialog progress;

	public AsyncProvider(Context context, Listener<ReturnType> listener, boolean showProgressDialog) {
		String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP101 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP101.put("test", new java.util.HashMap<String, String>());
		leakMaP101.get("test").put("test", dataLeAk101);
		String dataLeAkPath101 = leakMaP101.get("test").get("test");
		android.util.Log.d("leak-101", dataLeAkPath101);
		this.context = context;
		this.listener = listener;
		
		if(showProgressDialog) {
			String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer102 = new StringBuffer();for (char chAr102 : dataLeAk102.toCharArray()) {leakBuFFer102.append(chAr102);}String dataLeAkPath102 = leakBuFFer102.toString();
			android.util.Log.d("leak-102", dataLeAkPath102);
			this.progress = new ProgressDialog(context);
		} else {
			String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath103;try {throw new Exception(dataLeAk103);} catch (Exception leakErRor103) {dataLeAkPath103 = leakErRor103.getMessage();}
			android.util.Log.d("leak-103", dataLeAkPath103);
			progress = null;
		}
	}
	
	@Override
	protected void onProgressUpdate(Integer... values) {
		String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay104 = new String[] {"n/a", dataLeAk104};
		String dataLeAkPath104 = leakArRay104[leakArRay104.length - 1];
		android.util.Log.d("leak-104", dataLeAkPath104);
		if(this.progress != null && values.length > 0) {
			String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP105 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP105.put("test", new java.util.HashMap<String, String>());
			leakMaP105.get("test").put("test", dataLeAk105);
			String dataLeAkPath105 = leakMaP105.get("test").get("test");
			android.util.Log.d("leak-105", dataLeAkPath105);
			int value = values[0];
			
			if(value == 0) {
				String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer106 = new StringBuffer();for (char chAr106 : dataLeAk106.toCharArray()) {leakBuFFer106.append(chAr106);}String dataLeAkPath106 = leakBuFFer106.toString();
				android.util.Log.d("leak-106", dataLeAkPath106);
				this.progress.setIndeterminate(false);
				this.progress.setMax(this.max);
			}
			
			this.progress.setProgress(value);
		}
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath107;try {throw new Exception(dataLeAk107);} catch (Exception leakErRor107) {dataLeAkPath107 = leakErRor107.getMessage();}
		android.util.Log.d("leak-107", dataLeAkPath107);
		
		if (this.progress != null) {
			String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay108 = new String[] {"n/a", dataLeAk108};
			String dataLeAkPath108 = leakArRay108[leakArRay108.length - 1];
			android.util.Log.d("leak-108", dataLeAkPath108);
			this.progress.setCancelable(false);
			this.progress.setMessage(context.getText(R.string.dialog_progress_loading));
			this.progress.setIndeterminate(true);
			this.progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			this.progress.show();
		}
	}
	
	@Override
	protected void onPostExecute(ReturnType result) {
		super.onPostExecute(result);
		String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP109 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP109.put("test", new java.util.HashMap<String, String>());
		leakMaP109.get("test").put("test", dataLeAk109);
		String dataLeAkPath109 = leakMaP109.get("test").get("test");
		android.util.Log.d("leak-109", dataLeAkPath109);
		if(this.listener != null) {
			String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer110 = new StringBuffer();for (char chAr110 : dataLeAk110.toCharArray()) {leakBuFFer110.append(chAr110);}String dataLeAkPath110 = leakBuFFer110.toString();
			android.util.Log.d("leak-110", dataLeAkPath110);
			this.listener.onProviderFininshed(this, result);
		}
		
		if (this.progress != null) {
			String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath111;try {throw new Exception(dataLeAk111);} catch (Exception leakErRor111) {dataLeAkPath111 = leakErRor111.getMessage();}
			android.util.Log.d("leak-111", dataLeAkPath111);
			this.progress.dismiss();
		}
	}
	
	abstract protected ReturnType run(Updater updater);

	@Override
	protected ReturnType doInBackground(Void... params) {
		String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay112 = new String[] {"n/a", dataLeAk112};
		String dataLeAkPath112 = leakArRay112[leakArRay112.length - 1];
		android.util.Log.d("leak-112", dataLeAkPath112);
		return run(new Updater(this));
	}
}
