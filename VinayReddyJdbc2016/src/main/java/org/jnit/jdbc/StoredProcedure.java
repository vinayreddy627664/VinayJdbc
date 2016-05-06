package org.jnit.jdbc;

import java.sql.*;

public class StoredProcedure{
	
	public static void getPatientInformation(int p_id) throws ClassNotFoundException {
		try {
			Connection conn = DBConnectionUtility.getConnection();
			// Using a Callable Statement and calling a Stored Procedure
			String query = ("call fetchPatientInfo(?)");
			CallableStatement cst = conn.prepareCall(query);
			cst.setInt(1, p_id);
			ResultSet myRs = cst.executeQuery();
			while (myRs.next()) {
				// output
				System.out.println(myRs.getString("NAME"));
				System.out.println(myRs.getString("PHONE"));
			}
			myRs.close();
			cst.close();
			conn.close();

		} catch (SQLException e) {
			System.out.println("Failed to connect to the server");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws ClassNotFoundException {
		getPatientInformation(6);

	}

}
