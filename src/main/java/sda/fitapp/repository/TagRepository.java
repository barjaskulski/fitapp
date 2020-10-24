package sda.fitapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.fitapp.entity.TagEntity;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<TagEntity,Long>{
    Optional<TagEntity> findById(Long id);
    Optional<TagEntity> findFirstByName(String name);
}
