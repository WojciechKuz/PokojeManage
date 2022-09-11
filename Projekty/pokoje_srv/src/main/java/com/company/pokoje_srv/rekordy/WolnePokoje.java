package com.company.pokoje_srv.rekordy;

public class WolnePokoje {
    /*
        Nie tabela w BD, tylko do przesyłania
     */

    Integer nr_pokoju;
    String budynek; // adres
    String przeznaczenie;
    Integer ile_wolnych;    // ile jest wolnych biurek
    Integer ile_biurek;

    public int getNr_pokoju() {
        return nr_pokoju;
    }
    public String getBudynek() {
        return budynek;
    }
    public String getPrzeznaczenie() {
        return przeznaczenie;
    }
    public int getIle_wolnych() {
        return ile_wolnych;
    }
    public int getIle_biurek() {
        return ile_biurek;
    }

    public void setNr_pokoju(Integer nr_pokoju) {
        this.nr_pokoju = nr_pokoju;
    }
    public void setBudynek(String budynek) {
        this.budynek = budynek;
    }
    public void setPrzeznaczenie(String przeznaczenie) {
        this.przeznaczenie = przeznaczenie;
    }
    public void setIle_wolnych(Integer ile_wolnych) {
        this.ile_wolnych = ile_wolnych;
    }
    public void setIle_biurek(Integer ile_biurek) {
        this.ile_biurek = ile_biurek;
    }
}
