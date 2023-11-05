package br.com.springboot.restspringboot.mapper;

import br.com.springboot.restspringboot.data.vo.v2.PersonVOV2;
import br.com.springboot.restspringboot.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapperV2 {

    Person personVoV2ToPerson(PersonVOV2 person);


    @Mapping(target = "birthDay", expression = "java(new java.util.Date())")
    PersonVOV2 personToPersonVoV2(Person person);


}
