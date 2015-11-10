package privado.lisseth.pizzaricaapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.telephony.SmsMessage;


public class Carrito extends ActionBarActivity {

    ListView pedido;
    Button mensaje;
    int x;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        findViewById(R.id.otroProd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Carrito.this, Principal.class));
            }
        });


        //ObtDatos();


        pedido = (ListView) findViewById(R.id.listaPedido);

        mensaje = (Button) findViewById(R.id.agregarprod);

    };

    public void mensaje (View v){
        final Button miboton = (Button) findViewById(R.id.confirmar);
        if (x == 0) {
            x=1;
            miboton.setText("Mensaje de confirmacion enviado");
            sendsms();
            return;
        }
    }

    private void sendsms(){
        sendSMS("41212373", "Total a pagar, tu pedido lo recibiras en 30 minutos");
    }

    public void sendSMS(String numero, String mensaje){
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(numero, null, mensaje, null, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_carrito, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Cerrar) {
            return true;
        }

        if (id == R.id.MenuPrin) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean result = super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.Cerrar).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(Carrito.this, Iniciar_Sesion.class));
                return true;
            }
        });
        menu.findItem(R.id.MenuPrin).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(Carrito.this, Principal.class));
                return true;
            }
        });
        return result;        }

        //return super.onOptionsItemSelected(item);
    //}
}
