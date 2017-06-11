package com.online.player.model.track;

import com.online.player.model.AbstractEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ikota on 11.6.17.
 */
@Entity
@Table(name = "tag")
public class Tag extends AbstractEntity<Tag> {

    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 255)
    private String name;

    public String getName() {
        return name;
    }

    public Tag setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }

}
