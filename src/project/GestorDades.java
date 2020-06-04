package project;

import project.model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import project.model.DadesAPI;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class GestorDades {
    private DadesAPI dades;
    public GestorDades() {
        dades = new DadesAPI();
    }

    /**
     * Carrega des de l'API les dades que ens interessin.
     *
     */
    //Invoquem el mètode que ens carrega les dades de l'API
    public void carregarDades() {
        carregarEstudiants();
        carregarProfessors();

    }

    public DadesAPI getDades() {
        return dades;
    }

    //CARREGAR ELS ATRIBUTS DELS ESTUDIANTS
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
                String patronus = person.get("patronus").toString();
                String actor = person.get("actor").toString();
                Estudiant est = new Estudiant(nom, especie, casa, patronus, actor);
                dades.afegirEstudiant(est);
            }
            connection.disconnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    //CARREGAR ELS ATRIBUTS DELS PROFESSORS
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
                String patronus = person.get("patronus").toString();
                String actor = person.get("actor").toString();
                Professor prof = new Professor(nom, especie, casa, patronus, actor);
                dades.afegirProfessor(prof);
            }
            connection.disconnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //RECORRE ELS ARRAYLISTS BUSCANT EL NOM QUE S'HA INSERIT I L'ELIMINA
    public void buscareliminarPersonatge(String nom) {
        for (int i = 0; i < dades.getEstudiants().size() ; i++) {
            if (nom.equals(dades.getEstudiants().get(i).getNom().toLowerCase())) {
                dades.getEstudiants().remove(i);
                System.out.println("S'ha eliminat " + nom);
            }
        }
        for (int i = 0; i < dades.getProfessors().size(); i++) {
            if (nom.equals(dades.getProfessors().get(i).getNom().toLowerCase())) {
                dades.getProfessors().remove(i);
                System.out.println("S'ha eliminat " + nom);
            }
        }
    }

    //DETECTA SI L'ARRAY ESTÀ BUIDA I RETORNA UN BOLEÀ
    public boolean comprovarArraybuida(ArrayList a) {
        if (a.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
