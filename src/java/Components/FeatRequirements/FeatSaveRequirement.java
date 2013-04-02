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
import javax.persistence.ManyToOne;

/**
 *
 * @author Uskon
 */
@Entity
public class FeatSaveRequirement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn
    @ManyToOne
    private Feat feat;
    @Column
    private int fortSave;
    @Column
    private int willSave;
    @Column
    private int reflSave;

    public FeatSaveRequirement() {
    }

    public FeatSaveRequirement(Feat feat, int fortSave, int willSave, int reflSave) {
        this.feat = feat;
        this.fortSave = fortSave;
        this.willSave = willSave;
        this.reflSave = reflSave;
    }

    public Feat getFeat() {
        return feat;
    }

    public void setFeat(Feat feat) {
        this.feat = feat;
    }

    public int getFortSave() {
        return fortSave;
    }

    public void setFortSave(int fortSave) {
        this.fortSave = fortSave;
    }

    public int getWillSave() {
        return willSave;
    }

    public void setWillSave(int willSave) {
        this.willSave = willSave;
    }

    public int getReflSave() {
        return reflSave;
    }

    public void setReflSave(int reflSave) {
        this.reflSave = reflSave;
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
        if (!(object instanceof FeatSaveRequirement)) {
            return false;
        }
        FeatSaveRequirement other = (FeatSaveRequirement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Components.FeatRequirements.FeatSaveRequirement[ id=" + id + " ]";
    }
    
}
