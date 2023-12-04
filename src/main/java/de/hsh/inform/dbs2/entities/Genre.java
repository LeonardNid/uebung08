package de.hsh.inform.dbs2.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity()
@Table(name = "UE08_GENRE")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String genre;
    @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies = new HashSet<>();

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
