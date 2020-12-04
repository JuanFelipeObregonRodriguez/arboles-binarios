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
public class Nodo {
    private int dato;
    private Nodo arbolIzquierdo;
    private Nodo arbolDerecho;

    public Nodo(int dato) {
        this.dato = dato;
    }
    
    public Nodo(){
    }
    
    public void insertar(int elemento){
        if(elemento < dato){
            if(arbolIzquierdo == null){
                arbolIzquierdo = new Nodo(elemento);
            }else
                arbolIzquierdo.insertar(elemento);
        }
        else{
            if(arbolDerecho == null){
                arbolDerecho = new Nodo(elemento);
            }else
                arbolDerecho.insertar(elemento);
        }     
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getArbolIzquierdo() {
        return arbolIzquierdo;
    }

    public void setArbolIzquierdo(Nodo arbolIzquierdo) {
        this.arbolIzquierdo = arbolIzquierdo;
    }

    public Nodo getArbolDerecho() {
        return arbolDerecho;
    }

    public void setArbolDerecho(Nodo arbolDerecho) {
        this.arbolDerecho = arbolDerecho;
    }
    
    
    
}