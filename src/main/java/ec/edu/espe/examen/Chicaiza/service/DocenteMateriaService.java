package ec.edu.espe.examen.Chicaiza.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen.Chicaiza.dao.DocenteMateriaRepository;
import ec.edu.espe.examen.Chicaiza.dao.DocenteRepository;
import ec.edu.espe.examen.Chicaiza.dao.MateriaRepository;
import ec.edu.espe.examen.Chicaiza.domain.Docente;
import ec.edu.espe.examen.Chicaiza.domain.DocenteMateria;
import ec.edu.espe.examen.Chicaiza.domain.Materia;
import ec.edu.espe.examen.Chicaiza.service.Exception.CreacionException;


@Service
public class DocenteMateriaService {
    private final DocenteRepository docenteRepository;
    private final MateriaRepository materiaRepository;
    private final DocenteMateriaRepository docenteMateriaRepository;

    public DocenteMateriaService(DocenteRepository docenteRepository, MateriaRepository materiaRepository, DocenteMateriaRepository docenteMateriaRepository) {
        this.docenteRepository = docenteRepository;
        this.materiaRepository = materiaRepository;
        this.docenteMateriaRepository = docenteMateriaRepository;
    }

    public DocenteMateria crearDocenteMateria(DocenteMateria docenteMateria) {
        try {
            Optional<Docente> docente = docenteRepository.findById(docenteMateria.getPK().getCodDocente());
            Optional<Materia> materia = materiaRepository.findById(docenteMateria.getPK().getCodMateria());

            if (docente.isPresent() && materia.isPresent()) {
                return this.docenteMateriaRepository.save(docenteMateria);
            } else {
                throw new RuntimeException("Los datos son inválidos");
            }
        } catch (Exception e) {
            throw new CreacionException("Error al crear el registro: " + docenteMateria.toString(), e);
        }
    }
}
