package kotkaz.github.com.fujitsubackend.feedback;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class FeedbackRepositoryTests {
    @Autowired
    private FeedbackRepository underTest;

    @Test
    void feedbackAddedOnce() {
        int start = underTest.findAll().size();
        Feedback feedback = new Feedback("Madis Jaanikivi","madis@jaanikivi.ee", "Cool app!", List.of("Patients portal"));
        underTest.save(feedback);
        Assertions.assertEquals(start +1, underTest.findAll().size());
    }

    @Test
    void addedCorrectFeedback() {
        Feedback feedback = new Feedback("Madis Jaanikivi","madis@jaanikivi.ee", "Cool app!", List.of("Patients portal"));
        underTest.save(feedback);
        Feedback savedFeedback = underTest.findById(feedback.getId()).orElse(null);
        Assertions.assertNotNull(savedFeedback);
    }


}
