/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.managers;

import ComponentManager.EM;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Ohjaa submitin perusteella oikealle sivulle.
 * @author Uskon
 */
public class ManageDomainServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        if (session.getAttribute("logged") == null) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        if (request.getParameter("domain") == null) {
            session.setAttribute("nullDomain", true);
            response.sendRedirect("ManageDomains");
        } else {
            String submit = request.getParameter("selection");
            String domainid = request.getParameter("domain");
            session.setAttribute("managedDomain", domainid);
            if (submit.equals("Set Feats")) {
                response.sendRedirect("AddNewDomainFeat");
            }
            if (submit.equals("Delete")) {
                response.sendRedirect("RemoveDomain");
            }
        }
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
