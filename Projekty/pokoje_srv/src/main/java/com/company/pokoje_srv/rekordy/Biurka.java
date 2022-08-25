package com.company.pokoje_srv.rekordy;

import java.sql.Date; // .sql. albo .util.

public class Biurka {
    /*
    wynik zapytania sql
     */

    // Biurka.id?
    String imie;
    String nazwisko;
    String nr_tel_kom;
    int nr_pokoju;
    // budynek?
    Date zajete_od;
    Date zajete_do;

    public Biurka(String imie, String nazwisko, String nr_tel_kom, int nr_pokoju,
                  Date zajete_od, Date zajete_do) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_tel_kom = nr_tel_kom;
        this.nr_pokoju = nr_pokoju;
        this.zajete_od = zajete_od;
        this.zajete_do = zajete_do;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getNr_tel_kom() {
        return nr_tel_kom;
    }

    public int getNr_pokoju() {
        return nr_pokoju;
    }

    public Date getZajete_od() {
        return zajete_od;
    }

    public Date getZajete_do() {
        return zajete_do;
    }
}
