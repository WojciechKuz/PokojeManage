package com.company.pokoje_srv;
import com.company.pokoje_srv.rekordy.*;

import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
public class UniversalController {
    /* klient może wysłać:
    get - dane tabeli
    post - dodaj rekord
    put - edytuj rekord
    delete - usuń rekord
     */

    // do GET muszą być oddzielne, bo różnią się typem zwracanym

    @GetMapping("/table=Pokoje") // /table=Pokoje
    public Pokoje[] sendPokoje(){

        //todo: zwrócić tabelę pokoje (tablica)


        //tymczasowe: (mam nadzieję, że prześle tablicę z zawartością)
        Pokoje[] temptab = {new Pokoje(1034,100, 5, "+48 224 444 444", "pomieszczenie gospodarcze", 1),
                            new Pokoje(519,101, 3, "+48 224 444 000", "serwerownia", 2)};
        return temptab;
    }

    @GetMapping("/table=Pracownicy")
    public Pracownicy[] sendPracownicy(){

        //todo: zwrócić tabelę pracownicy (tablica)


        //tymczasowe:
        Pracownicy[] temptab = {new Pracownicy(007, "imie","nazwisko","+48 224 444 444", "sprzatacz",new Date(12230), new Date(12346))};
        return temptab;
    }

    @GetMapping("/table=Biurka")
    public Biurka[] sendBiurka(){

        //todo: zwrócić dane kto zajmuje pokoje (tablica)


        //tymczasowe:
        Biurka[] temptab = {new Biurka("imie","nazwisko","+48 224 444 444", 0,new Date(12234), new Date(12345))};
        return temptab;
    }

    @GetMapping("table=Wolne")
    public WolnePokoje[] sendWolne(){

        //todo: zwrócić dane ile jest jeszcze wolnych biurek w pokojach (tablica)


        //tymczasowe:
        WolnePokoje[] temptab = {new WolnePokoje(101, 3, "serwerownia", 0, 2)};
        return temptab;
    }


    // w POST, PUT, DELETE można wewnątrz rozpoznać o jaką tabelę chodzi
    @PostMapping("/")
    void addRecord(@RequestParam(value = "table", defaultValue = "Pokoje") String table){

        //todo: OTRZYMANO WIADOMOŚĆ. odczytać dane, zaktualizować bazę danych
    }
    @PutMapping("/")
    void editRecord(@RequestParam(value = "table", defaultValue = "Pokoje") String table){

        //todo: OTRZYMANO WIADOMOŚĆ. odczytać dane, zaktualizować bazę danych
    }
    @DeleteMapping("/")
    void deleteRecord(@RequestParam(value = "table", defaultValue = "Pokoje") String table){

        //todo: OTRZYMANO WIADOMOŚĆ. odczytać dane, zaktualizować bazę danych
    }

}
