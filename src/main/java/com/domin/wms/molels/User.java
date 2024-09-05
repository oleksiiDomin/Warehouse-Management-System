package com.domin.wms.molels;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {
 
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "last_name")
    @NotBlank(message = "Surname should not be empty.")
    @Size(min = 2, message = "Surname should contain at least 2 characters.")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+(\\s[a-zA-Zа-яА-Я]+)*$", message = "Surname should contain only letters and begin with a capital letter")
    private String lastName;

    @Column(name = "first_name")
    @NotBlank(message = "Name should not be empty.")
    @Size(min = 2, message = "Name should contain at least 2 characters.")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+(\\s[a-zA-Zа-яА-Я]+)*$", message = "Name should contain only letters and begin with a capital letter")
    private String firstName;

    @Column(name = "job_title")
    @NotBlank(message = "Job title should not be empty.")
    @Size(min = 5, message = "Job title should contain at least 5 characters.")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ]+(\\s[a-zA-Zа-яА-ЯёЁ]+)*$", message = "Job title should contain only letters.")
    private String jobTitle;

    @Column(name = "email")
    @NotBlank(message = "Email should be empty.")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email should be valid.")
    private String email;

    @Column(name = "password")
    @NotBlank(message = "Password title should not be empty.")
    private String password;

    public User() {
        //
    }

    public User(String lastName, String firstName, String jobTitle, String email, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
