package modelo.Peliculas;

import modelo.Pelicula;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue(value = "Largometraje")
public class Largometraje extends Pelicula {
    int numActores;

    public Largometraje(String titulo, Date estreno, Double presupuesto, Double recaudacion, String pais, int numActores) {
        super(titulo, estreno, presupuesto, recaudacion, pais);
        this.numActores = numActores;
    }

    public Largometraje() {}

    public int getNumActores() {
        return numActores;
    }

    public void setNumActores(int numActores) {
        this.numActores = numActores;
    }

    @Override
    public String tipo() {
        return null;
    }
}
