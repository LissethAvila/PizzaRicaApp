package privado.lisseth.pizzaricaapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Fragment_Producto extends Fragment {

    View VistaProducto; //Nueva vista

    Vista_Lista adapter;
    String[] titulo = new String[]{
            "PIZZAS",
            "BEBIDAS",
            "EXTRAS",

    };

    int[] imagenes = {
            R.drawable.pizza2,
            R.drawable.bebida2,
            R.drawable.pastel
    };
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate enlace de .java con .xml
        VistaProducto = inflater.inflate(R.layout.fragment__producto, container, false);

        final ListView lista = (ListView) VistaProducto.findViewById(R.id.ListaProductos);
        adapter = new Vista_Lista(VistaProducto.getContext(), titulo, imagenes);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(VistaProducto.getContext(), "presiono " + i, Toast.LENGTH_SHORT).show();
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(VistaProducto.getContext(), "presiono LARGO " + i, Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        return VistaProducto;

    }


   }


