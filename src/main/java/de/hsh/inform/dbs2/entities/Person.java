package de.hsh.inform.dbs2.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity()
@Table(name = "UE08_PERSON")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sex;
    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    private Set<MovieCharacter> movieCharacters = new HashSet<>();

    public Person(Long personID, String name, String sex) {
        this.id = personID;
        this.name = name;
        this.sex =sex;
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public Person() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }
}
