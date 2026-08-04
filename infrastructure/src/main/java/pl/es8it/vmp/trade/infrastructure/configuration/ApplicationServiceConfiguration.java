package pl.es8it.vmp.trade.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.es8it.vmp.trade.application.service.ItemListingService;

import java.util.ServiceLoader;

@Configuration
public class ApplicationServiceConfiguration {

    @Bean
    public ItemListingService itemListingService() {
        return ServiceLoader
                .load(ItemListingService.class)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No ItemListingService implementation found"));
    }
}
