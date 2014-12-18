import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class databaseTask extends linkedGroup{
	private final String SQL_SERVERNAME ="localhost";
	private final String SQL_ID = "root";
	private final String SQL_PASS = "dbcjsdl92";
	private final String SQL_DBNAME = "test";
	private final String SQL_PORT ="3306";
	
	public int allCount;  
	public String pikitableteam[] ; 
	public String pikitablename[] ; 
	
	private Statement stmt = null;
	private ResultSet rs = null;
	private Connection conn = null;
	private PreparedStatement pstmt =null;
	String[] teamName = {"Develop","Design","Plan", "Server", "Contents", "CN", "ST"};
	public String[] teamPeopleName;
	linkedGroup[] l_Teams = new linkedGroup[7];
	linkedGroup[] l_Capability = new linkedGroup[7];

	
	
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
			int i=0;
			pikitableteam = new String[allCount];
			pikitablename = new String[allCount];

			while (rs.next()){
				pikitableteam[i] = rs.getString("team");
				pikitablename[i] = rs.getString("name");
				i++;

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
		try{
			if(pstmt != null){
				pstmt.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void createArray() {
				
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://" + SQL_SERVERNAME + ":" + SQL_PORT + "/" + SQL_DBNAME;
			String option="?useUnicode=true&characterEncoding=EUC_KR";
            url = url + option;
            conn = (Connection) DriverManager.getConnection(url, SQL_ID, SQL_PASS);
			
            int count =0; 			
			stmt = (Statement) conn.createStatement();
			for(int i =0; i< teamName.length; i++){
				l_Teams[i] = new linkedGroup();
				l_Capability[i] = new linkedGroup();
				rs = stmt.executeQuery("select count(*) from pikiTable where team ='"+ teamName[i] +"'");
				while(rs.next()){
					count =rs.getInt(1);
				}
				
				////////////////////////////////////////////////////////////링크드리스트로 팀원 추가
				rs = stmt.executeQuery("select * from pikiTable where team ='"+ teamName[i] +"'");
				int j=0;
				while(rs.next()){
					l_Teams[i].add(j,rs.getString("name").toString());
					l_Capability[i].add(j, rs.getString("capability"));
					j++;		
				}	
			}//for
					
		}catch(Exception e){
			e.printStackTrace();
		}
		discDB();
	}
	
	public void teamPeopleArray(String team, String name) {
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://" + SQL_SERVERNAME + ":" + SQL_PORT + "/" + SQL_DBNAME;
			String option="?useUnicode=true&characterEncoding=EUC_KR";
            url = url + option;
            conn = (Connection) DriverManager.getConnection(url, SQL_ID, SQL_PASS); 			
			stmt = (Statement) conn.createStatement();
			
			int count =0;
			rs = stmt.executeQuery("select count(*) from pikiTable where team ='"+ team +"'");
			while(rs.next()){
				count =rs.getInt(1);
			}
			
			teamPeopleName= new String[count];
			rs = stmt.executeQuery("select Name from pikiTable where team ='"+ team +"'");
			int i=0;
			while(rs.next()){
				teamPeopleName[i] =rs.getString("name");
				i++;
			}
					
		}catch(Exception e){
			e.printStackTrace();
		}
		discDB();
	}
	
	public void countTable() {
				
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://" + SQL_SERVERNAME + ":" + SQL_PORT + "/" + SQL_DBNAME;
			String option="?useUnicode=true&characterEncoding=EUC_KR";
            url = url + option;
            conn = (Connection) DriverManager.getConnection(url, SQL_ID, SQL_PASS);
			stmt = (Statement) conn.createStatement();
			
        	rs = stmt.executeQuery("select count(*) from pikiTable ");
			while(rs.next()){
				allCount =rs.getInt(1);
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		discDB();
	}
	
	public void insertTeamTable(String team, String name) {
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://" + SQL_SERVERNAME + ":" + SQL_PORT + "/" + SQL_DBNAME;
			String option="?useUnicode=true&characterEncoding=EUC_KR";
            url = url + option;
            
            String sql="insert into pikiTable(Team,Name) Values(?,?)";
            //insert into pikiTable(Team,Name) Values(ST, ST12)
            conn = (Connection) DriverManager.getConnection(url, SQL_ID, SQL_PASS);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, team);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		discDB();
	}
	
	public void deleteTeamTable(String team, String name){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://" + SQL_SERVERNAME + ":" + SQL_PORT + "/" + SQL_DBNAME;
			String option="?useUnicode=true&characterEncoding=EUC_KR";
            url = url + option;
            
            String sql="delete from pikiTable where Team=? and Name =?";
            conn = (Connection) DriverManager.getConnection(url, SQL_ID, SQL_PASS);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, team);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		discDB();
	}
	
	public void deleteTeamTable( String name){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://" + SQL_SERVERNAME + ":" + SQL_PORT + "/" + SQL_DBNAME;
			String option="?useUnicode=true&characterEncoding=EUC_KR";
            url = url + option;
            
            String sql="delete from pikiTable where Name =?";
            conn = (Connection) DriverManager.getConnection(url, SQL_ID, SQL_PASS);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		discDB();
	}
}
