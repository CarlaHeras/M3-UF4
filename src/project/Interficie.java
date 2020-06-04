package project;

        import java.util.ArrayList;
        import java.util.Scanner;

public class Interficie {

    static Scanner sc = new Scanner(System.in);

    static String[] opcmenu = {"----------------------------------------------------------------------------------------------------", "MENÚ PRINCIPAL", "1-Carregar dades", "2-Consultar dades", "3-Afegir dades", "4-Esborrar dades", "0-Sortir", "----------------------------------------------------------------------------------------------------", "Elegeix una opció:"};
    static String[] opcmenu2 = {"----------------------------------------------------------------------------------------------------", "1-Veure tots els personatges de la saga", "2-Veure estudiants de Hogwarts", "3-Veure Staff de Hogwarts", "0-Tornar", "----------------------------------------------------------------------------------------------------", "Elegeix consulta:"};

    /**
     * Mostra informació que hagis recuperat de la teva API
     *
     * @param dades Array d'string amb informació
     */
    //Passem per paràmetre l'array de la consulta que sigui, i la printem.
    public static void mostrarDades(ArrayList dades) {
         System.out.println(dades.toString());
    }

    /**
     * Funció que mostra per pantalla les diferents opcions que formen el menú
     * que es rep com a paràmetre. La primera posició de l'array menú és el
     * títol del mateix mentre que la resta són les opcions. Aquesta variable
     * ja ve inicialitzada des del codi que en fa la crida.
     *
     * @param menu Conté les diferents opcions que es mostraran per pantalla a
     *             l'usuari.
     */
    //Printem el menú que rebem per paràmetre
    public static void mostrarMenu(String[] menu) {

        for (int i = 0; i < menu.length; i++) {

            System.out.println(menu[i]);

        }

    }

    /**
     * Funció que encapsula un simple volcat d'informació per pantalla
     *
     * @param missatge Missatge a mostrar per pantalla
     */
    public static void mostrarMissatge(String missatge) { //Printem el missatge que rebem per paràmetre
        System.out.println(missatge);
    }

    //AFEGIR ELS ATRIBUTS DEL NOU PERSONATGE
    public static void preguntarAtributs(String x, GestorDades gestor ) {
        System.out.println("Quin es el nom?");
        String nom = sc.nextLine();
        System.out.println("Quin es la seva especie?");
        String especie = sc.next();
        System.out.println("Quin es la seva casa?");
        String casa = sc.next();
        System.out.println("Quin es el seu patronus?");
        String patronus = sc.next();
        System.out.println("Qui l'interpreta?");
        sc.nextLine();
        String actor = sc.nextLine();
        System.out.println("Creat!");

        if (x == "est") {
            gestor.getDades().afegirEstudiant(nom, especie, casa, patronus, actor);
        } else {
            gestor.getDades().afegirProfessor(nom, especie, casa, patronus, actor);
        }
    }
}