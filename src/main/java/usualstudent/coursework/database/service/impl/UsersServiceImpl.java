//package usualstudent.coursework.database.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import usualstudent.coursework.database.entity.Role;
//import usualstudent.coursework.database.entity.Users;
//import usualstudent.coursework.database.repos.UsersRepo;
//import usualstudent.coursework.database.service.UsersService;
//
//import java.util.Collections;
//import java.util.List;
//
//
//@Service
//public class UsersServiceImpl implements UsersService{
//
//    @Autowired
//    private UsersRepo usersRepo;
//
//
//    public Users addUser(Users user) {
//
//        user.setRoles(Collections.singleton(Role.USER));
//
//        return usersRepo.saveAndFlush(user);
//    }
//
//
//    public void delete(long id) {
//        usersRepo.deleteById(id);
//
//    }
//
//
//    public Users getByName(String name) {
//        return usersRepo.findByName(name);
//    }
//
//
//    public Users editUser(Users user) {
//        return usersRepo.saveAndFlush(user);
//    }
//
//
//    public List<Users> getAll() {
//        return usersRepo.findAll();
//    }
//
//
//    public void banUser(Users user) {
//        user.setBanned(true);
//    }
//
//
//    public void unBanUser(Users user) {
//        user.setBanned(false);
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        Users user = usersRepo.findByName(s);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        return user;
//    }
//}
