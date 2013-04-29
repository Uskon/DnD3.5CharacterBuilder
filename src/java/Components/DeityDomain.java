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
public class DeityDomain implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn
    @ManyToOne
    private Deity deity;
    @JoinColumn
    @ManyToOne
    private DDomain domain;

    public DeityDomain() {
    }

    public DeityDomain(Deity deity, DDomain domain) {
        this.deity = deity;
        this.domain = domain;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Deity getDeity() {
        return deity;
    }

    public void setDeity(Deity deity) {
        this.deity = deity;
    }

    public DDomain getDomain() {
        return domain;
    }

    public void setDomain(DDomain domain) {
        this.domain = domain;
    }
    
    
}
