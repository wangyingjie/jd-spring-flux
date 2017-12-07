package com.jd.flux.config;

import com.jd.flux.hadler.PersonHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-12-07 18:43
 */
@Configuration
public class RoutesFunction {

    @Autowired
    private PersonHandler personHandler;

    @Bean
    public RouterFunction<?> routerFunction() {

        RouterFunction<ServerResponse> personRoute =
                route(GET("/person/{id}").and(accept(APPLICATION_JSON)), personHandler::getPerson)
                        .andRoute(GET("/person").and(accept(APPLICATION_JSON)), personHandler::listPeople)
                        .andRoute(POST("/person/save").and(contentType(APPLICATION_JSON)), personHandler::createPerson);


        return personRoute;
    }
}
