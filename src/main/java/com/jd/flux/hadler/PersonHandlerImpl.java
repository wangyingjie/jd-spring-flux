package com.jd.flux.hadler;

import com.jd.flux.bean.Person;
import com.jd.flux.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;


/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-12-07 18:01
 */
@Service
public class PersonHandlerImpl implements PersonHandler {

    @Resource
    private PersonService personService;

    @Override
    public Mono<ServerResponse> listPeople(ServerRequest request) {
        Flux<Person> people = personService.allPeople();
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(people, Person.class);
    }

    @Override
    public Mono<ServerResponse> createPerson(ServerRequest request) {
        Mono<Person> person = request.bodyToMono(Person.class);

        Person block = person.block();
        System.out.println("block================>" + block);

        return ServerResponse.ok().build(personService.savePerson(person));
    }

    @Override
    public Mono<ServerResponse> getPerson(ServerRequest request) {
        int personId = Integer.valueOf(request.pathVariable("id"));
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<Person> personMono = this.personService.getPerson(personId);
        return personMono
                .flatMap(person -> ServerResponse.ok().contentType(APPLICATION_JSON).body(fromObject(person)))
                .switchIfEmpty(notFound);
    }
}
