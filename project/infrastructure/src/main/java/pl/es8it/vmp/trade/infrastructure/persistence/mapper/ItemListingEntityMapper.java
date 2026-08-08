package pl.es8it.vmp.trade.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.es8it.vmp.trade.domain.listing.ItemListing;
import pl.es8it.vmp.trade.infrastructure.persistence.entity.ItemListingEntity;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ItemListingEntityMapper {

    ItemListingEntity toEntity(ItemListing domain);
}
