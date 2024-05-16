package Lineales.Dinamicas;

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
        boolean exitoDesapilar = false;
        if (this.tope != null) {
            Nodo nodoAnterior = this.tope.getEnlace();
            this.tope = nodoAnterior;
            exitoDesapilar = true;
        }
        return exitoDesapilar;
    }

    public Object obtenerTope() {
        Object elemento = null;
        if(!esVacia()){
            elemento = this.tope.getElem();
        }
        return elemento;
    }

    public boolean esVacia() {
        return (this.tope == null);
    }

    public void vaciar() {
        this.tope = null;
    }

    public Pila clone() {
        Pila copia = new Pila();
        Nodo auxCopia;
        Nodo auxOri = this.tope;
        if (!esVacia()) {
            copia.tope = new Nodo(auxOri.getElem(), null);
            auxOri = auxOri.getEnlace();
            auxCopia = copia.tope;
            while (auxOri != null) {
                auxCopia.setEnlace(new Nodo(auxOri.getElem(), null));
                auxCopia = auxCopia.getEnlace();
                auxOri = auxOri.getEnlace();
            }
        }
        return copia;
    }

    public String toString() {
        String cadena = "";
        if (esVacia()) {
            cadena = "Pila Vacia";
        } else {
            Nodo aux = this.tope;
            cadena += "tope: " + this.tope.getElem() + "\n"; 
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
