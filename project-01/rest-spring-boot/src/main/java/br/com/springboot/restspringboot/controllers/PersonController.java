package br.com.springboot.restspringboot.controllers;

import br.com.springboot.restspringboot.exception.UnsupportedMathOperationException;
import br.com.springboot.restspringboot.model.Person;
import br.com.springboot.restspringboot.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    private static final String template = "Hello, %s!";

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(
            @PathVariable(value = "id") String id
    ) throws Exception {
        return service.findById(id);
    }
}
