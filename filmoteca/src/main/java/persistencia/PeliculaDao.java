package persistencia;

import modelo.Pelicula;

import javax.persistence.EntityManager;
import java.util.List;

public class PeliculaDao extends Dao<Pelicula, Long> {

    public PeliculaDao(EntityManager em) {
        super(em);
    }

    @Override
    public Pelicula find(Long id) {
        EntityManager em = this.getEntityManager();
        return em.find(Pelicula.class, id);
    }

    public List<Pelicula> findAllFilms(){
        EntityManager em = this.getEntityManager();
        return (List<Pelicula>) em.createQuery("select f from Pelicula f").getResultList();
    }
}
