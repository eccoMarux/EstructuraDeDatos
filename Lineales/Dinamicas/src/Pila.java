package Lineales.Dinamicas.src;

public class Pila {
    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public boolean apilar(Object nuevoElemento) {
        // Creo nuevo nodo con el elemento y apunto al tope actual
        Nodo nuevoNodo = new Nodo(nuevoElemento, this.tope);
        // Actualizo el tope
        this.tope = nuevoNodo;
        return true;
    }

    public boolean desapilar() {
        boolean exitoDesapilar = (this.tope == null);
        if (!exitoDesapilar) {
            Nodo nodoAnterior = this.tope.getEnlace();
            this.tope = nodoAnterior;
            exitoDesapilar = true;
        }
        return exitoDesapilar;
    }

    public Object obtenerTope() {
        return this.tope.getElem();
    }

    public boolean esVacia() {
        return (this.tope == null);
    }

    public void vaciar() {
        this.tope = null;
    }

    public Pila clone() {
        Pila pilaClon = new Pila();
        // Ayuda
        return pilaClon;
    }

    public String toString() {
        String cadena = "";
        if (esVacia()) {
            cadena = "Pila Vacia";
        } else {
            Nodo aux = this.tope;
            cadena += "[ ";
            while (aux != null) {
                cadena += aux.getElem().toString();
                aux = aux.getEnlace();
                if (aux != null) {
                    cadena += ", ";
                }
            }
            cadena += " ]";
        }
        return cadena;
    }
}
