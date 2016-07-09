package com.example.khumalo.mapapp;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap m_map;
    MarkerOptions Betram;
    MarkerOptions District;
    MarkerOptions South;
    CameraPosition  CityCenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LatLng Bertram_House  =  new LatLng(-33.930366, 18.413767);
        Betram = new MarkerOptions()
                .position(Bertram_House)
                .title("Bertram House")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.flag));



        LatLng District_Six_Museum  =  new LatLng(-33.927544, 18.423731);
        District= new MarkerOptions()
                .position(District_Six_Museum)
                .title("District Six Museum")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.flag));



        LatLng South_African_Museum =  new LatLng(-33.928738, 18.414925);
        South= new MarkerOptions()
                .position(South_African_Museum)
                .title("South African Museum")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.flag));



        CityCenter = new CameraPosition.Builder()
                .target(new LatLng(-33.927544, 18.423731))
                .bearing(0)
                .tilt(45)
                .zoom(15)
                .build(); ;

       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/



        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
           m_map = googleMap;
           m_map.animateCamera(CameraUpdateFactory.newCameraPosition(CityCenter), 20000, null);
           CircleOptions  circle = new CircleOptions()
                .center(new LatLng(-33.927544, 18.423731))
                .radius(500)
                   .strokeColor(Color.GREEN)
                   .fillColor(Color.argb(64,0,255,0));
           Circle dsix = m_map.addCircle(circle);
           m_map.addMarker(District);
    }
}
