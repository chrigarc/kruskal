/* -*-jde-*- */
/* <Graph.java> */
package kruskal.spanningtrees;

import utils.Graph;


/**
 * Cualquier objeto que implemente esta interfaz debera cumplir con
 * el contrato de entontrar un arbol de expansion mínima para una gráfica dada.
 *
 * @author Carreño Velazquez Lizbeth Dannae
 */
public interface MinimumSpanningTree {

    /**
     * Da un arbol de expansion minima para la grafica <i>G</i>.
     *
     * @param graph La grafica.
     * @return el árbol generador de peso mínimo.
     */
    public Graph getSpanningTree(Graph graph)  throws Exception;
}
