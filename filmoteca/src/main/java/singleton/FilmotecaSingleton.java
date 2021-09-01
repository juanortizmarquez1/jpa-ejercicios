package singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FilmotecaSingleton {
    private static FilmotecaSingleton instance = new FilmotecaSingleton();
    static private final String PERSISTENCE_UNIT_NAME = "filmoteca-mysql";
    private EntityManagerFactory emf = null;

    public static FilmotecaSingleton getInstance() {
        return instance;
    }

    public FilmotecaSingleton() {
    }

    public EntityManagerFactory getEmf() {
        if(this.emf == null)
            this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        return emf;
    }
}
