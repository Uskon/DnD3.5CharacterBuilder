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
    private String raceName;
    @Column
    private String attributeBonuses;
    @Column
    private String raceDescription;
    @JoinColumn
    @ManyToOne
    private RuleSet ruleSet;

    public Race() {
    }

    public Race(String rname, String abonus, String rdescription, RuleSet rset) {
        this.raceName = rname;
        this.attributeBonuses = abonus;
        this.raceDescription = rdescription;
        this.ruleSet = rset;
    }

    public long getId() {
        return id;
    }

    public String getRaceName() {
        return raceName;
    }

    public String getAttributeBonuses() {
        return attributeBonuses;
    }

    public String getRaceDescription() {
        return raceDescription;
    }
    
    public RuleSet getRuleSet() {
        return ruleSet;
    }
}
