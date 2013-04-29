/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.search;

import ComponentManager.EM;
import Components.CClass;
import Components.DDomain;
import Components.Deity;
import Components.Feat;
import Components.Race;
import Components.Skill;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Näyttää tarkastellun hakutuloksen lisätietoja.
 * @author Uskon
 */
public class ShowInfoServlet extends HttpServlet {

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
        String itemid = request.getParameter("item");
        if (!itemid.isEmpty()) {
            if (type.equals("Class")) {
                CClass c = null;
                try {
                    c = em.getClassByID(itemid);
                } catch (Exception e) {
                }
                if (c != null) {
                    this.setClassInfoAttribute(c, request);
                }
            }
            if (type.equals("Feat")) {
                Feat f = null;
                try {
                    f = em.getFeatByID(itemid);
                } catch (Exception e) {
                }
                if (f != null) {
                    this.setFeatInfoAttribute(f, request);
                }
            }
            if (type.equals("Race")) {
                Race r = null;
                try {
                    r = em.getRaceByID(itemid);
                } catch (Exception e) {
                }
                if (r != null) {
                    this.setRaceInfoAttribute(r, request);
                }
            }
            if (type.equals("Skill")) {
                Skill s = null;
                try {
                    s = em.getSkillByID(itemid);
                } catch (Exception e) {
                }
                if (s != null) {
                    this.setSkillInfoAttribute(s, request);
                }
            }
            if (type.equals("Deity")) {
                Deity d = null;
                try {
                    d = em.getDeityByID(itemid);
                } catch (Exception e) {
                }
                if (d != null) {
                    this.setDeityInfoAttribute(d, request);
                }
            }
            if (type.equals("Domain")) {
                DDomain d = null;
                try {
                    d = em.getDomainByID(itemid);
                } catch (Exception e) {
                }
                if (d != null) {
                    this.setDomainInfoAttribute(d, request);
                }
            }
        }
        request.setAttribute("type", session.getAttribute("type"));
        request.setAttribute("result", session.getAttribute("result"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void setClassInfoAttribute(CClass c, HttpServletRequest request) {
        String classdesc = "No description";
        try {
            classdesc = em.getClassDescriptionByClassID("" + c.getId()).getDescription().replace("\n", "<br>");;
        } catch (Exception e) {
        }
        String classinfo = c.getName() + " ," + c.getRuleSet().getName() + "<br> Max level: " + c.getMaxlvl() + "<br><br>" + classdesc;
        request.setAttribute("info", classinfo);
    }

    private void setFeatInfoAttribute(Feat f, HttpServletRequest request) {
        String featdesc = "No description";
        try {
            featdesc = em.getFeatDescriptionByFeatID("" + f.getId()).getDescription().replace("\n", "<br>");;
        } catch (Exception e) {
        }
        String featinfo = f.getName() + " ," + f.getRuleSet().getName() + "<br><br>" + featdesc;
        request.setAttribute("info", featinfo);
    }

    private void setRaceInfoAttribute(Race r, HttpServletRequest request) {
        String racedesc = "No description";
        try {
            racedesc = em.getRaceDescriptionByRaceID("" + r.getId()).getDescription().replace("\n", "<br>");;
        } catch (Exception e) {
        }
        String raceinfo = r.getName() + " ," + r.getRuleSet().getName() + "<br><br>" + racedesc;
        request.setAttribute("info", raceinfo);
    }

    private void setSkillInfoAttribute(Skill s, HttpServletRequest request) {
        String skillinfo = s.getName() + " ," + s.getRuleSet().getName();
        request.setAttribute("info", skillinfo);
    }

    private void setDeityInfoAttribute(Deity d, HttpServletRequest request) {
        String deityinfo = d.getName() + " ," + d.getRuleSet().getName();
        request.setAttribute("info", deityinfo);
    }

    private void setDomainInfoAttribute(DDomain d, HttpServletRequest request) {
        String domaininfo = d.getName() + " ," + d.getRuleSet().getName();
        request.setAttribute("info", domaininfo);
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
