package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personSerivce;

    @Autowired
    public PersonController(PersonService personService){
        this.personSerivce = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personSerivce.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personSerivce.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personSerivce.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personSerivce.deletePersonById(id);
    }
    @PutMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id")UUID id, @Valid @RequestBody Person personToUpdate){
        personSerivce.updatePersonById(id, personToUpdate);
    }
}



