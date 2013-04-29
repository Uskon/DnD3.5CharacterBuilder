/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.additionServlets;

import ComponentManager.EM;
import Components.Alignment;
import Components.Deity;
import Components.RuleSet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Tarkistaa syötteen ja hoitaa Deityn lisäämistapahtuman.
 * @author Uskon
 */
public class AddDeityServlet extends HttpServlet {

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
        String name = request.getParameter("deityName");
        String ruleset = request.getParameter("rset");
        Alignment alignment = checkAlignmentInput(request);

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

        boolean doesDeityExist = false;
        for (int k = 0; k < em.getDeities().size(); k++) {
            if (em.getDeities().get(k).getName().equals(name) && em.getDeities().get(k).getRuleSet().getName().equals(ruleset)) {
                doesDeityExist = true;
                break;
            }
        }
        if (!doesDeityExist && rset != null && session.getAttribute("logged") != null && nameIsCorrect && alignment != null) {
            em.addToDatabase(new Deity(name, alignment, rset));
            request.setAttribute("inputSuccessful", true);
        }
        if (rset == null) {
            request.setAttribute("badRSetInput", true);
        }
        if (doesDeityExist) {
            request.setAttribute("deityExists", true);
        }
        if (!nameIsCorrect) {
            request.setAttribute("badname", true);
        }
        if (alignment == null) {
            request.setAttribute("badalignment", true);
        }

        request.getRequestDispatcher("/AddNewDeity").forward(request, response);
    }

    private Alignment checkAlignmentInput(HttpServletRequest request) {
        Alignment a = null;
        if (request.getParameter("alignment").matches("LG|LN|LE|NG|N|NE|CG|CN|CE")) {
            String as = request.getParameter("alignment");
            if (as.equals("LG")) {
                a = Alignment.LG;
            }
            if (as.equals("LN")) {
                a = Alignment.LN;
            }
            if (as.equals("LE")) {
                a = Alignment.LE;
            }
            if (as.equals("NG")) {
                a = Alignment.NG;
            }
            if (as.equals("N")) {
                a = Alignment.N;
            }
            if (as.equals("NE")) {
                a = Alignment.NE;
            }
            if (as.equals("CG")) {
                a = Alignment.CG;
            }
            if (as.equals("CN")) {
                a = Alignment.CN;
            }
            if (as.equals("CE")) {
                a = Alignment.CE;
            }
        }
        return a;
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
