package linealesEstaticas;

import java.util.Arrays;

public class Pila{
    private int tope;
    private static final int TAMANIO = 5;
    private Object arreglo[];

    public Pila(){
        // Crea y devuelve la pila vacía.
        this.arreglo = new Object[TAMANIO];
        this.tope=-1;
    }

    public boolean apilar(Object nuevoElem){
        // Pone el elemento nuevoElem en el tope de la pila. Devuelve verdadero si el elemento se pudo apilar y falso en caso contrario.
        boolean exito;
        if(this.tope+1>= TAMANIO){
            exito = false;
        }else{
            this.tope++;
            this.arreglo[this.tope]=nuevoElem;
            exito =true;
        }
        return exito;
    }

    public boolean desapilar(){
        // Saca el elemento del tope de la pila. Devuelve verdadero si la pila no estaba vacía al momento de desapilar (es decir que se pudo desapilar) y falso en caso contrario.
        boolean exito=false;
        if(this.tope > -1){
            this.arreglo[this.tope] = null;
            exito =true;
            this.tope--;
        }
        return exito;
    }

    public Object obtenerTope(){
        // Devuelve el elemento en el tope de la pila. Precondición: la pila no está vacía
        Object elemento=null;
        if(this.tope > -1){
            elemento = this.arreglo[this.tope];
        }
        return elemento;
    }

    public boolean esVacia(){
        // Devuelve verdadero si la pila no tiene elementos y falso en caso contrario
        boolean vacia=false;
        if(this.tope == -1){
            vacia = true;
        }
        return vacia;
    }

    public void vaciar(){
        // Saca todos los elementos de la pila.
        int i;
        for(i= this.tope; i>-1; i--){
            this.arreglo[i] = null;
        }
        this.tope = -1;
    }

    public Pila clone(){
        // Devuelve una copia exacta de los datos en la estructura original, y respetando el orden de los mismos,en otra estructura del mismo tipo
        Pila copia = new Pila();
        copia.arreglo = this.arreglo.clone();
        copia.tope = this.tope;
        return copia;
    }

    public String toString(){
        //// Devuelve una cadena de caracteres formada por todos los elementos de la pila para poder mostrarla
        //por pantalla. Es recomendable utilizar este método únicamente en la etapa de prueba y luego comentar el código
        String respuesta="";
        if(this.tope>-1){
            for(int i=0; i<=this.tope; i++){
                respuesta += "Posicion "+i+": "+this.arreglo[i].toString()+"\n";
            }
        }else{
            respuesta = "Pila Vacia";
        }
        return respuesta;
    }

    public boolean equals(Pila newPila1){
        //Compara si dos pilas son iguales en elementos.
        boolean aux = Arrays.equals(this.arreglo, newPila1.arreglo);
        return aux;
    }

}