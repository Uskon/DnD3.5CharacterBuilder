/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.removalServlets;

import ComponentManager.EM;
import Components.ClassRequirement.ClassAlignmentRequirement;
import Components.ClassRequirement.ClassAttributeRequirement;
import Components.ClassRequirement.ClassBABRequirement;
import Components.ClassRequirement.ClassCasterLevelRequirement;
import Components.ClassRequirement.ClassClassRequirement;
import Components.ClassRequirement.ClassDeityRequirement;
import Components.ClassRequirement.ClassFeatRequirement;
import Components.ClassRequirement.ClassLevelRequirement;
import Components.ClassRequirement.ClassRaceRequirement;
import Components.ClassRequirement.ClassSaveRequirement;
import Components.ClassRequirement.ClassSkillRequirement;
import Components.ClassRequirement.ClassSpellRequirement;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Hoitaa yksittäisen Class*Requirementin poiston.
 * @author Uskon
 */
public class RemoveClassRequirementServlet extends HttpServlet {

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
            String classid = (String) session.getAttribute("managedClass");

            if (req.equals("class")) {
                ClassClassRequirement creq = null;
                for (ClassClassRequirement ccr : em.getClassClassRequirementsByClassID(classid)) {
                    if (ccr.getId() == id) {
                        creq = ccr;
                    }
                }
                em.removeFromDatabase(creq, id);
            }
            if (req.equals("feat")) {
                ClassFeatRequirement freq = null;
                for (ClassFeatRequirement ccr : em.getClassFeatRequirementsByClassID(classid)) {
                    if (ccr.getId() == id) {
                        freq = ccr;
                    }
                }
                em.removeFromDatabase(freq, id);
            }
            if (req.equals("skill")) {
                ClassSkillRequirement sreq = null;
                for (ClassSkillRequirement ccr : em.getClassSkillRequirementsByClassID(classid)) {
                    if (ccr.getId() == id) {
                        sreq = ccr;
                    }
                }
                em.removeFromDatabase(sreq, id);
            }
            if (req.equals("caster")) {
                ClassCasterLevelRequirement creq = null;
                for (ClassCasterLevelRequirement ccr : em.getClassCasterLevelRequirementsByClassID(classid)) {
                    if (ccr.getId() == id) {
                        creq = ccr;
                    }
                }
                em.removeFromDatabase(creq, id);
            }
            if (req.equals("spell")) {
                ClassSpellRequirement sreq = null;
                for (ClassSpellRequirement csr : em.getClassSpellRequirementsByClassID(classid)) {
                    if (csr.getId() == id) {
                        sreq = csr;
                    }
                }
                em.removeFromDatabase(sreq, id);
            }
            if (req.equals("att")) {
                ClassAttributeRequirement areq = null;
                for (ClassAttributeRequirement car : em.getClassAttributeRequirementsByClassID(classid)) {
                    if (car.getId() == id) {
                        areq = car;
                    }
                }
                em.removeFromDatabase(areq, id);
            }
            if (req.equals("save")) {
                ClassSaveRequirement sreq = null;
                for (ClassSaveRequirement csr : em.getClassSaveRequirementsByClassID(classid)) {
                    if (csr.getId() == id) {
                        sreq = csr;
                    }
                }
                em.removeFromDatabase(sreq, id);
            }
            if (req.equals("al")) {
                ClassAlignmentRequirement areq = null;
                for (ClassAlignmentRequirement car : em.getClassAlignmentRequirementsByClassID(classid)) {
                    if (car.getId() == id) {
                        areq = car;
                    }
                }
                em.removeFromDatabase(areq, id);
            }
            if (req.equals("level")) {
                ClassLevelRequirement lreq = null;
                try {
                    lreq = em.getClassLevelRequirementByClassID(classid);
                } catch (Exception e) {
                }

                em.removeFromDatabase(lreq, id);
            }
            if (req.equals("bab")) {
                ClassBABRequirement breq = null;
                try {
                    breq = em.getClassBABRequirementByClassID(classid);
                } catch (Exception e) {
                }
                em.removeFromDatabase(breq, id);
            }
            if (req.equals("deity")) {
                ClassDeityRequirement dreq = null;
                for (ClassDeityRequirement cdr : em.getClassDeityRequirementsByClassID(classid)) {
                    if (cdr.getId() == id) {
                        dreq = cdr;
                    }
                }
                em.removeFromDatabase(dreq, id);
            }
            if (req.equals("race")) {
                ClassRaceRequirement rreq = null;
                for (ClassRaceRequirement crr : em.getClassRaceRequirementsByClassID(classid)) {
                    if (crr.getId() == id) {
                        rreq = crr;
                    }
                }
                em.removeFromDatabase(rreq, id);
            }
        }


        request.getRequestDispatcher("/AddClassRequirements").forward(request, response);
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
