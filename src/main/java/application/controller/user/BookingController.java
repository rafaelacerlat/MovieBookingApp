package application.controller.user;

import application.entity.dto.TicketFormDto;
import application.service.EndUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class BookingController {

    @Autowired
    EndUserService endUserService;

    @PostMapping("/movie/screenings/screening/book")
    public ResponseEntity<Object> bookMovieTicket(@RequestBody TicketFormDto ticketFormDto) {
        try {
            return new ResponseEntity<>(endUserService.bookTicketForMovie(ticketFormDto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/screenings")
    public ResponseEntity<Object> getAllScreenings() {
        try {
            return new ResponseEntity<>(endUserService.getAllScreenings(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{movieName:[a-zA-Z &+-]*}/screenings")
    public ResponseEntity<Object> getScreeningsByMovie(@PathVariable String movieName) {
        try {
            return new ResponseEntity<>(endUserService.findScreeningsByMovieName(movieName), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
