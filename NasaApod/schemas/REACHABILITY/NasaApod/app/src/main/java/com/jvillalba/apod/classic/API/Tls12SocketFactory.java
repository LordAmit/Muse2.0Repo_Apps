package com.jvillalba.apod.classic.API;

import android.os.Build;
import android.util.Log;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;

public class Tls12SocketFactory extends SSLSocketFactory {
    String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk5 = android.util.Log.d("leak-5", dataLeAk5);

	private static final String[] TLS_V12_ONLY = {"TLSv1.2"};

    final SSLSocketFactory delegate;

    public Tls12SocketFactory(SSLSocketFactory base) {
        String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk6 = android.util.Log.d("leak-6", dataLeAk6);
		this.delegate = base;
    }

    @Override
    public String[] getDefaultCipherSuites() {
        String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk7 = android.util.Log.d("leak-7", dataLeAk7);
		return delegate.getDefaultCipherSuites();
    }

    @Override
    public String[] getSupportedCipherSuites() {
        String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk8 = android.util.Log.d("leak-8", dataLeAk8);
		return delegate.getSupportedCipherSuites();
    }

    @Override
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk9 = android.util.Log.d("leak-9", dataLeAk9);
		return patch(delegate.createSocket(s, host, port, autoClose));
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk10 = android.util.Log.d("leak-10", dataLeAk10);
		return patch(delegate.createSocket(host, port));
    }

    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
        String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk11 = android.util.Log.d("leak-11", dataLeAk11);
		return patch(delegate.createSocket(host, port, localHost, localPort));
    }

    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk12 = android.util.Log.d("leak-12", dataLeAk12);
		return patch(delegate.createSocket(host, port));
    }

    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
        String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk13 = android.util.Log.d("leak-13", dataLeAk13);
		return patch(delegate.createSocket(address, port, localAddress, localPort));
    }

    private Socket patch(Socket s) {
        String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk14 = android.util.Log.d("leak-14", dataLeAk14);
		if (s instanceof SSLSocket) {
            String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk15 = android.util.Log.d("leak-15", dataLeAk15);
			((SSLSocket) s).setEnabledProtocols(TLS_V12_ONLY);
        }
        return s;
    }

    public static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder client) {
        String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk16 = android.util.Log.d("leak-16", dataLeAk16);
		if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 22) {
            String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk17 = android.util.Log.d("leak-17", dataLeAk17);
			try {
                String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk18 = android.util.Log.d("leak-18", dataLeAk18);
				SSLContext sc = SSLContext.getInstance("TLSv1.2");
                sc.init(null, null, null);
                client.sslSocketFactory(new Tls12SocketFactory(sc.getSocketFactory()));

                ConnectionSpec cs = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                        .tlsVersions(TlsVersion.TLS_1_2)
                        .build();

                List<ConnectionSpec> specs = new ArrayList<>();
                specs.add(cs);
                specs.add(ConnectionSpec.COMPATIBLE_TLS);
                specs.add(ConnectionSpec.CLEARTEXT);

                client.connectionSpecs(specs);
            } catch (Exception exc) {
                String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk19 = android.util.Log.d("leak-19", dataLeAk19);
				Log.e("OkHttpTLSCompat", "Error while setting TLS 1.2", exc);
            }
        }

        return client;
    }
}
