package pl.es8it.vmp.trade.infrastructure.persistence.repository.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.es8it.vmp.trade.domain.listing.ItemListing;
import pl.es8it.vmp.trade.domain.listing.repository.ItemListingRepository;
import pl.es8it.vmp.trade.infrastructure.persistence.mapper.ItemListingEntityMapper;
import pl.es8it.vmp.trade.infrastructure.persistence.repository.jpa.ItemListingJpaRepository;

@Repository
@RequiredArgsConstructor
public class ItemListingRepositoryAdapter implements ItemListingRepository {

    private final ItemListingJpaRepository repository;
    private final ItemListingEntityMapper mapper;

    @Override
    public void save(ItemListing itemListing) {
        var entity = mapper.toEntity(itemListing);
        repository.save(entity);
    }
}
