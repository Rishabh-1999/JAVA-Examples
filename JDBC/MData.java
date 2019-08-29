
import java.io.*;
import java.util.*;
import java.lang.*;
import java.sql.*;

public class MData
{
	public static void main(String[] agrs) throws Exception
	{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection co = DriverManager.getConnection("jdbc:mysql://localhost/uca","root", "");
        PreparedStatement ps=co.prepareStatement("select * from students");
        ResultSet rs=ps.executeQuery();
        ResultSetMetaData rm =rs.getMetaData();
        for(int i=1;i<=rm.getColumnCount();i++)
        {
            System.out.println(r m.getColumnName(i)+" "+rm.getColumnTypeName(i));
        }
        co.close();
	
	}
}