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
public class FeatSpellRequirement implements Serializable {
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
    private int spellLvl;

    public FeatSpellRequirement() {
    }

    public FeatSpellRequirement(Feat feat, CClass c, int spellLvl) {
        this.feat = feat;
        this.cclass = c;
        this.spellLvl = spellLvl;
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

    public int getSpellLvl() {
        return spellLvl;
    }

    public void setSpellLvl(int spellLvl) {
        this.spellLvl = spellLvl;
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
        if (!(object instanceof FeatSpellRequirement)) {
            return false;
        }
        FeatSpellRequirement other = (FeatSpellRequirement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Components.FeatRequirements.FeatSpellRequirement[ id=" + id + " ]";
    }
    
}
