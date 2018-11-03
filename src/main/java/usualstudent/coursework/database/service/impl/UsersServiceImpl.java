package usualstudent.coursework.database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import usualstudent.coursework.database.entity.Role;
import usualstudent.coursework.database.entity.Users;
import usualstudent.coursework.database.repos.UsersRepo;
import usualstudent.coursework.database.service.UserService;

import java.util.Collections;
import java.util.List;


@Service
public class UsersServiceImpl implements UserService {

    @Autowired
    private UsersRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(userRepo.findByUsername(username) == null)
            throw new UsernameNotFoundException("user not found");
        return userRepo.findByUsername(username);
    }

    public Users addUser(Users user) {

        user.setRoles(Collections.singleton(Role.USER));

        return userRepo.saveAndFlush(user);
    }


    public void delete(long id) {
        userRepo.deleteById(id);

    }


    public Users getByName(String name) {
        return userRepo.findByUsername(name);
    }


    public Users editUser(Users user) {
        return userRepo.saveAndFlush(user);
    }


    public List<Users> getAll() {
        return userRepo.findAll();
    }


    public void banUser(Users user) {
        user.setBanned(true);
    }


    public void unBanUser(Users user) {
        user.setBanned(false);
    }



}
