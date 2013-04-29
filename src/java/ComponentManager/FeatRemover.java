/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentManager;

import Components.ClassFeat;
import Components.ClassRequirement.ClassFeatRequirement;
import Components.DomainFeat;
import Components.FeatRequirements.FeatAlignmentRequirement;
import Components.FeatRequirements.FeatAttributeRequirement;
import Components.FeatRequirements.FeatCasterLevelRequirement;
import Components.FeatRequirements.FeatClassRequirement;
import Components.FeatRequirements.FeatDeityRequirement;
import Components.FeatRequirements.FeatFeatRequirement;
import Components.FeatRequirements.FeatRaceRequirement;
import Components.FeatRequirements.FeatSaveRequirement;
import Components.FeatRequirements.FeatSkillRequirement;
import Components.FeatRequirements.FeatSpellRequirement;
import Components.RacialFeat;

/**
 *  Sisältää toiminnot Feat-luokan ilmentymien ja kaikkien niihin viittaavien olioiden poistamiseen liittyvät toiminnot.
 * 
 */
public class FeatRemover {
    private EM em = new EM();

    /**
     * Poistaa Featin sekä kaikki siihen viittaavat rivit.
     * @param featid 
     */
    public void removeCompletely(String featid) {
        removeRequirements(featid);
        removeDomainFeats(featid);
        removeFeatDescription(featid);
        removeClassFeats(featid);
        removeClassFeatRequirements(featid);
        removeRacialFeats(featid);
        em.removeFromDatabase(em.getFeatByID(featid), em.getFeatByID(featid).getId());
    }
    
    /**
     * Poistaa kaikki Featin Requirementit.
     * @param featid 
     */
    public void removeRequirements(String featid) {
        this.removeAlignmentRequirements(featid);
        this.removeAttributeRequirements(featid);
        this.removeBABRequirement(featid);
        this.removeCasterLevelRequirement(featid);
        this.removeFeatRequirements(featid);
        this.removeDeityRequirements(featid);
        this.removeFeatRequirements(featid);
        this.removeLevelRequirement(featid);
        this.removeRaceRequirements(featid);
        this.removeSaveRequirements(featid);
        this.removeSkillRequirements(featid);
        this.removeSpellRequirements(featid);
    }

    /**
     * Poistaa Featin AlignmentRequirementit tietokannasta.
     * @param featid 
     */
    public void removeAlignmentRequirements(String featid) {
        if (!em.getFeatAlignmentRequirementsByFeatID(featid).isEmpty()) {
            for (FeatAlignmentRequirement far : em.getFeatAlignmentRequirementsByFeatID(featid)) {
                em.removeFromDatabase(far, far.getId());
            }
        }
    }

    /**
     * Poistaa Featin AttributeRequirementit tietokannasta.
     * @param featid 
     */
    public void removeAttributeRequirements(String featid) {
        if (!em.getFeatAttributeRequirementsByFeatID(featid).isEmpty()) {
            for (FeatAttributeRequirement car : em.getFeatAttributeRequirementsByFeatID(featid)) {
                em.removeFromDatabase(car, car.getId());
            }
        }
    }

    /**
     * Poistaa Featin BABRequirementin tietokannasta.
     * @param featid 
     */
    public void removeBABRequirement(String featid) {
        try {
            em.removeFromDatabase(em.getFeatBABRequirementByFeatID(featid), em.getFeatBABRequirementByFeatID(featid).getId());
        } catch (Exception e) {
        }
    }

    /**
     * Poistaa Featin CasterLevelRequirementit tietokannasta.
     * @param featid 
     */
    public void removeCasterLevelRequirement(String featid) {
        if (!em.getFeatCasterLevelRequirementsByFeatID(featid).isEmpty()) {
            for (FeatCasterLevelRequirement cclr : em.getFeatCasterLevelRequirementsByFeatID(featid)) {
                em.removeFromDatabase(cclr, cclr.getId());
            }
        }
    }

    /**
     * Poistaa Featin FeatRequirementit tietokannasta.
     * @param featid 
     */
    public void removeFeatRequirements(String featid) {
        if (!em.getFeatFeatRequirementsByFeatID(featid).isEmpty()) {
            for (FeatFeatRequirement ccr : em.getFeatFeatRequirementsByFeatID(featid)) {
                em.removeFromDatabase(ccr, ccr.getId());
            }
        }
    }

    /**
     * Poistaa Featin DeityRequirementit tietokannasta.
     * @param featid 
     */
    public void removeDeityRequirements(String featid) {
        if (!em.getFeatDeityRequirementsByFeatID(featid).isEmpty()) {
            for (FeatDeityRequirement cdr : em.getFeatDeityRequirementsByFeatID(featid)) {
                em.removeFromDatabase(cdr, cdr.getId());
            }
        }
    }

    /**
     * Poistaa Featin ClassRequirementit tietokannasta.
     * @param featid 
     */
    public void removeClassRequirements(String featid) {
        if (!em.getFeatClassRequirementsByFeatID(featid).isEmpty()) {
            for (FeatClassRequirement cfr : em.getFeatClassRequirementsByFeatID(featid)) {
                em.removeFromDatabase(cfr, cfr.getId());
            }
        }
    }
    
    /**
     * Poistaa CClassien tähän Feattiin viittaavat FeatRequirementit tietokannasta.
     * @param featid 
     */
    public void removeClassFeatRequirements(String featid) {
        if (!em.getClassFeatRequirementsByFeatID(featid).isEmpty()) {
            for (ClassFeatRequirement fcr : em.getClassFeatRequirementsByFeatID(featid)) {
                em.removeFromDatabase(fcr, fcr.getId());
            }
        }
    }

    /**
     * Poistaa Featin LevelRequirementin tietokannasta.
     * @param featid 
     */
    public void removeLevelRequirement(String featid) {
        try {
            em.removeFromDatabase(em.getFeatLevelRequirementByFeatID(featid), em.getFeatLevelRequirementByFeatID(featid).getId());
        } catch (Exception e) {
        }
    }

    /**
     * Poistaa Featin RaceRequirementit tietokannasta.
     * @param featid 
     */
    public void removeRaceRequirements(String featid) {
        if (!em.getFeatRaceRequirementsByFeatID(featid).isEmpty()) {
            for (FeatRaceRequirement crr : em.getFeatRaceRequirementsByFeatID(featid)) {
                em.removeFromDatabase(crr, crr.getId());
            }
        }
    }

    /**
     * Poistaa Featin SaveRequirementit tietokannasta.
     * @param featid 
     */
    public void removeSaveRequirements(String featid) {
        if (!em.getFeatSaveRequirementsByFeatID(featid).isEmpty()) {
            for (FeatSaveRequirement csr : em.getFeatSaveRequirementsByFeatID(featid)) {
                em.removeFromDatabase(csr, csr.getId());
            }
        }
    }

    /**
     * Poistaa Featin SkillRequirementit tietokannasta.
     * @param featid 
     */
    public void removeSkillRequirements(String featid) {
        if (!em.getFeatSkillRequirementsByFeatID(featid).isEmpty()) {
            for (FeatSkillRequirement csr : em.getFeatSkillRequirementsByFeatID(featid)) {
                em.removeFromDatabase(csr, csr.getId());
            }
        }
    }

    /**
     * Poistaa Featin SpellRequirementit tietokannasta.
     * @param featid 
     */
    public void removeSpellRequirements(String featid) {
        if (!em.getFeatSpellRequirementsByFeatID(featid).isEmpty()) {
            for (FeatSpellRequirement csr : em.getFeatSpellRequirementsByFeatID(featid)) {
                em.removeFromDatabase(csr, csr.getId());
            }
        }
    }
    
    /**
     * Poistaa DomainFeatit jotka viittaavat tähän Feattiin tietokannasta.
     * @param featid 
     */
    public void removeDomainFeats(String featid) {
        if (!em.getDomainFeatsByFeatID(featid).isEmpty()) {
            for (DomainFeat df : em.getDomainFeatsByFeatID(featid)) {
                em.removeFromDatabase(df, df.getId());
            }
        }
    }
    
    /**
     * Poistaa Featin FeatDescriptioniin tietokannasta.
     * @param featid 
     */
    public void removeFeatDescription(String featid) {
        try {
            em.removeFromDatabase(em.getFeatDescriptionByFeatID(featid), em.getFeatDescriptionByFeatID(featid).getId());
        }   catch (Exception e) {}
    } 

    /**
     * Poistaa tähän Feattiin viittaavat ClassFeatit tietokannasta.
     * @param featid 
     */
    public void removeClassFeats(String featid) {
        if (!em.getClassFeatsByFeatID(featid).isEmpty()) {
            for (ClassFeat cf : em.getClassFeatsByFeatID(featid)) {
                em.removeFromDatabase(cf, cf.getId());
            }
        }
    }
    
    /**
     * Poistaa tähän Feattiin viittaavat RacialFeatit tietokannasta.
     * @param featid 
     */
    public void removeRacialFeats(String featid) {
        if (!em.getRacialFeatsByFeatID(featid).isEmpty()) {
            for (RacialFeat rf : em.getRacialFeatsByFeatID(featid)) {
                em.removeFromDatabase(rf, rf.getId());
            }
        }
    }
}
