package com.awadhesh22791.entity;

import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import com.awadhesh22791.dto.AuthenticatedUser;

import lombok.Data;
import lombok.ToString;

@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
@ToString
public class User {
	@Id
	private UUID id;
	private String username;
	private String password;

	public AuthenticatedUser toAuthUser() {
		AuthenticatedUser user = new AuthenticatedUser(this.username, this.password, null);
		return user;
	}
}