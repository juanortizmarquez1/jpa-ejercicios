package main;

import modelo.Pelicula;
import modelo.Peliculas.Corto;
import services.PeliculaServicio;
import singleton.FilmotecaSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Date;
import java.util.Scanner;

public class NuevaPelicula {
    static PeliculaServicio service = new PeliculaServicio();
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
            Pelicula peli = new Corto(titulo, new Date(fecha), presupuesto, recaudacion, pais, 30.5);
            em.persist(peli);
            System.out.println("El código de la película es " + peli.getId());
            em.getTransaction().commit();


            System.out.println("\n\n\n\nVamos a crear otra\nCodigo => " + service.creaPelicula("Titulo2", new Date(121, 9, 2), "España", 0.0, "Animales"));
            System.out.println("Y modificamos la recaudación de la película 3");
            service.actualizaRecaudacionPelicula(10l, 120.0);
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            em.close();
            emf.close();
        }

    }
}
