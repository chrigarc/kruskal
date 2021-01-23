
package utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase <b>GeneraObjetos</b>
 * <br>
 * Clase que lee un archivo de texto para luego
 * generar distintos objetos segun sea nesesario
 * @author Garcia Garcia Christian Rafael
 */

public class GeneraObjetos<E>{

    private BufferedReader contenido;
    private String file;

    public GeneraObjetos(String file){
        this.file = file;
        contenido = null;
        try{
            contenido = new BufferedReader(new FileReader(file));
        }catch(Exception io){
            System.err.print(io);

        }

    }

    public String getContenido(){
        String tmp_s;
	StringBuffer auxiliar=new StringBuffer();
	try{
	    while((tmp_s = contenido.readLine()) != null){
		auxiliar.append(tmp_s);
		auxiliar.append("\n");
	    }
	}catch (IOException ex) {
	    System.out.println(ex);
	}finally{
            try {
                contenido.close();
            } catch (IOException ex) {
                Logger.getLogger(GeneraObjetos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	tmp_s = auxiliar.toString();
        return tmp_s;
    }

    public GraphConstructor getGraph(){
        GraphConstructor grafica = null;
        try {
            java.util.List<Vertex<E>> lista = new java.util.LinkedList<Vertex<E>>();
            java.util.List<Edge<E>> lista_a = new java.util.LinkedList<Edge<E>>();
            String tmp_s;
            String[] tmp = contenido.readLine().split(",");
            int index_v = 0;
            int index_a = 0;
            boolean dirigida = Boolean.parseBoolean(tmp[2]);
            while((tmp_s = contenido.readLine()) != null){
                tmp = tmp_s.split(",");
                if(tmp[0].equalsIgnoreCase("vertex")){
                    if(!lista.contains(new Vertice<E>((E) tmp[2]))){
                        lista.add(new Vertice<E>((E) tmp[2],0));
                        lista.get(index_v).setColor(Integer.parseInt(tmp[4]));
                        lista.get(index_v).setIndex(index_v);
                        index_v++;
                    }
                }else if(tmp[0].equalsIgnoreCase("edge")){
                    lista_a.add(new Edge<E>(new Vertice<E>((E) tmp[2]),new Vertice<E>((E) tmp[4])));
                    lista_a.get(index_a).setWeight(Integer.parseInt(tmp[6]));
                    lista_a.get(index_a).setIndex(index_a);

                    index_a++;
                }
            }
            for (int i = 0; i < lista.size(); i++) {
                for (int j = 0; j < lista_a.size(); j++) {
                    if (lista_a.get(j).getSource().equals(lista.get(i))) {
                        lista_a.get(j).getSource().setIndex(lista.get(i).getIndex());
                    }

                    if (lista_a.get(j).getTarget().equals(lista.get(i))) {
                        lista_a.get(j).getTarget().setIndex(lista.get(i).getIndex());
                    }
                }

            }
            grafica = new GraphConstructor(lista, lista_a,dirigida);
            
        } catch (IOException ex) {
            Logger.getLogger(GeneraObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return grafica;
    }
    
    
}
