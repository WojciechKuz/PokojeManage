package com.company.pokoje_srv.rekordy;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
@Table(name="pokoje")
public class Pokoje {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer nr_pokoju;
    private String budynek; // adres
    private String nr_tel;
    private String przeznaczenie;
    private Integer ile_biurek;
    @OneToMany(mappedBy ="pokoje")
    private List<Biurka> biurka;

    public Integer getId() {
        return id;
    }
    public Integer getNr_pokoju() {
        return nr_pokoju;
    }
    public String getBudynek() {
        return budynek;
    }
    public String getNr_tel() {
        return nr_tel;
    }
    public String getPrzeznaczenie() {
        return przeznaczenie;
    }
    public Integer getIle_biurek() {
        return ile_biurek;
    }
    public List<Biurka> getBiurka() {
        return biurka;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setNr_pokoju(Integer nr_pokoju) {
        this.nr_pokoju = nr_pokoju;
    }
    public void setBudynek(String budynek) {
        this.budynek = budynek;
    }
    public void setNr_tel(String nr_tel) {
        this.nr_tel = nr_tel;
    }
    public void setPrzeznaczenie(String przeznaczenie) {
        this.przeznaczenie = przeznaczenie;
    }
    public void setIle_biurek(Integer ile_biurek) {
        this.ile_biurek = ile_biurek;
    }
    public void setBiurka(List<Biurka> biurka) {
        this.biurka = biurka;
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
