package br.com.springboot.restspringboot.mapper;

import br.com.springboot.restspringboot.data.vo.v1.PersonVO;
import br.com.springboot.restspringboot.model.Person;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-07T23:03:07-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Amazon.com Inc.)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person personVoToPerson(PersonVO person) {
        if ( person == null ) {
            return null;
        }

        Person person1 = new Person();

        person1.setFirstName( person.getFirstName() );
        person1.setId( person.getId() );
        person1.setLastName( person.getLastName() );
        person1.setAddress( person.getAddress() );
        person1.setGender( person.getGender() );

        return person1;
    }

    @Override
    public PersonVO personToPersonVo(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonVO personVO = new PersonVO();

        personVO.setFirstName( person.getFirstName() );
        personVO.setId( person.getId() );
        personVO.setLastName( person.getLastName() );
        personVO.setAddress( person.getAddress() );
        personVO.setGender( person.getGender() );

        return personVO;
    }

    @Override
    public List<PersonVO> personToPersonVoList(List<Person> person) {
        if ( person == null ) {
            return null;
        }

        List<PersonVO> list = new ArrayList<PersonVO>( person.size() );
        for ( Person person1 : person ) {
            list.add( personToPersonVo( person1 ) );
        }

        return list;
    }
}
