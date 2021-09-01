package main;

import modelo.Pelicula;
import singleton.FilmotecaSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Date;
import java.util.Scanner;

public class NuevaPelicula {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        EntityManagerFactory emf = FilmotecaSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            System.out.print("Introduce el título => ");
            String titulo = leer.nextLine();
            System.out.print("Introduce la fecha de estreno => ");
            String fecha = leer.nextLine();
            System.out.print("Introduce el presupuesto => ");
            Double presupuesto = leer.nextDouble();
            System.out.print("Introduce la recaudación => ");
            Double recaudacion = leer.nextDouble();
            System.out.print("Introduce el pais => ");
            leer.nextLine();
            String pais = leer.nextLine();
            Pelicula peli = new Pelicula(titulo, new Date(fecha), presupuesto, recaudacion, pais);
            em.persist(peli);
            System.out.println("El código de la película es " + peli.getId());
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
