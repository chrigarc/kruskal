package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbrirGrafica<E> {

    List<Vertex<E>> vertices;
    List<Edge<E>> aristas;
    boolean d;

    public AbrirGrafica(String file_name){
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(file_name));
            vertices= new LinkedList<Vertex<E>>();
            aristas = new LinkedList<Edge<E>>();
            String cadena = buffer.readLine();
            d= Boolean.parseBoolean(cadena.split(",")[2]);
            int i1=0;
            int i2=0;
            while((cadena=buffer.readLine())!=null){
                String[] arreglo = cadena.split(",");
                if(arreglo[0].equalsIgnoreCase("vertex")){
                    if(!vertices.contains(new Vertice(arreglo[2]))){
                        vertices.add(new Vertice(arreglo[2]));
                        vertices.get(i1).setIndex(i1);
                        vertices.get(i1).setColor(Integer.parseInt(arreglo[4]));
                        i1++;
                    }
                }else{
                    if(arreglo[0].equals("edge")){
                        aristas.add(new Edge(new Vertice(arreglo[2]),new Vertice(arreglo[4])));
                        aristas.get(i2).setWeight(Integer.parseInt(arreglo[6]));
                        aristas.get(i2).setIndex(i2);
                        i2++;
                    }
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(AbrirGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Edge<E>> getAristas() {
        return aristas;
    }

    public void setAristas(List<Edge<E>> aristas) {
        this.aristas = aristas;
    }

    public boolean estaDirigida() {
        return d;
    }

    public List<Vertex<E>> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex<E>> vertices) {
        this.vertices = vertices;
    }

    public Edge<E>[][] obtenerMatriz(){
        Edge<E> matriz[][] = new Edge[vertices.size()][vertices.size()];
        int indice_vertice1 =0;
        int indice_vertice2=0;
        for(int i=0;i<aristas.size();i++){
            indice_vertice1=buscaIndex(aristas.get(i).getSource());
            indice_vertice2=buscaIndex(aristas.get(i).getTarget());
            matriz[indice_vertice1][indice_vertice2]=aristas.get(i);
            if(!d)
                matriz[indice_vertice2][indice_vertice1]=aristas.get(i);
        }
        return matriz;
    }

    private int buscaIndex(Vertex v){
        int index=0;
        for(int i=0;i<vertices.size();i++)
               if(v.equals(vertices.get(i)))
                   index = i;
        return index;
    }

}