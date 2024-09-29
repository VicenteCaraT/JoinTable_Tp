package com.example.JoinedTable_Vicente.repositorios;

import com.example.JoinedTable_Vicente.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository <Persona, Long> {
}
