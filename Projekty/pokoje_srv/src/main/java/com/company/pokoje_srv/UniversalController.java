package com.company.pokoje_srv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.company.pokoje_srv.rekordy.*;
import com.company.pokoje_srv.repozytoria.*;
import java.util.Objects;
import java.util.Optional;
import java.util.Vector;
import java.util.ArrayList;
import java.lang.Object;
import java.util.Date;

// URUCHOMIENIE SERWERA: .\mvnw spring-boot:run

@RestController
public class UniversalController {
    /* klient może wysłać:
    get - otrzymaj dane tabeli		/tabela
    post - dodaj lub edytuj rekord	/tabela/add	 /tabela/edit
    delete - usuń rekord			/tabela/id
    
    (nazwa tabeli w requescie małymi literami)
    
    put - nie ma, bo nie zwraca kodu
     */

    @Autowired
    public PokojeRepo pokojeRepo;
    @Autowired
    public PracownicyRepo pracownicyRepo;
    @Autowired
    public BiurkaRepo biurkaRepo;
    
    
    
    // do GET muszą być oddzielne, bo różnią się typem zwracanym
    @GetMapping("/pokoje")
    public Pokoje[] getPokoje(){
        ArrayList<Pokoje> tab = (ArrayList<Pokoje>) pokojeRepo.findAll();
        return tab.toArray(new Pokoje[tab.size()]);
    }

    @GetMapping("/pracownicy")
    public Pracownicy[] getPracownicy(){
        ArrayList<Pracownicy> tab = (ArrayList<Pracownicy>) pracownicyRepo.findAll();
        return tab.toArray(new Pracownicy[tab.size()]);
    }

    @GetMapping("/biurka")
    public Biurka[] getBiurka(){
        ArrayList<Biurka> tab = (ArrayList<Biurka>) biurkaRepo.findAll();
        return tab.toArray(new Biurka[tab.size()]);
    }

    @GetMapping("/wolne")
    public WolnePokoje[] getWolne() {

        //todo: zwrócić dane ile jest jeszcze wolnych biurek w pokojach (tablica)
        //
    	System.out.println("UWAGA! \"GET /wolne\" nie jest jeszcze obsługiwane.");
    	return new WolnePokoje[1]; // tymczasowe
    }

    // POST - dodawanie i edycja
    @PostMapping("/pokoje/{mode}")
    Integer postRecord(@RequestBody Pokoje pok, @PathVariable String mode) {
    	
    	switch(mode) {
    	case "add" -> {
    			pok.setId(null);
    			pokojeRepo.save(pok);
    		}
    	case "edit" -> {
    			pokojeRepo.save(pok);
    		}
    	}
    	return 0;
    }
    @PostMapping("/pracownicy/{mode}")
    Integer postRecord(@RequestBody Pracownicy pra, @PathVariable String mode) {
    	
    	switch(mode) {
    	case "add" -> {
    			pra.setId(null);
    			pracownicyRepo.save(pra);
    		}
    	case "edit" -> {
    			pracownicyRepo.save(pra);
    		}
    	}
    	return 0;
    }
    @PostMapping("/biurka/{mode}")
    Integer postRecord(@RequestBody Biurka biu, @PathVariable String mode) {
    	
    	switch(mode) {
    	case "add" -> {
    			biu.setIdb(null);
    			biurkaRepo.save(biu);
    		}
    	case "edit" -> {
    			biurkaRepo.save(biu);
    		}
    	}
    	return 0;
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

    
}
