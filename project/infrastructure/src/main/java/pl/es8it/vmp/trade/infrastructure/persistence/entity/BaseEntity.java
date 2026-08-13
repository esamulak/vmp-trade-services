package pl.es8it.vmp.trade.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Getter
@NoArgsConstructor
public abstract class BaseEntity<ID> {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    private ID id;

    protected BaseEntity(ID id) {
        this.id = id;
    }
}