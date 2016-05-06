package org.jnit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Scanner;

//Illustrating the usage of Save points and Transaction management
public class SavePointsAndTransactions {
	// Creating a connection
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");	
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/javatraining","root","vinay");
			return conn;
	}

	public static void TransactionsandSavepoints() throws ClassNotFoundException {
		Connection conn = null;
		Savepoint savepoint = null;
		Statement stmt = null;
		try{
			try {
				conn = getConnection();
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				// setting a Save point
				
				String sql = "INSERT INTO patient_info VALUES (14, 'Prabhas',984984)";
				stmt.executeUpdate(sql);
				savepoint = conn.setSavepoint("Savepoint");
				String query = "INSERT INTO doctor VALUES (4001,'Sudheer','Pediatrisian')";
				stmt.executeUpdate(query);
				//conn.commit();
				} catch (SQLException e) {
					e.printStackTrace();
					try {
						if (savepoint == null) {
							conn.rollback();
							System.out.println("rolled back successfully");
						} else {
							conn.rollback(savepoint);
							conn.commit();
						}
					} catch (SQLException e1) {
						System.out.println("SQLException in rollback");
					}	
				}
			boolean ok = askUserIfOkToSave();
			if (ok) {
				conn.commit();
				System.out.println("Transaction is done successfully");
			} else {
				conn.rollback();
				System.out.println("rolled back to the previous stage");
			}
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static boolean askUserIfOkToSave() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Do you want to save?  yes/no: ");
		String input = scanner.nextLine();
		scanner.close();
		return input.equalsIgnoreCase("yes");
	}
	public static void main(String[] args) throws ClassNotFoundException {
		TransactionsandSavepoints();
	}
}
