package modelo;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String titulo;
    Date estreno;
    Double presupuesto;
    Double recaudacion;
    String pais;
    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Critica> criticas = new HashSet<>();

    public Pelicula() {}

    public Pelicula(String titulo, Date estreno, Double presupuesto, Double recaudacion, String pais) {
        this.titulo = titulo;
        this.estreno = estreno;
        this.presupuesto = presupuesto;
        this.recaudacion = recaudacion;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getEstreno() {
        return estreno;
    }

    public void setEstreno(Date estreno) {
        this.estreno = estreno;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Double getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(Double recaudacion) {
        this.recaudacion = recaudacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Set<Critica> getCriticas() {
        return criticas;
    }

    public void setCriticas(Set<Critica> criticas) {
        this.criticas = criticas;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", estreno=" + estreno +
                ", presupuesto=" + presupuesto +
                ", recaudacion=" + recaudacion +
                ", pais='" + pais + '\'' +
                '}';
    }
}
