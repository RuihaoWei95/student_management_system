package cm.stu.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	//auto read c3p0-config.xml
	private static DataSource dataSource = new ComboPooledDataSource();
	
	//get connection
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//close resource
	public static void close(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet) {
		try {
			//close resource
			if(resultSet != null)  resultSet.close();
			if(preparedStatement != null)  preparedStatement.close();
			if(connection != null)  connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
