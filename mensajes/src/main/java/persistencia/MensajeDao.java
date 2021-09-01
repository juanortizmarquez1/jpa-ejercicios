package persistencia;

import modelo.Mensaje;

import javax.persistence.EntityManager;
import java.util.List;

public class MensajeDao extends Dao<Mensaje, Long> {
    private String query = "select m from Mensaje m";
    public MensajeDao(EntityManager em) {
        super(em);
    }

    @Override
    public Mensaje find(Long id) {
        EntityManager em = this.getEntityManager();
        return em.find(Mensaje.class, id);
    }

    public List<Mensaje> findAllMessages(){
        EntityManager em = this.getEntityManager();
        return (List<Mensaje>) em.createQuery(query).getResultList();
    }
}
