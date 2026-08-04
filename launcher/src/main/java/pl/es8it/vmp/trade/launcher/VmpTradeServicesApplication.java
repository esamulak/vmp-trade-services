package pl.es8it.vmp.trade.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = "pl.es8it.vmp.trade"
)
public class VmpTradeServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(VmpTradeServicesApplication.class, args);
	}

}
