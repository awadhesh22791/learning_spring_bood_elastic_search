package com.awadhesh22791.repository;
import org.springframework.stereotype.Repository;

import com.awadhesh22791.entity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository {

	Mono<User> findByUsername(String todo);

	Flux<User> findAllByUsernameStartsWithIgnoringCase(String username);

}