/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Uskon
 */
@Entity
public class Race implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private int strbonus;
    @Column
    private int dexbonus;
    @Column
    private int conbonus;
    @Column
    private int intbonus;
    @Column
    private int wisbonus;
    @Column
    private int chabonus;
    @JoinColumn
    @ManyToOne
    private RuleSet ruleSet;

    public Race() {
    }

    public Race(String rname, int strbonus, int dexbonus, int conbonus, int intbonus, int wisbonus, int chabonus, RuleSet rset) {
        this.name = rname;
        this.strbonus = strbonus;
        this.dexbonus = dexbonus;
        this.conbonus = conbonus;
        this.intbonus = intbonus;
        this.wisbonus = wisbonus;
        this.chabonus = chabonus;
        this.ruleSet = rset;
    }

    public long getId() {
        return id;
    }

    public String getRaceName() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrbonus() {
        return strbonus;
    }

    public void setStrbonus(int strbonus) {
        this.strbonus = strbonus;
    }

    public int getDexbonus() {
        return dexbonus;
    }

    public void setDexbonus(int dexbonus) {
        this.dexbonus = dexbonus;
    }

    public int getConbonus() {
        return conbonus;
    }

    public void setConbonus(int conbonus) {
        this.conbonus = conbonus;
    }

    public int getIntbonus() {
        return intbonus;
    }

    public void setIntbonus(int intbonus) {
        this.intbonus = intbonus;
    }

    public int getWisbonus() {
        return wisbonus;
    }

    public void setWisbonus(int wisbonus) {
        this.wisbonus = wisbonus;
    }

    public int getChabonus() {
        return chabonus;
    }

    public void setChabonus(int chabonus) {
        this.chabonus = chabonus;
    }


    public RuleSet getRuleSet() {
        return ruleSet;
    }
}
