package sample.Models;

public class Etudiant {

    private String matricule;
    private String nom;
    private String prenom;
    private String section;
    private int groupe;

    public Etudiant (String matricule, String nom, String prenom, String section, int groupe) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.section = section;
        this.groupe = groupe;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getGroupe() {
        return groupe;
    }

    public void setGroupe(int groupe) {
        this.groupe = groupe;
    }
}
