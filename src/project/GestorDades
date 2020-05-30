package project;

        import org.json.simple.JSONArray;
        import org.json.simple.JSONObject;
        import org.json.simple.parser.JSONParser;
        import java.io.*;
        import java.net.HttpURLConnection;
        import java.net.URL;
        import java.util.Collections;

public class GestorDades {
    //Declarem les 3 arrays a on passarem les dades de les llistes de la classe DadesAPI quan les necessitem en forma d'array.
    public static String[] estudiants;
    public static String[] professors;
    public static String[] personatges;

    /**
     * Carrega des de l'API les dades que ens interessin.
     *
     * @param dades parámetre que emmagatzemará les dades que hagim recuperat de l'API
     */
    //Invoquem el mètode que ens carrega les dades de l'API a les llistes de la classe DadesAPI i a continuació les conver-
    //-tim a array, a les 3 que hem creat adalt.
    public static void carregarDades(DadesAPI dades) {
        carregarDadesMngr("http://hp-api.herokuapp.com/api/characters/students", dades);
        carregarDadesMngr("http://hp-api.herokuapp.com/api/characters/", dades);
        carregarDadesMngr("http://hp-api.herokuapp.com/api/characters/staff", dades);


        estudiants = new String[dades.estudiants.size()];
        dades.estudiants.toArray(estudiants);

        professors = new String[dades.professors.size()];
        dades.professors.toArray(professors);

        personatges = new String[dades.personatges.size()];
        dades.personatges.toArray(personatges);

    }

    //Recorrem el JSON que correspongui i guardem les dades que ens interessan a les llistes de la classe DadesAPI
    static void carregarDadesMngr(String link, DadesAPI dades) {
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            JSONParser parser = new JSONParser();
            JSONArray a = (JSONArray) parser.parse(new InputStreamReader(connection.getInputStream()));
            for (Object o : a) {
                JSONObject person = (JSONObject) o;
                if (link.equals("http://hp-api.herokuapp.com/api/characters/students")) {
                    dades.estudiants.add(" - " + person.get("name") + " ||" + " -Espècie: " + person.get("species") + " |" + " -Casa: " + person.get("house") + " |" + " -Patronus: " + person.get("patronus") + " |" + " -Actor/Actriu: " + person.get("actor") + "\n");
                }
                if (link.equals("http://hp-api.herokuapp.com/api/characters/")) {
                    dades.personatges.add(" - " + person.get("name") + " ||" + " -Espècie: " + person.get("species") + " |" + " -Casa: " + person.get("house") + " |" + " -Actor/Actriu: " + person.get("actor") + "\n");
                }
                if (link.equals("http://hp-api.herokuapp.com/api/characters/staff")) {
                    dades.professors.add(" - " + person.get("name") + " ||" + " -Espècie: " + person.get("species") + " |" + " -Casa: " + person.get("house") + " |" + " -Actor/Actriu: " + person.get("actor") + "\n");
                }
            }
        } catch (Exception e) {

        }
    }

    /**
     * Desa les dades de l'API en un fitxer txt extern
     *
     * @param dades conté les dades de l'API
     */
    // Mètode per desar les dades en ".txt". Rebem per paràmetre l'array que conté les dades de la consulta que hem de guardar i el nom del fitxer
    public static void desarDades(String[] dades, String nomfitx) throws IOException {
        File fitxer = new File("res//" + nomfitx + ".txt");
        //Creem el fitxer
        if (fitxer.createNewFile()) {
            Interficie.mostrarMissatge("Fitxer creat, dades desades.");
        } else {
            Interficie.mostrarMissatge("Ja existeix, el sobreescriurem.");
        }
        //Escribim/sobreescribim el fitxer amb l'última consulta
        FileWriter escriure = new FileWriter(fitxer);
        for (int i = 0; i < dades.length; i++) {
            escriure.write(dades[i]);
        }
        escriure.close();
    }

    /**
     * Ordena el llista d'elements alfabéticament independenment de si el nom es troba en majúscules o minúscules
     *
     * @param dades conté variable amb la informació dels alements a ordenar en l'interior
     */
    //Ordenem les llistes i les convertim a les arrays declarades adalt.
    public static void ordenarElements(DadesAPI dades) {
        Collections.sort(dades.estudiants);
        estudiants = new String[dades.estudiants.size()];
        dades.estudiants.toArray(estudiants);
        Collections.sort(dades.personatges);
        personatges = new String[dades.personatges.size()];
        dades.personatges.toArray(personatges);
        Collections.sort(dades.professors);
        professors = new String[dades.professors.size()];
        dades.professors.toArray(professors);
    }

    /**
     * Afegeix l'element a la llista. Es manté la ordenació alfabética
     *
     * @param dades conté variable amb la informació dels elements a canviar en l'interior
     * @param nom   nom de l'element que cal afegir
     */
    //Afegim l'element que rebem al paràmetre nom a la llista que correspongui a l'id de consulta
    //i convertim la llista a array
    public static void afegirElement(DadesAPI dades, int idconsulta, String nom) {
        if (idconsulta == 1) {
            dades.personatges.add(" " + nom + "\n");
            personatges = new String[dades.personatges.size()];
            dades.personatges.toArray(personatges);
        }
        if (idconsulta == 2) {
            dades.estudiants.add(" " + nom + "\n");
            estudiants = new String[dades.estudiants.size()];
            dades.estudiants.toArray(estudiants);
        }
        if (idconsulta == 3) {
            dades.professors.add(" " + nom + "\n");
            professors = new String[dades.professors.size()];
            dades.professors.toArray(professors);
        }
    }

    //Guardem l'usuari que rebem per paràmetre al fitxer usuaris
    public static void guardarUsuari(String nom) throws IOException {
        Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("res//usuaris.txt", true), "UTF-8"));
        writer.append(nom + "\n");
        writer.close();
    }
}
