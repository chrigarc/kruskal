/* -*-jde-*- */
/* <Heap.java> */
package kruskal.structures;

/**
 * Clase para la construcción de un Heap
 *
 * @author	Carreño Velazquez Lizbeth Dannae
 */
public abstract class Heap<Type> {

    /**
     * Mantiene el tamaño del heap para hacerlo más eficiente
     */
    protected int size;

    /**
     * Añade un elemento al heap
     * @param t el tipo generico que se anade
     */
    public abstract void add(Type t);

    /**
     * La representación en cadena de cómo se esta visualizando el heap
     * @return La representación en cadena del heap
     */
    @Override
    public abstract String toString();

    /**
     * Devuelve el elemento mínimo extrayendolo de la estructura de datos
     * @return el Minimo elemento del tipo generico
     */
    public abstract Type getMin();

    /**
     * Regresa el tamaño de la estructura
     * @return regresa el tamaño de la estructura
     */
    public int size() {
        return size;
    }// size()
}// Heap
