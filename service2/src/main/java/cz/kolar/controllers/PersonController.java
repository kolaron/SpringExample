package cz.kolar.controllers;


import cz.kolar.entities.Person;
import cz.kolar.services.PersonServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonServiceImpl service;

    public PersonController(PersonServiceImpl personService) {
        this.service = personService;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Person> findAll() {
        return service.getPersons();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public List<Person> addUsers(@RequestBody List<Person> persons) {
        return service.addPersons(persons);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Person updateUser(@RequestBody Person person) {
        return service.updatePerson(person);
    }

    @RequestMapping(value = "/find")
    @ResponseBody
    public Optional<Person> findByID(@RequestParam String id) {
        try {
            Long num = Long.parseLong(id);
            return service.findByID(num);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @RequestMapping(value = "/remove")
    @ResponseBody
    public void removeByID(@RequestParam String id) {
        try {
            Long num = Long.parseLong(id);
            service.removePersonByID(num);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/removeAll")
    public void removeAll() {
        service.removeAll();
    }
}
