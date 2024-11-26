package develop;
import java.sql.*;
import java.util.*;
public class Select {
private static final String SELECT_Query="SELECT stid,stname,stad FROM student";
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
try {
Class.forName("com.mysql.cj.jdbc.Driver");
}catch(ClassNotFoundException e) {
e.printStackTrace();
}
try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/week","root","2006")){
PreparedStatement ps=con.prepareStatement(SELECT_Query);{
ResultSet rs=ps.executeQuery();
while(rs.next()) {
System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
}
}
}catch(SQLException se) {
System.out.println(se.getMessage());
se.printStackTrace();
}catch(Exception e) {
System.out.println(e.getMessage());
e.printStackTrace();
}
}
}
