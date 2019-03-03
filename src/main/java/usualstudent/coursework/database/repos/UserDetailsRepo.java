package usualstudent.coursework.database.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import usualstudent.coursework.database.entity.User;
//TODO: delete
public interface UserDetailsRepo extends JpaRepository<User, String> {
}