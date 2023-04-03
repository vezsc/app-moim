package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.User;

@WebFilter({"/moim/create","/moim/join-task"})
public class AuthFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String uri=request.getRequestURI();
		//System.out.println("doFilter...");
	
		boolean logon=(boolean)request.getSession().getAttribute("logon");
		User logonUser=(User)request.getSession().getAttribute("logonUser");
		// if를 걸어서
		//현재 요청을 보낸 사용자의 세선에 logon 값이 true 면 필터 통과
		
		//그게 아니면 /flow/login.jsp 로 리 다이렉트 시키는 필터를 만들어보자
		
		if(!logon && logonUser ==null) {
			response.sendRedirect("/user/login?url="+uri);
		}else {
			chain.doFilter(request, response);//필터 통과시켜주는	
		}
		
	}

}
