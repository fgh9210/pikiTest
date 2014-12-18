

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
		DBtask.deleteTeamTable(request.getParameter("Team"),request.getParameter("Name"));
		DBtask.teamPeopleArray(request.getParameter("Team"),request.getParameter("Name"));
		teamPeople = new Vector<String>();
		
		//for(int i=0; i<DBtask.teamPeopleName.length;i++){
		//	teamPeople.add(DBtask.teamPeopleName[i]);
		//}
		
		request.setAttribute("teamPeopleName", DBtask.teamPeopleName);
		RequestDispatcher rd = request.getRequestDispatcher("/deleteTeam.jsp");
		rd.forward(request, response);

		
		
		DBtask.deleteTeamTable(request.getParameter("Name"));
		//PrintWriter out = response.getWriter();
		//out.println(request.getParameter("Team")+request.getParameter("Name"));
		

		
	}

}
