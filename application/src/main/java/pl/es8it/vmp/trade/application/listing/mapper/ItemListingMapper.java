package pl.es8it.vmp.trade.application.listing.mapper;

import pl.es8it.vmp.trade.application.listing.data.CreateItemListingOutput;
import pl.es8it.vmp.trade.domain.listing.ItemListing;

public interface ItemListingMapper {

    static CreateItemListingOutput toCreateItemListingOutput(ItemListing itemListing) {
        return new CreateItemListingOutput(itemListing.items());
    }

}
