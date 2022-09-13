package com.company.pokoje_srv;

import com.company.pokoje_srv.rekordy.*;
import com.company.pokoje_srv.repozytoria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class WebController
{
    
    @Autowired
    public PokojeRepo pokojeRepo;
    @Autowired
    public PracownicyRepo pracownicyRepo;
    @Autowired
    public BiurkaRepo biurkaRepo;

    @RequestMapping("/menu")
    String wyswietlMenu() {
        return "menu";
    }


    //Usuwanie pracowników po przekroczeniu terminu zatrudnienia
    /*
    @Transactional
    public void UsuwaniePracownikowPoTerminie()
    {
        Date dateNow = new Date();
        List<Pracownicy> listaPracownicyDoUsuniecia = List.of(getPracownicy());
        for (Pracownicy prac : listaPracownicyDoUsuniecia)
        {
            pracownicyRepo.deleteByZatrudnienieDoBefore(dateNow);
        }
    }
    */

    @RequestMapping("/table=Pokoje")
    String WylistujPokoje(Model model)
    {
        List<Pokoje> listaPokoi = List.of(getPokoje());

        System.out.println("wyświetlam pokoje");

        model.addAttribute("pokojeList",listaPokoi);

        return "pokoje";
    }



    @RequestMapping("/table=Pracownicy")
    String WylistujPracownikow(Model model)
    {
        //Najpierw usuwanie pracowników, którzy przekroczyli czas zatrudnienia
        //UsuwaniePracownikowPoTerminie();

        //Pobieranie zaktualizowanej listy
        List<Pracownicy> listaPracownicy = List.of(getPracownicy());

        System.out.println("wyświetlam pracowników");

        model.addAttribute("pracownicyList",listaPracownicy);

        return "pracownicy";
    }

    @RequestMapping("/table=Biurka")
    String WylistujBiurka(Model model)
    {
        List<Biurka> listaBiurka = List.of(getBiurka());

        System.out.println("wyświetlam biurka");

        model.addAttribute("biurkaList",listaBiurka);

        return "biurka";
    }

    /////////////////////////////////////////////////////////

    //Mapping Formularza
    @RequestMapping("/table=DodajPokoj")
    public String dodajPokoj(Model model)
    {
        model.addAttribute("dane", new Pokoje());
        return "dodajPokoj";
    }

    @RequestMapping("/table=DodajPracownik")
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
    @RequestMapping("/table=EdytujPokoj")
    public String edytujPokoj(Model model)
    {
        model.addAttribute("dane", new Pokoje());
        return "edytujPokoj";
    }

    @RequestMapping("/table=EdytujPracownik")
    public String edytujPracownika(Model model)
    {
        model.addAttribute("dane", new Pracownicy());
        return "edytujPracownika";
    }

    @RequestMapping("/table=EdytujBiurko")
    public String edytujBiurko(Model model)
    {
        model.addAttribute("dane", new Biurka());
        return "edytujBiurko";
    }

    //////////////////////////////////////////////////////////

    //Mapping wypełnionego formularza
    @RequestMapping("/pokojDodano")
    public String dodajRekord(@ModelAttribute Pokoje dane, Model model)
    {
        addRecord(dane);
        return "dodanoRekord";
    }
    @RequestMapping("/pokojEdytowano")
    public String edytujRekord(@ModelAttribute Pokoje dane, Model model)
    {
        editRecord(dane);
        return "pokoje";
    }

    @RequestMapping("/pracownikDodano")
    public String dodajRekord(@ModelAttribute Pracownicy dane, Model model)
    {
        addRecord(dane);
        return "dodanoRekord";
    }
    @RequestMapping("/pracownikEdytowano")
    public String edytujRekord(@ModelAttribute Pracownicy dane, Model model)
    {
        editRecord(dane);
        return "pracownicy";
    }

    @RequestMapping("/biurkoDodano")
    public String dodajRekord(@ModelAttribute Biurka dane, Model model)
    {
        addRecord(dane);
        return "dodanoRekord";
    }
    @RequestMapping("/biurkoEdytowano")
    public String edytujRekord(@ModelAttribute Biurka dane, Model model)
    {
        editRecord(dane);
        return "biurko";
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


    /*
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
    */

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


