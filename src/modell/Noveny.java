package modell;

import java.io.Serializable;

public class Noveny implements Serializable{
    private String azonosito, nev;
    private int ar, kor;

    public Noveny(String azonosito, String nev, int ar, int kor) {
        this.azonosito = azonosito;
        this.nev = nev;
        this.ar = ar;
        this.kor = kor;
    }

    //getterek 
    public String getAzonosito() {
        return azonosito;
    }

    public String getNev() {
        return nev;
    }

    public int getAr() {
        return ar;
    }

    public int getKor() {
        return kor;
    }

    //setterek
    public void setAzonosito(String azonosito) {
        this.azonosito = azonosito;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }
    
    
    
    
    
}
