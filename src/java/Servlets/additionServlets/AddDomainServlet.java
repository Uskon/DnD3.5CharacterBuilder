/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.additionServlets;

import ComponentManager.EM;
import Components.DDomain;
import Components.RuleSet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Tarkistaa syötteen ja hoitaa Domainin lisäämistapahtuman.
 * @author Uskon
 */
public class AddDomainServlet extends HttpServlet {
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
        String name = request.getParameter("domainName");
        String ruleset = request.getParameter("rset");

        boolean nameIsCorrect = true;
        if (!name.matches("[a-zA-Z0-9 _-]+")) {
            nameIsCorrect = false;
        }

        RuleSet rset = null;
        for (int n = 0; n < em.getRuleSets().size(); n++) {
            if (em.getRuleSets().get(n).getName().equals(ruleset)) {
                rset = em.getRuleSets().get(n);
            }
        }

        boolean doesDomainExist = false;
        for (int k = 0; k < em.getDomains().size(); k++) {
            if (em.getDomains().get(k).getName().equals(name) && em.getDomains().get(k).getRuleSet().getName().equals(ruleset)) {
                doesDomainExist = true;
                break;
            }
        }
        if (!doesDomainExist && rset != null && session.getAttribute("logged") != null && nameIsCorrect) {
            em.addToDatabase(new DDomain(name, rset));
            request.setAttribute("inputSuccessful", true);
        }
        if (rset == null) {
            request.setAttribute("badRSetInput", true);
        }
        if (doesDomainExist) {
            request.setAttribute("domainExists", true);
        }
        if (!nameIsCorrect) {
            request.setAttribute("badname", true);
        }

        request.getRequestDispatcher("/AddNewDomain").forward(request, response);
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
