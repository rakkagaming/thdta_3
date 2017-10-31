package mah.thdta3.robin.android.assignment2;


import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener {

    private Controller controller;
    private LocationManager locationManager;
    private MapView map;
    private GoogleMap mapG;
    private boolean ok;
    private double startLatitude, startLongitude;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_map, container, false);
        initializeComponents(v);
        map.onCreate(savedInstanceState);
        locationManager = (LocationManager) getActivity().getSystemService(getContext().LOCATION_SERVICE);
        return v;
    }

    @Override
    public void onLowMemory() {
        map.onLowMemory();
        super.onLowMemory();
    }

    @Override
    public void onPause() {
        map.onPause();
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        map.onDestroy();
        super.onDestroyView();
    }

    @Override
    public void onResume() {
        String bestProvider = String.valueOf(locationManager.getBestProvider(new Criteria(),true));
        controller.checkPermission();
        Location startLocation = locationManager.getLastKnownLocation(bestProvider);
        startLatitude = startLocation.getLatitude();
        startLongitude = startLocation.getLongitude();
        map.onResume();
        super.onResume();
    }

    private void initializeComponents(View v) {
        map = (MapView) v.findViewById(R.id.map);
        map.getMapAsync(this);
    }


    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapG = googleMap;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ) {
            ok = controller.checkPermission();
        }
        if (ok){
            mapG.setMyLocationEnabled(true);
            mapG.setOnMyLocationButtonClickListener(this);

            /*
            //String bestProvider = String.valueOf(locationManager.getBestProvider(new Criteria(),true));
            //Location startLocation = locationManager.getLastKnownLocation(bestProvider);
            if (startLocation != null){
                //startLatitude = startLocation.getLatitude();
                //startLongitude = startLocation.getLongitude();
                LatLng currentLocation = new LatLng(startLatitude,startLongitude);

                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation,13));
            }*/
            LatLng currentLocation = new LatLng(startLatitude,startLongitude);

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation,13));
        }
        //controller.groupMarkers(positionList);
        controller.setStartPosition(startLongitude,startLatitude);
    }

    public void updateMapMarkers(ArrayList<Member> members) {

        Log.d("markers", "amount in list: " + members.size());
        mapG.clear();
        //mapG.addMarker(new MarkerOptions().position(new LatLng(members.indexOf(0), startLongitude)).title("Here you stand"));
        for (int i = 0; i < members.size(); i++) {
            Log.d("markers", "Adding Markers " + i);
            Log.d("markers", "Long: " + members.get(i).getLongitude() + " while currentPos is: " + startLongitude);
            Log.d("markers", "Lat: " + members.get(i).getLatitude() + " while currentPos is: " + startLatitude);
            mapG.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(members.get(i).getLatitude()), Double.parseDouble(members.get(i).getLongitude()))).title(members.get(i).getName()));
        }
    }

    public void updateMapPosition(Member member){
        Log.e("EMPTY STRING","Content of long and lat:" + member.getLongitude() + " " + member.getLatitude());
        if (member.getLatitude()=="" ||member.getLongitude()==""){}
        else {
            try {
                Log.v("Map", "Before adding thins to the map");
                LatLng temp = new LatLng(Double.parseDouble(member.getLongitude()),
                        Double.parseDouble(member.getLatitude()));
                mapG.clear();
                mapG.addMarker(new MarkerOptions().position(temp).title(member.getName()));
                mapG.animateCamera(CameraUpdateFactory.newLatLngZoom(temp, 10));
                Log.v("Map", "End of adding and fixing pos to the map");
            } catch (NullPointerException e) {
                Log.e("Map", "Nullpointer i member?");
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onMyLocationButtonClick() {
        return false;
    }

    public double getStartLongitude() {
        return startLongitude;
    }

    public double getStartLatitude() {
        return startLatitude;
    }
}
