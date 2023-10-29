package br.com.springboot.restspringboot.services;

import br.com.springboot.restspringboot.exception.ResourceNotFoundException;
import br.com.springboot.restspringboot.model.Person;
import br.com.springboot.restspringboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Finding all people");
        return repository.findAll();
    }

    public Person findById(Long id) {

        logger.info("Finding person");
//        Person person = new Person();
//        person.setId(counter.incrementAndGet());
//        person.setFirstName("Tuany");
//        person.setLastName("Brito");
//        person.setAddress("São Paulo");
//        person.setGender("feminine");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
    }

    public Person create(Person person) {
        logger.info("Creating one person");
        return repository.save(person);
    }
    public Person update(Person person) {
        logger.info("Update one person");
        Person entity =  repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void deleteById(Long id) {
        logger.info("Delete one person");

        var entity =  repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
            repository.delete(entity);
    }
}
