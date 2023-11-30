package de.hsh.inform.dbs2.entities;

import jakarta.persistence.*;

@Entity()
@Table(name = "UE08_GENRE")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String genre;

    public Genre(String genre) {

        this.genre = genre;
    }
    public Genre(Long genreid, String genre) {
        this.id = genreid;
        this.genre = genre;
    }

    public Genre() {

    }

    public Long getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }
}
