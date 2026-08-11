package pl.es8it.vmp.trade.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@MappedSuperclass
@NoArgsConstructor
@Getter
public abstract class AuditableEntity<ID> extends BaseEntity<ID> {

    @Column(name = "CREATED", nullable = false, updatable = false)
    private Instant created;

    protected AuditableEntity(ID id) {
        super(id);
        this.created = Instant.now();
    }
}
