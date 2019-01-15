package com.example.piu.studentapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class CheckInActivity extends AppCompatActivity implements LocationListener{
    private static final int NUM_RESULTS = 1;
    private LocationManager locationManager = null;

    TextView tvAddress = null;
    Button btnCheckIn = null;

    Address currentAddress ;

    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkin_activity);

        TextView tvPoints = findViewById(R.id.tv_points);
        tvPoints.setText(Store.sold.toString());

        tvAddress = findViewById(R.id.tv_address);
        btnCheckIn = findViewById(R.id.btn_checkin);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION}, 1993);
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);

        btnCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btn_checkin){
                    tvAddress.setText("Location: " +  currentAddress.getCountryName() + ", " +currentAddress.getAdminArea()  + ", " + currentAddress.getSubAdminArea() +
                            ", " + currentAddress.getThoroughfare() +  ", " + currentAddress.getFeatureName());
                }
            }
        });
}


    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1993) {
            boolean allGranted = true;
            for (int result : grantResults) {
                if (result != PERMISSION_GRANTED) {
                    allGranted = false;
                }
            }
            if (allGranted) {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
            } else {
                Log.e(getClass().getName(), "Missing permissions");
            }
        }
    }


    @Override
    public void onLocationChanged(Location location) {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addressList = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), NUM_RESULTS);
            for (Address address : addressList) {
                Log.d(getClass().getName(), "lat = " + location.getLatitude() +
                        " :: long = " + location.getLongitude() + " :: name = " + address.getAddressLine(0));
                currentAddress = address;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.sign_out) {
            showSignOutDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /** NEW **/
    private void showSignOutDialog() {
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setMessage("Esti sigur ca vrei sa te deconectezi?");
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Nu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Da", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });
        alertDialog.show();
    }

}

