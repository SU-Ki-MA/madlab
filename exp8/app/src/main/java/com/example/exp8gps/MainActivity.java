package com.example.exp8gps;

import android.location.Location;
import androidx.appcompat.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}
public class MainActivity extends FragmentActivity
        implements GooglePlayServicesClient.ConnectionCallbacks,
        com.google.android.gms.location.LocationListener,
        GooglePlayServicesClient.OnConnectionFailedListener{
    privateGoogleMapmyMap; // map reference
    private LocationClientmyLocationClient;
    private static final LocationRequest REQUEST = LocationRequest.create()
            .setInterval(5000) // 5seconds
            .setFastestInterval(16) // 16ms = 60fps
            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getMapReference();
    }
    @Override
    protected void onResume(){
        super.onResume();
        getMapReference();
        wakeUpLocationClient();
        myLocationClient.connect();
    }
    @Overrid
    e
    public void onPause(){
        super.onPause();
        if(myLocationClient != null){
            myLocationClient.disconnect();
        }
    }
    private void gotoMyLocation(double lat, double lng) {
        changeCamera(CameraUpdateFactory.newCameraPosition(new
                CameraPosition.Builder().target(new LatLng(lat, lng))
                .zoom(15.5f)
                .bearing(0)
                .tilt(25)
                .build()
        ), new GoogleMap.CancelableCallback() {
            @Override
            public void onFinish() {
// Your code here to do something after the Map is rendered
            }
            @Override
            public void onCancel() {
// Your code here to do something after the Map rendering is cancelled
            }
        });
    }
    private void wakeUpLocationClient() {
        if(myLocationClient == null){
            myLocationClient = new LocationClient(getApplicationContext(),
                    this, // Connection Callbacks
                    this); // OnConnectionFailedListener
        }
    }
    private void getMapReference() {
        if(myMap == null){
            myMap = ((SupportMapFragment)
                    getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
        }
        if(myMap != null){
            myMap.setMyLocationEnabled(true);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Overrid
    e
    public void onConnected(Bundle bundle) {
        myLocationClient.requestLocationUpdates(
                REQUEST,
                this); // LocationListener
    }
    @Overrid
    e
    public void onDisconnected() {
    }
    @Overrid
    e
    public void onLocationChanged(Location location) {
        gotoMyLocation(location.getLatitude(), location.getLongitude());
    }
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
    }
    private void changeCamera(CameraUpdate update, GoogleMap.CancelableCallback callback)
    {
        myMap.moveCamera(update);
    }
}