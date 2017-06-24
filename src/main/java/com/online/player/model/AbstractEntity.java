package com.online.player.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by ikota on 9.6.17.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity<T extends AbstractEntity> implements Persistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Version
    private Integer version;

    @CreatedDate
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public T setId(Long id) {
        this.id = id;
        return (T) this;
    }

    public Integer getVersion() {
        return version;
    }

    public T setVersion(Integer version) {
        this.version = version;
        return (T) this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public T setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return (T) this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public T setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return (T) this;
    }

    @Override
    public boolean isNew() {
        return id == null;
    }
}
