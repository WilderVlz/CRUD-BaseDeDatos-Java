package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.annotation.Resource;

import model.DatabaseQueries;
import model.Users;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DatabaseQueries modelQueries;
	private Users modelUsers;

	@Resource(name = "jdbc/Database")

	private DataSource connectionPool;

	public void init() throws ServletException {

		super.init();

		try {

			modelQueries = new DatabaseQueries(connectionPool);

		} catch (Exception e) {

			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String instruction = request.getParameter("instruction");

		if (instruction == null)
			instruction = "showUsers";

		switch (instruction) {

		case "showUsers":

			showUsers(request, response);

			break;

		case "add":

			addNewUser(request, response);

			break;

		case "update":

			try {
				updateUser(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}

			break;

		case "updateDB":

			updateDB(request, response);

			break;

		case "delete":

			deleteUser(request, response);

			break;

		default:

			showUsers(request, response);

			break;

		}

	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) {

		// reading data

		String ctid = request.getParameter("CTID");

		// sending id to model class

		try {

			modelQueries.deleteUser(ctid);

		} catch (Exception e) {

			e.printStackTrace();
		}

		// showing list of user updated

		showUsers(request, response);

	}

	private void updateDB(HttpServletRequest request, HttpServletResponse response) {

		// read new info from form fields

		String ctid = request.getParameter("CTID");
		String name = request.getParameter("name");
		String company = request.getParameter("company");
		String address = request.getParameter("address");
		String country = request.getParameter("country");
		double salary = Double.parseDouble(request.getParameter("salary"));

		// saving updated user

		Users updatedUser = new Users(ctid, name, company, address, country, salary);

		// sending updated user to the model

		try {

			modelQueries.updateDB(updatedUser);

		} catch (Exception e) {

			e.printStackTrace();
		}

		// showing updated users list

		showUsers(request, response);

	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read ctid

		String ctid = request.getParameter("CTID");

		// send ctid to model class

		Users idUser = modelQueries.updateUser(ctid);

		// setting attribute to update to the form

		request.setAttribute("userToUpdate", idUser);

		// sending user to the form

		RequestDispatcher dispatcher = request.getRequestDispatcher("/UpdateUserForm.jsp");

		dispatcher.forward(request, response);

	}

	private void addNewUser(HttpServletRequest request, HttpServletResponse response) {

		// reading info from the form

		String ctid = request.getParameter("ctid");
		String name = request.getParameter("name");
		String company = request.getParameter("company");
		String address = request.getParameter("address");
		String country = request.getParameter("country");
		double salary = Double.parseDouble(request.getParameter("salary"));

		// creating new user

		modelUsers = new Users(ctid, name, company, address, country, salary);

		// sending user to the model class

		try {
			modelQueries.addNewUser(modelUsers);
		} catch (Exception e) {

			e.printStackTrace();
		}

		// reloading the users

		showUsers(request, response);

	}

	public void showUsers(HttpServletRequest request, HttpServletResponse response) {

		List<Users> userList;

		try {

			// adding users from model response

			userList = modelQueries.getUsers();

			// adding users to request attribute

			request.setAttribute("Users", userList);

			// sending users to the View

			RequestDispatcher dispatcher = request.getRequestDispatcher("./View/Home.jsp");

			dispatcher.forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
