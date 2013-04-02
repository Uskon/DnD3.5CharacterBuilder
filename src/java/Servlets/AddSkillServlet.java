/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import ComponentLists.RuleSetList;
import ComponentLists.SkillList;
import Components.RuleSet;
import Components.Skill;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Uskon
 */
public class AddSkillServlet extends HttpServlet {

    private SkillList skillList = new SkillList();
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
        String name = request.getParameter("skillName");
        String ruleset = request.getParameter("rset");

        RuleSet rset = null;
        for (int n = 0; n < rsetlist.getRuleSets().size(); n++) {
            if (rsetlist.getRuleSets().get(n).getName().equals(ruleset)) {
                rset = rsetlist.getRuleSets().get(n);
            }
        }

        boolean doesSkillExist = false;
        for (int k = 0; k < skillList.getSkills().size(); k++) {
            if (skillList.getSkills().get(k).getName().equals(name)) {
                doesSkillExist = true;
                break;
            }
        }
        if (!doesSkillExist && rset != null) {
            skillList.addSkill(new Skill(name, rset));
        }

        request.getRequestDispatcher("/AddNewSkill").forward(request, response);
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
