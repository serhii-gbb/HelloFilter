package com.filter.hello.service;

import com.filter.hello.entity.Contact;
import com.filter.hello.repository.ContactRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class FilterService {

    private static final int RECORDS_PER_PAGE = 500_000;

    private ContactRepository contactRepository;


    public FilterService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    @Transactional(isolation = Isolation.REPEATABLE_READ, readOnly = true)
    public List<Contact> getByCondition(Pattern pattern) {
        List<Contact> result = new LinkedList<>();

        double pagesCount = Math.ceil(contactRepository.countRecords() / ((float) RECORDS_PER_PAGE));

        for (int i = 0; i < pagesCount; i++) {
            List<Contact> contentPage = contactRepository
                    .findAll(new PageRequest(i, RECORDS_PER_PAGE))
                    .getContent();

            List<Contact> list = new LinkedList<>(contentPage);
            list.removeIf(contact -> pattern.matcher(contact.getName()).find());

            result.addAll(list);
        }

        return result;
    }

}
