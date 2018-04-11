package com.filter.hello.controller;


import com.filter.hello.entity.Contact;
import com.filter.hello.service.FilterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private FilterService filterService;


    public HelloController(FilterService filterService) {
        this.filterService = filterService;
    }


    @GetMapping(path = "/contacts")
    public ResponseEntity<Map<String, List<Contact>>> getMatchContacts(@RequestParam("nameFilter") String filter) {
        Pattern pattern;

        try {
            pattern = Pattern.compile(filter);
        } catch (PatternSyntaxException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Contact> contacts = filterService.getByCondition(pattern);


        Map<String, List<Contact>> result = new HashMap<>();
        result.put("contacts", contacts);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
