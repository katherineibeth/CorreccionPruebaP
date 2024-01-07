package ec.edu.espe.examen.Chicaiza.dao;


import org.springframework.data.repository.CrudRepository;

import ec.edu.espe.examen.Chicaiza.domain.Especialidad;


public interface EspecialidadRepository extends CrudRepository<Especialidad, String> {

    public Especialidad findByCodigo(String codEspecialidad);
}
