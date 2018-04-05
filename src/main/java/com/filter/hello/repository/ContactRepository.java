package com.filter.hello.repository;

import com.filter.hello.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    @Query("select count(c) from Contact as c")
    int countRecords();
}
