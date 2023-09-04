

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class StudentMagServlet
 */
public class StudentMagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connector connector;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentMagServlet() {
        super();
        // TODO Auto-generated constructor stub
        connector = new Connector();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Action = request.getServletPath();
		
		switch (Action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert": 
			try {
				InsertStudent(request, response);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/delect":
			try {
				DelectStudent(request, response);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/edit": 
			try {
				ShowEditForm(request, response);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/update": 
			try {
				UpdateStudent(request, response);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			try {
				StudentList(request, response);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		}
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}
	private void InsertStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String LastName, FirstName, description, performance, Location;
		int Age = Integer.parseInt(request.getParameter("Age"));
		LastName = request.getParameter("LastName");
		FirstName = request.getParameter("FirstName");
		description = request.getParameter("description");
		performance = request.getParameter("performance");
		Location = request.getParameter("Location");
		Student Std = new Student(LastName, FirstName, Age, description, performance, Location);
		connector.insertStudent(Std);
		response.sendRedirect("List");	
	}

	
	private void UpdateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String LastName, FirstName, description, performance, Location;
		int Age = Integer.parseInt(request.getParameter("Age"));
		int id = Integer.parseInt(request.getParameter("id"));
		LastName = request.getParameter("LastName");
		FirstName = request.getParameter("FirstName");
		description = request.getParameter("description");
		performance = request.getParameter("performance");
		Location = request.getParameter("Location");
		Student Std = new Student(id, LastName, FirstName, Age, description, performance, Location);
		connector.updateStudent(Std);
		response.sendRedirect("List");	
	}

	
	private void StudentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		 List<Student> Students = connector.selectAllStudent();
		 request.setAttribute("Students", Students);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		 dispatcher.forward(request, response);
	}
	
	private void ShowEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		 int id = Integer.parseInt(request.getParameter("id"));
		 Student existingUser = connector.selectStudentById(id);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		 request.setAttribute("Student", existingUser);
		 dispatcher.forward(request, response);
	}
	private void DelectStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		 int id = Integer.parseInt(request.getParameter("id"));
		 connector.delectStudent(id);
		 response.sendRedirect("List");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
