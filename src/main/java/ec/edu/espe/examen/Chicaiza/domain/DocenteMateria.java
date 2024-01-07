package ec.edu.espe.examen.Chicaiza.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DOCENTE_MATERIA")
public class DocenteMateria {

    @Id
    @ManyToOne
    @JoinColumn(name = "COD_DOCENTE", nullable = false)
    private Docente docente;

    @Id
    @ManyToOne
    @JoinColumn(name = "COD_MATERIA", nullable = false)
    private Materia materia;

    @Column(name = "PERIODO", nullable = false, length = 10)
    private String periodo;

    @Column(name = "ALUMNOS_MATRICULADOS", nullable = false)
    private Integer alumnosMatriculados;

    @Column(name = "ESTADO", nullable = false, length = 3)
    private String estado;

    @Column(name = "PROMEDIO_CURSO", nullable = false)
    private Double promedioCurso;

    @Column(name = "FECHA_ULTIMO_CAMBIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaUltimoCambio;

    public DocenteMateria() {
    }

    public DocenteMateria(Docente docente, Materia materia) {
        this.docente = docente;
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "DocenteMateria [docente=" + docente + ", materia=" + materia + ", periodo=" + periodo
                + ", alumnosMatriculados=" + alumnosMatriculados + ", estado=" + estado + ", promedioCurso="
                + promedioCurso + ", fechaUltimoCambio=" + fechaUltimoCambio + "]";
    }

    

}
