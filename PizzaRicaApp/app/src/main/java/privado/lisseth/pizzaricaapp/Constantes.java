package privado.lisseth.pizzaricaapp;

/**
 * Created by Lisseth on 02-11-2015.
 */
public class
        Constantes {

   // Carpeta de ubicacion de los Script
    private static final String CARPETAS = "WebPizzaRica/AndroidScript";
    //Direccion IP
    private static final String IP = "192.168.1.11";
    // URL del WebService
    public static final String GET = "http://" + IP +"/"+CARPETAS + "/BProducto.php";
    public static final String GET_BY_ID = "http://" + IP +"/"+CARPETAS +  "/BBProducto.php";
    public static final String UPDATE = "http://" + IP +"/"+CARPETAS + "/I%20Wish/actualizar_meta.php";
    public static final String DELETE = "http://" + IP +"/"+CARPETAS + "/I%20Wish/borrar_meta.php";
    public static final String INSERT = "http://" + IP +"/"+CARPETAS + "/I%20Wish/insertar_meta.php";

    //Clave Usuario Sesion

    public static final Boolean SESION = false;

}
