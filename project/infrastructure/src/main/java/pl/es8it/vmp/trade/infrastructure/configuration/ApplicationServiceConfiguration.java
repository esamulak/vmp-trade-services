package pl.es8it.vmp.trade.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.es8it.vmp.trade.application.listing.service.ItemListingService;
import pl.es8it.vmp.trade.application.listing.service.ItemListingServiceImpl;
import pl.es8it.vmp.trade.domain.listing.repository.ItemListingRepository;

@Configuration
public class ApplicationServiceConfiguration {

    @Bean
    public ItemListingService itemListingService(ItemListingRepository itemListingRepository) {
        return new ItemListingServiceImpl(itemListingRepository);
    }
}
