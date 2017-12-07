package com.jd.flux.service;

import com.jd.flux.bean.Person;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-12-06 18:43
 */
public interface PersonService {

    Person getById(Integer id);

    Person add(Person person);

    Flux<Person> allPeople();

    Mono<Person> getPerson(int personId);

    BiFunction<ServerWebExchange, ServerResponse.Context, Mono<Void>> savePerson(Mono<Person> person);

}
