package com.contacts.adressbook.controller;

import com.contacts.adressbook.dto.ResponseDTO;
import com.contacts.adressbook.model.ContactData;
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

    @RequestMapping(value = {"","/","/contacts"})
    public ResponseEntity<ResponseDTO> getAddressBookInformation(){
        ContactData contactData = null;
        contactData = new ContactData(1, new ContactDTO("Galefaugger","Basiela", 789456123));
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful" , contactData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/get/{contactId}")
    public ResponseEntity<ResponseDTO> getAddressBookInformation(@PathVariable("contactId") int contactId){
        ContactData contactData = null;
        contactData = new ContactData(1, new ContactDTO("Galefaugger","Basiela", 789456123));
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful" , contactData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addContact(@RequestBody ContactDTO contactDTO){
        ContactData contactData = null;
        contactData = new ContactData(1, contactDTO);
        ResponseDTO responseDTO = new ResponseDTO("Creation call successful for + " , contactData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateContact(@RequestBody ContactDTO contactDTO){
        ContactData contactData = null;
        contactData = new ContactData(1, contactDTO);
        ResponseDTO responseDTO = new ResponseDTO(" Call For Id updation Successful" , contactData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable("contactId") int contactId){
        ResponseDTO responseDTO = new ResponseDTO("Deleted successfully ","Deleted id"+contactId);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
