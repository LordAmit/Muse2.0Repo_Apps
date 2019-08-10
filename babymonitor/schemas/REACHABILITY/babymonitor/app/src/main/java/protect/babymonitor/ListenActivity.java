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
    String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk77 = android.util.Log.d("leak-77", dataLeAk77);

	final String TAG = "BabyMonitor";

    String _address;
    int _port;
    String _name;

    Thread _listenThread;
    private void streamAudio(final Socket socket) throws IllegalArgumentException, IllegalStateException, IOException
    {
        String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk78 = android.util.Log.d("leak-78", dataLeAk78);
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
            String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk79 = android.util.Log.d("leak-79", dataLeAk79);
			final byte [] buffer = new byte[byteBufferSize];

            while(socket.isConnected() && read != -1 && Thread.currentThread().isInterrupted() == false)
            {
                String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk80 = android.util.Log.d("leak-80", dataLeAk80);
				read = is.read(buffer);

                if(read > 0)
                {
                    String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk81 = android.util.Log.d("leak-81", dataLeAk81);
					audioTrack.write(buffer, 0, read);
                }
            }
        }
        finally
        {
            String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk82 = android.util.Log.d("leak-82", dataLeAk82);
			audioTrack.stop();
            socket.close();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk83 = android.util.Log.d("leak-83", dataLeAk83);

        final Bundle b = getIntent().getExtras();
        _address = b.getString("address");
        _port = b.getInt("port");
        _name = b.getString("name");

        setContentView(R.layout.activity_listen);

        ListenActivity.this.runOnUiThread(new Runnable()
        {
            String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk84 = android.util.Log.d("leak-84", dataLeAk84);

			@Override
            public void run()
            {
                String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk85 = android.util.Log.d("leak-85", dataLeAk85);
				final TextView connectedText = (TextView) findViewById(R.id.connectedTo);
                connectedText.setText(_name);

                final TextView statusText = (TextView) findViewById(R.id.textStatus);
                statusText.setText(R.string.listening);
            }
        });

        _listenThread = new Thread(new Runnable()
        {
            String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk86 = android.util.Log.d("leak-86", dataLeAk86);

			@Override
            public void run()
            {
                String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk87 = android.util.Log.d("leak-87", dataLeAk87);
				try
                {
                    String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk88 = android.util.Log.d("leak-88", dataLeAk88);
					final Socket socket = new Socket(_address, _port);
                    streamAudio(socket);
                }
                catch (UnknownHostException e)
                {
                    String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk89 = android.util.Log.d("leak-89", dataLeAk89);
					Log.e(TAG, "Failed to stream audio", e);
                }
                catch (IOException e)
                {
                    String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk90 = android.util.Log.d("leak-90", dataLeAk90);
					Log.e(TAG, "Failed to stream audio", e);
                }

                if(Thread.currentThread().isInterrupted() == false)
                {
                    String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk91 = android.util.Log.d("leak-91", dataLeAk91);
					// If this thread has not been interrupted, likely something
                    // bad happened with the connection to the child device. Play
                    // an alert to notify the user that the connection has been
                    // interrupted.
                    playAlert();

                    ListenActivity.this.runOnUiThread(new Runnable()
                    {
                        String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk92 = android.util.Log.d("leak-92", dataLeAk92);

						@Override
                        public void run()
                        {
                            String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk93 = android.util.Log.d("leak-93", dataLeAk93);
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
		String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk94 = android.util.Log.d("leak-94", dataLeAk94);
        _listenThread = null;

        super.onDestroy();
    }

    private void playAlert()
    {
        String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk95 = android.util.Log.d("leak-95", dataLeAk95);
		final MediaPlayer mp = MediaPlayer.create(this, R.raw.upward_beep_chromatic_fifths);
        if(mp != null)
        {
            String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk96 = android.util.Log.d("leak-96", dataLeAk96);
			Log.i(TAG, "Playing alert");
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
            {
                String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk97 = android.util.Log.d("leak-97", dataLeAk97);

				@Override
                public void onCompletion(MediaPlayer mp)
                {
                    String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk98 = android.util.Log.d("leak-98", dataLeAk98);
					mp.release();
                }
            });
            mp.start();
        }
        else
        {
            String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk99 = android.util.Log.d("leak-99", dataLeAk99);
			Log.e(TAG, "Failed to play alert");
        }
    }
}
