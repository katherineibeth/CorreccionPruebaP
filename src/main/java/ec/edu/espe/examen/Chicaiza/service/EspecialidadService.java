package ec.edu.espe.examen.Chicaiza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.espe.examen.Chicaiza.dao.EspecialidadRepository;
import ec.edu.espe.examen.Chicaiza.domain.Especialidad;

@Service
public class EspecialidadService {

     @Autowired
    private EspecialidadRepository especialidadRepository;

    public void crearEspecialidad(Especialidad especialidad) {
        especialidadRepository.save(especialidad);
    }

    public List<Especialidad> obtenerEspecialidadesPorNombre(String patronNombre) {
        return especialidadRepository.findByNombreContaining(patronNombre);
    }
    
}
