package Servlet;

import Models.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserCreateServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("userCreate.jsp");
            requestDispatcher.forward(request, response);
        }catch (Exception e) { 
            throw new ServletException(e.getMessage()); 
        }    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
        try{
            String name = request.getParameter("name");
            String position = request.getParameter("position");
            
            User user = new User();
            
            user.setName(name);
            user.setPosition(position);
            
            Models.User.Create(user);
            
            response.sendRedirect("/Java01-war/users");
        }catch (Exception e) { 
            throw new ServletException(e.getMessage()); 
        }    
    }

    @Override
    public String getServletInfo() {
        return "";
    }
    
}
