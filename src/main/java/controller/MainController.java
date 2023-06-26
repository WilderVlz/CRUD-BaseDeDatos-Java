package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
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

		default:

			showUsers(request, response);

			break;

		}

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

			RequestDispatcher dispatcher = request.getRequestDispatcher("/Home.jsp");

			dispatcher.forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
