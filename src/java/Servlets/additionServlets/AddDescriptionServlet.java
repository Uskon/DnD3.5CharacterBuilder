/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.additionServlets;

import ComponentManager.EM;
import Components.CClass;
import Components.Feat;
import Components.Race;
import Components.descriptions.ClassDescription;
import Components.descriptions.FeatDescription;
import Components.descriptions.RaceDescription;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Tarkistaa Descriptionin tyypin, syötteen ja hoitaa lisäämisen jos olemassaolevaa Descriptionia ei ole.
 * @author Uskon
 */
public class AddDescriptionServlet extends HttpServlet {

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
        String type = request.getParameter("type");
        if (request.getParameter("type") == null) {
            type = (String) session.getAttribute("desctype");
        }
        if (type.equals("class")) {
            addClassDescription(request, session);
            RequestDispatcher dispatcher = request.getRequestDispatcher("AddNewClassDescription.jsp");
            dispatcher.forward(request, response);
        }

        if (type.equals("feat")) {
            addFeatDescription(request, session);
            RequestDispatcher dispatcher = request.getRequestDispatcher("AddNewFeatDescription.jsp");
            dispatcher.forward(request, response);
        }
        if (type.equals("race")) {
            addRaceDescription(request, session);
            RequestDispatcher dispatcher = request.getRequestDispatcher("AddNewRaceDescription.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    private void addClassDescription(HttpServletRequest request, HttpSession session) {
        request.setAttribute("class", session.getAttribute("managedClass"));
            String classid = (String) session.getAttribute("managedClass");
            session.removeAttribute("managedClass");
            String desc = request.getParameter("description");
            CClass cclass = em.getClassByID(classid);
            request.setAttribute("class", cclass);
            String fixeddesc;
            boolean doesClassDescriptionExist = false;
            for (ClassDescription cd : em.getClassDescriptions()) {
                if (cd.getCclass().getId() == cclass.getId()) {
                    doesClassDescriptionExist = true;
                    fixeddesc = cd.getDescription().replace("\n", "<br>");
                    request.setAttribute("cdesc", fixeddesc);
                }
            }

            if (!doesClassDescriptionExist && cclass != null && desc != null && session.getAttribute("logged") != null) {
                em.addToDatabase(new ClassDescription(cclass, desc));
                fixeddesc = em.getClassDescriptionByClassID(classid).getDescription().replace("\n", "<br>");
                request.setAttribute("cdesc", fixeddesc);
            }
            session.setAttribute("managedClass", classid);
    }
    
    private void addFeatDescription(HttpServletRequest request, HttpSession session) {
        request.setAttribute("feat", session.getAttribute("managedFeat"));
            String featid = (String) session.getAttribute("managedFeat");
            session.removeAttribute("managedFeat");
            String desc = request.getParameter("description");
            Feat feat = em.getFeatByID(featid);
            request.setAttribute("feat", feat);
            String fixeddesc;
            boolean doesFeatDescriptionExist = false;
            for (FeatDescription fd : em.getFeatDescriptions()) {
                if (fd.getFeat().getId() == feat.getId()) {
                    doesFeatDescriptionExist = true;
                    fixeddesc = fd.getDescription().replace("\n", "<br>");
                    request.setAttribute("cdesc", fixeddesc);
                }
            }

            if (!doesFeatDescriptionExist && feat != null && desc != null && session.getAttribute("logged") != null) {
                em.addToDatabase(new FeatDescription(feat, desc));
                fixeddesc = em.getFeatDescriptionByFeatID(featid).getDescription().replace("\n", "<br>");
                request.setAttribute("cdesc", fixeddesc);
            }
            session.setAttribute("managedFeat", featid);
    }
    
    private void addRaceDescription(HttpServletRequest request, HttpSession session) {
        request.setAttribute("race", session.getAttribute("managedRace"));
            String raceid = (String) session.getAttribute("managedRace");
            session.removeAttribute("managedRace");
            String desc = request.getParameter("description");
            Race race = em.getRaceByID(raceid);
            request.setAttribute("race", race);
            String fixeddesc;
            boolean doesRaceDescriptionExist = false;
            for (RaceDescription rd : em.getRaceDescriptions()) {
                if (rd.getRace().getId() == race.getId()) {
                    doesRaceDescriptionExist = true;
                    fixeddesc = rd.getDescription().replace("\n", "<br>");
                    request.setAttribute("cdesc", fixeddesc);
                }
            }

            if (!doesRaceDescriptionExist && race != null && desc != null && session.getAttribute("logged") != null) {
                em.addToDatabase(new RaceDescription(race, desc));
                fixeddesc = em.getRaceDescriptionByRaceID(raceid).getDescription().replace("\n", "<br>");
                request.setAttribute("cdesc", fixeddesc);
            }
            session.setAttribute("managedRace", raceid);
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
