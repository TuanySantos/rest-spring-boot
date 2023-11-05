package br.com.springboot.restspringboot.mapper;

import br.com.springboot.restspringboot.data.vo.v1.PersonVO;
import br.com.springboot.restspringboot.model.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person personVoToPerson(PersonVO person);
    PersonVO personToPersonVo(Person person);

    List<PersonVO> personToPersonVoList(List<Person> person);
}
