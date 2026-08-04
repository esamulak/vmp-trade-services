package pl.es8it.vmp.trade.infrastructure.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.es8it.vmp.trade.api.ItemListingApi;
import pl.es8it.vmp.trade.application.service.ItemListingService;
import pl.es8it.vmp.trade.model.CreateItemListingResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemListingController implements ItemListingApi {

    private final ItemListingService itemListingService;

    @Override
    public ResponseEntity<CreateItemListingResponse> createItemListing() {
        CreateItemListingResponse response = new CreateItemListingResponse();
        response.setItems(List.of());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
