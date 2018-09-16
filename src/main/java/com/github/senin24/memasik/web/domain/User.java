package com.github.senin24.memasik.web.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String login;
	private String password;
	private String email;
	private String coockie;
	
	protected User() {}

	public User(String name, String login) {
		this.name = name;
		this.login = login;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", login=" + login + ", email=" + email + "]";
	}
	
	

}
