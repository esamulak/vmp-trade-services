package pl.es8it.vmp.trade.application.listing.service;

import pl.es8it.vmp.trade.application.listing.data.CreateItemListingInput;
import pl.es8it.vmp.trade.application.listing.data.CreateItemListingOutput;
import pl.es8it.vmp.trade.application.listing.mapper.ItemListingMapper;
import pl.es8it.vmp.trade.domain.listing.ItemListing;

import java.util.Collections;
import java.util.UUID;

import static pl.es8it.vmp.trade.application.listing.mapper.ItemListingMapper.toCreateItemListingOutput;

public class ItemListingServiceImpl implements ItemListingService {

    public CreateItemListingOutput createItemListing(CreateItemListingInput input) {
        var itemListing = new ItemListing(UUID.randomUUID(), Collections.emptyList()); //TODO: get UUID from request

        return toCreateItemListingOutput(itemListing);
    }
}
