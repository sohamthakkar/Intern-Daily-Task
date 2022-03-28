package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import DAO.registerDAO;
import VO.registerVO;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String flag=request.getParameter("flag"); //doubt over here id flag
		
		if(flag.equals("search")){
			search(request,response);
			response.sendRedirect("registerjson.jsp");
		}
	}

	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		registerVO v2=new registerVO();
		
		registerDAO d=new registerDAO();
		List ls=d.search(v2);
		
		HttpSession s=request.getSession();
		s.setAttribute("list",ls);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	
		String flag=request.getParameter("flag");
		
		if(flag.equals("insert")){
			insert(request,response);
			//response.sendRedirect("registerajax1.jsp");
		}
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		registerVO v1=new registerVO();
		
		registerDAO d=new registerDAO();
		d.insert(v1);
		
	}
	
}
