package com.tactfactory.poei.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private User author;

    @ManyToMany(mappedBy = "ownBooks")
    private List<User> owners = new ArrayList<>();

    /**
     * @return the id
     */
    public final Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public final void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public final String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public final void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the author
     */
    public final User getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public final void setAuthor(User author) {
        this.author = author;
    }

    /**
     * @return the owners
     */
    public final List<User> getOwners() {
        return owners;
    }

    /**
     * @param owners the owners to set
     */
    public final void setOwners(List<User> owners) {
        this.owners = owners;
    }
}
