package usualstudent.coursework.controllers.service;


import org.springframework.stereotype.Service;
import usualstudent.coursework.controllers.entity.Users;

import java.util.List;

@Service
public interface UsersService {
    Users addUser(Users user);

    void delete(long id);

    Users getByName(String name);

    Users editUser(Users user);

    List<Users> getAll();

    void banUser(Users user);

    void unBanUser(Users user);

}
