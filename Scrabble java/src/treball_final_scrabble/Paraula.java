/*
Aquesta clase la emplearem per demanar paraules a l'usuari, paraules com el nom d'usuari.
Nom: Bernat Parera Servera
  */
package treball_final_scrabble;
public class Paraula {
    //declaracio dels atributs de classe que descriuen l'estat dels objectes paraula
    //declaracio del nombre màxim de caracters per posar una limitacio
     private static final int MAXIM_NOMBRE_CARACTERS=20;
    //declaracio d'atribut de classe que representa la final d'una sequencia de caracters
     private static final char FINAL_SEQUENCIA='.';
     //declaracio d'atribut de classe que representa el caracter espai
     private static final char ESPAI=' ';
     //declaracio d'atribut de classe que rep
     private static final char BOT_LINEA='\n';
     //declaracio d'atribut de classe qye reoresenta el caracter llegit desde una sequencia de caracters
     private static char caracter=ESPAI;
     //declaracio d'atribut d'objecte del tipus array per enmagatzemar els caracters introduits
     private char [] caracters=new char[MAXIM_NOMBRE_CARACTERS];
     //declaracio d'atribut d'objecte per representar el nombre de caracters que te una paraula
     private int nombreCaracters;
     
     //Metodes
     
     //metode constructor
     public Paraula(){
         //inicialitzacio de nombre de caracters a 0
         nombreCaracters=0;
     }
     private static void cercarParaula() {
        while (caracter==ESPAI) {
            caracter=LT.readChar();
        }
     }
     //metode que verifica si hi ha paraules amb cercarParaula
     public static boolean hihaParaules() {
        cercarParaula();
        if ((caracter!=FINAL_SEQUENCIA)&&(caracter!=BOT_LINEA)) {
            return true;
        }
        else {
            //buidar buffer de entrada
            if (caracter==FINAL_SEQUENCIA) LT.skipLine();
            //inicialitzar caracter amb espai
            caracter=ESPAI;
            //tornar false com a resutlat
            return false;
        } 
    }
     //metode que duu a terme la lectura per teclat juntament amb hihaParaules
     public void llegir() {
        //inicialitzacio a 0 de nombreCaracters
        nombreCaracters=0;
        //bucle de lectura i emmagatzament dels caracters
        while ((caracter!=FINAL_SEQUENCIA)&&(caracter!=ESPAI)&&(caracter!=BOT_LINEA)) {
            //caracters de la posicio nombre caracters es el caracter llegit per LT.readChar
            caracters[nombreCaracters]=caracter;
            //incremneto del atributo numeroCaracteres
            nombreCaracters++;
            //lectura siguiente caracter de la secuencia 
            caracter=LT.readChar();
        }
}
         //aquest metode insterta el caracter  a la primera posicio lliure de la paraula.
         //la paraula.
     public void adicioCaracter(char lletra) {
        caracters[nombreCaracters]=lletra;
        nombreCaracters++;
    }    
     public char caracterIndex(int index){
         return (caracters[index]);
     }
     public int agafarNombreCaracters(){
         return nombreCaracters;
     }
         public static boolean iguals(Paraula paraula1, Paraula paraula2) {
        if (paraula1.nombreCaracters==paraula2.nombreCaracters) {
            //verificacio de si son iguals a nivell de caracters
            for (int index=0;index<paraula1.nombreCaracters;index++) {
                //verifciacio de si son iguals a nivell de index
                //de l'atribut caracters
                if (paraula1.caracters[index]!=paraula2.caracters[index]) {
                    //devolucio de false perque son diferents
                    return false;
                }
            }
            //devolucio true perque son iguals
            return true;
        }
        else {
            //decolucio false perque no tenen el mateix nombre de caracters ido no son iguals
            return false;
        }
    }
         //metrode que mostra la paraula per pantalla
         public void mostraParaula(){
             for (int i = 0; i < nombreCaracters; i++) {
                 System.out.print(caracters[i]);
             }
             System.out.println("\n");
         }
}

