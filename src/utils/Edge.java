/* -*-jde-*- */
/* <Edge.java> */
package utils;

/**
 * Modelo para la representaciÃ³n de las aristas.
 *
 * @author	Carreño Velazquez Lizbeth Dannae
 */
public class Edge<E> {

    /**
     * VÃ©rtice origen.
     */
    private Vertex<E> source;
    /**
     * VÃ©rtice destino.
     */
    private Vertex<E> target;
    /**
     * Peso.
     */
    private int weight;
    /**
     * Ãndice.
     */
    private int index;

    /**
     * Crea un ejemplar de la clase con el vÃ©rtice origen <i>s</i> y vÃ©rtice destino <i>t</i>.
     * El peso serÃ¡ <i>DEFAULT_WEIGHT</i> y el Ã­ndice <i>NULL_INDEX</i>.
     * @param s vÃ©rtice orgigen.
     * @param t vÃ©rtice destino.
     */
    public Edge(Vertex<E> s, Vertex<E> t) {
        this(s, t, Graph.DEFAULT_WEIGHT, Graph.NULL_INDEX);
    }

    /**
     * Crea un ejemplar de la clase con el vÃ©rtice origen <i>s</i>, vÃ©rtice destino <i>t</i>,
     * peso w e Ã­ndice idx.
     * @param s vÃ©rtice orgigen.
     * @param t vÃ©rtice destino.
     * @param w peso.
     * @param idx Ã­ndice.
     */
    public Edge(Vertex<E> s, Vertex<E> t, int w, int idx) {
        source = s;
        target = t;
        weight = w;
        index = idx;
    }

    public Vertex<E> getSource() {
        return source;
    }

    public void setSource(Vertex<E> source) {
        this.source = source;
    }

    public Vertex<E> getTarget() {
        return target;
    }

    public void setTarget(Vertex<E> target) {
        this.target = target;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int w) {
        weight = w;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Regresa la representaciÃ³n de la arista con todas sus cualidades.
     * @return La representaciÃ³n de un ejemplar de la clase en cadena.
     */
    @Override
    public String toString() {
        return " < i:( " + index + " ) w:( " + weight + " ) s:( " + source.getElement().toString()
                + " ) t:( " + target.getElement().toString() + " ) > ";
    }

    @Override
    public boolean equals(Object o){
        boolean status = false;
        Edge tmp = null;
        if(o instanceof Edge)
            tmp = (Edge)o;
        status = tmp != null &&
                tmp.source.equals(this.source) &&
                tmp.target.equals(this.target) &&
                tmp.weight == tmp.weight;
        return status;
    }
}
