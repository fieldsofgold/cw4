package pl.altkom;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class ReadClientsDataServlet extends HttpServlet {

@Resource(lookup="jdbc/jweb")
private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();

	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Dane klientów</title>");
	    out.println("</head>");
	    out.println("<body bgcolor=\"lightblue\"><center>");

		log("Servlet: "+getServletName()+" czyta dane klienta z bazy danych ");
		List<Client> clients = null;
		try {
			ClientDataDAO dao = new ClientDataDAOImpl();
		    clients = dao.readClientsData(ds);
		}catch(Exception e){
			log("Błąd dostępu do bazy danych",e);
		}

	    if (clients.size() > 0) {
		    out.println("<table>");
		    out.println("<tr><td><b>Klient</b></td><td><b>Wiek</b></td><td><b>Region</b></td><td><b>Płeć</b></td></tr>");
		    out.println("<tr><td colspan='5'><hr></td></tr>");

                for(Client cl: clients){
	    		out.println("<tr><td>"+cl.getName()+" "+cl.getSurname()+"</td>");
	    		out.println("<td>"+cl.getAge()+"</td><td>"+cl.getRegion()+"</td><td>"+(cl.isMale()?"M":"K")+"</td></tr>");
	    	}
	    	out.println("</table>");
	    }
	    else out.println("Brak zarejestrowanych klientow<br>");

            String cp = request.getContextPath();
	    String path = cp + "/controller";
	    out.println("<a href=\"" + path + "\">Powrot</a>");
	    out.println("</center></body></html>");
	}
}
