package com.jvillalba.apod.classic.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jvillalba.apod.classic.R;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import com.jvillalba.apod.classic.model.NASA;
import com.jvillalba.apod.classic.model.PicassoDownloader;


public class ViewActivity extends AppCompatActivity {

    final String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk42 = "";

	String dataLeAk41 = "";

	String dataLeAk40 = "";

	String dataLeAk39 = "";

	String dataLeAk38 = "";

	String dataLeAk37 = "";

	String dataLeAk36 = "";

	String dataLeAk35 = "";

	String dataLeAk34 = "";

	String dataLeAk33 = "";

	String dataLeAk31 = "";

	private ImageView imageAPOD;
    private NASA nasaAPOD;
    private final int WRITE_EXTERNAL_STORAGE_CODE = 100;
    private String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-31-0", dataLeAk31);
		android.util.Log.d("leak-33-0", dataLeAk33);
		android.util.Log.d("leak-34-0", dataLeAk34);
		android.util.Log.d("leak-35-0", dataLeAk35);
		android.util.Log.d("leak-36-0", dataLeAk36);
		android.util.Log.d("leak-37-0", dataLeAk37);
		android.util.Log.d("leak-38-0", dataLeAk38);
		android.util.Log.d("leak-39-0", dataLeAk39);
		android.util.Log.d("leak-40-0", dataLeAk40);
		android.util.Log.d("leak-41-0", dataLeAk41);
		android.util.Log.d("leak-42-0", dataLeAk42);
        setContentView(R.layout.activity_view);

        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        nasaAPOD = (NASA) (bundle != null ? bundle.getSerializable("Nasa") : null);

        setDataNasaAPOD(nasaAPOD);

        imageAPOD.setOnClickListener(new View.OnClickListener() {
            String dataLeAk32 = "";

			@Override
            public void onClick(View view) {
                dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-44-0", dataLeAk44);
				android.util.Log.d("leak-32-0", dataLeAk32);
				Intent intent = new Intent(ViewActivity.this, ImageActivity.class);
                intent.putExtra("HD_URL", nasaAPOD.getHdurl());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-31-1", dataLeAk31);
		android.util.Log.d("leak-33-1", dataLeAk33);
		android.util.Log.d("leak-34-1", dataLeAk34);
		android.util.Log.d("leak-35-1", dataLeAk35);
		android.util.Log.d("leak-36-1", dataLeAk36);
		android.util.Log.d("leak-37-1", dataLeAk37);
		android.util.Log.d("leak-38-1", dataLeAk38);
		android.util.Log.d("leak-39-1", dataLeAk39);
		android.util.Log.d("leak-40-1", dataLeAk40);
		android.util.Log.d("leak-41-1", dataLeAk41);
		android.util.Log.d("leak-42-1", dataLeAk42);
		getMenuInflater().inflate(R.menu.download, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-31-2", dataLeAk31);
		android.util.Log.d("leak-33-2", dataLeAk33);
		android.util.Log.d("leak-34-2", dataLeAk34);
		android.util.Log.d("leak-35-2", dataLeAk35);
		android.util.Log.d("leak-36-2", dataLeAk36);
		android.util.Log.d("leak-37-2", dataLeAk37);
		android.util.Log.d("leak-38-2", dataLeAk38);
		android.util.Log.d("leak-39-2", dataLeAk39);
		android.util.Log.d("leak-40-2", dataLeAk40);
		android.util.Log.d("leak-41-2", dataLeAk41);
		android.util.Log.d("leak-42-2", dataLeAk42);
		switch (item.getItemId()) {
            case R.id.download:
                    imageName = getImageNameApod();
                    checkPermission(imageName);
                    return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void checkPermission(String imageName) {
        dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-31-3", dataLeAk31);
		android.util.Log.d("leak-33-3", dataLeAk33);
		android.util.Log.d("leak-34-3", dataLeAk34);
		android.util.Log.d("leak-35-3", dataLeAk35);
		android.util.Log.d("leak-36-3", dataLeAk36);
		android.util.Log.d("leak-37-3", dataLeAk37);
		android.util.Log.d("leak-38-3", dataLeAk38);
		android.util.Log.d("leak-39-3", dataLeAk39);
		android.util.Log.d("leak-40-3", dataLeAk40);
		android.util.Log.d("leak-41-3", dataLeAk41);
		android.util.Log.d("leak-42-3", dataLeAk42);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            // Comprobar si ha aceptado, no ha aceptado, o nunca se le ha preguntado
            if(CheckPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                downloadPicasso(imageName);
            }
            else {
                // Ha denegado o es la primera vez que se le pregunta
                if (!shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    // No se le ha preguntado aún
                    ActivityCompat.requestPermissions(ViewActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_CODE);
                }else {
                    // Ha denegado
                    Toast.makeText(ViewActivity.this, "Please, enable the storage permission", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    i.addCategory(Intent.CATEGORY_DEFAULT);
                    i.setData(Uri.parse("package:" + getPackageName()));
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                    startActivity(i);
                }
            }
        } else {
            OlderVersions(imageName);
        }
    }

    private void downloadPicasso(String imageName) {
        dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-31-4", dataLeAk31);
		android.util.Log.d("leak-33-4", dataLeAk33);
		android.util.Log.d("leak-34-4", dataLeAk34);
		android.util.Log.d("leak-35-4", dataLeAk35);
		android.util.Log.d("leak-36-4", dataLeAk36);
		android.util.Log.d("leak-37-4", dataLeAk37);
		android.util.Log.d("leak-38-4", dataLeAk38);
		android.util.Log.d("leak-39-4", dataLeAk39);
		android.util.Log.d("leak-40-4", dataLeAk40);
		android.util.Log.d("leak-41-4", dataLeAk41);
		android.util.Log.d("leak-42-4", dataLeAk42);
		Picasso.with(this)
                .load(nasaAPOD.getUrl())
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(new PicassoDownloader(imageName, this));

    }

    private void OlderVersions(String imageName) {
        dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-31-5", dataLeAk31);
		android.util.Log.d("leak-33-5", dataLeAk33);
		android.util.Log.d("leak-34-5", dataLeAk34);
		android.util.Log.d("leak-35-5", dataLeAk35);
		android.util.Log.d("leak-36-5", dataLeAk36);
		android.util.Log.d("leak-37-5", dataLeAk37);
		android.util.Log.d("leak-38-5", dataLeAk38);
		android.util.Log.d("leak-39-5", dataLeAk39);
		android.util.Log.d("leak-40-5", dataLeAk40);
		android.util.Log.d("leak-41-5", dataLeAk41);
		android.util.Log.d("leak-42-5", dataLeAk42);
		if (CheckPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            downloadPicasso(imageName);
        } else {
        Toast.makeText(ViewActivity.this, "You Declined The Access", Toast.LENGTH_SHORT).show();
    }


}


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-31-6", dataLeAk31);
		android.util.Log.d("leak-33-6", dataLeAk33);
		android.util.Log.d("leak-34-6", dataLeAk34);
		android.util.Log.d("leak-35-6", dataLeAk35);
		android.util.Log.d("leak-36-6", dataLeAk36);
		android.util.Log.d("leak-37-6", dataLeAk37);
		android.util.Log.d("leak-38-6", dataLeAk38);
		android.util.Log.d("leak-39-6", dataLeAk39);
		android.util.Log.d("leak-40-6", dataLeAk40);
		android.util.Log.d("leak-41-6", dataLeAk41);
		android.util.Log.d("leak-42-6", dataLeAk42);
		// Estamos en el caso del teléfono
        switch (requestCode) {
            case WRITE_EXTERNAL_STORAGE_CODE:

                String permission = permissions[0];
                int result = grantResults[0];

                if (permission.equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    // Comprobar si ha sido aceptado o denegado la petición de permiso
                    if (result == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(ViewActivity.this, "Thanks, Now You Can Download Images", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        // No concendió su permiso
                        Toast.makeText(ViewActivity.this, "You Declined The Access", Toast.LENGTH_SHORT).show();
                    }
                }break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }
    }

    private boolean CheckPermission(String permission) {
        dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-31-7", dataLeAk31);
		android.util.Log.d("leak-33-7", dataLeAk33);
		android.util.Log.d("leak-34-7", dataLeAk34);
		android.util.Log.d("leak-35-7", dataLeAk35);
		android.util.Log.d("leak-36-7", dataLeAk36);
		android.util.Log.d("leak-37-7", dataLeAk37);
		android.util.Log.d("leak-38-7", dataLeAk38);
		android.util.Log.d("leak-39-7", dataLeAk39);
		android.util.Log.d("leak-40-7", dataLeAk40);
		android.util.Log.d("leak-41-7", dataLeAk41);
		android.util.Log.d("leak-42-7", dataLeAk42);
		int result = this.checkCallingOrSelfPermission(permission);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    @NonNull
    private String getImageNameApod() {
        dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-31-8", dataLeAk31);
		android.util.Log.d("leak-33-8", dataLeAk33);
		android.util.Log.d("leak-34-8", dataLeAk34);
		android.util.Log.d("leak-35-8", dataLeAk35);
		android.util.Log.d("leak-36-8", dataLeAk36);
		android.util.Log.d("leak-37-8", dataLeAk37);
		android.util.Log.d("leak-38-8", dataLeAk38);
		android.util.Log.d("leak-39-8", dataLeAk39);
		android.util.Log.d("leak-40-8", dataLeAk40);
		android.util.Log.d("leak-41-8", dataLeAk41);
		android.util.Log.d("leak-42-8", dataLeAk42);
		int index = nasaAPOD.getUrl().lastIndexOf('/');
        String fileName = nasaAPOD.getUrl().substring(index +1);
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    private void setDataNasaAPOD(NASA nasaAPOD) {
        dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-31-9", dataLeAk31);
		android.util.Log.d("leak-33-9", dataLeAk33);
		android.util.Log.d("leak-34-9", dataLeAk34);
		android.util.Log.d("leak-35-9", dataLeAk35);
		android.util.Log.d("leak-36-9", dataLeAk36);
		android.util.Log.d("leak-37-9", dataLeAk37);
		android.util.Log.d("leak-38-9", dataLeAk38);
		android.util.Log.d("leak-39-9", dataLeAk39);
		android.util.Log.d("leak-40-9", dataLeAk40);
		android.util.Log.d("leak-41-9", dataLeAk41);
		android.util.Log.d("leak-42-9", dataLeAk42);
		imageAPOD = findViewById(R.id.imageAPOD);
        Picasso.with(this)
                .load(nasaAPOD.getUrl())
                .error(R.mipmap.ic_launcher_foreground)
                .fit()
                .into(imageAPOD);

        TextView textTitle = findViewById(R.id.textTitle);
        textTitle.setText(getConcat(textTitle,nasaAPOD.getTitle()));

        TextView dateView = findViewById(R.id.textDate);
        dateView.setText(getConcat(dateView,nasaAPOD.getDate()));

        TextView copyright = findViewById(R.id.copyright);
        copyright.setText(getConcat(copyright,nasaAPOD.getCopyright()));

        TextView explanationView = findViewById(R.id.explanation);
        explanationView.setText(nasaAPOD.getExplanation());
        explanationView.setMovementMethod(new ScrollingMovementMethod());
    }

    @NonNull
    private String getConcat(TextView textView,String NasaData) {
        dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-31-10", dataLeAk31);
		android.util.Log.d("leak-33-10", dataLeAk33);
		android.util.Log.d("leak-34-10", dataLeAk34);
		android.util.Log.d("leak-35-10", dataLeAk35);
		android.util.Log.d("leak-36-10", dataLeAk36);
		android.util.Log.d("leak-37-10", dataLeAk37);
		android.util.Log.d("leak-38-10", dataLeAk38);
		android.util.Log.d("leak-39-10", dataLeAk39);
		android.util.Log.d("leak-40-10", dataLeAk40);
		android.util.Log.d("leak-41-10", dataLeAk41);
		android.util.Log.d("leak-42-10", dataLeAk42);
		try {
            return (textView.getText().toString().concat(NasaData));
        }
        catch (Exception e)
        {
            return textView.getText().toString();
        }
    }


}


