/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Components.FeatRequirements;

import Components.Feat;
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
public class FeatBABRequirement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn
    @OneToOne
    private Feat feat;
    @Column
    private int BAB;

    public FeatBABRequirement() {
    }

    public FeatBABRequirement(Feat feat, int BAB) {
        this.feat = feat;
        this.BAB = BAB;
    }

    public Feat getFeat() {
        return feat;
    }

    public void setFeat(Feat feat) {
        this.feat = feat;
    }

    public int getBAB() {
        return BAB;
    }

    public void setBAB(int BAB) {
        this.BAB = BAB;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FeatBABRequirement)) {
            return false;
        }
        FeatBABRequirement other = (FeatBABRequirement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Components.FeatRequirements.FeatBABRequirement[ id=" + id + " ]";
    }
    
}
