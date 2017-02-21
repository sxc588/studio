package com.huawei.support.enterprise.web.filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

public class SessionFilter implements Filter
{

	private static org.slf4j.Logger LOG = LoggerFactory.getLogger(SessionFilter.class);

	/**
	 * 判断是否为Ajax请求
	 * 
	 * @param request
	 * @return 是true, 否false
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean isAjaxRequest(HttpServletRequest request)
	{
		String header = request.getHeader("X-Requested-With");
		if (header != null && "XMLHttpRequest".equals(header)) return true;
		else return false;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		// TODO Auto-generated method stub

	}

	/**
	 * 登录验证过滤器
	 */
	@Override
	public
			void
			doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
																												throws IOException,
																												ServletException
	{
		// 不过滤的uri
		String[] notFilter = new String[]{"/images", "/js", "/css", "/login", "/login/mainframe", "/user/exist", "/user/checkPassword", "/signcode"};

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		HttpSession session = request.getSession();

		// 请求的uri
		String uri = request.getRequestURI();
		LOG.info(uri);
		// 是否过滤
		boolean doFilter = true;
		for (String s : notFilter)
		{
			if (uri.indexOf(s) != -1)
			{
				// 如果uri中包含不过滤的uri，则不进行过滤
				doFilter = false;
				break;
			}
		}



		if (doFilter)
		{
			// 执行过滤
			// 从session中获取登录者实体
			Object obj = request.getSession().getAttribute(SessionKeyContent.SESSION_KEY_OBJ_USER_BEAN);
			if (null == obj)
			{
				boolean isAjaxRequest = isAjaxRequest(request);
				if (isAjaxRequest)
				{
					response.setCharacterEncoding("UTF-8");
					response.sendError(HttpStatus.UNAUTHORIZED.value(), "您已经太长时间没有操作,请刷新页面");
					return;
				}

				response.sendRedirect(request.getContextPath() + "/login/tologin.jsp");
				return;
			}
			else
			{
				Object url = request.getSession().getAttribute(SessionKeyContent.SESSION_KEY_URL);

				// response.sendRedirect(request.getContextPath() +
				// url.toString());
				// 如果session中存在登录者实体，则继续
				filterChain.doFilter(request, response);
			}
		}
		else
		{
			// 如果不执行过滤，则继续
			filterChain.doFilter(request, response);
		}

	}

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub

	}

}
