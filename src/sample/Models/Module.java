package sample.Models;

public class Module {
    String codem;
    String libellem;
    int coef;
    String codeens;

    public Module(String codem, String libellem, int coef, String codeens) {
        this.codem = codem;
        this.libellem = libellem;
        this.coef = coef;
        this.codeens = codeens;
    }

    public String getCodem() {
        return codem;
    }

    public void setCodem(String codem) {
        this.codem = codem;
    }

    public String getLibellem() {
        return libellem;
    }

    public void setLibellem(String libellem) {
        this.libellem = libellem;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public String getCodeens() {
        return codeens;
    }

    public void setCodeens(String codeens) {
        this.codeens = codeens;
    }
}
