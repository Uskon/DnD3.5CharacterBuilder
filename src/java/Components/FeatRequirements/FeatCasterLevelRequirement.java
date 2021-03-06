/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Components.FeatRequirements;

import Components.CClass;
import Components.Feat;
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
public class FeatCasterLevelRequirement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn
    @ManyToOne
    private Feat feat;
    @JoinColumn
    @ManyToOne
    private CClass cclass;
    @Column
    private int casterLvl;

    public FeatCasterLevelRequirement() {
    }

    public FeatCasterLevelRequirement(Feat feat, CClass c, int casterLvl) {
        this.feat = feat;
        this.cclass = c;
        this.casterLvl = casterLvl;
    }

    public Feat getFeat() {
        return feat;
    }

    public void setFeat(Feat feat) {
        this.feat = feat;
    }

    public CClass getCclass() {
        return cclass;
    }

    public void setC(CClass c) {
        this.cclass = c;
    }

    public int getCasterLvl() {
        return casterLvl;
    }

    public void setCasterLvl(int casterLvl) {
        this.casterLvl = casterLvl;
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
        if (!(object instanceof FeatCasterLevelRequirement)) {
            return false;
        }
        FeatCasterLevelRequirement other = (FeatCasterLevelRequirement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Components.FeatRequirements.FeatCasterLevelRequirement[ id=" + id + " ]";
    }
    
}
