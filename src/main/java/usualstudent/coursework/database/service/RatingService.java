package usualstudent.coursework.database.service;

import org.springframework.stereotype.Service;
import usualstudent.coursework.database.entity.Rating;
import usualstudent.coursework.database.entity.Users;

@Service
public interface RatingService {

    Rating addUser(Rating rating);

    void removeUser(Rating rating);

    int getUserPlaceInRating(Users user);

}
