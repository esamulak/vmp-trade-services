package pl.es8it.vmp.trade.application.service.impl;

import pl.es8it.vmp.trade.application.service.ItemListingService;
import pl.es8it.vmp.trade.application.service.data.CreateItemListingInput;
import pl.es8it.vmp.trade.application.service.data.CreateItemListingOutput;

import java.util.Collections;

public class ItemListingServiceImpl implements ItemListingService {

    @Override
    public CreateItemListingOutput createItemListing(CreateItemListingInput input) {
        return new CreateItemListingOutput(Collections.emptyList());
    }
}
