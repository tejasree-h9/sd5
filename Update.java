package develop;
import java.sql.*;
import java.util.*;
public class Update {
private static final String UPDATE_Query="UPDATE student SET stname=? WHERE stid=?";
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
try {
Class.forName("com.mysql.cj.jdbc.Driver");
}catch(ClassNotFoundException e) {
e.printStackTrace();
}
try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/week","root","2006")){
PreparedStatement ps=con.prepareStatement(UPDATE_Query);{
System.out.println("enter studentid:");
int stid=sc.nextInt();
System.out.println("Enter updation sname");
String stname=sc.next();
ps.setString(1, stname);
ps.setInt(2, stid);
int count=ps.executeUpdate();
if(count==0) 
System.out.println("Record is not updated");
else 
System.out.println("record is updated");
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
