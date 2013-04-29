/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentManager;

import Components.ClassRequirement.ClassDeityRequirement;
import Components.DeityDomain;
import Components.FeatRequirements.FeatDeityRequirement;

/**
 * Apuluokka, joka voi poistaa Deityn ja kaikki siihen viittaavat muiden taulujen rivit tietokannasta. 
 * 
 */
public class DeityRemover {
    private EM em = new EM();
    
    /**
     * Poistaa Deityn ja kaiken siihen viittaavan tietokannasta.
     * @param deityid 
     */
    public void removeCompletely(String deityid) {
        removeDomains(deityid);
        this.removeClassDeityRequirements(deityid);
        this.removeFeatDeityRequirements(deityid);
        em.removeFromDatabase(em.getDeityByID(deityid), em.getDeityByID(deityid).getId());
    }
    
    /**
     * Poistaa Deityn DeityDomainit tietokannasta.
     * @param deityid 
     */
    public void removeDomains(String deityid) {
    if (!em.getDeityDomainsByDeityID(deityid).isEmpty()) {
            for (DeityDomain dd : em.getDeityDomainsByDeityID(deityid)) {
                em.removeFromDatabase(dd, dd.getId());
            }
        }
    }
    
    /**
     * Poistaa CClassien tähän Deityyn viittaavat DeityRequirementit tietokannasta.
     * @param deityid 
     */
    public void removeClassDeityRequirements(String deityid) {
        if (!em.getClassDeityRequirementsByDeityID(deityid).isEmpty()) {
            for (ClassDeityRequirement cdr : em.getClassDeityRequirementsByDeityID(deityid)) {
                em.removeFromDatabase(cdr, cdr.getId());
            }
        }
    }
    
    /**
     * Poistaa Feattien tähän Deityyn viittaavat DeityRequirementit tietokannasta.
     * @param deityid 
     */
    public void removeFeatDeityRequirements(String deityid) {
        if (!em.getFeatDeityRequirementsByDeityID(deityid).isEmpty()) {
            for (FeatDeityRequirement fdr : em.getFeatDeityRequirementsByDeityID(deityid)) {
                em.removeFromDatabase(fdr, fdr.getId());
            }
        }
    }
    
    
}
