package ec.edu.espe.examen.Chicaiza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ec.edu.espe.examen.Chicaiza.domain.DocenteMateria;
import ec.edu.espe.examen.Chicaiza.service.DocenteMateriaService;

public class DocenteMateriaController {

    @Autowired
    private DocenteMateriaService planificacionService;

    @PostMapping("/asignar")
    public ResponseEntity<Void> asignarDocenteAMateria(@RequestBody DocenteMateria docenteMateria) {
        try {
            planificacionService.asignarDocenteAMateria(docenteMateria);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DocenteNotFoundException | MateriaNotFoundException | AsignacionInvalidaException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
