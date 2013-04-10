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
public class ClassProgress implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn
    @ManyToOne
    private CClass cclass;
    @Column
    private int BAB;
    @Column
    private int casterLevel;
    @Column
    private int spellLevel;
    @Column
    private int hitDice;
    @Column
    private int fortSave;
    @Column
    private int willSave;
    @Column
    private int reflSave;
    @Column
    private int skillPoints;
    @Column
    private int lvl;

    public ClassProgress(CClass c, int BAB, int casterLevel, int hitDice, int fortSave, int willSave, int reflSave, int skillPoints, int level) {
        this.cclass = c;
        this.BAB = BAB;
        this.casterLevel = casterLevel;
        this.hitDice = hitDice;
        this.fortSave = fortSave;
        this.willSave = willSave;
        this.reflSave = reflSave;
        this.skillPoints = skillPoints;
        this.lvl = level;
    }

    public ClassProgress() {
    }

    public long getId() {
        return id;
    }

    public CClass getC() {
        return cclass;
    }

    public void setC(CClass c) {
        this.cclass = c;
    }

    public int getBAB() {
        return BAB;
    }

    public void setBAB(int BAB) {
        this.BAB = BAB;
    }

    public int getCasterLevel() {
        return casterLevel;
    }

    public void setCasterLevel(int casterLevel) {
        this.casterLevel = casterLevel;
    }

    public int getHitDice() {
        return hitDice;
    }

    public void setHitDice(int hitDice) {
        this.hitDice = hitDice;
    }

    public int getFortSave() {
        return fortSave;
    }

    public void setFortSave(int fortSave) {
        this.fortSave = fortSave;
    }

    public int getWillSave() {
        return willSave;
    }

    public void setWillSave(int willSave) {
        this.willSave = willSave;
    }

    public int getReflSave() {
        return reflSave;
    }

    public void setReflSave(int reflSave) {
        this.reflSave = reflSave;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public int getLevel() {
        return lvl;
    }

    public void setLevel(int level) {
        this.lvl = level;
    }

    public int getSpellLevel() {
        return spellLevel;
    }

    public void setSpellLevel(int spellLevel) {
        this.spellLevel = spellLevel;
    }
}
