package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import controller.MainController;

public class DatabaseQueries {

	private String user, password;
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

	public Users updateUser(String ctid) throws Exception {

		Connection connection = null;
		PreparedStatement preparedQuery = null;
		ResultSet resultset = null;
		Users usertToUpdate = null;

		try {

			connection = connectionPool.getConnection();

			preparedQuery = connection.prepareStatement("SELECT * FROM CLIENTS WHERE CTID=?");

			preparedQuery.setString(1, ctid);

			resultset = preparedQuery.executeQuery();

			if (resultset.next()) {

				usertToUpdate = new Users(resultset.getString(1), resultset.getString(2), resultset.getString(3),
						resultset.getString(4), resultset.getString(5), resultset.getDouble(6));

			} else {

				throw new Exception("Not data found to this id:" + ctid);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			connection.close();
			preparedQuery.close();
			resultset.close();
		}

		return usertToUpdate;

	}

	public void updateDB(Users updatedUser) throws Exception {

		Connection connectionDB = null;
		PreparedStatement preparedQuery = null;

		try {

			connectionDB = connectionPool.getConnection();

			preparedQuery = connectionDB.prepareStatement(
					"UPDATE CLIENTS SET NAME=?, COMPANY=?, ADDRESS=?, COUNTRY=?, SALARY=? WHERE CTID=?");

			preparedQuery.setString(6, updatedUser.getCtid());
			preparedQuery.setString(1, updatedUser.getName());
			preparedQuery.setString(2, updatedUser.getCompany());
			preparedQuery.setString(3, updatedUser.getAddress());
			preparedQuery.setString(4, updatedUser.getCountry());
			preparedQuery.setDouble(5, updatedUser.getSalary());

			preparedQuery.execute();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			connectionDB.close();
			preparedQuery.close();

		}

	}

	public void deleteUser(String ctid) throws Exception {

		Connection connectionDB = null;
		PreparedStatement preparedQuery = null;

		try {

			connectionDB = connectionPool.getConnection();

			preparedQuery = connectionDB.prepareStatement("DELETE FROM CLIENTS WHERE CTID=?");

			preparedQuery.setString(1, ctid);

			preparedQuery.execute();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			connectionDB.close();
			preparedQuery.close();

		}

	}

	public Users verifyLogin(String user, String password) throws Exception {

		this.user = user;
		this.password = password;

		Connection connectionDB = null;
		PreparedStatement preparedQuery = null;
		ResultSet resultset = null;
		Users usersN = null;

		try {

			connectionDB = connectionPool.getConnection();
			preparedQuery = connectionDB.prepareStatement("SELECT * FROM CLIENTS WHERE NAME=? AND COMPANY=?");

			preparedQuery.setString(1, user);
			preparedQuery.setString(2, password);

			resultset = preparedQuery.executeQuery();

			if (resultset.next()) {

				System.out.println("User is registed");

				usersN = new Users(resultset.getString(1), resultset.getString(2), resultset.getString(3),
						resultset.getString(4), resultset.getString(5), resultset.getDouble(6));

				System.out.println(resultset.getString(1) + resultset.getString(2) + resultset.getString(3)
						+ resultset.getString(4) + resultset.getString(5) + resultset.getDouble(6));

			}

			else

				System.out.println("not registed");

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			connectionDB.close();
			preparedQuery.close();
			resultset.close();

		}

		return usersN;

	}

//	public Users showUserData() throws Exception {
//
//		Connection connectionDB = null;
//		PreparedStatement preparedQuery = null;
//		ResultSet resultset = null;
//		Users userRegistered = null;
//
//		try {
//
//			connectionDB = connectionPool.getConnection();
//			preparedQuery = connectionDB.prepareStatement("SELECT * FROM CLIENTS WHERE NAME=? AND COMPANY=?");
//
//			preparedQuery.setString(1, user);
//			preparedQuery.setString(2, password);
//
//			resultset = preparedQuery.executeQuery();
//
//			if (resultset.next()) {
//
//				userRegistered = new Users
//
//			}
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//
//		} finally {
//
//			connectionDB.close();
//			preparedQuery.close();
//			resultset.close();
//		}
//
//		return userRegistered;
//
//	}

}
