package kodlama.io.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication  //Configuration
public class ECommerceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ECommerceApplication.class, args);
	}

}
