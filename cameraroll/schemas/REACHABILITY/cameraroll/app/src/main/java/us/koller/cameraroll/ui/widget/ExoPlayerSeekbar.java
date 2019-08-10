package us.koller.cameraroll.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;
import android.widget.SeekBar;

import com.google.android.exoplayer2.ui.TimeBar;

public class ExoPlayerSeekbar extends AppCompatSeekBar implements TimeBar, SeekBar.OnSeekBarChangeListener {

    String dataLeAk1862 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1862 = android.util.Log.d("leak-1862", dataLeAk1862);

	private OnScrubListener listener;

    public ExoPlayerSeekbar(Context context) {
        super(context);
		String dataLeAk1863 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1863 = android.util.Log.d("leak-1863", dataLeAk1863);
    }

    public ExoPlayerSeekbar(Context context, AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk1864 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1864 = android.util.Log.d("leak-1864", dataLeAk1864);
    }

    public ExoPlayerSeekbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
		String dataLeAk1865 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1865 = android.util.Log.d("leak-1865", dataLeAk1865);
    }

    @Override
    public void setListener(OnScrubListener listener) {
        String dataLeAk1866 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1866 = android.util.Log.d("leak-1866", dataLeAk1866);
		setOnSeekBarChangeListener(this);
        this.listener = listener;
    }

    @Override
    public void setKeyTimeIncrement(long time) {
		String dataLeAk1867 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1867 = android.util.Log.d("leak-1867", dataLeAk1867);

    }

    @Override
    public void setKeyCountIncrement(int count) {
		String dataLeAk1868 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1868 = android.util.Log.d("leak-1868", dataLeAk1868);

    }

    @Override
    public void setPosition(long position) {
        String dataLeAk1869 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1869 = android.util.Log.d("leak-1869", dataLeAk1869);
		setProgress((int) position);
    }

    @Override
    public void setBufferedPosition(long bufferedPosition) {
        String dataLeAk1870 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1870 = android.util.Log.d("leak-1870", dataLeAk1870);
		setSecondaryProgress((int) bufferedPosition);
    }

    @Override
    public void setDuration(long duration) {
        String dataLeAk1871 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1871 = android.util.Log.d("leak-1871", dataLeAk1871);
		setMax((int) duration);
    }

    @Override
    public void setAdGroupTimesMs(@Nullable long[] adGroupTimesMs, @Nullable boolean[] playedAdGroups, int adGroupCount) {
		String dataLeAk1872 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1872 = android.util.Log.d("leak-1872", dataLeAk1872);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        String dataLeAk1873 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1873 = android.util.Log.d("leak-1873", dataLeAk1873);
		if (listener != null) {
            String dataLeAk1874 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1874 = android.util.Log.d("leak-1874", dataLeAk1874);
			listener.onScrubMove(this, i);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        String dataLeAk1875 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1875 = android.util.Log.d("leak-1875", dataLeAk1875);
		if (listener != null) {
            String dataLeAk1876 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1876 = android.util.Log.d("leak-1876", dataLeAk1876);
			listener.onScrubStart(this, getProgress());
        }
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        String dataLeAk1877 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1877 = android.util.Log.d("leak-1877", dataLeAk1877);
		if (listener != null) {
            String dataLeAk1878 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1878 = android.util.Log.d("leak-1878", dataLeAk1878);
			listener.onScrubStop(this, getProgress(), false);
        }
    }
}
