package application.entity.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "cinemas")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String cinema_name;

    @Column(nullable = false)
    private String cinema_address;

}
