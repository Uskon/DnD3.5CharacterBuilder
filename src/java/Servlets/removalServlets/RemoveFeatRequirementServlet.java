/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.removalServlets;

import ComponentManager.EM;
import Components.FeatRequirements.FeatAlignmentRequirement;
import Components.FeatRequirements.FeatAttributeRequirement;
import Components.FeatRequirements.FeatBABRequirement;
import Components.FeatRequirements.FeatCasterLevelRequirement;
import Components.FeatRequirements.FeatClassRequirement;
import Components.FeatRequirements.FeatDeityRequirement;
import Components.FeatRequirements.FeatFeatRequirement;
import Components.FeatRequirements.FeatLevelRequirement;
import Components.FeatRequirements.FeatRaceRequirement;
import Components.FeatRequirements.FeatSaveRequirement;
import Components.FeatRequirements.FeatSkillRequirement;
import Components.FeatRequirements.FeatSpellRequirement;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Poistaa Featin yksittäisen Feat*Requirementin.
 * @author Uskon
 */
public class RemoveFeatRequirementServlet extends HttpServlet {
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

        String req = request.getParameter("req");
        String reqid = request.getParameter("reqid");
        if (reqid == null || req == null) {
        } else {
            long id = (long) Integer.parseInt(reqid);
            String featid = (String) session.getAttribute("managedFeat");

            if (req.equals("class")) {
                FeatClassRequirement creq = null;
                for (FeatClassRequirement fcr : em.getFeatClassRequirementsByFeatID(featid)) {
                    if (fcr.getId() == id) {
                        creq = fcr;
                    }
                }
                em.removeFromDatabase(creq, id);
            }
            if (req.equals("feat")) {
                FeatFeatRequirement freq = null;
                for (FeatFeatRequirement ffr : em.getFeatFeatRequirementsByFeatID(featid)) {
                    if (ffr.getId() == id) {
                        freq = ffr;
                    }
                }
                em.removeFromDatabase(freq, id);
            }
            if (req.equals("skill")) {
                FeatSkillRequirement sreq = null;
                for (FeatSkillRequirement fsr : em.getFeatSkillRequirementsByFeatID(featid)) {
                    if (fsr.getId() == id) {
                        sreq = fsr;
                    }
                }
                em.removeFromDatabase(sreq, id);
            }
            if (req.equals("caster")) {
                FeatCasterLevelRequirement creq = null;
                for (FeatCasterLevelRequirement fclr : em.getFeatCasterLevelRequirementsByFeatID(featid)) {
                    if (fclr.getId() == id) {
                        creq = fclr;
                    }
                }
                em.removeFromDatabase(creq, id);
            }
            if (req.equals("spell")) {
                FeatSpellRequirement sreq = null;
                for (FeatSpellRequirement fsr : em.getFeatSpellRequirementsByFeatID(featid)) {
                    if (fsr.getId() == id) {
                        sreq = fsr;
                    }
                }
                em.removeFromDatabase(sreq, id);
            }
            if (req.equals("att")) {
                FeatAttributeRequirement areq = null;
                for (FeatAttributeRequirement far : em.getFeatAttributeRequirementsByFeatID(featid)) {
                    if (far.getId() == id) {
                        areq = far;
                    }
                }
                em.removeFromDatabase(areq, id);
            }
            if (req.equals("save")) {
                FeatSaveRequirement sreq = null;
                for (FeatSaveRequirement fsr : em.getFeatSaveRequirementsByFeatID(featid)) {
                    if (fsr.getId() == id) {
                        sreq = fsr;
                    }
                }
                em.removeFromDatabase(sreq, id);
            }
            if (req.equals("al")) {
                FeatAlignmentRequirement areq = null;
                for (FeatAlignmentRequirement far : em.getFeatAlignmentRequirementsByFeatID(featid)) {
                    if (far.getId() == id) {
                        areq = far;
                    }
                }
                em.removeFromDatabase(areq, id);
            }
            if (req.equals("level")) {
                FeatLevelRequirement lreq = null;
                try {
                    lreq = em.getFeatLevelRequirementByFeatID(featid);
                } catch (Exception e) {
                }

                em.removeFromDatabase(lreq, id);
            }
            if (req.equals("bab")) {
                FeatBABRequirement breq = null;
                try {
                    breq = em.getFeatBABRequirementByFeatID(featid);
                } catch (Exception e) {
                }
                em.removeFromDatabase(breq, id);
            }
            if (req.equals("deity")) {
                FeatDeityRequirement dreq = null;
                for (FeatDeityRequirement fdr : em.getFeatDeityRequirementsByFeatID(featid)) {
                    if (fdr.getId() == id) {
                        dreq = fdr;
                    }
                }
                em.removeFromDatabase(dreq, id);
            }
            if (req.equals("race")) {
                FeatRaceRequirement rreq = null;
                for (FeatRaceRequirement frr : em.getFeatRaceRequirementsByFeatID(featid)) {
                    if (frr.getId() == id) {
                        rreq = frr;
                    }
                }
                em.removeFromDatabase(rreq, id);
            }
            else {
                request.getRequestDispatcher("/AddFeatRequirements").forward(request, response);
            }
        }


        request.getRequestDispatcher("/AddFeatRequirements").forward(request, response);
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
