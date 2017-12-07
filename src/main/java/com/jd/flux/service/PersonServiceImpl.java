package com.jd.flux.service;

import com.jd.flux.bean.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-12-06 18:43
 */
@Service
public class PersonServiceImpl implements PersonService {

    private static Map<Integer, Person> map = new HashMap<>();

    static {
        for (int i = 0; i < 5; i++) {
            map.put(i, new Person(i, "name" + i));
        }
    }


    @Override
    public Person getById(Integer id) {
        return map.get(id);
    }

    @Override
    public Person add(Person person) {
        map.put(person.getId(), person);
        return person;
    }

    @Override
    public Flux<Person> allPeople() {
        return Flux.fromStream(map.values().stream());
    }

    @Override
    public Mono<Person> getPerson(int personId) {
        return Mono.justOrEmpty(map.get(personId));
    }

    @Override
    public BiFunction<ServerWebExchange, ServerResponse.Context, Mono<Void>> savePerson(Mono<Person> person) {

        // todo

        Person personModel = person.block();

//        BiFunction<ServerWebExchange, ServerResponse.Context, Mono<Void>> xxx =

        return null;
    }

}
