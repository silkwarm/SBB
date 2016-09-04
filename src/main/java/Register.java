import oracle.jdbc.pool.OracleDataSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        try {
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setServerName("localhost");
            dataSource.setUser("");
            dataSource.setPassword("");
            dataSource.setPortNumber(1521);
            dataSource.setDriverType("thin");
            dataSource.setDatabaseName("orcl");
            Connection conn = dataSource.getConnection();
            out.println("gut");
            String stm = "INSERT INTO users (id, login, password) VALUES (general_seq.nextval, ?, ?)";
            PreparedStatement ins_user = conn.prepareStatement(stm);
            ins_user.setString(1, (String) req.getParameter("login"));
            ins_user.setString(2, (String) req.getParameter("password"));
            ins_user.executeQuery();
            conn.close();
        } catch (SQLException e) {
            out.println(e.getMessage());
        }
    }
}
