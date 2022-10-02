/*
Classe BarallaFitxes per fer la baralla de fitxes per després repartir-les
Nom: Bernat Parera Servera.
 */
package treball_final_scrabble;

public class BarallaFitxes {
    //Declaracio d'atribut de classe del nombre de fitxes que tendrà la baralla
    private static final int NOMBRE_FITXES = 104;
    //Declaracio d'atribut d'objecte que és el tauler de lletreas
    private char[] baralla;
    //metode constructor
    public BarallaFitxes() throws Exception {
        baralla = new char[NOMBRE_FITXES];
    }

    public void generarBarallaFitxes() throws Exception {
        //variable contador per comptar el nombre de fitxes d'un tipus que hi ha
        int contador = 0;
        //variable index per treballar amb l'array baralla.
        int index = 0;
        //variable linia
        Linea linea = new Linea();
        //lectura del fitxer "fitxes.txt"
        LineaFitxersLectura fitxer;
        fitxer = new LineaFitxersLectura("fitxes.txt");
        //mentre queden linies per llegir
        while (fitxer.hihaLinies()) {
            //lectura de la linia
            linea = fitxer.lectura();
            //si comença per alfabetic, usar el metode nombreFitxes per trobar
            //el nombre de fitxes corresponent.
            if (linea.començaPerAlfabetic()) {
                contador = linea.nombreFitxes();
                for (int i = 0; i < contador; i++) {
                    baralla[index] = linea.primerCaracter();
                    index++;
                }

            }
        }
        fitxer.tancament();
    }
    //metode per trobar la fitxa de la baralla en posocio index.
    public char trobarFitxa(int nombre){
        return baralla[nombre];
    }
    //metode que cerca la posicio a la baralla d'un caracter introduit per paràmetre
    public int cercarPosicioBaralla(char lletra){
        int index=0;
        for (int i = 0; i < NOMBRE_FITXES; i++) {
            if (baralla[i]==lletra){
                index= i;
            }
        }
        //retorn de variable index la qual correspon a la posicio on hi ha el caracter
        //del paraàmetre
        return index;
    }
}
