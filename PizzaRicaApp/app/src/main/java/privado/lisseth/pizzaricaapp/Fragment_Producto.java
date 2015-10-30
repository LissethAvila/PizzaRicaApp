package privado.lisseth.pizzaricaapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Fragment_Producto extends Fragment {

    View VistaProducto; //Vista producto

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate enlace de .java con .xml
        VistaProducto = inflater.inflate(R.layout.fragment__producto, container, false);
        return VistaProducto;

    }

}
