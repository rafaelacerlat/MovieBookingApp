package application.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookedTicketDto {
    private String username;
    private String movie_name;
    private String movie_language;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate screening_date;
    private LocalTime screening_time;
    private String cinema_name;
    private String cinema_address;
    private long room_id;
    private int seat_number;
}
