/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.additionServlets;

import ComponentManager.EM;
import Components.CClass;
import Components.ClassSkill;
import Components.Skill;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Tarkistaa syötteen ja hoitaa ClassSkillin lisäämistapahtuman.
 * @author Uskon
 */
public class AddClassSkillServlet extends HttpServlet {

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
        session.removeAttribute("managedClass");
        String classid = request.getParameter("cclass");
        String skillId = request.getParameter("skill");
        String t = request.getParameter("type");
        CClass cclass = em.getClassByID(classid);
        Skill skill = null;
        int type = 3;
        boolean doesClassSkillExist = false;
        if (t != null && skillId != null) {
            type = Integer.parseInt(t);
            skill = em.getSkillByID(skillId);
            if (!em.getClassSkills().isEmpty()) {
                for (ClassSkill cs : em.getClassSkills()) {
                    if (cs.getCclass().getId() == cclass.getId() && cs.getSkill().getId() == skill.getId()) {
                        doesClassSkillExist = true;
                    }
                }
            }
        }
        if (!doesClassSkillExist && cclass != null && skill != null && session.getAttribute("logged") != null && type != 3) {
            em.addToDatabase(new ClassSkill(cclass, skill, type));
        }
        session.setAttribute("managedClass", classid);
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddNewClassSkill");
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
