package application.entity.model;

import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = false)
    private String actors;



}
