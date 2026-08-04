package pl.es8it.vmp.trade.infrastructure.web.rest.mapper;

import org.mapstruct.Mapper;
import pl.es8it.vmp.trade.application.service.data.CreateItemListingInput;
import pl.es8it.vmp.trade.application.service.data.CreateItemListingOutput;
import pl.es8it.vmp.trade.model.CreateItemListingRequest;
import pl.es8it.vmp.trade.model.CreateItemListingResponse;

@Mapper(componentModel = "spring")
public interface ItemListingMapper {

    CreateItemListingInput toInput(CreateItemListingRequest request);

    CreateItemListingResponse toResponse(CreateItemListingOutput output);
}
