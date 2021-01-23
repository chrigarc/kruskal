
package utils;

import java.util.Arrays;
import java.util.List;
/**
 * Clase que simula una matriz de adyacencias e implementa todos los metodos de la clase Graph
 *
 *
 */
public class EdgeGraph<E> implements Graph{

    private Vertex<E>[] vertices;
    private int matriz[][];
    private boolean d;

    public EdgeGraph(GraphConstructor g){
        this.vertices = g.getVerticesArray();
	this.matriz = g.getMatriz();
        this.d = g.isDirected();
    }

    /**
     *  Arreglo con los vertices presentes en la grafica
     */
    public Vertex<E>[] getVertices(){
	return vertices;
    }

    /**
     * Retorna una matriz que contiene la informacion de la aristas
     */
    public int[][] getMatriz(){
	return matriz;
    }

    /**
     * Obtiene el numero de vertices de la grafica
     * @return el numero de vertices n
     */

    public int getVertexNum(){
	return matriz.length;
    }


    /**
     * Obtiene el numero de aristas de la grafica
     * @return el numero de aristas
     */
    public int getEdgesNum(){
	int index = 0;
	for(int i=0;i<matriz.length;i++)
	    for(int j=0;j<matriz[0].length;j++)
		if(matriz[i][j] > 0)
		    index++;
        if(!d)
            index = index/2;
	return index;
    }

    /**
	 * Regresa una <i>List</i> de vertices de la grafica
	 * @return lista de vertices
	 */
    public List<Vertex> getVertexList(){
	java.util.LinkedList<Vertex> lista = new java.util.LinkedList<Vertex>();
        lista.addAll(Arrays.asList(vertices));
	return lista;

    }

    /**
     * Regresa un arreglo de vertices de la grafica
     * @return arreglo de vertices
     */
    public Vertex[] getVertexArray(){
	return vertices;
    }

    /**
     * Regresa un objeto <i>Vertex</i> correspondiente al vertice con identificador entero i
     * @param	el entero i que identifica un vertice de la grafica de manera unica
     * @return	el objeto vertex correpondiente
     */
    public Vertex getVertex(int i){
	return vertices[i];
    }


    /**
     * Regresa una <i>List</i> de aristas de la grafica
     * si el conjunto de aristas de la grafica es vacio regresa null
     * @return lista de aristas
     */

    public List<Edge> getEdgesList(){
	int tam = getEdgesNum();
	if(tam == 0)
	    return null;
	java.util.LinkedList<Edge> lista = new java.util.LinkedList<Edge>();
	for(int i=0;i<matriz.length;i++)
	    for(int j=0;j<matriz[0].length;j++)
		if(matriz[i][j] != 0)
		    lista.add(new Edge(vertices[i],vertices[j],matriz[i][j],
				       Graph.NULL_INDEX));
	return lista;
    }


    /**
     * Regresa un arreglo de aristas de la grafica
     * si el conjunto de aristas de la grafica es vacio regresa null
     * @return arreglo de aristas
     */
    public Edge[] getEdgesArray(){
	java.util.List<Edge> lista = getEdgesList();
	if(lista == null || lista.isEmpty())
	    return null;
	Edge[] arreglo = new Edge[lista.size()];
	for(int i=0;i<arreglo.length;i++)
	    arreglo[i]=lista.get(i);
	return arreglo;

    }

    /**
     * Regresa un objeto <i>Edge</i> que une al vertice start con el vertice end si existe.
     * Si no existe tal arista se regresa una con peso 0.
     * @param start el vÃ©rtice inicio
     * @param end el vÃ©rtice final
     * @return una arista que une start con end
     */
    public Edge<E> getEdge(Vertex start, Vertex end){
	int index_start = 0;
	int index_end = 0;
	for(int i=0;i<vertices.length;i++)
	    if(vertices[i].getElement().equals(start.getElement()))
		index_start = i;
	for(int i=0;i<vertices.length;i++)
	    if(vertices[i].getElement().equals(end.getElement()))
		index_end = i;
	if(matriz[index_start][index_end]!= 0)
	    return new Edge(vertices[index_start],vertices[index_end],
			    matriz[index_start][index_end],Graph.NULL_INDEX);
	return new Edge(start,end);

    }
    /**
     * Regresa un objeto <i>Edge</i> que une al vertice start con el vertice end si existe.
     * Si no existe tal arista se regresa una con peso 0.
     * @param start el vÃ©rtice inicio
     * @param end el vÃ©rtice final
     * @return una arista que une start con end
     */
    public Edge<E> getEdge(int i){
	return null;
    }

    /**
     * Devuelve <i>true</i> si los vertices <i>start</i> y <i>end</i> son adyacentes
     * (si existe arista entre ellos) y false en otro caso
     * @param start devuelve si start es adyacente a end
     * @param end devuelve si end es adyacente a start
     * @return true si start es adyacente a end y false en otro caso
     */
    public boolean isAdjacent(Vertex start, Vertex end){
	int index_start = 0;
	int index_end = 0;
	for(int i=0;i<vertices.length;i++)
	    if(vertices[i].getElement().equals(start.getElement()))
		index_start = i;
	for(int i=0;i<vertices.length;i++)
	    if(vertices[i].getElement().equals(end.getElement()))
		index_end = i;
	if(matriz[index_start][index_end]!= 0)
	    return true;
	return false;
    }

    /**
     * Devuelve true si los dos vertices numerados con i,j son adyacentes
     * y false en otro caso
     * @param i el vÃ©rtice i
     * @param j el vÃ©rtice j
     * @return true si i es adyacente a j false en otro caso.
     */
    public boolean isAdjacent(int i, int j){
	return false;
    }

    /**
     * Obtiene el grado del vertice v (el numero de vertices adyacentes a el)
     * @param el vertice v
     * @return el grado de v
     */
    public int getDegree(Vertex v){
	int index_v = 0;
	for(int i=0;i<vertices.length;i++)
	    if(vertices[i].getElement().equals(v.getElement()))
		index_v = i;
	int grado =0;
	for(int i=0;i<matriz[index_v].length;i++)
	    if(matriz[index_v][i]!=0)
		grado++;
	return grado;
    }

    /**
     * obtiene el grado del vertice i-esimo de la grafica (el numero de vertices adyacentes a el)
     * @param el vertice i-esimo
     * @return el grado de tal vertice
     */
    public int getDegree(int index_v){
	int grado =0;
	for(int i=0;i<matriz[index_v].length;i++)
	    if(matriz[index_v][i]!=0)
		grado++;
	return grado;
    }


    /**
     * obtiene el peso de la arista e. Si no existe tal arista se regresa 0
     * @param la arista e
     * @return un entero que corresponde al peso de la arista e
     */
    public int getWeight(Edge e){
	Edge edge = getEdge(e.getSource(),e.getTarget());
	return edge.getWeight();
    }

    /**
     * obtiene el peso de la arista conformada por los vertices start y end.
     * Si no existe tal arista se regresa 0
     * @param los vertices start y end
     * @return un entero que corresponde al peso de la arista
     */
    public int getWeight(Vertex start, Vertex end){
	Edge edge = getEdge(start,end);
	return edge.getWeight();
    }

    /**
     * obtiene el peso de la arista conformada por los vertices start y end
     * identificados como el i-esimo y j-esimo respectivamente
     * Si no existe tal arista se regresa 0
     * @param los vertices start y end
     * @return un entero que corresponde al peso de la arista
     */
    public int getWeight(int start, int end){
	Edge edge = new Edge(vertices[start],vertices[end]);
	return edge.getWeight();

    }

    /**
     * Obtiene un arreglo de los vecinos del vertice v
     * @param el vertice v
     * @return el arreglo de vecinos
     */
    public Vertex[] getNeighborsArray(Vertex v){
	List<Vertex<E>> lista =  getNeighborsList(v);
	Vertex[] arreglo = new Vertex[lista.size()];
	for(int i=0;i<arreglo.length;i++)
	    arreglo[i]=lista.get(i);
	return arreglo;
    }

    /**
     * Obtiene un arreglo de los vecinos del vertice i-esimo de la grafica
     * @param el identificador del vertice
     * @return el arreglo de vecinos
     */
    public Vertex[] getNeighborsArray(int index){
	List<Vertex<E>> lista = getNeighborsList(index);
	Vertex[] arreglo = new Vertex[lista.size()];
	for(int i=0;i<arreglo.length;i++)
	    arreglo[i]=lista.get(i);
	return arreglo;
    }

    /**
     * Obtiene una List de los vecinos del vertice v
     * @param el vertice v
     * @return la lista de vecinos
     */
    public List<Vertex<E>> getNeighborsList(Vertex v){
	int index = 0;
	while(index<vertices.length && !v.getElement().equals(vertices[index].getElement())){
	    index++;
	}
	if(!vertices[index].getElement().equals(v.getElement()))
	    return new java.util.LinkedList<Vertex<E>>();
	java.util.LinkedList<Vertex<E>> lista = new java.util.LinkedList<Vertex<E>>();
	for(int i=0;i<matriz[index].length;i++)
	    if(matriz[index][i]!=0)
		lista.add(vertices[i]);
	//System.out.println("assasas:"+lista.size());
	return lista;

    }

    /**
     * Obtiene una List de los vecinos del vertice i-esimo de la grafica
     * @param el identificador del vertice
     * @return la lista de vecinos
     */
    public List<Vertex<E>> getNeighborsList(int index){
	//	System.out.println("netnsad");
	java.util.LinkedList<Vertex<E>> lista = new java.util.LinkedList<Vertex<E>>();
	for(int i=0;i<matriz[index].length;i++)
	    if(matriz[index][i]!=0)
		lista.add(vertices[i]);
	//	System.out.println("***"+lista.size());
	return lista;
    }

    public boolean getIsDirected(){ return d; }

    @Override
    public String toString(){
	String tmp_s = "";
	for(int i=0;i<matriz.length;i++){
	    tmp_s+=(vertices[i].getElement()+" : ");
	    for(int j=0;j<matriz[i].length;j++)
		tmp_s+=(matriz[i][j]+" ");
            tmp_s+="\n";
	}

	return tmp_s;
    }

}



