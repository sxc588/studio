package com.github.support.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.github.support.entitlement.entity.User;

@Controller
@RequestMapping("/api/user")
public interface RestUser
{
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  User get(@PathVariable long id);
	 
	 
	  @RequestMapping(value = "/{id}", method = RequestMethod.POST)
	  User update(@PathVariable long id, @RequestBody User updated);
}
