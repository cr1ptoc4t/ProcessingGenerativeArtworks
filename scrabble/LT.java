//Classe LT per a la entrada de dades desde teclat
//Nom: Bernat Parera Servera
package treball_final_scrabble; 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * La clase LT (Lectura del Teclat) simplifica el procés de llegir dades des
 * de l'entrada del programa.
 * 
 * _/Manual d'ús\_______________________________________________________________
 * Aquesta classe proporciona mecanismes per llegir l'entrada a través del
 * teclat en prémer la tecla de retorn (intro).
 * 
 * __/Lectura del teclat\_______________________________________________________
 *  - LT.readChar(): lectura de caràcters 
 *      Llegeix l'entrada, un caràcter cada vegada que es fa servir.
 *      El darrer caràcter que es pot llegir és el \n.
 *      Després d'això espera una nova línia de text.
 * 
 *  - LT.readDouble(): lectura de nombres reals (precisió doble)
 *  - LT.readFloat(): lectura de nombres reals (precisió simple)
 *  - LT.readInt(): lectura de nombres enters (32 bits)
 *  - LT.readLong(): lectura de nombres enters (64 bits)
 *      Llegeix els caràcters de la línia actual
 *      (de la resta de la línia si s'ha consumit parcialment amb readChar)
 *      i els retorna en el format numèric desitjat.
 * 
 *  - LT.skipLine(): es bóta una línia
 *      Llegeix els caràcters de la línia actual
 *      (de la resta de la línia si s'ha consumit parcialment amb readChar)
 *      i els ignora.
 * 
 *  - LT.readLine(): lectura d'una línia
 *      Llegeix els caràcters de la línia actual
 *      (de la resta de la línia si s'ha consumit parcialment amb readChar)
 *      i els retorna un String.
 * 
 * __/Configuració\_____________________________________________________________
 *  - setup(): (re)configuració estàndard
 *      Es fa servir automàticament si no s'ha configurat.
 *      Hauria de funcionar correctament sempre excepte en els següents casos.
 * 
 *  - setupWindowsCmd(): (re)configuració pel terminal de Windows
 *      Estableix la codificació necessària per llegir correctament des del
 *      cmd de Windows.
 * 
 *  - setupWindowsNetbeans(): (re)configuració per Netbeans a Windows
 *      Estableix la codificació necessària per llegir correctament des del
 *      terminal integrat a Netbeans executat a Windows.
 * 
 * _/Historial de versions\_____________________________________________________
 * versió 2.2:
 *  - Mètode readLong.
 *  - Privatitzat read.
 *  - Afegit aquest manual d'ús.
 * 
 * versió 2.1:
 *  - Afegit suport per a codificacions de caràcters.
 *  - Afegit '\n' en omplir el buffer, respectant la lectura de línies i nombres.
 * 
 * versió 2.0:
 *  - Reescriptura de la classe.
 *  - Lectura de caràcters successius en una mateixa línia.
 * 
 * @author Els professors de l'assignatura 22393 - Programació - Informàtica I
 * @version 2.2
 */
public class LT {
    
    private static char[] buffer;
    private static int index;
    private static BufferedReader br;
    
    // A Windows, els encodings estan malament.
    private static final String ENCODING_WINDOWS_NETBEANS = "Cp1252";
    private static final String ENCODING_WINDOWS_CMD = "Cp850";
    
    private static boolean setup = false;
    
    /**
     * Configura l'encoding dels caràcters amb la codificació per defecte.
     * Hauria de funcionar bé, en teoria, excepte en els casos següents.
     */
    public static void setup() {
        br = new BufferedReader(new InputStreamReader(System.in));
        setup = true;
    }
    
    /**
     * Configura l'encoding dels caràcters per a funcionar dins el Netbeans a Windows.
     * Netbeans introdueix els caràcters amb Cp1252, però Java es pensa que ho fa en UTF-8.
     */
    public static void setupWindowsNetbeans() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in, ENCODING_WINDOWS_NETBEANS));
            setup = true;
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException(uee);
        }
    }
    
    /**
     * Configura l'encoding dels caràcters per a funcionar amb el CMD de Windows.
     * El CMD introdueix els caràcters amb Cp850, però Java es pensa que ho fa en Cp1252.
     */
    public static void setupWindowsCmd() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in, ENCODING_WINDOWS_CMD));
            setup = true;
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException(uee);
        }
    }
    
    
    /**
     * Omple el buffer amb una línia de l'entrada, reiniciant l'índex.
     */
    private static void fillBuffer() {
        if (!setup) {
            setup();
        }
        try {
            String line = br.readLine() + '\n';
            buffer = line.toCharArray();
            index = 0;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    /**
     * Llegeix la resta del buffer, a partir de l'índex actual, marcant-lo
     * com a llegit.
     * 
     * @return un String amb la resta del buffer
     */
    private static String readBuffer() {
        int offset = index;
        int count = buffer.length - index;
        index = buffer.length;
        return new String(buffer, offset, count);
    }
    
    /**
     * Retorna una línia sense el darrer caràcter, que és el de newline.
     * 
     * @param line la línia amb el \n al final
     * @return la línia sense el \n al final
     */
    private static String removeNewline(String line) {
        return line.substring(0, line.length() - 1);
    }
    
    /**
     * Llegeix un sol caràcter. Executa readChar().
     * 
     * @return el caràcter que s'ha llegit
     */
    private static char read() {
        return readChar();
    }
    
    /**
     * Llegeix un sol caràcter.
     * 
     * @return el caràcter que s'ha llegit
     */
    public static char readChar() {
        if (!(buffer != null && index < buffer.length)) {
            fillBuffer();
        }
        return buffer[index++];
    }
    
    /**
     * Llegeix una línia de text i la converteix en un nombre enter.
     * Una línia acaba amb un line feed ('\n'), carriage return ('\r'), o un
     * carriage return seguit immediatament d'un line feed.
     * 
     * @return l'int creat a partir de la línia de text llegida
     */
    public static int readInt() {
        if (!(buffer != null && index < buffer.length - 1)) {
            fillBuffer();
        }
        return Integer.parseInt(removeNewline(readBuffer()));
    }
    
    /**
     * Llegeix una línia de text i la converteix en un nombre enter.
     * Una línia acaba amb un line feed ('\n'), carriage return ('\r'), o un
     * carriage return seguit immediatament d'un line feed.
     * 
     * @return el long creat a partir de la línia de text llegida
     */
    public static long readLong() {
        if (!(buffer != null && index < buffer.length - 1)) {
            fillBuffer();
        }
        return Long.parseLong(removeNewline(readBuffer()));
    }
    
    /**
     * Llegeix una línia de text i la converteix en un nombre en punt flotant de
     * doble precisió.
     * Una línia acaba amb un line feed ('\n'), carriage return ('\r'), o un
     * carriage return seguit immediatament d'un line feed.
     * 
     * @return el double creat a partir de la línia de text llegida
     */
    public static double readDouble() {
        if (!(buffer != null && index < buffer.length - 1)) {
            fillBuffer();
        }
        return Double.parseDouble(removeNewline(readBuffer()));
    }
    
    /**
     * Llegeix una línia de text i la converteix en un nombre en punt flotant.
     * Una línia acaba amb un line feed ('\n'), carriage return ('\r'), o un
     * carriage return seguit immediatament d'un line feed.
     * 
     * @return el float creat a partir de la línia de text llegida
     */
    public static float readFloat() {
        if (!(buffer != null && index < buffer.length - 1)) {
            fillBuffer();
        }
        return Float.parseFloat(removeNewline(readBuffer()));
    }
    
    /**
     * Llegeix una línia de text i la converteix en un array de caràcters.
     * Una línia acaba amb un line feed ('\n'), carriage return ('\r'), o un
     * carriage return seguit immediatament d'un line feed.
     * 
     * @return el char[] creat a partir de la línia de text llegida
     */
    public static char[] readLineArray() {
        if (!(buffer != null && index < buffer.length - 1)) {
            fillBuffer();
        }
        return removeNewline(readBuffer()).toCharArray();
    }

    /**
     * Llegeix una línia de text i la converteix en un array de caràcters.
     * Una línia acaba amb un line feed ('\n'), carriage return ('\r'), o un
     * carriage return seguit immediatament d'un line feed.
     * 
     * @return el char[] creat a partir de la línia de text llegida
     */
    public static String readLine() {
        if (!(buffer != null && index < buffer.length - 1)) {
            fillBuffer();
        }
        return removeNewline(readBuffer());
    }

    
    /**
     * Es salta una línia de text.
     */
    public static void skipLine() {
        if (!(buffer != null && index < buffer.length)) {
            fillBuffer();
        }
        readBuffer();
    }
    
}
