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

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;



public class Fragment_Producto extends Fragment {

    View VistaProducto; //Nueva vista
    ListView lista;
    ArrayList<String> iddato;
    Vista_Lista adapter;

    int[] imagenes = {
            R.drawable.pizza2,
            R.drawable.bebida2,
            R.drawable.pastel
    };
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate enlace de .java con .xml
        VistaProducto = inflater.inflate(R.layout.fragment__producto, container, false);
        ObtDatos();

        lista = (ListView) VistaProducto.findViewById(R.id.ListaProductos);

       lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {


           @Override

           public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
               Intent intent = new Intent(getActivity(), Producto_Pizza.class);
               intent.putExtra("IdTProducto", CapturaId(arg2));
               startActivity(intent);

           }});

        return VistaProducto;

    }

    //Obtener datos bd
    public void ObtDatos(){
        AsyncHttpClient client = new AsyncHttpClient();
        String url= Constantes.GET;


        client.post(url, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                if (statusCode == 200) {
                    CargarLista(obtDatosJSON(new String(response)));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }

        });


    }

    //Obtener datos JSON
    public ArrayList<String> obtDatosJSON(String web){
        ArrayList<String> tproductos = new ArrayList<String>();
        iddato = new ArrayList<String>();

        try {
            JSONArray jsonArray = new JSONArray(web);
            String texto;
            String id;
            for (int i=0;i<jsonArray.length();i++){
                texto = jsonArray.getJSONObject(i).getString("Nombre");
                id = jsonArray.getJSONObject(i).getString("IdTProducto");
                tproductos.add(texto);
                iddato.add(id);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return tproductos;
    }

    public void CargarLista(ArrayList<String> dato){
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,dato);
        //lista.setAdapter(adapter);
        List<String> stockList = new ArrayList<String>();
        for (int i = 0; i<dato.size();i++)
            stockList.add(dato.get(i));

        String[] titulo = new String[stockList.size()];
        titulo = stockList.toArray(titulo);

        adapter = new Vista_Lista(VistaProducto.getContext(), titulo, imagenes);
        lista.setAdapter(adapter);

    }

    public int CapturaId(int dato){
        List<String>  posicionId = new ArrayList<String>();

        for (int i = 0; i<iddato.size();i++)
            posicionId.add(iddato.get(i));


        int idPos = Integer.parseInt(posicionId.get(dato));
        System.out.println("ListaPosicion> " + idPos);

        return idPos;

    }

}


