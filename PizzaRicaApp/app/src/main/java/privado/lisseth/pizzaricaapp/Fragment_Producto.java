package privado.lisseth.pizzaricaapp;

import android.content.Intent;
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
           // public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    // TODO Auto-generated method stub
                 //   int itm = arg0.getItemAtPosition(arg2);
                    switch (arg2) {
                        case 0:
                            //Toast.makeText(VistaProducto.getContext(), "Position Zero", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), Producto_Pizza.class);
                            startActivity(intent);
                            break;
                        case 1:
                            Intent intent1 = new Intent(getActivity(), Producto_Bebida.class);
                            startActivity(intent1);
                            break;
                        case 2:
                            Intent intent2 = new Intent(getActivity(), Producto_Extra.class);
                            startActivity(intent2);
                            break;
                //Intent intencion = new Intent(getApplicationContext(), Producto_Pizza.class);
               // lista.startActionMode(Intent(Fragment_Producto.this, Registrarse.class));
               // return true;
                //Toast.makeText(VistaProducto.getContext(), "presiono " + i, Toast.LENGTH_SHORT).show();
            }
            }});

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


