package org.example.crud;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import javax.security.auth.login.LoginException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet("/auth")

public class Auth extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        Person per = new Person();
        String userEmail=req.getParameter("userEmail");
        String userPass1=req.getParameter("userPass");
        System.out.println(userPass1);
        String userPass=per.hash(req.getParameter("userPass"));
        Person person = new Person();
        person.setUserEmail(userEmail);
        person.setUserPass(userPass);
        person.setUserPass1(userPass1);


        if (PersonDao.checkPersonIfExists(person)!=null){
            Person returnedPerson=PersonDao.checkPersonIfExists(person);
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("userName", returnedPerson.getUserName());
            httpSession.setAttribute("userEmail", returnedPerson.getUserEmail());
            httpSession.setAttribute("userCountry", returnedPerson.getUserCountry());
            httpSession.setAttribute("userPass", returnedPerson.getUserPass());
            httpSession.setAttribute("userPass1", returnedPerson.getUserPass1());
            httpSession.setAttribute("id", returnedPerson.getId());
            System.out.println(returnedPerson.getUserName());
            System.out.println(returnedPerson.getUserEmail());
            System.out.println(returnedPerson.getUserCountry());
            System.out.println(returnedPerson.getId());
            System.out.println(userPass1);
            resp.sendRedirect("authed_person.jsp"); //отправляе на другую страничку
        }
        else{
           printWriter.print("<h1>User auth Error, incorrect email or password</h1>");
           req.getRequestDispatcher("auth.html").include(req,resp);
        }



    }
}
