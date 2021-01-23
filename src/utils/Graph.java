/* -*-jde-*- */
/* <Graph.java> */
package utils;

import java.util.List;

/**
 * Interfaz de la clase Graph G=(V,E) donde V es un conjunto de
 * Vertices (Vertex) y E es un conjunto de aristas (Edge)
 * (formadas por pares de vertices en V). V no vacio.
 *
 * @author Carreño Velazquez Lizbeth Dannae
 */
public interface Graph<E> {

    /**
     * Ãndice nulo.
     */
    public static int NULL_INDEX = -1;
    /**
     * Peso predeterminado
     */
    public static int DEFAULT_WEIGHT = 1;

    /**
     * Obtiene el numero de vertices de la grafica
     * @return el numero de vertices n
     */
    public int getVertexNum();

    /**
     * Obtiene el numero de aristas de la grafica
     * @return el numero de aristas
     */
    public int getEdgesNum();

    /**
     * Regresa una <i>List</i> de vertices de la grafica
     * @return lista de vertices
     */
    public List<Vertex> getVertexList();

    /**
     * Regresa un arreglo de vertices de la grafica
     * @return arreglo de vertices
     */
    public Vertex[] getVertexArray();

    /**
     * Regresa un objeto <i>Vertex</i> correspondiente al vertice con identificador entero i
     * @param i el entero i que identifica un vertice de la grafica de manera unica
     * @return	el objeto vertex correpondiente
     */
    public Vertex getVertex(int i);

    /**
     * Regresa una <i>List</i> de aristas de la grafica
     * si el conjunto de aristas de la grafica es vacio regresa null
     * @return lista de aristas
     */
    public List<Edge> getEdgesList();

    /**
     * Regresa un arreglo de aristas de la grafica
     * si el conjunto de aristas de la grafica es vacio regresa null
     * @return arreglo de aristas
     */
    public Edge[] getEdgesArray();

    /**
     * Regresa un objeto <i>Edge</i> que une al vertice inicio con el vertice fin si existe.
     * Si no existe tal arista se regresa una con peso 0.
     * @param start el vÃ©rtice inicio
     * @param end el vÃ©rtice final
     * @return una arista que une start con end
     */
    public Edge<E> getEdge(Vertex<E> start, Vertex<E> end);

    /**
     * Regresa la arista etiquetada con el numero <i>i</i> de la grafica,
     * si no existe arista, regresa una arista con peso 0
     * @param i el numero i de arista que se requiere
     * @return la arista etiquetada con i
     */
    public Edge<E> getEdge(int i);

    /**
     * Devuelve <i>true</i> si los vertices <i>start</i> y <i>end</i> son adyacentes
     * (si existe arista entre ellos) y false en otro caso
     * @param start devuelve si start es adyacente a end
     * @param end devuelve si end es adyacente a start
     * @return true si start es adyacente a end y false en otro caso
     */
    public boolean isAdjacent(Vertex start, Vertex end);

    /**
     * Devuelve true si los dos vertices numerados con i,j son adyacentes
     * y false en otro caso
     * @param i el vÃ©rtice i
     * @param j el vÃ©rtice j
     * @return true si i es adyacente a j false en otro caso.
     */
    public boolean isAdjacent(int i, int j);

    /**
     * Obtiene el grado del vertice v (el numero de vertices adyacentes a el)
     * @param v el vertice v
     * @return el grado de v
     */
    public int getDegree(Vertex v);

    /**
     * obtiene el grado del vertice i-esimo de la grafica (el numero de vertices adyacentes a el)
     * @param i el vertice i-esimo
     * @return el grado de tal vertice
     */
    public int getDegree(int i);

    /**
     * obtiene el peso de la arista e. Si no existe tal arista se regresa 0
     * @param e la arista e
     * @return un entero que corresponde al peso de la arista e
     */
    public int getWeight(Edge e);

    /**
     * obtiene el peso de la arista conformada por los vertices start y end.
     * Si no existe tal arista se regresa 0
     * @param start
     * @param end
     * @return un entero que corresponde al peso de la arista
     */
    public int getWeight(Vertex start, Vertex end);

    /**
     * obtiene el peso de la arista conformada por los vertices start y end
     * identificados como el i-esimo y j-esimo respectivamente
     * Si no existe tal arista se regresa 0
     * @param start
     * @param end
     * @return un entero que corresponde al peso de la arista
     */
    public int getWeight(int start, int end);

    /**
     * Obtiene un arreglo de los vecinos del vertice v
     * @param v el vertice v
     * @return el arreglo de vecinos
     */
    public Vertex[] getNeighborsArray(Vertex v);

    /**
     * Obtiene un arreglo de los vecinos del vertice i-esimo de la grafica
     * @param i el identificador del vertice
     * @return el arreglo de vecinos
     */
    public Vertex[] getNeighborsArray(int i);

    /**
     * Obtiene una List de los vecinos del vertice v
     * @param v el vertice v
     * @return la lista de vecinos
     */
    public List<Vertex<E>> getNeighborsList(Vertex<E> v);

    /**
     * Obtiene una List de los vecinos del vertice i-esimo de la grafica
     * @param i el identificador del vertice
     * @return la lista de vecinos
     */
    public List<Vertex<E>> getNeighborsList(int i);

    @Override
    public String toString();
}
