/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.additionServlets;

import ComponentManager.EM;
import Components.CClass;
import Components.ClassProgress;
import Components.descriptions.ClassDescription;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Tarkistaa syötteet ja hoitaa ClassProgressien generointi- ja lisäystapahtumat.
 * @author Uskon
 */
public class SetClassProgressServlet extends HttpServlet {

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
        request.setAttribute("class", session.getAttribute("managedClass"));
        String classid = (String) session.getAttribute("managedClass");
        session.removeAttribute("managedClass");
        CClass cclass = em.getClassByID(classid);
        request.setAttribute("class", cclass);
        if (noEmptyFields(request)) {
            String hd = request.getParameter("hd");
            String bab = request.getParameter("bab");
            String sp = request.getParameter("sp");
            String fort = request.getParameter("fort");
            String refl = request.getParameter("refl");
            String will = request.getParameter("will");
            String clvlprogress = request.getParameter("clvl");
            String exclvls = request.getParameter("exc");
            String slvlprogress = request.getParameter("slvl");
            String speclvls = request.getParameter("spec");
            boolean doesClassProgressExist = false;
            if (!em.getClassProgressByClassID(classid).isEmpty()) {
                doesClassProgressExist = true;
                request.setAttribute("cprog", em.getClassProgressByClassID(classid));
            }


            if (!doesClassProgressExist && cclass != null && session.getAttribute("logged") != null) {
                generateClassProgress(cclass, 1, 0, 0, hd, bab, sp, fort, refl, will, clvlprogress, exclvls, slvlprogress, speclvls);
            }

        }
        if (!em.getClassProgressByClassID(classid).isEmpty()) {
            request.setAttribute("cprog", em.getClassProgressByClassID(classid));
        }
        session.setAttribute("managedClass", classid);
        RequestDispatcher dispatcher = request.getRequestDispatcher("SetClassProgress.jsp");
        dispatcher.forward(request, response);


    }

    /**
     * Muuttaa tekstisyötteen käsittelykelpoiseen taulukkomuotoon.
     *
     * @param input
     * @return levelit taulukossa
     */
    private int[] restructureLevelInput(String input) {
        String newInput = input.replaceAll(" ", "");
        String[] parsedInput = newInput.split(",");
        int[] finalInput = new int[20];
        for (int k = 0; k < parsedInput.length; k++) {
            finalInput[k] = Integer.parseInt(parsedInput[k]);
        }
        return finalInput;
    }

    /**
     * Tarkistaa, että kaikki vaadittavat kentät on täytetty.
     *
     * @param request
     * @return true, jos vaatimukset täytetty
     */
    private boolean noEmptyFields(HttpServletRequest request) {
        if (request.getParameter("hd") == null) {
            return false;
        }
        if (request.getParameter("bab") == null) {
            return false;
        }
        if (request.getParameter("sp") == null) {
            return false;
        }
        if (request.getParameter("fort") == null) {
            return false;
        }
        if (request.getParameter("refl") == null) {
            return false;
        }
        if (request.getParameter("will") == null) {
            return false;
        }
        if (request.getParameter("clvl") == null) {
            return false;
        }
        if (request.getParameter("slvl") == null && request.getParameter("spec") == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Tarkistaa brutaalisti, onko tekstikenttien syöte kelvollisen muotoinen.
     *
     * @param input
     * @return true, jos syöte oikean muotoinen
     */
    private boolean properInput(String input) {
        try {
            restructureLevelInput(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Generoi ClassProgress-oliosetin Classille annettujen parametrien
     * perusteella. levelille.
     *
     * @param cclass
     * @param lvl
     * @param oldClvl
     * @param oldSlvl
     * @param hd
     * @param bab
     * @param sp
     * @param fort
     * @param refl
     * @param will
     * @param clvl
     * @param exc
     * @param slvl
     * @param spec
     * @param request
     * 
     */
    private void generateClassProgress(CClass cclass, int lvl, int oldClvl, int oldSlvl, String hd, String bab, String sp, String fort, String refl, String will, String clvl, String exc, String slvl, String spec) {
        if (lvl <= cclass.getMaxlvl()) {
            int hit = Integer.parseInt(hd.replaceAll("d", ""));
            int baseattack = calculateBAB(bab, lvl);
            int spoints = Integer.parseInt(sp);
            int fortsave = calculateSave(fort, lvl);
            int reflsave = calculateSave(refl, lvl);
            int willsave = calculateSave(will, lvl);
            int[] excludedLevels = new int[20];
            int[] specifiedLevels = new int[20];
            if (!exc.isEmpty()) {
                excludedLevels = restructureLevelInput(exc);
            }
            if (!spec.isEmpty()) {
                specifiedLevels = restructureLevelInput(spec);
            }
            int casterlevel = calculateCasterlvl(clvl, excludedLevels, oldClvl, lvl);
            int spelllevel = calculateSpelllvl(slvl, specifiedLevels, oldSlvl, lvl);
            em.addToDatabase(new ClassProgress(cclass, baseattack, casterlevel, spelllevel, hit, fortsave, willsave, reflsave, spoints, lvl));
            generateClassProgress(cclass, lvl + 1, casterlevel, spelllevel, hd, bab, sp, fort, refl, will, clvl, exc, slvl, spec);
        }
    }

    /**
     * Laskee CClassin level-kohtaisia caster level-arvoja.
     *
     * @param clvl
     * @param exc
     * @param oldClvl
     * @param lvl
     * @return level-kohtainen caster level
     */
    private int calculateCasterlvl(String clvl, int[] exc, int oldClvl, int lvl) {
        if (clvl.equals("full")) {
            if (isContained(lvl, exc)) {
                return oldClvl;
            } else {
                return oldClvl + 1;
            }
        }
        if (clvl.equals("half")) {
            return lvl / 2;
        }
        if (clvl.equals("none")) {
            return 0;
        } else {
            return oldClvl;
        }
    }

    /**
     * Laskee CClassin level-kohtaisia spell level -arvoja.
     *
     * @param slvl
     * @param spec
     * @param oldSlvl
     * @param lvl
     * @return level-kohtainen spell level
     */
    private int calculateSpelllvl(String slvl, int[] spec, int oldSlvl, int lvl) {
        if (oldSlvl == 9) {
            return oldSlvl;
        }
        boolean isSpecified = false;
        for (int k = 0; k < spec.length; k++) {
            if (spec[k] > 0) {
                isSpecified = true;
            }
        }
        if (isSpecified) {
            if (isContained(lvl, spec)) {
                return oldSlvl + 1;
            } else {
                return oldSlvl;
            }
        } else if (slvl.equals("odd")) {
            if (lvl == 1) {
                return 1;
            } else if (lvl % 2 == 1) {
                return oldSlvl + 1;
            } else {
                return oldSlvl;
            }
        } else if (slvl.equals("even")) {
            if (lvl == 1) {
                return 1;
            } else if (lvl % 2 == 0 && lvl > 2) {
                return oldSlvl + 1;
            } else {
                return oldSlvl;
            }
        } else {
            return oldSlvl;
        }
    }

    /**
     * Tarkistaa, onko luku taulukossa.
     *
     * @param lvl
     * @param t
     * @return true, jos luku on taulukossa
     */
    private boolean isContained(int lvl, int[] t) {
        boolean levelIsContained = false;
        for (int k = 0; k < t.length; k++) {
            if (t[k] == lvl) {
                levelIsContained = true;
            }
        }
        if (levelIsContained) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Laskee CClassin level-kohtaisia saving throw -arvoja tyypin ja levelin
     * perusteella.
     *
     * @param type
     * @param lvl
     * @return level-kohtainen save-arvo
     */
    private int calculateSave(String type, int lvl) {
        if (type.equals("high")) {
            return (lvl / 2 + 2);
        } else if (type.equals("low")) {
            return (lvl / 3);
        } else {
            return -1;
        }
    }

    /**
     * Laskee CClassin level-kohtaisia Base Attack Bonus -arvoja tyypin ja
     * levelin perusteella.
     *
     * @param bab
     * @param lvl
     * @return level-kohtainen Base attack bonus
     */
    private int calculateBAB(String bab, int lvl) {
        if (bab.equals("high")) {
            return lvl;
        } else if (bab.equals("med")) {
            if (lvl % 4 == 1) {
                return (lvl - (lvl / 4 + 1));
            } else {
                return (lvl - ((lvl - 1) / 4 + 1));
            }
        } else if (bab.equals("low")) {
            return lvl / 2;
        } else {
            return -1;
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
