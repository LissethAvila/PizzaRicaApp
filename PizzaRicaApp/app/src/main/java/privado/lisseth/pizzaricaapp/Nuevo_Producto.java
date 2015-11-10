package privado.lisseth.pizzaricaapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class Nuevo_Producto extends Activity {

    Spinner listastam;

    Spinner listastipo;

    String[] datos = {"TAMANO", "Pequeno", "Mediano", "Grande", "Unico"};

    String[] datostipo = {"TIPO PRODUCTO", "Pizza", "Bebida", "Extra"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo__producto);

        listastam = (Spinner)findViewById(R.id.tamano);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datos);
        listastam.setAdapter(adaptador);

        listastipo = (Spinner)findViewById(R.id.tipoprod);
        ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datostipo);
        listastipo.setAdapter(adaptador1);

    }


    @Override
    public View findViewById(int id) {
        return super.findViewById(id);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onPrepareOptionsMenu(menu);

        menu.findItem(R.id.Cerrar).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(Nuevo_Producto.this, Iniciar_Sesion.class));
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
            return true;
        }

        //return super.onOptionsItemSelected(item);
    //}
   }

