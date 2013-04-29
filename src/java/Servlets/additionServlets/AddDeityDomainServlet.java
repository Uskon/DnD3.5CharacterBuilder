/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.additionServlets;

import ComponentManager.EM;
import Components.DDomain;
import Components.Deity;
import Components.DeityDomain;
import Components.DomainFeat;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Tarkistaa syötteen ja hoitaa DeityDomainin lisäämistapahtuman.
 * @author Uskon
 */
public class AddDeityDomainServlet extends HttpServlet {
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
        session.removeAttribute("managedDeity");
        String deityid = request.getParameter("deity");
        String domainid = request.getParameter("domain");
        Deity deity = em.getDeityByID(deityid);
        DDomain domain = null;
        boolean doesDeityDomainExist = false;
        if (domainid != null) {
            domain = em.getDomainByID(domainid);
            if (!em.getDeityDomains().isEmpty()) {
                for (DeityDomain dd : em.getDeityDomains()) {
                    if (dd.getDeity().getId() == deity.getId() && dd.getDomain().getId() == domain.getId()) {
                        doesDeityDomainExist = true;
                    }
                }
            }
        }
        if (!doesDeityDomainExist && deity != null && domain != null && session.getAttribute("logged") != null) {
            em.addToDatabase(new DeityDomain(deity, domain));
        }
        request.setAttribute("deity", deity);
        session.setAttribute("managedDeity", deityid);
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddNewDeityDomain");
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
