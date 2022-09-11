package com.company.pokoje_srv.rekordy;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.List;
import java.util.Date;

@Entity
@Table(name="pracownicy")
public class Pracownicy {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String imie;
    private String nazwisko;
    private String nr_tel_kom;
    private String rodzaj_pracown;
    private Date zatrudnienie_od;
    private Date zatrudnienie_do;
    @OneToMany(mappedBy ="pracownicy")
    private List<Biurka> biurka;

    public Integer getId() {
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
    public List<Biurka> getBiurka() {
        return biurka;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    public void setNr_tel_kom(String nr_tel_kom) {
        this.nr_tel_kom = nr_tel_kom;
    }
    public void setRodzaj_pracown(String rodzaj_pracown) {
        this.rodzaj_pracown = rodzaj_pracown;
    }
    public void setZatrudnienie_od(Date zatrudnienie_od) {
        this.zatrudnienie_od = zatrudnienie_od;
    }
    public void setZatrudnienie_do(Date zatrudnienie_do) {
        this.zatrudnienie_do = zatrudnienie_do;
    }
    public void setBiurka(List<Biurka> biurka) {
        this.biurka = biurka;
    }
}
