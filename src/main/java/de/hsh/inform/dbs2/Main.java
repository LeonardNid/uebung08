package de.hsh.inform.dbs2;

import de.hsh.inform.dbs2.entities.Genre;
import de.hsh.inform.dbs2.entities.Movie;
import de.hsh.inform.dbs2.entities.MovieCharacter;
import de.hsh.inform.dbs2.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    private static EntityManagerFactory emf;

    public static void main(String [] args) {
        System.out.println("hello world");
        emf = Persistence.createEntityManagerFactory("movie");

//        dropTable("UE08_Movie");
//        dropTable("UE08_Genre");
//        dropTable("UE08_HasGenre");
//        dropTable("UE08_MovieCharacter");
//        dropTable("UE08_Person");

        createGenre();
        createPerson();
        createMovieCharacter();
        createMovie();
        printGenres();
        printPerson();
        printMovies();
        printMovieCharacter();
    }

    public static void dropTable(String tableName) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("DROP TABLE " + tableName).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public static void createMovie() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Movie movie = new Movie("Star Wars", "C", 1977);
        movie.addGenre(1L, em);
        movie.addMovieCharacter(1L, em);
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

    public static void createGenre() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Genre genre = new Genre("Aktion");
        em.persist(genre);
        em.getTransaction().commit();
        em.close();
    }

    public static void printGenres() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Genre> results = em.createQuery("SELECT g FROM Genre g", Genre.class).getResultList();
        for (Genre genre : results) {
            System.out.println("" + genre.getId() + ":" + genre.getGenre());
        }
        em.getTransaction().commit();
        em.close();
    }

    public static void createPerson() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = new Person("Willi", "M");
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }

    public static void printPerson() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Person> results = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        for (Person person : results) {
            System.out.println("" + person.getId() + ":" + person.getName() + ":" + person.getSex());
        }
        em.getTransaction().commit();
        em.close();
    }

    public static void createMovieCharacter() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        MovieCharacter movieCharacter = new MovieCharacter("Iron-Man", "Tony Stark");
        movieCharacter.addMovie(1L, em);
        movieCharacter.addPerson(1L, em);
        em.persist(movieCharacter);
        em.getTransaction().commit();
        em.close();
    }

    public static void printMovieCharacter() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<MovieCharacter> results = em.createQuery("SELECT mc FROM MovieCharacter mc", MovieCharacter.class).getResultList();
        for (MovieCharacter movieCharacter : results) {
            System.out.println("" + movieCharacter.getId() + ":" + movieCharacter.getCharacter() + ":" + movieCharacter.getAlias());
        }
        em.getTransaction().commit();
        em.close();
    }
}
