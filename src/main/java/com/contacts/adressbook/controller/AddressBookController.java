package com.contacts.adressbook.controller;

import com.contacts.adressbook.dto.ResponseDTO;
import com.contacts.adressbook.model.ContactData;
import com.contacts.adressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contacts.adressbook.dto.ContactDTO;

import java.util.List;

@RestController
@RequestMapping("/book")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @RequestMapping(value = {"","/","/contacts"})
    public ResponseEntity<ResponseDTO> getAddressBookInformation(){
        List<ContactData> contactDataList = null;
        contactDataList = addressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful" , contactDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO ,HttpStatus.OK);
    }

    @GetMapping("/get/{contactId}")
    public ResponseEntity<ResponseDTO> getAddressBookInformation(@PathVariable("contactId") int contactId){
        ContactData contactData = null;
        contactData = addressBookService.getContactDataById(contactId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful" , contactData);
        return new ResponseEntity<ResponseDTO>(responseDTO ,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addContact(@RequestBody ContactDTO contactDTO){
        ContactData contactData = null;
        contactData = addressBookService.createContactData(contactDTO);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful" , contactData);
        return new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.OK);
    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDTO> updateContact(@PathVariable("contactId") int contactId , @RequestBody ContactDTO contactDTO){
        ContactData contactData = null;
        contactData = addressBookService.updateContactData(contactId,contactDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update Call For Id Successful" , contactData);
        return new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable("contactId") int contactId){
        addressBookService.deleteContactData(contactId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted successfully ","Deleted id"+contactId);
        return new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.OK);
    }
}
