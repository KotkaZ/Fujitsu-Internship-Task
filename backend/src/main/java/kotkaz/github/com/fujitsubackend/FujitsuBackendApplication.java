package kotkaz.github.com.fujitsubackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin(origins = {"http://localhost:8081"})
public class FujitsuBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FujitsuBackendApplication.class, args);
	}
	
	@GetMapping
	public String helloWorld() {
		return "fujitsu_api v1";
	}

}
