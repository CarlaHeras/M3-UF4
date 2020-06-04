  
package project.model;
import java.util.ArrayList;

public class DadesAPI {
//Creem 3 llistes on guardarem les dades. Ho fem amb llistes per a que ens sigui més senzill afegir elements.
    private ArrayList<Estudiant> estudiants = new ArrayList<>();
    private ArrayList<Professor> professors = new ArrayList<>();

    public void afegirEstudiant(Estudiant e ) {
        estudiants.add(e);
    }

    public void afegirProfessor(Professor p ) {
        professors.add(p);
    }

    //SOBRECÀRREGA DE DADES DE L'OPCIÓ D'AFEGIR DEL MENU
    public void afegirEstudiant(String nom, String especie, String casa, String patronus, String actor) {
        Estudiant es = new Estudiant(nom, especie, casa, patronus, actor);
        estudiants.add(es);
    }

    public void afegirProfessor(String nom, String especie, String casa, String patronus, String actor) {
        Professor prof = new Professor(nom, especie, casa, patronus, actor);
        professors.add(prof);
    }

    //
    public ArrayList<Estudiant> getEstudiants() {
        return estudiants;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }
}