/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kruskal.spanningtrees;

import java.util.LinkedList;
import utils.Edge;
import utils.Graph;
import utils.GraphConstructor;
import utils.NeighbourListGraph;
import utils.Vertex;
import kruskal.structures.ColaPrioridad;
import kruskal.structures.ConjuntosAjenos;

/**
 *
 * @author Carreño Velazquez Lizbeth Dannae
 */
public class Kruskal implements MinimumSpanningTree{

    public Graph getSpanningTree(Graph graph) throws Exception{
        Graph grafica = null;
        Vertex[] vertices = graph.getVertexArray();
        Edge[] aristas = graph.getEdgesArray();
        for(Edge i: aristas){
            if(i.getWeight() < 0){
                throw new Exception("Kruskal no permite pesos negativos");
            }
        }
        System.out.println("numero de aristas:" + aristas.length);
        ColaPrioridad cola = new ColaPrioridad(aristas);
        for(int i=0;i<aristas.length;i++){
            cola.add(aristas[i]);
        }
    //    System.out.println("size cola: "+cola.size());

        ConjuntosAjenos conjunto = new ConjuntosAjenos(vertices);

        LinkedList<Edge> aristas_g = new LinkedList<Edge>();
        while(!cola.estaVacia()){
            Edge e = cola.getMin();
            if (e != null) {
                Vertex v_i = e.getSource();
                Vertex v_f = e.getTarget();
                int set1 = conjunto.findAgent(v_i.getIndex());
                int set2 = conjunto.findAgent(v_f.getIndex());
                if (set1 != set2) {
                    conjunto.union(set1, set2);
                    aristas_g.add(e);
                }
            }
        }
        GraphConstructor gc = new GraphConstructor(graph.getVertexList(), aristas_g, false);
        grafica = new NeighbourListGraph(gc);
        return grafica;
    }

}
