package application.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CinemaDto {
    private long id;
    private String cinema_name;
    private String cinema_address;
}
