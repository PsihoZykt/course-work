package usualstudent.coursework.database.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import usualstudent.coursework.database.entity.Users;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    Users addUser(Users user);

    void delete(long id);

    Users getByName(String name);

    Users editUser(Users user);

    List<Users> getAll();

    void banUser(Users user);

    void unBanUser(Users user);

}
