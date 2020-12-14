package Spring.Twilio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Spring.Twilio.Service.Twilioproperties;

@SpringBootApplication
public class SpringTwilioApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTwilioApplication.class, args);
	}
	@Bean
	public Twilioproperties properties() {
	    return new Twilioproperties();
	}
}
