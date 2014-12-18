

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	databaseTask DBtask =new databaseTask();
	public Vector<String> teamPeople;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=euc-kr");
		
		//if(request.getParameter("Team") and request.getParameter("Name"))
		//String team = request.getParameter("Team");
		//String name =request.getParameter("Name");
		DBtask.deleteTeamTable(request.getParameter("Team"),request.getParameter("Name"));
		DBtask.deleteTeamTable(request.getParameter("Name"));
		
		request.setAttribute("name", request.getParameter("Name"));
		
		RequestDispatcher rd = request.getRequestDispatcher("/deleteOK.jsp");
		rd.forward(request, response);
	}

}
