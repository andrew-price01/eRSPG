package eRSPG.Repository;

import eRSPG.model.Reviewer;

import java.util.List;

public interface ReviewerDAO {

    void addReviewer(Reviewer reviewer);

    List<Reviewer> findAllReviewers();

    Reviewer findReviewerById(int id);

    List<Reviewer> findAllReviewByUserId(int userId);

    void deleteReviewer(Reviewer reviewer);
}
