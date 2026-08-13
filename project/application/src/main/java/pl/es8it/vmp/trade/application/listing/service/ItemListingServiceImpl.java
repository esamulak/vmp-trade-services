package pl.es8it.vmp.trade.application.listing.service;

import lombok.RequiredArgsConstructor;
import pl.es8it.vmp.trade.application.listing.data.CreateItemListingInput;
import pl.es8it.vmp.trade.application.listing.data.CreateItemListingOutput;
import pl.es8it.vmp.trade.domain.listing.ItemListing;
import pl.es8it.vmp.trade.domain.listing.repository.ItemListingRepository;

import java.util.Collections;
import java.util.UUID;

import static pl.es8it.vmp.trade.application.listing.mapper.ItemListingMapper.toCreateItemListingOutput;

@RequiredArgsConstructor
public class ItemListingServiceImpl implements ItemListingService {

    private final ItemListingRepository itemListingRepository;

    public CreateItemListingOutput createItemListing(CreateItemListingInput input) {
        var itemListing = new ItemListing(UUID.randomUUID(), Collections.emptyList()); //TODO: get UUID from request

        itemListingRepository.save(itemListing);

        return toCreateItemListingOutput(itemListing);
    }
}
