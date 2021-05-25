package com.contacts.adressbook.service;

import com.contacts.adressbook.dto.ContactDTO;
import com.contacts.adressbook.model.ContactData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressBookService implements IAddressBookService {

    private List<ContactData> contactDataList = new ArrayList<>();

    @Override
    public List<ContactData> getAddressBookData() {

        return contactDataList;
    }

    @Override
    public ContactData getContactDataById(int contactId) {

        return contactDataList.get(contactId - 1);
    }

    @Override
    public ContactData createContactData(ContactDTO contactDTO) {
        ContactData contactData = null;
        contactData = new ContactData(contactDataList.size() + 1 , contactDTO);
        contactDataList.add(contactData);
        return contactData;
    }

    @Override
    public ContactData updateContactData(int contactId , ContactDTO contactDTO) {
        ContactData contactData = this.getContactDataById(contactId);
        contactData.setFirstName(contactDTO.firstName);
        contactData.setLastName(contactDTO.lastName);
        contactData.setContactNumber(contactDTO.contactNumber);

        contactDataList.set(contactId - 1, contactData);

        return contactData;
    }

    @Override
    public void deleteContactData(int contactid) {
        contactDataList.remove(contactid -1);
    }

}
