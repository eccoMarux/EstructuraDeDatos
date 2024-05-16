package Lineales.TestLineales;
//import Lineales.Estaticas.Pila;
import Lineales.Dinamicas.Pila;

//import Lineales.Dinamicas.src.Pila;
/*
 * 1. Crear un paquete lineales.estaticas e implementar la clase Pila,
 * incluyendo todas las operaciones del TDA
 * Pila.
 * 2. Crear un paquete tests.lineales e implementar la clase TestPila que
 * permita probar todas las operaciones
 * de la clase Pila anterior con números enteros.
 * 3. En la clase TestPila escriba un método que, dada una pila llena con
 * dígitos (0..9), verifique si la secuencia
 * forma un número capicúa o no. Nota: Utilizar una pila auxiliar para facilitar
 * la operación.
 * 4. Extienda la clase TestPila para comprobar que la misma clase Pila también
 * funciona con elementos de
 * tipo String.
 */
public class TestPila {
    public static void main(String[] args) {
        Pila pilaPrueba = new Pila();
        Pila pilaClon;
        int cargado = 10;

        /*** TEST PILA CON NUMEROS ENTEROS ***/

        System.out.println(">> ¡Pila Vacia!");
        /* Test TOSTRING con Pila Vacia */
        System.out.println("Test ToString (no debe listar): " + pilaPrueba.toString());

        /* Test ESVACIA con Pila Vacia */
        System.out.println("Test EsVacia (true): " + pilaPrueba.esVacia());

        /* Test DESAPILAR con Pila Vacia */
        System.out.println("Test Desapilar (false): " + pilaPrueba.desapilar());

        /* Test OBTENERTOPE con Pila Vacia */
        System.out.println("Test Obtener Tope (null):" + pilaPrueba.obtenerTope());

        /* Test CLONE con Pila Vacia */
        System.out.println(">> ¡Test Clon Pila Vacia!");
        pilaClon = pilaPrueba.clone();
        System.out.println("Pila Original: " + pilaPrueba.toString());
        System.out.println("Pila Clon: " + pilaClon.toString());
        System.out.println("Obtener tope de Clon: " + pilaClon.obtenerTope());

        /* Test APILAR */
        for (int i = 0; i < cargado; i++) {
            pilaPrueba.apilar((i));
        }

        /* Test TOSTRING con Pila Cargada */
        System.out.println(">> ¡Pila Cargada!");
        System.out.println("Test Apilar (10 elementos) y ToString: \n" + pilaPrueba.toString());

        /* Test ESVACIA con Pila Cargada */
        System.out.println("Test EsVacia (false): " + pilaPrueba.esVacia());

        /* Test OBTENERTOPE con Pila Cargada */
        System.out.println("Test Obtener Tope (9): " + pilaPrueba.obtenerTope());

        /* Test DESAPILAR con Pila Cargada */
        System.out.println("Test Desapilar (true): " + pilaPrueba.desapilar());
        System.out.println("Pila Actual despues de Desapilar: \n" + pilaPrueba.toString());

        /* Test OBTENERTOPE despues de Desapilar */
        System.out.println("Test Obtener Tope (8):" + pilaPrueba.obtenerTope());

        /* Test CLONE con Pila Cargada */
        System.out.println(">> ¡Test Clon Pila Cargada!");
        pilaClon = pilaPrueba.clone();
        System.out.println("Pila Original: \n" + pilaPrueba.toString());
        System.out.println("Pila Clon: \n" + pilaClon.toString());
        System.out.println("Obtener tope de Clon: " + pilaClon.obtenerTope());

        /* Test VACIAR con Pila Cargada */
        pilaPrueba.vaciar();
        System.out.println("Test Vaciar Pila Original (no debe listar): " + pilaPrueba.toString());
        pilaClon.vaciar();

        /*** TEST PILA CON STRINGS ***/
        System.out.println(">> ¡Test Clon Pila Cargada con Strings!");

        /* Test APILAR con Pila Cargada */
        pilaPrueba.apilar("Maru");
        pilaPrueba.apilar("Sofi");
        pilaPrueba.apilar("Lauti");
        pilaPrueba.apilar("Mint");
        pilaPrueba.apilar("Edat24");

        /* Test TOSTRING con Pila Cargada */
        System.out.println("Test TOSTRING (arreglos con strings): \n" + pilaPrueba.toString());

        /* Test OBTENERTOPE con Pila Cargada */
        System.out.println("Test Obtener Tope (Edat24):" + pilaPrueba.obtenerTope());

        /* Test DESAPILAR con Pila Cargada */
        System.out.println("Test Desapilar (true): " + pilaPrueba.desapilar());
        System.out.println("Pila Actual despues de Desapilar: \n" + pilaPrueba.toString());
        System.out.println("Obtener Tope (Mint):" + pilaPrueba.obtenerTope());

        /* Test CLONE con Pila Cargada */
        pilaClon = pilaPrueba.clone();
        System.out.println("Pila Original: \n" + pilaPrueba.toString());
        System.out.println("Pila Clon: \n" + pilaClon.toString());

        /* Test VACIAR con Pila Cargada */
        pilaPrueba.vaciar();
        System.out.println("Test Vaciar Pila Original (no debe listar): " + pilaPrueba.toString());

    }
}
