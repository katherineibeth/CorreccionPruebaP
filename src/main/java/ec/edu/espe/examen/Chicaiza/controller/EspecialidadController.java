package ec.edu.espe.examen.Chicaiza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen.Chicaiza.domain.Especialidad;
import ec.edu.espe.examen.Chicaiza.service.EspecialidadService;

@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {
    
    @Autowired
    private EspecialidadService especialidadService;

    @PostMapping
    public ResponseEntity<Void> crearEspecialidad(@RequestBody Especialidad especialidad) {
        especialidadService.crearEspecialidad(especialidad);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Especialidad>> obtenerEspecialidadesPorNombre(@RequestParam String patronNombre) {
        List<Especialidad> especialidades = especialidadService.obtenerEspecialidadesPorNombre(patronNombre);
        return new ResponseEntity<>(especialidades, HttpStatus.OK);
    }
}
