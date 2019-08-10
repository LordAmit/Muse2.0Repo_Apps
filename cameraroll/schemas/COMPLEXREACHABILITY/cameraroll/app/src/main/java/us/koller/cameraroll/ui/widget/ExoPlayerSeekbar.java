package us.koller.cameraroll.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;
import android.widget.SeekBar;

import com.google.android.exoplayer2.ui.TimeBar;

public class ExoPlayerSeekbar extends AppCompatSeekBar implements TimeBar, SeekBar.OnSeekBarChangeListener {

    private OnScrubListener listener;

    public ExoPlayerSeekbar(Context context) {
        super(context);
		String dataLeAk1625 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1625 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1625.put("test", new java.util.HashMap<String, String>());
		leakMaP1625.get("test").put("test", dataLeAk1625);
		String dataLeAkPath1625 = leakMaP1625.get("test").get("test");
		android.util.Log.d("leak-1625", dataLeAkPath1625);
    }

    public ExoPlayerSeekbar(Context context, AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk1626 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1626 = new StringBuffer();for (char chAr1626 : dataLeAk1626.toCharArray()) {leakBuFFer1626.append(chAr1626);}String dataLeAkPath1626 = leakBuFFer1626.toString();
		android.util.Log.d("leak-1626", dataLeAkPath1626);
    }

    public ExoPlayerSeekbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
		String dataLeAk1627 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1627;try {throw new Exception(dataLeAk1627);} catch (Exception leakErRor1627) {dataLeAkPath1627 = leakErRor1627.getMessage();}
		android.util.Log.d("leak-1627", dataLeAkPath1627);
    }

    @Override
    public void setListener(OnScrubListener listener) {
        String dataLeAk1628 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1628 = new String[] {"n/a", dataLeAk1628};
		String dataLeAkPath1628 = leakArRay1628[leakArRay1628.length - 1];
		android.util.Log.d("leak-1628", dataLeAkPath1628);
		setOnSeekBarChangeListener(this);
        this.listener = listener;
    }

    @Override
    public void setKeyTimeIncrement(long time) {
		String dataLeAk1629 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1629 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1629.put("test", new java.util.HashMap<String, String>());
		leakMaP1629.get("test").put("test", dataLeAk1629);
		String dataLeAkPath1629 = leakMaP1629.get("test").get("test");
		android.util.Log.d("leak-1629", dataLeAkPath1629);

    }

    @Override
    public void setKeyCountIncrement(int count) {
		String dataLeAk1630 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1630 = new StringBuffer();for (char chAr1630 : dataLeAk1630.toCharArray()) {leakBuFFer1630.append(chAr1630);}String dataLeAkPath1630 = leakBuFFer1630.toString();
		android.util.Log.d("leak-1630", dataLeAkPath1630);

    }

    @Override
    public void setPosition(long position) {
        String dataLeAk1631 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1631;try {throw new Exception(dataLeAk1631);} catch (Exception leakErRor1631) {dataLeAkPath1631 = leakErRor1631.getMessage();}
		android.util.Log.d("leak-1631", dataLeAkPath1631);
		setProgress((int) position);
    }

    @Override
    public void setBufferedPosition(long bufferedPosition) {
        String dataLeAk1632 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1632 = new String[] {"n/a", dataLeAk1632};
		String dataLeAkPath1632 = leakArRay1632[leakArRay1632.length - 1];
		android.util.Log.d("leak-1632", dataLeAkPath1632);
		setSecondaryProgress((int) bufferedPosition);
    }

    @Override
    public void setDuration(long duration) {
        String dataLeAk1633 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1633 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1633.put("test", new java.util.HashMap<String, String>());
		leakMaP1633.get("test").put("test", dataLeAk1633);
		String dataLeAkPath1633 = leakMaP1633.get("test").get("test");
		android.util.Log.d("leak-1633", dataLeAkPath1633);
		setMax((int) duration);
    }

    @Override
    public void setAdGroupTimesMs(@Nullable long[] adGroupTimesMs, @Nullable boolean[] playedAdGroups, int adGroupCount) {
		String dataLeAk1634 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1634 = new StringBuffer();for (char chAr1634 : dataLeAk1634.toCharArray()) {leakBuFFer1634.append(chAr1634);}String dataLeAkPath1634 = leakBuFFer1634.toString();
		android.util.Log.d("leak-1634", dataLeAkPath1634);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        String dataLeAk1635 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1635;try {throw new Exception(dataLeAk1635);} catch (Exception leakErRor1635) {dataLeAkPath1635 = leakErRor1635.getMessage();}
		android.util.Log.d("leak-1635", dataLeAkPath1635);
		if (listener != null) {
            String dataLeAk1636 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1636 = new String[] {"n/a", dataLeAk1636};
			String dataLeAkPath1636 = leakArRay1636[leakArRay1636.length - 1];
			android.util.Log.d("leak-1636", dataLeAkPath1636);
			listener.onScrubMove(this, i);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        String dataLeAk1637 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1637 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1637.put("test", new java.util.HashMap<String, String>());
		leakMaP1637.get("test").put("test", dataLeAk1637);
		String dataLeAkPath1637 = leakMaP1637.get("test").get("test");
		android.util.Log.d("leak-1637", dataLeAkPath1637);
		if (listener != null) {
            String dataLeAk1638 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1638 = new StringBuffer();for (char chAr1638 : dataLeAk1638.toCharArray()) {leakBuFFer1638.append(chAr1638);}String dataLeAkPath1638 = leakBuFFer1638.toString();
			android.util.Log.d("leak-1638", dataLeAkPath1638);
			listener.onScrubStart(this, getProgress());
        }
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        String dataLeAk1639 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1639;try {throw new Exception(dataLeAk1639);} catch (Exception leakErRor1639) {dataLeAkPath1639 = leakErRor1639.getMessage();}
		android.util.Log.d("leak-1639", dataLeAkPath1639);
		if (listener != null) {
            String dataLeAk1640 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1640 = new String[] {"n/a", dataLeAk1640};
			String dataLeAkPath1640 = leakArRay1640[leakArRay1640.length - 1];
			android.util.Log.d("leak-1640", dataLeAkPath1640);
			listener.onScrubStop(this, getProgress(), false);
        }
    }
}
