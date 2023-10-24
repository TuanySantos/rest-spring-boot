package br.com.springboot.restspringboot.services;

import br.com.springboot.restspringboot.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        logger.info("Finding person");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Tuany");
        person.setLastName("Brito");
        person.setAddress("São Paulo");
        person.setGender("feminine");
        return person;
    }
}
