package persistencia;

import modelo.Autor;

import javax.persistence.EntityManager;
import java.util.List;

public class AutorDao extends Dao<Autor, Long> {
    String query = "select a from Autor a";

    public AutorDao(EntityManager em) {
        super(em);
    }

    @Override
    public Autor find(Long id) {
        EntityManager em = this.getEntityManager();
        return em.find(Autor.class, id);
    }

    public List<Autor> findAllAutores() {
        EntityManager em = this.getEntityManager();
        return (List<Autor>) em.createQuery(query).getResultList();
    }
}
