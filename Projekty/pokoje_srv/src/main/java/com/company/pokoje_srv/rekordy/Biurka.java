package com.company.pokoje_srv.rekordy;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.FetchType;

import java.util.Date;

@Entity
@Table(name="biurka")
public class Biurka {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer idb;
    Date zajete_od;
    Date zajete_do;
    @ManyToOne(fetch = FetchType.LAZY)
    Pracownicy pracownicy;
    @ManyToOne(fetch = FetchType.LAZY)
    Pokoje pokoje;

    public Integer getIdb() {
        return idb;
    }
    public Date getZajete_od() {
        return zajete_od;
    }
    public Date getZajete_do() {
        return zajete_do;
    }
    public Pracownicy getPracownicy() {
        return pracownicy;
    }
    public Pokoje getPokoje() {
        return pokoje;
    }

    public void setIdb(Integer idb) {
        this.idb = idb;
    }
    public void setZajete_od(Date zajete_od) {
        this.zajete_od = zajete_od;
    }
    public void setZajete_do(Date zajete_do) {
        this.zajete_do = zajete_do;
    }
    public void setPracownicy(Pracownicy pracownicy) {
        this.pracownicy = pracownicy;
    }
    public void setPokoje(Pokoje pokoje) {
        this.pokoje = pokoje;
    }

    @Override
    public String toString() {
        return "Biurka{" +
                "idb=" + idb +
                ", zajete_od=" + zajete_od +
                ", zajete_do=" + zajete_do +
                ", pracownicy=" + pracownicy +
                ", pokoje=" + pokoje +
                '}';
    }
}
