package com.github.support.quartz.model;

public class User {
	private String nickname;
	private String password;
	private String username;

	public String getNickname() {
		return nickname;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", nickname=" + nickname + "]";
	}

}
