package com.contacts.adressbook.model;

import com.contacts.adressbook.dto.ContactDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "contacts")
public @Data class ContactData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contact_id")
    private int contactId;
    private String firstName;
    private String lastName;
    private long contactNumber;
    private String city;
    private String state;
    private int zipCode;

    @ElementCollection
    @CollectionTable(name = "types" , joinColumns = @JoinColumn(name = "id"))
    @Column(name = "type")
    private List<String> type;


    public ContactData(ContactDTO contactDTO) {

        this.updateContactData(contactDTO);

    }

    public void updateContactData(ContactDTO contactDTO){
        this.firstName = contactDTO.firstName;
        this.lastName = contactDTO.lastName;
        this.contactNumber = contactDTO.contactNumber;
        this.city = contactDTO.city;
        this.state = contactDTO.state;
        this.zipCode = contactDTO.zipCode;
    }

    public ContactData() {}
}
