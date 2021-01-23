
package utils;

import java.util.List;
public class NeighbourListGraph<E> extends EdgeGraph{

    public NeighbourListGraph(GraphConstructor<E> g){
        super(g);
    }

    private List<Vertex<E>> generaListaAdyacencias(){
	Vertex[] vertices = getVertices();
	java.util.LinkedList<Vertex<E>> lista = new java.util.LinkedList<Vertex<E>>();
	for(int i=0;i<vertices.length;i++){
	    vertices[i].addSymmetricNeighbours(getNeighborsList(vertices[i]));
	    lista.add(vertices[i]);
	}
	//System.out.println("********"+vertices.length);
	return lista;
    }

    @Override
    public String toString(){
	String tmp_s = "";
	List<Vertex<E>> lista = generaListaAdyacencias();
	for(int i=0;i<lista.size();i++){
	    tmp_s += lista.get(i).getElement() +" : ";
	    for(int j=0;j<lista.get(i).getNeighboursList().size();j++)
		tmp_s+=lista.get(i).getNeighboursList().get(j).getElement() + " ";
	    tmp_s+="\n";
	}
	return tmp_s;
    }
}
