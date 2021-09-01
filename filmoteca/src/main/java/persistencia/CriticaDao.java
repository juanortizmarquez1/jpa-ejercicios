package persistencia;

import modelo.Critica;

import javax.persistence.EntityManager;
import java.util.List;

public class CriticaDao extends Dao<Critica,Long>{
    public CriticaDao(EntityManager em) {
        super(em);
    }

    @Override
    public Critica find(Long id) {
        EntityManager em = this.getEntityManager();
        return em.find(Critica.class, id);
    }

    public List<Critica> findAllCriticas(){
        return (List<Critica>) em.createQuery("select c from Critica c").getResultList();
    }
}
