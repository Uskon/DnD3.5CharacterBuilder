/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.additionServlets;

import Components.Race;
import ComponentLists.RaceList;
import ComponentLists.RuleSetList;
import Components.RuleSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Uskon
 */
public class AddRaceServlet extends HttpServlet {
    private RaceList raceList = new RaceList();
    private RuleSetList rsetlist = new RuleSetList();

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
        String raceName = request.getParameter("raceName");
        String abonus = request.getParameter("abonus");
        String rdesc = request.getParameter("rdescription");
        String ruleset = request.getParameter("rset");       
        RuleSet rset = null;
        for (int n = 0; n < rsetlist.getRuleSets().size(); n++) {
            if (rsetlist.getRuleSets().get(n).getName().equals(ruleset)) {
                rset = rsetlist.getRuleSets().get(n);
            }
        }

        boolean doesRaceExist = false;
        for (int k = 0; k < raceList.getRaces().size(); k++) {
            if (raceList.getRaces().get(k).getRaceName().equals(raceName)) {
                doesRaceExist = true;
            }
        }
        if (!doesRaceExist && rset != null && session.getAttribute("logged") != null) {
            Race race = new Race(raceName, abonus, rdesc, rset);
            raceList.addRace(race);
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
