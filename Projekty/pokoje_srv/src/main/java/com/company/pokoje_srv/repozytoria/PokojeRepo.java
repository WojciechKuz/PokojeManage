package com.company.pokoje_srv.repozytoria;

import com.company.pokoje_srv.rekordy.Pokoje;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PokojeRepo extends JpaRepository<Pokoje, Integer>
{

}
