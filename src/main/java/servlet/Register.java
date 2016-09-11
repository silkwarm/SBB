package servlet;

import dao.UserDAO;
import persistence.UserPO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Register extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        UserPO user = new UserPO();
        UserDAO userD = new UserDAO();
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        try {
            userD.add(user);
        } catch (SQLException e) {
            out.println(e.getMessage());
        }
    }
}
