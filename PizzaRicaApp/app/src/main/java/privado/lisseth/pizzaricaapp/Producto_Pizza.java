package privado.lisseth.pizzaricaapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class Producto_Pizza extends Fragment {

    View VistaPizza; //Nueva vista

    Vista_Lista adapter;
    String[] titulo = new String[]{
            "HAWAIANA",
            "QUESO",
            "VEGETARIANA",

    };

    int[] imagenes = {
            R.drawable.pizza2,
            R.drawable.pizza2,
            R.drawable.pizza2
    };
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate enlace de .java con .xml
        VistaPizza = inflater.inflate(R.layout.producto__pizza, container, false);

        final ListView lista = (ListView) VistaPizza.findViewById(R.id.ListaProductos);
        adapter = new Vista_Lista(VistaPizza.getContext(), titulo, imagenes);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(VistaPizza.getContext(), "presiono " + i, Toast.LENGTH_SHORT).show();
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(VistaPizza.getContext(), "presiono LARGO " + i, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return VistaPizza;
    }
}