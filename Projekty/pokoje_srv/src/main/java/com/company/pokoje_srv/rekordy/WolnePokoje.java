package com.company.pokoje_srv.rekordy;

public class WolnePokoje {
    /*
    wynik zapytania sql
     */

    int nr_pokoju;
    int budynek;
    String przeznaczenie;
    int ile_wolnych;    // ile jest wolnych biurek
    int ile_biurek;

    public WolnePokoje(int nr_pokoju, int budynek, String przeznaczenie, int ile_wolnych, int ile_biurek) {
        this.nr_pokoju = nr_pokoju;
        this.budynek = budynek;
        this.przeznaczenie = przeznaczenie;
        this.ile_wolnych = ile_wolnych;
        this.ile_biurek = ile_biurek;
    }

    public int getNr_pokoju() {
        return nr_pokoju;
    }

    public int getBudynek() {
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
}
