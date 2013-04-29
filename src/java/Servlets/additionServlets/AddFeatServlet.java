/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.additionServlets;

import ComponentManager.EM;
import Components.CClass;
import Components.Feat;
import Components.RuleSet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Tarkistaa syötteen ja hoitaa Featin lisäämistapahtuman.
 * @author Uskon
 */
public class AddFeatServlet extends HttpServlet {

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
        String name = request.getParameter("featName");
        String ruleset = request.getParameter("rset");
        String charlvl = request.getParameter("reqCharlvl");
        String race = request.getParameter("reqRace");
        String deity = request.getParameter("reqDeity");
        String alignment = request.getParameter("reqAlignment");
        String classlvl = request.getParameter("reqClass");
        String casterlvl = request.getParameter("reqCaster");
        String spelllvl = request.getParameter("reqSpell");
        String attribute = request.getParameter("reqAttributes");
        String save = request.getParameter("reqSave");
        String feat = request.getParameter("reqFeat");
        String skill = request.getParameter("reqSkill");
        String bab = request.getParameter("reqSkill");

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
        boolean doesFeatExist = false;
        for (Feat f : em.getFeats()) {
            if (f.getName().equals(name) && f.getRuleSet().getName().equals(ruleset)) {
                doesFeatExist = true;
            }
        }

        if (rset != null && !doesFeatExist && session.getAttribute("logged") != null && nameIsCorrect) {
            em.addToDatabase(new Feat(name, rset, turnToBoolean(classlvl), turnToBoolean(race), turnToBoolean(classlvl), turnToBoolean(attribute), turnToBoolean(alignment), turnToBoolean(deity), turnToBoolean(skill), turnToBoolean(save), turnToBoolean(bab), turnToBoolean(casterlvl), turnToBoolean(spelllvl), turnToBoolean(feat)));
            request.setAttribute("inputSuccessful", true);
        }
        if (rset == null) {
            request.setAttribute("badRSetInput", true);
        }
        if (doesFeatExist) {
            request.setAttribute("featExists", true);
        }
        if (!nameIsCorrect) {
            request.setAttribute("badname", true);
        }

        request.getRequestDispatcher("/AddNewFeat").forward(request, response);
    }

    private boolean turnToBoolean(String string) {
        if (string.equals("true")) {
            return true;
        } else {
            return false;
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
