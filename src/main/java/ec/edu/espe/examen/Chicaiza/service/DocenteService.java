package ec.edu.espe.examen.Chicaiza.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.espe.examen.Chicaiza.dao.DocenteRepository;
import ec.edu.espe.examen.Chicaiza.dao.EspecialidadRepository;
import ec.edu.espe.examen.Chicaiza.domain.Docente;
import ec.edu.espe.examen.Chicaiza.domain.Especialidad;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public void crearDocente(Docente docente) throws EntityNotFoundException, FechaIngresoInvalidaException {
        Especialidad especialidad = especialidadRepository.findById(docente.getCodEspecialidad())
                .orElseThrow(() -> new EntityNotFoundException("Especialidad no encontrada"));

        if (docente.getFechaIngreso().before(new Date())) {
            throw new Exception("La fecha de ingreso debe ser mayor a la fecha actual");
        }

        docente.setCodEspecialidad(especialidad);
        docenteRepository.save(docente);
    }
}

