package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 쿠키 ..?
		// 브라우저에서 관리되는 것으로 데이터를 담긴 일종의 파일이라고 보면 된다.
		// 쿠기에는 도메인값(쿠키 발행처) 이 있는데
		// 브라우저는 웹 요청을 보낼때 발행처가 같다면 쿠키를 자동으로 포함시켜 전송을 하게 되어있다

		// 백엔드쪽에서는 클라이언트가 보낸 쿠키들을 확인하는게 가능하다

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {

			for (Cookie c : cookies) {
				System.out.println(c.toString());
			}
		} else {

			System.out.println("not found cookie");
		}
		req.getRequestDispatcher("/WEB-INF/views/test.jsp").forward(req, resp);
	}
}

//@Override
//protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	String message = "오늘 하루 힘드네 참.";
//
//
//	for (int cnt = 1; cnt <= 5; cnt++) {
//		String hashed = BCrypt.hashpw(message, BCrypt.gensalt());
//		System.out.println(hashed);
//	boolean f=	message.equals(hashed);
//	System.out.println("string.equals= "+f);
//	
//	boolean ff=BCrypt.checkpw(message, hashed);
//	System.out.println("BCrypt.checkpw= "+ff);
//	}
//}
