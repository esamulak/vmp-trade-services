package pl.es8it.vmp.trade.application.service;

import pl.es8it.vmp.trade.application.service.data.CreateItemListingInput;
import pl.es8it.vmp.trade.application.service.data.CreateItemListingOutput;

public interface ItemListingService {

    CreateItemListingOutput createItemListing(CreateItemListingInput input);
    // Define methods for the service
}
