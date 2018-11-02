package usualstudent.coursework.database.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import usualstudent.coursework.database.entity.Users;

import java.util.List;

@Service
public interface UsersService extends UserDetailsService {
    Users addUser(Users user);

    void delete(long id);

    Users getByName(String name);

    Users editUser(Users user);

    List<Users> getAll();

    void banUser(Users user);

    void unBanUser(Users user);

}
