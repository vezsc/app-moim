package controller.moim;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import data.Moim;

@WebServlet("/moim/search")
public class MoimSearchController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String[] cates = req.getParameterValues("cate");

		int p;
		if (req.getParameter("page") == null) {
			p = 1;
		} else {
			p = Integer.parseInt(req.getParameter("page"));
		}

		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("a", (p - 1) * 6 + 1); // "a" , p*6-5;
		map.put("b", 6 * p);
		map.put("arr", cates);
	//	List<Moim> list = sqlSession.selectList("moims.findSomeByCates", cates);
		List<Moim> list = sqlSession.selectList("moims.findSomeByAtoBInCates", map);
		// List<Moim>list =Moims.findByCate(cates);

		int total = sqlSession.selectOne("moims.countDatas",cates);

		sqlSession.close();

		int lastPage = total / 6 + (total % 6 > 0 ? 1 : 0);

		req.setAttribute("list", list);

		int start = ((p - 1) / 5) * 5 + 1;
		int last = (int) Math.ceil(p / 5.0) * 5;
		last = last > lastPage ? lastPage : last;
		req.setAttribute("start", start); // p 기준 (1~5)==>1 /(6~10)==>6 /(11~15)==>11
		req.setAttribute("last", last); // p 기준 (1~5)==>5 /(6~10)==>10 /(11~15)==>15

		boolean existPrev = p >= 6;
		boolean existNext= lastPage >last;
		req.setAttribute("existPrev", existPrev);
		req.setAttribute("existNext", existNext);
		req.getRequestDispatcher("/WEB-INF/views/moim/search.jsp").forward(req, resp);
	}
}
