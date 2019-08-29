import java.io.*;
import java.util.*;
import java.lang.*;
import java.sql.*;

public class example1
{
	public static void main(String[] agrs) throws Exception
	{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection co = DriverManager.getConnection("jdbc:mysql://localhost/uca","root", "");
        Statement st=co.createStatement();
        ResultSet rs = st.executeQuery("select * from students");
        while(rs.next())
        {
            System.out.println(rs.getString("Name"));
            System.out.println(rs.getString("Age"));
        }
        String name="Nistant";
        String age="20";
        //st.executeUpdate("insert into students(Name,age) values('Rishav','19')");
        st.executeUpdate("insert into students(Name,age) values('"+name+"','+age+')");
        co.close();
	
	}
}