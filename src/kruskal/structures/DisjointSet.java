/* -*-jde-*- */
/* <DisjointSet.java> */
package kruskal.structures;

/**
 * Clase para la construcción de Conjuntos Ajenos
 *
 * @author	Carreño Velazquez Lizbeth Dannae
 */
public abstract class DisjointSet {

    /**
     * Arreglo de los índices de los vértices
     */
    protected int[] vertices;
    /**
     * Arreglo para los representantes
     */
    protected int[] representantes;

    /**
     * Regresa el representante del indice del vertice que le pasemos como parámetro
     *
     * @param value el vértice del que queremos ver a su representante
     * @return el índice del representante del conjunto donde se encuentra el vertice
     */
    public abstract int findAgent(int value);

    /**
     * Une los representantes de los vertices
     *
     * @param vertex1 el vértice1 que queremos unir
     * @param vertex2 el vértice2 que queremos unir
     */
    public abstract void union(int vertex1, int vertex2);

    /**
     * Regresa una cadena de la representación de ésta clase
     *
     * @return la representacion en cadena de la clase
     */
    @Override
    public abstract String toString();
}// DisjointSet

