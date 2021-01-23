package utils;
import java.util.List;
public class GraphConstructor<E>{

    private List<Vertex<E>> vertices;
    private List<Edge<E>> aristas;
    private boolean dirigida;

    public GraphConstructor(List<Vertex<E>> vertices,
            List<Edge<E>> aristas, boolean dirigida){
        this.vertices = vertices;
        this.aristas = aristas;
        this.dirigida = dirigida;
    }

    public List<Edge<E>> getAristasList() {
        return aristas;
    }

    public Edge<E>[] getAristasArray(){
        Edge<E> arreglo[] = new Edge[aristas.size()];
        for(int i=0;i<aristas.size();i++)
            arreglo[i] = aristas.get(i);
        return arreglo;
        
    }

    public void setAristasList(List<Edge<E>> aristas) {
        this.aristas = aristas;
    }

    public List<Vertex<E>> getVerticesList() {
        return vertices;
    }

    public Vertex<E>[] getVerticesArray(){
        Vertex<E> arreglo[] = new Vertex[vertices.size()];
        for(int i=0;i<arreglo.length;i++)
            arreglo[i] = vertices.get(i);
        return arreglo;
    }

    public void setVerticesList(List<Vertex<E>> vertices) {
        this.vertices = vertices;
    }

    public int[][] getMatriz(){
      int[][] matriz = new int[vertices.size()][vertices.size()];
      //System.out.println(matriz.length);
      int index_1 = 0;
      int index_2 = 0;
      for(int i=0;i<aristas.size();i++){
          index_1 = getIndex(aristas.get(i).getSource());
          index_2 = getIndex(aristas.get(i).getTarget());
          matriz[index_1][index_2] = aristas.get(i).getWeight();
          if(!dirigida)
              matriz[index_2][index_1] = aristas.get(i).getWeight();
      }
      return matriz;
    }

    private int getIndex(Vertex<E> v){
        int i=0;
        while(i<vertices.size() && !vertices.get(i).equals(v))
            i++;
        return i;
    }

    public boolean isDirected(){
        return dirigida;
    }

    @Override
    public String toString(){
        StringBuilder tmp_s = new StringBuilder();
        tmp_s.append("lista vertices:\n");
        for(int i=0;i<vertices.size();i++){
            tmp_s.append(vertices.get(i)).append("\n");
        }
        tmp_s.append("lista aristas: \n");
        for(int i=0;i<aristas.size();i++)
           tmp_s.append(aristas.get(i)).append("\n");
        return tmp_s.toString();
    }

}
