/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Components.descriptions;

import Components.Race;
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
public class RaceDescription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn
    @OneToOne
    private Race race;
    @Column
    private String description;
    
    public RaceDescription(){}
    
    public RaceDescription(Race race, String desc) {
        this.race = race;
        this.description = desc;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
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
