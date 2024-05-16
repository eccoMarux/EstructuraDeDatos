package Lineales.Estaticas.Jerarquicas;

public class ArbolBin {

    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar){
        boolean exito = true;

        if (this.raiz == null){
            //si el arbol esta vacio, pone elem nuevo en la raiz
            this.raiz = new NodoArbol(elemNuevo, null, null);
        }else{
            //si arbol no esta vacio, busca al padre
            NodoArbol nPadre = obtenerNodo(this.raiz, elemPadre);

            //si padre existe y lugar no está ocupado lo pone, sino da error
            if (nPadre != null){
                if (lugar == 'I' && nPadre.getIzquierdo() == null){
                    nPadre.setIzquiedo(new NodoArbol(elemNuevo, null, null));
                }else if (lugar == 'D' && nPadre.getDerecho() == null) {
                    nPadre.setDerecho(new NodoArbol(elemNuevo, null, null));                    
                }else{
                    exito = false;
                }
            }else{
                exito = false;
            }
        }
    }

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado){
        NodoArbol resultado = null;
        if(n!= null){
            if(n.getElem().equals(buscado)){
                resultado = n;
            }else{
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                if(resultado == null){
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }

}