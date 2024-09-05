package com.domin.wms.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDTO {

    @NotBlank(message = "Surname should not be empty.")
    @Size(min = 2, message = "Surname should contain at least 2 characters.")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+(\\s[a-zA-Zа-яА-Я]+)*$", message = "Surname should contain only letters and begin with a capital letter")
    private String lastName;

    @NotBlank(message = "Name should not be empty.")
    @Size(min = 2, message = "Name should contain at least 2 characters.")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+(\\s[a-zA-Zа-яА-Я]+)*$", message = "Name should contain only letters and begin with a capital letter")
    private String firstName;

    @NotBlank(message = "Job title should not be empty.")
    @Size(min = 5, message = "Job title should contain at least 5 characters.")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ]+(\\s[a-zA-Zа-яА-ЯёЁ]+)*$", message = "Job title should contain only letters.")
    private String jobTitle;

    @NotBlank(message = "Email should be empty.")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email should be valid.")
    private String email;

    @NotBlank(message = "Password title should not be empty.")
    private String password;



    public UserDTO() {
    }

    public UserDTO(String lastName, String firstName, String jobTitle, String email, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.password = password;
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
