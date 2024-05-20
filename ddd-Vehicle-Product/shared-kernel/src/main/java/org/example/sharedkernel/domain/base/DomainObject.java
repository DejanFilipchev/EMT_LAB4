package org.example.sharedkernel.domain.base;

import jakarta.persistence.Embeddable;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.io.Serializable;

@MappedSuperclass
@Embeddable
public interface DomainObject extends Serializable {
}
