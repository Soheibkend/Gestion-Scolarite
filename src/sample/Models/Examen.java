package sample.Models;

public class Examen {

    long matricule;
    String codem;

    public Examen (long matricule, String codem) {
        this.matricule = matricule;
        this.codem = codem;
    }

    public long getMatricule() {
        return matricule;
    }

    public void setMatricule(long matricule) {
        this.matricule = matricule;
    }

    public String getCodem() {
        return codem;
    }

    public void setCodem(String codem) {
        this.codem = codem;
    }
}
