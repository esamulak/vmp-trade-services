package pl.es8it.vmp.trade.infrastructure.persistence.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.es8it.vmp.trade.infrastructure.persistence.entity.ItemListingEntity;

import java.util.UUID;

public interface ItemListingJpaRepository extends JpaRepository<ItemListingEntity, UUID> {
}