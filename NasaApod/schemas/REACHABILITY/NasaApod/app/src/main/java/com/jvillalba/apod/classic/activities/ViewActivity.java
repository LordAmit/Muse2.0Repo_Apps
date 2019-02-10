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

    String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk52 = android.util.Log.d("leak-52", dataLeAk52);

	private ImageView imageAPOD;
    private NASA nasaAPOD;
    private final int WRITE_EXTERNAL_STORAGE_CODE = 100;
    private String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk53 = android.util.Log.d("leak-53", dataLeAk53);
        setContentView(R.layout.activity_view);

        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        nasaAPOD = (NASA) (bundle != null ? bundle.getSerializable("Nasa") : null);

        setDataNasaAPOD(nasaAPOD);

        imageAPOD.setOnClickListener(new View.OnClickListener() {
            String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk54 = android.util.Log.d("leak-54", dataLeAk54);

			@Override
            public void onClick(View view) {
                String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk55 = android.util.Log.d("leak-55", dataLeAk55);
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
        String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk56 = android.util.Log.d("leak-56", dataLeAk56);
		getMenuInflater().inflate(R.menu.download, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk57 = android.util.Log.d("leak-57", dataLeAk57);
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
        String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk58 = android.util.Log.d("leak-58", dataLeAk58);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk59 = android.util.Log.d("leak-59", dataLeAk59);
			// Comprobar si ha aceptado, no ha aceptado, o nunca se le ha preguntado
            if(CheckPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk60 = android.util.Log.d("leak-60", dataLeAk60);
				downloadPicasso(imageName);
            }
            else {
                String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk61 = android.util.Log.d("leak-61", dataLeAk61);
				// Ha denegado o es la primera vez que se le pregunta
                if (!shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk62 = android.util.Log.d("leak-62", dataLeAk62);
					// No se le ha preguntado aún
                    ActivityCompat.requestPermissions(ViewActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_CODE);
                }else {
                    String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk63 = android.util.Log.d("leak-63", dataLeAk63);
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
            String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk64 = android.util.Log.d("leak-64", dataLeAk64);
			OlderVersions(imageName);
        }
    }

    private void downloadPicasso(String imageName) {
        String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk65 = android.util.Log.d("leak-65", dataLeAk65);
		Picasso.with(this)
                .load(nasaAPOD.getUrl())
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(new PicassoDownloader(imageName, this));

    }

    private void OlderVersions(String imageName) {
        String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk66 = android.util.Log.d("leak-66", dataLeAk66);
		if (CheckPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk67 = android.util.Log.d("leak-67", dataLeAk67);
			downloadPicasso(imageName);
        } else {
        String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk68 = android.util.Log.d("leak-68", dataLeAk68);
		Toast.makeText(ViewActivity.this, "You Declined The Access", Toast.LENGTH_SHORT).show();
    }


}


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk69 = android.util.Log.d("leak-69", dataLeAk69);
		// Estamos en el caso del teléfono
        switch (requestCode) {
            case WRITE_EXTERNAL_STORAGE_CODE:

                String permission = permissions[0];
                int result = grantResults[0];

                if (permission.equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk70 = android.util.Log.d("leak-70", dataLeAk70);
					// Comprobar si ha sido aceptado o denegado la petición de permiso
                    if (result == PackageManager.PERMISSION_GRANTED) {
                        String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk71 = android.util.Log.d("leak-71", dataLeAk71);
						Toast.makeText(ViewActivity.this, "Thanks, Now You Can Download Images", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk72 = android.util.Log.d("leak-72", dataLeAk72);
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
        String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk73 = android.util.Log.d("leak-73", dataLeAk73);
		int result = this.checkCallingOrSelfPermission(permission);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    @NonNull
    private String getImageNameApod() {
        String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk74 = android.util.Log.d("leak-74", dataLeAk74);
		int index = nasaAPOD.getUrl().lastIndexOf('/');
        String fileName = nasaAPOD.getUrl().substring(index +1);
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    private void setDataNasaAPOD(NASA nasaAPOD) {
        String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk75 = android.util.Log.d("leak-75", dataLeAk75);
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
        String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk76 = android.util.Log.d("leak-76", dataLeAk76);
		try {
            String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk77 = android.util.Log.d("leak-77", dataLeAk77);
			return (textView.getText().toString().concat(NasaData));
        }
        catch (Exception e)
        {
            String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk78 = android.util.Log.d("leak-78", dataLeAk78);
			return textView.getText().toString();
        }
    }


}


