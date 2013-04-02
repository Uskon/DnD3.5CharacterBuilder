/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Character;

import ComponentLists.SkillList;
import Components.Alignment;
import Components.Deity;
import Components.Feat;
import Components.Race;
import Components.Skill;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Uskon
 */
public class Character {

    private String name;
    private Race race;
    private int ECL;
    private int STR;
    private int DEX;
    private int CON;
    private int INT;
    private int WIS;
    private int CHA;
    private HashMap<Class, Integer> classes = new HashMap<Class, Integer>();
    private Alignment alignment;
    private Deity deity;
    private HashMap<Skill, Integer> skills = new HashMap<Skill, Integer>();
    private ArrayList<Feat> feats = new ArrayList<Feat>();
    private SkillList templist = new SkillList();
    private int fort;
    private int will;
    private int refl;
    private int BAB;
    private HashMap<Class, Integer> casterLevels = new HashMap<Class, Integer>();

    public HashMap<Class, Integer> getCasterLevels() {
        return casterLevels;
    }

    public void setCasterLevels(HashMap<Class, Integer> casterLevels) {
        this.casterLevels = casterLevels;
    }

    public int getFort() {
        return fort;
    }

    public void setFort(int fort) {
        this.fort = fort;
    }

    public int getWill() {
        return will;
    }

    public void setWill(int will) {
        this.will = will;
    }

    public int getRefl() {
        return refl;
    }

    public void setRefl(int refl) {
        this.refl = refl;
    }

    public int getBAB() {
        return BAB;
    }

    public void setBAB(int BAB) {
        this.BAB = BAB;
    }
    
    public Character(String name) {
        this.name = name;
        for (Skill s : templist.getSkills()) {
            skills.put(s, 0);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Race getRace() {
        return race;
    }

    public int getECL() {
        return ECL;
    }

    public void setECL(int ECL) {
        this.ECL = ECL;
    }

    public int getSTR() {
        return STR;
    }

    public void setSTR(int STR) {
        this.STR = STR;
    }

    public int getDEX() {
        return DEX;
    }

    public void setDEX(int DEX) {
        this.DEX = DEX;
    }

    public int getCON() {
        return CON;
    }

    public void setCON(int CON) {
        this.CON = CON;
    }

    public int getINT() {
        return INT;
    }

    public void setINT(int INT) {
        this.INT = INT;
    }

    public int getWIS() {
        return WIS;
    }

    public void setWIS(int WIS) {
        this.WIS = WIS;
    }

    public int getCHA() {
        return CHA;
    }

    public void setCHA(int CHA) {
        this.CHA = CHA;
    }

    
    
    public void setRace(Race race) {
        this.race = race;
    }

    public void levelUpClass(Class c) {
        if (classes.containsKey(c)) {
            int currentClassLevel = classes.get(c);
            classes.put(c, currentClassLevel + 1);
            return;
        }
        if (!classes.containsKey(c)) {
            classes.put(c, 1);
        }
        this.ECL++;
    }

    public HashMap<Class, Integer> getClasses() {
        return classes;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public Deity getDeity() {
        return deity;
    }

    public void setDeity(Deity deity) {
        this.deity = deity;
    }
    
    public void increaseSkill(Skill s) {
        int currentSkillPoints = skills.get(s);
        skills.put(s, currentSkillPoints+1);
    }
    
    public HashMap<Skill, Integer> getSkills() {
        return skills;
    }

    public void giveFeat(Feat f) {
        if (!feats.contains(f)) {
            feats.add(f);
        }
    }
    
    public ArrayList<Feat> getFeats() {
        return feats;
    }
}
