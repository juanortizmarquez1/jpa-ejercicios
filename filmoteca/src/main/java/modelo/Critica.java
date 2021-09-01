package modelo;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Critica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String critico;
    String texto;
    @Range(min = 1, max = 10)
    Integer valoracion;
    @ManyToOne
    @JoinColumn(name = "pelicula", nullable = false)
    Pelicula pelicula;

    public Critica() {}

    public Critica(String critico, String texto, Integer valoracion, Pelicula pelicula) {
        this.critico = critico;
        this.texto = texto;
        this.valoracion = valoracion;
        this.pelicula = pelicula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCritico() {
        return critico;
    }

    public void setCritico(String critico) {
        this.critico = critico;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "Critica{" +
                "id=" + id +
                ", critico='" + critico + '\'' +
                ", texto='" + texto + '\'' +
                ", valoracion=" + valoracion +
                ", pelicula=" + pelicula.getTitulo() +
                '}';
    }
}
