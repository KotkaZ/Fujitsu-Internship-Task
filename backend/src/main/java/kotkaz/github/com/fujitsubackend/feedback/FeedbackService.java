package kotkaz.github.com.fujitsubackend.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Feedback Service Layer
 */
@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    /**
     * Method finds all feedback objects from repository and returns them as List.
     *
     * @return List of all feedback objects.
     */
    public List<Feedback> getFeedbacks() {
        return feedbackRepository.findAll();
    }

    /**
     * Method adds new feedback object to repository.
     * Overwriting feedback with same id is forbidden,
     * in which case it will return status code 500 for simplicity.
     *
     * @param feedback New Feedback object.
     */
    public void addNewFeedback(Feedback feedback) {
        if (feedback.getId() != null && feedbackRepository.existsById(feedback.getId()))
            throw new IllegalStateException("Feedback with id " + feedback.getId() + " already exists!");
        feedbackRepository.save(feedback);
    }
}
