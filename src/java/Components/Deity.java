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
public class Deity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private Alignment alignment;
    @JoinColumn
    @ManyToOne
    private RuleSet ruleSet;

    public Deity() {
    }

    public Deity(String name, Alignment alignment, RuleSet rset) {
        this.name = name;
        this.alignment = alignment;
        this.ruleSet = rset;
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

    public void setRuleSet(RuleSet ruleSet) {
        this.ruleSet = ruleSet;
    }

    public Alignment getAlignment() {
        return alignment;
    }
}
