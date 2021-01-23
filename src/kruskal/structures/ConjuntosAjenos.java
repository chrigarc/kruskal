/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal.structures;

import utils.Vertex;

/**
 *
 * @author Carreño Velazquez Lizbeth Dannae
 */
public class ConjuntosAjenos extends DisjointSet {

    public ConjuntosAjenos(Vertex[] vs) {
        vertices = new int[vs.length];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = i;
        }
    }

    @Override
    public int findAgent(int value) {
        int agent = 0;
        int index = value;
        while (vertices[index] != index) {
            index = vertices[index];
        }
        agent = index;
        return agent;
    }

    @Override
    public void union(int vertex1, int vertex2) {
        if (vertex1 < vertex2) {
            vertices[vertex2] = vertex1;
        } else {
            vertices[vertex1] = vertex2;
        }
    }

    @Override
    public String toString() {
        String cadena = "";
        for (int i = 0; i < vertices.length; i++) {
            cadena += "v" + i + ": " + vertices[i];
        }
        return cadena;
    }
}
