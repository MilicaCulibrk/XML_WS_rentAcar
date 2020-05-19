package rent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RentApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentApplication.class, args);
	}

}
