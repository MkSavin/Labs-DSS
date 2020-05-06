package Servlet;

import Models.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsersServlet extends HttpServlet {
    
    // @EJB 
    // private UserDAORemote dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            List<User> users = Models.User.GetUsersList();
            request.setAttribute("users", users);
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("users.jsp");
            requestDispatcher.forward(request, response);
        }catch (Exception e) { 
            throw new ServletException(e.getLocalizedMessage()); 
        }    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
        try{
            RequestDispatcher dispatcher = request.getRequestDispatcher("users.jsp");
            dispatcher.forward(request,response);
        }catch (Exception e) { 
            throw new ServletException(e.getMessage()); 
        }    
    }

    @Override
    public String getServletInfo() {
        return "";
    }

}
