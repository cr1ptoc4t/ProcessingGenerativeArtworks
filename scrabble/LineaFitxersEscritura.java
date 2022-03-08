/*
Escriu linies a un fitxer introduit per parametre
Nom: Bernat Parera Servera
 */
package treball_final_scrabble;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class LineaFitxersEscritura {
        //declaracio atribut de classe constant que representa el caracter return
    private static final int RETURN=(int) '\r';
    //declaracio atribut de classe constant que representa el caracter bot de linia
    private static final int SALTO_LINEA=(int) '\n';
    //declaracio atribut d'objecte BuffereWriter
    private BufferedWriter fitxer=null;  
    
    //metode constructor
    public LineaFitxersEscritura(String nombre) throws Exception {
        //establiment de l'enllaç lògic amb el fitxer
        fitxer=new BufferedWriter(new FileWriter(nombre));
    }
 
    public LineaFitxersEscritura(String nombre,boolean adicion) throws Exception {
        //establiment de l'enllaç fisic del fitxer
        fitxer=new BufferedWriter(new FileWriter(nombre,adicion));
    }
    
    //metode que duu a terme l'escritura d'una linia introduida per parametre
    public void escritura(Linea linea) throws Exception {
        for (int indice=0;indice<linea.nombreCaracters();indice++) {
            fitxer.write(linea.caracterIndex(indice));
        }
    }
    
    //metode que ecriu un bot de linia.
    public void escrituraBotDeLinea() throws Exception{
        fitxer.newLine();
    }
    
    //metode que tanca l'enllaç amb el fitxer
    public void tanca() throws Exception {
        fitxer.close();
    }
    
    
}
