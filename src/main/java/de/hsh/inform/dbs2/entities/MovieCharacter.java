package de.hsh.inform.dbs2.entities;

import de.hsh.inform.dbs2.Main;
import jakarta.persistence.*;

@Entity()
@Table(name = "UE08_MOVIECHARACTER")
public class MovieCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movcharid")
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
    public MovieCharacter(Long movCharID, String character, String alias, Integer position, Long movieID, Long personID) {
        this.id = movCharID;
        this.character = character;
        this.alias = alias;
        this.position = position;
        // Laden Sie das zugehörige Movie-Objekt aus der Datenbank
        EntityManager entityManager = Main.getEmf().createEntityManager();
        this.movie = entityManager.find(Movie.class, id);
//        this.movie = new Movie(movieID); // Erstellen Sie eine Movie-Instanz mit der angegebenen movieID
//        this.person = new Person(personID); // Erstellen Sie eine Person-Instanz mit der angegebenen personID
    }
    public MovieCharacter(String character, String alias, Integer position, Long movieID, Long personID) {
        this.character = character;
        this.alias = alias;
        this.position = position;
//        this.movie = new Movie(movieID); // Erstellen Sie eine Movie-Instanz mit der angegebenen movieID
//        this.person = new Person(personID); // Erstellen Sie eine Person-Instanz mit der angegebenen personID
    }

    public MovieCharacter() {

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

}
