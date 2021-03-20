package kotkaz.github.com.fujitsubackend.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public List<Feedback> getFeedbacks() {
        return feedbackRepository.findAll();
    }

    public void addNewFeedback(Feedback feedback) {
        if(feedback.getId() != null && feedbackRepository.existsById(feedback.getId()))
            throw new IllegalStateException("Feedback with id " + feedback.getId() + " already exists!");
        feedbackRepository.save(feedback);
    }
}
