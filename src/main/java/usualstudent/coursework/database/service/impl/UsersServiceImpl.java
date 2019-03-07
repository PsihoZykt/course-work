package usualstudent.coursework.database.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import usualstudent.coursework.CourseWorkApplication;
import usualstudent.coursework.database.entity.Role;
import usualstudent.coursework.database.entity.Users;
import usualstudent.coursework.database.repos.UsersRepo;
import usualstudent.coursework.database.service.MailSenderService;
import usualstudent.coursework.database.service.UserService;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class UsersServiceImpl implements UserService {

    @Autowired
    private UsersRepo userRepo;
    @Autowired
    private MailSenderService mailSenderService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private static final Logger logger = LogManager.getLogger(CourseWorkApplication.class);


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (userRepo.findByUsername(username) == null)
            throw new UsernameNotFoundException("user not found");
        return userRepo.findByUsername(username);
    }



    public boolean addUser(Users user) {
        Users userFromDb = userRepo.findByUsername(user.getUsername());
        if(userRepo.findByEmail(user.getEmail()) != null){
            return false;
        }
        if(userFromDb != null) {
            return false;
        }

        user.setRegistrationDate(new Date());
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        sendMessage(user);
        userRepo.save(user);
        return true;
    }

    private void sendMessage(Users user) {
        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to Sweater. Please, visit next link: http://localhost:8080/activate/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );

            mailSenderService.send(user.getEmail(), "Activation code", message);
        }
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

    @Override
    public boolean activateUser(String code) {
      Users user =  userRepo.findByActivationCode(code);
      if(user == null){
          return false;
      }
      user.setActivationCode(null);
      userRepo.save(user);
      return true;
    }

    @Override
    public void saveUser(Users user, Map<String, String> form) {
        logger.warn("in service" + user.getFavouritePokemon());

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepo.save(user);
    }

    @Override
    public void updateProfile(Users user, String password, String email) {
        String userEmail = user.getEmail();
        boolean isEmailChanged  = (email != null && !email.equals(userEmail) ||
        userEmail!=null && !userEmail.equals(email));
        if(isEmailChanged){
            user.setEmail(email);
            if(!StringUtils.isEmpty(email)){
                user.setActivationCode(UUID.randomUUID().toString());
            }

        }
        userRepo.save(user);
        if(isEmailChanged){
            sendMessage(user);
        }


    }
}
