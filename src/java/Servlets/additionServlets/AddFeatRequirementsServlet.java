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
import Components.ClassRequirement.ClassDeityRequirement;
import Components.ClassRequirement.ClassLevelRequirement;
import Components.ClassRequirement.ClassRaceRequirement;
import Components.ClassRequirement.ClassSaveRequirement;
import Components.ClassRequirement.ClassSpellRequirement;
import Components.Deity;
import Components.Feat;
import Components.FeatRequirements.FeatAlignmentRequirement;
import Components.FeatRequirements.FeatAttributeRequirement;
import Components.FeatRequirements.FeatBABRequirement;
import Components.FeatRequirements.FeatCasterLevelRequirement;
import Components.FeatRequirements.FeatClassRequirement;
import Components.FeatRequirements.FeatDeityRequirement;
import Components.FeatRequirements.FeatFeatRequirement;
import Components.FeatRequirements.FeatLevelRequirement;
import Components.FeatRequirements.FeatRaceRequirement;
import Components.FeatRequirements.FeatSaveRequirement;
import Components.FeatRequirements.FeatSkillRequirement;
import Components.FeatRequirements.FeatSpellRequirement;
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
 * Tarkistaa syötteet ja hoitaa erilaisten FeatRequirementtien lisäystapahtumat.
 * @author Uskon
 */
public class AddFeatRequirementsServlet extends HttpServlet {

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
        request.setAttribute("feat", session.getAttribute("managedFeat"));
        String featid = (String) session.getAttribute("managedFeat");
        session.removeAttribute("managedFeat");
        Feat feat = em.getFeatByID(featid);
        request.setAttribute("feat", feat);

        addClassRequirement(featid, feat, request);
        addFeatRequirement(featid, feat, request);
        addSkillRequirement(featid, feat, request);
        addBABRequirement(featid, feat, request);
        addCasterLevelRequirement(featid, feat, request);
        addSpellRequirement(featid, feat, request);
        addAttributeRequirement(featid, feat, request);
        addSaveRequirement(featid, feat, request);
        addAlignmentRequirement(featid, feat, request);
        addDeityRequirement(featid, feat, request);
        addLevelRequirement(featid, feat, request);
        addRaceRequirement(featid, feat, request);


        if (feat != null) {
            setRequestAttributes(request, feat);
            setRequestListAttributes(request, featid);
        }
        session.setAttribute("managedFeat", featid);
        request.getRequestDispatcher("/AddFeatRequirements.jsp").forward(request, response);
    }

    /**
     * Asettaa jsp:lle hyödynnettäväksi Featin boolean-parametrejä.
     *
     * @param request
     */
    private void setRequestAttributes(HttpServletRequest request, Feat feat) {
        if (feat.isClassRequired()) {
            request.setAttribute("classrequired", true);
        }
        if (feat.isFeatRequired()) {
            request.setAttribute("featrequired", true);
        }
        if (feat.isSkillRequired()) {
            request.setAttribute("skillrequired", true);
        }
        if (feat.isBABRequired()) {
            request.setAttribute("babrequired", true);
        }
        if (feat.isCasterLevelRequired()) {
            request.setAttribute("casterrequired", true);
        }
        if (feat.isSpellLevelRequired()) {
            request.setAttribute("spellrequired", true);
        }
        if (feat.isAttributeRequired()) {
            request.setAttribute("attributerequired", true);
        }
        if (feat.isSaveRequired()) {
            request.setAttribute("saverequired", true);
        }
        if (feat.isAlignmentRequired()) {
            request.setAttribute("alignmentrequired", true);
        }
        if (feat.isDeityRequired()) {
            request.setAttribute("deityrequired", true);
        }
        if (feat.isRaceRequired()) {
            request.setAttribute("racerequired", true);
        }
        if (feat.isLevelRequired()) {
            request.setAttribute("levelrequired", true);
        }
        if (!(feat.isAlignmentRequired() || feat.isAttributeRequired() || feat.isBABRequired() || feat.isCasterLevelRequired() || feat.isClassRequired() || feat.isDeityRequired() || feat.isFeatRequired() || feat.isLevelRequired() || feat.isRaceRequired() || feat.isSaveRequired() || feat.isSkillRequired() || feat.isSpellLevelRequired())) {
            request.setAttribute("noreqs", true);
        }

    }

    /**
     * Asettaa jsp:n käyttöön erilaisia oliolistoja, jos ne eivät ole tyhjiä.
     *
     * @param request
     * @param cclass
     */
    public void setRequestListAttributes(HttpServletRequest request, String featid) {
        if (!em.getFeatClassRequirementsByFeatID(featid).isEmpty()) {
            request.setAttribute("classlist", em.getFeatClassRequirementsByFeatID(featid));
        }
        if (!em.getFeatFeatRequirementsByFeatID(featid).isEmpty()) {
            request.setAttribute("featlist", em.getFeatFeatRequirementsByFeatID(featid));
        }
        if (!em.getFeatSkillRequirementsByFeatID(featid).isEmpty()) {
            request.setAttribute("skilllist", em.getFeatSkillRequirementsByFeatID(featid));
        }

        FeatBABRequirement fbr = null;
        try {
            fbr = em.getFeatBABRequirementByFeatID(featid);
        } catch (Exception e) {
        }
        if (fbr != null) {
            request.setAttribute("bab", fbr);
        }

        if (!em.getFeatCasterLevelRequirementsByFeatID(featid).isEmpty()) {
            request.setAttribute("casterlist", em.getFeatCasterLevelRequirementsByFeatID(featid));
        }
        if (!em.getFeatSpellRequirementsByFeatID(featid).isEmpty()) {
            request.setAttribute("spelllist", em.getFeatSpellRequirementsByFeatID(featid));
        }
        if (!em.getFeatAttributeRequirementsByFeatID(featid).isEmpty()) {
            request.setAttribute("attributelist", em.getFeatAttributeRequirementsByFeatID(featid));
        }
        if (!em.getFeatSaveRequirementsByFeatID(featid).isEmpty()) {
            request.setAttribute("savelist", em.getFeatSaveRequirementsByFeatID(featid));
        }

        FeatLevelRequirement flr = null;
        try {
            flr = em.getFeatLevelRequirementByFeatID(featid);
        } catch (Exception e) {
        }
        if (flr != null) {
            request.setAttribute("level", flr);
        }

        if (!em.getFeatAlignmentRequirementsByFeatID(featid).isEmpty()) {
            request.setAttribute("alignmentlist", em.getFeatAlignmentRequirementsByFeatID(featid));
        }
        if (!em.getFeatDeityRequirementsByFeatID(featid).isEmpty()) {
            request.setAttribute("deitylist", em.getFeatDeityRequirementsByFeatID(featid));
        }
        if (!em.getFeatRaceRequirementsByFeatID(featid).isEmpty()) {
            request.setAttribute("racelist", em.getFeatRaceRequirementsByFeatID(featid));
        }
    }

    /**
     * Tarkistaa onko FeatClassRequirementin syöte laitettu ja onko se oikein,
     * ja sitten yrittää luodat uudet oliot.
     *
     * @param featid
     * @param feat
     * @param request
     */
    private void addClassRequirement(String featid, Feat feat, HttpServletRequest request) {
        if (request.getParameter("classreq") != null && request.getParameter("classlvl") != null) {
            if (request.getParameter("classreq").matches("[a-zA-Z0-9 _-]+") && request.getParameter("classlvl").matches("[0-9]{1,2}") && feat != null) {
                List<CClass> classlist = em.getClassesByName(request.getParameter("classreq"));
                int lvl = Integer.parseInt(request.getParameter("classlvl"));
                if (!classlist.isEmpty()) {
                    for (CClass c : classlist) {
                        boolean doesRequirementExist = false;
                        if (!em.getFeatClassRequirementsByFeatID(featid).isEmpty()) {
                            for (FeatClassRequirement fcr : em.getFeatClassRequirementsByFeatID(featid)) {
                                if (fcr.getRequiredClass().getId() == c.getId()) {
                                    doesRequirementExist = true;
                                }
                            }
                        }
                        if (!doesRequirementExist) {
                            em.addToDatabase(new FeatClassRequirement(feat, c, lvl));
                        }
                    }
                }
            }
        }
    }

    /**
     * Tarkistaa onko syötettä annettua ja onko se oikein, ja sitten yrittää
     * luoda uusia FeatFeatRequirementteja jos niitä ei ole jo olemassa.
     *
     * @param featid
     * @param feat
     * @param request
     */
    private void addFeatRequirement(String featid, Feat feat, HttpServletRequest request) {
        if (request.getParameter("feat") != null) {
            if (request.getParameter("feat").matches("[a-zA-Z0-9 _-]+") && feat != null) {
                List<Feat> featlist = em.getFeatsByName(request.getParameter("feat"));
                if (!featlist.isEmpty()) {
                    for (Feat f : featlist) {
                        boolean doesRequirementExist = false;
                        if (!em.getFeatFeatRequirementsByFeatID(featid).isEmpty()) {
                            for (FeatFeatRequirement ffr : em.getFeatFeatRequirementsByFeatID(featid)) {
                                if (ffr.getRequiredFeat().getId() == f.getId()) {
                                    doesRequirementExist = true;
                                }
                            }
                        }
                        if (!doesRequirementExist && !f.getName().equals(feat.getName())) {
                            em.addToDatabase(new FeatFeatRequirement(feat, f));
                        }
                    }
                }
            }
        }
    }

    /**
     * Tarkistaa onko syötettä annettua ja onko se oikein, ja sitten yrittää
     * luoda uusia FeatSkillRequirementteja jos niitä ei ole jo olemassa.
     *
     * @param featid
     * @param feat
     * @param request
     */
    private void addSkillRequirement(String featid, Feat feat, HttpServletRequest request) {
        if (request.getParameter("skill") != null && request.getParameter("skillrank") != null) {
            if (request.getParameter("skill").matches("[a-zA-Z0-9 _-]+") && request.getParameter("skillrank").matches("[0-9]{1,2}") && feat != null) {
                List<Skill> skilllist = em.getSkillsByName(request.getParameter("skill"));
                int lvl = Integer.parseInt(request.getParameter("skillrank"));
                if (!skilllist.isEmpty()) {
                    for (Skill s : skilllist) {
                        boolean doesRequirementExist = false;
                        if (!em.getFeatSkillRequirementsByFeatID(featid).isEmpty()) {
                            for (FeatSkillRequirement fsr : em.getFeatSkillRequirementsByFeatID(featid)) {
                                if (fsr.getSkill().getId() == s.getId()) {
                                    doesRequirementExist = true;
                                }
                            }
                        }
                        if (!doesRequirementExist) {
                            em.addToDatabase(new FeatSkillRequirement(feat, s, lvl));
                        }
                    }
                }
            }
        }
    }

    /**
     * Tarkistaa, onko syötettä annettu ja onko se oikein, ja sitten yrittää
     * luoda uuden FeatBABRequirementin jos sellaista ei jo Featilla ole.
     *
     * @param featid
     * @param feat
     * @param request
     */
    private void addBABRequirement(String featid, Feat feat, HttpServletRequest request) {
        if (request.getParameter("bab") != null) {
            if (request.getParameter("bab").matches("[0-9]{1,2}") && feat != null) {
                int bab = Integer.parseInt(request.getParameter("bab"));
                boolean doesRequirementExist = false;
                FeatBABRequirement babreq = null;
                try {
                    babreq = em.getFeatBABRequirementByFeatID(featid);
                } catch (Exception e) {
                }
                if (babreq != null) {
                    doesRequirementExist = true;
                }
                if (!doesRequirementExist) {
                    em.addToDatabase(new FeatBABRequirement(feat, bab));
                }
            }
        }
    }

    /**
     * Tarkistaa onko syötettä annettu ja onko se oikein, ja sitten yrittää
     * luoda uudet FeatCasterLevelRequirementit jos niitä ei ole jo olemassa.
     *
     * @param featid
     * @param feat
     * @param request
     */
    private void addCasterLevelRequirement(String featid, Feat feat, HttpServletRequest request) {
        if (request.getParameter("casterclass") != null && request.getParameter("casterlevel") != null) {
            if (request.getParameter("casterclass").matches("[a-zA-Z0-9 _-]+") && request.getParameter("casterlevel").matches("[0-9]{1,2}") && feat != null) {
                List<CClass> classlist = em.getClassesByName(request.getParameter("casterclass"));
                int lvl = Integer.parseInt(request.getParameter("casterlevel"));
                if (!classlist.isEmpty()) {
                    for (CClass c : classlist) {
                        boolean doesRequirementExist = false;
                        if (!em.getFeatCasterLevelRequirementsByFeatID(featid).isEmpty()) {
                            for (FeatCasterLevelRequirement fclr : em.getFeatCasterLevelRequirementsByFeatID(featid)) {
                                if (fclr.getCclass().getId() == c.getId()) {
                                    doesRequirementExist = true;
                                }
                            }
                        }
                        if (!doesRequirementExist) {
                            em.addToDatabase(new FeatCasterLevelRequirement(feat, c, lvl));
                        }
                    }
                }
            }
        }
    }

    /**
     * Tarkistaa onko syötettä annettu ja onko se oikein, ja sitten yrittää
     * luoda uudet FeatSpellRequirementit jos niitä ei ole jo olemassa.
     *
     * @param featid
     * @param feat
     * @param request
     */
    private void addSpellRequirement(String featid, Feat feat, HttpServletRequest request) {
        if (request.getParameter("spellclass") != null && request.getParameter("spelllevel") != null) {
            if (request.getParameter("spellclass").matches("[a-zA-Z0-9 _-]+") && request.getParameter("spelllevel").matches("[0-9]{1,2}") && feat != null) {
                List<CClass> classlist = em.getClassesByName(request.getParameter("spellclass"));
                int lvl = Integer.parseInt(request.getParameter("spelllevel"));
                if (!classlist.isEmpty()) {
                    for (CClass c : classlist) {
                        boolean doesRequirementExist = false;
                        if (!em.getFeatSpellRequirementsByFeatID(featid).isEmpty()) {
                            for (FeatSpellRequirement fsr : em.getFeatSpellRequirementsByFeatID(featid)) {
                                if (fsr.getCclass().getId() == c.getId()) {
                                    doesRequirementExist = true;
                                }
                            }
                        }
                        if (!doesRequirementExist) {
                            em.addToDatabase(new FeatSpellRequirement(feat, c, lvl));
                        }
                    }
                }
            }
        }
    }

    /**
     * Tarkistaa onko syötettä annettu ja onko se oikein, ja sitten yrittää
     * luoda uuden FeatAttributeRequirementin jos sitä ei ole jo olemassa.
     *
     * @param featid
     * @param feat
     * @param request
     */
    private void addAttributeRequirement(String featid, Feat feat, HttpServletRequest request) {
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
        if (!em.getFeatAttributeRequirementsByFeatID(featid).isEmpty()) {
            for (FeatAttributeRequirement far : em.getFeatAttributeRequirementsByFeatID(featid)) {
                if (far.getSTR() == str && far.getDEX() == dex && far.getCON() == con && far.getINT() == in && far.getWIS() == wis && far.getCHA() == cha) {
                    doesRequirementExist = true;
                }
            }
        }
        if (!doesRequirementExist && (str != 0 || dex != 0 || con != 0 || in != 0 || wis != 0 || cha != 0)) {
            em.addToDatabase(new FeatAttributeRequirement(feat, str, dex, con, in, wis, cha));
        }
    }

    /**
     * Tarkistaa onko syötettä annettu ja onko se oikein, ja sitten yrittää
     * luoda uuden FeatSaveRequirementit jos samaa ei ole jo olemassa.
     *
     * @param featid
     * @param feat
     * @param request
     */
    private void addSaveRequirement(String featid, Feat feat, HttpServletRequest request) {
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
        if (!em.getFeatSaveRequirementsByFeatID(featid).isEmpty()) {
            for (FeatSaveRequirement fsr : em.getFeatSaveRequirementsByFeatID(featid)) {
                if (fsr.getFortSave() == fort && fsr.getReflSave() == refl && fsr.getWillSave() == will) {
                    doesRequirementExist = true;
                }
            }
        }
        if (!doesRequirementExist && (fort != 0 || refl != 0 || will != 0)) {
            em.addToDatabase(new FeatSaveRequirement(feat, fort, will, refl));
        }
    }

    /**
     * Tarkistaa onko syötettä annettu ja onko se oikein, ja sitten yrittää
     * luoda uuden FeatLevelRequirementin jos sellaista ei ole olemassa.
     *
     * @param featid
     * @param feat
     * @param request
     */
    private void addLevelRequirement(String featid, Feat feat, HttpServletRequest request) {
        int level = 0;
        try {
            level = Integer.parseInt(request.getParameter("charlvl"));
        } catch (Exception e) {
        }
        boolean doesRequirementExist = false;
        FeatLevelRequirement lvlreq = null;
        try {
            lvlreq = em.getFeatLevelRequirementByFeatID(featid);
        } catch (Exception e) {
        }
        if (lvlreq != null) {
            doesRequirementExist = true;
        }
        if (!doesRequirementExist && level != 0) {
            em.addToDatabase(new FeatLevelRequirement(feat, level));
        }
    }

    /**
     * Tarkistaa onko syötettä annettu ja onko se oikein, ja yrittää lisätä
     * uuden FeatAlignmentRequirementin jos samaa ei ole jo olemassa.
     *
     * @param featid
     * @param feat
     * @param request
     */
    public void addAlignmentRequirement(String featid, Feat feat, HttpServletRequest request) {
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
                    if (!em.getFeatAlignmentRequirementsByFeatID(featid).isEmpty()) {
                        for (FeatAlignmentRequirement far : em.getFeatAlignmentRequirementsByFeatID(featid)) {
                            if (far.getAlignment() == a) {
                                doesRequirementExist = true;
                            }
                        }
                    }
                    if (!doesRequirementExist) {
                        em.addToDatabase(new FeatAlignmentRequirement(feat, a));
                    }
                }
            }
        }
    }

    /**
     * Tarkistaa onko syöte annettu ja onko se oikein, ja yrittää lisätä uuden
     * FeatDeityRequirementin jos samaa ei jo ole.
     *
     * @param featid
     * @param feat
     * @param request
     */
    private void addDeityRequirement(String featid, Feat feat, HttpServletRequest request) {
        if (request.getParameter("deity") != null) {
            if (request.getParameter("deity").matches("[a-zA-Z0-9 _-]+") && feat != null) {
                List<Deity> deitylist = em.getDeitiesByName(request.getParameter("deity"));
                if (!deitylist.isEmpty()) {
                    for (Deity d : deitylist) {
                        boolean doesRequirementExist = false;
                        if (!em.getFeatDeityRequirementsByFeatID(featid).isEmpty()) {
                            for (FeatDeityRequirement fdr : em.getFeatDeityRequirementsByFeatID(featid)) {
                                if (fdr.getDeity().getId() == d.getId()) {
                                    doesRequirementExist = true;
                                }
                            }
                        }
                        if (!doesRequirementExist) {
                            em.addToDatabase(new FeatDeityRequirement(feat, d));
                        }
                    }
                }
            }
        }
    }

    /**
     * Tarkistaa onko syöte annettu ja onko se oikein, ja yrittää sitten lisätä
     * uuden FeatRaceRequirementin jos samaa ei jo ole.
     *
     * @param featid
     * @param feat
     * @param request
     */
    private void addRaceRequirement(String featid, Feat feat, HttpServletRequest request) {
        if (request.getParameter("race") != null) {
            if (request.getParameter("race").matches("[a-zA-Z0-9 _-]+") && feat != null) {
                List<Race> racelist = em.getRacesByName(request.getParameter("race"));
                if (!racelist.isEmpty()) {
                    for (Race r : racelist) {
                        boolean doesRequirementExist = false;
                        if (!em.getFeatRaceRequirementsByFeatID(featid).isEmpty()) {
                            for (FeatRaceRequirement frr : em.getFeatRaceRequirementsByFeatID(featid)) {
                                if (frr.getRace().getId() == r.getId()) {
                                    doesRequirementExist = true;
                                }
                            }
                        }
                        if (!doesRequirementExist) {
                            em.addToDatabase(new FeatRaceRequirement(feat, r));
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
