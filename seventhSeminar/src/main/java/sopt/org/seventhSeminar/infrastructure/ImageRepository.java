package sopt.org.seventhSeminar.infrastructure;


import org.springframework.data.repository.Repository;
import sopt.org.seventhSeminar.domain.Image;

public interface ImageRepository extends Repository<Image, Long> {
    // CREATE
    void save(Image image);
}
