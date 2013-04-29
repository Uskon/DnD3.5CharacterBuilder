/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentManager;

import Components.ClassFeat;
import Components.ClassProgress;
import Components.ClassRequirement.ClassAlignmentRequirement;
import Components.ClassRequirement.ClassAttributeRequirement;
import Components.ClassRequirement.ClassCasterLevelRequirement;
import Components.ClassRequirement.ClassClassRequirement;
import Components.ClassRequirement.ClassDeityRequirement;
import Components.ClassRequirement.ClassFeatRequirement;
import Components.ClassRequirement.ClassRaceRequirement;
import Components.ClassRequirement.ClassSaveRequirement;
import Components.ClassRequirement.ClassSkillRequirement;
import Components.ClassRequirement.ClassSpellRequirement;
import Components.ClassSkill;
import Components.FeatRequirements.FeatCasterLevelRequirement;
import Components.FeatRequirements.FeatClassRequirement;
import Components.FeatRequirements.FeatSpellRequirement;

/**
 *  Sisältää toiminnot CClassin ilmentymien ja kaikkien niihin viittaavien muiden olioiden tietokannasta poistoon liittyvät toiminnot.
 * 
 */
public class ClassRemover {
    private EM em = new EM();

    /**
     * Poistaa annetun ID:n CClassin kaikkine yhteyksineen tietokannasta.
     * @param classid 
     */
    public void removeCompletely(String classid) {
        removeRequirements(classid);
        this.removeClassFeats(classid);
        this.removeClassDescription(classid);
        this.removeClassProgress(classid);
        this.removeClassSkills(classid);
        this.removeFeatCasterLevelRequirement(classid);
        this.removeFeatSpellRequirements(classid);
        this.removeFeatClassRequirements(classid);
        em.removeFromDatabase(em.getClassByID(classid), em.getClassByID(classid).getId());
    }
    
    /**
     * Poistaa kaikki CClassiin viittaavat Class*Requirement-ilmentymät tietokannasta.
     * @param classid 
     */
    public void removeRequirements(String classid) {
        this.removeAlignmentRequirements(classid);
        this.removeAttributeRequirements(classid);
        this.removeBABRequirement(classid);
        this.removeCasterLevelRequirement(classid);
        this.removeClassRequirements(classid);
        this.removeDeityRequirements(classid);
        this.removeFeatRequirements(classid);
        this.removeLevelRequirement(classid);
        this.removeRaceRequirements(classid);
        this.removeSaveRequirements(classid);
        this.removeSkillRequirements(classid);
        this.removeSpellRequirements(classid);
        this.removeClassCasterLevelRequirement(classid);
        this.removeClassClassRequirements(classid);
        this.removeClassSpellRequirements(classid);
    }

    /**
     * Poistaa CClassin AlignmentRequirementit tietokannasta.
     * @param classid 
     */
    public void removeAlignmentRequirements(String classid) {
        if (!em.getClassAlignmentRequirementsByClassID(classid).isEmpty()) {
            for (ClassAlignmentRequirement car : em.getClassAlignmentRequirementsByClassID(classid)) {
                em.removeFromDatabase(car, car.getId());
            }
        }
    }

    /**
     * Poistaa CClassin AttributeRequirementit tietokannasta.
     * @param classid 
     */
    public void removeAttributeRequirements(String classid) {
        if (!em.getClassAttributeRequirementsByClassID(classid).isEmpty()) {
            for (ClassAttributeRequirement car : em.getClassAttributeRequirementsByClassID(classid)) {
                em.removeFromDatabase(car, car.getId());
            }
        }
    }

    /**
     * Poistaa CClassin BABRequirementint tietokannasta.
     * @param classid 
     */
    public void removeBABRequirement(String classid) {
        try {
            em.removeFromDatabase(em.getClassBABRequirementByClassID(classid), em.getClassBABRequirementByClassID(classid).getId());
        } catch (Exception e) {
        }
    }

    /**
     * Poistaa CClassin CasterLevelRequirementit tietokannasta.
     * @param classid 
     */
    public void removeCasterLevelRequirement(String classid) {
        if (!em.getClassCasterLevelRequirementsByClassID(classid).isEmpty()) {
            for (ClassCasterLevelRequirement cclr : em.getClassCasterLevelRequirementsByClassID(classid)) {
                em.removeFromDatabase(cclr, cclr.getId());
            }
        }
    }
    
    /**
     * Poistaa muiden CClassien tähän CClassiin viittaavat CasterLevelRequirementit tietokannasta.
     * @param classid 
     */
    public void removeClassCasterLevelRequirement(String classid) {
        if (!em.getClassCasterLevelRequirementsByRequiredClassID(classid).isEmpty()) {
            for (ClassCasterLevelRequirement cclr : em.getClassCasterLevelRequirementsByRequiredClassID(classid)) {
                em.removeFromDatabase(cclr, cclr.getId());
            }
        }
    }
    
    /**
     * Poistaa Feattien tähän CClassiin viittaavat CasterLevelRequirementit tietokannasta.
     * @param classid 
     */
    public void removeFeatCasterLevelRequirement(String classid) {
        if (!em.getFeatCasterLevelRequirementsByClassID(classid).isEmpty()) {
            for (FeatCasterLevelRequirement fclr : em.getFeatCasterLevelRequirementsByClassID(classid)) {
                em.removeFromDatabase(fclr, fclr.getId());
            }
        }
    }

    /**
     * Poistaa kaikki CClassin ClassRequirementit tietokannasta.
     * @param classid 
     */
    public void removeClassRequirements(String classid) {
        if (!em.getClassClassRequirementsByClassID(classid).isEmpty()) {
            for (ClassClassRequirement ccr : em.getClassClassRequirementsByClassID(classid)) {
                em.removeFromDatabase(ccr, ccr.getId());
            }
        }
    }
    
    /**
     * Poistaa muiden CClassien tähän CClassiin viittaavat ClassRequirementit tietokannasta.
     * @param classid 
     */
    public void removeClassClassRequirements(String classid) {
        if (!em.getClassClassRequirementsByRequiredClassID(classid).isEmpty()) {
            for (ClassClassRequirement ccr : em.getClassClassRequirementsByRequiredClassID(classid)) {
                em.removeFromDatabase(ccr, ccr.getId());
            }
        }
    }
    
    /**
     * Poistaa Feattien tähän CClassiin viittaavat ClassRequirementit tietokannasta.
     * @param classid 
     */
    public void removeFeatClassRequirements(String classid) {
        if (!em.getFeatClassRequirementsByClassID(classid).isEmpty()) {
            for (FeatClassRequirement fcr : em.getFeatClassRequirementsByClassID(classid)) {
                em.removeFromDatabase(fcr, fcr.getId());
            }
        }
    }

    /**
     * Poistaa CClassin DeityRequirementit tietokannasta.
     * @param classid 
     */
    public void removeDeityRequirements(String classid) {
        if (!em.getClassDeityRequirementsByClassID(classid).isEmpty()) {
            for (ClassDeityRequirement cdr : em.getClassDeityRequirementsByClassID(classid)) {
                em.removeFromDatabase(cdr, cdr.getId());
            }
        }
    }

    /**
     * Poistaa CClassin FeatRequirementit tietokannasta.
     * @param classid 
     */
    public void removeFeatRequirements(String classid) {
        if (!em.getClassFeatRequirementsByClassID(classid).isEmpty()) {
            for (ClassFeatRequirement cfr : em.getClassFeatRequirementsByClassID(classid)) {
                em.removeFromDatabase(cfr, cfr.getId());
            }
        }
    }

    /**
     * Poistaa CClassin LevelRequirementin tietokannasta.
     * @param classid 
     */
    public void removeLevelRequirement(String classid) {
        try {
            em.removeFromDatabase(em.getClassLevelRequirementByClassID(classid), em.getClassLevelRequirementByClassID(classid).getId());
        } catch (Exception e) {
        }
    }

    /**
     * Poistaa CClassin RaceRequirementit tietokannasta.
     * @param classid 
     */
    public void removeRaceRequirements(String classid) {
        if (!em.getClassRaceRequirementsByClassID(classid).isEmpty()) {
            for (ClassRaceRequirement crr : em.getClassRaceRequirementsByClassID(classid)) {
                em.removeFromDatabase(crr, crr.getId());
            }
        }
    }

    /**
     * Poistaa CClassin SaveRequirementit tietokannasta.
     * @param classid 
     */
    public void removeSaveRequirements(String classid) {
        if (!em.getClassSaveRequirementsByClassID(classid).isEmpty()) {
            for (ClassSaveRequirement csr : em.getClassSaveRequirementsByClassID(classid)) {
                em.removeFromDatabase(csr, csr.getId());
            }
        }
    }

    /**
     * Poistaa CClassin SkillRequirementit tietokannasta.
     * @param classid 
     */
    public void removeSkillRequirements(String classid) {
        if (!em.getClassSkillRequirementsByClassID(classid).isEmpty()) {
            for (ClassSkillRequirement csr : em.getClassSkillRequirementsByClassID(classid)) {
                em.removeFromDatabase(csr, csr.getId());
            }
        }
    }

    /**
     * Poistaa CClassin SpellRequirementit tietokannasta.
     * @param classid 
     */
    public void removeSpellRequirements(String classid) {
        if (!em.getClassSpellRequirementsByClassID(classid).isEmpty()) {
            for (ClassSpellRequirement csr : em.getClassSpellRequirementsByClassID(classid)) {
                em.removeFromDatabase(csr, csr.getId());
            }
        }
    }
    
    /**
     * Poistaa muiden CClassien tähän CClasiin viittaavat SpellRequirementit tietokannasta.
     * @param classid 
     */
    public void removeClassSpellRequirements(String classid) {
        if (!em.getClassSpellRequirementsByRequiredClassID(classid).isEmpty()) {
            for (ClassSpellRequirement csr : em.getClassSpellRequirementsByRequiredClassID(classid)) {
                em.removeFromDatabase(csr, csr.getId());
            }
        }
    }
    
    /**
     * Poistaa Feattien tähän CClassiin viittaavat SpellRequirementit tietokannasta.
     * @param classid 
     */
    public void removeFeatSpellRequirements(String classid) {
        if (!em.getFeatSpellRequirementsByClassID(classid).isEmpty()) {
            for (FeatSpellRequirement fsr : em.getFeatSpellRequirementsByClassID(classid)) {
                em.removeFromDatabase(fsr, fsr.getId());
            }
        }
    }

    /**
     * Poistaa CClassin ClassFeatit tietokannasta.
     * @param classid 
     */
    public void removeClassFeats(String classid) {
        if (!em.getClassFeatsByClassID(classid).isEmpty()) {
            for (ClassFeat cf : em.getClassFeatsByClassID(classid)) {
                em.removeFromDatabase(cf, cf.getId());
            }
        }
    }

    /**
     * Poistaa CClassin ClassSkillit tietokannasta.
     * @param classid 
     */
    public void removeClassSkills(String classid) {
        if (!em.getClassSkillsByClassID(classid).isEmpty()) {
            for (ClassSkill cs : em.getClassSkillsByClassID(classid)) {
                em.removeFromDatabase(cs, cs.getId());
            }
        }
    }

    /**
     * Poistaa CClassin ClassDescriptionin tietokannasta.
     * @param classid 
     */
    public void removeClassDescription(String classid) {
        try {
            em.removeFromDatabase(em.getClassDescriptionByClassID(classid), em.getClassDescriptionByClassID(classid).getId());
        } catch (Exception e) {
        }
    }
    
    /**
     * Poistaa CClassin ClassProgressit tietokannasta.
     * @param classid 
     */
    public void removeClassProgress(String classid) {
        if (!em.getClassProgressByClassID(classid).isEmpty()) {
            for (ClassProgress cp : em.getClassProgressByClassID(classid)) {
                em.removeFromDatabase(cp, cp.getId());
            }
        }
    }
}
