package com.github.support.user;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class User
{

//	@NotNull
//	@Pattern(regexp = "[a-zA-Z0-9_]{5,10}", message = "{user.username.illegal}")
	private String username;

//	@Size(min = 6, max = 10)
	private String password;
	// 省略setter/getter
	public User(String username, String password)
	{
		super();
		this.username = username;
		this.password = password;
	}
	public User()
	{
		super();
	}
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
