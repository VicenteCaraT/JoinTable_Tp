package com.example.JoinedTable_Vicente.repositorios;

import com.example.JoinedTable_Vicente.entidades.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository <Alumno, Long> {
}
