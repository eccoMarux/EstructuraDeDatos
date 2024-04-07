//import Lineales.Dinamicas.src.Cola;
import Lineales.Estaticas.src.Cola;
public class TestCola {
    public static void main(String[] args) {
        Cola colaOriginal = new Cola();
        Cola colaClon = new Cola();
        int cargado = 8;

        /*** TEST COLA CON NUMEROS ENTEROS ***/

        System.out.println(">> ¡Cola Vacia!");
        /* Test TOSTRING con Cola Vacia */
        System.out.println("Test ToString (no debe listar): " + colaOriginal.toString());

        /* Test ESVACIA con Cola Vacia */
        System.out.println("Test EsVacia (true): " + colaOriginal.esVacia());

        /* Test SACAR con Cola Vacia */
        System.out.println("Test Sacar (false): " + colaOriginal.sacar());

        /* Test OBTENERFRENTE con Cola Vacia */
        System.out.println("Test Obtener Frente (null):" + colaOriginal.obtenerFrente());

        /* Test CLONE con Cola Vacia */
        System.out.println(">> ¡Test Clon Cola Vacia!");
        colaClon = colaOriginal.clone();
        System.out.println("Cola Original: " + colaOriginal.toString());
        System.out.println("Cola Clon: " + colaClon.toString());
        System.out.println("Obtener frente de Clon: " + colaClon.obtenerFrente());

        /* Test PONER */
        for (int i = 0; i < cargado; i++) {
            colaOriginal.poner(i);
        }

        /* Test TOSTRING con Cola Cargada */
        System.out.println(">> ¡Cola Cargada!");
        System.out.println("Test poner (10 elementos) y ToString: \n" + colaOriginal.toString());

        /* Test ESVACIA con Cola Cargada */
        System.out.println("Test EsVacia (false): " + colaOriginal.esVacia());

        /* Test OBTENERFRENTE con Cola Cargada */
        System.out.println("Test Obtener Frente (0): " + colaOriginal.obtenerFrente());

        /* Test SACAR con Cola Cargada */
        System.out.println("Test Sacar (true): " + colaOriginal.sacar());
        System.out.println("Cola Actual despues de Sacar: \n" + colaOriginal.toString());

        /* Test OBTENERFRENTE despues de SACAR*/
        System.out.println("Test Frente Tope (1): " + colaOriginal.obtenerFrente());

        /* Test CLONE con Cola Cargada */
        System.out.println(">> ¡Test Cola Clon Cargada!");
        colaClon = colaOriginal.clone();
        System.out.println("Cola Original: \n" + colaOriginal.toString());
        System.out.println("Cola Clon: \n" + colaClon.toString());
        System.out.println("Obtener frente de Clon: " + colaClon.obtenerFrente());

        /* Test VACIAR con Cola Cargada */
        colaOriginal.vaciar();
        System.out.println("Test Vaciar Cola Original (no debe listar): " + colaOriginal.toString());
        colaClon.vaciar();

        /*** TEST Cola CON STRINGS ***/
        System.out.println(">> ¡Test Cola Cargada con Strings!");

        /* Test PONER con Cola Cargada */
        colaOriginal.poner("Maru");
        colaOriginal.poner("Sofi");
        colaOriginal.poner("Lauti");
        colaOriginal.poner("Mint");
        colaOriginal.poner("Edat24");

        /* Test TOSTRING con Cola Cargada */
        System.out.println("Test TOSTRING: \n" + colaOriginal.toString());

        /* Test OBTENERTOPE con Cola Cargada */
        System.out.println("Test Obtener Frente (Maru):" + colaOriginal.obtenerFrente());

        /* Test DESAPILAR con Cola Cargada */
        System.out.println("Test Sacar (true): " + colaOriginal.sacar());
        System.out.println("Pila Actual despues de Sacar: \n" + colaOriginal.toString());
        System.out.println("Obtener Frente (Sofi): " + colaOriginal.obtenerFrente());

        /* Test CLONE con Cola Cargada */
        colaClon = colaOriginal.clone();
        System.out.println("Cola Original: \n" + colaOriginal.toString());
        System.out.println("Cola Clon: \n" + colaClon.toString());

        /* Test VACIAR con Cola Cargada */
        colaOriginal.vaciar();
        System.out.println("Test Vaciar Cola Original (no debe listar): " + colaOriginal.toString());
    }
}
