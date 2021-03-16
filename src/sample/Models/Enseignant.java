package sample.Models;

public class Enseignant {
    String codeens;
    String nomens;
    String prenomens;
    String grade;

    public Enseignant (String codeens,String nomens, String prenomens, String grade) {
        this.codeens = codeens;
        this.nomens = nomens;
        this.prenomens = prenomens;
        this.grade = grade;
    }

    public String getCodeens() {
        return codeens;
    }

    public void setCodeens(String codeens) {
        this.codeens = codeens;
    }

    public String getNomens() {
        return nomens;
    }

    public void setNomens(String nomens) {
        this.nomens = nomens;
    }

    public String getPrenomens() {
        return prenomens;
    }

    public void setPrenomens(String prenomens) {
        this.prenomens = prenomens;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
