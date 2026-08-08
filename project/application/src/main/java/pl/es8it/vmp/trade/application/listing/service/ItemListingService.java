package pl.es8it.vmp.trade.application.listing.service;

import pl.es8it.vmp.trade.application.listing.data.CreateItemListingInput;
import pl.es8it.vmp.trade.application.listing.data.CreateItemListingOutput;

public interface ItemListingService {

    CreateItemListingOutput createItemListing(CreateItemListingInput input);

}
