package ec.edu.espe.examen.Chicaiza.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Embeddable
public class DocenteMateriaPK implements Serializable{
    
    @Column(name = "COD_DOCENTE")
    private Integer codDocente;
    @Column(name = "COD_MATERIA")
    private Integer codMateria;
    
    public DocenteMateriaPK(Integer codDocente, Integer codMateria) {
        this.codDocente = codDocente;
        this.codMateria = codMateria;
    }

    @Override
    public String toString() {
        return "DocenteMateriaPK [codigoDocente=" + codDocente + ", codigoMateria=" + codMateria + "]";
    }
}
