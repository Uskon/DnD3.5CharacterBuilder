/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import ComponentManager.EM;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Uskon
 */
public class SearchByNameServlet extends HttpServlet {
    private EM em = new EM();

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        if (type.equals("Class")) {
            if (em.getClassesByName(name).isEmpty()) {
                request.setAttribute("noresult", true);
            }
            request.setAttribute("result", em.getClassesByName(name));
        }
        if (type.equals("Feat")) {
            if (em.getFeatsByName(name).isEmpty()) {
                request.setAttribute("noresult", true);
            }
            request.setAttribute("result", em.getFeatsByName(name));
        }
        if (type.equals("Race")) {
            if (em.getRacesByName(name).isEmpty()) {
                request.setAttribute("noresult", true);
            }
            request.setAttribute("result", em.getRacesByName(name));
        }
        if (type.equals("Skill")) {
            if (em.getSkillsByName(name).isEmpty()) {
                request.setAttribute("noresult", true);
            }
            request.setAttribute("result", em.getSkillsByName(name));
        }
        if (type.equals("Deity")) {
            if (em.getDeitiesByName(name).isEmpty()) {
                request.setAttribute("noresult", true);
            }
            request.setAttribute("result", em.getDeitiesByName(name));
        }
        if (type.equals("Domain")) {
            if (em.getDomainsByName(name).isEmpty()) {
                request.setAttribute("noresult", true);
            }
            request.setAttribute("result", em.getDomainsByName(name));
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
