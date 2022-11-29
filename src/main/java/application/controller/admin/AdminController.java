package application.controller.admin;

import application.entity.dto.CinemaDto;
import application.entity.dto.MovieDto;
import application.entity.dto.RoomDto;
import application.entity.dto.ScreeningDto;
import application.entity.model.User;
import application.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @PostMapping("/users/add")
    public ResponseEntity<Object> addNewUser(@RequestBody User user) {
        try {
            adminService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers() {
        try {
            return new ResponseEntity<>(adminService.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/movies/add")
    public ResponseEntity<Object> addNewMovie(@RequestBody MovieDto movieDto) {
        try {
            adminService.addMovie(movieDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/movies")
    public ResponseEntity<Object> getAllMovies() {
        try {
            return new ResponseEntity<>(adminService.getAllMovies(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Object> getMovieById(@PathVariable long id) {
        try {
            return new ResponseEntity<>(adminService.getMovieById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/movies/screenings/add")
    public ResponseEntity<Object> addNewMovieScreening(@RequestBody ScreeningDto screeningDto) {
        try{
            adminService.addScreening(screeningDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/cinemas/add")
    public ResponseEntity<Object> addNewCinema(@RequestBody CinemaDto cinemaDto) {
        try{
            adminService.addCinema(cinemaDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/cinemas/rooms/add")
    public ResponseEntity<Object> addNewCinemaRoom(@RequestBody RoomDto room) {
        try{
            adminService.addRoom(room);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/tickets/{id}")
    public void deleteTickets(@PathVariable long id){
        adminService.deleteTicket(id);
    }



}
