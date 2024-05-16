package Lineales.Dinamicas;

public class Lista {
    private Nodo cabecera;

    public Lista() {
        cabecera = null;
    }

    public boolean insertar(Object elemento, int posicion) {
        boolean exito = false;
        Nodo nodoNuevo = new Nodo(elemento, null);
        if (posicion >= 1 && posicion <= this.longitud() + 1) {
            if (posicion == 1) {
                nodoNuevo.setEnlace(cabecera);
                this.cabecera = nodoNuevo;
            } else {
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < posicion - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                nodoNuevo.setEnlace(aux.getEnlace());
                aux.setEnlace(nodoNuevo);
            }
            exito = true;
        }
        return exito;
    }

    public boolean eliminar(int posicion) {
        boolean exito = false;
        if (posicion >= 1 && posicion <= this.longitud() + 1) {
            if (posicion == 1) {
                this.cabecera = this.cabecera.getEnlace();
            } else {
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < posicion - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace());
            }
            exito = true;
        }
        return exito;
    }

    public Object recuperar(int posicion) {
        Object elemento = null;
        if (posicion >= 1 && posicion <= this.longitud() + 1) {
            Nodo aux = this.cabecera;
            int i = 1;
            while (i < posicion) {
                aux = aux.getEnlace();
                i++;
            }
            elemento = aux.getElem();
        }
        return elemento;
    }

    public int localizar(Object elementoBuscado) {
        int posicion = -1;
        boolean encontrado = false;
        Nodo aux = this.cabecera;
        int i = 1;
        while (i <= longitud() && !encontrado) {
            if (elementoBuscado == aux.getElem()) {
                posicion = i;
                encontrado = true;
            }
            aux = aux.getEnlace();
            i++;
        }
        return posicion;
    }

    public int longitud() {
        int longitud = 0;
        Nodo aux = this.cabecera;
        if (!esVacia()) {
            longitud++;
            while (aux.getEnlace() != null) {
                longitud++;
                aux = aux.getEnlace();
            }
        }
        return longitud;
    }

    public boolean esVacia() {
        return (this.cabecera == null);
    }

    public void vaciar() {
        this.cabecera = null;
    }

    public Lista clone() {
        Lista copia = new Lista();
        Nodo auxCopia;
        Nodo auxOri = this.cabecera;
        if (!esVacia()) {
            copia.cabecera = new Nodo(auxOri.getElem(), null);
            auxOri = auxOri.getEnlace();
            auxCopia = copia.cabecera;
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
            cadena = "¡Lista Vacia!";
        } else {
            Nodo aux = this.cabecera;
            cadena += "Cabecera: " + this.cabecera.getElem() + "\n"; 
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
