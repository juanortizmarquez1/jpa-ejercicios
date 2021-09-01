package main;

import modelo.Critica;
import modelo.Pelicula;
import singleton.FilmotecaSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Scanner;

public class NuevaCritica {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        EntityManagerFactory emf = FilmotecaSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            System.out.print("Introduce el nombre del crítico => ");
            String critico = leer.nextLine();
            System.out.print("Introduce el texto de la crítica => ");
            String texto = leer.nextLine();
            System.out.print("Introduce la valoración => ");
            Integer valoracion = leer.nextInt();
            System.out.print("Introduce el código de la película => ");
            Long codigo = leer.nextLong();
            Pelicula p = em.find(Pelicula.class, codigo);
            if(p == null){
                System.out.println("No existe ninguna película con ese código");
                em.getTransaction().rollback();
            }else{
                Critica c = new Critica(critico, texto, valoracion, p);
                em.persist(c);
                System.out.println("El id de la critica es " + c.getId());
                em.getTransaction().commit();
            }

        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            em.close();
            emf.close();
        }

    }
}
