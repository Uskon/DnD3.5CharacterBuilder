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
public class DomainFeat implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn
    @ManyToOne
    private Deity deity;
    @JoinColumn
    @ManyToOne
    private Feat feat;

    public DomainFeat() {
    }

    public DomainFeat(Deity deity, Feat feat) {
        this.deity = deity;
        this.feat = feat;
    }

    public long getId() {
        return id;
    }

    public Deity getDeity() {
        return deity;
    }

    public Feat getFeat() {
        return feat;
    }
    
    
}
