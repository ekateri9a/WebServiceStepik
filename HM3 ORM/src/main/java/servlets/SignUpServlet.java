package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;

public class SignUpServlet extends HttpServlet {
    private final DBService dbService;

    public SignUpServlet(DBService dbService) {
        this.dbService = dbService;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login == null || password == null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        long id = 0;

        try {
            id = dbService.getUserByLogin(login);
        } catch (DBException e) {
            e.printStackTrace();
        }

        if (id == 0) {
            try {
                long userId = dbService.addUser(login, password);
                //System.out.println("Added user id: " + userId);
            } catch (DBException e) {
                e.printStackTrace();
            }

            response.getWriter().println("ok");

            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

    }
}
