package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.cityVO;
import DAO.cityDAO;
import VO.stateVO;
/**
 * Servlet implementation class city
 */
@WebServlet("/city")
public class city extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public city() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	String flag=request.getParameter("flag");
	
		if(flag.equals("search")){
			search(request,response);
			response.sendRedirect("citydynamic1.jsp");
		}
	}

	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int stateId=Integer.parseInt(request.getParameter("sta"));
		stateVO v2=new stateVO();
		v2.setStateId(stateId);
		
		cityVO v3=new cityVO();
		
		cityDAO d=new cityDAO();
		List ls=d.search(v3,v2);

		HttpSession s=request.getSession();
		s.setAttribute("citylist",ls);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
