package com.company.pokoje_srv;

import com.company.pokoje_srv.rekordy.Pokoje;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        listaPokoi.add(new Pokoje(1034,100, 5, "+48 224 444 444", "pomieszczenie gospodarcze", 1));
        listaPokoi.add(new Pokoje(519,101, 3, "+48 224 444 000", "serwerownia", 2));
        System.out.println("vvvvvvvvvvvvvvvvvvvvv");
        listaPokoi.forEach(System.out::println);
        System.out.println();
        System.out.println("^^^^^^^^^^^^^^^^^^^^^");
        model.addAttribute("pokojeList",listaPokoi);
        return "pokoje";
    }

}


