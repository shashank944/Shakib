package rmgyantra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdateAndVerify {
	public String  executeUpdateAndVerify(String url, String username, String password, String query) throws SQLException {
		Driver driver;
		Connection con = null;
		String message = "";
		try {
			driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username, password);
			Statement statement = con.createStatement();
			int result = statement.executeUpdate(query);
			System.out.println("Total number of records Affected = " + result);

			if(result>=0) {
				message = "Update Operation is Successful";
			}else {
				message = "Update Operation is Failed";
			}
		}catch (Exception e) {

		}finally {
			con.close();
		}
		return message;
	}

	public static void main(String[] args) throws Exception {
		String output = new ExecuteUpdateAndVerify().executeUpdateAndVerify("jdbc:mysql://localhost:3306/projects", "root", "root", "delete from project where project_name='abc';");
		System.out.println(output);
	}
}
