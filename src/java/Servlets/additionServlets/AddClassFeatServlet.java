/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.additionServlets;

import ComponentManager.EM;
import Components.CClass;
import Components.ClassFeat;
import Components.ClassSkill;
import Components.Feat;
import Components.Skill;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Tarkistaa CClassin lisäämisen syötteen ja hoitaa ClassFeatin lisäystapahtuman.
 * 
 */
public class AddClassFeatServlet extends HttpServlet {

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
        String featId = request.getParameter("feat");
        String l = request.getParameter("level");
        CClass cclass = em.getClassByID(classid);
        Feat feat = null;
        int lvl = 0;
        boolean doesClassFeatExist = false;
        if (l != null && featId != null && l.matches("[0-9]*")) {
            lvl = Integer.parseInt(l);
            if (lvl > cclass.getMaxlvl()) {
                lvl = 0;
            }
            feat = em.getFeatByID(featId);
            if (!em.getClassFeats().isEmpty()) {
                for (ClassFeat cf : em.getClassFeats()) {
                    if (cf.getCclass().getId() == cclass.getId() && cf.getFeat().getId() == feat.getId()) {
                        doesClassFeatExist = true;
                    }
                }
            }
        }
        if (!doesClassFeatExist && cclass != null && feat != null && session.getAttribute("logged") != null && lvl > 0) {
            em.addToDatabase(new ClassFeat(cclass, feat, lvl));
        }
        if (lvl <= 0) {
            request.setAttribute("badlvl", true);
        }
        session.setAttribute("managedClass", classid);
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddNewClassFeat");
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
