package com.jd.flux.hadler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-12-07 18:01
 */
public interface PersonHandler {

    Mono<ServerResponse> listPeople(ServerRequest request);

    Mono<ServerResponse> createPerson(ServerRequest request);

    Mono<ServerResponse> getPerson(ServerRequest request);
}
