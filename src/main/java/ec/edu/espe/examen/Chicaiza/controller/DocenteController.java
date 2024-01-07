package ec.edu.espe.examen.Chicaiza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen.Chicaiza.domain.Docente;
import ec.edu.espe.examen.Chicaiza.service.DocenteService;

@RestController
@RequestMapping("/docente")
public class DocenteController {
    
    @Autowired
    private DocenteService docenteService;

    @PostMapping
    public ResponseEntity<Void> crearDocente(@RequestBody Docente docente) {
        try {
            docenteService.crearDocente(docente);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (EspecialidadNotFoundException | FechaIngresoInvalidaException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
