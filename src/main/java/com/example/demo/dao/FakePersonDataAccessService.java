package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public  class FakePersonDataAccessService implements PersonDao {
    private static List<Person> DB = new ArrayList<>()
    {{add(new Person( "trung",1000,"Da Nang"));
        add(new Person( "Thien",123,"Sai Gon"));
        add(new Person( "Ngoc",2838.2f,"Vaasa"));
        add(new Person( "Adam",2322.f,"Helsinki"));
        add(new Person( "Jani",9999.123f,"France"));
        add(new Person( "Rayko",10020,"Oulu"));
        add(new Person( "Lien",10200.2f,"Da Nang"));
        add(new Person( "Aichi",10200.2f,"Tokyo"));
        ;}};

    @Override
    public  int insertPerson(UUID id,Person person){
        DB.add(new Person(id,person.getName() ,person.getMoney(), person.getLocation(), person.getSaving()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople(){
        return DB;
    }

    @Override
    public Optional<Person> selectPerson(String name) {
        return DB.stream().filter(person -> person.getName().equals(name)).findFirst();
    }

    @Override
    public int deletePerson(String name) {
        Optional<Person> deletePerson = selectPerson(name);
        if(deletePerson.isEmpty()){
            return 0;
        }
        DB.remove(deletePerson.get());
        return 1;
    }

    @Override
    public int updatePerson(String name, Person person) {
        return selectPerson(name).map(p ->{
            int index = DB.indexOf(p);
            UUID newId = UUID.randomUUID();
            if(index >= 0){
                DB.set(index, new Person(newId, person.getName(), person.getMoney(), person.getLocation(), person.getSaving()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }

}

