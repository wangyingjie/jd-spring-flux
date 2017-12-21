package com.jd.flux.web;

import com.jd.flux.bean.Person;
import com.jd.flux.hadler.PersonHandler;
import com.jd.flux.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


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

    @Autowired
    private PersonHandler personHandler;

    @GetMapping("/hello")
    public String handle() {
        return "Hello WebFlux";
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Integer id) {
        // ...

        return personService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Person> add(/*@RequestBody*/ Person person) {
        // ...
        if (Objects.isNull(person)) {
            return Mono.empty();
        }

        System.out.println("xxxxxxx");

        Person addPerson = personService.add(person);

        return Mono.just(addPerson);
    }

    @PostMapping("/addJson")
    @ResponseStatus(HttpStatus.CREATED)
    public void addJson(@RequestBody Person person) {
        // ...
        if (Objects.isNull(person)) {
            return;
        }

        personService.add(person);
    }

    @GetMapping(path = "/pets/{id}", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Person getPet(@PathVariable int id) {
        return personService.getById(id);
    }

    @GetMapping(path = "/list")
    public Mono<ServerResponse> getPersonList(ServerRequest request) {

        return personHandler.listPeople(request);
    }

    @RequestMapping(value = "/sendVoice", method = RequestMethod.POST)
    public Flux<Map<String, String>> receiveVoice(@RequestParam MultipartFile fileData) {
        String fileName = fileData.getOriginalFilename();

        Map<String, String> payload = new HashMap<>();
        payload.put("message", "ファイルを受領しました。： " + fileName);

        return Flux.just(payload);
    }
}