package com.awadhesh22791.repository;

import org.springframework.stereotype.Repository;

import com.awadhesh22791.entity.Todo;

import reactor.core.publisher.Flux;

@Repository
public interface TodoRepository{

	Flux<Todo> findAllByTodoStartsWithIgnoringCase(String todo);

}
