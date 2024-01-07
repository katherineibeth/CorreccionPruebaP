package ec.edu.espe.examen.Chicaiza.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen.Chicaiza.dao.DocenteRepository;
import ec.edu.espe.examen.Chicaiza.dao.EspecialidadRepository;
import ec.edu.espe.examen.Chicaiza.domain.Docente;
import ec.edu.espe.examen.Chicaiza.domain.Especialidad;
import ec.edu.espe.examen.Chicaiza.service.Exception.CreacionException;
import jakarta.transaction.Transactional;

@Service
public class DocenteService {

    private DocenteRepository docenteRepository;
    private EspecialidadRepository especialidadRepository;

    public DocenteService(DocenteRepository docenteRepository, EspecialidadRepository especialidadRepository) {
        this.docenteRepository = docenteRepository;
        this.especialidadRepository = especialidadRepository;
    }

    @Transactional
    public Docente crearDocente(Docente docente) {
        Especialidad especialidad = especialidadRepository.findByCodigo(docente.getCodEspecialidad());
        if (especialidad == null) {
            throw new RuntimeException("La especialidad con código " + docente.getCodEspecialidad() + " no existe.");
        }

        Date fechaActual = new Date(System.currentTimeMillis());
        Date fechaIngresoDocente = docente.getFechaIngreso(); 

        if (fechaIngresoDocente.before(fechaActual)) {
            throw new RuntimeException("La fecha es invalida");
        }

        try {
            return this.docenteRepository.save(docente); 
        } catch (Exception e) {
            throw new CreacionException("Error Al Crear Docente: " + docente.toString(), e);
        }
    }
}
