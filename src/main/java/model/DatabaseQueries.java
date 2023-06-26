package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class DatabaseQueries {

	private Connection connectionDB;
	private Statement query;
	private PreparedStatement preparedQuery;
	private ResultSet resultset;
	private DataSource connectionPool;

	public DatabaseQueries(DataSource connectionPool) {

		this.connectionPool = connectionPool;

	}

	public List<Users> getUsers() throws Exception {

		List<Users> userList = new ArrayList<Users>();

		connectionDB = null;
		query = null;
		resultset = null;

		try {

			// creating connection with the database

			connectionDB = connectionPool.getConnection();

			// creating statement

			query = connectionDB.createStatement();

			// making consult

			resultset = query.executeQuery("SELECT * FROM CLIENTS");

			// Iterate users

			while (resultset.next()) {

				// adding users to the collection

				Users tempUsers = new Users(resultset.getString(1), resultset.getString(2), resultset.getString(3),
						resultset.getString(4), resultset.getString(5), resultset.getDouble(6));

				userList.add(tempUsers);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			connectionDB.close();
			query.close();
			resultset.close();

		}

		return userList;

	}

	public void addNewUser(Users user) throws Exception {

		Connection connectionDB = null;

		try {

			// connecting with DB

			connectionDB = connectionPool.getConnection();

			// creating prepared query

			preparedQuery = connectionDB.prepareStatement(
					"INSERT INTO CLIENTS (CTID,NAME,COMPANY,ADDRESS,COUNTRY,SALARY) VALUES (?,?,?,?,?,?)");

			// Establishing values

			preparedQuery.setString(1, user.getCtid());
			preparedQuery.setString(2, user.getName());
			preparedQuery.setString(3, user.getCompany());
			preparedQuery.setString(4, user.getAddress());
			preparedQuery.setString(5, user.getCountry());
			preparedQuery.setDouble(6, user.getSalary());

			preparedQuery.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			connectionDB.close();
			preparedQuery.close();

		}

	}

}
