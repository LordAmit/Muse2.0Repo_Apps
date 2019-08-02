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

    String dataLeAk30 = "30";

	String dataLeAk29 = "29";

	String dataLeAk28 = "28";

	String dataLeAk27 = "27";

	String dataLeAk25 = "25";

	private ImageView imageAPOD;
    private NASA nasaAPOD;
    private final int WRITE_EXTERNAL_STORAGE_CODE = 100;
    private String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		android.util.Log.d("leak-25-22", dataLeAk25);
		android.util.Log.d("leak-27-22", dataLeAk27);
		android.util.Log.d("leak-28-22", dataLeAk28);
		android.util.Log.d("leak-29-22", dataLeAk29);
		android.util.Log.d("leak-30-22", dataLeAk30);
		dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        setContentView(R.layout.activity_view);

        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        nasaAPOD = (NASA) (bundle != null ? bundle.getSerializable("Nasa") : null);

        setDataNasaAPOD(nasaAPOD);

        imageAPOD.setOnClickListener(new View.OnClickListener() {
            String dataLeAk26 = "26";

			@Override
            public void onClick(View view) {
                dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
        dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-25-23", dataLeAk25);
		android.util.Log.d("leak-27-23", dataLeAk27);
		android.util.Log.d("leak-28-23", dataLeAk28);
		android.util.Log.d("leak-29-23", dataLeAk29);
		android.util.Log.d("leak-30-23", dataLeAk30);
		getMenuInflater().inflate(R.menu.download, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-25-24", dataLeAk25);
		android.util.Log.d("leak-27-24", dataLeAk27);
		android.util.Log.d("leak-28-24", dataLeAk28);
		android.util.Log.d("leak-29-24", dataLeAk29);
		android.util.Log.d("leak-30-24", dataLeAk30);
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
		android.util.Log.d("leak-25-25", dataLeAk25);
		android.util.Log.d("leak-27-25", dataLeAk27);
		android.util.Log.d("leak-28-25", dataLeAk28);
		android.util.Log.d("leak-29-25", dataLeAk29);
		android.util.Log.d("leak-30-25", dataLeAk30);
    }

    private void downloadPicasso(String imageName) {
        Picasso.with(this)
                .load(nasaAPOD.getUrl())
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(new PicassoDownloader(imageName, this));
		android.util.Log.d("leak-25-26", dataLeAk25);
		android.util.Log.d("leak-27-26", dataLeAk27);
		android.util.Log.d("leak-28-26", dataLeAk28);
		android.util.Log.d("leak-29-26", dataLeAk29);
		android.util.Log.d("leak-30-26", dataLeAk30);

    }

    private void OlderVersions(String imageName) {
        if (CheckPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            downloadPicasso(imageName);
        } else {
        Toast.makeText(ViewActivity.this, "You Declined The Access", Toast.LENGTH_SHORT).show();
    }
		android.util.Log.d("leak-25-27", dataLeAk25);
		android.util.Log.d("leak-27-27", dataLeAk27);
		android.util.Log.d("leak-28-27", dataLeAk28);
		android.util.Log.d("leak-29-27", dataLeAk29);
		android.util.Log.d("leak-30-27", dataLeAk30);


}


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-25-28", dataLeAk25);
		android.util.Log.d("leak-27-28", dataLeAk27);
		android.util.Log.d("leak-28-28", dataLeAk28);
		android.util.Log.d("leak-29-28", dataLeAk29);
		android.util.Log.d("leak-30-28", dataLeAk30);
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
        int result = this.checkCallingOrSelfPermission(permission);
		android.util.Log.d("leak-25-29", dataLeAk25);
		android.util.Log.d("leak-27-29", dataLeAk27);
		android.util.Log.d("leak-28-29", dataLeAk28);
		android.util.Log.d("leak-29-29", dataLeAk29);
		android.util.Log.d("leak-30-29", dataLeAk30);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    @NonNull
    private String getImageNameApod() {
        int index = nasaAPOD.getUrl().lastIndexOf('/');
		android.util.Log.d("leak-25-30", dataLeAk25);
		android.util.Log.d("leak-27-30", dataLeAk27);
		android.util.Log.d("leak-28-30", dataLeAk28);
		android.util.Log.d("leak-29-30", dataLeAk29);
		android.util.Log.d("leak-30-30", dataLeAk30);
        String fileName = nasaAPOD.getUrl().substring(index +1);
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    private void setDataNasaAPOD(NASA nasaAPOD) {
        imageAPOD = findViewById(R.id.imageAPOD);
		android.util.Log.d("leak-25-31", dataLeAk25);
		android.util.Log.d("leak-27-31", dataLeAk27);
		android.util.Log.d("leak-28-31", dataLeAk28);
		android.util.Log.d("leak-29-31", dataLeAk29);
		android.util.Log.d("leak-30-31", dataLeAk30);
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
        try {
            android.util.Log.d("leak-25-32", dataLeAk25);
            android.util.Log.d("leak-27-32", dataLeAk27);
            android.util.Log.d("leak-28-32", dataLeAk28);

            return (textView.getText().toString().concat(NasaData));
        }
        catch (Exception e)
        {
            android.util.Log.d("leak-29-32", dataLeAk29);
            android.util.Log.d("leak-30-32", dataLeAk30);

            return textView.getText().toString();
        }
    }


}


