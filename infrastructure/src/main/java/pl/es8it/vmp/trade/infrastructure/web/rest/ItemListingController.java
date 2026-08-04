package pl.es8it.vmp.trade.infrastructure.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.es8it.vmp.trade.api.ItemListingApi;
import pl.es8it.vmp.trade.application.service.ItemListingService;
import pl.es8it.vmp.trade.application.service.data.CreateItemListingInput;
import pl.es8it.vmp.trade.infrastructure.web.rest.mapper.ItemListingMapper;
import pl.es8it.vmp.trade.model.CreateItemListingResponse;

@RestController
@RequiredArgsConstructor
public class ItemListingController implements ItemListingApi {

    private final ItemListingService itemListingService;
    private final ItemListingMapper itemListingMapper;

    @Override
    public ResponseEntity<CreateItemListingResponse> createItemListing() {
        var output = itemListingService.createItemListing(new CreateItemListingInput());
        var response = itemListingMapper.toResponse(output);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
