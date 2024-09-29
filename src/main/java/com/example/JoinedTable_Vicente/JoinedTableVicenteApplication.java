package com.example.JoinedTable_Vicente;

import com.example.JoinedTable_Vicente.entidades.Alumno;
import com.example.JoinedTable_Vicente.entidades.Profesor;
import com.example.JoinedTable_Vicente.enumeraciones.Especialidades;
import com.example.JoinedTable_Vicente.enumeraciones.Titulos;
import com.example.JoinedTable_Vicente.repositorios.AlumnoRepository;
import com.example.JoinedTable_Vicente.repositorios.PersonaRepository;
import com.example.JoinedTable_Vicente.repositorios.ProfesorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class JoinedTableVicenteApplication {
	private static final Logger logger = LoggerFactory.getLogger(JoinedTableVicenteApplication.class);

	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private ProfesorRepository profesorRepository;

	@Autowired
	private AlumnoRepository alumnoRepository;

	public static void main(String[] args) {
		SpringApplication.run(JoinedTableVicenteApplication.class, args);

		System.out.println("funcionando");
	}

	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository,
						   AlumnoRepository alumnoRepository,
						   ProfesorRepository profesorRepository) {
		return args -> {
			// Profesores
			Profesor pro1 = Profesor.builder()
					.nombre("Alberto")
					.apellido("Cortez")
					.fechaIngreso(LocalDate.of(2022, 1, 1))
					.cantHijos(2)
					.titulo(Titulos.MASTER)
					.sueldo(new BigDecimal("123.45"))
					.build();
			Profesor pro2 = Profesor.builder()
					.nombre("Daniel")
					.apellido("Perez")
					.fechaIngreso(LocalDate.of(2019, 1, 1))
					.cantHijos(3)
					.titulo(Titulos.MASTER)
					.sueldo(new BigDecimal("200.00"))
					.build();

			// Alumnos
			Alumno alum1 = Alumno.builder()
					.nombre("Vicente")
					.apellido("Cara")
					.legajo(62098)
					.especialidad(Especialidades.BACHILLER)
					.build();
			Alumno alum2 = Alumno.builder()
					.nombre("Ignacio")
					.apellido("Terracota")
					.legajo(63234)
					.especialidad(Especialidades.PERITO_MERCANTIL)
					.build();
			Alumno alum3 = Alumno.builder()
					.nombre("Mateo")
					.apellido("Muñoz")
					.legajo(62312)
					.especialidad(Especialidades.BACHILLER)
					.build();

			// Lo grabo a través del repositorio de Spring
			profesorRepository.save(pro1);
			profesorRepository.save(pro2);
			alumnoRepository.save(alum1);
			alumnoRepository.save(alum2);
			alumnoRepository.save(alum3);

		};
	}

}
