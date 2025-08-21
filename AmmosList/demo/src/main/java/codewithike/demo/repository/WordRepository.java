package codewithike.demo.repository;

import codewithike.demo.models.Word;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface WordRepository extends JpaRepository<Word, Integer> {

    // All rows that share the most recent timestamp (ties included)
    @Query("""
           SELECT w FROM Word w
           WHERE w.createdAt = (SELECT MAX(w2.createdAt) FROM Word w2)
           """)
    List<Word> findAllFromMostRecentInstant();

    //find all based on a limited number
    default List<Word> findMostRecent(int limit) {
        return findAll(PageRequest.of(0, limit, Sort.by(Sort.Direction.DESC, "createdAt")))
                .getContent();
    }
}
