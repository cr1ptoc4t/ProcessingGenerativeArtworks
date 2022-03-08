/*
CLASE PalabraFicherosEscritura
Aglutina las delcaraciones y funcionalidades necesarias para posibilitar la escritura
de objetos Palabra en un fichero de texto
 */
package treball_final_scrabble;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ParaulaFitxerEscritura {
    //DECLARACIÓN ATRIBUTOS
    //declaración atributo de clase constante entero que representa el código
    //de caracter del caracter espacio en blanco
    private static final int COD_ESPACIO=(int) ' ';
    //declaración atributo de clase constante entero que representa el código
    //del caracter de control RETURN
    private static final int RETURN=(int) '\r';
    //declaración atributo de clase constante entero que representa el código
    //del caracter de control SALTO DE LINEA
    private static final int SALTO_LINEA=(int) '\n';
    //declaración atributo de objeto BufferedWriter que posibilite el enlace
    //con el fichero de texto a nivel de escritura
    private BufferedWriter fichero=null;  
    
    //MÉTODOS
    //MÉTODO CONSTRUCTOR
    public ParaulaFitxerEscritura(String nombreFichero) throws Exception {
        //establecimiento enlace BufferedWriter con fichero de texto identificado
        //a través del parámetro String nombreFichero dado
        fichero=new BufferedWriter(new FileWriter(nombreFichero));
    }

    //CONSTRUCTOR PARA AÑADIR SIN  ELIMINAR FICHERO SI EXISTE PREVIAMENTE
    public ParaulaFitxerEscritura(String nombreFichero,boolean adicion) throws Exception {
        //establecimiento enlace BufferedWriter con fichero de texto identificado
        //a través del parámetro String nombreFichero dado
        fichero=new BufferedWriter(new FileWriter(nombreFichero,adicion));
    }    
    //MÉTODOS FUNCIONALES
    
    //MÉTODO escritura QUE LLEVA A CABO LA ESCRITURA DE UNA PALABRA EN EL
    //FICHERO DE TEXTO REPRESENTADO POR EL OBJETO BufferedWriter CORRESPONDIENTE
    public void escritura(Paraula paraula) throws Exception {
        //escritura de los caracteres de la palabra dada, caracter a caracter en
        //el fichero
        for (int indice=0;indice<paraula.agafarNombreCaracters();indice++) {
            //escritura en el fichero del caracter indice-ésimo de la palabra
            //dada
            fichero.write(paraula.caracterIndex(indice));
        }
    }
    
    //MÉTODO escrituraSeparador QUE LLEVA A CABO LA ESCRITURA DEL CÓDIGO
    //DE CARACTER DEL ESPACIO EN BLANCO EN EL FICHERO
    public void escrituraSeparador() throws Exception {
        //escritura del código del espacio en blanco en el fichero
        fichero.write(COD_ESPACIO);
    }
    
    //MÉTODO nuevaLinea QUE LLEVA A CABO LA CREACIÓN DE UNA NUEVA LINEA
    //EN EL FICHERO
    //NOTA: SI TRABAJAMOS EN WINDOWS TENEMOS QUE TENER EN CUENTA QUE
    //LA CREACIÓN DE UNA NUEVA LINEA EN UN FICHERO (NORMALMENTE SE LLAMA SALTO
    //DE LINEA) ES NESARIO LLEVARLO A CABO CON LOS CARACTERES DE CONTROL
    //RETURN Y SALTO DE LINEA.
    //EN MAC O LINUX SOLO SERÍA NECEARIO EL CARACTER DE CONTROL SALTO DE LINEA
    public void nuevaLinea() throws Exception {
        //escritura caracter de control RETURN en el fichero
        fichero.write(RETURN);
        //escritura caracter de control SALTO_LINEA en el fichero
        fichero.write(SALTO_LINEA);
    }
    
    //MÉTODO cerrarEnlaceFichero QUE LLEVA A CABO EL CIERRE DEL ENLACE BufferedWriter
    //con el fichero 
    public void cerrarEnlaceFichero() throws Exception {
        fichero.close();
    }
}
