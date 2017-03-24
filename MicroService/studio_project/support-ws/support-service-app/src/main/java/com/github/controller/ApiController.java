package com.github.controller;
import javax.servlet.http.HttpServletRequest;
import org.eclipse.jetty.server.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.github.support.entitlement.entity.User;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

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

	/**
	 * 根据用户名获取用户对象
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据用户名获取用户对象", httpMethod = "GET", response = ApiResult.class, notes = "根据用户名获取用户对象")
	public ApiResult<User> getUserByName(@ApiParam(required = true, name = "name", value = "用户名")
	@PathVariable
	String name) throws Exception
	{
		User ucUser = ucUserManager.getUserByName(name);

		if (ucUser != null)
		{
			ApiResult<User> result = new ApiResult<User>();
			result.setCode(ResultCode.SUCCESS.getCode());
			result.setData(ucUser);
			return result;
		}
		else
		{
			throw new BusinessException("根据{name=" + name + "}获取不到UcUser对象");
		}
	}

}