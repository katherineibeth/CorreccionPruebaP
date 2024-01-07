package ec.edu.espe.examen.Chicaiza.service;


import org.springframework.stereotype.Service;

import ec.edu.espe.examen.Chicaiza.dao.EspecialidadRepository;
import ec.edu.espe.examen.Chicaiza.domain.Especialidad;
import ec.edu.espe.examen.Chicaiza.service.Exception.CreacionException;
import jakarta.transaction.Transactional;

@Service
public class EspecialidadService {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadService(EspecialidadRepository especialidadRepository){
        this.especialidadRepository = especialidadRepository;
    }

    @Transactional
    public Especialidad crearEspecialidad(Especialidad especialidad) {
        try {
            return this.especialidadRepository.save(especialidad);
        } catch (Exception e) {
            throw new CreacionException("No se pudo crear la Especialidad: " + especialidad.toString(), e);
        }
    }

    public Especialidad buscarPatron(String patron) {
        try{
            return especialidadRepository.findByCodigo(patron);
        } catch (Exception e) {
            throw new RuntimeException("La Especialidad y Patron no existen: " + patron, e);
        }
        
    }
    
}
