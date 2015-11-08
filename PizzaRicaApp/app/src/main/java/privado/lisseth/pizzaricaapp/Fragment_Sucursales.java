package privado.lisseth.pizzaricaapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Fragment_Sucursales extends Fragment {
    MapaSucursal Map = new MapaSucursal();
    View VistaSucursal; //Nueva vista

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate enlace de .java con .xml
        VistaSucursal = inflater.inflate(R.layout.activity_mapa_sucursal, container, false);
        //Map.setUpMapIfNeeded();

        return VistaSucursal;

    }


    }