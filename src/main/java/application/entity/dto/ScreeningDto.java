package application.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScreeningDto {
    private long id;
    private long movie_id;
    private long room_id;
    //@JsonbDateFormat(value="dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate screening_date;
    @JsonFormat(pattern="HH:mm")
    private LocalTime screening_time;
    private int[] available_seats;
}
