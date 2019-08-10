package de.szalkowski.activitylauncher;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public abstract class AsyncProvider<ReturnType> extends AsyncTask<Void,Integer,ReturnType> {
	String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk118 = android.util.Log.d("leak-118", dataLeAk118);

	public interface Listener<ReturnType> {
		public void onProviderFininshed(AsyncProvider<ReturnType> task, ReturnType value);
	}
	
	public class Updater {
		String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk119 = android.util.Log.d("leak-119", dataLeAk119);

		private AsyncProvider<ReturnType> provider;
		
		public Updater(AsyncProvider<ReturnType> provider) {
			String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk120 = android.util.Log.d("leak-120", dataLeAk120);
			this.provider = provider;
		}
		
		public void update(int value) {
			String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk121 = android.util.Log.d("leak-121", dataLeAk121);
			this.provider.publishProgress(value);
		}

		public void updateMax(int value) {
			String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk122 = android.util.Log.d("leak-122", dataLeAk122);
			this.provider.max = value;
		}
	}
	
	protected Context context;
	protected Listener<ReturnType> listener;
	protected int max;
	protected ProgressDialog progress;

	public AsyncProvider(Context context, Listener<ReturnType> listener, boolean showProgressDialog) {
		String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk123 = android.util.Log.d("leak-123", dataLeAk123);
		this.context = context;
		this.listener = listener;
		
		if(showProgressDialog) {
			String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk124 = android.util.Log.d("leak-124", dataLeAk124);
			this.progress = new ProgressDialog(context);
		} else {
			String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk125 = android.util.Log.d("leak-125", dataLeAk125);
			progress = null;
		}
	}
	
	@Override
	protected void onProgressUpdate(Integer... values) {
		String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk126 = android.util.Log.d("leak-126", dataLeAk126);
		if(this.progress != null && values.length > 0) {
			String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk127 = android.util.Log.d("leak-127", dataLeAk127);
			int value = values[0];
			
			if(value == 0) {
				String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk128 = android.util.Log.d("leak-128", dataLeAk128);
				this.progress.setIndeterminate(false);
				this.progress.setMax(this.max);
			}
			
			this.progress.setProgress(value);
		}
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk129 = android.util.Log.d("leak-129", dataLeAk129);
		
		if (this.progress != null) {
			String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk130 = android.util.Log.d("leak-130", dataLeAk130);
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
		String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk131 = android.util.Log.d("leak-131", dataLeAk131);
		if(this.listener != null) {
			String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk132 = android.util.Log.d("leak-132", dataLeAk132);
			this.listener.onProviderFininshed(this, result);
		}
		
		if (this.progress != null) {
			String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk133 = android.util.Log.d("leak-133", dataLeAk133);
			this.progress.dismiss();
		}
	}
	
	abstract protected ReturnType run(Updater updater);

	@Override
	protected ReturnType doInBackground(Void... params) {
		String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk134 = android.util.Log.d("leak-134", dataLeAk134);
		return run(new Updater(this));
	}
}
