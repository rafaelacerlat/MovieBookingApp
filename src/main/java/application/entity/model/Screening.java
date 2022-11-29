package application.entity.model;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import com.vladmihalcea.hibernate.type.array.IntArrayType;

import javax.persistence.*;
import java.time.*;


@Data
@Entity
@Table(name = "movie_screenings")
@TypeDefs({
        @TypeDef(
                name = "integer-array",
                typeClass = IntArrayType.class
        )
})
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    private LocalDate screening_date;

    private LocalTime screening_time;

    @Type(type = "integer-array")
    @Column(columnDefinition = "integer[]")
    private int[] available_seats;

}
