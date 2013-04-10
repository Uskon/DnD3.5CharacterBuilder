/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.additionServlets;

import ComponentLists.CClassList;
import ComponentLists.RuleSetList;
import Components.CClass;
import Components.RuleSet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Uskon
 */
public class AddClassServlet extends HttpServlet {
    private CClassList clist = new CClassList(); 
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
        String name = request.getParameter("className");
        String ruleset = request.getParameter("rset");
        RuleSet rset = null;
        for (int n = 0; n < rsetlist.getRuleSets().size(); n++) {
            if (rsetlist.getRuleSets().get(n).getName().equals(ruleset)) {
                rset = rsetlist.getRuleSets().get(n);
            }
        }
        boolean doesClassExist = false;
        for (CClass c : clist.getClasses()) {
            if (c.getName().equals(name) && c.getRuleSet()==rset) {
                doesClassExist = true;
            } 
        }
        
        if (rset != null && !doesClassExist && session.getAttribute("logged") != null) {
        clist.addClass(new CClass(name, rset));
        }
        
        request.getRequestDispatcher("/AddNewClass").forward(request, response);
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
