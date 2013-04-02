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
public class CClass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private boolean classRequired = false;
    @Column
    private boolean raceRequired = false;
    @Column
    private boolean featRequired = false;
    @Column
    private boolean skillRequired = false;
    @Column
    private boolean attributeRequired = false;
    @Column
    private boolean saveRequired = false;
    @Column
    private boolean casterLevelRequired = false;
    @Column
    private boolean spellLevelRequired = false;
    @Column
    private boolean alignmentRequired = false;
    @Column
    private boolean deityRequired = false;
    @Column
    private boolean BABRequired = false;
    @Column
    private boolean levelRequired = false;
    @JoinColumn
    @ManyToOne
    private RuleSet ruleSet;

    public CClass(String name, RuleSet ruleSet) {
        this.name = name;
        this.ruleSet = ruleSet;
    }

    public CClass(String name, boolean classRequired, boolean raceRequired, boolean featRequired, boolean skillRequired, boolean attributeRequired, boolean saveRequired, boolean casterLevelRequired, boolean spellLevelRequired, boolean alignmentRequired, boolean deityRequired, boolean BABRequired, boolean levelRequired, RuleSet ruleSet) {
        this.name = name;
        this.classRequired = classRequired;
        this.raceRequired = raceRequired;
        this.featRequired = featRequired;
        this.skillRequired = skillRequired;
        this.attributeRequired = attributeRequired;
        this.saveRequired = saveRequired;
        this.casterLevelRequired = casterLevelRequired;
        this.spellLevelRequired = spellLevelRequired;
        this.alignmentRequired = alignmentRequired;
        this.deityRequired = deityRequired;
        this.BABRequired = BABRequired;
        this.levelRequired = levelRequired;
        this.ruleSet = ruleSet;
    }

    
    public boolean isClassRequired() {
        return classRequired;
    }

    public void setClassRequired(boolean classRequired) {
        this.classRequired = classRequired;
    }

    public boolean isRaceRequired() {
        return raceRequired;
    }

    public void setRaceRequired(boolean raceRequired) {
        this.raceRequired = raceRequired;
    }

    public boolean isFeatRequired() {
        return featRequired;
    }

    public void setFeatRequired(boolean featRequired) {
        this.featRequired = featRequired;
    }

    public boolean isSkillRequired() {
        return skillRequired;
    }

    public void setSkillRequired(boolean skillRequired) {
        this.skillRequired = skillRequired;
    }

    public boolean isAttributeRequired() {
        return attributeRequired;
    }

    public void setAttributeRequired(boolean attributeRequired) {
        this.attributeRequired = attributeRequired;
    }

    public boolean isSaveRequired() {
        return saveRequired;
    }

    public void setSaveRequired(boolean saveRequired) {
        this.saveRequired = saveRequired;
    }

    public boolean isCasterLevelRequired() {
        return casterLevelRequired;
    }

    public void setCasterLevelRequired(boolean casterLevelRequired) {
        this.casterLevelRequired = casterLevelRequired;
    }

    public boolean isSpellLevelRequired() {
        return spellLevelRequired;
    }

    public void setSpellLevelRequired(boolean spellLevelRequired) {
        this.spellLevelRequired = spellLevelRequired;
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

    public boolean isBABRequired() {
        return BABRequired;
    }

    public void setBABRequired(boolean BABRequired) {
        this.BABRequired = BABRequired;
    }

    public boolean isLevelRequired() {
        return levelRequired;
    }

    public void setLevelRequired(boolean levelRequired) {
        this.levelRequired = levelRequired;
    }

    public CClass() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public RuleSet getRuleSet() {
        return ruleSet;
    }
}
