package sample.Models;

public class Section {
    String codes;
    String libelle;
    String specialite;

    public Section (String codes, String libelle, String specialite) {
        this.codes = codes;
        this.libelle = libelle;
        this.specialite = specialite;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
