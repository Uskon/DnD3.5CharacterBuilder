/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.additionServlets;

import ComponentManager.EM;
import Components.ClassFeat;
import Components.DDomain;
import Components.DomainFeat;
import Components.Feat;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Tarkistaa syötteen ja hoitaa DomainFeatin lisäämistapahtuman.
 * @author Uskon
 */
public class AddDomainFeatServlet extends HttpServlet {
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
        session.removeAttribute("managedDomain");
        String domainid = request.getParameter("ddomain");
        String featId = request.getParameter("feat");
        DDomain ddomain = em.getDomainByID(domainid);
        Feat feat = null;
        boolean doesDomainFeatExist = false;
        if (featId != null) {
            feat = em.getFeatByID(featId);
            if (!em.getDomainFeats().isEmpty()) {
                for (DomainFeat df : em.getDomainFeats()) {
                    if (df.getDomain().getId() == ddomain.getId() && df.getFeat().getId() == feat.getId()) {
                        doesDomainFeatExist = true;
                    }
                }
            }
        }
        if (!doesDomainFeatExist && ddomain != null && feat != null && session.getAttribute("logged") != null) {
            em.addToDatabase(new DomainFeat(ddomain, feat));
        }
        request.setAttribute("domain", ddomain);
        session.setAttribute("managedDomain", domainid);
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddNewDomainFeat");
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
