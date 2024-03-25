package org.example.crud;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
   @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     resp.setContentType("text/html");
       PrintWriter printWriter = resp.getWriter();
       String sid = req.getParameter("id");

       int id = Integer.parseInt(sid);
       String userName=req.getParameter("userName");
       String userPass= req.getParameter("userPass");
       String userEmail=req.getParameter("userEmail");
       String userCountry=req.getParameter("userCountry");

        Person person = new Person();
      person.setId(id);
        person.setUserName(userName);
        person.setUserPass(userPass);
        person.setUserEmail(userEmail);
       person.setUserCountry(userCountry);

        int status = PersonDao.update(person);
        if (status >0){
           resp.sendRedirect("view");
       }
       else {
           printWriter.print("Something went wrong"); }
    }
}