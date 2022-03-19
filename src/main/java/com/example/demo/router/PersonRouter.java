package com.example.demo.router;

import com.example.demo.handler.PersonHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

/**
 * @author zxccong
 * @date 2022/3/19
 */
@Configuration
public class PersonRouter {

    @Bean
    public RouterFunction<ServerResponse> routerPerson(PersonHandler personHandler) {

        return RouterFunctions.route(RequestPredicates.GET("/person").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), personHandler::getPersons);
    }
}
