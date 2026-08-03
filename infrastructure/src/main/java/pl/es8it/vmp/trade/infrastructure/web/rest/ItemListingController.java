package pl.es8it.vmp.trade.infrastructure.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.es8it.vmp.trade.api.ItemListingApi;
import pl.es8it.vmp.trade.model.CreateItemListingRequest;
import pl.es8it.vmp.trade.model.CreateItemListingResponse;

@RestController
public class ItemListingController implements ItemListingApi {

    @Override
    public ResponseEntity<CreateItemListingResponse> createItemListing(CreateItemListingRequest createItemListingRequest) {
        return ResponseEntity.ok(new CreateItemListingResponse());
    }
}
