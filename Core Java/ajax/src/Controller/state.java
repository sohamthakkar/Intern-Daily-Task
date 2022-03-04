package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.stateDAO;
import VO.stateVO;
import VO.countryVO;

/**
 * Servlet implementation class state
 */
@WebServlet("/state")
public class state extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public state() {
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
			response.sendRedirect("statedynamic1.jsp");
		}
	}

	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int countryId=Integer.parseInt(request.getParameter("con"));
		
		countryVO v1=new countryVO();
		v1.setCountryId(countryId);
		
		stateVO v2=new stateVO();
		
		stateDAO d=new stateDAO();
		List ls=d.search(v2,v1);
		
		HttpSession s=request.getSession();
		s.setAttribute("statelist",ls);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
