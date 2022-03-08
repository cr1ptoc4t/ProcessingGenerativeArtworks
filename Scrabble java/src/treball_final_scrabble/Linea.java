/*
Classe linea q serveix per enmagatzemar objectes del tipus linea,
Nom: Bernat Parera Servera
 */
package treball_final_scrabble;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Linea {
    //Atribut de classe contrant que representa el maxim caracters que se poden introduir
    private static final int MAXIM = 250;
    //Atribut de classe que representa el caracter espai
     private static final char ESPAI=' ';
    //declaració atribut de classe que representa el codi del caracter TAB
    private static final int TAB = (int) '	';
    //Atribut d'objecte que representa un array de caracters per enmagatzemar la linea.
    private char[] caracters = new char[MAXIM];
    //Atribut d'objecte que representa el nombre de caracters de la linea
    private int nombreCaracters;

    //metode constructor
    public Linea() {
        nombreCaracters = 0;
    }

    //metode que duu a terme la adicio d'un caracter
    public void adicioCaracter(int cod) {
        caracters[nombreCaracters] = (char) cod;
        nombreCaracters++;
    }

    //metode que retorna el nombre de caracters de la linea
    public int nombreCaracters() {
        return nombreCaracters;
    }

    //metode que retorna el caracter de la posicio introduida per parametre.
    public char caracterIndex(int pos) {
        return caracters[pos];
    }

    //metode que verifica si un caracter introduit per parametre es alfabetic,
    public boolean esAlfabetic(char caracter) {
        final char[] ALFABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        //si el caracter esta a alfabet, retorna true, si no esta retorna false.
        for (int indice = 0; indice < ALFABET.length; indice++) {
            if (caracter == ALFABET[indice]) {
                return true;
            }
        }
        return false;
    }
    //metode que verifica si un caracter introduit per parametre es numeric
    public boolean esNumeric(char caracter) {
        final char[] NOMBRES = "0123456789".toCharArray();
        //verificam si esta dins l'array nombres i si ho esta retornam true.
        for (int indice = 0; indice < NOMBRES.length; indice++) {
            if (caracter == NOMBRES[indice]) {
                return true;
            }
        }
        return false;
    }
    //metode que verifica si el caracter de la posicio 1 és alfabetic.
    public boolean començaPerAlfabetic() {
        return esAlfabetic(caracters[1]);
    }
    //metode que retorna el caracter de la posicio 1.
    public char primerCaracter() {
        return caracters[1];
    }
    //metode que troba el nombre de fitxes
    public int nombreFitxes() {
        //declaracio array del tipus Integer ja que permet l'ùs de null
        Integer array[] = new Integer[2];
        //declaracio varaible j per l'array
        int j = 0;
        //declaracio variable tab que permet comptar el nombre de tab que hiha.
        int tab = 0;
        //cerca els tab
        for (int i = 0; i < nombreCaracters; i++) {
            if (caracters[i] == TAB) {
                tab++;
            }
            //quan hi hagi un tab introduiex el nombre que es troben a l'array.
            if (esNumeric(caracters[i]) && tab == 1) {
                array[j] = (int) caracters[i] - (int)'0';
                j++;
            }
        }
        //variable per retornar i emmagatzemar el nombre de fitxes a repartir
        int nombreFitxes = 0;
        //si no hi ha res a la posició 1 de l'array vol dir que el nombre es d'un digit
        //i assignam nombre fitxes l'array de posició 0.
        if (array[1] == null) {
            nombreFitxes = array[0];
            //en canvi si hi ha un digit a la posició 1 vol dir que el nombre està format
            //per dos digits ido hem de multiplicar el de la posició 0 per 10 ja que es 
            //tracten de decenes i sumar-li el de la posicio 1 sense multiplicar per cap nombre
        } else {
            nombreFitxes = array[0] * 10;
            nombreFitxes += array[1];
        }
        return nombreFitxes;
    }
    //metode que troba la puntuacio
    public int trobarPuntuacio() {
        //declaracio array del tipus Integer ja que permet l'ùs de null
        Integer array[] = new Integer[2];
        //declaracio varaible j per l'array
        int j = 0;
        //declaracio variable tab que permet comptar el nombre de tab que hiha.
        int tab = 0;
        //cerca els tab
        for (int i = 0; i < nombreCaracters; i++) {
            if (caracters[i] == TAB) {
                tab++;
            }
            //quan hi hagi dos tab introduiex el nombre que es troben a l'array.
            if (esNumeric(caracters[i]) && tab == 2) {
                array[j] = (int) caracters[i] - 48;
                j++;
            }
        }
        //variable per retornar i emmagatzemar el la puntuacio
        int punts = 0;
        //si no hi ha res a la posició 1 de l'array vol dir que el nombre es d'un digit
        //i assignam nombre fitxes l'array de posició 0.
        if (array[1] == null) {
            punts = array[0];
            
        } 
        //en canvi si hi ha un digit a la posició 1 vol dir que el nombre està format
        //per dos digits ido hem de multiplicar el de la posició 0 per 10 ja que es 
        //tracten de decenes i sumar-li el de la posicio 1 sense multiplicar per cap nombre
        else {
            punts = array[0] * 10;
            punts += array[1];
        }
        //retorn de punts
        return punts;
    }
    //metode que escriu una linia per escriure a l'historial
    public void historial(int puntuacio, Paraula paraula) throws Exception{
        //ús de la clase DateTimeFormatter i els seus metodes per trobar la fetxa i la 
        //hora a la que es juga.
      DateTimeFormatter datos3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
      //declaracio d'array de caracters per fer el tractament i assignament de
      //l'string que representa la fetxa i la hora en forma d'array
      char [] fechaHora = datos3.format(LocalDateTime.now()).toCharArray();
      //declaracio d'array de caracters per fer el tractament i assignament de
      //de la puntuacio.
      char [] charArrayPuntuacio = intToCharArray(puntuacio);
      //no fa falta array de caracters de la paraula ja uqe tenim el metode caracterIndex()
      //bucle de tractament de la linea
        for (int i = 0; i < fechaHora.length; i++) {
            //assignament de fecha hora al principi de la linea
            caracters[i]=fechaHora[i];
            nombreCaracters++;
        }
        //bucle de tractament desde la posicio del darrer caracter escrit de fechaHora
        //fins el final de charArrayPuntuacio + 1, ja que entre fechaHora i charArrayPuntuacio 
        //hi ha d'haver un espai en blanc, que assignarem al final programa.
        for (int i = fechaHora.length+1; i < (fechaHora.length+charArrayPuntuacio.length+1); i++) {
            //assignament de la puntuacio, l'index de charArrayPuntuacio es aquest 
            //i menys la inicialitzacio de la variable i, aixi conseguim que conti desde 0. 
            caracters[i]=charArrayPuntuacio[i-(fechaHora.length+1)];
            nombreCaracters++;
        }
         //bucle de tractament desde la posicio del darrer caracter escrit de charArrayPuntuacio
        //fins el final de la paraula+ 2, ja que entre  charArrayPuntuacio i paraula
        //hi ha d'haver un espai en blanc i amb el +1 de l'anterior for s'acumulen i fan +2.
        for (int i = (fechaHora.length+charArrayPuntuacio.length+2); i < (fechaHora.length+charArrayPuntuacio.length+paraula.agafarNombreCaracters()+4); i++) {
            //assignament de la paraula a la linea usant el metode caracterIndex(), 
            //a aquest hem de tenir en compte que comença per 0, aixi que li restam la inicialitzacio de la variable i
            //i aixi tenim els nombres que ens interessa per el metode caracterIndex().
            caracters[i]=paraula.caracterIndex(i-(fechaHora.length+charArrayPuntuacio.length+2));
            nombreCaracters++;
        }
        //assignacio del caracter ESPAI a les posicions entre canvis de FOR.
        //a aquests assignarem la posicio en la que acaben el for anterior ja que 
        //amb el +1 i el +2 el que hem fet es evitar que s'escrigui res
        //a aquelles posicions.
      caracters[fechaHora.length]= ESPAI;
      caracters[fechaHora.length+charArrayPuntuacio.length+1]= ESPAI;
    }
    //metode creat unicament per l'ús a historial()
    private char[] intToCharArray(int nombre)throws Exception{
        
        //primer hem de trobar el nombre de dígits dels que esta format el nombre
        //declaracio variable lomgitud per contar el nombre de digits que té el nombre.
        int longitud=0;
        //declaracio de variable nombre2 i assignament del valor de la variable nombre
        //per poder manipularlo sense afectar al funcionament.
        int nombre2= nombre;
        //bucle que es realitza mentre el nombre és major que 0, aquest dividirà cada pic 
        //el nombre2 entre 10 i sumarà 1 a longitud perque es guardi a longitud el nombre 
        //de caracters que té nombre i nombre2.
        while(nombre2>0){
            longitud++;
            nombre2 /= 10;
        }
        //creacio de array de nombres de longitud longitud trobada anteriorment.char [] arrayNombres = new char[longitud];
        char [] arrayNombres = new char[longitud];
        if(nombre>0){
        //declaracio variable i per al bucle
        int i = 0;
        //bucle per assignar al array de caracters cada un dels digits de nombre
        for (int j = longitud; j > 0; j--) {
            //delcaracio de la variable digit a la qual s'asigna el valor de la resta de nombre/10
            int digit = nombre%10;
            //divisio entre 10 del nombre per poder seguir amb el tractament
            nombre /=10;
            //introduccio de el valor de digit a la posicio corresponent al char array
            //sumant-li el valor del 0 per aixi conseguir el caracter correcte.
            arrayNombres[j-1]= (char)(digit+(int)'0');
        }
    }
        //else amb el retorn que indica que la puntuacio ha estat negativa.
        else{
           char[] respostaNegativa = "La puntuació ha estat negativa.".toCharArray();
           return respostaNegativa;
        }
        //al cas que nombre>0 retornara arrayNombres.
        return arrayNombres;
}
    //metode que mostra per pantalla la linia.
    public void mostraLinea(){
        for (int i = 0; i < nombreCaracters; i++) {
            System.out.print(caracters[i]);
        }
    }
}
