package application.repository;

import application.entity.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    List<Screening> findByMovieName(String movieName);
    Screening getById(long id);

    @Modifying
    @Transactional
    @Query(value = "update movie_screenings set available_seats = array_remove(available_seats, :seat_number) where id= :screening_id"
            , nativeQuery = true)
    void updateAvailableSeats(@Param("screening_id") long screening_id, @Param("seat_number") int seat_number);
}
