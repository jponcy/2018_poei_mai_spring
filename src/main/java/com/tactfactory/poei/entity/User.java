package com.tactfactory.poei.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "sys_user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    @JsonProperty(access = Access.READ_ONLY)
    private Long id;

    @Column(name = "id")
    @NotBlank
    private String username;

    @NotBlank
    @Length(min = 8, max = 4321)
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    @JsonProperty(access = Access.READ_ONLY)
    private LocalDateTime createdAt = LocalDateTime.now();

    private String lastname;
    private String firstname;

    @NotBlank
    @Email
    private String email;

    private String grade;

    @OneToMany(mappedBy = "author")
    private List<Book> writeBooks;

    @ManyToMany
    private List<Book> ownBooks;

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
     * @return the username
     */
    public final String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public final void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public final String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public final void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the lastname
     */
    public final String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public final void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the firstname
     */
    public final String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public final void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the email
     */
    public final String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public final void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the grade
     */
    public final String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public final void setGrade(String grade) {
        this.grade = grade;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
