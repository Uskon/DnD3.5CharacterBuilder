/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentManager;

import Components.CClass;
import Components.DDomain;
import Components.Deity;
import Components.Feat;
import Components.Race;
import Components.Skill;

/**
 * Apuluokka, joka poistaa kokonaisia RuleSettejä tietokannasta.
 * 
 */
public class RuleSetRemover {

    private EM em = new EM();
    private ClassRemover classr = new ClassRemover();
    private FeatRemover featr = new FeatRemover();
    private SkillRemover skillr = new SkillRemover();
    private DeityRemover deityr = new DeityRemover();
    private DomainRemover domainr = new DomainRemover();
    private RaceRemover racer = new RaceRemover();

    /**
     * Poistaa RuleSetin ja aivan kaikki siitä riippuvaiset rivit tietokannasta.
     * @param rulesetname 
     */
    public void removeRuleSetCompletely(String rulesetname) {
        this.removeClasses(rulesetname);
        this.removeDeities(rulesetname);
        this.removeDomains(rulesetname);
        this.removeFeats(rulesetname);
        this.removeRaces(rulesetname);
        this.removeSkills(rulesetname);
        em.removeRuleSetFromDatabase(em.getRuleSetByName(rulesetname), em.getRuleSetByName(rulesetname).getName());
    }

    /**
     * Poistaa RuleSetistä riippuvaiset CClassit yhteyksineen tietokannasta.
     * @param rulesetname 
     */
    public void removeClasses(String rulesetname) {
        if (!em.getClassesByRuleSet(rulesetname).isEmpty()) {
            for (CClass c : em.getClassesByRuleSet(rulesetname)) {
                classr.removeCompletely("" + c.getId());
            }
        }
    }

    /**
     * Poistaa RuleSetistä riippuvaiset Featit yhteyksineen tietokannasta.
     * @param rulesetname 
     */
    public void removeFeats(String rulesetname) {
        if (!em.getFeatsByRuleSet(rulesetname).isEmpty()) {
            for (Feat f : em.getFeatsByRuleSet(rulesetname)) {
                featr.removeCompletely("" + f.getId());
            }
        }
    }

    /**
     * Poistaa RuleSetistä riippuvaiset Racet yhteyksineen tietokannasta.
     * @param rulesetname 
     */
    public void removeRaces(String rulesetname) {
        if (!em.getRacesByRuleSet(rulesetname).isEmpty()) {
            for (Race r : em.getRacesByRuleSet(rulesetname)) {
                racer.removeCompletely("" + r.getId());
            }
        }
    }

    /**
     * Poistaa RuleSetistä riippuvaiset Skillit yhteyksineen tietokannasta.
     * @param rulesetname 
     */
    public void removeSkills(String rulesetname) {
        if (!em.getSkillsByRuleSet(rulesetname).isEmpty()) {
            for (Skill s : em.getSkillsByRuleSet(rulesetname)) {
                skillr.removeCompletely("" + s.getId());
            }
        }
    }

    /**
     * Poistaa RuleSetistä riippuvaiset Deityt yhteyksineen tietokannasta.
     * @param rulesetname 
     */
    public void removeDeities(String rulesetname) {
        if (!em.getDeitiesByRuleSet(rulesetname).isEmpty()) {
            for (Deity d : em.getDeitiesByRuleSet(rulesetname)) {
                deityr.removeCompletely("" + d.getId());
            }
        }
    }

    /**
     * Poistaa RuleSetistä riippuvaiset DDomainit yhteyksineen tietokannasta.
     * @param rulesetname 
     */
    public void removeDomains(String rulesetname) {
        if (!em.getDomainsByRuleSet(rulesetname).isEmpty()) {
            for (DDomain d : em.getDomainsByRuleSet(rulesetname)) {
                domainr.removeCompletely("" + d.getId());
            }
        }
    }
}
