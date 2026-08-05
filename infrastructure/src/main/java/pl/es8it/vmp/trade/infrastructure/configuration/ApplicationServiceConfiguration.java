package pl.es8it.vmp.trade.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.es8it.vmp.trade.application.listing.service.ItemListingService;
import pl.es8it.vmp.trade.application.listing.service.ItemListingServiceImpl;

@Configuration
public class ApplicationServiceConfiguration {

    @Bean
    public ItemListingService itemListingService() {
        return new ItemListingServiceImpl();
    }
}
