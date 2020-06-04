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
        GestorDades gestor = new GestorDades();

        int eleccio;       //Variable per guardar l'opció del menú secundari elegida per l'usuari.
        int eleccio2;      //Variable per guardar l'opció del menú secundari elegida per l'usuari.
        boolean exit1 = false;

        while (!exit1) {
            Interficie.mostrarMenu(Interficie.opcmenu);
            eleccio = sc.nextInt();
            switch (eleccio) {
                case 1://CARREGA LES DADES ALS ARRAYLISTS
                    gestor.carregarDades();
                    break;
                case 2:
                    boolean exit2 = false;
                    while (!exit2) {
                        Interficie.mostrarMenu(Interficie.opcmenu2); //MOSTRAR SUBMENU PREGUNTANT SI L'USUARI VOL VEURE TOTS, ST O PROF
                        eleccio2 = sc.nextInt();
                        switch (eleccio2) {

                            case 1: //MOSTRAR TOTS ELS PERSONATGES (JUNTAR STU, AMB PROF)
                                if (gestor.comprovarArraybuida(gestor.getDades().getEstudiants()) && gestor.comprovarArraybuida(gestor.getDades().getEstudiants())) {
                                    System.out.println("Insereix dades a estudiants i professors!");
                                } else {
                                    Interficie.mostrarDades(gestor.getDades().getEstudiants());
                                    Interficie.mostrarDades(gestor.getDades().getProfessors());
                                }
                                break;
                            case 2: //MOSTAR ESTUDIANTS
                                if (gestor.comprovarArraybuida(gestor.getDades().getEstudiants())) {
                                    System.out.println("Insereix dades a estudiants!");
                                } else {
                                    Interficie.mostrarDades(gestor.getDades().getEstudiants());
                                }
                                break;
                            case 3: //MOSTRAR PROFESSORS
                                if (gestor.comprovarArraybuida(gestor.getDades().getProfessors())) {
                                    System.out.println("Insereix dades a professors!");
                                } else {
                                    Interficie.mostrarDades(gestor.getDades().getProfessors());
                                }
                                break;
                            case 0:
                                exit2 = true;
                                break;
                            default:
                                Interficie.mostrarMissatge("Inserta un número que correspongui a alguna opció:");
                                break;
                        }

                    }
                    break;
                case 3:
                    System.out.println("Que vols afegir?");
                    System.out.println("1.Alumnes");
                    System.out.println("2.Professors");
                    switch (sc.nextInt()) {
                        case 1: //ALUMNES
                            Interficie.preguntarAtributs("est", gestor);
                            break;
                        case 2: //PROFESSORS
                            Interficie.preguntarAtributs("pro", gestor);
                            break;
                        case 0:
                            eleccio2 = 0;
                            break;
                    }
                    break;
                case 4: //Esborrar personatges (en el cas de que les arrays estiguin buides no permet borrar)
                    if (gestor.comprovarArraybuida(gestor.getDades().getEstudiants()) && gestor.comprovarArraybuida(gestor.getDades().getProfessors())) {
                        System.out.println("Insereix dades a estudiants i professors!");
                    } else {
                        System.out.println("Quin personatge vols esborrar?");
                        sc.nextLine();
                        String nom = sc.nextLine();
                        gestor.buscareliminarPersonatge(nom.toLowerCase());
                    }
                    break;
                case 0:
                    exit1 = true;
            }
        }
    }
}
