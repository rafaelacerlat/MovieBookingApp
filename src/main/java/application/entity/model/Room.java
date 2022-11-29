package application.entity.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "movie_rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @Column(name = "seats_number")
    private int seats_number;
}
