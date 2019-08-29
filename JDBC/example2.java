import java.io.*;
import java.util.*;
import java.lang.*;
import java.sql.*;

public class example2
{
	public static void main(String[] agrs) throws Exception
	{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection co = DriverManager.getConnection("jdbc:mysql://localhost/uca","root", "");
        Statement st=co.createStatement();
        ResultSet rs = st.executeQuery("select * from students where Name='Rishabh'");
        if(rs.next()==false)
        {
            st.executeUpdate("insert into students(Name,age) values('Rishabh','20')");    
        }
        else
        {
            System.out.println(rs.getString("Name"));
        }
        co.close();
	}
}