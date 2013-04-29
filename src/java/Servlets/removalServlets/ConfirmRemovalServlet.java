/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.removalServlets;

import ComponentManager.ClassRemover;
import ComponentManager.DeityRemover;
import ComponentManager.DomainRemover;
import ComponentManager.EM;
import ComponentManager.FeatRemover;
import ComponentManager.RaceRemover;
import ComponentManager.RuleSetRemover;
import ComponentManager.SkillRemover;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Tarkistaa mitä ollaan poistamassa ja saadun syötteen perusteella voi suorittaa poiston, ohjaa takaisin määrätylle sivulle.
 * @author Uskon
 */
public class ConfirmRemovalServlet extends HttpServlet {

    private EM em = new EM();
    private ClassRemover classremover = new ClassRemover();
    private FeatRemover featremover = new FeatRemover();
    private RaceRemover raceremover = new RaceRemover();
    private SkillRemover skillremover = new SkillRemover();
    private DeityRemover deityremover = new DeityRemover();
    private DomainRemover domainremover = new DomainRemover();
    private RuleSetRemover rsetremover = new RuleSetRemover();

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
        String action = request.getParameter("action");
        String type = request.getParameter("type");

        if (action.equals("Remove")) {
            if (type.equals("cclass")) {
                String classid = (String) session.getAttribute("managedClass");
                deleteClass(session, response, classid);
            }
            if (type.equals("feat")) {
                String featid = (String) session.getAttribute("managedFeat");
                deleteFeat(session, response, featid);
            }
            if (type.equals("race")) {
                String raceid = (String) session.getAttribute("managedRace");
                deleteRace(session, response, raceid);
            }
            if (type.equals("deity")) {
                String deityid = (String) session.getAttribute("managedDeity");
                deleteDeity(session, response, deityid);
            }
            if (type.equals("domain")) {
                String domainid = (String) session.getAttribute("managedDomain");
                deleteDomain(session, response, domainid);
            }
            if (type.equals("skill")) {
                String skillid = (String) session.getAttribute("managedSkill");
                deleteSkill(session, response, skillid);
            }
            if (type.equals("ruleset")) {
                String pw = "";
                try {
                    pw = request.getParameter("confirmation");
                } catch (Exception e) {
                }
                if (pw.equals("Cybuster")) {
                    String rulesetname = (String) session.getAttribute("managedRuleSet");
                    deleteRuleSet(session, response, rulesetname);
                } else {
                    response.sendRedirect("ConfirmRuleSetRemoval");
                    return;
                }
            }
        }
        if (action.equals("Cancel")) {
        }

        if (type.equals("cclass")) {
            session.removeAttribute("managedClass");
            response.sendRedirect("ManageClasses");
        }
        if (type.equals("feat")) {
            session.removeAttribute("managedFeat");
            response.sendRedirect("ManageFeats");
        }
        if (type.equals("race")) {
            session.removeAttribute("managedRace");
            response.sendRedirect("ManageRaces");
        }
        if (type.equals("skill")) {
            session.removeAttribute("managedSkill");
            response.sendRedirect("ManageSkills");
        }
        if (type.equals("deity")) {
            session.removeAttribute("managedDeity");
            response.sendRedirect("ManageDeities");
        }
        if (type.equals("domain")) {
            session.removeAttribute("managedDomain");
            response.sendRedirect("ManageDomains");
        }
        if (type.equals("ruleset")) {
            session.removeAttribute("managedRuleSet");
            response.sendRedirect("ManageRuleSets");
        }
    }

    /**
     * Poistaa tietokannasta annetulla id:llä olevan CClassin ja kaikki siihen
     * viittaavat muiden taulujen rivit.
     *
     * @param session
     * @param response
     * @param classid
     */
    private void deleteClass(HttpSession session, HttpServletResponse response, String classid) {
        try {
        classremover.removeCompletely(classid);
        } catch (Exception e) {
         session.setAttribute("outdated", true);
         try {
         response.sendRedirect("ManageClasses");
         return;
         } catch (Exception e2) {
         }
         }
    }

    /**
     * Poistaa tietokannasta annetulla id:llä olevan Featin ja kaikki siihen
     * viittaavat muiden taulujen rivit.
     *
     * @param session
     * @param response
     * @param classid
     */
    private void deleteFeat(HttpSession session, HttpServletResponse response, String featid) {
        try {
        featremover.removeCompletely(featid);
        } catch (Exception e) {
         session.setAttribute("outdated", true);
         try {
         response.sendRedirect("ManageFeats");
         } catch (Exception e2) {
         }
         }
    }

    /**
     * Poistaa tietokannasta annetulla id:llä olevan Racen ja kaikki siihen
     * viittaavat muiden taulujen rivit.
     *
     * @param session
     * @param response
     * @param classid
     */
    private void deleteRace(HttpSession session, HttpServletResponse response, String raceid) {
        try {
        raceremover.removeCompletely(raceid);
        } catch (Exception e) {
         session.setAttribute("outdated", true);
         try {
         response.sendRedirect("ManageRaces");
         } catch (Exception e2) {
         }
         }
    }

    /**
     * Poistaa tietokannasta annetulla id:llä olevan Skillin ja kaikki siihen
     * viittaavat muiden taulujen rivit.
     *
     * @param session
     * @param response
     * @param classid
     */
    private void deleteSkill(HttpSession session, HttpServletResponse response, String skillid) {
        try {
        skillremover.removeCompletely(skillid);
        } catch (Exception e) {
         session.setAttribute("outdated", true);
         try {
         response.sendRedirect("ManageSkills");
         } catch (Exception e2) {
         }
         }
    }

    /**
     * Poistaa tietokannasta annetulla id:llä olevan Deityn ja kaikki siihen
     * viittaavat muiden taulujen rivit.
     *
     * @param session
     * @param response
     * @param classid
     */
    private void deleteDeity(HttpSession session, HttpServletResponse response, String deityid) {
        try {
        deityremover.removeCompletely(deityid);
        } catch (Exception e) {
         session.setAttribute("outdated", true);
         try {
         response.sendRedirect("ManageDeities");
         } catch (Exception e2) {
         }
         }
    }

    /**
     * Poistaa tietokannasta annetulla id:llä olevan DDomainin ja kaikki siihen
     * viittaavat muiden taulujen rivit.
     *
     * @param session
     * @param response
     * @param classid
     */
    private void deleteDomain(HttpSession session, HttpServletResponse response, String domainid) {
        try {
        domainremover.removeCompletely(domainid);
        } catch (Exception e) {
         session.setAttribute("outdated", true);
         try {
         response.sendRedirect("ManageDomains");
         } catch (Exception e2) {
         }
         }
    }

    /**
     * Poistaa tietokannasta annetulla id:llä olevan RuleSetin ja kaikki siihen
     * viittaavat muiden taulujen rivit.
     *
     * @param session
     * @param response
     * @param classid
     */
    private void deleteRuleSet(HttpSession session, HttpServletResponse response, String rsetname) {
        try {
        rsetremover.removeRuleSetCompletely(rsetname);
        } catch (Exception e) {
         session.setAttribute("outdated", true);
         try {
         response.sendRedirect("ManageRuleSets");
         } catch (Exception e2) {
         }
         }
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
