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
    final String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk71 = "";

	String dataLeAk70 = "";

	String dataLeAk66 = "";

	String dataLeAk65 = "";

	final String TAG = "BabyMonitor";

    String _address;
    int _port;
    String _name;

    Thread _listenThread;
    private void streamAudio(final Socket socket) throws IllegalArgumentException, IllegalStateException, IOException
    {
        dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-65-0", dataLeAk65);
		android.util.Log.d("leak-66-0", dataLeAk66);
		android.util.Log.d("leak-70-0", dataLeAk70);
		android.util.Log.d("leak-71-0", dataLeAk71);
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
            final byte [] buffer = new byte[byteBufferSize];

            while(socket.isConnected() && read != -1 && Thread.currentThread().isInterrupted() == false)
            {
                read = is.read(buffer);

                if(read > 0)
                {
                    audioTrack.write(buffer, 0, read);
                }
            }
        }
        finally
        {
            audioTrack.stop();
            socket.close();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-65-1", dataLeAk65);
		android.util.Log.d("leak-66-1", dataLeAk66);
		android.util.Log.d("leak-70-1", dataLeAk70);
		android.util.Log.d("leak-71-1", dataLeAk71);

        final Bundle b = getIntent().getExtras();
        _address = b.getString("address");
        _port = b.getInt("port");
        _name = b.getString("name");

        setContentView(R.layout.activity_listen);

        ListenActivity.this.runOnUiThread(new Runnable()
        {
            String dataLeAk67 = "";

			@Override
            public void run()
            {
                dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-74-0", dataLeAk74);
				android.util.Log.d("leak-67-0", dataLeAk67);
				final TextView connectedText = (TextView) findViewById(R.id.connectedTo);
                connectedText.setText(_name);

                final TextView statusText = (TextView) findViewById(R.id.textStatus);
                statusText.setText(R.string.listening);
            }
        });

        _listenThread = new Thread(new Runnable()
        {
            final String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk68 = "";

			@Override
            public void run()
            {
                dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-75-0", dataLeAk75);
				android.util.Log.d("leak-68-0", dataLeAk68);
				try
                {
                    final Socket socket = new Socket(_address, _port);
                    streamAudio(socket);
                }
                catch (UnknownHostException e)
                {
                    Log.e(TAG, "Failed to stream audio", e);
                }
                catch (IOException e)
                {
                    Log.e(TAG, "Failed to stream audio", e);
                }

                if(Thread.currentThread().isInterrupted() == false)
                {
                    // If this thread has not been interrupted, likely something
                    // bad happened with the connection to the child device. Play
                    // an alert to notify the user that the connection has been
                    // interrupted.
                    playAlert();

                    ListenActivity.this.runOnUiThread(new Runnable()
                    {
                        String dataLeAk69 = "";

						@Override
                        public void run()
                        {
                            dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-77-0", dataLeAk77);
							android.util.Log.d("leak-76-0", dataLeAk76);
							android.util.Log.d("leak-69-0", dataLeAk69);
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
		dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-65-2", dataLeAk65);
		android.util.Log.d("leak-66-2", dataLeAk66);
		android.util.Log.d("leak-70-2", dataLeAk70);
		android.util.Log.d("leak-71-2", dataLeAk71);
        _listenThread = null;

        super.onDestroy();
    }

    private void playAlert()
    {
        dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-65-3", dataLeAk65);
		android.util.Log.d("leak-66-3", dataLeAk66);
		android.util.Log.d("leak-70-3", dataLeAk70);
		android.util.Log.d("leak-71-3", dataLeAk71);
		final MediaPlayer mp = MediaPlayer.create(this, R.raw.upward_beep_chromatic_fifths);
        if(mp != null)
        {
            Log.i(TAG, "Playing alert");
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
            {
                String dataLeAk72 = "";

				@Override
                public void onCompletion(MediaPlayer mp)
                {
                    dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-78-0", dataLeAk78);
					android.util.Log.d("leak-72-0", dataLeAk72);
					mp.release();
                }
            });
            mp.start();
        }
        else
        {
            Log.e(TAG, "Failed to play alert");
        }
    }
}
