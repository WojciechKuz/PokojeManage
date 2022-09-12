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



    // // // // // DOSTĘP DO DANYCH // // // // //

    // GET
    // gdy zamiast RestController Controller, to przed typem zwracanym @ResponseBody
    //@GetMapping("/pokoje")
    public Pokoje[] getPokoje(){
        ArrayList<Pokoje> tab = (ArrayList<Pokoje>) pokojeRepo.findAll();
        return tab.toArray(new Pokoje[tab.size()]);
    }
    //@GetMapping("/pracownicy")
    public  Pracownicy[] getPracownicy(){
        ArrayList<Pracownicy> tab = (ArrayList<Pracownicy>) pracownicyRepo.findAll();
        return tab.toArray(new Pracownicy[tab.size()]);
    }
    //@GetMapping("/biurka")
    public Biurka[] getBiurka(){
        ArrayList<Biurka> tab = (ArrayList<Biurka>) biurkaRepo.findAll();
        return tab.toArray(new Biurka[tab.size()]);
    }
    //@GetMapping("/wolne")
    public WolnePokoje[] getWolne() {

        // zwrócić dane ile jest jeszcze wolnych biurek w pokojach (tablica)
        //
        System.out.println("UWAGA! \"GET /wolne\" nie jest jeszcze obsługiwane.");
        return new WolnePokoje[1]; // tymczasowe
    }

    Integer addRecord(Pokoje pok) {
        if(pok == null)
            return 1;
        pok.setId(null);
        pokojeRepo.save(pok);
        return 0;
    }
    Integer addRecord(Pracownicy pra) {
        if(pra == null)
            return 1;
        pra.setId(null);
        pracownicyRepo.save(pra);
        return 0;
    }
    Integer addRecord(Biurka biu) {
        if(biu == null)
            return 1;
        biu.setIdb(null);
        biurkaRepo.save(biu);
        return 0;
    }
    Integer editRecord(Pokoje pok) {
        if(pok == null)
            return 1;
        pokojeRepo.save(pok);
        return 0;
    }
    Integer editRecord(Pracownicy pra) {
        if(pra == null)
            return 1;
        pracownicyRepo.save(pra);
        return 0;
    }
    Integer editRecord(Biurka biu) {
        if(biu == null)
            return 1;
        biurkaRepo.save(biu);
        return 0;
    }



    // POST - dodawanie i edycja
    @PostMapping("/pokoje/{mode}")
    Integer postRecord(@RequestBody Pokoje pok, @PathVariable String mode) {
        int rv = 0;
        switch(mode) {
            case "add" -> {
                rv = addRecord(pok);
            }
            case "edit" -> {
                rv = editRecord(pok);
            }
        }
        return rv;
    }
    @PostMapping("/pracownicy/{mode}")
    Integer postRecord(@RequestBody Pracownicy pra, @PathVariable String mode) {
        int rv = 0;
        switch(mode) {
            case "add" -> {
                rv = addRecord(pra);
            }
            case "edit" -> {
                rv = editRecord(pra);
            }
        }
        return rv;
    }
    @PostMapping("/biurka/{mode}")
    Integer postRecord(@RequestBody Biurka biu, @PathVariable String mode) {
        int rv = 0;
        switch(mode) {
            case "add" -> {
                rv = addRecord(biu);
            }
            case "edit" -> {
                rv = editRecord(biu);
            }
        }
        return rv;
    }

    // PUT NIE MA! zamiast tego używać POST /{tabela}/edit


    // DELETE
    @DeleteMapping("/{table}/{id}")
    void deleteRecord(@PathVariable String table, @PathVariable Integer id){
        switch(table) {
            case "pokoje" -> pokojeRepo.deleteById(id);
            case "pracownicy" -> pracownicyRepo.deleteById(id);
            case "biurka" -> biurkaRepo.deleteById(id);
        }
    }

    /* klient może wysłać:
    [WYŁĄCZONE] get - otrzymaj dane tabeli		/tabela
    post - dodaj lub edytuj rekord	/tabela/add	 /tabela/edit
    delete - usuń rekord			/tabela/id

    (nazwa tabeli w requescie małymi literami)

    put - nie ma, bo nie zwraca kodu
     */


}


