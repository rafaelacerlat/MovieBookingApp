package application.repository;

import application.entity.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    //Movie findByMovieName(String movieName);
    Movie findById(long movieId);
}
