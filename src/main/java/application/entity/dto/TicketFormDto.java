package application.entity.dto;


import application.entity.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketFormDto {
    private long user_id;
    private long screening_id;
    private int seat_number;
    //private double total;
}
