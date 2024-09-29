package com.example.JoinedTable_Vicente.repositorios;

import com.example.JoinedTable_Vicente.entidades.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository <Profesor, Long> {
}
