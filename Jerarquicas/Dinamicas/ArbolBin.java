package Jerarquicas.Dinamicas;

import Lineales.Dinamicas.Lista;
import Lineales.Dinamicas.Cola;

public class ArbolBin {

    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {
        boolean exito = true;

        if (this.raiz == null) {
            // si el arbol esta vacio, pone elem nuevo en la raiz
            this.raiz = new NodoArbol(elemNuevo, null, null);
        } else {
            // si arbol no esta vacio, busca al padre
            NodoArbol nPadre = obtenerNodo(this.raiz, elemPadre);

            // si padre existe y lugar no está ocupado lo pone, sino da error
            if (nPadre != null) {
                if (lugar == 'I' && nPadre.getIzquierdo() == null) {
                    nPadre.setIzquiedo(new NodoArbol(elemNuevo, null, null));
                } else if (lugar == 'D' && nPadre.getDerecho() == null) {
                    nPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                } else {
                    exito = false;
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    public boolean insertarPorPosicion(Object elemNuevo, int posPadre, char posHijo) {
        return insertarPorPosicionAux(elemNuevo, posPadre, posHijo, this.raiz);
    }

    private boolean insertarPorPosicionAux(Object elemNuevo, int posPadre, char posHijo, NodoArbol nodo) {
        boolean exito = false;

        if (nodo != null) {
            if (posPadre == 0) {
                if (posHijo == 'I' && nodo.getIzquierdo() == null) {
                    nodo.setIzquiedo(new NodoArbol(elemNuevo, null, null));
                    exito = true;
                } else if (posHijo == 'D' && nodo.getDerecho() == null) {
                    nodo.setDerecho(new NodoArbol(elemNuevo, null, null));
                    exito = true;
                }
            } else {
                exito = insertarPorPosicionAux(elemNuevo, posPadre - 1, posHijo, nodo.getIzquierdo());
                if (!exito) {
                    exito = insertarPorPosicionAux(elemNuevo, posPadre - 1, posHijo, nodo.getDerecho());
                }
            }
        }

        return exito;
    }

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        NodoArbol resultado = null;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                resultado = n;
            } else {
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                if (resultado == null) {
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public int altura() {
        return alturaAux(this.raiz);
    }

    private int alturaAux(NodoArbol nodo) {
        int altura = -1; // Inicializamos con -1 en caso de que el nodo sea nulo
        if (nodo != null) {
            int alturaIzq = alturaAux(nodo.getIzquierdo());
            int alturaDer = alturaAux(nodo.getDerecho());
            altura = Math.max(alturaIzq, alturaDer) + 1;
        }
        return altura;
    }

    public int nivel(Object elemento) {
        return nivelAux(this.raiz, elemento, 0);
    }

    private int nivelAux(NodoArbol nodo, Object elemento, int nivel) {
        int nivelEncontrado = -1; // Inicializamos con -1 en caso de que el nodo sea nulo

        if (nodo != null) {
            if (nodo.getElem().equals(elemento)) {
                nivelEncontrado = nivel;
            } else {
                int nivelIzq = nivelAux(nodo.getIzquierdo(), elemento, nivel + 1);
                if (nivelIzq != -1) {
                    nivelEncontrado = nivelIzq;
                } else {
                    nivelEncontrado = nivelAux(nodo.getDerecho(), elemento, nivel + 1);
                }
            }
        }

        return nivelEncontrado;
    }

    public Object padre(Object elemento) {
        return padreAux(this.raiz, elemento, null);
    }

    private Object padreAux(NodoArbol nodo, Object elemento, Object padre) {
        Object padreEncontrado = null; // Inicializamos como null en caso de que el nodo sea nulo

        if (nodo != null) {
            if ((nodo.getIzquierdo() != null && nodo.getIzquierdo().getElem().equals(elemento)) ||
                    (nodo.getDerecho() != null && nodo.getDerecho().getElem().equals(elemento))) {
                padreEncontrado = nodo.getElem();
            } else {
                Object padreIzq = padreAux(nodo.getIzquierdo(), elemento, nodo.getElem());
                if (padreIzq != null) {
                    padreEncontrado = padreIzq;
                } else {
                    padreEncontrado = padreAux(nodo.getDerecho(), elemento, nodo.getElem());
                }
            }
        }

        return padreEncontrado;
    }

    public Lista listarPreorden() {
        Lista listaPreorden = new Lista();
        listarPreordenAux(this.raiz, listaPreorden);
        return listaPreorden;
    }

    private void listarPreordenAux(NodoArbol nodo, Lista lista) {
        if (nodo != null) {
            lista.insertar(nodo.getElem(), lista.longitud() + 1);
            listarPreordenAux(nodo.getIzquierdo(), lista);
            listarPreordenAux(nodo.getDerecho(), lista);
        }
    }

    public Lista listarInorden() {
        Lista listaInorden = new Lista();
        listarInordenAux(this.raiz, listaInorden);
        return listaInorden;
    }

    private void listarInordenAux(NodoArbol nodo, Lista lista) {
        if (nodo != null) {
            listarInordenAux(nodo.getIzquierdo(), lista);
            lista.insertar(nodo.getElem(), lista.longitud() + 1);
            listarInordenAux(nodo.getDerecho(), lista);
        }
    }

    public Lista listarPosorden() {
        Lista listaPosorden = new Lista();
        listarPosordenAux(this.raiz, listaPosorden);
        return listaPosorden;
    }

    private void listarPosordenAux(NodoArbol nodo, Lista lista) {
        if (nodo != null) {
            listarPosordenAux(nodo.getIzquierdo(), lista);
            listarPosordenAux(nodo.getDerecho(), lista);
            lista.insertar(nodo.getElem(), lista.longitud() + 1);
        }
    }

    public Lista listarNiveles() {
        Lista listaNiveles = new Lista();
        if (!esVacio()) {
            Cola cola = new Cola();
            cola.poner(this.raiz);

            while (!cola.esVacia()) {
                NodoArbol nodo = (NodoArbol) cola.obtenerFrente();
                cola.sacar();
                listaNiveles.insertar(nodo.getElem(), listaNiveles.longitud() + 1);

                if (nodo.getIzquierdo() != null) {
                    cola.poner(nodo.getIzquierdo());
                }
                if (nodo.getDerecho() != null) {
                    cola.poner(nodo.getDerecho());
                }
            }
        }
        return listaNiveles;
    }

    public ArbolBin clone() {
        ArbolBin copia = new ArbolBin();
        if (this.raiz != null) {
            copia.raiz = cloneAux(this.raiz);
        }
        return copia;
    }

    private NodoArbol cloneAux(NodoArbol nodo) {
        NodoArbol nuevoNodo = null;
        if (nodo != null) {
            nuevoNodo = new NodoArbol(nodo.getElem(), null, null);
            nuevoNodo.setIzquiedo(cloneAux(nodo.getIzquierdo()));
            nuevoNodo.setDerecho(cloneAux(nodo.getDerecho()));
        }
        return nuevoNodo;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoArbol nodo) {
        String cadena = "";
        if (nodo != null) {
            cadena += nodo.getElem().toString() + " --> ";
            NodoArbol hijo = nodo.getIzquierdo();
            while (hijo != null) {
                cadena += hijo.getElem().toString() + ", ";
                hijo = hijo.getDerecho();
            }
            hijo = nodo.getIzquierdo();
            while (hijo != null) {
                cadena += "\n" + toStringAux(hijo);
                hijo = hijo.getDerecho();
            }
        }
        return cadena;
    }
}