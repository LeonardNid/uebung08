package de.hsh.inform.dbs2.entities;

import de.hsh.inform.dbs2.Main;
import jakarta.persistence.*;

@Entity()
@Table(name = "UE08_MOVIECHARACTER")
public class MovieCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String character;
    private String alias;
    private Integer position;

    @ManyToOne
    @JoinColumn(name = "movieid")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "personid")
    private Person person;


    public MovieCharacter(Long movCharID, String character, String alias) {
        this.id = movCharID;
        this.character = character;
        this.alias = alias;
    }
    public MovieCharacter(String character, String alias) {
        this.character = character;
        this.alias = alias;
    }

    public MovieCharacter() {

    }

    public void addMovie(Long movieId, EntityManager em) {
        this.movie = em.find(Movie.class, movieId);
    }

    public void addPerson(Long personId, EntityManager em) {
        this.person = em.find(Person.class, personId);
    }

    public Long getId() {
        return id;
    }

    public String getCharacter() {
        return character;
    }

    public String getAlias() {
        return alias;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
