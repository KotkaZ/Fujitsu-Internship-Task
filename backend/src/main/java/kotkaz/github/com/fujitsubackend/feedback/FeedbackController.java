package kotkaz.github.com.fujitsubackend.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Feedback API Layer
 */
@RestController
@RequestMapping("api/v1/feedback")
@CrossOrigin(origins = {"http://localhost:8081"})
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public List<Feedback> getFeedbacks() {
        return feedbackService.getFeedbacks();
    }

    @PostMapping
    public void addFeedback(@RequestBody @NonNull @Valid Feedback feedback) {
        feedbackService.addNewFeedback(feedback);
    }

}
