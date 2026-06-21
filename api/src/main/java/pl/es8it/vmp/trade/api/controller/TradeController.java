package pl.es8it.vmp.trade.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//I want this class to be a @RestController implementing API createItemListing
@RestController
public class TradeController {

    @PostMapping("/item-listings")
    public ResponseEntity<String> createItemListing() {
        return ResponseEntity.ok("Not implemented yet.");
    }
}
