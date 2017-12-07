package com.jd.flux.web;

import com.jd.flux.bean.Person;
import com.jd.flux.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-12-06 18:41
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Integer id) {
        // ...

        return personService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(/*@RequestBody*/ Person person) {
        // ...
        if (Objects.isNull(person)) {
            return;
        }

        personService.add(person);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addJson(@RequestBody Person person) {
        // ...
        if (Objects.isNull(person)) {
            return;
        }

        personService.add(person);
    }
}