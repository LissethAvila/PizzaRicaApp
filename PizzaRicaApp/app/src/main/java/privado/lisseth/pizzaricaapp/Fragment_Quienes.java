package privado.lisseth.pizzaricaapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.search.SearchAuth;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


public class Fragment_Quienes extends Fragment {

    View VistaQuienes; //Nueva vista
    TextView Mision;
    TextView Vision;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate enlace de .java con .xml
        VistaQuienes = inflater.inflate(R.layout.fragment__quienes, container, false);


        Mision = (TextView) VistaQuienes.findViewById(R.id.textMision);
        Vision = (TextView) VistaQuienes.findViewById(R.id.textVision);

       ObtDato();

        return VistaQuienes;
    }

    public void ObtDato(){

        AsyncHttpClient MisVis = new AsyncHttpClient();
        String url=Constantes.EMPRESA;

        MisVis.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    obtDatosJSON (new String(responseBody));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void obtDatosJSON(String web){

        try {
            JSONArray jsonArray = new JSONArray(web);
            String textoM;
            String textoV;
            for (int i=0;i<jsonArray.length();i++){
                textoM = jsonArray.getJSONObject(i).getString("Mision");
                textoV = jsonArray.getJSONObject(i).getString("Vision");
                Mision.setText(textoM);
                Vision.setText(textoV);
                System.out.print("mision "+textoM);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }



    };


}
