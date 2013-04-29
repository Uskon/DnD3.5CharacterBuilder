/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Components.descriptions;

import Components.Skill;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Uskon
 */
@Entity
public class SkillDescription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn
    @OneToOne
    private Skill skill;
    @Column
    private String description;

    public SkillDescription(Skill skill, String description) {
        this.skill = skill;
        this.description = description;
    }

    public SkillDescription() {
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
