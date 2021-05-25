package com.contacts.adressbook.service;

import com.contacts.adressbook.dto.ContactDTO;
import com.contacts.adressbook.model.ContactData;

import java.util.List;

public interface IAddressBookService {

    List<ContactData> getAddressBookData();

    ContactData getContactDataById(int contactId);

    ContactData createContactData(ContactDTO contactDTO);

    ContactData updateContactData(int contactID , ContactDTO contactDTO);

    void deleteContactData(int contactid);
}
