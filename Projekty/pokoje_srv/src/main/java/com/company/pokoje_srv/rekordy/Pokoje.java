package com.company.pokoje_srv.rekordy;

public class Pokoje {
    int id; // ? id ? tak, ale nie trzeba wyświetlać
    int nr_pokoju;
    int budynek; // adres czy numer budynku?
    String nr_tel;
    String przeznaczenie;
    int ile_biurek;

    public Pokoje(int id, int nr_pokoju, int budynek, String nr_tel, String przeznaczenie, int ile_biurek) {
        this.id = id;
        this.nr_pokoju = nr_pokoju;
        this.budynek = budynek;
        this.nr_tel = nr_tel;
        this.przeznaczenie = przeznaczenie;
        this.ile_biurek = ile_biurek;
    }

    public int getNr_pokoju() {
        return nr_pokoju;
    }

    public int getBudynek() {
        return budynek;
    }

    public String getNr_tel() {
        return nr_tel;
    }

    public String getPrzeznaczenie() {
        return przeznaczenie;
    }

    public int getIle_biurek() {
        return ile_biurek;
    }

    @Override
    public String toString() {
        return "Pokoje{" +
                "id=" + id +
                ", nr_pokoju=" + nr_pokoju +
                ", budynek=" + budynek +
                ", nr_tel='" + nr_tel + '\'' +
                ", przeznaczenie='" + przeznaczenie + '\'' +
                ", ile_biurek=" + ile_biurek +
                '}';
    }
}
