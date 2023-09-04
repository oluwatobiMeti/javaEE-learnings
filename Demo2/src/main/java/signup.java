

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String FirstName = request.getParameter("fname");
		String LastName = request.getParameter("lname");
		
		dataBase dt = new dataBase(FirstName, LastName);
		Connnect cn = new Connnect();
		
		String result = cn.Insert(dt);
		response.getWriter().println(result);
	}

}
