package pl.es8it.vmp.trade.domain.listing;

import java.util.List;
import java.util.UUID;

public record ItemListing(
        UUID id,
        List<String> items
) {}
