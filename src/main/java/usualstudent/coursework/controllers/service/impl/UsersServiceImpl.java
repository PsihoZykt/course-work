package usualstudent.coursework.controllers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usualstudent.coursework.controllers.entity.Users;
import usualstudent.coursework.controllers.repos.UsersRepo;
import usualstudent.coursework.controllers.service.UsersService;

import java.util.List;


@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepo usersRepo;

    @Override
    public Users addUser(Users user) {
        return usersRepo.saveAndFlush(user);
    }

    @Override
    public void delete(long id) {
        usersRepo.deleteById(id);

    }

    @Override
    public Users getByName(String name) {
        return usersRepo.findByName(name);
    }

    @Override
    public Users editUser(Users user) {
        return usersRepo.saveAndFlush(user);
    }

    @Override
    public List<Users> getAll() {
        return usersRepo.findAll();
    }

    @Override
    public void banUser(Users user) {
        user.setBanned(true);
    }

    @Override
    public void unBanUser(Users user) {
        user.setBanned(false);
    }


}
