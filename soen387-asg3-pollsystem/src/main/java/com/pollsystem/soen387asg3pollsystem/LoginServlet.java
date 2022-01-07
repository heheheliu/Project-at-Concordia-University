package com.pollsystem.soen387asg3pollsystem;

import com.pollsystem.daoimpl.UserDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String pass = request.getParameter("pass");

        UserDaoImpl userDao = new UserDaoImpl();


        //if (user_id ==111 && pass.equals("1234")){
        if(userDao.check(user_id, pass)){
            HttpSession session = request.getSession();//check the uname to avoid display welcome.jsp
            session.setAttribute("userid", user_id);

            response.sendRedirect("display.jsp");
        }
        else
        {
            response.sendRedirect("login.jsp");
        }
    }


}