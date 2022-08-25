package com.company.pokoje_srv.rekordy;

import java.sql.Date;   // java.sql.Date albo java.util.Date ?

public class Pracownicy {
    int id;
    String imie;
    String nazwisko;
    String nr_tel_kom;
    String rodzaj_pracown;
    Date zatrudnienie_od;
    Date zatrudnienie_do;

    public Pracownicy(int id, String imie, String nazwisko, String nr_tel_kom,
                      String rodzaj_pracown, Date zatrudnienie_od, Date zatrudnienie_do) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_tel_kom = nr_tel_kom;
        this.rodzaj_pracown = rodzaj_pracown;
        this.zatrudnienie_od = zatrudnienie_od;
        this.zatrudnienie_do = zatrudnienie_do;
    }

    public int getId() {
        return id;
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

    public String getRodzaj_pracown() {
        return rodzaj_pracown;
    }

    public Date getZatrudnienie_od() {
        return zatrudnienie_od;
    }

    public Date getZatrudnienie_do() {
        return zatrudnienie_do;
    }
}
