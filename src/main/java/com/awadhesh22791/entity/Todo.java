package com.awadhesh22791.entity;

import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import lombok.Data;

@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class Todo {
	private UUID id;
	private String todo;
	private boolean completed;
}
