package sda.fitapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.fitapp.entity.User;
import sda.fitapp.entity.UserSex;

import java.util.List;

@Repository
public interface UserRepositories extends JpaRepository<User,Long>{

    //List<User> findUserBySex(UserSex userSex);
}
