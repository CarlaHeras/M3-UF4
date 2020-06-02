  
package project.model;
import java.util.ArrayList;
import java.util.List;

public class DadesAPI {
//Creem 3 llistes on guardarem les dades. Ho fem amb llistes per a que ens sigui més senzill afegir elements.
    private List<Estudiant> estudiants = new ArrayList<>();
    private List<Professor> professors = new ArrayList<>();

    public DadesAPI(){
        //La Cristina diu que l'inacialització dels tres atributs ha d'anar aqui
    }

    public void afegirEstudiant(Estudiant e ) {
        estudiants.add(e);
    }

    public void afegirProfessor(Professor p ) {
        professors.add(p);
    }
}

