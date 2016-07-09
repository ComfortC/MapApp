package com.example.khumalo.mapapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap m_map;
    boolean mapReady=false;

    private static final LatLng Cape_Town = new LatLng(-33.9880185,18.4827403);
    private static final LatLng London_Settings = new LatLng(51.528308,-0.3817765);
    private static final LatLng Seattle_Settings = new LatLng(47.6129432,-122.4821475);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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



        Button CapeTown= (Button) findViewById(R.id.cape);
        CapeTown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    CameraPosition capeTown = new CameraPosition.Builder()
                            .target(Cape_Town)
                            .zoom(13)
                            .bearing(45)
                            .build();
                    m_map.animateCamera(CameraUpdateFactory.newCameraPosition(capeTown),5000,null);
                }
            }
        });

        Button London = (Button) findViewById(R.id.london);
        London.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mapReady){

                    CameraPosition LondonCity = new CameraPosition.Builder()
                            .target(London_Settings)
                            .zoom(13)
                            .bearing(45)
                            .build();
                    m_map.animateCamera(CameraUpdateFactory.newCameraPosition(LondonCity),5000,null);

                }


            }
        });

        Button Seattle = (Button) findViewById(R.id.seattle);
        Seattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mapReady){
                    CameraPosition SeattleCity = new CameraPosition.Builder()
                            .target(Seattle_Settings)
                            .zoom(13)
                            .bearing(45)
                            .build();
                    m_map.animateCamera(CameraUpdateFactory.newCameraPosition(SeattleCity),5000,null);
                }

            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
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
        mapReady=true;
        m_map = googleMap;
        m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        LatLng Cape = new LatLng(-33.9880185,18.4827403);
        CameraPosition target = CameraPosition.builder().target(Cape).zoom(14).build();
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
