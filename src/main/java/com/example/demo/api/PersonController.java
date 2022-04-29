package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RequestMapping("table")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPerson();
    }

    @GetMapping(path = "{name}")
    public Person getPerson(@PathVariable("name") String name){
        return personService.getPerson(name).orElse(null);
    }

    @DeleteMapping(path = "{name}")
    public  void deletePerson(@PathVariable("name") String name){
         personService.deletePerson(name);
    }

    @PutMapping(path = "{name}")
    public void updatePerson(@PathVariable("name") String name ,@RequestBody Person updatePerson){
        personService.updatePerson(name,updatePerson);
    }
}
