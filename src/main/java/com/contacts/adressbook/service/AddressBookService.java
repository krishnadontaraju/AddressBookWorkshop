package com.contacts.adressbook.service;

import com.contacts.adressbook.dto.ContactDTO;
import com.contacts.adressbook.exception.AddressBookException;
import com.contacts.adressbook.model.ContactData;
import com.contacts.adressbook.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public List<ContactData> getAddressBookData() {

        return addressBookRepository.findAll();
    }

    @Override
    public ContactData getContactDataById(int contactId) {

        return addressBookRepository.findById(contactId)
                                    .orElseThrow(() -> new AddressBookException("Contact not Found"));
    }

    @Override
    public ContactData createContactData(ContactDTO contactDTO) {
        ContactData contactData = null;
        contactData = new ContactData(contactDTO);
        log.debug("Contact Data : "+contactData);
        return addressBookRepository.save(contactData);
    }

    @Override
    public ContactData updateContactData(int contactId , ContactDTO contactDTO) {
        ContactData contactData = this.getContactDataById(contactId);
        contactData.updateContactData(contactDTO);

        return addressBookRepository.save(contactData);
    }

    @Override
    public List<ContactData> getContactsByType(String type){
        return addressBookRepository.findAllByContactType(type);
    }

    @Override
    public void deleteContactData(int contactid) {
        ContactData contactData = this.getContactDataById(contactid);
        addressBookRepository.delete(contactData);
    }

}
