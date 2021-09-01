package main;

import modelo.Autor;
import singleton.MensajeSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ModificaAutor {
    public static void main(String[] args) {
        EntityManagerFactory emf = MensajeSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            Autor autor = em.find(Autor.class, new Long(1));
            autor.setNombre("Manolillo");
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            em.close();
            emf.close();
        }
    }
}
