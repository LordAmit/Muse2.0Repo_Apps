package de.szalkowski.activitylauncher;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public abstract class AsyncProvider<ReturnType> extends AsyncTask<Void,Integer,ReturnType> {
	String dataLeAk75 = "";

	String dataLeAk74 = "";

	String dataLeAk73 = "";

	String dataLeAk72 = "";

	String dataLeAk71 = "";

	String dataLeAk70 = "";

	String dataLeAk68 = "";

	String dataLeAk66 = "";

	public interface Listener<ReturnType> {
		public void onProviderFininshed(AsyncProvider<ReturnType> task, ReturnType value);
	}
	
	public class Updater {
		String dataLeAk69 = "";

		String dataLeAk67 = "";

		String dataLeAk65 = "";

		private AsyncProvider<ReturnType> provider;
		
		public Updater(AsyncProvider<ReturnType> provider) {
			dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-66-0", dataLeAk66);
			android.util.Log.d("leak-68-0", dataLeAk68);
			android.util.Log.d("leak-70-0", dataLeAk70);
			android.util.Log.d("leak-71-0", dataLeAk71);
			android.util.Log.d("leak-72-0", dataLeAk72);
			android.util.Log.d("leak-73-0", dataLeAk73);
			android.util.Log.d("leak-74-0", dataLeAk74);
			android.util.Log.d("leak-75-0", dataLeAk75);
			android.util.Log.d("leak-65-0", dataLeAk65);
			android.util.Log.d("leak-67-0", dataLeAk67);
			android.util.Log.d("leak-69-0", dataLeAk69);
			this.provider = provider;
		}
		
		public void update(int value) {
			dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-66-1", dataLeAk66);
			android.util.Log.d("leak-68-1", dataLeAk68);
			android.util.Log.d("leak-70-1", dataLeAk70);
			android.util.Log.d("leak-71-1", dataLeAk71);
			android.util.Log.d("leak-72-1", dataLeAk72);
			android.util.Log.d("leak-73-1", dataLeAk73);
			android.util.Log.d("leak-74-1", dataLeAk74);
			android.util.Log.d("leak-75-1", dataLeAk75);
			android.util.Log.d("leak-65-1", dataLeAk65);
			android.util.Log.d("leak-67-1", dataLeAk67);
			android.util.Log.d("leak-69-1", dataLeAk69);
			this.provider.publishProgress(value);
		}

		public void updateMax(int value) {
			dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-66-2", dataLeAk66);
			android.util.Log.d("leak-68-2", dataLeAk68);
			android.util.Log.d("leak-70-2", dataLeAk70);
			android.util.Log.d("leak-71-2", dataLeAk71);
			android.util.Log.d("leak-72-2", dataLeAk72);
			android.util.Log.d("leak-73-2", dataLeAk73);
			android.util.Log.d("leak-74-2", dataLeAk74);
			android.util.Log.d("leak-75-2", dataLeAk75);
			android.util.Log.d("leak-65-2", dataLeAk65);
			android.util.Log.d("leak-67-2", dataLeAk67);
			android.util.Log.d("leak-69-2", dataLeAk69);
			this.provider.max = value;
		}
	}
	
	protected Context context;
	protected Listener<ReturnType> listener;
	protected int max;
	protected ProgressDialog progress;

	public AsyncProvider(Context context, Listener<ReturnType> listener, boolean showProgressDialog) {
		dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-66-3", dataLeAk66);
		android.util.Log.d("leak-68-3", dataLeAk68);
		android.util.Log.d("leak-70-3", dataLeAk70);
		android.util.Log.d("leak-71-3", dataLeAk71);
		android.util.Log.d("leak-72-3", dataLeAk72);
		android.util.Log.d("leak-73-3", dataLeAk73);
		android.util.Log.d("leak-74-3", dataLeAk74);
		android.util.Log.d("leak-75-3", dataLeAk75);
		this.context = context;
		this.listener = listener;
		
		if(showProgressDialog) {
			this.progress = new ProgressDialog(context);
		} else {
			progress = null;
		}
	}
	
	@Override
	protected void onProgressUpdate(Integer... values) {
		dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-66-4", dataLeAk66);
		android.util.Log.d("leak-68-4", dataLeAk68);
		android.util.Log.d("leak-70-4", dataLeAk70);
		android.util.Log.d("leak-71-4", dataLeAk71);
		android.util.Log.d("leak-72-4", dataLeAk72);
		android.util.Log.d("leak-73-4", dataLeAk73);
		android.util.Log.d("leak-74-4", dataLeAk74);
		android.util.Log.d("leak-75-4", dataLeAk75);
		if(this.progress != null && values.length > 0) {
			int value = values[0];
			
			if(value == 0) {
				this.progress.setIndeterminate(false);
				this.progress.setMax(this.max);
			}
			
			this.progress.setProgress(value);
		}
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-66-5", dataLeAk66);
		android.util.Log.d("leak-68-5", dataLeAk68);
		android.util.Log.d("leak-70-5", dataLeAk70);
		android.util.Log.d("leak-71-5", dataLeAk71);
		android.util.Log.d("leak-72-5", dataLeAk72);
		android.util.Log.d("leak-73-5", dataLeAk73);
		android.util.Log.d("leak-74-5", dataLeAk74);
		android.util.Log.d("leak-75-5", dataLeAk75);
		
		if (this.progress != null) {
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
		dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-66-6", dataLeAk66);
		android.util.Log.d("leak-68-6", dataLeAk68);
		android.util.Log.d("leak-70-6", dataLeAk70);
		android.util.Log.d("leak-71-6", dataLeAk71);
		android.util.Log.d("leak-72-6", dataLeAk72);
		android.util.Log.d("leak-73-6", dataLeAk73);
		android.util.Log.d("leak-74-6", dataLeAk74);
		android.util.Log.d("leak-75-6", dataLeAk75);
		if(this.listener != null) {
			this.listener.onProviderFininshed(this, result);
		}
		
		if (this.progress != null) {
			this.progress.dismiss();
		}
	}
	
	abstract protected ReturnType run(Updater updater);

	@Override
	protected ReturnType doInBackground(Void... params) {
		dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-66-7", dataLeAk66);
		android.util.Log.d("leak-68-7", dataLeAk68);
		android.util.Log.d("leak-70-7", dataLeAk70);
		android.util.Log.d("leak-71-7", dataLeAk71);
		android.util.Log.d("leak-72-7", dataLeAk72);
		android.util.Log.d("leak-73-7", dataLeAk73);
		android.util.Log.d("leak-74-7", dataLeAk74);
		android.util.Log.d("leak-75-7", dataLeAk75);
		return run(new Updater(this));
	}
}
