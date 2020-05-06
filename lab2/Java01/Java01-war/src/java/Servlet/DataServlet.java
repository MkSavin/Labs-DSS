package Servlet;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataServlet extends HttpServlet {
    
    @EJB
    Singleton.DataSharerSingleton dss;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.setAttribute("singleton", dss.getCode());
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("data.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e.getMessage()); 
        }    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
        try{
            response.sendRedirect("/Java01-war/users");
        } catch (Exception e) {
            throw new ServletException(e.getMessage()); 
        }
    }

    @Override
    public String getServletInfo() {
        return "";
    }
}
