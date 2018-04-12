package com.filter.hello.repository;

import com.filter.hello.entity.Contact;

import java.util.List;
import java.util.regex.Pattern;

public interface JdbcRepository {

    List<Contact> getByJdbc(Pattern pattern);

    List<Contact> getAllByJdbcTemp(Pattern pattern);
}
