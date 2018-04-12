package com.filter.hello.service;

import com.filter.hello.entity.Contact;
import com.filter.hello.repository.ContactRepository;
import com.filter.hello.repository.JdbcRepository;
import com.filter.hello.repository.JdbcRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class FilterService {


    private ContactRepository contactRepository;
    private JdbcRepository jdbcRepository;

    public FilterService(ContactRepository contactRepository, JdbcRepository jdbcRepository) {
        this.contactRepository = contactRepository;
        this.jdbcRepository = jdbcRepository;
    }


    @Transactional()
    public List<Contact> getByCondition(Pattern pattern) {
        return jdbcRepository.getAllByJdbcTemp(pattern);
    }

}
