package com.contacts.adressbook.controller;

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

@RestController
@RequestMapping("/book")
public class AddressBookController {

	@RequestMapping(value = {"","/","/contact"})
    public ResponseEntity<String> getAddressBookInformation(){
        return new ResponseEntity<>("Get call is successful ",HttpStatus.OK);
    }

    @GetMapping("/get/{contactId}")
    public ResponseEntity<String> getAddressBookInformation(@PathVariable("contactId") int contactId){
    return new ResponseEntity<>("Get call is successful for id "+contactId,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addContact(@RequestBody ContactDTO contactDTO){
        return new ResponseEntity<>("Added the contact Data : "+contactDTO , HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateContact(@RequestBody ContactDTO contactDTO){
        return new ResponseEntity<>("Update the contact's data : "+contactDTO , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<String> deleteContact(@PathVariable("contactId") int contactId){
        return new ResponseEntity<>("Deleted contact's Data for id : "+contactId , HttpStatus.OK);
    }
}
