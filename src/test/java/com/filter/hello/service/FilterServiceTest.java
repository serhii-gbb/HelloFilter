package com.filter.hello.service;

import com.filter.hello.TestUtil;
import com.filter.hello.entity.Contact;
import com.filter.hello.repository.ContactRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FilterServiceTest {


    private ContactRepository contactRepository;
    private PageRequest pageRequest;
    Page<Contact> page;
    private static final int COUNT_RECORDS_PAGE = 3;
    private List<Contact> contactsList;

    @Before
    public void setUp() throws Exception {
        contactRepository = mock(ContactRepository.class);
        pageRequest = mock(PageRequest.class);
        page = mock(Page.class);

        contactsList = TestUtil.getContatList();
    }

    @Test
    public void getByCondition() {

        when(contactRepository.countRecords()).thenReturn(15);
        when(contactRepository.findAll(pageRequest)).thenReturn(page);
        when(page.getContent()).thenReturn(contactsList);

        Integer counts = contactRepository.countRecords();
        double pages = Math.ceil(counts / COUNT_RECORDS_PAGE);

        Page<Contact> all = contactRepository.findAll(pageRequest);
        List<Contact> content = all.getContent();


        assertEquals(content, contactsList);
        assertEquals(counts, new Integer(15));

        verify(contactRepository, times(1)).findAll(pageRequest);
        verify(contactRepository, times(1)).countRecords();

    }
}