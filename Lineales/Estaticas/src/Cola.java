package Lineales.Estaticas.src;

public class Cola {
    private Object[] arreglo;
    private int frente;
    private int fin;
    private static final int TAMANIO = 10;

    public Cola() {
        this.arreglo = new Object[this.TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }

    public boolean poner(Object nuevoElemento) {
        boolean exito = false;
        if (((this.fin + 1) % this.TAMANIO) != this.frente) { // Verifica que NO este llena
            this.arreglo[this.fin] = nuevoElemento;
            this.fin = (this.fin + 1) % this.TAMANIO;
            exito = true;
        }
        return exito;
    }

    public boolean sacar() {
        boolean puedoSacar = !(esVacia()); // si es vacia(true), exito es falso y retorna falso.
        if (puedoSacar) {
            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1) % this.TAMANIO;
        }
        return puedoSacar;
    }

    public Object obtenerFrente() {
        Object elemento;
        if (esVacia()) {
            elemento = null;
        } else {
            elemento = this.arreglo[this.frente];
        }
        return elemento;
    }

    public boolean esVacia() {
        return (this.frente == this.fin);
    }

    public void vaciar() {
        if (!esVacia()) { 
            while (this.frente != this.fin) {
                this.arreglo[this.frente] = null; 
                this.frente = (this.frente + 1) % TAMANIO;
            }
            this.frente = 0;
            this.fin = 0;
        }
    }
    

    public Cola clone() {
        Cola clon = new Cola();
        clon.arreglo = this.arreglo.clone();
        clon.frente = this.frente;
        clon.fin = this.fin;
        return clon;
    }

    public String toString() {
        String cadena = "Cola: \n";
        int i = this.frente;
        while (i != this.fin) {
            cadena += "  " + this.arreglo[i] + "\n";
            i = (i + 1) % this.TAMANIO;
        }
        return cadena;
    }
}