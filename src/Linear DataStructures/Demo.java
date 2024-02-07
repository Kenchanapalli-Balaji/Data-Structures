package Algorithms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;

public class Demo 
{
	String Empno;
	String EmpName;
	String Designation;
	Date Doj;
	
	
	public String getEmpno() {
		return Empno;
	}


	public void setEmpno(String empno) {
		Empno = empno;
	}


	public String getEmpName() {
		return EmpName;
	}


	public void setEmpName(String empName) {
		EmpName = empName;
	}


	public String getDesignation() {
		return Designation;
	}


	public void setDesignation(String designation) {
		Designation = designation;
	}


	public Date getDoj() {
		return Doj;
	}
	public void setDoj(Date doj) {
		Doj = doj;
	}

	public Demo(String empno, String empName, String designation, Date doj) {
		super();
		Empno = empno;
		EmpName = empName;
		Designation = designation;
		Doj = doj;
	}
	public Demo()
	{
		
	}


	@Override
	public String toString() {
		return "Demo [Empno=" + Empno + ", EmpName=" + EmpName + ", Designation=" + Designation + ", Doj=" + Doj + "]";
	}


	

	public int displayExperience(String eno)
	{
		Demo employee;
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/edu";
		String un="root";
		String pw="Balu@359";
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,un,pw);
			Statement stmt=con.createStatement();
			ResultSet res= stmt.executeQuery("select * from employee where Empno="+eno );
			while(res.next())
			{
				String num=res.getString(1);
				String name=res.getString(2);
				String des=res.getString(3);
				Date d=res.getDate(4);
				employee=new Demo(num,name,des,d);
				LocalDate currentDate=java.time.LocalDate.now();
				int days=currentDate-employee.getDoj();
				
			}
			
			}
		}
		
	public static String displayDetails(String eno,String field)
	{
		Demo employee;
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/edu";
		String un="root";
		String pw="Balu@359";
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,un,pw);
			Statement stmt=con.createStatement();
			ResultSet res= stmt.executeQuery("select * from employee where Empno="+eno );
			while(res.next())
			{
			String num=res.getString(1);
			String name=res.getString(2);
			String des=res.getString(3);
			Date d=res.getDate(4);
			employee=new Demo(num,name,des,d);	
			if(employee==null)
			System.out.println("Invalid Employee Number"); 
			 if(field.equalsIgnoreCase("EMPNAME"))
				System.out.println(employee.getEmpName());
			else if(field.equalsIgnoreCase("Designation"))
			System.out.println(employee.getDesignation());	
			else
				return "Invalid Field";
			
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			return "Statement not Executed";
	}


	public static void main(String[] args)
	{
		
	}
}
