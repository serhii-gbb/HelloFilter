package com.filter.hello;

import com.filter.hello.entity.Contact;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static List<Contact> getContatList() {
        return new ArrayList<Contact>() {
            {
                add(new Contact(1, "Vasya"));
                add(new Contact(2, "Kolya"));
                add(new Contact(3, "Petya"));
                add(new Contact(4, "Tanya"));
            }
        };
    }
}
