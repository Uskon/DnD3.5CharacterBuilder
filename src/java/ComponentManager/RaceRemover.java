/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentManager;

import Components.ClassRequirement.ClassRaceRequirement;
import Components.FeatRequirements.FeatRaceRequirement;
import Components.RacialFeat;

/**
 * Apuluokka, jolla voidaan poistaa Race ja kaikki siihen viittaavat rivit tietokannasta.
 * 
 */
public class RaceRemover {

    private EM em = new EM();

    /**
     * Poistaa Racen ja kaiken siihen viittaavan tietokannasta.
     * @param raceid 
     */
    public void removeCompletely(String raceid) {
        removeRaceDescription(raceid);
        this.removeClassRaceRequirements(raceid);
        this.removeFeatRaceRequirements(raceid);
        this.removeRacialFeats(raceid);
        em.removeFromDatabase(em.getRaceByID(raceid), em.getRaceByID(raceid).getId());
    }

    /**
     * Poistaa Racen RaceDescriptionin tietokannasta.
     * @param raceid 
     */
    public void removeRaceDescription(String raceid) {
        try {
            em.removeFromDatabase(em.getRaceDescriptionByRaceID(raceid), em.getRaceDescriptionByRaceID(raceid).getId());
        } catch (Exception e) {
        }
    }

    /**
     * Poistaa Feattien tähän Raceen viittaavat RaceRequirementit tietokannasta.
     * @param raceid 
     */
    public void removeFeatRaceRequirements(String raceid) {
        if (!em.getFeatRaceRequirementsByRaceID(raceid).isEmpty()) {
            for (FeatRaceRequirement frr : em.getFeatRaceRequirementsByRaceID(raceid)) {
                em.removeFromDatabase(frr, frr.getId());
            }
        }
    }

    /**
     * Poistaa CClassien tähän Raceen viittaavat RaceRequirementit tietokannasta.
     * @param raceid 
     */
    public void removeClassRaceRequirements(String raceid) {
        if (!em.getClassRaceRequirementsByRaceID(raceid).isEmpty()) {
            for (ClassRaceRequirement crr : em.getClassRaceRequirementsByRaceID(raceid)) {
                em.removeFromDatabase(crr, crr.getId());
            }
        }
    }

    /**
     * Poistaa Racen RacialFeatit tietokannasta.
     * @param raceid 
     */
    public void removeRacialFeats(String raceid) {
        if (!em.getRacialFeatsByRaceID(raceid).isEmpty()) {
            for(RacialFeat rf : em.getRacialFeatsByRaceID(raceid)) {
                em.removeFromDatabase(rf, rf.getId());
            }
        }
    }
}
