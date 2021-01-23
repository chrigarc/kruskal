/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kruskal;

/**
 *
 * @author Carreño Velazquez Lizbeth Dannae
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Escritor {

    BufferedWriter escritor;

    public Escritor(String archivo){
        try {
            escritor = new BufferedWriter(new FileWriter(archivo));
        } catch (IOException ex) {
            System.out.println("Error de Lectura-Escritura.\n\n");
            ex.printStackTrace();
        }
    }

    public void escribe(String linea){
        try {
            escritor.write(linea);
            escritor.newLine();
        } catch (IOException ex) {
            System.out.println("Error de Lectura-Escritura.\n\n");
            ex.printStackTrace();
        }
    }

    public void termina(){
        try {
            escritor.close();
        } catch (IOException ex) {
            System.out.println("Error de Lectura-Escritura.\n\n");
            ex.printStackTrace();
        }
    }

}
