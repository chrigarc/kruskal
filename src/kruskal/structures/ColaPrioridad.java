/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kruskal.structures;

import java.util.List;
import utils.Edge;

/**
 *
 * @author Carreño Velazquez Lizbeth Dannae
 */
public class ColaPrioridad extends Heap<Edge>{

    private Edge[] nodos;
    private int max_size;
    private int size;

    public ColaPrioridad(Edge[] aristas){
        inicia(aristas.length+1);
    }

    public ColaPrioridad(List<Edge> aristas){
        inicia(aristas.size());
    }

    public void inicia(int max_size){
        this.max_size = max_size;
        size = 0;
        nodos = new Edge[max_size];
    }

    @Override
    public void add(Edge t) {
         if (size < max_size) {
            if (size == 0) {
                nodos[0] = t;    
            } else {
                nodos[size] = t;     
                reheap(0);
            }
            size++;
        }
   
    }

    public int getSize(){
        return size;
    }

    public int size(){ return size; }

    @Override
    public String toString() {
        String cadena = "";
        for(int i=0;i<size;i++){
            if(nodos[i]!=null)
                cadena+=nodos[i]+" ";
        }
        return cadena;
    }

    @Override
    public Edge getMin() {
        Edge tmp=nodos[0];
        swap(0,size);
        nodos[size]=null;
        size--;
        reheap(0);
        return tmp;
    }

    public boolean estaVacia(){ return size==0; }

    private void swap(int i1, int i2){
        Edge tmp=nodos[i1];
        nodos[i1]=nodos[i2];
        nodos[i2]=tmp;
    }

    private void reheap(int index){
        try {
            if (nodos[(2 * index) + 1].getWeight() < nodos[index].getWeight()) {
                swap(index, (2 * index) + 1);
                reheap((2 * index) + 1);
                reheap(0);
            } else {
                if (nodos[(2 * index) + 2].getWeight() < nodos[index].getWeight()) {
                    swap(index, (2 * index) + 2);
                    reheap((2 * index) + 2);
                    reheap(0);
                }
            }
        } catch (Exception e) {
        }
    }

}
