package testLineales;

import linealesEstaticas.Pila;

public class testPila {
    public static void main(String[] args){
        //Ejercicio 2
        Pila newPila1 = new Pila();

        for (int i = 0; i < 5; i++) {
            newPila1.apilar(i);
        }

        Pila newPila2 = newPila1.clone();

        // ---------------------Basicas---------------------
        //.apliar se utilizo en la repetitiva PARA

        System.out.println("Obtener tope: " + newPila1.obtenerTope());
        System.out.println("Verificar si esta vacia: " + newPila1.esVacia());
        System.out.println("Desapilar " + newPila1.desapilar() + "\n" + newPila1.toString());
        
        // ---------------------NO Basicas---------------------
        //.clone se utilizo antes y toString en todas las demas. 
        newPila1.vaciar();
        System.out.println("Vaciar Pila: " + newPila1.toString());
        System.out.println("Clonar Pila " + "\n" + newPila2.toString());
     
        //Ejercicio 3

        for (int i = 0; i < 5; i++) {
            newPila1.apilar((int)(Math.random()*10));
        }
        System.out.println("La random es: " + "\n" + newPila1.toString());

        Pila newPila3 = new Pila();
        Pila aux = newPila1.clone();
        Object numAux = "";

        for (int j = 0; j < 5; j++) {
            numAux = aux.obtenerTope();
            aux.desapilar();
            newPila3.apilar(numAux);
        }

        System.out.println("La invertida es: " + "\n" + newPila3.toString());

        if(newPila1.equals(newPila3) == true){
            System.out.println("Es capicua");
        }else{
            System.out.println("No son capicua");
        }

        /*
        Extienda la clase TestPila para comprobar que
        la misma clase Pila también funciona con elementos de tipo String.
        */
     }
}
