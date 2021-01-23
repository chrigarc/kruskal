/* -*-jde-*- */
/* <Vertex.java> */
package utils;

import java.util.List;

/**
 * Modelo para la representaciÃ³n de los vÃ©rtices.
 *
 * @author Carreño Velazquez Lizbeth Dannae
 */
public abstract class Vertex<E> {

    /**
     * Elemento contenido en el vÃ©rtice
     */
    private E element;
    /**
     * Ãndice
     */
    private int index;
    /**
     * Color
     */
    private int color;
    private int distancia;
    private boolean visitado;

    /**
     * Crea un ejemplar vacÃ­o.
     */
    public Vertex() {
        this(null, Graph.NULL_INDEX);
    }

    /**
     * Crea un ejemplar con el elemento <i>element</i> contenido.
     * @param element
     */
    public Vertex(E element) {
        this(element, Graph.NULL_INDEX);
    }

    /**
     * Crea un ejemplar que contenga a <i>element</i>, y el indice dado.
     * @param element elemento.
     * @param index el indece del vertices.
     */
    public Vertex(E element, int index) {
        this.element = element;
        this.index = index;
        distancia = 0;
        visitado = false;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    /**
     * Da una lista con los vertices adyacentes.
     * @return la lista con los vertices adyacentes.
     */
    public abstract List<Vertex<E>> getNeighboursList();

    /**
     * Da el vÃ©rtice adyacente en la i-Ã©sima posiciÃ³n de <i>neighbours</i>.
     * @param i la posiciÃ³n del vÃ©rtice deseado.
     * @return el i-Ã©simo vecino, si no existe tal posiciÃ³n
     */
    public abstract Vertex<E> getNeighbour(int i);

    /**
     * Hace al vÃ©rtice adyacente a los vÃ©rtices de <i>vs</i>.
     * @param vs neighbours vÃ©rtices adyacentes.
     */
    public abstract void addNeighbours(List<Vertex<E>> vs);

    /**
     * Hace al vÃ©rtice adyacente a los vÃ©rtices de <i>vs</i> y viceverza.
     * @param vs neighbours vÃ©rtices adyacentes.
     */
    public abstract void addSymmetricNeighbours(List<Vertex<E>> vs);

    /**
     * Hace al vÃ©rtice adyacente al vÃ©rtice <i>v</i>.
     * @param v el vÃ©rtice.
     */
    public abstract void addNeighbour(Vertex<E> v);

    /**
     * Hace al vÃ©rtice adyacente al vÃ©rtice <i>v</i> y viceverza.
     * @param v el vÃ©rtice.
     */
    public abstract void addSymmetricNeighbour(Vertex<E> v);

    public int getIndex() {
        return index;
    }

    public void setIndex(int idx) {
        index = idx;
    }

    /**
     * Da el grado del vÃ©rtice.
     * El grado del vÃ©rtice es el nÃºmero de vÃ©rtices a los que Ã©ste es adyacente.
     * @return el grado del vÃ©rtice.
     */
    public abstract int grade();

    /**
     * Indica si <i>element</i> es <i>null</i>.
     * @return <i>true</i> si <i>element</i> es <i>null</i>,
     * <i>false></i> en otro caso.
     */
    public boolean isEmpty() {
        return (element == null) ? true : false;
    }

    /**
     * Regresamos el color el vÃ©rtice
     * @return El color el vÃ©rtice
     */
    public int getColor() {
        return color;
    }

    /**
     * Colocamos el nuevo color para el vÃ©rtice
     * @param color
     */
    public void setColor(int color) {
        this.color = color;
    }

    /**
     * Regresa la representaciÃ³n del vÃ©rtice. "el contenido el vÃ©rtice."
     * @return La representaciÃ³n de un ejemplar de la clase en cadena.
     */
    @Override
    public String toString() {
        return "< ( " + index + " )\t" + element.toString() + " > [" + color + "]";
    }
}
