package scs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class InsertRecord {
	static Scanner sc = new Scanner(System.in);
void insertStudentData() throws ClassNotFoundException, SQLException
{
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ramdb","root","");
	Statement st = conn.createStatement();
	int rno;
	String sname;
	System.out.println("Enter rno");
	rno = sc.nextInt();
	System.out.println("Enter name");
	sname = sc.next();
	int x = st.executeUpdate("insert into stu(rno,sname) values('"+rno+"','"+sname+"')");
	if(x!=0)
	{
		System.out.println("Data Inserted Successfully");
	}
	else
	{
		System.out.println("Data Not Inserted Successfully");
	}
	
}
void updateStudentData() throws ClassNotFoundException, SQLException
{
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ramdb","root","");
	Statement st = conn.createStatement();
	int rno;
	String sname;
	System.out.println("Enter rno");
	rno = sc.nextInt();
	System.out.println("Enter name");
	sname = sc.next();
    int x = st.executeUpdate("update stu set sname='"+sname+"' where rno='"+rno+"'");
    if(x!=0)
	{
		System.out.println("Data Updated Successfully");
	}
	else
	{
		System.out.println("Data Not Updated Successfully");
	}
	
}

void showStudentData() throws ClassNotFoundException, SQLException
{
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ramdb","root","");
	Statement st = conn.createStatement();
	ResultSet x = st.executeQuery("select * from stu");
	while(x.next())
	{
		System.out.println(x.getString(1) + " " + x.getString(2) );
	}
	
	
}
void deleteStudentData() throws ClassNotFoundException, SQLException
{
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ramdb","root","");
	Statement st = conn.createStatement();
	int rno;
	String sname;
	System.out.println("Enter rno");
	rno = sc.nextInt();
	
    int x = st.executeUpdate("delete from stu where rno='"+rno+"'");
	if(x!=0)
	{
		System.out.println("Data Deleted Successfully");
	}
	else
	{
		System.out.println("Data Not Deleted Successfully");
	}
	
}
public static void main(String[] args) throws ClassNotFoundException, SQLException {
		InsertRecord obj = new InsertRecord();
		while(true)
		{
			System.out.println("Press 1 to Add record \n Press 2 Update record \n Press 3 for Delete Record \n 4 for Display Record \n press other to exit");
	        char ch = sc.next().charAt(0);
	        switch(ch)
	        {
	        case '1':
	        	
	        	obj.insertStudentData();
	        	break;
	        case '2':
	        
	        	obj.updateStudentData();
	        	break;
	        case '3':
	        	
	        	obj.deleteStudentData();
	        	break;
	       
	        case '4':
		        
	        	obj.showStudentData();
	        	break;	
	        default:
	        	System.exit(0);
	        	break;
	        	
	        }
		}

	}
	
	

}
