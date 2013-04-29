/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.additionServlets;

import ComponentManager.EM;
import Components.Race;
import Components.RuleSet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Tarkistaa syötteen ja hoitaa Racen lisäämistapahtuman.
 * @author Uskon
 */
public class AddRaceServlet extends HttpServlet {

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
        String raceName = request.getParameter("raceName");
        String strbonus = request.getParameter("str");
        String dexbonus = request.getParameter("dex");
        String conbonus = request.getParameter("con");
        String intbonus = request.getParameter("int");
        String wisbonus = request.getParameter("wis");
        String chabonus = request.getParameter("cha");
        String ruleset = request.getParameter("rset");

        boolean nameIsCorrect = true;
        if (!raceName.matches("[a-zA-Z0-9 _-]+")) {
            nameIsCorrect = false;
        }

        RuleSet rset = null;
        for (int n = 0; n < em.getRuleSets().size(); n++) {
            if (em.getRuleSets().get(n).getName().equals(ruleset)) {
                rset = em.getRuleSets().get(n);
            }
        }

        boolean correctAttributeBonuses = false;
        if (strbonus.matches("^[-|+]{0,1}[0-9]{1,2}") && dexbonus.matches("^[-|+]{0,1}[0-9]{1,2}") && conbonus.matches("^[-|+]{0,1}[0-9]{1,2}") && intbonus.matches("^[-|+]{0,1}[0-9]{1,2}") && wisbonus.matches("^[-|+]{0,1}[0-9]{1,2}") && chabonus.matches("^[-|+]{0,1}[0-9]{1,2}")) {
            correctAttributeBonuses = true;
        }



        boolean doesRaceExist = false;
        for (int k = 0; k < em.getRaces().size(); k++) {
            if (em.getRaces().get(k).getRaceName().equals(raceName) && em.getRaces().get(k).getRuleSet().getName().equals(ruleset)) {
                doesRaceExist = true;
            }
        }
        if (!doesRaceExist && rset != null && session.getAttribute("logged") != null && correctAttributeBonuses && nameIsCorrect) {
            Race race = new Race(raceName, Integer.parseInt(strbonus), Integer.parseInt(dexbonus), Integer.parseInt(conbonus), Integer.parseInt(intbonus), Integer.parseInt(wisbonus), Integer.parseInt(chabonus), rset);
            em.addToDatabase(race);
            request.setAttribute("inputSuccessful", true);
        } else {
            request.setAttribute("badInput", true);
        }
        if (doesRaceExist) {
            request.setAttribute("raceExists", true);
        }
        if (correctAttributeBonuses == false) {
            request.setAttribute("badAttributeInput", true);
        }
        if (rset == null) {
            request.setAttribute("badRSetInput", true);
        }
        if (!nameIsCorrect) {
            request.setAttribute("badname", true);
        }


        request.getRequestDispatcher("/AddNewRace").forward(request, response);
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
