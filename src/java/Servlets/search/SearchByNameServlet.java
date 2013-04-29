/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.search;

import ComponentManager.EM;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Palauttaa tiedot hakutuloksista.
 * @author Uskon
 */
public class SearchByNameServlet extends HttpServlet {
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
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        if (!(name.matches("[a-zA-Z0-9 _-]*"))) {
            type = "";
            request.setAttribute("badinput", true);
        }
        if (type.equals("Class")) {
            if (em.searchClassesByName(name).isEmpty()) {
                request.setAttribute("noresult", true);
            }
            request.setAttribute("result", em.searchClassesByName(name));
            session.setAttribute("result", em.searchClassesByName(name));
            request.setAttribute("type", "Class");
            session.setAttribute("type", "Class");
        }
        if (type.equals("Feat")) {
            if (em.searchFeatsByName(name).isEmpty()) {
                request.setAttribute("noresult", true);
            }
            request.setAttribute("result", em.searchFeatsByName(name));
            session.setAttribute("result", em.searchFeatsByName(name));
            request.setAttribute("type", "Feat");
            session.setAttribute("type", "Feat");
        }
        if (type.equals("Race")) {
            if (em.searchRacesByName(name).isEmpty()) {
                request.setAttribute("noresult", true);
            }
            request.setAttribute("result", em.searchRacesByName(name));
            session.setAttribute("result", em.searchRacesByName(name));
            request.setAttribute("type", "Race");
            session.setAttribute("type", "Race");
        }
        if (type.equals("Skill")) {
            if (em.searchSkillsByName(name).isEmpty()) {
                request.setAttribute("noresult", true);
            }
            request.setAttribute("result", em.searchSkillsByName(name));
            session.setAttribute("result", em.searchSkillsByName(name));
            request.setAttribute("type", "Skill");
            session.setAttribute("type", "Skill");
        }
        if (type.equals("Deity")) {
            if (em.searchDeitiesByName(name).isEmpty()) {
                request.setAttribute("noresult", true);
            }
            request.setAttribute("result", em.searchDeitiesByName(name));
            session.setAttribute("result", em.searchDeitiesByName(name));
            request.setAttribute("type", "Deity");
            session.setAttribute("type", "Deity");
        }
        if (type.equals("Domain")) {
            if (em.searchDomainsByName(name).isEmpty()) {
                request.setAttribute("noresult", true);
            }
            request.setAttribute("result", em.searchDomainsByName(name));
            session.setAttribute("result", em.searchDomainsByName(name));
            request.setAttribute("type", "Domain");
            session.setAttribute("type", "Domain");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
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
