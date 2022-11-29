package application.service;

import application.entity.dto.*;
import application.entity.model.*;
import application.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ScreeningRepository screeningRepository;

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addMovie(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setName(movieDto.getName());
        movie.setDuration(movieDto.getDuration());
        movie.setLanguage(movieDto.getLanguage());
        movie.setActors(movieDto.getActors());
        movie.setRating(movieDto.getRating());
        movieRepository.save(movie);
    }

    public List<MovieDto> getAllMovies(){
        List<MovieDto> movies = new ArrayList<>();
        List<Movie> list = movieRepository.findAll();
        for (Movie movie : list) {
            MovieDto movieDto = new MovieDto();
            movieDto.setId(movie.getId());
            movieDto.setName(movie.getName());
            movieDto.setDuration(movie.getDuration());
            movieDto.setLanguage(movie.getLanguage());
            movieDto.setActors(movie.getActors());
            movieDto.setRating(movie.getRating());

            movies.add(movieDto);
        }
        return movies;
    }

    public MovieDto getMovieById(long id) {
        Movie movie = movieRepository.findById(id);
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setName(movie.getName());
        movieDto.setDuration(movie.getDuration());
        movieDto.setLanguage(movie.getLanguage());
        movieDto.setActors(movie.getActors());
        movieDto.setRating(movie.getRating());
        return movieDto;
    }

    public void deleteMovie(long id) {
        Movie movie = movieRepository.findById(id);
        movieRepository.delete(movie);
    }

    public void addScreening(ScreeningDto screeningDto){
        Screening screening = new Screening();
        screening.setMovie(movieRepository.findById(screeningDto.getMovie_id()));
        screening.setRoom(roomRepository.getReferenceById(screeningDto.getRoom_id()));
        screening.setScreening_date(screeningDto.getScreening_date());
        screening.setScreening_time(screeningDto.getScreening_time());
        screening.setAvailable_seats(screeningDto.getAvailable_seats());
        screeningRepository.save(screening);
    }

    public void addCinema(CinemaDto cinemaDto) {
        Cinema cinema = new Cinema();
        cinema.setCinema_name(cinemaDto.getCinema_name());
        cinema.setCinema_address(cinemaDto.getCinema_address());
        cinemaRepository.save(cinema);
    }

    public void addRoom(RoomDto roomDto){
        Room room = new Room();
        room.setCinema(cinemaRepository.getReferenceById(roomDto.getCinema_id()));
        room.setSeats_number(roomDto.getSeats_number());
        roomRepository.save(room);
    }

    public void deleteTicket(long id) {
        Ticket ticket = ticketRepository.getReferenceById(id);
        ticketRepository.delete(ticket);
    }

}
