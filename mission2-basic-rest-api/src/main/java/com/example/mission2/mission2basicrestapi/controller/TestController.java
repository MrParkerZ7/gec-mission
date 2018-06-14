package com.example.mission2.mission2basicrestapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class TestController {

    @Value("string value") // basic inject string value
    private String stringValue;

    @Value("${value.from.file}")
    private String valueFromFile;

    @Value("${unknown.param:some default}") // this might be injected ;
    private String someDefault;

    @Value("${priority}")
    private String prioritySystemProperty;

    @Value("${listOfValues}")
    private String[] valuesArray;

    @Value("#{systemProperties['priority']}")
    private String spelValue;

    @Value("#{systemProperties['unknown'] ?: 'some default'}")
    private String spelSomeDefault;

    @Value(("${sloth.contact.name}"))
    private String slothContactName;

    @Value(("${sloth.contact.address}"))
    private String slothContactAddress;

    @GetMapping("/test")
    public List<String> test() {
        List<String> strings = new ArrayList<>();
        strings.add(stringValue);
        strings.add(valueFromFile);
        strings.add(someDefault);
        strings.add(prioritySystemProperty);
        strings.add(spelValue);
        strings.add(spelSomeDefault);
        strings.add(slothContactName);
        strings.add(slothContactAddress);
        return strings;
    }

    @GetMapping("/test/array")
    public String[] testArray() {
        return valuesArray;
    }

}
