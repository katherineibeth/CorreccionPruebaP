package ec.edu.espe.examen.Chicaiza.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen.Chicaiza.domain.DocenteMateria;
import ec.edu.espe.examen.Chicaiza.service.DocenteMateriaService;

@RestController
@RequestMapping("/docente-materia")
public class DocenteMateriaCotroller {

    private final DocenteMateriaService docenteMateriaService;

    public DocenteMateriaCotroller(DocenteMateriaService docenteMateriaService) {
        this.docenteMateriaService = docenteMateriaService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<DocenteMateria> GuardarPM(@RequestBody DocenteMateria docenteMateria){
        return new ResponseEntity<>(docenteMateriaService.crearDocenteMateria(docenteMateria), HttpStatus.OK);
    }
}
