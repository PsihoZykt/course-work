package usualstudent.coursework.database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usualstudent.coursework.database.entity.Rating;
import usualstudent.coursework.database.entity.Users;
import usualstudent.coursework.database.repos.RatingRepo;
import usualstudent.coursework.database.service.RatingService;

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
        List<Rating> sortedRatingLit =  sortRating(ratingList);
        for (int i = 0; i < ratingList.size(); i++) {
            if (ratingList.get(i).getUser().getId() == user.getId())
                return i;
        }
        return 0;
    }



    public List<Rating> sortRating(List<Rating> ratingList) {
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
        return ratingList;
    }
}
