package sopt.org.seventhSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.seventhSeminar.domain.Board;

public interface BoardRepository extends Repository<Board, Long> {

    // CREATE
    void save(Board board);

    // READ

    // UPDATE

    // DELETE
}
