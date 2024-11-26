package develop;
import java.sql.*;
import java.util.*; 
public class Insert { 
private static final String Insert_Query="INSERT INTO student(stid,stname,stad) VALUES(?,?,?)"; 
public static void main(String[] args) { 
Scanner sc=new Scanner(System.in);
  try { 
   Class.forName("com.mysql.cj.jdbc.Driver"); 
  }catch(ClassNotFoundException e) { 
   e.printStackTrace(); 
  } 
  try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/week","root","2006")){ 
  PreparedStatement ps=con.prepareStatement(Insert_Query);{ 
   System.out.println("enter studentid:"); 
   int stid=sc.nextInt(); 
   System.out.println("Enter sname"); 
   String stname=sc.next(); 
   System.out.println("Enter sadress"); 
   String stad=sc.next(); 
   ps.setInt(1, stid); 
   ps.setString(2, stname); 
   ps.setString(3, stad); 
   int count=ps.executeUpdate(); 
   if(count==0) 
    System.out.println("Record is not registered"); 
   else 
    System.out.println("record is registered");  
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

