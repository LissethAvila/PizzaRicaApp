package privado.lisseth.pizzaricaapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Fragment_Quienes extends Fragment {

    View VistaQuienes; //Nueva vista

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate enlace de .java con .xml
        VistaQuienes = inflater.inflate(R.layout.fragment__quienes, container, false);
        return VistaQuienes;

    }
}
