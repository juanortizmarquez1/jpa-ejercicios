package personalizado;

import modelo.Pelicula;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.hibernate.LazyInitializationException;
import org.junit.BeforeClass;
import org.junit.Test;
import singleton.FilmotecaSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.*;

public class TestPersonalizados {
    private static EntityManagerFactory emf;
    private static IDatabaseConnection connection;
    private static IDataSet dataset;

    @BeforeClass
    public static void initDatabaseTest() {
        try {
            // Inicializamos sólo una vez el emf antes de todos los tests
            emf = FilmotecaSingleton.getInstance().getEmf();
            // Inicializamos la conexión a la BD necesaria para que DBUnit cargue los datos de los tests
            Class.forName("com.mysql.jdbc.Driver");
            Connection jdbcConnection = (Connection) DriverManager
                    .getConnection(
                            "jdbc:mysql://localhost:3306/jpa_mensajes", "root", "root");

            connection = new DatabaseConnection(jdbcConnection);
            FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
            flatXmlDataSetBuilder.setColumnSensing(true);
            dataset = flatXmlDataSetBuilder.build(Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("dbunit/dataset1.xml"));

        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Excepción al inicializar el emf y DbUnit");
        }
    }

    @Test
    public void compruebaLazy() {
        emf = FilmotecaSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        Pelicula pelicula = em.find(Pelicula.class, 1L);
        em.close();
        try{
            assertEquals(2, pelicula.getCriticas().size());
        }catch (LazyInitializationException liz){
            fail("No se pueden cargar los datos porque están de tipo Lazy");
        }
    }

}
