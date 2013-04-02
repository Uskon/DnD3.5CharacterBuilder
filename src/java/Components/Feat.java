/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Uskon
 */
@Entity
public class Feat implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private boolean levelRequired;
    @Column
    private boolean raceRequired;
    @Column
    private boolean classRequired;
    @Column
    private boolean attributeRequired;
    @Column
    private boolean alignmentRequired;
    @Column
    private boolean deityRequired;
    @Column
    private boolean skillRequired;
    @Column
    private boolean saveRequired;
    @Column
    private boolean BABRequired;
    @Column
    private boolean casterLevelRequired;
    @Column
    private boolean spellLevelRequired;
    @Column
    private boolean featRequired;
    @JoinColumn
    @ManyToOne
    private RuleSet ruleSet;

    public Feat() {
    }

    public Feat(String name, boolean levelRequired, boolean raceRequired, boolean classRequired, boolean attributeRequired, boolean alignmentRequired, boolean deityRequired, boolean skillRequired, boolean saveRequired, boolean BABRequired, boolean casterLevelRequired, boolean spellLevelRequired, boolean featRequired, RuleSet ruleSet) {
        this.name = name;
        this.levelRequired = levelRequired;
        this.raceRequired = raceRequired;
        this.classRequired = classRequired;
        this.attributeRequired = attributeRequired;
        this.alignmentRequired = alignmentRequired;
        this.deityRequired = deityRequired;
        this.skillRequired = skillRequired;
        this.saveRequired = saveRequired;
        this.BABRequired = BABRequired;
        this.casterLevelRequired = casterLevelRequired;
        this.spellLevelRequired = spellLevelRequired;
        this.featRequired = featRequired;
        this.ruleSet = ruleSet;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLevelRequired() {
        return levelRequired;
    }

    public void setLevelRequired(boolean levelRequired) {
        this.levelRequired = levelRequired;
    }

    public boolean isRaceRequired() {
        return raceRequired;
    }

    public void setRaceRequired(boolean raceRequired) {
        this.raceRequired = raceRequired;
    }

    public boolean isClassRequired() {
        return classRequired;
    }

    public void setClassRequired(boolean classRequired) {
        this.classRequired = classRequired;
    }

    public boolean isAttributeRequired() {
        return attributeRequired;
    }

    public void setAttributeRequired(boolean attributeRequired) {
        this.attributeRequired = attributeRequired;
    }

    public boolean isAlignmentRequired() {
        return alignmentRequired;
    }

    public void setAlignmentRequired(boolean alignmentRequired) {
        this.alignmentRequired = alignmentRequired;
    }

    public boolean isDeityRequired() {
        return deityRequired;
    }

    public void setDeityRequired(boolean deityRequired) {
        this.deityRequired = deityRequired;
    }

    public boolean isSkillRequired() {
        return skillRequired;
    }

    public void setSkillRequired(boolean skillRequired) {
        this.skillRequired = skillRequired;
    }

    public boolean isSaveRequired() {
        return saveRequired;
    }

    public void setSaveRequired(boolean saveRequired) {
        this.saveRequired = saveRequired;
    }
    
    public boolean isBABRequired() {
        return BABRequired;
    }

    public void setBABRequired(boolean BABRequired) {
        this.BABRequired = BABRequired;
    }

    public boolean isCasterLevelRequired() {
        return casterLevelRequired;
    }

    public void setCasterLevelRequired(boolean casterLevelRequired) {
        this.casterLevelRequired = casterLevelRequired;
    }

    public boolean isFeatRequired() {
        return featRequired;
    }

    public void setFeatRequired(boolean featRequired) {
        this.featRequired = featRequired;
    }

    public RuleSet getRuleSet() {
        return ruleSet;
    }

    public void setRuleSet(RuleSet ruleSet) {
        this.ruleSet = ruleSet;
    }

    public boolean isSpellLevelRequired() {
        return spellLevelRequired;
    }

    public void setSpellLevelRequired(boolean spellLevelRequired) {
        this.spellLevelRequired = spellLevelRequired;
    }
    
    
}
