package sda.fitapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.fitapp.entity.UserEntity;

@Repository
public interface UserRepositories extends JpaRepository<UserEntity,Long>{

    //List<User> findUserBySex(UserSex userSex);
}
