package com.awadhesh22791.service.impl;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.awadhesh22791.entity.User;
import com.awadhesh22791.repository.UserRepository;
import com.awadhesh22791.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements ReactiveUserDetailsService, UserService {

	@Autowired(required = false)
	private UserRepository userRepository;
	
	@Autowired(required = false)
	private PasswordEncoder passwordEncoder;

	@Override
	public Mono<UserDetails> findByUsername(String username) {
		return userRepository.findByUsername(username)
				.switchIfEmpty(Mono.defer(() -> Mono.error(new UsernameNotFoundException("User not found."))))
				.map(User::toAuthUser);
	}

	@Override
	public Flux<User> findAll(String username) {
		if(username==null || username.isEmpty()) {
			return null;//userRepository.findAll();
		} else {
			return userRepository.findAllByUsernameStartsWithIgnoringCase(username);
		}
	}

	@Override
	public Mono<User> create(User user) {
		//user.setId(Uuids.timeBased());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Mono<User> savedTodo = null;//userRepository.save(user);
		return savedTodo;
	}

	@Override
	public Mono<User> update(User user) {
		return null;/*userRepository.findById(user.getId()).flatMap(existingUser -> {
			existingUser.setUsername(user.getUsername());
			if(user.getPassword()!=null && !user.getPassword().isEmpty()) {
				existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			return userRepository.save(existingUser);
		});*/
	}

	@Override
	public Mono<User> findById(String id) {
		return null;//userRepository.findById(UUID.fromString(id));
	}

	@Override
	public Mono<Boolean> delete(String id) {
		return null;/*userRepository.findById(UUID.fromString(id)).flatMap(existingTodo -> {
			return userRepository.delete(existingTodo).then(Mono.just(true));
		});*/
	}

	@Override
	public Mono<Long> countUsers() {
		return null;//userRepository.count();
	}

}