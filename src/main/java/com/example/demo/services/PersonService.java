package com.example.demo.services;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
    public List<Person> getAllPerson(){
        return personDao.selectAllPeople();
    }
    public Optional<Person> getPerson(String name){
        return personDao.selectPerson(name);
    }
    public int deletePerson(String name){
        return  personDao.deletePerson(name);
    }
    public int updatePerson(String name,Person person){
        return  personDao.updatePerson(name,person);
    }
}

