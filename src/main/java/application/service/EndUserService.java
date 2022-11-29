package application.service;

import application.entity.dto.BookedTicketDto;
import application.entity.dto.ScreeningDto;
import application.entity.dto.ShowScreeningDto;
import application.entity.dto.TicketFormDto;
import application.entity.model.Screening;
import application.entity.model.Ticket;
import application.entity.model.User;
import application.repository.MovieRepository;
import application.repository.ScreeningRepository;
import application.repository.TicketRepository;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EndUserService {

    @Autowired
    private ScreeningRepository screeningRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private MovieRepository movieRepository;


    public List<Screening> getAllScreenings(){
        return screeningRepository.findAll();
    }

    public List<Screening> findScreeningsByMovieName(String movieName){
        return screeningRepository.findByMovieName(movieName);
    }

    public BookedTicketDto bookTicketForMovie(TicketFormDto ticketFormDto) throws Exception {


        User user = userRepository.getById(ticketFormDto.getUser_id());
        Screening screening = screeningRepository.getById(ticketFormDto.getScreening_id());

        if (Arrays.stream(screening.getAvailable_seats()).anyMatch(i -> i == ticketFormDto.getSeat_number())){
            Ticket ticket = new Ticket();
            ticket.setUser(user);
            ticket.setScreening(screening);
            ticket.setSeat_number(ticketFormDto.getSeat_number());
            ticketRepository.save(ticket);

            BookedTicketDto bookedTicketDto = new BookedTicketDto();

            bookedTicketDto.setUsername(user.getFirstName());
            bookedTicketDto.setMovie_name(screening.getMovie().getName());
            bookedTicketDto.setMovie_language(screening.getMovie().getLanguage());
            bookedTicketDto.setScreening_date(screening.getScreening_date());
            bookedTicketDto.setScreening_time(screening.getScreening_time());
            bookedTicketDto.setCinema_name(screening.getRoom().getCinema().getCinema_name());
            bookedTicketDto.setCinema_address(screening.getRoom().getCinema().getCinema_address());
            bookedTicketDto.setRoom_id(screening.getRoom().getId());
            bookedTicketDto.setSeat_number(ticketFormDto.getSeat_number());

            screeningRepository.updateAvailableSeats(ticketFormDto.getScreening_id(), ticketFormDto.getSeat_number());

            return bookedTicketDto;
        }
        else {
            throw new Exception("This seat number is not available");
        }

    }

    public List<BookedTicketDto> getTicketsByUserId(long id){
        List<Ticket> tickets = ticketRepository.findByUserId(id);

        List<BookedTicketDto> userTickets= new ArrayList<>();
        for(Ticket ticket: tickets){
            BookedTicketDto bookedTicketDto = new BookedTicketDto();
            bookedTicketDto.setUsername(ticket.getUser().getFirstName());
            bookedTicketDto.setMovie_name(ticket.getScreening().getMovie().getName());
            bookedTicketDto.setMovie_language(ticket.getScreening().getMovie().getLanguage());
            bookedTicketDto.setScreening_date(ticket.getScreening().getScreening_date());
            bookedTicketDto.setScreening_time(ticket.getScreening().getScreening_time());
            bookedTicketDto.setCinema_name(ticket.getScreening().getRoom().getCinema().getCinema_name());
            bookedTicketDto.setCinema_address(ticket.getScreening().getRoom().getCinema().getCinema_address());
            bookedTicketDto.setRoom_id(ticket.getScreening().getRoom().getId());
            bookedTicketDto.setSeat_number(ticket.getSeat_number());
        }

        return userTickets;
    }
}
