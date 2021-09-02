import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Validation;
import javax.validation.Validator;

import static org.junit.Assert.*;

public class TestEmf {
    //private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void createEntityManagerTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("filmoteca-mysql");
        EntityManager em = emf.createEntityManager();
        assertNotNull(em);
        em.close();
    }
}
