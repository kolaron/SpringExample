package cz.kolar.Controllers;

import cz.kolar.Entities.Person;
import cz.kolar.Services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private Service service;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Person> remove() {
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
    public Person findByID(@RequestParam(value = "id") String id) {
        try {
            Long num = Long.parseLong(id);
            return service.findByID(num);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @RequestMapping(value = "/remove")
    @ResponseBody
    public void removeByID(@RequestParam(value = "id") String id) {
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
