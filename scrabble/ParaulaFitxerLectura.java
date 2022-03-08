/*
CLASE PalabraFicherosIn
Aglutina las delcaraciones y funcionalidades necesarias para posibilitar la lectura
de objetos Palabra desde un fichero de texto
 */
package treball_final_scrabble;

import java.io.BufferedReader;
import java.io.FileReader;

public class ParaulaFitxerLectura {
    //atribut de classe constant que representa el final d'un fitxer
    private static final int FINAL_FITXER=-1;
    //atribut de classe constant que representa el caracter espai
    private static final int COD_ESPAI=(int) ' ';
    //atribut de classe constant que representa el caracter de control return
    private static final int RETURN=(int) '\r';
    //declaració atribut de classe que representa el codi del caracter TAB
    private static final int TAB=(int) '	';    
    //declaració atribut de classe que representa el codi del caracter bot de linia
    private static final int BOT_LINEA=(int) '\n';
    //declaracio atribut d'objecte que representa el codi llegit del fitxer
    private int codi=COD_ESPAI;
    //enllaç bufferedReader que possibilita l'enllaç amb el fitxer
    private BufferedReader fitxer=null;
   
    //metode constructor
    public ParaulaFitxerLectura(String nombreFichero) throws Exception {
        //establiment de l'enllaç fisic.
        fitxer=new BufferedReader(new FileReader(nombreFichero));
    }
    
    //metode que verifica si hi ha paraules
    public boolean hihaParaules() throws Exception {
        cercarParaula();
        return (codi!=FINAL_FITXER);
    }
    //metode cercarParaula cerca si encara queden paraules per llegir
    private void cercarParaula() throws Exception {
        //lectura desde el fichero mientras el código de caracter leido
        //sea igual al espacio en blanco
        while ((codi==COD_ESPAI)||(codi==RETURN)||(codi==BOT_LINEA)) {
            //lectura siguiente código de caracter desde el fichero
            codi=fitxer.read();
        }
    }
    
    //metode que duu a terme la lectura del fitxer
    public Paraula lectura() throws Exception {
        //delcaracio objecte paraula per retornar
        Paraula paraula=new Paraula();
       //mentre no sigui cap d'aquests caracters segueix llegint
        while ((codi!=FINAL_FITXER)&&(codi!=COD_ESPAI)&&(codi!=RETURN)
                &&(codi!=BOT_LINEA)) {
            //enmagatzema el codi corresponent
            paraula.adicioCaracter((char) codi);
            //lectura següent caracter
            codi=fitxer.read();           
        }
        //tornar paraula
        return paraula;
    }
    //Metode per implementar el cercar paraules fins que hi hagi un bot de linea
      public boolean hihaBotDeLinea() throws Exception {
        cercarParaula();
        return (codi!=BOT_LINEA);
    }
    
    //metode per tancar enllaç amb el fitxer
    public void tancarEnllaçFitxer() throws Exception {
        fitxer.close();
    }
}
