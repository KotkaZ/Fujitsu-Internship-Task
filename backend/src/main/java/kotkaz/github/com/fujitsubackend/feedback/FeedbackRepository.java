package kotkaz.github.com.fujitsubackend.feedback;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Feedback Database layer
 */
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
