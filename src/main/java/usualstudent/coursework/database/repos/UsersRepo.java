package usualstudent.coursework.database.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import usualstudent.coursework.database.entity.Users;

/**
 * Репозиторий пользователей
 */
@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {

    @Query(value = "select u from Users u where u.userName = :name")
    Users findByName(@Param("name") String name);

}