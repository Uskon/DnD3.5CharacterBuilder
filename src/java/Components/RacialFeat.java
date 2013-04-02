/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import java.io.Serializable;
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
public class RacialFeat implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn
    @ManyToOne
    private Race race;
    @JoinColumn
    @ManyToOne
    private Feat feat;

    public RacialFeat() {
    }
    
    public RacialFeat(Race r, Feat f) {
        this.race = r;
        this.feat = f;
    }

    public long getId() {
        return id;
    }

    public Race getRace() {
        return race;
    }

    public Feat getFeat() {
        return feat;
    }
    
}
