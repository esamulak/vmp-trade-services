package pl.es8it.vmp.trade.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
		scanBasePackages = "pl.es8it.vmp.trade"
)
public class VmpTradeServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(VmpTradeServicesApplication.class, args);
	}

}
