package de.hsh.inform.dbs2;

import de.hsh.inform.dbs2.entities.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    private static EntityManagerFactory emf;

    public static void main(String [] args) {
        System.out.println("hello world");
        emf = Persistence.createEntityManagerFactory("movie");
        createMovie();
        printMovies();
    }

    public static void createMovie() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Movie movie = new Movie("Star Wars", "C", 1977);
        em.persist(movie);
        em.getTransaction().commit();
        em.close();
    }

    public static void printMovies() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Movie> results = em.createQuery("SELECT m FROM Movie m WHERE m.year = :year", Movie.class).setParameter("year", 1977).getResultList();
        for (Movie movie : results) {
            System.out.println("" + movie.getId() + ":" + movie.getTitle());
        }
        em.getTransaction().commit();
        em.close();
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }



}
