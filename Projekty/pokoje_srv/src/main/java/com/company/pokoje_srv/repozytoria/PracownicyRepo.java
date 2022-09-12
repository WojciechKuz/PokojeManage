package com.company.pokoje_srv.repozytoria;

import com.company.pokoje_srv.rekordy.Pracownicy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface PracownicyRepo extends JpaRepository<Pracownicy, Integer>
{
    Pracownicy deleteByZatrudnienieDoBefore(Date date);
}