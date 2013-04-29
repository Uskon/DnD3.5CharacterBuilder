/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentManager;

import Components.ClassRequirement.ClassSkillRequirement;
import Components.ClassSkill;
import Components.FeatRequirements.FeatSkillRequirement;

/**
 * Apuluokka, jolla voidaan poistaa Skillejä tietokannasta.
 */
public class SkillRemover {

    private EM em = new EM();

    /**
     * Poistaa Skillin ja kaikki siihen viittaavat rivit tietokannasta.
     * @param skillid 
     */
    public void removeCompletely(String skillid) {
        this.removeClassSkills(skillid);
        this.removeClassSkillRequirements(skillid);
        this.removeFeatSkillRequirements(skillid);
        em.removeFromDatabase(em.getSkillByID(skillid), em.getSkillByID(skillid).getId());
    }

    /**
     * Poistaa kaikki Skilliin viittaavat ClassSkillit tietokannasta.
     * @param skillid 
     */
    public void removeClassSkills(String skillid) {
        if (!em.getClassSkillsBySkillID(skillid).isEmpty()) {
            for (ClassSkill cs : em.getClassSkillsBySkillID(skillid)) {
                em.removeFromDatabase(cs, cs.getId());
            }
        }
    }
    
    /**
     * Poistaa Feattien tähän Skilliin viittaavat SkillRequirementit tietokannasta.
     * @param skillid 
     */
    public void removeFeatSkillRequirements(String skillid) {
        if (!em.getFeatSkillRequirementsBySkillID(skillid).isEmpty()) {
            for (FeatSkillRequirement fsr : em.getFeatSkillRequirementsBySkillID(skillid)) {
                em.removeFromDatabase(fsr, fsr.getId());
            }
        }
    }
    
    /**
     * Poistaa CClassien tähän Skilliin viittaavat SkillRequirementit tietokannasta.
     * @param skillid 
     */
    public void removeClassSkillRequirements(String skillid) {
        if (!em.getClassSkillRequirementsBySkillID(skillid).isEmpty()) {
            for (ClassSkillRequirement csr : em.getClassSkillRequirementsBySkillID(skillid)) {
                em.removeFromDatabase(csr, csr.getId());
            }
        }
    }
}
