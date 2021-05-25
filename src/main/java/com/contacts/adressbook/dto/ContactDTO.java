package com.contacts.adressbook.dto;

public class ContactDTO {

    public String firstName;
    public String lastName;
    public long contactNumber;


    public ContactDTO(String firstName,String lastNameString , long contactNumber) {
        this.firstName = firstName;
        this.lastName = lastNameString;
        this.contactNumber = contactNumber;
    }


    @Override
    public String toString() {
        return "firstName = " + firstName +", lastName = "+lastName+ ", contactNumber = " + contactNumber;
    }

}
