/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.binarios;

/**
 *
 * @author Juan Obregon
 */
public class ArbolBB {

    private Nodo raiz;

    public void addNodo(int elemento) {
        if (raiz == null) {
            raiz = new Nodo(elemento);
        } else {
            raiz.insertar(elemento);
        }
    }

    public void inorden (Nodo nodo){
        if(nodo == null){
            return;
        }else{
            inorden(nodo.getArbolIzquierdo());
            System.out.println("+" + nodo.getDato());
            inorden(nodo.getArbolDerecho());
        }
    }
    
    public void preorden(Nodo nodo){
        if(nodo == null){
            return;
        }else{
            System.out.println("+" + nodo.getDato());
            preorden(nodo.getArbolIzquierdo());
            preorden(nodo.getArbolDerecho());
        }
    }
    
    public void postorden(Nodo nodo){
        if(nodo == null){
            return;
        }else{
            postorden(nodo.getArbolIzquierdo());
            postorden(nodo.getArbolDerecho());
            System.out.println("+" + nodo.getDato());
        }
    }
        public void menorValor(Nodo nodo) {
        if (raiz != null) {
            nodo = raiz;
            while (nodo.getArbolIzquierdo() != null) {
                nodo = nodo.getArbolIzquierdo();
            }
            System.out.println("Menor valor del árbol:" + nodo.getDato());
        }
    }
        public void mayorValor(Nodo nodo) {
        if (raiz != null) {
            nodo = raiz;
            while (nodo.getArbolDerecho() != null) {
                nodo = nodo.getArbolDerecho();
            }
            System.out.println("Mayor valor del árbol:" + nodo.getDato());
        }
    }
        
    public boolean existe(int busqueda) {
    return existe(this.raiz, busqueda);
}

private boolean existe(Nodo n, int busqueda) {
    if (n == null) {
        return false;
    }
    if (n.getDato() == busqueda) {
        return true;
    } else if (busqueda < n.getDato()) {
        return existe(n.getArbolIzquierdo(), busqueda);
    } else {
        return existe(n.getArbolDerecho(), busqueda);
    }}
//Eliminar un nodo con hijos
     public void eliminar(int dato) throws Exception{
         raiz = eliminarN(raiz, dato);
     }
     
     protected Nodo eliminarN(Nodo aux, int dato)throws Exception{
         if(aux == null){
             throw new Exception("Nodo no encontrado");
         }
         else if(dato < aux.getDato()){
             Nodo iz = eliminarN(aux.getArbolIzquierdo(), dato);
             aux.setArbolIzquierdo(iz);
         }
         else if(dato > aux.getDato()){
             Nodo der = eliminarN(aux.getArbolDerecho(), dato);
             aux.setArbolDerecho(der);
         }
         else{
             Nodo p = aux;
             if(p.getArbolDerecho() == null){
                 aux = p.getArbolIzquierdo();
             }
             else if(p.getArbolIzquierdo() == null){
                 aux = p.getArbolDerecho();
             }
             else{
                 p = cambiar(p);
             }
             p = null;
         }
         return aux;
     }
     
     protected Nodo cambiar(Nodo aux){
         Nodo p = aux;
         Nodo a = aux.getArbolIzquierdo();
         while(a.getArbolDerecho() != null){
             p = a;
             a = a.getArbolDerecho();
         }
         aux.setDato(a.getDato());
         if(p == aux) p.setArbolIzquierdo(a.getArbolIzquierdo());
         else p.setArbolDerecho(a.getArbolIzquierdo());
         return a;
     }
    


    
    public static void main(String[] args) throws Exception {
        ArbolBB bb = new ArbolBB();
        bb.addNodo(5);
        bb.addNodo(3);
        bb.addNodo(6);
        bb.addNodo(4);
        bb.inorden(bb.raiz);
        System.out.println("");
        bb.preorden(bb.raiz);
        System.out.println("");
        bb.postorden(bb.raiz);
        System.out.println("");
       bb.menorValor(bb.raiz);
        System.out.println("");
        bb.mayorValor(bb.raiz);
        System.out.println(bb.existe(3));
        System.out.println(bb.existe(1));
        System.out.println(bb.existe(6));
        bb.eliminar(4);
   
        
      
        

    }

   
    
}