package com.filter.hello.controller;

import com.filter.hello.TestUtil;
import com.filter.hello.entity.Contact;
import com.filter.hello.service.FilterService;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;
import java.util.regex.Pattern;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private List<Contact> contactList;
    private FilterService filterService;
    private Pattern pattern;

    @MockBean
    private HelloController helloController;


    @Before
    public void setUp() throws Exception {
        filterService = mock(FilterService.class);
        contactList = TestUtil.getContatList();
    }


    @Test
    public void getMatchContacts() throws Exception {
        Map<String, List<Contact>> result = new HashMap<>();
        result.put("contacts", contactList);

        pattern = Pattern.compile("^.$");
        when(filterService.getByCondition(pattern)).thenReturn(contactList);

        List<Contact> contacts = filterService.getByCondition(pattern);
        verify(filterService, times(1)).getByCondition(pattern);

        given(helloController.getMatchContacts(pattern.toString()))
                .willReturn(new ResponseEntity<>(result, HttpStatus.OK));

        mockMvc.perform(get("/hello/contacts")
                .param("nameFilter", "^.$")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.contacts[0].id").value(Is.is(contacts.get(0).getId()), Long.class));
    }
}