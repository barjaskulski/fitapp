package sda.fitapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.fitapp.entity.Tag;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long>{
    Optional<Tag> findById(Long id);
}
