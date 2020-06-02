package project;

import project.model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import project.model.DadesAPI;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class GestorDades {
    private DadesAPI dades;
    public GestorDades() {
        dades = new DadesAPI();
    }

    /*//Declarem les 3 arrays a on passarem les dades de les llistes de la classe DadesAPI quan les necessitem en forma d'array.
    public static String[] estudiants;
    public static String[] professors;
    public static String[] personatges;
    */
    /**
     * Carrega des de l'API les dades que ens interessin.
     *
     */
    //Invoquem el mètode que ens carrega les dades de l'API a les llistes de la classe DadesAPI i a continuació les conver-
    //-tim a array, a les 3 que hem creat adalt.
    public void carregarDades() {
        carregarEstudiants();
        carregarProfessors();

    }

    public void carregarEstudiants() {
        try {
            URL url = new URL("http://hp-api.herokuapp.com/api/characters/students");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            JSONParser parser = new JSONParser();
            JSONArray a = (JSONArray) parser.parse(new InputStreamReader(connection.getInputStream()));
            for (Object o : a) {
                JSONObject person = (JSONObject) o;

                String nom = person.get("name").toString();
                String especie = person.get("species").toString();
                String casa = person.get("house").toString();
                String actor = person.get("actor").toString();
                Estudiant est = new Estudiant(nom, especie, casa, actor);
                dades.afegirEstudiant(est);
            }
            connection.disconnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void carregarProfessors() {
        try {
            URL url = new URL("http://hp-api.herokuapp.com/api/characters/staff");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            JSONParser parser = new JSONParser();
            JSONArray a = (JSONArray) parser.parse(new InputStreamReader(connection.getInputStream()));
            for (Object o : a) {
                JSONObject person = (JSONObject) o;

                String nom = person.get("name").toString();
                String especie = person.get("species").toString();
                String casa = person.get("house").toString();
                String actor = person.get("actor").toString();
                Professor prof = new Professor(nom, especie, casa, actor);
                dades.afegirProfessor(prof);
            }
            connection.disconnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
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


        String tempe;

        for (int i = 0; i < dades.estudiants.size(); i++) {

            for (int j = i + 1; j < dades.estudiants.size(); j++) {

                if (dades.estudiants.get(i).compareTo(dades.estudiants.get(j)) < 0) {

                    tempe = dades.estudiants.get(i);
                    dades.estudiants.set(i, dades.estudiants.get(j));
                    dades.estudiants.set(j, tempe);

                }
            }
        }

        String temppe;

        for (int i = 0; i < dades.personatges.size(); i++) {

            for (int j = i + 1; j < dades.personatges.size(); j++) {

                if (dades.personatges.get(i).compareTo(dades.personatges.get(j)) < 0) {

                    temppe = dades.personatges.get(i);
                    dades.personatges.set(i, dades.personatges.get(j));
                    dades.personatges.set(j, temppe);

                }
            }
        }

        String temppr;

        for (int i = 0; i < dades.professors.size(); i++) {

            for (int j = i + 1; j < dades.professors.size(); j++) {

                if (dades.professors.get(i).compareTo(dades.professors.get(j)) < 0) {

                    temppr = dades.professors.get(i);
                    dades.professors.set(i, dades.professors.get(j));
                    dades.professors.set(j, temppr);

                }
                /*//Collections.sort(dades.estudiants);
                estudiants = new String[dades.estudiants.size()];
                dades.estudiants.toArray(estudiants);

                //Collections.sort(dades.personatges);
                personatges = new String[dades.personatges.size()];
                dades.personatges.toArray(personatges);

                //Collections.sort(dades.professors);
                professors = new String[dades.professors.size()];
                dades.professors.toArray(professors);*/
            }
        }
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
