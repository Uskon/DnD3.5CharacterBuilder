/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.additionServlets;

import ComponentManager.EM;
import Components.Feat;
import Components.Race;
import Components.RacialFeat;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Tarkistaa syötteen ja hoitaa RacialFeatin lisäystapahtuman.
 * @author Uskon
 */
public class AddRacialFeatServlet extends HttpServlet {
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
        session.removeAttribute("managedRace");
        String raceId = request.getParameter("race");
        String featId = request.getParameter("feat");
        Race race = em.getRaceByID(raceId);
        Feat feat = null;
        boolean doesRacialFeatExist = false;
        if (featId != null) {
            feat = em.getFeatByID(featId);
            if (!em.getRacialFeatsByRaceID(raceId).isEmpty()) {
                for (RacialFeat rf : em.getRacialFeatsByRaceID(raceId)) {
                    if (rf.getRace().getId() == race.getId() && rf.getFeat().getId() == feat.getId()) {
                        doesRacialFeatExist = true;
                    }
                }
            }
        }
        if (!doesRacialFeatExist && race != null && feat != null && session.getAttribute("logged") != null) {
            em.addToDatabase(new RacialFeat(race, feat));
        }
        request.setAttribute("race", race);
        session.setAttribute("managedRace", raceId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddNewRacialFeat");
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
