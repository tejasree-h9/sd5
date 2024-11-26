package develop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class Delete {
private static final String DELETE_QUERY="DELETE FROM student WHERE stid=?";
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
try {
Class.forName("com.mysql.cj.jdbc.Driver");
}catch(ClassNotFoundException e) {
e.printStackTrace();
}
try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/week","root","2006")){
PreparedStatement ps=con.prepareStatement(DELETE_QUERY);{
System.out.println("enter the studentid which to delete:");
int studentid=sc.nextInt();
ps.setInt(1, studentid);
int count=ps.executeUpdate();
if(count==0) 
System.out.println("Record is not deleted");
else 
System.out.println("record is deleted");
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
