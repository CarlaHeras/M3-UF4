package project.model;

public abstract class Personatge {
    private String nom;
    private String especie;
    private String casa;
    private String patronus;
    private String actor;

    public Personatge(String nom, String especie, String casa, String patronus,String actor) {
        this.nom = nom;
        this.especie = especie;
        this.casa = casa;
        this.patronus = patronus;
        this.actor = actor;
    }

    //SOBREESCRIPTURA PER PRINTAR PERSONATGES
    @Override
    public String toString() {
        return  "Nom = " + nom +
                ", Especie = " + especie +
                ", Casa = " + casa +
                ", Patronus = " + patronus +
                ", Actor = " + actor + "\n";
    }

    public String getNom() {
        return nom;
    }
}
