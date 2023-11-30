package de.hsh.inform.dbs2.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(name = "UE08_MOVIE")
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String type;

    private int year;
//    @OneToMany(mappedBy = "movie", cascade = CascadeType.PERSIST)
//    private ArrayList<MovieCharacter> movieCharacters;

    public Movie(Long movieid, String title, Integer year, String type) {
        this.id = movieid;
        this.title = title;
        this.year = year;
        this.type =type;
    }

    public Movie(String title, String type, int year) {
        this.title = title;
        this.type = type;
        this.year = year;
    }

    public Movie() {

    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }
}
