package Lineales.Estaticas.src;

public class Pila {
    private Object[] arreglo;
    private int tope;
    private static final int tamanio = 20;

    public Pila() {
        this.arreglo = new Object[tamanio];
        this.tope = -1;
    }

    public boolean apilar(Object nuevoElem) {
        boolean exito;

        if (this.tope + 1 >= this.tamanio) {
            // Error: pila llena
            exito = false;
        } else {
            // pone el elemento en el tope de la pila e incrementa tope
            this.tope++;
            this.arreglo[tope] = nuevoElem;
            exito = true;
        }

        return exito;
    }

    public boolean desapilar() {
        boolean exito;

        if (this.esVacia()) {
            // Error: pila vacia
            exito = false;
        } else {
            // Saca el elemento del tope (deja en null) y cambia el tope a una posicion
            // menos.
            this.arreglo[tope] = null;
            this.tope--;
            exito = true;
        }

        return exito;
    }

    public Object obtenerTope() {
        Object elementoTope = null;
        if(this.tope != -1){
            elementoTope = this.arreglo[this.tope];
        }
        return elementoTope;
    }

    public boolean esVacia() {
        return (this.tope == -1);
    }

    public void vaciar() {
        if (!this.esVacia()) {
            for (int i = 0; i <= this.tope; i++) {
                this.arreglo[i] = null;
            }
            this.tope = -1;
        }
    }

    public Pila clone() {
        Pila nuevaPila = new Pila();

        if (!esVacia()) {
            nuevaPila.arreglo = this.arreglo.clone();
            nuevaPila.tope = this.tope;
        }

        return nuevaPila;
    }

    public String toString() {
        String cadena = "Es vacia!";
        if (!esVacia()) {
            cadena = "Tope: " + this.tope;
            for (int i = this.arreglo.length-1; i > -1; i--) {
                cadena += "\nPosicion: " + i + " Elemento: " + this.arreglo[i];
            }
        }
        return cadena;
    }
}
