package ec.edu.espe.examen.Chicaiza.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.examen.Chicaiza.domain.Especialidad;

public interface EspecialidadRepository extends JpaRepository<Especialidad, String> {

    List<Especialidad> findByNombreContaining(String patronNombre);
}
