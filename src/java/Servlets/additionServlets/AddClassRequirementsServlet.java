/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.additionServlets;

import ComponentManager.EM;
import Components.Alignment;
import Components.CClass;
import Components.ClassRequirement.ClassAlignmentRequirement;
import Components.ClassRequirement.ClassAttributeRequirement;
import Components.ClassRequirement.ClassBABRequirement;
import Components.ClassRequirement.ClassCasterLevelRequirement;
import Components.ClassRequirement.ClassClassRequirement;
import Components.ClassRequirement.ClassDeityRequirement;
import Components.ClassRequirement.ClassFeatRequirement;
import Components.ClassRequirement.ClassLevelRequirement;
import Components.ClassRequirement.ClassRaceRequirement;
import Components.ClassRequirement.ClassSaveRequirement;
import Components.ClassRequirement.ClassSkillRequirement;
import Components.ClassRequirement.ClassSpellRequirement;
import Components.Deity;
import Components.Feat;
import Components.Race;
import Components.Skill;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Tarkistaa Class*Requirementtien lisäämisen syötteet ja hoitaa lisäämiset.
 * 
 */
public class AddClassRequirementsServlet extends HttpServlet {

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
        request.setAttribute("class", session.getAttribute("managedClass"));
        String classid = (String) session.getAttribute("managedClass");
        session.removeAttribute("managedClass");
        CClass cclass = em.getClassByID(classid);
        request.setAttribute("class", cclass);
        
        addClassRequirement(classid, cclass, request);
        addFeatRequirement(classid, cclass, request);
        addSkillRequirement(classid, cclass, request);
        addBABRequirement(classid, cclass, request);
        addCasterLevelRequirement(classid, cclass, request);
        addSpellRequirement(classid, cclass, request);
        addAttributeRequirement(classid, cclass, request);
        addSaveRequirement(classid, cclass, request);
        addAlignmentRequirement(classid, cclass, request);
        addDeityRequirement(classid, cclass, request);
        addLevelRequirement(classid, cclass, request);
        addRaceRequirement(classid, cclass, request);

        if (cclass != null) {
            setRequestAttributes(request, cclass);
            setRequestListAttributes(request, classid);
        }
        session.setAttribute("managedClass", classid);
        request.getRequestDispatcher("/AddClassRequirements.jsp").forward(request, response);
    }

    /**
     * Asettaa jsp:lle hyödynnettäväksi CClassin boolean-parametrejä.
     *
     * @param request
     */
    private void setRequestAttributes(HttpServletRequest request, CClass cclass) {
        if (cclass.isClassRequired()) {
            request.setAttribute("classrequired", true);
        }
        if (cclass.isFeatRequired()) {
            request.setAttribute("featrequired", true);
        }
        if (cclass.isSkillRequired()) {
            request.setAttribute("skillrequired", true);
        }
        if (cclass.isBABRequired()) {
            request.setAttribute("babrequired", true);
        }
        if (cclass.isCasterLevelRequired()) {
            request.setAttribute("casterrequired", true);
        }
        if (cclass.isSpellLevelRequired()) {
            request.setAttribute("spellrequired", true);
        }
        if (cclass.isAttributeRequired()) {
            request.setAttribute("attributerequired", true);
        }
        if (cclass.isSaveRequired()) {
            request.setAttribute("saverequired", true);
        }
        if (cclass.isAlignmentRequired()) {
            request.setAttribute("alignmentrequired", true);
        }
        if (cclass.isDeityRequired()) {
            request.setAttribute("deityrequired", true);
        }
        if (cclass.isRaceRequired()) {
            request.setAttribute("racerequired", true);
        }
        if (cclass.isLevelRequired()) {
            request.setAttribute("levelrequired", true);
        }
        if (!(cclass.isAlignmentRequired() || cclass.isAttributeRequired() || cclass.isBABRequired() || cclass.isCasterLevelRequired() || cclass.isClassRequired() || cclass.isDeityRequired() || cclass.isFeatRequired() || cclass.isLevelRequired() || cclass.isRaceRequired() || cclass.isSaveRequired() || cclass.isSkillRequired() || cclass.isSpellLevelRequired())) {
            request.setAttribute("noreqs", true);
        }

    }

    /**
     * Asettaa jsp:n käyttöön erilaisia oliolistoja, jos ne eivät ole tyhjiä.
     *
     * @param request
     * @param cclass
     */
    public void setRequestListAttributes(HttpServletRequest request, String classid) {
        if (!em.getClassClassRequirementsByClassID(classid).isEmpty()) {
            request.setAttribute("classlist", em.getClassClassRequirementsByClassID(classid));
        }
        if (!em.getClassFeatRequirementsByClassID(classid).isEmpty()) {
            request.setAttribute("featlist", em.getClassFeatRequirementsByClassID(classid));
        }
        if (!em.getClassSkillRequirementsByClassID(classid).isEmpty()) {
            request.setAttribute("skilllist", em.getClassSkillRequirementsByClassID(classid));
        }

        ClassBABRequirement cbr = null;
        try {
            cbr = em.getClassBABRequirementByClassID(classid);
        } catch (Exception e) {
        }
        if (cbr != null) {
            request.setAttribute("bab", cbr);
        }

        if (!em.getClassCasterLevelRequirementsByClassID(classid).isEmpty()) {
            request.setAttribute("casterlist", em.getClassCasterLevelRequirementsByClassID(classid));
        }
        if (!em.getClassSpellRequirementsByClassID(classid).isEmpty()) {
            request.setAttribute("spelllist", em.getClassSpellRequirementsByClassID(classid));
        }
        if (!em.getClassAttributeRequirementsByClassID(classid).isEmpty()) {
            request.setAttribute("attributelist", em.getClassAttributeRequirementsByClassID(classid));
        }
        if (!em.getClassSaveRequirementsByClassID(classid).isEmpty()) {
            request.setAttribute("savelist", em.getClassSaveRequirementsByClassID(classid));
        }

        ClassLevelRequirement clr = null;
        try {
            clr = em.getClassLevelRequirementByClassID(classid);
        } catch (Exception e) {
        }
        if (clr != null) {
            request.setAttribute("level", clr);
        }

        if (!em.getClassAlignmentRequirementsByClassID(classid).isEmpty()) {
            request.setAttribute("alignmentlist", em.getClassAlignmentRequirementsByClassID(classid));
        }
        if (!em.getClassDeityRequirementsByClassID(classid).isEmpty()) {
            request.setAttribute("deitylist", em.getClassDeityRequirementsByClassID(classid));
        }
        if (!em.getClassRaceRequirementsByClassID(classid).isEmpty()) {
            request.setAttribute("racelist", em.getClassRaceRequirementsByClassID(classid));
        }
    }

    /**
     * Tarkistaa onko ClassClassRequirementin syöte laitettu ja onko se oikein,
     * ja sitten yrittää luodat uudet oliot.
     *
     * @param classid
     * @param cclass
     * @param request
     */
    private void addClassRequirement(String classid, CClass cclass, HttpServletRequest request) {
        if (request.getParameter("classreq") != null && request.getParameter("classlvl") != null) {
            if (request.getParameter("classreq").matches("[a-zA-Z0-9 _-]+") && request.getParameter("classlvl").matches("[0-9]{1,2}") && cclass != null) {
                List<CClass> classlist = em.getClassesByName(request.getParameter("classreq"));
                int lvl = Integer.parseInt(request.getParameter("classlvl"));
                if (!classlist.isEmpty()) {
                    for (CClass c : classlist) {
                        boolean doesRequirementExist = false;
                        if (!em.getClassClassRequirementsByClassID(classid).isEmpty()) {
                            for (ClassClassRequirement ccr : em.getClassClassRequirementsByClassID(classid)) {
                                if (ccr.getRequiredClass().getId() == c.getId()) {
                                    doesRequirementExist = true;
                                }
                            }
                        }
                        if (!doesRequirementExist && !c.getName().equals(cclass.getName())) {
                            em.addToDatabase(new ClassClassRequirement(cclass, c, lvl));
                        }
                    }
                }
            }
        }
    }

    /**
     * Tarkistaa onko syötettä annettua ja onko se oikein, ja sitten yrittää
     * luoda uusia ClassFeatRequirementteja jos niitä ei ole jo olemassa.
     *
     * @param classid
     * @param cclass
     * @param request
     */
    private void addFeatRequirement(String classid, CClass cclass, HttpServletRequest request) {
        if (request.getParameter("feat") != null) {
            if (request.getParameter("feat").matches("[a-zA-Z0-9 _-]+") && cclass != null) {
                List<Feat> featlist = em.getFeatsByName(request.getParameter("feat"));
                if (!featlist.isEmpty()) {
                    for (Feat f : featlist) {
                        boolean doesRequirementExist = false;
                        if (!em.getClassFeatRequirementsByClassID(classid).isEmpty()) {
                            for (ClassFeatRequirement cfr : em.getClassFeatRequirementsByClassID(classid)) {
                                if (cfr.getRequiredFeat().getId() == f.getId()) {
                                    doesRequirementExist = true;
                                }
                            }
                        }
                        if (!doesRequirementExist) {
                            em.addToDatabase(new ClassFeatRequirement(cclass, f));
                        }
                    }
                }
            }
        }
    }

    /**
     * Tarkistaa onko syötettä annettua ja onko se oikein, ja sitten yrittää
     * luoda uusia ClassSkillRequirementteja jos niitä ei ole jo olemassa.
     *
     * @param classid
     * @param cclass
     * @param request
     */
    private void addSkillRequirement(String classid, CClass cclass, HttpServletRequest request) {
        if (request.getParameter("skill") != null && request.getParameter("skillrank") != null) {
            if (request.getParameter("skill").matches("[a-zA-Z0-9 _-]+") && request.getParameter("skillrank").matches("[0-9]{1,2}") && cclass != null) {
                List<Skill> skilllist = em.getSkillsByName(request.getParameter("skill"));
                int lvl = Integer.parseInt(request.getParameter("skillrank"));
                if (!skilllist.isEmpty()) {
                    for (Skill s : skilllist) {
                        boolean doesRequirementExist = false;
                        if (!em.getClassSkillRequirementsByClassID(classid).isEmpty()) {
                            for (ClassSkillRequirement csr : em.getClassSkillRequirementsByClassID(classid)) {
                                if (csr.getRequiredSkill().getId() == s.getId()) {
                                    doesRequirementExist = true;
                                }
                            }
                        }
                        if (!doesRequirementExist) {
                            em.addToDatabase(new ClassSkillRequirement(cclass, s, lvl));
                        }
                    }
                }
            }
        }
    }

    /**
     * Tarkistaa, onko syötettä annettu ja onko se oikein, ja sitten yrittää
     * luoda uuden ClassBABRequirementin jos sellaista ei jo CClassilla ole.
     *
     * @param classid
     * @param cclass
     * @param request
     */
    private void addBABRequirement(String classid, CClass cclass, HttpServletRequest request) {
        if (request.getParameter("bab") != null) {
            if (request.getParameter("bab").matches("[0-9]{1,2}") && cclass != null) {
                int bab = Integer.parseInt(request.getParameter("bab"));
                boolean doesRequirementExist = false;
                ClassBABRequirement babreq = null;
                try {
                    babreq = em.getClassBABRequirementByClassID(classid);
                } catch (Exception e) {
                }
                if (babreq != null) {
                    doesRequirementExist = true;
                }
                if (!doesRequirementExist) {
                    em.addToDatabase(new ClassBABRequirement(cclass, bab));
                }
            }
        }
    }

    /**
     * Tarkistaa onko syötettä annettu ja onko se oikein, ja sitten yrittää
     * luoda uudet ClassCasterLevelRequirementit jos niitä ei ole jo olemassa.
     *
     * @param classid
     * @param cclass
     * @param request
     */
    private void addCasterLevelRequirement(String classid, CClass cclass, HttpServletRequest request) {
        if (request.getParameter("casterclass") != null && request.getParameter("casterlevel") != null) {
            if (request.getParameter("casterclass").matches("[a-zA-Z0-9 _-]+") && request.getParameter("casterlevel").matches("[0-9]{1,2}") && cclass != null) {
                List<CClass> classlist = em.getClassesByName(request.getParameter("casterclass"));
                int lvl = Integer.parseInt(request.getParameter("casterlevel"));
                if (!classlist.isEmpty()) {
                    for (CClass c : classlist) {
                        boolean doesRequirementExist = false;
                        if (!em.getClassCasterLevelRequirementsByClassID(classid).isEmpty()) {
                            for (ClassCasterLevelRequirement cclr : em.getClassCasterLevelRequirementsByClassID(classid)) {
                                if (cclr.getRequiredClass().getId() == c.getId()) {
                                    doesRequirementExist = true;
                                }
                            }
                        }
                        if (!doesRequirementExist && !c.getName().equals(cclass.getName())) {
                            em.addToDatabase(new ClassCasterLevelRequirement(cclass, c, lvl));
                        }
                    }
                }
            }
        }
    }

    /**
     * Tarkistaa onko syötettä annettu ja onko se oikein, ja sitten yrittää
     * luoda uudet ClassSpellRequirementit jos niitä ei ole jo olemassa.
     *
     * @param classid
     * @param cclass
     * @param request
     */
    private void addSpellRequirement(String classid, CClass cclass, HttpServletRequest request) {
        if (request.getParameter("spellclass") != null && request.getParameter("spelllevel") != null) {
            if (request.getParameter("spellclass").matches("[a-zA-Z0-9 _-]+") && request.getParameter("spelllevel").matches("[0-9]{1,2}") && cclass != null) {
                List<CClass> classlist = em.getClassesByName(request.getParameter("spellclass"));
                int lvl = Integer.parseInt(request.getParameter("spelllevel"));
                if (!classlist.isEmpty()) {
                    for (CClass c : classlist) {
                        boolean doesRequirementExist = false;
                        if (!em.getClassSpellRequirementsByClassID(classid).isEmpty()) {
                            for (ClassSpellRequirement csr : em.getClassSpellRequirementsByClassID(classid)) {
                                if (csr.getRequiredClass().getId() == c.getId()) {
                                    doesRequirementExist = true;
                                }
                            }
                        }
                        if (!doesRequirementExist&& !c.getName().equals(cclass.getName())) {
                            em.addToDatabase(new ClassSpellRequirement(cclass, c, lvl));
                        }
                    }
                }
            }
        }
    }

    /**
     * Tarkistaa onko syötettä annettu ja onko se oikein, ja sitten yrittää
     * luoda uuden ClassAttributeRequirementin jos sitä ei ole jo olemassa.
     *
     * @param classid
     * @param cclass
     * @param request
     */
    private void addAttributeRequirement(String classid, CClass cclass, HttpServletRequest request) {
        int str = 0;
        int dex = 0;
        int con = 0;
        int in = 0;
        int wis = 0;
        int cha = 0;
        try {
            str = Integer.parseInt(request.getParameter("str"));
            dex = Integer.parseInt(request.getParameter("dex"));
            con = Integer.parseInt(request.getParameter("con"));
            in = Integer.parseInt(request.getParameter("int"));
            wis = Integer.parseInt(request.getParameter("wis"));
            cha = Integer.parseInt(request.getParameter("cha"));
        } catch (Exception e) {
        }
        boolean doesRequirementExist = false;
        if (!em.getClassAttributeRequirementsByClassID(classid).isEmpty()) {
            for (ClassAttributeRequirement car : em.getClassAttributeRequirementsByClassID(classid)) {
                if (car.getSTR() == str && car.getDEX() == dex && car.getCON() == con && car.getINTG() == in && car.getWIS() == wis && car.getCHA() == cha) {
                    doesRequirementExist = true;
                }
            }
        }
        if (!doesRequirementExist && (str != 0 || dex != 0 || con != 0 || in != 0 || wis != 0 || cha != 0)) {
            em.addToDatabase(new ClassAttributeRequirement(cclass, str, dex, con, in, wis, cha));
        }
    }

    /**
     * Tarkistaa onko syötettä annettu ja onko se oikein, ja sitten yrittää
     * luoda uuden ClassSaveRequirementit jos sitä ei ole jo olemassa.
     *
     * @param classid
     * @param cclass
     * @param request
     */
    private void addSaveRequirement(String classid, CClass cclass, HttpServletRequest request) {
        int fort = 0;
        int refl = 0;
        int will = 0;
        try {
            fort = Integer.parseInt(request.getParameter("fort"));
            refl = Integer.parseInt(request.getParameter("refl"));
            will = Integer.parseInt(request.getParameter("will"));
        } catch (Exception e) {
        }
        boolean doesRequirementExist = false;
        if (!em.getClassSaveRequirementsByClassID(classid).isEmpty()) {
            for (ClassSaveRequirement csr : em.getClassSaveRequirementsByClassID(classid)) {
                if (csr.getFortSave() == fort && csr.getReflSave() == refl && csr.getWillSave() == will) {
                    doesRequirementExist = true;
                }
            }
        }
        if (!doesRequirementExist && (fort != 0 || refl != 0 || will != 0)) {
            em.addToDatabase(new ClassSaveRequirement(cclass, fort, will, refl));
        }
    }

    /**
     * Tarkistaa onko syötettä annettu ja onko se oikein, ja sitten yrittää
     * luoda uuden ClassLevelRequirementin jos sellaista ei ole olemassa.
     *
     * @param classid
     * @param cclass
     * @param request
     */
    private void addLevelRequirement(String classid, CClass cclass, HttpServletRequest request) {
        int level = 0;
        try {
            level = Integer.parseInt(request.getParameter("charlvl"));
        } catch (Exception e) {
        }
        boolean doesRequirementExist = false;
        ClassLevelRequirement lvlreq = null;
        try {
            lvlreq = em.getClassLevelRequirementByClassID(classid);
        } catch (Exception e) {
        }
        if (lvlreq != null) {
            doesRequirementExist = true;
        }
        if (!doesRequirementExist && level != 0) {
            em.addToDatabase(new ClassLevelRequirement(cclass, level));
        }
    }

    /**
     * Tarkistaa onko syötettä annettu ja onko se oikein, ja yrittää lisätä
     * uuden ClassAlignmentRequirementin jos samaa ei ole jo olemassa.
     *
     * @param classid
     * @param cclass
     * @param request
     */
    public void addAlignmentRequirement(String classid, CClass cclass, HttpServletRequest request) {
        if (request.getParameter("alignment") != null) {
            if (request.getParameter("alignment").matches("LG|LN|LE|NG|N|NE|CG|CN|CE")) {
                String as = request.getParameter("alignment");
                Alignment a = null;
                if (as.equals("LG")) {
                    a = Alignment.LG;
                }
                if (as.equals("LN")) {
                    a = Alignment.LN;
                }
                if (as.equals("LE")) {
                    a = Alignment.LE;
                }
                if (as.equals("NG")) {
                    a = Alignment.NG;
                }
                if (as.equals("N")) {
                    a = Alignment.N;
                }
                if (as.equals("NE")) {
                    a = Alignment.NE;
                }
                if (as.equals("CG")) {
                    a = Alignment.CG;
                }
                if (as.equals("CN")) {
                    a = Alignment.CN;
                }
                if (as.equals("CE")) {
                    a = Alignment.CE;
                }
                if (a != null) {
                    boolean doesRequirementExist = false;
                    if (!em.getClassAlignmentRequirementsByClassID(classid).isEmpty()) {
                        for (ClassAlignmentRequirement car : em.getClassAlignmentRequirementsByClassID(classid)) {
                            if (car.getAlignment() == a) {
                                doesRequirementExist = true;
                            }
                        }
                    }
                    if (!doesRequirementExist) {
                        em.addToDatabase(new ClassAlignmentRequirement(cclass, a));
                    }
                }
            }
        }
    }

    /**
     * Tarkistaa, onko syöte annettu ja onko se oikein, ja sitten lisää DeityRequirementit jos samaa ei jo ole.
     * @param classid
     * @param cclass
     * @param request 
     */
    private void addDeityRequirement(String classid, CClass cclass, HttpServletRequest request) {
        if (request.getParameter("deity") != null) {
            if (request.getParameter("deity").matches("[a-zA-Z0-9 _-]+") && cclass != null) {
                List<Deity> deitylist = em.getDeitiesByName(request.getParameter("deity"));
                if (!deitylist.isEmpty()) {
                    for (Deity d : deitylist) {
                        boolean doesRequirementExist = false;
                        if (!em.getClassDeityRequirementsByClassID(classid).isEmpty()) {
                            for (ClassDeityRequirement cdr : em.getClassDeityRequirementsByClassID(classid)) {
                                if (cdr.getDeity().getId() == d.getId()) {
                                    doesRequirementExist = true;
                                }
                            }
                        }
                        if (!doesRequirementExist) {
                            em.addToDatabase(new ClassDeityRequirement(cclass, d));
                        }
                    }
                }
            }
        }
    }

    /**
     * Tarkistaa, onko syöte annettu ja onko se oikein, ja sitten lisää RaceRequirementit jos samaa ei jo ole.
     * @param classid
     * @param cclass
     * @param request 
     */
    private void addRaceRequirement(String classid, CClass cclass, HttpServletRequest request) {
        if (request.getParameter("race") != null) {
            if (request.getParameter("race").matches("[a-zA-Z0-9 _-]+") && cclass != null) {
                List<Race> racelist = em.getRacesByName(request.getParameter("race"));
                if (!racelist.isEmpty()) {
                    for (Race r : racelist) {
                        boolean doesRequirementExist = false;
                        if (!em.getClassRaceRequirementsByClassID(classid).isEmpty()) {
                            for (ClassRaceRequirement crr : em.getClassRaceRequirementsByClassID(classid)) {
                                if (crr.getRace().getId() == r.getId()) {
                                    doesRequirementExist = true;
                                }
                            }
                        }
                        if (!doesRequirementExist) {
                            em.addToDatabase(new ClassRaceRequirement(cclass, r));
                        }
                    }
                }
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
