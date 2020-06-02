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
}
