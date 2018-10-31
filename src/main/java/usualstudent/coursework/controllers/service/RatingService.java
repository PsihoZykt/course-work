package usualstudent.coursework.controllers.service;

import org.springframework.stereotype.Service;
import usualstudent.coursework.controllers.entity.Rating;
import usualstudent.coursework.controllers.entity.Users;

@Service
public interface RatingService {

    Rating addUser(Rating rating);

    void removeUser(Rating rating);

    int getUserPlaceInRating(Users user);

}
