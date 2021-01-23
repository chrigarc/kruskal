package utils;

/*
*	Clase que sirve para generar y almacenar una matriz de incidencias
*/
public class ArrayGraph<E> extends EdgeGraph{

    public ArrayGraph(GraphConstructor<E> g){
        super(g);
    }

    private int[][] generaMatrizIncidencias(){
	int num_vertices = getVertexNum();
	int num_aristas = getEdgesNum();
      //  System.out.println("aristas: "+num_aristas);
	int matriz_inc[][] = new int[num_aristas][num_vertices];
	int matriz[][] = getMatriz();
	Vertex<E>[] vertices = getVertices();
	int index =0;
	for(int i=0;i<matriz.length;i++){
	    for(int j=0;j<matriz[i].length;j++){
		if(matriz[i][j]!=0){
		    matriz_inc[index][i]=matriz[i][j];
		    index++;
		}
	    }
	}

	return matriz_inc;

    }

    @Override
    public String toString(){
	int matriz_inc[][] = generaMatrizIncidencias();
	int matriz[][] = getMatriz();
	String tmp_s = "";
	Vertex<E>[] vertices = getVertices();
	for(int i=0;i<matriz_inc[0].length;i++){
            tmp_s+=vertices[i].getElement()+" : ";
	    for(int j=0;j<matriz_inc.length;j++)
		tmp_s += matriz_inc[j][i] + " ";
	    tmp_s+="\n";
	}
	return tmp_s;

    }
}