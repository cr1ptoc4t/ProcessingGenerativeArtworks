/*
Scrabble
Nom: Bernat Parera Servera
 */
package treball_final_scrabble;

import java.util.Random;

public class Scrabble {

    //declaració metode main
    public static void main(String[] args) throws Exception {

        new Scrabble().metodePrincipal();
    }
    //declaracio variable eleccio per el menu
    private int eleccio;

    //Declaració metodePrincipal
    private void metodePrincipal() throws Exception {
        System.out.println("Benvingut al joc Scrabble.");
        while (eleccio != 4) {
            //MENÚ PER TRIAR I ASSIGNACIÓ 
            menu();
            //Creació switch per 
            switch (eleccio) {
                //Executa la partida
                case 1:
                    partidaHumana();
                    break;
                //mostra el ficher registra
                case 2:
                    visualitzaHistorial();
                    break;
                //acaba el joc
                case 3:
                    menuSimulador();
                    break;
                //entra al mode simulador on es troba el mode simulador i el mode cervell superior.
                case 4:
                    System.out.println("Gràcies per jugar al Scrabble");
                    break;
                default:
                    System.out.println("Ha introduit un nombre que no es troba al menu");
            }
        }
    }

    //Creació metode menu que retorna l'leccio
    private int menu() {
        //Declaració variable eleccio per tirar la opció
        //Donar la benvinguda al joc i donar les opcions
        System.out.println("Seleccioni que vol fer:\n"
                + "#1.Jugar una partida standard.\n"
                + "#2. Llistar el contingut del fitxer històric de partides.\n"
                + "#3. Entrar al mode simulador\n"
                + "#4. Sortir del joc.");
        eleccio = LT.readInt();
        return eleccio;
    }

    private void partidaHumana() throws Exception {
        //variable eleccioLlengua per elegir en quina llengua volem jugar
        int eleccioLlengua = 0;
        //variable puntuacio per contar la puntuacio que aconseguim
        int puntuacio = 0;
        //variable nombre torns per contar el nombre de torns que jugarà l'humà.
        int nombreTorns;
        //variable indexTorns per escriure per pantalla per quin torn va el joc.
        int indexTorns = 1;
        //declaracio d'una Paraula per el nom d'usuari
        Paraula nomUsuari = new Paraula();
        //demanar nom d'usuari
        System.out.println("Introduesqui el seu nom d'usuari:");
        //declaracio taulerFitxe, aquest és el tauler que tindrà cada torn el jugador
        //o el simulador
        TaulerFitxes taulerFitxes = new TaulerFitxes();
        //declaracio barallaFitxes per a la construccio del tauler de fitxes
        BarallaFitxes baralla = new BarallaFitxes();
        //metode de barallaFitxes per generar la baralla de fitxes.
        baralla.generarBarallaFitxes();
        while (Paraula.hihaParaules()) //lectura nom usuari
        {
            nomUsuari.llegir();
        }
        //demanar a l'usuari el nombre de torns que vol jugar l'usuari
        System.out.print("Quants de torns vols jugar? ");
        //lectura del nombre de torns
        nombreTorns = LT.readInt();
        //demanar a l'usuari en quina llengua vol jugar.
        System.out.println("En quina llengua vols jugar?\n "
                + "#1. Català.\n"
                + " #2. Castellà");
        //lectura d'eleccioLlengua
        eleccioLlengua = LT.readInt();
        //declaracio paraulaIntroduida del tipus Paraula perque l'usuari escrigui la paraula
        //la qual serà puntuada posteriorment
        Paraula paraulaIntroduida = new Paraula();
        //bucle que acaba quan els torns son zero, auqest bucle es podria dir que és
        //la partida ja que és on es desenvolupa la mateixa
        while (nombreTorns > 0) {
            //assignament de les fitxes, cada pic que comenci el while s'assignaràn 
            //un altre pic
            taulerFitxes.assignacióFitxes();
            //mostrar per pantalla el tauler del torn nombre indexTorns
            System.out.println("Aquest es el teu tauler per el torn nombre " + indexTorns);
            //metode per mostrar per pantalla el taulerFitxes
            taulerFitxes.mostraFitxes();
            //demanar per pantalla a escriure la paraula.
            System.out.println("Escriu la teva paraula:");
            while (Paraula.hihaParaules()) //lectura paraulaIntroduida
            {
                paraulaIntroduida.llegir();
            }
            //declaracio variable del tipus booleana inicialitzada a 0 per indicar si 
            //paraulaIntroduida està al diccionari
            boolean estaAlDiccionari = false;
            //declaracio per a la lectura del diccioanri
            ParaulaFitxerLectura diccionari;
            //si l'usuari eligeix l'opcio català entrarà aqui.
            if (eleccioLlengua == 1) {
                //inicialitzacio de diccionari com el fitxer diccionari.txt que correspon
                //al diccionari català
                diccionari = new ParaulaFitxerLectura("diccionari.txt");
                //bucle que entra si al diccionari hiha paraules i si estaAlDiccionari
                //es false, aixi ens asseguram de que el programa atura quan troba la 
                //paraula perquè no estigui tant de temps lleguint el diccionari tot
                // i que es podria llevar la segona part del booleà però si es
                //fes el programa tardaria molt en donar la puntuacio
                while ((diccionari.hihaParaules()) && (!estaAlDiccionari)) {
                    //lectura del diccionari i assignament a la Paraula paraulaDiccionari
                    Paraula paraulaDiccionari = diccionari.lectura();
                    //ús del metode iguals que es troba a la classe paraula que verifica
                    //si dues paraules son iguals, en el cas verifica si paraulaIntroduida, que
                    //es la que l'usuari ha escrit i la paraulaDiccionari son iguals.
                    if (Paraula.iguals(paraulaIntroduida, paraulaDiccionari)) {
                        //si son iguals estaAlDiccionari passa a ser true i ja no entra més al bucle
                        //per l'explicat als comentaris anteriors.
                        estaAlDiccionari = true;
                    }
                }
                diccionari.tancarEnllaçFitxer();
            }
            //si l'usuari eligeix l'opcio castellà entrarà aqui.
            if (eleccioLlengua == 2) {
                //inicialitzacio de diccionari com el fitxer diccionario.txt que correspon
                //al diccionari castellà
                diccionari = new ParaulaFitxerLectura("diccionario.txt");
                //bucle que entra si al diccionari hiha paraules i si estaAlDiccionari
                //es false, aixi ens asseguram de que el programa atura quan troba la 
                //paraula perquè no estigui tant de temps lleguint el diccionari tot
                // i que es podria llevar la segona part del booleà però si es
                //fes el programa tardaria molt en donar la puntuacio
                while ((diccionari.hihaParaules()) && (!estaAlDiccionari)) {
                    //lectura del diccionari i assignament a la Paraula paraulaDiccionari
                    Paraula paraulaDiccionari = diccionari.lectura();
                    //ús del metode iguals que es troba a la classe paraula que verifica
                    //si dues paraules son iguals, en el cas verifica si paraulaIntroduida, que
                    //es la que l'usuari ha escrit i la paraulaDiccionari son iguals.
                    if (Paraula.iguals(paraulaIntroduida, paraulaDiccionari)) {
                        //si son iguals estaAlDiccionari passa a ser true i ja no entra més al bucle
                        //per l'explicat als comentaris anteriors.
                        estaAlDiccionari = true;
                    }
                }
                //tancament de l'enllaç del fitxer per aixi evitar qualsevol problema.
                diccionari.tancarEnllaçFitxer();
            }
            //ús del metode estaAlTauler de la classe taulerFitxes per verificar que tots
            //els caracters de paraulaIntroduida estan al diccionari i si està al diccionari
            //troba la puntuació que ha aconseguit l'usuari.
            if ((taulerFitxes.estaAlTauler(paraulaIntroduida)) && (estaAlDiccionari)) {
                puntuacio = trobarPuntuacioParaula(paraulaIntroduida, puntuacio);
            } 
            //si els caracters de la paraula introduida per l'usuari no estan al tauler o
            //no esta al diccionari entra aqui dins.
            else {
                //si els caracters de la paraula introduida per l'usuari no estan al tauler i
                //si que esta al diccionari vol dir que al menys una lletra no esta al tauler
                if (!taulerFitxes.estaAlTauler(paraulaIntroduida) && estaAlDiccionari) {
                    System.out.println("hi ha lletres a la teva paraula que no estan al tauler.");
                }
                //si els caracters de la paraula introduida per l'usuari si estan al tauler i
                //si que estan al tauler vol dir que la paraula no esta al diccionari.
                if (!estaAlDiccionari && taulerFitxes.estaAlTauler(paraulaIntroduida)) {
                    System.out.println("Aquesta paraula no esta al diccionari.");
                }
                //aquesta es la negacio de if ((taulerFitxes.estaAlTauler(paraulaIntroduida)) && (estaAlDiccionari))
                //però aplicant la llei de la logica de De Morgan, si es cumpleix aquest booleà
                //vol dir que no s'ha complit cap de les dues. He usar la llei de De Morgan per 
                //simplificar el booleà.
                if (!((taulerFitxes.estaAlTauler(paraulaIntroduida)) || (estaAlDiccionari))) {
                    System.out.println("Aquesta paraula no esta ni al diccionari ni al teu tauler, quin desastre!!");
                }
                //resta 10 a puntuacio ja que la paraula no compleix els requisits.
                puntuacio -= 10;
            }
            //resta 1 nombreTorns
            nombreTorns--;
            //suma 1 indexTrons
            indexTorns++;
        }
        //mostrar per pantalla la puntuacio aconseguida
        System.out.println("Has acosneguit " + puntuacio + " punts");
        //declaracio linea de la clase Linea
        Linea linea = new Linea();
        //metode de la classe linea que crea la linea per escriure a l'historial.
        linea.historial(puntuacio, nomUsuari);
        //declaracio de historial per escriure al fitxer historial.txt amb el constructor
        //de la classe LineaFitxersEscritura que permet guardar el que ja havia escrit
        //al fitxer
        LineaFitxersEscritura historial = new LineaFitxersEscritura("historial.txt", true);
        //escritura a historial de la linea
        historial.escritura(linea);
        //escritura del salt de linea
        historial.escrituraBotDeLinea();
        //tancament de l'historial
        historial.tanca();
    }

    private void visualitzaHistorial() throws Exception {
        //metode de la classe linea que crea la linea per visualitzar l'historial.
        Linea linea = new Linea();
        //lectura d'historial
        LineaFitxersLectura historial = new LineaFitxersLectura("historial.txt");
        while (historial.hihaLinies()) {
            linea = historial.lectura();
            //mostra linia historial
            linea.mostraLinea();
        }
        //escritua bot de linia
        System.out.println();
        //tancament d'historial
        historial.tancament();
    }

    private void menuSimulador() throws Exception {
        //declaracio variable eleccio per el menu de simulador
        int eleccio;
        //declaracio variable nombreParaules per saber quantes paraules generarà el simulador
        int nombreParaules;
        System.out.println("Com vols que el simulador trobi les paraules, quant més fàcil sigui per el simulador més possibilitats de obtenir punts tendrà.\n"
                + "#1. Facil\n"
                + "#2. Normal\n"
                + "#3. Dificil\n"
                + "#4. modeCervellSuperior");
        eleccio = LT.readInt();
        switch (eleccio) {
            //el simulador creará 50 paraules per evaluar-les al diccionari
            case 1:
                nombreParaules = 100;
                modeSimuladorSenzill(nombreParaules);
                break;
            //el simulador creará 100 paraules per evaluar-les al diccionari
            case 2:
                nombreParaules = 50;
                modeSimuladorSenzill(nombreParaules);
                break;
            //el simulador creará 100 paraules per evaluar-les al diccionari
            case 3:
                nombreParaules = 20;
                modeSimuladorSenzill(nombreParaules);
                break;

            //entra al metode modeCervellSuperior que es fa apart ja que 
            case 4:
                modeCervellSuperior();
                break;
            default:
                System.out.println("Ha introduit un nombre que no es troba al menu");
        }

    }
//aquest mode creará paraules aleatòries i triará la que tengui més puntuació

    private void modeSimuladorSenzill(int nombreParaules) throws Exception {
        //declaracio paraula per guardar la paraula de més puntuacio.
        Paraula paraulaDeMesPuntuacio = new Paraula();
        //declaracio i generacio baralla de la classe BarallaFitxes
        BarallaFitxes baralla = new BarallaFitxes();
        baralla.generarBarallaFitxes();
        //declaracio variable puntuacio del tipus entera per contar la puntuacio que fa el simulador
        int puntuacio = 0;
        //declaracio variable taulerFitxes de la classe TaulerFitxes
        TaulerFitxes taulerFitxes = new TaulerFitxes();
        //assignació d'un tauler al simulador
        taulerFitxes.assignacióFitxes();
        //declaracio variable de la classe Random per generar nombress
        Random aleatori = new Random();
        //delcaracio nombre enter per assignar-li el valor aleatori
        int nombre;
        //declaracio array booleana per verificar si s'ha usat ja aquella fitxa del tauler 
        //de mida de la tauler.
        boolean[] verificacioTauler = new boolean[taulerFitxes.nombreFitxes()];
        //delcaracio nombreAleatori enter per assignar-li el valor aleatori
        int nombreAleatori;
        for (int i = 0; i < nombreParaules; i++) {
            //bucle per inicialitzar totes les posicions a false
            for (int k = 0; k < verificacioTauler.length; k++) {
                verificacioTauler[k] = false;
            }
            //assignació d'un valor entre [1,11] per saber la grandària de la paraula que crearà
            //ho faig d'aquesta manera ja que aleatori.nextInt(11) crea un nombre aleatori a l'interval
            //[0,10], que realment és l'interval [1,11] per la paraula
            nombre = aleatori.nextInt(11);
            //declaracio variable index per el bucle while
            int index = 0;
            //declaracio de variable paraula de la classe Paraula 
            Paraula paraula = new Paraula();
            //bucle per crear la paraula aleatoria, si index no es menor que nombre
            //pero si es igual a 0 també ha d'entrar ja que estariem xerrant 
            //d'una paraula d'un caracter de longitud (posició 0)
            while ((index < nombre) || (index == 0)) {
                //assignament a nombreAleatori d'un nombre aleatori en el rang[0,nombre]
                nombreAleatori = aleatori.nextInt(verificacioTauler.length);
                //si la fitxa no ha estat usada, entra al programa.
                if (!verificacioTauler[nombreAleatori]) {
                    //assignacio true a la posicio per marcar que ja ha estat usada
                    verificacioTauler[nombreAleatori] = true;
                    //insertar la lletra de la fitxa assignada aleatoriament
                    paraula.adicioCaracter(taulerFitxes.fitxaIndex(index));
                    //sumar 1 a index
                    index++;
                }
            }
            //varaible booleana per saber si la paraula esta al diccionari
            boolean estaAlDiccionari = false;
            //lectura del fitxer diccionari.txt, aquest cambiara a true la variable
            //esta al diccionari si paraula i paraulaDiccionari son iguals
            ParaulaFitxerLectura diccionari;
            diccionari = new ParaulaFitxerLectura("diccionari.txt");
            while ((diccionari.hihaParaules()) && (!estaAlDiccionari)) {
                Paraula paraulaDiccionari = diccionari.lectura();
                if (Paraula.iguals(paraula, paraulaDiccionari)) {
                    estaAlDiccionari = true;
                }
            }
            //declaracio variable puntuacioParaula per evaluar la puntuacio de cada paraula individualment
            int puntuacioParaula = 0;
            if (estaAlDiccionari) {
                //assignament a la variable puntuacioParaula el metode tronarPuntuacioParaula
                puntuacioParaula = trobarPuntuacioParaula(paraula, puntuacioParaula);
            }
            //si la puntuacioParaula>puntuacio, puntuacio ha de ser puntuacioParaula 
            //ja que aquesta paraula seria la paraula amb més puntuació
            if (puntuacioParaula > puntuacio) {
                puntuacio = puntuacioParaula;
                paraulaDeMesPuntuacio = paraula;
            }
            diccionari.tancarEnllaçFitxer();
        }
        System.out.println("La puntuacio que ha aconseguit el simulador és de " + puntuacio + " punts.");
        System.out.print("la paraula que ha trobat el simulador és: ");
        paraulaDeMesPuntuacio.mostraParaula();
        System.out.println("El tauler que ha usat és: ");
        taulerFitxes.mostraFitxes();
    }
//aquest mode el que fará és trobar la paraula amb més puntuacio que pugui aconseguir amb el tauler que té

    private void modeCervellSuperior() throws Exception {
        //delcaracio variable puntuacio per indicar quina puntuacio té cada paraula
        int puntuacio = 0;
        //declaracio variavle puntuacioTotal per indicar la puntuacio que ha tret el simulador
        int puntuacioTotal = 0;
        //declaracio variable taulerFitxes de la classe TaulerFitxes
        TaulerFitxes taulerFitxes = new TaulerFitxes();
        //assignació d'un tauler al simulador
        taulerFitxes.assignacióFitxes();
        //declaracio paraula per indicar quina és la paraula de més puntuacio
        Paraula paraulaMesPuntuacio = new Paraula();
        ParaulaFitxerLectura diccionari;
        diccionari = new ParaulaFitxerLectura("diccionari.txt");
        while (diccionari.hihaParaules()) {
            //inicialitzacio a 0 per que no es sumin les puntuacioms anteriors
            puntuacio = 0;
            Paraula paraulaDiccionari = diccionari.lectura();
            puntuacio = trobarPuntuacioParaula(paraulaDiccionari, puntuacio);
            if ((taulerFitxes.estaAlTauler(paraulaDiccionari)) && (puntuacio > puntuacioTotal)) {
                paraulaMesPuntuacio = paraulaDiccionari;
                puntuacioTotal = puntuacio;
            }
        }
        System.out.println("La puntuacio que ha aconseguit el simulador és de " + puntuacioTotal + " punts.");
        System.out.print("la paraula que ha trobat el simulador és: ");
        paraulaMesPuntuacio.mostraParaula();
        System.out.println("amb aquest tauler: ");
        taulerFitxes.mostraFitxes();
        diccionari.tancarEnllaçFitxer();
    }

    public int trobarPuntuacioParaula(Paraula paraula, int puntuacio) throws Exception {
        //declaracio baralla de la classe BarallaFitxes
        BarallaFitxes baralla = new BarallaFitxes();
        //generar baralla fitxes
        baralla.generarBarallaFitxes();
          //bucle que fa el recompte de punts.
                for (int i = 0; i < paraula.agafarNombreCaracters(); i++) {
                    //delcaracio variable char per realitzar la comprobacio individualment
                    //dels caracters de paraulaIntroduida i assignament mitjançant el metode 
                    //caracterIndex() del caracter de l'index del for 'i'.
                    char a = paraula.caracterIndex(i);
                    //declaracio variable int i assignament de la posicio en la que 
                    //es troba a la baralla per després trobar la puntuacio d'aquest caracter
                    //per a usar al metode puntuacioPosicioIndex de la classe PuntuacioFitxes
                    int posicio = baralla.cercarPosicioBaralla(a);
                    //declaracio taulaDePuntuacio de cla classe puntuacioFitxes per 
                    //el recompte de puntuacio.
                    PuntuacioFitxes taulaDePuntuacio = new PuntuacioFitxes();
                    //generacio de la taulaDePuntuacio.
                    taulaDePuntuacio.generarPuntuacioFitxes();
                    //declacio de la variable suma per sumar-li el seu valor a puntuacio 
                    //i assignament de la puntuacio del caracter a ja que abans hem cercat
                    //la seva posicio amb el metode cercarPosicioBaralla() de la classe
                    //barallaFitxes.
                    int suma = taulaDePuntuacio.puntuacioPosicioIndex(posicio);
                    //suma a puntuacio la variable suma
                    puntuacio += suma;
                }
        return puntuacio;
    }
}
