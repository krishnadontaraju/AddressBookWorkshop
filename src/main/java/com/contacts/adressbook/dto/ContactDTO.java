package com.contacts.adressbook.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public @ToString class ContactDTO {

    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$" , message = "First Name name not according to the pattern")
    @NotBlank
    public String firstName;
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$" , message = "First Name name not according to the pattern")
    public String lastName;
    @Pattern(regexp = "^[+0-9]{10,13}$" , message = "Phone number given is Invalid")
    @NotBlank
    public long contactNumber;
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "City name must be at least 3 letters long ")
    public String city;
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "State name must be at least 3 letters long ")
    public String state;
    @Pattern(regexp = "^[0-9]{6}$" , message = "Zip Code given is Invalid")
    public int zipCode;
    @NotNull
    public List<String> type;


    public ContactDTO(String firstName,String lastNameString , long contactNumber) {
        this.firstName = firstName;
        this.lastName = lastNameString;
        this.contactNumber = contactNumber;
    }


}
