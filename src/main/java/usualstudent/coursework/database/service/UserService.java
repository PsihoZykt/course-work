package usualstudent.coursework.database.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import usualstudent.coursework.database.entity.Users;

import java.util.List;
import java.util.Map;

@Service
public interface UserService extends UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    boolean addUser(Users user);

    void delete(long id);

    Users getByName(String name);

    Users editUser(Users user);

    List<Users> getAll();

    void banUser(Users user);

    void unBanUser(Users user);

    boolean activateUser(String code);

    void saveUser(Users user, String username,  Map<String, String> form);

    void updateProfile(Users user, String password, String email);
}
