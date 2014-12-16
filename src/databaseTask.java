import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class databaseTask extends linkedGroup{
	private final String SQL_SERVERNAME ="localhost";
	private final String SQL_ID = "root";
	private final String SQL_PASS = "dbcjsdl92";
	private final String SQL_DBNAME = "test";
	private final String SQL_PORT ="3306";
	
	public int allCount=0;  
	public String teamArray[][] = new String[7][];
	
	private Statement stmt = null;
	private ResultSet rs = null;

	private Connection conn = null;
//////////////////////////////////////
	linkedGroup linkG = new linkedGroup();
	linkedGroup[] l_Teams = new linkedGroup[7];
	
	
	public void initDB() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://" + SQL_SERVERNAME + ":" + SQL_PORT + "/" + SQL_DBNAME;
			String option="?useUnicode=true&characterEncoding=EUC_KR";
            url = url + option;
            conn = (Connection) DriverManager.getConnection(url, SQL_ID, SQL_PASS);
            stmt = (Statement) conn.createStatement(); 
            rs = stmt.executeQuery("SELECT * FROM pikiTable");
            
            if(stmt.execute("SELECT * FROM pikiTable")){
            	rs = stmt.getResultSet();
            }
            
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("SQLException: " + e.getMessage());
		}
		
		try{
			while (rs.next()){
				int id = rs.getInt("id");
				String team = rs.getString("team");
				String name = rs.getString("name");


			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		discDB();
	}
	
	public void discDB() {
		try{
			if(stmt != null){
				stmt.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			if(conn != null){
				conn.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void createArray() {
		////////////////////////////
		
		
		
		String[] teamName = {"Develop","Design","Plan", "Server", "Contents", "CN", "ST"};
				
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://" + SQL_SERVERNAME + ":" + SQL_PORT + "/" + SQL_DBNAME;
			String option="?useUnicode=true&characterEncoding=EUC_KR";
            url = url + option;
            conn = (Connection) DriverManager.getConnection(url, SQL_ID, SQL_PASS);
			
            int count =0; 			
			stmt = (Statement) conn.createStatement();
			for(int i =0; i< teamName.length; i++){
				//////////////////////////////////
				l_Teams[i] = new linkedGroup();
				
				rs = stmt.executeQuery("select count(*) from pikiTable where team ='"+ teamName[i] +"'");
			
				while(rs.next()){
					count =rs.getInt(1);
				}
				teamArray[i] = new String[count];
				////////////////////////////////////////////////////////////비정방배열생성
				rs = stmt.executeQuery("select * from pikiTable where team ='"+ teamName[i] +"'");
				int j=0;
				while(rs.next()){
					///////////////////////
					
					l_Teams[i].add(j,rs.getString("name").toString());
					//System.out.println(l_Teams[i].toString());
					j++;		
				}
				/////////////////////////1213수정
				//linkG.add(i, l_Teams[i]);	
			}//for
			
			rs = stmt.executeQuery("select count(*) from pikiTable ");
			while(rs.next()){
				allCount =rs.getInt(1);
			}
		
		
			
		}catch(Exception e){
			e.printStackTrace();
		}
		discDB();
	}
}
