package project;

        import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;

public class Interficie {

    static String[] opcmenu = {"----------------------------------------------------------------------------------------------------", "MENÚ PRINCIPAL", "1-Consultar dades", "2-Guardar dades", "3-Informació d'usuaris", "0-Sortir", "----------------------------------------------------------------------------------------------------", "Elegeix una opció:"};
    static String[] opcmenu2 = {"----------------------------------------------------------------------------------------------------", "1-Veure tots els personatges de la saga", "2-Veure estudiants de Hogwarts", "3-Veure Staff de Hogwarts", "0-Tornar", "----------------------------------------------------------------------------------------------------", "Elegeix consulta:"};

    //Llegim el fitxer d'usuaris
    public static void mostrarUsuaris() throws IOException {
        System.out.println("Usuaris que han fet consultes:");
        BufferedReader in = new BufferedReader(new FileReader("res//usuaris.txt"));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        in.close();
    }

    /**
     * Mostra informació que hagis recuperat de la teva API
     *
     * @param dades Array d'string amb informació
     */
    public static void mostrarDades(String[] dades) { //Passem per paràmetre l'array de la consulta que sigui, i la printem.

        for (int x = 0; x < dades.length; x++) {
            System.out.println(dades[x]);
        }
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
    public static void mostrarMenu(String[] menu) { //Printem el menú que rebem per paràmetre

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

}
