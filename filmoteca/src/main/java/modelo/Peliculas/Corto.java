package modelo.Peliculas;

import modelo.Pelicula;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("Corto")
public class Corto extends Pelicula {
    Double duracion;

    public Corto(String titulo, Date estreno, Double presupuesto, Double recaudacion, String pais, Double duracion) {
        super(titulo, estreno, presupuesto, recaudacion, pais);
        this.duracion = duracion;
    }

    public Corto() {

    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    @Override
    public String tipo() {
        return "Corto";
    }
}
