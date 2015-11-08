package privado.lisseth.pizzaricaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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


public class Producto_Pizza extends ActionBarActivity {

    Vista_Lista adapter;
    ListView lista;

  //  String[] titulo = new String[]{"GrandeExtra","Queso","Jamon"};

    int[] imagenes = {
            R.drawable.pizza2,
            R.drawable.pizza2,
            R.drawable.pizza2,
            R.drawable.pizza2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto__pizza);
        ObtDatos();
        lista = (ListView) findViewById(R.id.listapizza);
       // adapter = new Vista_Lista(this, titulo, imagenes);
       // lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "presiono " + i, Toast.LENGTH_SHORT).show();
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "presiono LARGO " + i, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    public void ObtDatos(){
        AsyncHttpClient client = new AsyncHttpClient();
        String url= Constantes.GET_BY_ID;

        Bundle bundle = getIntent().getExtras();

        RequestParams parametros = new RequestParams();
        parametros.put("IdTProducto",bundle.getInt("IdTProducto"));

        client.post(url, parametros, new AsyncHttpResponseHandler() {

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

    public ArrayList<String> obtDatosJSON(String web){
        ArrayList<String> productos = new ArrayList<String>();
          //  System.out.println("Lista web "+web.toString());
        try {
            JSONArray jsonArray = new JSONArray(web);
            String texto;
            String id;
            for (int i=0;i<jsonArray.length();i++){
                texto = jsonArray.getJSONObject(i).getString("Nombre");
                // id = jsonArray.getJSONObject(i).getString("IdTProducto");
                productos.add(texto);
                System.out.println("Lista> "+productos.toString());
                // productos.add(id);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return productos;
    }

    public void CargarLista(ArrayList<String> dato){
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,dato);
        //lista.setAdapter(adapter);
        List<String> stockList = new ArrayList<String>();
        for (int i = 0; i<dato.size();i++)
            stockList.add(dato.get(i));

        String[] titulo = new String[stockList.size()];
        titulo = stockList.toArray(titulo);


        adapter = new Vista_Lista(this, titulo, imagenes);
        lista.setAdapter(adapter);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_producto__pizza, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.Iniciar) {
                return true;
            }

            if (id == R.id.Registrate) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

        @Override
        public boolean onPrepareOptionsMenu(Menu menu) {
            boolean result = super.onPrepareOptionsMenu(menu);
            menu.findItem(R.id.Iniciar).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    startActivity(new Intent(Producto_Pizza.this, Iniciar_Sesion.class));
                    return true;
                }
            });
            menu.findItem(R.id.Registrate).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    startActivity(new Intent(Producto_Pizza.this, Registrarse.class));
                    return true;
                }
            });
            return result;
        }

    }
