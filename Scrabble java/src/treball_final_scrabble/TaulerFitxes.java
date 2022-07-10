/*
Classe fitxes per donar 11 fitxes a l'usuari
Nom: Bernat Parera Servera
 */
package treball_final_scrabble;

import java.util.Random;

public class TaulerFitxes {

    //Declaracio d'atribut de classe del nombre de fitxes que donarem cada torn
    private static int NOMBRE_FITXES=11;
    //Declaracio d'atribut d'objecte que és el tauler de lletreas
    private char[] Fitxes = new char[NOMBRE_FITXES];

    //Metode constructor buit
    public TaulerFitxes() {
       
    }
    //Metode assignacioFitxes per assignar un tauler a l'usuari o al simulador
    public void assignacioFitxes() throws Exception {
        //baralla de la classe BarallaFitxes per crear el tauler
        BarallaFitxes baralla = new BarallaFitxes();
        //gerear la baralla
        baralla.generarBarallaFitxes();
        //declaracio i inicialitzacio a false a un array de booleans de grandària
        //de la baralla i també amb correspondencia posicional amb la baralla per saber
        //si s'ha agafat ja aquella lletra o no.
        boolean[] VerificacioBaralla = new boolean[104];
        for (int i = 0; i < 104; i++) {
            VerificacioBaralla[i] = false;
        }
        //aleatori del tipus random per crear un nombre aleatori
        Random aleatori = new Random();
        //declaracio variable del tipus int nombre per guardar el nombre aleatori
        int nombre;
        //variable index del tipis int per al bucle while
        int index = 0;
        //bucle while que acaba quan ja ha trobat totes fitxes del tauler
        while (index < NOMBRE_FITXES) {
            //assignament a nombre del nombre aleatori
            nombre = aleatori.nextInt(104);
            //si la verificacio de index es false entra al if.
            if (!VerificacioBaralla[nombre]) {
                //assignacio a la posicio nombre true per marcar que ja hem agafat
                //la fitxa seleccionada i no repetir.
                VerificacioBaralla[nombre] = true;
                //assignacio a fitxes d'index la fitxa que està a la posicio
                //del nombre aleatori
                Fitxes[index] = baralla.trobarFitxa(nombre);
                //suma a index 1
                index++;
            }
        }

    }
    //metode per mostrar les fitxes assignades amb un espai entre elles
    public void mostraFitxes() throws Exception {
        //bucle per mostrar totes les fitxes.
        for (int index = 0; index < NOMBRE_FITXES; index++) {
            System.out.print(Fitxes[index]+" ");
        }
        //insertar bot de linea ja que no podem usar es System.out.println ja que
        //vull que les fitxes estiguin totes a la mateixa linea.
        System.out.print("\n");
    }
    //metode per verificar si tots els caracters d'una paraula estan al tauler
    public boolean estaAlTauler(Paraula paraula){
        //delcaracio nombreCaractersParaula que es el bombre de caracters que te la paraula 
        //mitjançant el metode agafarNombreCaracters().
        int nombreCaractersParaula=paraula.agafarNombreCaracters();
        //arrays booleanes una de grandaria de la paraula i l'altre la del tauler
        //per verificar i no repetir fitxa.
        boolean[]VerificacioParaula=new boolean[nombreCaractersParaula];
         boolean[]VerificacioTauler=new boolean[NOMBRE_FITXES];
         //inicialitzacio a false de tot l'array
        for (int i = 0; i < nombreCaractersParaula; i++) {
            VerificacioParaula[i] = false;
        }
         //inicialitzacio a false de tot l'array
        for (int i = 0; i < NOMBRE_FITXES; i++) {
            VerificacioTauler[i] = false;
        }
        //doble bucle per fer totes les combinacions possibles.
        for (int i = 0; i < NOMBRE_FITXES; i++) {
        for (int index = 0; index < nombreCaractersParaula; index++) {
            //usant el metode caracterIndex verificam si la paraula d'aquesta és la 
            //mateixa que la de fitxes d'i ja que fara el reconeixement per totes. També s'ha
            //de cumplir que els dos arrays anteriors siguins false a la posicio ja que si es
            //true voldria dir que ja s'ha usat.
            if((paraula.caracterIndex(index)==Fitxes[i])&&(!VerificacioTauler[i])&&(!VerificacioParaula[index])){
                //true per dur a terme la verificacio i no repetir
                VerificacioParaula[index]=true;
                VerificacioTauler[i] = true;
            }
        }
    }
        //variable verificacio del tipus int per comptar el nombre de true que hi ha a l'array
        int verificacio=0;
        //recompte de true que hi ha a l'array
        for(int a=0;a<nombreCaractersParaula;a++){
            if(VerificacioParaula[a]){
                verificacio++;
            }
        }
        //retorna true si tots els components de la VerificacioParaula és true.
        return(verificacio==nombreCaractersParaula);
    }
    //metode que retorna la fitxa de la posicio i
      public char fitxaIndex(int i){
          return Fitxes[i];
      }
      //metode que retorna el nombre de fitxes
      public int nombreFitxes(){
          return NOMBRE_FITXES;
      }
}

