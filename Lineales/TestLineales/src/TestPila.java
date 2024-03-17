public class TestPila {
    public static void main(String[] args) {
        Pila pilaPrueba = new Pila();
        Pila pilaClon;
        int cargado = 12;

        /*** TEST PILA CON NUMEROS ENTEROS ***/

        /* Test TOSTRING con Pila Vacia */
        System.out.println("Test ToString (no debe listar): " + pilaPrueba.toString());

        /* Test ESVACIA con Pila Vacia */
        System.out.println("Test EsVacia (true): " + pilaPrueba.esVacia());

        /* Test DESAPILAR con Pila Vacia */
        System.out.println("Test Desapilar (false): " + pilaPrueba.desapilar());

        /* Test OBTENERTOPE con Pila Vacia */
        System.out.println("Test Obtener Tope (-1):" + pilaPrueba.obtenerTope());

        /* Test CLONE con Pila Vacia */
        System.out.println("Test Clon Pila Vacia:");
        pilaClon = pilaPrueba.clone();
        System.out.println("Pila Original: " + pilaPrueba.toString());
        System.out.println("Pila Clon: " + pilaClon.toString());
        System.out.println("Obtener tope de Clon: " + pilaClon.obtenerTope());

        /* Test APILAR */
        for (int i = 0; i < cargado; i++) {
            pilaPrueba.apilar((i + 2));
        }

        /* Test TOSTRING con Pila Cargada */
        System.out.println("Test Apilar (respeta posicion+2) y ToString: \n" + pilaPrueba.toString());

        /* Test ESVACIA con Pila Cargada */
        System.out.println("Test EsVacia (false): " + pilaPrueba.esVacia());

        /* Test OBTENERTOPE con Pila Cargada */
        System.out.println("Test Obtener Tope (" + (cargado - 1) + "):" + pilaPrueba.obtenerTope());

        /* Test DESAPILAR con Pila Cargada */
        System.out.println("Test Desapilar (true): " + pilaPrueba.desapilar());
        System.out.println("Pila Actual despues de Desapilar: \n" + pilaPrueba.toString());

        /* Test OBTENERTOPE despues de Desapilar */
        System.out.println("Test Obtener Tope (" + (cargado - 2) + "):" + pilaPrueba.obtenerTope());

        /* Test CLONE con Pila Cargada */
        System.out.println("Test Clon Pila Cargada:");
        pilaClon = pilaPrueba.clone();
        System.out.println("Pila Original: \n" + pilaPrueba.toString());
        System.out.println("Pila Clon: \n" + pilaClon.toString());
        System.out.println("Obtener tope de Clon: " + pilaClon.obtenerTope());

        /* Test VACIAR con Pila Cargada */
        pilaPrueba.vaciar();
        System.out.println("Test Vaciar Pila Original (no debe listar): " + pilaPrueba.toString());
        pilaClon.vaciar();

        /*** TEST PILA CON STRINGS ***/

        /* Test APILAR con Pila Cargada */
        pilaPrueba.apilar("Maru");
        pilaPrueba.apilar("Sofi");
        pilaPrueba.apilar("Lauti");
        pilaPrueba.apilar("Mint");
        pilaPrueba.apilar("Edat24");

        /* Test TOSTRING con Pila Cargada */
        System.out.println("Test TOSTRING (arreglos con strings): \n" + pilaPrueba.toString());

        /* Test OBTENERTOPE con Pila Cargada */
        System.out.println("Test Obtener Tope (4):" + pilaPrueba.obtenerTope());

        /* Test DESAPILAR con Pila Cargada */
        System.out.println("Test Desapilar (true): " + pilaPrueba.desapilar());
        System.out.println("Pila Actual despues de Desapilar: \n" + pilaPrueba.toString());
        System.out.println("Obtener Tope (3):" + pilaPrueba.obtenerTope());

        /* Test CLONE con Pila Cargada */
        System.out.println("Test Clon Pila Cargada:");
        pilaClon = pilaPrueba.clone();
        System.out.println("Pila Original: \n" + pilaPrueba.toString());
        System.out.println("Pila Clon: \n" + pilaClon.toString());

        /* Test VACIAR con Pila Cargada */
        pilaPrueba.vaciar();
        System.out.println("Test Vaciar Pila Original (no debe listar): " + pilaPrueba.toString());

    }
}
