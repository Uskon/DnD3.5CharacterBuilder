/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentManager;

import Components.DeityDomain;
import Components.DomainFeat;

/**
 * Apuluokka, joka voi poistaa DDomainin sekä kaikki siihen viittaavat muiden taulujen rivit.
 * 
 */
public class DomainRemover {
    private EM em = new EM();
    
    /**
     * Poistaa DDomainin ja kaikki siihen viittaavat rivit.
     * @param domainid 
     */
    public void removeCompletely(String domainid) {
            removeDomainFeats(domainid);
            removeDeityDomains(domainid);
            em.removeFromDatabase(em.getDomainByID(domainid), em.getDomainByID(domainid).getId());
    }
    
    /**
     * Poistaa kaikki DDomainin DomainFeatit tietokannasta.
     * @param domainid 
     */
    public void removeDomainFeats(String domainid) {
        if (!em.getDomainFeatsByDomainID(domainid).isEmpty()) {
            for (DomainFeat df : em.getDomainFeatsByDomainID(domainid)) {
                em.removeFromDatabase(df, df.getId());
            }
        }
    }
    
    /**
     * Poistaa Deityjen tähän DDomainiin viittaavat DeityDomainit tietokannasta.
     * @param domainid 
     */
    public void removeDeityDomains(String domainid) {
        if (!em.getDeityDomainsByDomainID(domainid).isEmpty()) {
            for (DeityDomain dd : em.getDeityDomainsByDomainID(domainid)) {
                em.removeFromDatabase(dd, dd.getId());
            }
        }
    }
}
