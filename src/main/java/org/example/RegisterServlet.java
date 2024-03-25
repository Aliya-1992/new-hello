/*package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/regu")
public class RegisterServlet extends HttpServlet {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/shop";
    static final String USER="postgres";
    static final String PASS = "Samsung2023!";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost started");

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        String userName = req.getParameter("userName");
        String userPass = req.getParameter("userPass");
        String userEmail = req.getParameter("userEmail");
        String userCountry = req.getParameter("userCountry");

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Подключение выполнено");
            String sql = "insert into usersReg values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPass);
            preparedStatement.setString(3, userEmail);
            preparedStatement.setString(4, userCountry);
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows);
            if (rows > 0){
                printWriter.print("Values added correctly!");
            }
            else {
                printWriter.print("Error adding data");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("SQLException");
            throw new RuntimeException(e);

        }
    }
}*/
