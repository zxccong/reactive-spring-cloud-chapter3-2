package com.example.demo.handler;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author zxccong
 * @date 2022/3/19
 */
@Component
public class PersonHandler {

    @Autowired
    private PersonService personService;

    public Mono<ServerResponse> getPersons(ServerRequest request) {
//        request.body(BodyExtractors.toMono(String.class));
//        request.body(BodyExtractors.toFlux(Person.class));
//
//        ServerResponse.ok().body(BodyInserters.fromValue("Hello World"));
        final String id = request.pathVariable("id");
        return ServerResponse.ok().body(this.personService.getProducts(), Person.class);
    }


    public Mono<ServerResponse> getPersonById(ServerRequest request) {
//        request.body(BodyExtractors.toMono(String.class));
//        request.body(BodyExtractors.toFlux(Person.class));
//
//        ServerResponse.ok().body(BodyInserters.fromValue("Hello World"));
        final String id = request.pathVariable("id");
        return ServerResponse.ok().body(this.personService.getProductById(id), Person.class);
    }



}
