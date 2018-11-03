package usualstudent.coursework.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import usualstudent.coursework.database.repos.UsersRepo;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UsersRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(userRepo.findByUsername(username) == null)
            throw new UsernameNotFoundException("user not found");
        return userRepo.findByUsername(username);
    }
}
//
//
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//import usualstudent.coursework.database.entity.Users;
//
//import java.util.List;
//
//@Service
//public interface UsersService extends UserDetailsService {
//    Users addUser(Users user);
//
//    void delete(long id);
//
//    Users getByName(String name);
//
//    Users editUser(Users user);
//
//    List<Users> getAll();
//
//    void banUser(Users user);
//
//    void unBanUser(Users user);
//
//}
