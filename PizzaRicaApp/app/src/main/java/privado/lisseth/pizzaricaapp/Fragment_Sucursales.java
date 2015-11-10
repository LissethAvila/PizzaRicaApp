package privado.lisseth.pizzaricaapp;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import cz.msebera.android.httpclient.Header;

public class Fragment_Sucursales extends Fragment{

    View VistaSucursal; //Nueva vista
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    CameraUpdate mCamara; //mover a la ubicacion y zoom del mapa
    LocationManager manejador; //manejador de localizacion
    Double Latitud, Longitud;   //Longitud y latitud del ubicacion

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Actualizar Ubicacion
        actualizarPosicion();
        // Inflate enlace de .java con .xml
        VistaSucursal = inflater.inflate(R.layout.fragment__sucursales, container, false);
        //Inicio del Mapa
        setUpMapIfNeeded();

        return VistaSucursal;
    }
    //Metodos para visualizar el mapa
    private void setUpMapIfNeeded() {
        if (mMap != null) {
            setUpMap();
        }
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapSuc)).getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }
    //metodo de ingreso de sucursales y posicion
    public void setUpMap() {
        ObtDatos();
        mMap.addMarker(new MarkerOptions().position(new LatLng(Latitud, Longitud)).title("Tu"));
        mCamara = CameraUpdateFactory.newLatLngZoom(new LatLng(Latitud, Longitud), 15);
        mMap.animateCamera(mCamara);

    }

    public void onViewCreated(View view, Bundle savedInstancesState){
        if (mMap != null)
            setUpMap();

        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapSuc)).getMap(); // getMap is deprecated
            // Check if we were successful in obtaining the map.
            if (mMap != null)
                setUpMap();
        }
    }
    //Actualizacion de posicision
    public void actualizarPosicion()
    {
        //Obtenemos una referencia al LocationManager
        manejador = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);

        //Obtenemos la última posición conocida
        Location location = manejador.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        //Mostramos la última posición conocida
        muestraPosicion(location);

        //Nos registramos para recibir actualizaciones de la posición
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                muestraPosicion(location);
            }
            public void onProviderDisabled(String provider){

            }
            public void onProviderEnabled(String provider){

            }
            public void onStatusChanged(String provider, int status, Bundle extras){

            }
        };

        manejador.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER, 15000, 0, locationListener);
    }
    //Muestar la Posicion de la persona
    private void muestraPosicion(Location localizacion) {
        if (localizacion == null)
            System.out.print("No se pudo localizar");
        else{
            Latitud =localizacion.getLatitude();
            Longitud = localizacion.getLongitude();
            // System.out.print("Latitud "+Latitud+" Longitud "+Longitud);
        }

    }
    //obtener datos sucursal y conexion 
    public void ObtDatos(){
        AsyncHttpClient client = new AsyncHttpClient();
        String url= Constantes.SUCURSAL;

        client.post(url, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                if (statusCode == 200) {
                    obtDatosJSON(new String(response));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }

        });


    }

    //Obtener datos JSON
    public void obtDatosJSON(String web){

        try {
            JSONArray jsonArray = new JSONArray(web);
            String nSucursal,direccion;
            Double cLatitud, cLongitud;
            for (int i=0;i<jsonArray.length();i++){
                nSucursal = jsonArray.getJSONObject(i).getString("Nombre");
                cLatitud = Double.valueOf(jsonArray.getJSONObject(i).getString("Coordenada1"));
                cLongitud = Double.valueOf(jsonArray.getJSONObject(i).getString("Coordenada2"));
                direccion = jsonArray.getJSONObject(i).getString("Direccion");
                mMap.addMarker(new MarkerOptions().position(new LatLng(cLatitud, cLongitud)).title(nSucursal)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.logozz)).snippet(direccion));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


}