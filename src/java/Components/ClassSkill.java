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
public class ClassSkill implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn
    @ManyToOne
    private CClass cclass;
    @JoinColumn
    @ManyToOne
    private Skill skill;
    @Column
    private int type;

    public ClassSkill() {
    }

    public ClassSkill(CClass cclass, Skill skill, int type) {
        this.cclass = cclass;
        this.skill = skill;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public CClass getCclass() {
        return cclass;
    }

    public Skill getSkill() {
        return skill;
    }

    public int getType() {
        return type;
    }
    
    
}
