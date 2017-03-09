package com.github.controller;  
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class ApiController extends BaseController
{
	private Logger log = LoggerFactory.getLogger(ApiController.class);

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Item get(@PathVariable
	String id, HttpServletRequest request)
	{
		Item item = new Item();
		item.setId(id);
		item.setName("name");
		return item;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void post(Item item, HttpServletRequest request)
	{
		log.info("post item:{}", item.toString());
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public
			void
			put(@RequestBody
			Item item, HttpServletRequest request)
	{
		log.info("put item:{}", item.toString());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable
	String id, HttpServletRequest request)
	{
		log.info("delete id:{}", id);
	}

}