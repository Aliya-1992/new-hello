package org.example.crud;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/view")
public class ViewServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<h1>Persons list</h1>");
        ArrayList<Person> arrayList = PersonDao.getAllPersons();
        printWriter.print("<table>");
        printWriter.print("<tr><td>id</td> <td>userName</td>  <td>userPass</td>  <td>userEmail</td>   <td>userCountry</td></tr>");
        for (Person person :arrayList) {
            printWriter.print("<tr><td>" + person.getId() +"</td> <td>" + person.getUserName() +"</td>  <td>"+ person.getUserPass() +" </td>  <td>"+ person.getUserEmail() +"</td>   <td>"+ person.getUserCountry() +"</td><th><a href = 'delete?id="+ person.getId() +"'>delete</a></th></tr>");
        }
        printWriter.print("</table>");
    }
}
