package application.entity.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    private long id;
    private String name;
    private String duration;
    private String language;
    private int rating;
    private String actors;
}
