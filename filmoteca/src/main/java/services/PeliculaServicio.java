package services;

import com.mysql.cj.protocol.x.XProtocolDecoder;
import modelo.Pelicula;
import modelo.Peliculas.Corto;
import modelo.Peliculas.Documental;
import modelo.Peliculas.Largometraje;
import persistencia.PeliculaDao;
import singleton.FilmotecaSingleton;

import java.util.Date;
import java.util.List;

public class PeliculaServicio {
    PeliculaDao peliculaDao = new PeliculaDao(FilmotecaSingleton.getInstance().getEmf().createEntityManager());

    public long creaPelicula(String titulo, Date fechaEstreno, String pais, Double presupuesto, Double duracion) {
        peliculaDao.getEntityManager().getTransaction().begin();
        Pelicula p = new Corto(titulo, fechaEstreno, presupuesto, 0.0, pais, duracion);
        try {
            peliculaDao.create(p);
            peliculaDao.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            peliculaDao.getEntityManager().getTransaction().rollback();
            e.printStackTrace();
        }
        return p.getId();
    }

    public long creaPelicula(String titulo, Date fechaEstreno, String pais, Double presupuesto, int numActores) {
        peliculaDao.getEntityManager().getTransaction().begin();
        Pelicula p = new Largometraje(titulo, fechaEstreno, presupuesto, 0.0, pais, numActores);
        try {
            peliculaDao.create(p);
            peliculaDao.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            peliculaDao.getEntityManager().getTransaction().rollback();
            e.printStackTrace();
        }
        return p.getId();
    }

    public long creaPelicula(String titulo, Date fechaEstreno, String pais, Double presupuesto, String tematica) {
        peliculaDao.getEntityManager().getTransaction().begin();
        Pelicula p = null;
        try {
            p = peliculaDao.create(new Documental(titulo, fechaEstreno, presupuesto, 0.0, pais, tematica));
            peliculaDao.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            peliculaDao.getEntityManager().getTransaction().rollback();
            e.printStackTrace();
        }
        return p.getId();
    }

    public void actualizaRecaudacionPelicula (Long idPelicula, Double recaudacion){
        peliculaDao.getEntityManager().getTransaction().begin();
        try {
            Pelicula p = peliculaDao.getEntityManager().find(Pelicula.class, idPelicula);
            if (p != null) {
                p.setRecaudacion(recaudacion);
            } else {
                throw new Exception("No se ha encontrado la película con ese ID");
            }
            peliculaDao.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            peliculaDao.getEntityManager().getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void borraTodasSinRecaudacion(List<Pelicula> pelis){
        for(Pelicula p : pelis){
            if(p.getRecaudacion() == 0.0){
                peliculaDao.delete(p);
            }
        }
    }
}
