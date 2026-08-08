package pl.es8it.vmp.trade.infrastructure.persistence.entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ITEM_LISTING")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ItemListingEntity extends AuditableEntity<UUID> {

    @ElementCollection
    @CollectionTable(
            name = "ITEM_LISTING_ITEM",
            joinColumns = @JoinColumn(name = "ITEM_LISTING_ID")
    )
    @Column(name = "ITEM")
    private List<String> items = new ArrayList<>();

    public ItemListingEntity(UUID id, List<String> items) {
        super(id);
        this.items = items;
    }
}
