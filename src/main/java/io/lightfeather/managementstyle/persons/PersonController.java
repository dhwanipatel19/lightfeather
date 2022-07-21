package io.lightfeather.managementstyle.persons;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PersonController {
    // @Autowired private PersonService personService;

    @PostMapping(value="/submit", consumes = "application/json", produces = "application/json")
    public void addPerson(@Valid @RequestBody Person person) {  // validates the person input
        System.out.println("Person to add: " + person.toString());
    }

    
}
