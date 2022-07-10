/*
Classe Puntuacio que té correspondència possicional amb BarallaFitxes.
Nom: Bernat Parera Servera
 */
package treball_final_scrabble;

/**
 *
 * @author berna
 */
public class PuntuacioFitxes {

    private static final int NOMBRE_FITXES = 104;
    private int[] puntuacio;

    //metode constructor
    public PuntuacioFitxes() throws Exception {
        puntuacio = new int[NOMBRE_FITXES];
    }

    public void generarPuntuacioFitxes() throws Exception {
        //variable contador per comptar el nombre de fitxes d'un tipus que hi ha
        int contador = 0;
        //variable index per treballar amb l'array puntuacio.
        int indice = 0;
        //declaracio linea
        Linea linea = new Linea();
        //lectura del fitxer fitxes.txt
        LineaFitxersLectura fitxer;
        fitxer = new LineaFitxersLectura("fitxes.txt");
        //mentre hi ha linies
        while (fitxer.hihaLinies()) {
            linea = fitxer.lectura();
            //si la linia comença per alfabetic
            if (linea.començaPerAlfabetic()) {
                //ús del metode nombreFitxes per trobar la quantitat de punts de 
                //cada lletra posar.
                contador = linea.nombreFitxes();
                //punts es el valor de cada fitxa dn quant a puntuacio
                int punts = linea.trobarPuntuacio();
                //colocacio a l'array els punts.
                for (int i = 0; i < contador; i++) {
                    puntuacio[indice] = punts;
                    indice++;
                }

            }
        }
        fitxer.tancament();
    }
    //metode que torna la puntuacio de l'index introduit per parametre.
    public int puntuacioPosicioIndex(int index){
        return puntuacio[index];
    }
}
