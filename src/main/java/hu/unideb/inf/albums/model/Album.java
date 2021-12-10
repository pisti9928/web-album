package hu.unideb.inf.albums.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data   //getter, setter, tostring, equals, hashcode
@NoArgsConstructor
public class Album implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String artist;
    private String title;
    private String releaseDate;
    private String genre;   //műfaj
    private String rating;
}
