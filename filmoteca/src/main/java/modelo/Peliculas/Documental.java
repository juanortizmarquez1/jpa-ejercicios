package modelo.Peliculas;

import modelo.Pelicula;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("Documental")
public class Documental extends Pelicula {
    String tematica;

    public Documental(String titulo, Date estreno, Double presupuesto, Double recaudacion, String pais, String tematica) {
        super(titulo, estreno, presupuesto, recaudacion, pais);
        this.tematica = tematica;
    }

    public Documental() {

    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    @Override
    public String tipo() {
        return "Documental";
    }
}
