package Lineales.Dinamicas.src;

public class Cola {
    private Nodo frente;
    private Nodo fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public boolean poner(Object elemento) {
        Nodo nuevoNodo = new Nodo(elemento, null);
        if (esVacia()) {
            // Si la cola esta vacia entonces frente y fin apuntan al nodo creado.
            this.frente = this.fin = nuevoNodo;
        } else {
            this.fin.setEnlace(nuevoNodo);
            this.fin = nuevoNodo; // recordar actualizar el fin.
        }
        return true;
    }

    public boolean sacar() {
        boolean exito = false;
        if (this.frente != null) {
            this.frente = this.frente.getEnlace();
            if (this.frente == null) {
                this.fin = null;
            }
            exito = true;
        }
        return exito;
    }

    public Object obtenerFrente() {
        Object elementoFrente = null;
        if (!esVacia()) {
            elementoFrente = this.frente.getElem();
        }
        return elementoFrente;
    }

    public boolean esVacia() {
        return (this.frente == null);
    }

    public void vaciar() {
        this.fin = this.frente = null;
    }

    public Cola clone() {
        Cola colaClon = new Cola();
        Nodo auxCopia;
        Nodo auxOri = this.frente;
        if (!esVacia()) {
            colaClon.frente = new Nodo(auxOri.getElem(), null);
            auxOri = auxOri.getEnlace();
            auxCopia = colaClon.frente;
            while (auxOri != null) {
                auxCopia.setEnlace(new Nodo(auxOri.getElem(), null));
                auxCopia = auxCopia.getEnlace();
                auxOri = auxOri.getEnlace();
            }
            colaClon.fin = auxCopia;
        }
        return colaClon;
    }

    public String toString() {
        String cadena = "";
        if (esVacia()) {
            cadena = "¡Cola Vacia!";
        } else {
            Nodo aux = this.frente;
            cadena += "Frente: " + this.frente.getElem() + "\n"; 
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
