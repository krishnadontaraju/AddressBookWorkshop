package com.contacts.adressbook.repository;

import com.contacts.adressbook.model.ContactData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AddressBookRepository extends JpaRepository<ContactData , Integer> {

    @Query(value = "SELECT * FROM contacts , types WHERE contact_id = id AND types = :types",nativeQuery = true)
    List<ContactData> findAllByContactType(String contactType);
}
