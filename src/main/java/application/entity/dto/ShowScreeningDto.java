package application.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowScreeningDto {
    private long id;
    private String movie_id;
    private long room_id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate screening_date;

    @JsonFormat(pattern="HH:mm")
    private LocalTime screening_time;

    private int[] available_seats;
}
