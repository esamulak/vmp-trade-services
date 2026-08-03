package pl.es8it.vmp.trade.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("pl.es8it.vmp")
public class VmpTradeServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(VmpTradeServicesApplication.class, args);
	}

}
