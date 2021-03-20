package kotkaz.github.com.fujitsubackend.feedback;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table
@ToString
@NoArgsConstructor
public class Feedback {

    @Id
    @SequenceGenerator(
            name = "feedback_sequence",
            sequenceName = "feedback_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "feedback_sequence"
    )
    @Setter
    @Getter
    @Positive
    private Long id;

    @Setter
    @Getter
    @NotBlank
    @Size.List ({
            @Size(min=3, message="The name field must be at least {min} characters"),
            @Size(max=45, message="The name field must be less than {max} characters")
    })
    @Pattern(regexp = "^([A-ZÕÄÖÜ][a-zõäöü]+)([ -][A-ZÕÄÖÜ][a-zõäöü]+)*$")
    private String name;

    @Setter
    @Getter
    @Email
    @NotBlank
    private String email;

    @Setter
    @Getter
    @NotBlank
    @Size.List ({
            @Size(min=3, message="The text field must be at least {min} characters"),
            @Size(max=255, message="The text field must be less than {max} characters")
    })
    private String text;

    @Setter
    @Getter
    @NotEmpty
    @ElementCollection
    private List<String> applications;



    public Feedback(String name, String email, String text, List<String> applications) {
        this.name = name;
        this.email = email;
        this.text = text;
        this.applications = applications;
    }
}
