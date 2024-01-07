package ec.edu.espe.examen.Chicaiza.controller;

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
    
   
    private DocenteService docenteService;

    public DocenteController(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    @PostMapping("/crear")
    public ResponseEntity<Docente> Guardar(@RequestBody Docente docente) {
        return new ResponseEntity<>(docenteService.crearDocente(docente), HttpStatus.OK);
    }
}
