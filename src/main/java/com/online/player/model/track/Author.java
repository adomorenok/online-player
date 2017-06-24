package com.online.player.model.track;

import com.online.player.model.AbstractEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ikota on 11.6.17.
 */
@Entity
@Table(name = "author")
public class Author extends AbstractEntity<Author> {

    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 255)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "author_tag", joinColumns = {
            @JoinColumn(name = "author_id", nullable = false, updatable = true)
    }, inverseJoinColumns = { @JoinColumn(name = "tag_id", nullable = false, updatable = true) })
    private Set<Tag> tags;

    public String getName() {
        return name;
    }

    public Author setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public Author setTags(Set<Tag> tags) {
        this.tags = tags;
        return this;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
