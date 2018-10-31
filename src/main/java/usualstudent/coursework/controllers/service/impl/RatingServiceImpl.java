package usualstudent.coursework.controllers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usualstudent.coursework.controllers.entity.Rating;
import usualstudent.coursework.controllers.entity.Users;
import usualstudent.coursework.controllers.repos.RatingRepo;
import usualstudent.coursework.controllers.service.RatingService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepo ratingRepo;

    @Override
    public Rating addUser(Rating rating) {
        return ratingRepo.saveAndFlush(rating);
    }

    @Override
    public void removeUser(Rating rating) {
        ratingRepo.delete(rating);
    }


    @Override
    public int getUserPlaceInRating(Users user) {
        List<Rating> ratingList = ratingRepo.findAll();
        if (ratingList != null) {
            Collections.sort(ratingList, new Comparator<Rating>() {
                @Override
                public int compare(Rating r1, Rating r2) {
                    if (r1.getRating() < r2.getRating())
                        return 1;
                    else if (r1.getRating() > r2.getRating())
                        return -1;
                    else
                        return 0;

                }
            });
        }

        for (int i = 0; i < ratingList.size(); i++) {
            if (ratingList.get(i).getUser().getId() == user.getId())
                return i;
        }
        return 0;
    }
}
