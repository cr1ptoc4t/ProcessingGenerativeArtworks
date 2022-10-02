/*
Clase LineasFicherosIn --> aglutina las declaraciones y funcionalidades que
posibilitan la gestion de la lectura de objetos Linea desde un fichero de
texto

NOTA: clase preparada para funcionar a nivel de BufferedReader
 */
package treball_final_scrabble;

import java.io.BufferedReader;
import java.io.FileReader;

public class LineaFicherosLectura {
    //DECLARACIONES
    //Declaracion atributo de clase constante entero que representa el final de
    //un fichero
    private static final int FINAL_FICHERO=-1;
    //declaracion atributo de objclaseeto constante entero que representa el codigo
    //del caracter de control RETURN
    private static final int RETURN=(int) '\r';
    //declaracion atributo de clase constante entero que representa el codigo
    //del caracter de control SALTO DE LINEA
    private static final int SALTO_LINEA=(int) '\n';  
    //declaracion atributo de clase variable entero que represente el codigo
    //de caracter leido desde el fichero
    private int codigo=SALTO_LINEA;
   
    //declaracion atributo de objeto BufferedReader que posibilite el enlace
    //con el fichero de texto a nivel de lectura
    private BufferedReader fichero=null;
    
    
    
    //MÉTODOS
    
    //Métodos Constructores
    public LineaFicherosLectura(String nombre) throws Exception {
        //establecimiento del enlace logico con el fichero físico
        fichero=new BufferedReader(new FileReader(nombre));
    }
    
    //Métodos Funcionales
    
    //método que verifica si hay palabras por leer en un fichero de texto dado
    public boolean hayLineas() throws Exception {
        //lectura codigo de caracter desde el fichero
        codigo=fichero.read();
        return (codigo!=FINAL_FICHERO); 
    }
    
    //método que lleva a cabo la lectura de un objeto Linea desde un fichero de texto
    public Linea lectura() throws Exception {
        Linea linea=new Linea();
        if (codigo==RETURN) {
            //lectura caracter de control SALTO DE LINEA que viene después del
            //caracter RETURN
            codigo=fichero.read();
            //devolver linea vacia
            return linea;
        }  
        while ((codigo!=FINAL_FICHERO)&&(codigo!=RETURN)) {
            //añadir elcaracter correspondiente al codigo leido al objeto Linea
            linea.adicionCaracter(codigo);
            //lectura siguiente codigo de caracter desde el fichero de texto
            codigo=fichero.read();
        }
        return linea;
    }
    
    //método que lleva a cabo el cierre del enlace logico con el fichero de texto
    public void cierre() throws Exception {
            fichero.close();
    }
     public boolean hayFinalLinea() throws Exception {
        //lectura codigo de caracter desde el fichero
        codigo=fichero.read();
        return (codigo!=SALTO_LINEA);
     
            
     }
}
