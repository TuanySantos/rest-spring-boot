package br.com.springboot.restspringboot.services;

import br.com.springboot.restspringboot.data.vo.v1.PersonVO;
import br.com.springboot.restspringboot.data.vo.v2.PersonVOV2;
import br.com.springboot.restspringboot.exception.ResourceNotFoundException;
import br.com.springboot.restspringboot.mapper.PersonMapper;
import br.com.springboot.restspringboot.mapper.PersonMapperV2;
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

    @Autowired
    PersonMapper personMapper;

    @Autowired
    PersonMapperV2 personMapperV2;

    public List<PersonVO> findAll() {
        logger.info("Finding all people");
        return personMapper.personToPersonVoList(repository.findAll());
    }

    public PersonVO findById(Long id) {

        logger.info("Finding person");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        return personMapper.personToPersonVo(entity);
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one person");
        var entity = personMapper.personVoToPerson(person);
        var vo = personMapper.personToPersonVo(repository.save(entity));
        return vo;
    }
    public PersonVOV2 createV2(PersonVOV2 person) {
        logger.info("Creating one person v2");
        var entity = personMapperV2.personVoV2ToPerson(person);
        var vo = personMapperV2.personToPersonVoV2(repository.save(entity));
        return vo;
    }

    public PersonVO update(PersonVO person) {
        logger.info("Update one person");
        var entity =  repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = personMapper.personToPersonVo(repository.save(entity));
        return vo;
    }

    public void deleteById(Long id) {
        logger.info("Delete one person");

        var entity =  repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
            repository.delete(entity);
    }
}
