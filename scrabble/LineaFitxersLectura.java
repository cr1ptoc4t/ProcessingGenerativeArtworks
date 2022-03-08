/*
Classe que serveix per a la lectura de linies desde un fitxer
Nom: Bernat Parera Servera
 */
package treball_final_scrabble;

import java.io.BufferedReader;
import java.io.FileReader;

public class LineaFitxersLectura {
    //atribut de classe constant que representa el final d'un fitxer
    private static final int FINAL_FITXER=-1;
    //atribut de classe constant que representa el caracter de control return
    private static final int RETURN=(int) '\r';
    //atribut de classe constant que representa el caracter de control bot de linea
    private static final int BOT_LINEA=(int) '\n';  
    //declaracio atribut d'objecte variable codi que representa el caracter llegit
    //al fitxer
    private int codi=BOT_LINEA;
   
    //enllaç bufferedReader que possibilita l'enllaç amb el fitxer
    private BufferedReader fitxer=null;
  
    
    //metode constructor
    public LineaFitxersLectura(String nombre) throws Exception {
        //establiment de l'enllaç fisic.
        fitxer=new BufferedReader(new FileReader(nombre));
    }

    
    //mètode que verifica si queden paraules per llegir
    public boolean hihaLinies() throws Exception {
        //lectura de codi desde fitxer.
        codi=fitxer.read();
        return (codi!=FINAL_FITXER); 
    }
    
    //método que duu a terme la lectura d'una linia
    public Linea lectura() throws Exception {
        Linea linea=new Linea();
        if (codi==RETURN) {
            //lectura caracter després de detectar el return
            codi=fitxer.read();
            //tornar linia buida.
            return linea;
        }  
        while ((codi!=FINAL_FITXER)&&(codi!=RETURN)) {
            //afegir el caracter corresponent a linia
            linea.adicioCaracter(codi);
            //lectura del següent codi.
            codi=fitxer.read();
        }
        return linea;
    }
    
    //método que duu a terme el tancament amb l'enllaç del fitxer.
    public void tancament() throws Exception {
            fitxer.close();
    }
    //metode que verifica si hi ha un fina lde linia.
     public boolean hihaFinalLinea() throws Exception {
        //lectura de codi de caracter.
        codi=fitxer.read();
        return (codi!=BOT_LINEA);
     
            
     }
}
