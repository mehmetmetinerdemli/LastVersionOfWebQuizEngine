package engine.dao;

import engine.entities.Quiz;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizRepository extends PagingAndSortingRepository<Quiz, Long> {
    void save(Quiz quiz);

    void deleteById(long id);

    Optional<Quiz> findById(long id);
}