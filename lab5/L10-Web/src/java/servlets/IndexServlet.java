/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Reciever;
import beans.SenderLocal;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MkSavin
 */
@WebServlet(name = "IndexServlet", urlPatterns = {"/index"})
public class IndexServlet extends HttpServlet {

    @Inject
    SenderLocal sbl;
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String recieved = "";
        
        recieved += "Recieved messages: \n";
        if (Reciever.messages.size() > 0) {
            for (int i=0; i<Reciever.messages.size(); i++) {
                recieved += "&mdash; " + Reciever.messages.get(i) + "\n";
            }
            Reciever.messages.clear();
        }
        
        request.setAttribute("messages", recieved);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.xhtml");
        requestDispatcher.forward(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String text = request.getParameter("text");
        try {
            sbl.sendMessage(text);
            
            request.setAttribute("message", "Транзакция сообщения успешно выполнена");
        } catch(Exception e) {
            request.setAttribute("message", "Транзакция сообщения не была успешно выполнена: " + e);
        }
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.xhtml");
        requestDispatcher.forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
