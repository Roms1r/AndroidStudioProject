package com.example.a2023springtermproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsFragment extends Fragment {
    private GoogleMap mMap;
    private String address;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;

            // Get the location from the address
            Geocoder geocoder = new Geocoder(getActivity());
            List<Address> addresses;
            try {
                addresses = geocoder.getFromLocationName(address, 1);
                if (addresses != null && !addresses.isEmpty()) {
                    Address foundAddress = addresses.get(0);

                    // Create a LatLng object from the address
                    LatLng searchLocation = new LatLng(foundAddress.getLatitude(), foundAddress.getLongitude());

                    // Add a marker on the map and move the camera
                    mMap.addMarker(new MarkerOptions().position(searchLocation).title("Marker in " + address));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(searchLocation, 15));
                } else {
                    // Handle the case where the address is not found
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }

        if (getArguments() != null) {
            address = getArguments().getString("address");
        }
    }
}
