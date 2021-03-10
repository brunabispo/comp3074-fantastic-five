package ca.gbc.comp3074.mind_manager_app;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity  extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Button btnApply = findViewById(R.id.btnApply);
        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToWelcome();
            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED){
            getLocation();
        }else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1 && permissions.length == 1
                && permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION
                && grantResults [0] == PackageManager.PERMISSION_GRANTED){
            getLocation();
        }
    }

         void getLocation() {
             if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) ==
                     PackageManager.PERMISSION_GRANTED) {
                 LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
                 if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                     Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                     locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                             100, 1, this);
                 } else {
                     Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                     startActivity(intent);
                 }
             }
         }

         @Override
         public void onLocationChanged(@NonNull Location location) {
             if(location != null){
                 LatLng pos = new LatLng (location.getLatitude(), location.getLongitude());
                 if(mMap != null){
                     mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(pos, 14));
                 }
             }
         }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng casaloma = new LatLng(43.6705, -79.3936);
        mMap.addMarker(new MarkerOptions().position(casaloma).title("Marker in Casa Loma"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(casaloma, 14));
    }

    private void backToWelcome(){
        Intent start = new Intent(getApplicationContext(), WelcomeActivity.class);
        startActivity(start);
    }



    //function to start AboutActivity
    private void openAbout(){
        Intent start = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(start);
    }

    private void openlogin(){
        Intent start = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(start);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_about) {
            openAbout();
            return true;
        }
        if (item.getItemId() == R.id.menu_main) {
            openlogin();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}