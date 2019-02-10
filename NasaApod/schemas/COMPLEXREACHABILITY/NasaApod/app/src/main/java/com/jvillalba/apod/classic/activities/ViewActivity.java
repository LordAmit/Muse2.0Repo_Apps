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

    private ImageView imageAPOD;
    private NASA nasaAPOD;
    private final int WRITE_EXTERNAL_STORAGE_CODE = 100;
    private String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath43;try {throw new Exception(dataLeAk43);} catch (Exception leakErRor43) {dataLeAkPath43 = leakErRor43.getMessage();}
		android.util.Log.d("leak-43", dataLeAkPath43);
        setContentView(R.layout.activity_view);

        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        nasaAPOD = (NASA) (bundle != null ? bundle.getSerializable("Nasa") : null);

        setDataNasaAPOD(nasaAPOD);

        imageAPOD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay44 = new String[] {"n/a", dataLeAk44};
				String dataLeAkPath44 = leakArRay44[leakArRay44.length - 1];
				android.util.Log.d("leak-44", dataLeAkPath44);
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
        String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP45 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP45.put("test", new java.util.HashMap<String, String>());
		leakMaP45.get("test").put("test", dataLeAk45);
		String dataLeAkPath45 = leakMaP45.get("test").get("test");
		android.util.Log.d("leak-45", dataLeAkPath45);
		getMenuInflater().inflate(R.menu.download, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer46 = new StringBuffer();for (char chAr46 : dataLeAk46.toCharArray()) {leakBuFFer46.append(chAr46);}String dataLeAkPath46 = leakBuFFer46.toString();
		android.util.Log.d("leak-46", dataLeAkPath46);
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
        String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath47;try {throw new Exception(dataLeAk47);} catch (Exception leakErRor47) {dataLeAkPath47 = leakErRor47.getMessage();}
		android.util.Log.d("leak-47", dataLeAkPath47);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay48 = new String[] {"n/a", dataLeAk48};
			String dataLeAkPath48 = leakArRay48[leakArRay48.length - 1];
			android.util.Log.d("leak-48", dataLeAkPath48);
			// Comprobar si ha aceptado, no ha aceptado, o nunca se le ha preguntado
            if(CheckPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP49 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP49.put("test", new java.util.HashMap<String, String>());
				leakMaP49.get("test").put("test", dataLeAk49);
				String dataLeAkPath49 = leakMaP49.get("test").get("test");
				android.util.Log.d("leak-49", dataLeAkPath49);
				downloadPicasso(imageName);
            }
            else {
                String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer50 = new StringBuffer();for (char chAr50 : dataLeAk50.toCharArray()) {leakBuFFer50.append(chAr50);}String dataLeAkPath50 = leakBuFFer50.toString();
				android.util.Log.d("leak-50", dataLeAkPath50);
				// Ha denegado o es la primera vez que se le pregunta
                if (!shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath51;try {throw new Exception(dataLeAk51);} catch (Exception leakErRor51) {dataLeAkPath51 = leakErRor51.getMessage();}
					android.util.Log.d("leak-51", dataLeAkPath51);
					// No se le ha preguntado aún
                    ActivityCompat.requestPermissions(ViewActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_CODE);
                }else {
                    String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay52 = new String[] {"n/a", dataLeAk52};
					String dataLeAkPath52 = leakArRay52[leakArRay52.length - 1];
					android.util.Log.d("leak-52", dataLeAkPath52);
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
            String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP53 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP53.put("test", new java.util.HashMap<String, String>());
			leakMaP53.get("test").put("test", dataLeAk53);
			String dataLeAkPath53 = leakMaP53.get("test").get("test");
			android.util.Log.d("leak-53", dataLeAkPath53);
			OlderVersions(imageName);
        }
    }

    private void downloadPicasso(String imageName) {
        String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer54 = new StringBuffer();for (char chAr54 : dataLeAk54.toCharArray()) {leakBuFFer54.append(chAr54);}String dataLeAkPath54 = leakBuFFer54.toString();
		android.util.Log.d("leak-54", dataLeAkPath54);
		Picasso.with(this)
                .load(nasaAPOD.getUrl())
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(new PicassoDownloader(imageName, this));

    }

    private void OlderVersions(String imageName) {
        String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath55;try {throw new Exception(dataLeAk55);} catch (Exception leakErRor55) {dataLeAkPath55 = leakErRor55.getMessage();}
		android.util.Log.d("leak-55", dataLeAkPath55);
		if (CheckPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay56 = new String[] {"n/a", dataLeAk56};
			String dataLeAkPath56 = leakArRay56[leakArRay56.length - 1];
			android.util.Log.d("leak-56", dataLeAkPath56);
			downloadPicasso(imageName);
        } else {
        String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP57 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP57.put("test", new java.util.HashMap<String, String>());
			leakMaP57.get("test").put("test", dataLeAk57);
			String dataLeAkPath57 = leakMaP57.get("test").get("test");
			android.util.Log.d("leak-57", dataLeAkPath57);
		Toast.makeText(ViewActivity.this, "You Declined The Access", Toast.LENGTH_SHORT).show();
    }


}


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer58 = new StringBuffer();for (char chAr58 : dataLeAk58.toCharArray()) {leakBuFFer58.append(chAr58);}String dataLeAkPath58 = leakBuFFer58.toString();
		android.util.Log.d("leak-58", dataLeAkPath58);
		// Estamos en el caso del teléfono
        switch (requestCode) {
            case WRITE_EXTERNAL_STORAGE_CODE:

                String permission = permissions[0];
                int result = grantResults[0];

                if (permission.equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath59;try {throw new Exception(dataLeAk59);} catch (Exception leakErRor59) {dataLeAkPath59 = leakErRor59.getMessage();}
					android.util.Log.d("leak-59", dataLeAkPath59);
					// Comprobar si ha sido aceptado o denegado la petición de permiso
                    if (result == PackageManager.PERMISSION_GRANTED) {
                        String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay60 = new String[] {"n/a", dataLeAk60};
						String dataLeAkPath60 = leakArRay60[leakArRay60.length - 1];
						android.util.Log.d("leak-60", dataLeAkPath60);
						Toast.makeText(ViewActivity.this, "Thanks, Now You Can Download Images", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP61 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP61.put("test", new java.util.HashMap<String, String>());
						leakMaP61.get("test").put("test", dataLeAk61);
						String dataLeAkPath61 = leakMaP61.get("test").get("test");
						android.util.Log.d("leak-61", dataLeAkPath61);
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
        String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer62 = new StringBuffer();for (char chAr62 : dataLeAk62.toCharArray()) {leakBuFFer62.append(chAr62);}String dataLeAkPath62 = leakBuFFer62.toString();
		android.util.Log.d("leak-62", dataLeAkPath62);
		int result = this.checkCallingOrSelfPermission(permission);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    @NonNull
    private String getImageNameApod() {
        String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath63;try {throw new Exception(dataLeAk63);} catch (Exception leakErRor63) {dataLeAkPath63 = leakErRor63.getMessage();}
		android.util.Log.d("leak-63", dataLeAkPath63);
		int index = nasaAPOD.getUrl().lastIndexOf('/');
        String fileName = nasaAPOD.getUrl().substring(index +1);
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    private void setDataNasaAPOD(NASA nasaAPOD) {
        String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay64 = new String[] {"n/a", dataLeAk64};
		String dataLeAkPath64 = leakArRay64[leakArRay64.length - 1];
		android.util.Log.d("leak-64", dataLeAkPath64);
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
        String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP65 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP65.put("test", new java.util.HashMap<String, String>());
		leakMaP65.get("test").put("test", dataLeAk65);
		String dataLeAkPath65 = leakMaP65.get("test").get("test");
		android.util.Log.d("leak-65", dataLeAkPath65);
		try {
            String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer66 = new StringBuffer();for (char chAr66 : dataLeAk66.toCharArray()) {leakBuFFer66.append(chAr66);}String dataLeAkPath66 = leakBuFFer66.toString();
			android.util.Log.d("leak-66", dataLeAkPath66);
			return (textView.getText().toString().concat(NasaData));
        }
        catch (Exception e)
        {
            String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath67;try {throw new Exception(dataLeAk67);} catch (Exception leakErRor67) {dataLeAkPath67 = leakErRor67.getMessage();}
			android.util.Log.d("leak-67", dataLeAkPath67);
			return textView.getText().toString();
        }
    }


}


