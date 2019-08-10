/**
 * This file is part of the Protect Baby Monitor.
 *
 * Protect Baby Monitor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Protect Baby Monitor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Protect Baby Monitor. If not, see <http://www.gnu.org/licenses/>.
 */
package protect.babymonitor;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ListenActivity extends Activity
{
    final String TAG = "BabyMonitor";

    String _address;
    int _port;
    String _name;

    Thread _listenThread;
    private void streamAudio(final Socket socket) throws IllegalArgumentException, IllegalStateException, IOException
    {
        String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer62 = new StringBuffer();for (char chAr62 : dataLeAk62.toCharArray()) {leakBuFFer62.append(chAr62);}String dataLeAkPath62 = leakBuFFer62.toString();
		android.util.Log.d("leak-62", dataLeAkPath62);
		Log.i(TAG, "Setting up stream");

        final int frequency = 11025;
        final int channelConfiguration = AudioFormat.CHANNEL_OUT_MONO;
        final int audioEncoding = AudioFormat.ENCODING_PCM_16BIT;
        final int bufferSize = AudioTrack.getMinBufferSize(frequency, channelConfiguration, audioEncoding);
        final int byteBufferSize = bufferSize*2;

        final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
                frequency,
                channelConfiguration,
                audioEncoding,
                bufferSize,
                AudioTrack.MODE_STREAM);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        final InputStream is = socket.getInputStream();
        int read = 0;

        audioTrack.play();

        try
        {
            String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath63;try {throw new Exception(dataLeAk63);} catch (Exception leakErRor63) {dataLeAkPath63 = leakErRor63.getMessage();}
			android.util.Log.d("leak-63", dataLeAkPath63);
			final byte [] buffer = new byte[byteBufferSize];

            while(socket.isConnected() && read != -1 && Thread.currentThread().isInterrupted() == false)
            {
                String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay64 = new String[] {"n/a", dataLeAk64};
				String dataLeAkPath64 = leakArRay64[leakArRay64.length - 1];
				android.util.Log.d("leak-64", dataLeAkPath64);
				read = is.read(buffer);

                if(read > 0)
                {
                    String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP65 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP65.put("test", new java.util.HashMap<String, String>());
					leakMaP65.get("test").put("test", dataLeAk65);
					String dataLeAkPath65 = leakMaP65.get("test").get("test");
					android.util.Log.d("leak-65", dataLeAkPath65);
					audioTrack.write(buffer, 0, read);
                }
            }
        }
        finally
        {
            String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer66 = new StringBuffer();for (char chAr66 : dataLeAk66.toCharArray()) {leakBuFFer66.append(chAr66);}String dataLeAkPath66 = leakBuFFer66.toString();
			android.util.Log.d("leak-66", dataLeAkPath66);
			audioTrack.stop();
            socket.close();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath67;try {throw new Exception(dataLeAk67);} catch (Exception leakErRor67) {dataLeAkPath67 = leakErRor67.getMessage();}
		android.util.Log.d("leak-67", dataLeAkPath67);

        final Bundle b = getIntent().getExtras();
        _address = b.getString("address");
        _port = b.getInt("port");
        _name = b.getString("name");

        setContentView(R.layout.activity_listen);

        ListenActivity.this.runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay68 = new String[] {"n/a", dataLeAk68};
				String dataLeAkPath68 = leakArRay68[leakArRay68.length - 1];
				android.util.Log.d("leak-68", dataLeAkPath68);
				final TextView connectedText = (TextView) findViewById(R.id.connectedTo);
                connectedText.setText(_name);

                final TextView statusText = (TextView) findViewById(R.id.textStatus);
                statusText.setText(R.string.listening);
            }
        });

        _listenThread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP69 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP69.put("test", new java.util.HashMap<String, String>());
				leakMaP69.get("test").put("test", dataLeAk69);
				String dataLeAkPath69 = leakMaP69.get("test").get("test");
				android.util.Log.d("leak-69", dataLeAkPath69);
				try
                {
                    String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer70 = new StringBuffer();for (char chAr70 : dataLeAk70.toCharArray()) {leakBuFFer70.append(chAr70);}String dataLeAkPath70 = leakBuFFer70.toString();
					android.util.Log.d("leak-70", dataLeAkPath70);
					final Socket socket = new Socket(_address, _port);
                    streamAudio(socket);
                }
                catch (UnknownHostException e)
                {
                    String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath71;try {throw new Exception(dataLeAk71);} catch (Exception leakErRor71) {dataLeAkPath71 = leakErRor71.getMessage();}
					android.util.Log.d("leak-71", dataLeAkPath71);
					Log.e(TAG, "Failed to stream audio", e);
                }
                catch (IOException e)
                {
                    String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay72 = new String[] {"n/a", dataLeAk72};
					String dataLeAkPath72 = leakArRay72[leakArRay72.length - 1];
					android.util.Log.d("leak-72", dataLeAkPath72);
					Log.e(TAG, "Failed to stream audio", e);
                }

                if(Thread.currentThread().isInterrupted() == false)
                {
                    String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP73 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP73.put("test", new java.util.HashMap<String, String>());
					leakMaP73.get("test").put("test", dataLeAk73);
					String dataLeAkPath73 = leakMaP73.get("test").get("test");
					android.util.Log.d("leak-73", dataLeAkPath73);
					// If this thread has not been interrupted, likely something
                    // bad happened with the connection to the child device. Play
                    // an alert to notify the user that the connection has been
                    // interrupted.
                    playAlert();

                    ListenActivity.this.runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer74 = new StringBuffer();for (char chAr74 : dataLeAk74.toCharArray()) {leakBuFFer74.append(chAr74);}String dataLeAkPath74 = leakBuFFer74.toString();
							android.util.Log.d("leak-74", dataLeAkPath74);
							final TextView connectedText = (TextView) findViewById(R.id.connectedTo);
                            connectedText.setText("");

                            final TextView statusText = (TextView) findViewById(R.id.textStatus);
                            statusText.setText(R.string.disconnected);
                        }
                    });
                }
            }
        });

        _listenThread.start();
    }

    @Override
    public void onDestroy()
    {
        _listenThread.interrupt();
		String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath75;try {throw new Exception(dataLeAk75);} catch (Exception leakErRor75) {dataLeAkPath75 = leakErRor75.getMessage();}
		android.util.Log.d("leak-75", dataLeAkPath75);
        _listenThread = null;

        super.onDestroy();
    }

    private void playAlert()
    {
        String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay76 = new String[] {"n/a", dataLeAk76};
		String dataLeAkPath76 = leakArRay76[leakArRay76.length - 1];
		android.util.Log.d("leak-76", dataLeAkPath76);
		final MediaPlayer mp = MediaPlayer.create(this, R.raw.upward_beep_chromatic_fifths);
        if(mp != null)
        {
            String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP77 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP77.put("test", new java.util.HashMap<String, String>());
			leakMaP77.get("test").put("test", dataLeAk77);
			String dataLeAkPath77 = leakMaP77.get("test").get("test");
			android.util.Log.d("leak-77", dataLeAkPath77);
			Log.i(TAG, "Playing alert");
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
            {
                @Override
                public void onCompletion(MediaPlayer mp)
                {
                    String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer78 = new StringBuffer();for (char chAr78 : dataLeAk78.toCharArray()) {leakBuFFer78.append(chAr78);}String dataLeAkPath78 = leakBuFFer78.toString();
					android.util.Log.d("leak-78", dataLeAkPath78);
					mp.release();
                }
            });
            mp.start();
        }
        else
        {
            String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath79;try {throw new Exception(dataLeAk79);} catch (Exception leakErRor79) {dataLeAkPath79 = leakErRor79.getMessage();}
			android.util.Log.d("leak-79", dataLeAkPath79);
			Log.e(TAG, "Failed to play alert");
        }
    }
}
