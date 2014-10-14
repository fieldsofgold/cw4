package pl.altkom;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;

public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        request.getSession();
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");

        out.println("<title>Menu servlet</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"lightblue\"><center>");
        out.println("<table align='center'><tr><td>");
        out.println("<h3>Menu: </h3>");
        out.println("</td></tr>");

        String cp = request.getContextPath();

	String path = cp + "/readClients";
        out.println("<tr><td><a href=\"" + path + "\">Dane klientow</a></td></tr>");

        path = cp + "/userForm.html";
        out.println("<tr><td><a href=\"" + path + "\">Zarejestruj klienta</a></td></tr>");

        path = cp + "/makeForm.html";
        out.println("<tr><td><a href=\"" + path + "\">Ulubiona marka samochodu</a></td></tr>");

        out.println("<table>");
        out.println("<br/>Aktualnie w aplikacji pracuje: "+pl.altkom.SessionCounter.getActiveSessions()+" osób");
        Integer counter = (Integer)getServletContext().getAttribute("savedClientsCounter");
        if (counter!=null){
            out.println("<br/><br/>Podczas pracy aplikacji dodano: "+counter+" klientów");
        }
        out.println("</center></body>");
        out.println("</html>");
    }
}
