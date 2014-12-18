

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dbServlet
 */
@WebServlet("/dbServlet")
public class dbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Vector<String> pikiteam  ;
	public Vector<String> pikiname ;
	
	
	databaseTask DBtask =new databaseTask();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public dbServlet() {
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
		
		
		DBtask.countTable();
		DBtask.initDB();
		
		
		try{
		pikiteam = new Vector<String>();
		pikiname = new Vector<String>();	
		
		for(int i=0; i<DBtask.pikitablename.length;i++){
			pikiteam.add(DBtask.pikitableteam[i]);
			pikiname.add(DBtask.pikitablename[i]);
		}
		
		request.setAttribute("pikiteam", pikiteam);
		request.setAttribute("pikiname", pikiname);
		RequestDispatcher rd = request.getRequestDispatcher("/inqurieTeam.jsp");
		rd.forward(request, response);
		}catch(Exception e){
			System.out.println("list error:"+e.getMessage());
		    e.printStackTrace();
		}
		
		
		
		
		
		PrintWriter out = response.getWriter();
		/*
		out.println("db¼­ºí¸´");
		out.println("<input type=submit value>");
		
		out.println("<head><style>");
		out.println("table {border-collapse:collapse; }");
		out.println("table, th, td {border:1px solid black; }");
		out.println("th, td {padding:5px; }");
		out.println("</style></head>");
					
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>"+ "Team" +"</th>");
		out.println("<th>"+ "Name" +"</th>");
		out.println("<th>"+ "Check" +"</th>");
		for(int i=0; i<DBtask.allCount; i++) {
			out.println("</tr>");

			out.println("<td>"+ DBtask.pikitableteam[i] +"</td>");
	        out.println("<td>"+ DBtask.pikitablename[i] +"</td>");
	        out.println("<td>"+"<input type=radio name =ch value=i>"+"</td>");

	        out.println("</tr>");
	    }
		out.println("</table>");*/
	}

		
	

}
