package utils;
import java.util.List;

public class Vertice<E> extends Vertex{

    private java.util.List<Vertex<E>> lista_adyacencias;


    public Vertice(E element, int index){
        super(element,index);
    }

    public Vertice(E element){
        super(element);
    }

    /**
     * Da una lista con los vertices adyacentes.
     * @return la lista con los vertices adyacentes.
     */
    public List<Vertex<E>> getNeighboursList(){
	return lista_adyacencias;
    }

    /**
     * Da el vÃ©rtice adyacente en la i-Ã©sima posiciÃ³n de <i>neighbours</i>.
     * @param i la posiciÃ³n del vÃ©rtice deseado.
     * @return el i-Ã©simo vecino, si no existe tal posiciÃ³n
     */
    public Vertex<E> getNeighbour(int i){
	return null;
    }

    /**
     * Hace al vÃ©rtice adyacente a los vÃ©rtices de <i>vs</i>.
     * @param neighbours vÃ©rtices adyacentes.
     */
    public void addNeighbours(List vs){

    }

    /**
     * Hace al vÃ©rtice adyacente a los vÃ©rtices de <i>vs</i> y viceverza.
     * @param neighbours vÃ©rtices adyacentes.
     */
    public void addSymmetricNeighbours(List vs){
	lista_adyacencias=vs;
    }

    /**
     * Hace al vÃ©rtice adyacente al vÃ©rtice <i>v</i>.
     * @param v el vÃ©rtice.
     */
    public void addNeighbour(Vertex v){
    }

    /**
     * Hace al vÃ©rtice adyacente al vÃ©rtice <i>v</i> y viceverza.
     * @param v el vÃ©rtice.
     */
    public void addSymmetricNeighbour(Vertex v){
	int i=0;
	i++;
    }

    /**
     * Da el grado del vÃ©rtice.
     * El grado del vÃ©rtice es el nÃºmero de vÃ©rtices a los que Ã©ste es adyacente.
     * @return el grado del vÃ©rtice.
     */
    public int grade(){
	return 0;
    }

    public boolean equals(Object o){
        boolean status = false;
        if(o instanceof Vertice)
            status = ((Vertice)o).getElement().equals(this.getElement());
        else
            status = false;
        return status;

    }

}
