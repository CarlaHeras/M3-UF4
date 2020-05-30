package project;

        import java.io.IOException;
        import java.util.Scanner;

public class M3_UF3_ActAvaluable {

    public static void main(String[] args) throws IOException {
        M3_UF3_ActAvaluable solucio = new M3_UF3_ActAvaluable();
        solucio.inici();
    }

    /**
     * Programa principal cridat des del main de la classe. Mostra el menú
     * per pantalla i segons la opció triada executa una o altre instrucció fins
     * que aquesta opció sigui la de sortir.
     */
    public void inici() throws IOException {

        Scanner sc = new Scanner(System.in);
        DadesAPI dades = new DadesAPI();
        GestorDades.carregarDades(dades);
        String usuari;
        Interficie.mostrarMissatge("Inserta el teu nom:");
        usuari = sc.nextLine();
        GestorDades.guardarUsuari(usuari);
        int eleccio = -1;       //Variable per guardar l'opció del menú secundari elegida per l'usuari.
        int eleccio2 = -1;      //Variable per guardar l'opció del menú secundari elegida per l'usuari.
        int id_consulta = 0;    //Variable per identificar les consultes en el moment d'afegir elements.
        int haconsultat = 0;    //Variable per guardar si s'ha fet consulta.
        String afegirelement;   //Variable per preguntar si es vol afegir element, serà Y o N
        String nomelement;      //Variable on guardarem l'element que es vulgui afegir.
        String volsordenar;     //Variable per preguntar si es vol ordenar, serà Y o N
        while (eleccio != 0) {
            Interficie.mostrarMenu(Interficie.opcmenu);
            eleccio = sc.nextInt();
            switch (eleccio) {
                case 1:         //Entrem al menú secundari
                    haconsultat++;
                    while (eleccio2 != 0) {
                        Interficie.mostrarMenu(Interficie.opcmenu2); //Mostrem el menú secundari i demanem l'opció.
                        eleccio2 = sc.nextInt();
                        switch (eleccio2) {
                            case 1://Mostrem les dades i afegim un element si l'usuari ho desitja.
                                Interficie.mostrarDades(GestorDades.personatges);
                                Interficie.mostrarMissatge("Vols afegir un element? Y/N:");
                                sc.nextLine();
                                afegirelement = sc.nextLine();
                                id_consulta = 1;
                                if (afegirelement.equals("Y") || afegirelement.equals("y")) {
                                    Interficie.mostrarMissatge("Escriu l'element que vulguis afegir:");
                                    nomelement = sc.nextLine();
                                    GestorDades.afegirElement(dades, id_consulta, nomelement);
                                } else {
                                }
                                break;
                            case 2:
                                Interficie.mostrarDades(GestorDades.estudiants);
                                Interficie.mostrarMissatge("Vols afegir un element? Y/N:");
                                sc.nextLine();
                                afegirelement = sc.nextLine();
                                id_consulta = 2;
                                if (afegirelement.equals("Y") || afegirelement.equals("y")) {
                                    Interficie.mostrarMissatge("Escriu l'element que vulguis afegir:");
                                    nomelement = sc.nextLine();
                                    GestorDades.afegirElement(dades, id_consulta, nomelement);
                                } else {
                                }
                                break;
                            case 3:
                                Interficie.mostrarDades(GestorDades.professors);
                                Interficie.mostrarMissatge("Vols afegir un element? Y/N:");
                                sc.nextLine();
                                afegirelement = sc.nextLine();
                                id_consulta = 3;
                                if (afegirelement.equals("Y") || afegirelement.equals("y")) {
                                    Interficie.mostrarMissatge("Escriu l'element que vulguis afegir:");
                                    nomelement = sc.nextLine();
                                    GestorDades.afegirElement(dades, id_consulta, nomelement);
                                } else {
                                }
                                break;
                            case 0:
                                break;
                            default:
                                Interficie.mostrarMissatge("Inserta un número que correspongui a alguna opció:");
                                break;
                        }

                    }
                    eleccio2 = -1; //Hem d'asginar-li -1 a l'opció del submenú perquè al sortir d'ell es queda en 0 llavors si tornem a entrar dona problemes
                case 2: //Demanem un nom per al fitxer, preguntem si es vol ordenar les dades i el creem i escribim o sobreescribim si ja està creat.
                    if (eleccio == 2) {
                        if (haconsultat != 0) {
                            Interficie.mostrarMissatge("Inserta nom del fitxer:");
                            String nomfitxer;
                            sc.nextLine();
                            nomfitxer = sc.nextLine();
                            Interficie.mostrarMissatge("Vols ordenar els elements? Y/N");
                            volsordenar = sc.nextLine();
                            if (volsordenar.equals("Y") || volsordenar.equals("y")) {
                                GestorDades.ordenarElements(dades);
                            } else {
                            }
                            switch (id_consulta) {
                                case 1:
                                    GestorDades.desarDades(GestorDades.personatges, nomfitxer);
                                    break;
                                case 2:
                                    GestorDades.desarDades(GestorDades.estudiants, nomfitxer);
                                    break;
                                case 3:
                                    GestorDades.desarDades(GestorDades.professors, nomfitxer);
                                    break;
                            }
                        } else {
                            Interficie.mostrarMissatge("Has de fer una consulta per poder guardar!");
                        }

                    }
                    break;
                case 3:
                    Interficie.mostrarUsuaris();
                case 0:
                    break;
                default:
                    Interficie.mostrarMissatge("Inserta un número que correspongui a alguna opció:");
            }

        }
        Interficie.mostrarMissatge("Bye");
    }
}
