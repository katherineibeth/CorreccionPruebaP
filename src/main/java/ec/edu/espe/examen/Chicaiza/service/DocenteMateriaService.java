package ec.edu.espe.examen.Chicaiza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.espe.examen.Chicaiza.dao.DocenteMateriaRepository;
import ec.edu.espe.examen.Chicaiza.dao.DocenteRepository;
import ec.edu.espe.examen.Chicaiza.dao.MateriaRepository;
import ec.edu.espe.examen.Chicaiza.domain.Docente;
import ec.edu.espe.examen.Chicaiza.domain.DocenteMateria;
import ec.edu.espe.examen.Chicaiza.domain.Materia;

@Service
public class DocenteMateriaService {
    
     @Autowired
    private DocenteMateriaRepository docenteMateriaRepository;

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    public void asignarDocenteAMateria(DocenteMateria docenteMateria) throws DocenteNotFoundException, MateriaNotFoundException, AsignacionInvalidaException {
        Docente docente = docenteRepository.findById(docenteMateria.getDocente().getCodDocente())
                .orElseThrow(() -> new DocenteNotFoundException("Docente no encontrado"));

        Materia materia = materiaRepository.findById(docenteMateria.getMateria().getCodMateria())
                .orElseThrow(() -> new MateriaNotFoundException("Materia no encontrada"));


        docenteMateriaRepository.save(docenteMateria);
}
