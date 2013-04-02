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
public class FeatLevelRequirement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn
    @OneToOne
    private Feat feat;
    @Column
    private int requiredLvl;

    public FeatLevelRequirement() {
    }

    public FeatLevelRequirement(Feat feat, int requiredLvl) {
        this.feat = feat;
        this.requiredLvl = requiredLvl;
    }

    public Feat getFeat() {
        return feat;
    }

    public void setFeat(Feat feat) {
        this.feat = feat;
    }

    public int getRequiredLvl() {
        return requiredLvl;
    }

    public void setRequiredLvl(int requiredLvl) {
        this.requiredLvl = requiredLvl;
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
        if (!(object instanceof FeatLevelRequirement)) {
            return false;
        }
        FeatLevelRequirement other = (FeatLevelRequirement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Components.FeatRequirements.FeatLevelRequirement[ id=" + id + " ]";
    }
    
}
