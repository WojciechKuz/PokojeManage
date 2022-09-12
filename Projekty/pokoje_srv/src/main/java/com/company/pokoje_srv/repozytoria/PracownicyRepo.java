package com.company.pokoje_srv.repozytoria;

import com.company.pokoje_srv.rekordy.Pracownicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PracownicyRepo extends JpaRepository<Pracownicy, Integer>
{

}