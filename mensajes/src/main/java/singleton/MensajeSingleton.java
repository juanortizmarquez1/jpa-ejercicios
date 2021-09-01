package singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MensajeSingleton {
    private static MensajeSingleton instance = new MensajeSingleton();
    static private final String PERSISTENCE_UNIT_NAME = "mensajes-mysql";
    private EntityManagerFactory emf = null;

    public static MensajeSingleton getInstance() {
        return instance;
    }

    public MensajeSingleton() {
    }

    public EntityManagerFactory getEmf() {
        if(this.emf == null)
            this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        return emf;
    }
}
