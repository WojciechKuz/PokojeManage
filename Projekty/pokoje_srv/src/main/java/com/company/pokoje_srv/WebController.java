package com.company.pokoje_srv;

import com.company.pokoje_srv.rekordy.Biurka;
import com.company.pokoje_srv.rekordy.Pokoje;
import com.company.pokoje_srv.rekordy.Pracownicy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController
{
    @RequestMapping("/table=PokojeTest")
    String WylistujPokoje(Model model)
    {
        //testowa lista
        //Pokoje[] temptab = {new Pokoje(1034,100, 5, "+48 224 444 444", "pomieszczenie gospodarcze", 1),
        //        new Pokoje(519,101, 3, "+48 224 444 000", "serwerownia", 2)};

        List<Pokoje> listaPokoi = new ArrayList<>();

        //Wypisanie zawartości na konsolę
        System.out.println();
        System.out.println("vvvvvvvvvvvvvvvvvvvvv");
        listaPokoi.forEach(System.out::println);
        System.out.println();
        System.out.println("^^^^^^^^^^^^^^^^^^^^^");

        model.addAttribute("pokojeList",listaPokoi);

        return "pokoje";
    }

    @RequestMapping("/table=PracownicyTest")
    String WylistujPracownikow(Model model)
    {
        List<Pracownicy> listaPracownicy = new ArrayList<>();

        //Wypisanie zawartości na konsolę
        System.out.println();
        System.out.println("vvvvvvvvvvvvvvvvvvvvv");
        listaPracownicy.forEach(System.out::println);
        System.out.println();
        System.out.println("^^^^^^^^^^^^^^^^^^^^^");

        model.addAttribute("pracownicyList",listaPracownicy);

        return "pracownicy";
    }

    @RequestMapping("/table=BiurkaTest")
    String WylistujBiurka(Model model)
    {
        List<Pracownicy> listaBiurka = new ArrayList<>();

        //Wypisanie zawartości na konsolę
        System.out.println();
        System.out.println("vvvvvvvvvvvvvvvvvvvvv");
        listaBiurka.forEach(System.out::println);
        System.out.println();
        System.out.println("^^^^^^^^^^^^^^^^^^^^^");

        model.addAttribute("biurkaList",listaBiurka);

        return "biurka";
    }

    @RequestMapping("/table=DodajPokoj")
    public String dodajPokoj(Model model)
    {
        model.addAttribute("dane", new Pokoje());
        return "dodajPokoj";
    }

    @RequestMapping("/table=DodajPracownika")
    public String dodajPracownika(Model model)
    {
        model.addAttribute("dane", new Pracownicy());
        return "dodajPracownika";
    }

    @RequestMapping("/table=DodajBiurko")
    public String dodajBiurko(Model model)
    {
        model.addAttribute("dane", new Biurka());
        return "dodajBiurko";
    }



}


