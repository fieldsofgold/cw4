package pl.altkom;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class SaveClientDataServlet extends HttpServlet {

    //@Resource(name="jdbc/jweb
    @Resource(lookup="jdbc/jweb")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Client cl = new Client();
        cl.setName(req.getParameter("name"));
        cl.setSurname(req.getParameter("surname"));
        cl.setRegion(req.getParameter("region"));
        cl.setAge(Integer.parseInt(req.getParameter("age")));
        cl.setMale(Boolean.parseBoolean(req.getParameter("male")));

        log("Servlet: " + getServletName() + " zapisuje dane klienta w bazie danych ");
        try {
            ClientDataDAO dao = new ClientDataDAOImpl();
            dao.saveClientData(cl, ds);
            // tylko żeby przechwycić przez listener
            req.setAttribute("lastAddedClient", cl);
        } catch (Exception e) {
            log("Blad zapisu do bazy danych", e);
        }

        getServletContext().getRequestDispatcher("/controller").forward(req, res);
    }
}

